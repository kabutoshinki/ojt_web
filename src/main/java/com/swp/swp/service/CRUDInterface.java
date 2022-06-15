package com.swp.swp.service;

public interface CRUDInterface<T> {
    boolean updateStatus(int id, String status);
    Iterable<T> getAll();
    T getById(int id);
    boolean isExist(String value);
}
