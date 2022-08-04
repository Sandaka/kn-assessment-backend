package com.kuehnenagel.controller;

import com.kuehnenagel.entity.People;
import com.kuehnenagel.service.PeopleService;
import com.kuehnenagel.utility.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


/**
 * Created by Sandaka Wijesinghe.
 * Date: 7/30/22
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/people")
    public ResponseEntity<HttpResponse> getContactList(@RequestParam Optional<String> name, @RequestParam Optional<Integer> page, Optional<Integer> size) {

        log.info("Request to get contact list");
        Map<String, Page<People>> map = new HashMap<>();
        map.put("page", peopleService.getContacts(name.orElse(""), page.orElse(0), size.orElse(10)));

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully Retrieved")
                        .timeStamp(LocalDateTime.now().toString())
                        .data(map)
                        .build()
        );
    }

//    @GetMapping("/people")
//    public ResponseEntity<List<People>> getContactList(@RequestParam Optional<String> name, @RequestParam Optional<Integer> page, Optional<Integer> size) {
//
//        log.info("Request to get contact list");
//
//        List<People> list = peopleService.getContacts(name, page, size);
//    }


}
