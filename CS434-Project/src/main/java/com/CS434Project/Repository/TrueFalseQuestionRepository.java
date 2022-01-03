package com.CS434Project.Repository;

import com.CS434Project.Model.Question.TrueFalseQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrueFalseQuestionRepository extends JpaRepository<TrueFalseQuestion, Integer> {
}
