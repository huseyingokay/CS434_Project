package com.CS434Project.Repository;

import com.CS434Project.Model.Question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository<T extends Question> extends JpaRepository<T, Integer> {
}
