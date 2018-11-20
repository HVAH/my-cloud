package com.mall.order.controller;

import com.mall.order.domain.RespInternalCallResult;
import com.mall.order.domain.Storage;
import com.mall.order.service.StorageService;
import com.mall.order.util.SymmetricCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by Ken on 7/15/2018.
 */
@RestController
@RequestMapping("/storages/internal")
public class StorageInternalController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private StorageService storageService;

    @Autowired
    public StorageInternalController(@Qualifier("GridFS") StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/{storage_id}")
    public ResponseEntity validateStorage(@PathVariable(value = "storage_id") String storageId) {
        String decodedId = SymmetricCodec.decode(storageId);
        if (decodedId != null && storageService.queryOneStorage(decodedId)) {
//            return ResponseEntity.noContent().build();
            return ResponseEntity.ok(new RespInternalCallResult().setLogicResult(true));
        }
//        return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new RespInternalCallResult().setLogicResult(false));
    }

    @GetMapping("/{storage_id}/hash")
    public ResponseEntity queryStorageHash(@PathVariable(value = "storage_id") String storageId) {
        String decodedId = SymmetricCodec.decode(storageId);
        if (decodedId != null) {
            Optional<Storage> storageOptional = storageService.fetchOneStorage(decodedId);
            if (storageOptional.isPresent()) {
                return ResponseEntity.ok(new RespInternalCallResult().setLogicResult(true).setContentResult("MD5:" + storageOptional.get().getMd5()));
            }
        }
//        return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new RespInternalCallResult().setLogicResult(false));
    }

    @DeleteMapping("/{storage_id}")
    public ResponseEntity deleteStorage(@PathVariable(value = "storage_id") String storageId) {
        String decodedId = SymmetricCodec.decode(storageId);
        if (decodedId != null && storageService.deleteStorage(decodedId)) {
//            return ResponseEntity.noContent().build();
            return ResponseEntity.ok(new RespInternalCallResult().setLogicResult(true));
        }
//        return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new RespInternalCallResult().setLogicResult(false));
    }
}
