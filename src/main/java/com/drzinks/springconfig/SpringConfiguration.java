package com.drzinks.springconfig;

import com.drzinks.model.Employee;
import com.drzinks.model.Gender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SpringConfiguration {

    @Bean
    public List<Employee> employees(){
        Employee employee1 = new Employee("John", 20, 2000, Gender.MALE);
        Employee employee2 = new Employee("Jane", 28, 2000, Gender.FEMALE);
        Employee employee3 = new Employee("Alex", 33, 2750, Gender.MALE);
        Employee employee4 = new Employee("Mary", 35, 3500, Gender.FEMALE);
        Employee employee5 = new Employee("Pedro", 40, 3100, Gender.MALE);

        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5);
        return employees;
    }
}
