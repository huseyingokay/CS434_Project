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


function logOut(){
    window.location.href = "../login/login.html";
}