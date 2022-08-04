package com.kuehnenagel;

import com.kuehnenagel.entity.People;
import com.kuehnenagel.repository.PeopleRepository;
import com.kuehnenagel.service.implementation.PeopleServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.*;
import static org.springframework.data.domain.PageRequest.of;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 8/2/22
 */
@ExtendWith(MockitoExtension.class)
public class PeopleServiceImplTest {

    @InjectMocks
    PeopleServiceImpl peopleService;

    @Mock
    PeopleRepository peopleRepository;

    private String name;
    private int page;
    private int size;

    @Before
    public void setUp() {
        name = "abc";
        page = 1;
        size = 1;

        People peopleTest = new People(1L, "sandaka","https://google.com");
    }

    @Test
    public void getContactsTest() {
        List<People> contacts = new ArrayList<>();
        Pageable pageable= PageRequest.of(0,5);
        Page<People> result = new PageImpl<>(contacts,pageable,1);

        //Page<People> people = Mockito.mock(Page.class);
        Mockito.when(peopleRepository.findByNameContaining(name, pageable)).thenReturn(result);
    }
}
