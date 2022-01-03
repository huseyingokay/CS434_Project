package com.CS434Project.Repository;

import com.CS434Project.Model.Exam.Exam;
import com.CS434Project.Model.Question.MultiChoiceQuestion;
import com.CS434Project.Model.Question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultiChoiceQuestionRepository extends JpaRepository<Question, Integer> {
}
