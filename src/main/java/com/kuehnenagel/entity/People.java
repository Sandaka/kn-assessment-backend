package com.kuehnenagel.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


/**
 * Created by Sandaka Wijesinghe.
 * Date: 7/29/22
 */
@Entity
@Table(name = "people")
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Getter
@Setter
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "url", nullable = false)
    private String url;
}
