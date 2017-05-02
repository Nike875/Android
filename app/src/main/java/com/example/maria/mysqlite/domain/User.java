package com.example.maria.mysqlite.domain;

/**
 * Created by maria on 30/04/2017.
 */

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String notes;

    public User(){

    }
    public User(long id, String firstName,String lastName, int age, String notes){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.notes = notes;
    }
    public User(String firstName,String lastName, int age, String notes){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
