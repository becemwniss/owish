package com.owishserver.RestApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.owishserver.entities.Wish;
import com.owishserver.models.WishModel;
import com.owishserver.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

/**
 * Created by pc-becem on 6/25/2017.
 */
@RestController
public class WishController {
    @Autowired
    private WishService wishService;
    @RequestMapping(value = "/saveWish", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveWish(@RequestBody WishModel wishModel){
        try {
            Wish wish = wishModel.toWish();
            wishService.save(wish);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/findAllWishs", method = RequestMethod.GET)
    public ResponseEntity<?> findAllWishs(){
        try {
            RestTemplate restTemplate = new RestTemplate();
            Object o = restTemplate.getForObject("htt://localhost:9200/wish-index/data/_search?pretty -H 'Content-Type: application/json' -d'\n" +
                    "{\n" +
                    "    \"sort\" : [\n" +
                    "        { \"creation_date\" : {\"order\" : \"asc\"}}\n" +
                    "    ]\n" +
                    "}'", Object.class);
            return new ResponseEntity<>(o, HttpStatus.OK);
        } catch (RestClientException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
