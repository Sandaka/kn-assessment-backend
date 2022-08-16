package com.kuehnenagel.service;

import com.kuehnenagel.entity.People;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 7/30/22
 */
public interface PeopleService {

    /**
     * @param name
     * @param page
     * @param size
     * @return
     */
    Page<People> getContacts(String name, int page, int size);

    /**
     * @param people
     * @return
     */
    People saveContact(People people);

    /**
     * @param people
     * @param id
     * @return
     */
    People updateContact(People people, long id);

    /**
     * @param id
     * @return
     */
    Optional<People> getContactById(long id);

}
