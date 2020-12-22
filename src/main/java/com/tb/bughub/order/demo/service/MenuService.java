package com.tb.bughub.order.demo.service;

import com.tb.bughub.order.demo.domain.Menu;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class MenuService {

    public Menu getItemsById(String id){
        Menu menu = new Menu();
        menu.setName(UUID.randomUUID().toString());
        menu.setId(UUID.randomUUID().toString());
        menu.setPrice(23);
        return menu;
        // If I need to call the rest client
        //  String uri = "http://localhost:8080/menuItems";
        //  RestTemplate restTemplate = new RestTemplate();
        //  Menu result = restTemplate.getForObject(uri, Menu.class);
    }


}
