package com.kuehnenagel;

import com.kuehnenagel.entity.People;
import com.kuehnenagel.exception.ContactNotFoundException;
import com.kuehnenagel.repository.PeopleRepository;
import com.kuehnenagel.service.implementation.PeopleServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.*;
import static org.springframework.data.domain.PageRequest.of;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 8/2/22
 */
@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
public class PeopleServiceImplTest {

    @InjectMocks
    PeopleServiceImpl peopleService;

    @Mock
    PeopleRepository peopleRepository;

    private String name;
    private int page;
    private int size;
    private People peopleTest;

    @Before
    public void setUp() {
        name = "abc";
        page = 1;
        size = 1;

        peopleTest = new People(1L, "sandaka","https://google.com");
    }

    @Test
    public void getContactsTest() {
        List<People> contacts = new ArrayList<>();
        Pageable pageable= PageRequest.of(0,5);
        Page<People> result = new PageImpl<>(contacts,pageable,1);

        //Page<People> people = Mockito.mock(Page.class);
        Mockito.when(peopleRepository.findByNameContaining(name, pageable)).thenReturn(result);
    }

    @Test
    public void saveContactTest(){
        //peopleTest = new People(1L, "sandaka","https://google.com");
        Mockito.lenient().when(peopleRepository.save(peopleTest)).thenReturn(peopleTest);
        peopleTest = peopleRepository.save(peopleTest);
        Assert.assertEquals(peopleTest, peopleTest);
        verify(peopleRepository).save(peopleTest);
    }

    @Test
    public void updateContactTest(){
        peopleTest = new People(1L, "sandaka_updated","https://google.com");
        People peopleUpdated = peopleRepository.save(peopleTest);
        Mockito.lenient().when(peopleRepository.save(peopleTest)).thenReturn(peopleUpdated);
        Assert.assertNotEquals(peopleTest, peopleUpdated);
    }

//    @Test
//    public void updateContactTest_new(){
//        People people = new People(1L, "sandaka_updated","https://google.com");
//
//        when(peopleRepository.findById(peopleTest.getId())).thenReturn(Optional.of(peopleTest));
//        peopleService.updateContact(people, peopleTest.getId());
//
//        verify(peopleRepository).save(people);
//        verify(peopleRepository).findById(peopleTest.getId());
//    }

    @Test
    public void getContactByIdTest_ifIdFound(){
        People people = new People();
        people.setId(10L);

        when(peopleRepository.findById(people.getId())).thenReturn(Optional.of(people));

        Optional<People> expected = peopleService.getContactById(people.getId());

        Assert.assertEquals(expected.get().getId(), people.getId());
        verify(peopleRepository).findById(people.getId());
    }

}
