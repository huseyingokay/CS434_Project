const studentId = localStorage.getItem("userId");

function onClickGetExams(){
    document.getElementById('getExamsSection').style.display = 'inline-grid';
    document.getElementById('getExamScoresSection').style.display = 'none';
    getStudentExams()
}

function onClickGetGrades(){
    document.getElementById('getExamsSection').style.display = 'none';
    document.getElementById('getExamScoresSection').style.display = 'block';
    GetGrades()
}

function getStudentExams(){
    let examList;
    axios.get('http://localhost:9000/exam/all/all').then(res => {
        examList = res.data.examList
        console.log(examList)

        let examItems = "";
        for(exam of examList){
            examItems += "<div class='examItem' id=" + exam.examId + ">"
            examItems += "<p>" + exam.examName + "</p>"
            examItems += "<button onclick=\"startExam(" + exam.examId + ")\" > Start Exam </button>"
            examItems += "</div>"

            document.getElementById("getExamsSectionWrapper").innerHTML = examItems;
        }
    })
}

function startExam(examId){
    let questions;
    let questionItems = '';
    axios.get('http://localhost:9000/exam/'+examId).then(res => {
        questions = res.data.examDTO.questions
        if(questions == null)
            alert("Lecturer hasn't prepared the exam!")
        else {
            console.log(questions)
            for(question of questions){
                if(question.questionType === "WRITTEN"){
                    questionItems += '<div class="question" id=written' + question.id + ' style="display: inline-grid">'
                    questionItems += '<p> Question point:' + question.questionPoint+ '</p>'
                    questionItems += '<p>'+question.questionExplanation+'</p>'
                    questionItems += '<p>Please answer the question: </p>'
                    questionItems += '<textarea id=questionAnswer' + question.id + '> </textarea>'
                    questionItems += "<button onclick=\"saveWrittenQuestion(" + question.id +","+examId+ ")\" > Save Answer </button>"
                    questionItems += '</div>'
                }
                if(question.questionType === "TRUEFALSE"){
                    questionItems += '<div class="question" id=truefalse' + question.id + ' style="display: inline-grid">'
                    questionItems += '<p> Question point:' + question.questionPoint+ '</p>'
                    questionItems += '<p>'+question.questionExplanation+'</p>'
                    questionItems += '<p>Please answer the question: </p>'
                    questionItems += '<input type="radio" name=radio'+ question.id + ' id=questionTrue' + question.id + ' value="True">'
                    questionItems += '<label>True</label><br>'
                    questionItems += '<input type="radio" name=radio'+ question.id + ' id=questionFalse' + question.id+' value="False">'
                    questionItems += '<label>False</label><br>'
                    questionItems += "<button onclick=\"saveTrueFalseQuestion(" + question.id +","+examId+ ")\" > Save Answer </button>"
                    questionItems += '</div>'
                }
                if(question.questionType === "MULTICHOICE"){
                    console.log(question)
                    questionItems += '<div class="question" id=multichoice' + question.id + ' style="display: inline-grid">'
                    questionItems += '<p> Question point:' + question.questionPoint+ '</p>'
                    questionItems += '<p>'+question.questionExplanation+'</p>'
                    questionItems += '<p>Please answer the question: </p>'
                    questionItems += '<input type="radio" name=radio'+ question.id + ' id=choiceA' + question.id + ' >'
                    questionItems += '<label>' + question.choices[0] +'</label><br>'
                    questionItems += '<input type="radio" name=radio'+ question.id + ' id=choiceB' + question.id+ ' >'
                    questionItems += '<label>' + question.choices[1] +'</label><br>'
                    questionItems += '<input type="radio" name=radio'+ question.id + ' id=choiceC' + question.id+' >'
                    questionItems += '<label>' + question.choices[2] +'</label><br>'
                    questionItems += '<input type="radio" name=radio'+ question.id + ' id=choiceD' + question.id+' >'
                    questionItems += '<label>' + question.choices[3] +'</label><br>'
                    questionItems += "<button onclick=\"saveMultiChoiceQuestion(" + question.id +","+examId+ ")\" > Save Answer </button>"
                    questionItems += '</div>'
                }
                document.getElementById("getExamsSectionWrapper").innerHTML = questionItems;
            }
        }
    })
}

function saveWrittenQuestion(questionId,examId){
    let answer = document.getElementById("questionAnswer"+questionId).value;
    let request = {
        "studentId": studentId,
        "questionId": questionId,
        "examId": examId,
        "answer": answer
    }

    axios.post('http://localhost:9000/answer/', request)
    alert("Question is answered")
}

function saveMultiChoiceQuestion(questionId,examId){
    let a = "choiceA"+questionId
    let b = "choiceB"+questionId
    let c = "choiceC"+questionId
    let d = "choiceD"+questionId

    let answer;
    if (document.getElementById(a).checked)
        answer = "A"
    else if(document.getElementById(b).checked)
        answer = "B"
    else if(document.getElementById(c).checked)
        answer = "C"
    else if(document.getElementById(d).checked)
        answer = "D"

    let request = {
        "studentId": studentId,
        "questionId": questionId,
        "examId": examId,
        "answer": answer
    }
    axios.post('http://localhost:9000/answer/', request)
    alert("Question is answered")
}

function saveTrueFalseQuestion(questionId, examId){
    let answer;
    if(document.getElementById("questionTrue"+questionId).checked){
        answer="T"
    }
    else{
        answer="F"
    }

    let request = {
        "studentId": studentId,
        "questionId": questionId,
        "examId": examId,
        "answer": answer
    }
    axios.post('http://localhost:9000/answer/', request)
    alert("Question is answered")
}

function GetGrades(){
    let examList;
    axios.get('http://localhost:9000/exam/all/all').then(res => {
        examList = res.data.examList
        console.log(examList)

        let examItems = "";
        for(exam of examList){
            examItems += "<div class='examItem' id=" + exam.examId + ">"
            examItems += "<p>" + exam.examName + "</p>"
            examItems += "<button onclick=\"getGrade(" + exam.examId + ")\" > Get Grade </button>"
            examItems += "<p id=result" + exam.examId + ">  </p>"
            examItems += "</div>"

            document.getElementById("getExamScoresSectionWrapper").innerHTML = examItems;
        }
    })
}

function getGrade(examId) {
    let result = 0.0;
    console.log(studentId)
    axios.get('http://localhost:9000/exam/' + examId +'/results/' + studentId).then(res => {
            result = res.data.result
            document.getElementById("result"+examId).innerHTML = result;
    }).catch((error) => {
        if( error.response ){
            alert("You haven't submit the exam!")
        }
    });

}

function logOut(){
    window.location.href = "../login/login.html";
}