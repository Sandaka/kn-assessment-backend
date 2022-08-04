package com.kuehnenagel.service;

import com.kuehnenagel.entity.People;
import org.springframework.data.domain.Page;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 7/30/22
 */
public interface PeopleService {

    /**
     *
     * @param name
     * @param page
     * @param size
     * @return
     */
    Page<People> getContacts(String name, int page, int size);
}
