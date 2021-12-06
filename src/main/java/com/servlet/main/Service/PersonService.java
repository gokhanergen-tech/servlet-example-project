package com.servlet.main.Service;

import com.servlet.main.Model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private static List<Person> personList=new ArrayList<>();

    public static void addPerson(Person person){
        personList.add(person);
    }

    public static List<Person> getPersonList() {
        return personList;
    }
}
