package com.example.studentSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Name;
    private String Gender;
    private String Birthdate;
    private String NativePlace;
    private String Department;
    private String Number;

    public void setNumber(String number) {
        Number = number;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public void setNativePlace(String nativePlace) {
        NativePlace = nativePlace;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNumber() {
        return Number;
    }

    public String getDepartment() {
        return Department;
    }

    public String getNativePlace() {
        return NativePlace;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public String getGender() {
        return Gender;
    }

    public String getName() {
        return Name;
    }

    public Integer getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Birthdate='" + Birthdate + '\'' +
                ", NativePlace='" + NativePlace + '\'' +
                ", Department='" + Department + '\'' +
                ", Number='" + Number + '\'' +
                '}';
    }
}
