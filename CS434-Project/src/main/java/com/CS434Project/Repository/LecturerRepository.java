package com.CS434Project.Repository;

import com.CS434Project.Model.Lecturer.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
    Lecturer findByUsername(String username);
}
