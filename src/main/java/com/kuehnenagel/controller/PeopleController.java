package com.kuehnenagel.controller;

import com.kuehnenagel.entity.People;
import com.kuehnenagel.service.PeopleService;
import com.kuehnenagel.utility.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @param name
     * @param page
     * @param size
     * @return
     */
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

    /**
     * @param people
     * @return
     */
    @PostMapping("/people")
    public ResponseEntity<People> addNewContact(@RequestBody People people) {
        People people1 = peopleService.saveContact(people);
        return ResponseEntity.ok().body(people1);
    }

    /**
     * @param people
     * @param id
     * @return
     */
    @PutMapping("/people/{id}")
    public ResponseEntity<People> updateContact(@RequestBody People people, @PathVariable("id") long id) {
        People people_new = peopleService.updateContact(people, id);
        return ResponseEntity.ok().body(people_new);
    }

//    @GetMapping("/people")
//    public ResponseEntity<List<People>> getContactList(@RequestParam Optional<String> name, @RequestParam Optional<Integer> page, Optional<Integer> size) {
//
//        log.info("Request to get contact list");
//
//        List<People> list = peopleService.getContacts(name, page, size);
//    }


}
