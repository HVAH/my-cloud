package com.mall.order.controller;

import com.mall.order.common.ReturnCode;
import com.mall.order.domain.RespMessage;
import com.mall.order.domain.RespStorageId;
import com.mall.order.domain.Storage;
import com.mall.order.service.StorageService;
import com.mall.order.util.SymmetricCodec;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

/**
 * Created by Ken on 7/15/2018.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/storages")
@Api(description = "文件服务")
public class StorageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private StorageService storageService;

    @Autowired
    public StorageController(@Qualifier("GridFS") StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping
    public ResponseEntity upload(@RequestParam("file") MultipartFile multipartFile) {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            try {
                Storage storage = new Storage()
                        .setName(multipartFile.getOriginalFilename())
                        .setType(multipartFile.getContentType())
                        .setInputStream(multipartFile.getInputStream());
                return storageService
                        .addStorage(storage)
                        .<ResponseEntity>map(savedStorage -> ResponseEntity.ok(new RespStorageId()
                                .setStorageId(SymmetricCodec.encode(savedStorage.getId()))))
                        .orElseGet(() -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
            } catch (IOException e) {
                logger.error("UPLOAD FAILED");
                logger.error(e.getMessage(), e);
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{storage_id}")
    public ResponseEntity download(@PathVariable(value = "storage_id", required = true) String storageId) {
        String decodedId = SymmetricCodec.decode(storageId);
        if (decodedId != null) {
            Optional<Storage> storageOptional = storageService.fetchOneStorage(decodedId);
            if (storageOptional.isPresent()) {
                Storage storage = storageOptional.get();
                String contentType = storage.getType();
                if (contentType == null) {
                    contentType = "application/octet-stream";
                }
                String fileName;
                try {
                    fileName = URLEncoder.encode(storage.getName(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    fileName = storage.getName();
                }
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                        .body(new InputStreamResource(storage.getInputStream()));
            }
        }
        RespMessage respMessage = new RespMessage()
                .setCode(ReturnCode.RESOURCE_NOT_EXIST)
                .setMessage("file is not exist");
        return ResponseEntity.unprocessableEntity().body(respMessage);
    }
}
