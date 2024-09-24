package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Random;


public class Person {

    private static final  String[] names = new String[]{"Никита", "Даша", "Гоша", "Данил", "Василиса"};

    private static final Random random = new Random();


    private int id;
    private String name;
    private int age;

    public Person() {
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Person create(){
        return new Person(names[random.nextInt(names.length)],random.nextInt(20,26) );
    }


    public void updateAge(){
        age = random.nextInt(20,26);
    }

    public void updateName(){
        name = names[random.nextInt(names.length)];
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int age() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
