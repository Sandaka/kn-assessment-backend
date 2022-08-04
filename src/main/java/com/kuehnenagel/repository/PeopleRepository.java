package com.kuehnenagel.repository;

import com.kuehnenagel.entity.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 7/30/22
 */
@Repository
public interface PeopleRepository extends PagingAndSortingRepository<People, Long> {

    /**
     *
     * @param name
     * @param pageable
     * @return
     */
    Page<People> findByNameContaining(String name, Pageable pageable);
}
