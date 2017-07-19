package com.owishserver.RestApi;

import com.owishserver.entities.Wish;
import com.owishserver.models.WishModel;
import com.owishserver.service.WishService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

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
            TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

            SearchResponse response = client.prepareSearch("wish-index")
                    .setTypes("data").addSort("creation_date", SortOrder.DESC).execute().actionGet();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
