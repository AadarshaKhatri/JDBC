package org.example;

import models.ConfigFile;
import org.springframework.boot.context.config.InactiveConfigDataAccessException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InactiveConfigDataAccessException,NoClassDefFoundError {
        try {
            String name = "Ram";
            int age = 18;
            int grade = 12;
            ApplicationContext context = new AnnotationConfigApplicationContext(ConfigFile.class);
            JdbcTemplate j = context.getBean(JdbcTemplate.class);
            String sql_query = "insert into students (Age, Name, Class) values(?,?,?)";
            int count = j.update(sql_query,age,name,grade);
            if (count > 0) {
                System.out.println("Insertion Success");
            } else {
                System.out.println("Failed");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}