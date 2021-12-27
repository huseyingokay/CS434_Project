package com.CS434Project.Repository;

import com.CS434Project.Model.Lecturer.Lecturer;
import com.CS434Project.Model.Student.UnderGradStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnderGradRepository extends JpaRepository<UnderGradStudent, Integer> {
    UnderGradStudent findByUsername(String username);
}
