package com.mall.order.service.impl;

import com.mall.order.domain.Storage;
import com.mall.order.service.StorageService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

/**
 * Created by Ken on 7/15/2018.
 */
@Primary
@Service("GridFS")
public class GridFSStorageServiceImpl implements StorageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private GridFsTemplate gridFsTemplate;

    @Autowired
    public GridFSStorageServiceImpl(GridFsTemplate gridFsTemplate) {
        this.gridFsTemplate = gridFsTemplate;
    }

    @Override
    @Transactional
    public Optional<Storage> addStorage(Storage storage) {
        InputStream content = storage.getInputStream();
        if (content == null) {
            return Optional.empty();
        }

        ObjectId objectId = ObjectId.get();
        DBObject metadata = new BasicDBObject("filename", storage.getName());
        gridFsTemplate.store(content, objectId.toString(), storage.getType(), metadata);
        storage.setId(objectId.toString()).setCreatedAt(Date.from(Instant.now()));
        return Optional.of(storage);
    }

    @Override
    @Transactional
    public Boolean deleteStorage(String id) {
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("filename").is(id)));
        if (gridFSFile == null) {
            return false;
        }
        gridFsTemplate.delete(Query.query(Criteria.where("filename").is(id)));
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Storage> fetchOneStorage(String id) {
        GridFsResource gridFsResource = gridFsTemplate.getResource(id);
        if (gridFsResource == null) {
            return Optional.empty();
        }
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("filename").is(id)));
        if (gridFSFile == null) {
            return Optional.empty();
        }
        try {
            Storage storage = new Storage()
                    .setId(id)
                    .setName(gridFSFile.getMetadata().getString("filename"))
                    .setType(gridFsResource.getContentType())
                    .setLength(BigInteger.valueOf(gridFsResource.contentLength()))
                    .setMd5(gridFSFile.getMD5())
                    .setInputStream(gridFsResource.getInputStream())
                    .setCreatedAt(new Date(gridFsResource.lastModified()));
            return Optional.of(storage);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean queryOneStorage(String id) {
        GridFsResource gridFsResource = gridFsTemplate.getResource(id);
        if (gridFsResource == null) {
            return false;
        }
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("filename").is(id)));
        if (gridFSFile == null) {
            return false;
        }
        return true;
    }
}
