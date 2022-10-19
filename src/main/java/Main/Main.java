package Main;

import DBManager.ConnectionPool.BasicConnectionPool;
import DBManager.DBManager;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import model.tables.Courses;


import org.jooq.codegen.GenerationTool;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws Exception {


        try{

            DBManager DBManager = new DBManager(BasicConnectionPool
                       .create("jdbc:mysql://localhost:3306/skillbox",
                              "root",
                              "ft232rl"),
                               SQLDialect.MYSQL);

            Result<Record> courses =  DBManager.getTable(Courses.COURSES);

            courses.forEach( course ->{
               String name = course.getValue(Courses.COURSES.NAME);
                System.out.println("Course name: " + name );
            });


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
