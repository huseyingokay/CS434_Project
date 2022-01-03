package com.CS434Project.Model.Response;

import com.CS434Project.Model.Dto.IExamDTO;

public class GetExamResponse {
    private IExamDTO examDTO;

    public IExamDTO getExamDTO() {
        return examDTO;
    }

    public void setExamDTO(IExamDTO examDTO) {
        this.examDTO = examDTO;
    }
}
