package com.drzinks;

import com.drzinks.model.Employee;
import com.drzinks.model.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@SpringBootApplication
public class App implements CommandLineRunner {
    private static List<Employee> employees;

    @Autowired
    public App(List<Employee> employees) {
        this.employees = employees;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        employees.stream().forEach(emp-> System.out.println(emp));
//        System.out.println(getAvgSalaryFromAge(35).orElse(0));
//        Employee emp1 = null;
//        System.out.println(getStateFromJava8(emp1));

        var result = PalindromeChecker.Type.COMPARE_HALVES.isPalindrome("kajak");
        System.out.println(result);
        result = PalindromeChecker.Type.RECURSIVE.isPalindrome("kajak");

        System.out.println(result);
    }

    private OptionalDouble getAvgSalaryFromAge(int age){
        return employees.stream()
                .filter(emp -> emp.age()>=age)
                .mapToInt(Employee::salary)
                .average();
    }

    private static int getStateFromJava8(Employee emp) {
        Optional<Employee> employeeOpt = Optional.ofNullable(emp);
        // Java 8
        return employeeOpt
//                .map(Employee::name)
                .map(Employee::age)
//                .map(Employee::salary)
//                .map(Employee::gender)
//                .orElse("unknown");
                .orElse(0);
    }
}