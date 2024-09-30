/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testws_20242.entidad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author barr2
 */
@XmlRootElement(name = "persona")
@XmlType(propOrder = {"id","fullName","age", "salario"})
public class Person {
    
    private int id;
    private String fullName;
    private int age;
    private int salario;
    private int salMinimo = 1300000;
    
    public Person(){
        
    }

    public Person(int id, String fullName, int age, int salario) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.salario = salario;
    }
    
    @XmlElement
    public int getSalario() {
        return salario;
    }

    public void setSalario(int age) {
        this.salario = age*this.salMinimo/3;
        System.out.println("entre al metodo");
        System.out.println("age: " + age);
        System.out.println("salminimo: " + salMinimo);
        System.out.println("salario: " + salario);
    }
    
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
