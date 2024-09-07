package com.imsoftware.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imsoftware.students.entity.Student;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "Select name from subject where id in ( Select subject_id from (Select subject_id, count(1) num from subject_student group by subject_id order by num desc) limit 1)", nativeQuery = true)
    String buscaPopularSubject();
}
