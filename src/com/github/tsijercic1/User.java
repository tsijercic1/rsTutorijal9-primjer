package com.github.tsijercic1;

import java.time.LocalDate;

public class User {
    private String name;
    private LocalDate birthday;
    private String phoneNumber;

    public User(String name, LocalDate birthday, String phoneNumber) {
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + " " + birthday + " " + phoneNumber;
    }
}
