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
    axios.get('http://localhost:9000/exam', request)
}


function logOut(){
    window.location.href = "../login/login.html";
}