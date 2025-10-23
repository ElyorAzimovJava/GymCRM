package com.gym.crm.dao;

import com.gym.crm.model.User;

import java.util.List;

public interface GenericDao<I,T>{
    T save(T entity);
    T update(T entity);
    void delete(I id);
    T findById(I id);
    List<T> findAll();
}
