package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;



    @RequestMapping("/")
    public String index(Model model){

        Student student1= new Student();
        student1.setName("Mary");
        student1.setDepartment("Information Systems");
        student1.setGpa(3.7);

        Student student2= new Student();
        student2.setName("John");
        student2.setDepartment("Information Systems");
        student2.setGpa(4.2);

        Instructor rey=new Instructor("Rey");
        Instructor sue=new Instructor("Sue");
        Instructor nora=new Instructor("Nora");
        Course course1 = new Course();
        course1.setTitle("Java101");
        course1.setCredits(4);
        course1.addInstructor(sue);
        course1.addInstructor(nora);
        course1.addStudent(student1);
        course1.addStudent(student2);




        Course course2= new Course();
        course2.setTitle("Html101");
        course2.addInstructor(rey);
        course2.setCredits(3);
        course2.addStudent(student2);
        courseRepository.save(course1);
        courseRepository.save(course2);
        //student1.getCourses().add(course2);



        model.addAttribute("courses",courseRepository.findAll());
        for(Course c: courseRepository.findAll()){
            System.out.println(c.getTitle());
        }
        //model.addAttribute("courses",courseRepository.findAll());
        return "index";



    }
}

