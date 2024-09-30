/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testws_20242.services;

import com.mycompany.testws_20242.entidad.Person;
import com.mycompany.testws_20242.entidad.SalaryResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author barr2
 */
@Path("services")
public class Service {

    private static Map<Integer, Person> personas = new HashMap();

    static {
        for (int i = 0; i < 10; i++) {
            Person persona = new Person();
            int id = i + 1;
            persona.setId(id);
            persona.setFullName("Apreciado Amigo  " + id);
            int age = new Random().nextInt(40) + 1;
            persona.setAge(age);
            persona.setSalario(age);
            personas.put(id, persona);
        }
    }

    @GET
    @Path("/getAllPersonsInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsInJson() {
        return new ArrayList<Person>(personas.values());
    }

    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML() {
        return new ArrayList<Person>(personas.values());
    }

    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJson(@PathParam("id") int id) {
        return personas.get(id);
    }

    @POST
    @Path("/addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPersonInJson(Person person) {
        person.setSalario(person.getAge());
        personas.put(new Integer(person.getId()), person);
        return person;
    }

    @GET
    @Path("/getAverageSalaryInXML")
    @Produces(MediaType.APPLICATION_XML)
    public SalaryResponse averageSalary() {
        int avg = 0;
        for (Person person : personas.values()) {
            avg += person.getSalario();
        }
        avg /= personas.size();
        System.out.println("avg: " + avg);

        return new SalaryResponse(avg);  // Retornamos el objeto envolvente
    }

    @GET
    @Path("/getSumSalaryInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public int sumSalary() {
        int total = 0;
        for (Person person : personas.values()) {
            total += person.getSalario();
        }
        System.out.println("Total salario: " + total);
        return total;
    }

}
