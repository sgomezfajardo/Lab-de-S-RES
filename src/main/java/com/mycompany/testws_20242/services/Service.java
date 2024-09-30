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

@Path("services")  // Ruta base para el servicio
public class Service {

    private static Map<Integer, Person> personas = new HashMap<>();

    // Inicializa algunas personas de prueba
    static {
        for (int i = 0; i < 10; i++) {
            Person persona = new Person();
            int id = i + 1;
            persona.setId(id);
            persona.setFullName("Apreciado Amigo " + id);
            int age = new Random().nextInt(40) + 1;  // Edad aleatoria entre 1 y 40
            persona.setAge(age);
            persona.setSalario(age);  // Asigna el salario igual a la edad
            personas.put(id, persona);
        }
    }

    // Método para obtener todas las personas en formato JSON
    @GET
    @Path("/getAllPersonsInJson")  // Ruta para este método
    @Produces(MediaType.APPLICATION_JSON)  // Tipo de respuesta
    public List<Person> getAllPersonsInJson() {
        return new ArrayList<>(personas.values());
    }

    // Método para obtener todas las personas en formato XML
    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML() {
        return new ArrayList<>(personas.values());
    }

    // Método para obtener una persona por ID en formato JSON
    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJson(@PathParam("id") int id) {
        return personas.get(id);
    }

    // Método para agregar una persona en formato JSON
    @POST
    @Path("/addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPersonInJson(Person person) {
        person.setSalario(person.getAge());  // Establece el salario basado en la edad
        personas.put(person.getId(), person);
        return person;
    }

    // Método para calcular el salario promedio en formato XML
    @GET
    @Path("/getAverageSalaryInXML")
    @Produces(MediaType.APPLICATION_XML)
    public SalaryResponse averageSalary() {
        int avg = 0;
        for (Person person : personas.values()) {
            avg += person.getSalario();
        }
        avg /= personas.size();
        System.out.println("Promedio de salario: " + avg);
        return new SalaryResponse(avg);  // Retorna el objeto envolvente
    }

    // Método para calcular la suma de salarios en formato JSON
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
