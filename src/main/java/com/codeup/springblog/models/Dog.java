package com.codeup.springblog.models;

import javax.persistence.*;
//
//  CREATE TABLE `dogs` (
//          `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
//          `age` tinyint(3) unsigned NOT NULL,
//          `name` varchar(200) NOT NULL,
//          `reside_state` char(2) DEFAULT 'XX',
//          PRIMARY KEY (`id`),
//          UNIQUE KEY `UK_?????????????????` (`age`)
//          ) ENGINE=MyISAM DEFAULT CHARSET=utf8

@Entity
@Table(name="dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private long id;

    @Column(nullable = false, unique = true, columnDefinition = ("TINYINT(3) UNSIGNED"))
    private int age;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(columnDefinition = ("CHAR(2) DEFAULT 'XX'"))
    private String resideState;

    public Dog(){}

    public Dog(int age, String name, String resideState) {
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}
