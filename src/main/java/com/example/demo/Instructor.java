package com.example.demo;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

//many2many without mappedby
@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "instructor_course",
    joinColumns=@JoinColumn(name = "instructor_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;

    public Instructor() {
    }

    public Instructor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
