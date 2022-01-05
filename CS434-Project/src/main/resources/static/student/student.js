function onClickGetExams(){
    document.getElementById('getExamsSection').style.display = 'block';
    document.getElementById('getExamScoresSection').style.display = 'none';
    getStudentExams()
}

function onClickGetGrades(){
    document.getElementById('getExamsSection').style.display = 'none';
    document.getElementById('getExamScoresSection').style.display = 'block';
}

function getStudentExams(){
    let examList;
    axios.get('http://localhost:9000/exam/all/all').then(res => {
        examList = res.data.examList
        console.log(examList)

        let examItems = "";
        for(exam of examList){
            examItems += "<div class='product' id=" + exam.examId + ">"
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
                    questionItems += '<p> Question point:' + question.id+ '</p>'
                    questionItems += '<p>'+question.questionExplanation+'</p>'
                    questionItems += '<p>Please add your answer for this question: </p>'
                    questionItems += '<textarea id=questionAnswer' + question.id + '> </textarea>'
                    questionItems += "<button onclick=\"saveWrittenQuestion(" + question.id +","+examId+ ")\" > Save Answer </button>"
                    questionItems += '</div>'
                }
                document.getElementById("getExamsSectionWrapper").innerHTML = questionItems;
            }
        }
    })
}

function saveWrittenQuestion(questionId,examId){
    let studentId = localStorage.getItem("userId");
    let answer = document.getElementById("questionAnswer"+questionId).value;

    let request = {
        "studentId": studentId,
        "questionId": questionId,
        "examId": examId,
        "answer": answer
    }

    axios.post('http://localhost:9000/answer/', request)
}

function logOut(){
    window.location.href = "../login/login.html";
}