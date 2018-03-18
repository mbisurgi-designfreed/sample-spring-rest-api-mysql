package com.designfreed.sampleapp.services.generic;

import java.util.List;

public interface CRUDService<T> {
    List<T> findAll();

    T findById(String id);

    T saveOrUpdate(T domainObject);

    void deleteById(String id);
}

