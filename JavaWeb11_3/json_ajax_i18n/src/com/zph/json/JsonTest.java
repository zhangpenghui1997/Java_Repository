package com.zph.json;

import com.google.gson.Gson;
import com.zph.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    @Test
    public void test1() {
        Person person = new Person(1, "zph");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        System.out.println(s);

        Person person1 = gson.fromJson(s, Person.class);
        System.out.println(person1);
    }


    @Test
    public void test2() {
        Gson gson = new Gson();
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "zph"));
        personList.add(new Person(2, "123"));
        String personListJson = gson.toJson(personList);
        System.out.println(personListJson);
        List<Person> list= gson.fromJson(personListJson, new PersonListType().getType());
        System.out.println(list);


    }
    @Test
    public void test3(){
        Map<Integer,Person> personMap=new HashMap<>();
        personMap.put(1,new Person(1,"zph"));
        personMap.put(2,new Person(2,"123"));
        System.out.println(personMap);
        Gson gson=new Gson();
        String personMapJson=gson.toJson(personMap);
        System.out.println(personMapJson);


       Map<Integer,Person> map= gson.fromJson(personMapJson, new PersonMapType().getType());
        System.out.println(map);
        Person p=map.get(2);
        System.out.println(p);


    }
}
