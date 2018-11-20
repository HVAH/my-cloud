package com.mall.order.service;


import com.mall.order.domain.Storage;

import java.util.Optional;

/**
 * Created by Ken on 7/15/2018.
 */
public interface StorageService {

    Optional<Storage> addStorage(Storage storage);

    Boolean deleteStorage(String id);

    Optional<Storage> fetchOneStorage(String id);

    Boolean queryOneStorage(String id);
}
