package com.designfreed.sampleapp.services.generic;

import java.util.List;

public interface CRUDService<T> {
    List<T> findAll();

    T findById(Long id);

    T saveOrUpdate(T domainObject);

    void deleteById(Long id);
}

