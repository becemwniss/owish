package com.owishserver.service;

import com.owishserver.entities.Wish;

import java.util.List;

/**
 * Created by pc-becem on 6/25/2017.
 */
public interface WishService {
    void save(Wish wish);

    List<Wish> findAll();
}
