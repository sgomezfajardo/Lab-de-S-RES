/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testws_20242.entidad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author barr2
 */
@XmlRootElement
public class SalaryResponse {
    
    private int averageSalary;

    public SalaryResponse() {
    }

    public SalaryResponse(int averageSalary) {
        this.averageSalary = averageSalary;
    }

    @XmlElement
    public int getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(int averageSalary) {
        this.averageSalary = averageSalary;
    }
}