package com.owishserver.models;

import com.owishserver.entities.Wish;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by pc-becem on 6/25/2017.
 */
public class WishModel {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Wish toWish(){
        Wish wish = new Wish();
        wish.setContent(content);
        wish.setCreationDate(new Date());
        return wish;
    }
}
