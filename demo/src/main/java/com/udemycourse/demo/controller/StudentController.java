package com.udemycourse.demo.controller;

import com.udemycourse.demo.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//returning a student object into json
@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
       Student stud=new Student("kanchan",1);
       return stud;
    }

    //responseentity demo
    @GetMapping("/studenty")
    public ResponseEntity<Student> getStudents(){
        Student stud=new Student("kanchan",1);
        //agar khud ka status bhjna hai ye line best h
        //return new ResponseEntity<>(stud,HttpStatus.OK);
        //OR
        //return ResponseEntity.ok(stud); //this stud is body ok is status
        //OR all body ,header ,status in one go
        return ResponseEntity.ok().header("custom-header","ramesh").body(stud);

    }

    @GetMapping("students")
    public List<Student> Getall(){
        List<Student>stud=new ArrayList<>();
        stud.add(new Student("mearra",2));
        stud.add(new Student("peearra",2));
        stud.add(new Student("jeera",2));

        stud.add(new Student("hema",2));

        return stud;
    }
    @GetMapping("/stud/{id}")
    public Student get(@PathVariable("id") int sid ){
        return new Student("ramesh",sid);
    }

    //can return multiple path variables
    @GetMapping("/stud/{id}/{nmae}")
    public Student get(@PathVariable("id") int sid ,
                       @PathVariable String nmae){
        return new Student(nmae,sid);
    }
    @GetMapping("/studentshi")
    public Student querymethod(@RequestParam int id){
        return new Student("kanchan",id);
    }
    //can return multiple request param
    @GetMapping("/students/query")
    public Student querymethods(@RequestParam int id,@RequestParam String name){
        return new Student(name,id);
    }

    @PostMapping("/create/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getName());
        return student;
    }
    //Restapi for updating
    @PutMapping("/update/{id}")
    public Student update(@RequestBody Student student,@PathVariable int id){
        System.out.println(student.getId());
        System.out.println(student.getName());
        return student;
    }
    //for dleeting

    @DeleteMapping("/del/{id}")
    public String delete(@PathVariable  int id){
        return "deleted succ";
    }
}
