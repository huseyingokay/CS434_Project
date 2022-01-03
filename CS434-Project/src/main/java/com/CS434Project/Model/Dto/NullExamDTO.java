package com.CS434Project.Model.Dto;

import java.util.List;

public class NullExamDTO implements IExamDTO{
    private int id = 0;
    private List<QuestionDTO> questions = null;
}
