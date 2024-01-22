package com.example.jpabasics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

    // integer --> primary is integer
    // Student --> table name is student
    // why extends --> JPARepo is an interface and studentRepository is also an interface
    // therefore we use extends for same type of pages;


}
