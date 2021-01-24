package com.zph.entity;

import java.util.List;
import java.util.Map;

public class Person {
    private Integer id;
    private String name;
    private List<String> phones;
    private Map<String,Object> map;

    public Person(Integer id, String name, List<String> phones, Map<String, Object> map) {
        this.id = id;
        this.name = name;
        this.phones = phones;
        this.map = map;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
