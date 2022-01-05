package com.CS434Project.Repository;

import com.CS434Project.Model.Exam.Exam;
import com.CS434Project.Model.Request.UserType;
import com.CS434Project.Model.Student.GradStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
    List<Exam> findExamByUserType(UserType userType);
}
