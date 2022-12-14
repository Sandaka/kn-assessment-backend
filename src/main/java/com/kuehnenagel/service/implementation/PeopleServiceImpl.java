package com.kuehnenagel.service.implementation;

import com.kuehnenagel.entity.People;
import com.kuehnenagel.repository.PeopleRepository;
import com.kuehnenagel.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.springframework.data.domain.PageRequest.of;


/**
 * Created by Sandaka Wijesinghe.
 * Date: 7/30/22
 */
@Service
@Transactional
@Slf4j
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    /**
     * @param name
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<People> getContacts(String name, int page, int size) {
        log.info("Getting contacts for page {} of size {}", page, size);

        return peopleRepository.findByNameContaining(name, of(page, size));
    }

    /**
     * @param people
     * @return
     */
    @Override
    public People saveContact(People people) {
        log.info("Saving new contact : name {}", people.getName());
        return peopleRepository.save(people);
    }

    /**
     * @param people
     * @param id
     * @return
     */
    @Override
    public People updateContact(People people, long id) {
        log.info("Updating contact : id {}", id);
        people.setId(id);
        return peopleRepository.save(people);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<People> getContactById(long id) {
        return peopleRepository.findById(id);
    }
}
