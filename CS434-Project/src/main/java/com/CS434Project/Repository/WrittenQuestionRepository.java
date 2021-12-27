package com.CS434Project.Repository;

import com.CS434Project.Model.Exam.Exam;
import com.CS434Project.Model.Question.WrittenQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface WrittenQuestionRepository extends JpaRepository<WrittenQuestion, Integer> {
}
