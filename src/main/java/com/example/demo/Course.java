package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private int credits;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Student> students =new HashSet<>();


    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "instructor_course",
            joinColumns=@JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id"))
    private Set<Instructor> instructors;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }


    public void addStudent(Student s) {
        if(this.students==null){
            this.students=new HashSet<>();
        }

        this.students.add(s);
    }
    public void addInstructor(Instructor instructor) {
        if(this.instructors==null){
            this.instructors=new HashSet<Instructor>();
        }

        this.instructors.add(instructor);
    }

    public Set<Student> getStudent() {
        return students;
    }

    public void setStudent(Set<Student> student) {
        this.students = student;
    }

    public Course() {
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

    public String showInstructors() {
        String ins="";
        for(Instructor i:this.instructors){
            ins=ins+i.getName()+" ";
        }
        return ins;
    }
}
