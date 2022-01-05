package com.CS434Project.Model.Response;

import com.CS434Project.Model.Dto.ExamAndIdDto;

import java.util.ArrayList;
import java.util.List;

public class GetExamListResponse {
    private List<ExamAndIdDto> examList = new ArrayList<>();

    public List<ExamAndIdDto> getExamList() {
        return examList;
    }

    public void setExamList(List<ExamAndIdDto> examList) {
        this.examList = examList;
    }
}
