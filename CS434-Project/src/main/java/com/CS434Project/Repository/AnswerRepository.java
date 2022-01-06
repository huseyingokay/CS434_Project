package com.CS434Project.Repository;

import com.CS434Project.Model.Answer.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findByStudentIdAndExamId(int studentId, int examId);
    Answer findByStudentIdAndExamIdAndQuestionId(int studentId, int examId, int questionId);
}
