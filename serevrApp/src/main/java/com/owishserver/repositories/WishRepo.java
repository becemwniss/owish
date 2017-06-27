package com.owishserver.repositories;

import com.owishserver.entities.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pc-becem on 6/25/2017.
 */
public interface WishRepo extends JpaRepository<Wish, Long>{
}
