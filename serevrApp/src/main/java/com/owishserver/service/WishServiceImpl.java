package com.owishserver.service;

import com.owishserver.entities.Wish;
import com.owishserver.repositories.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pc-becem on 6/25/2017.
 */
@Service
public class WishServiceImpl implements WishService {
    @Autowired
    private WishRepo wishRepo;
    @Override
    public void save(Wish wish) {
        wishRepo.save(wish);
    }

    @Override
    public List<Wish> findAll() {
        return wishRepo.findAll();
    }
}
