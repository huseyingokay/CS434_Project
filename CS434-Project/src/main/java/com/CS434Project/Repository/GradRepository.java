package com.CS434Project.Repository;

import com.CS434Project.Model.Student.GradStudent;
import com.CS434Project.Model.Student.UnderGradStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradRepository extends JpaRepository<GradStudent, Integer> {
    GradStudent findByUsername(String username);

}
