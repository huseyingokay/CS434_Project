let questionId = 0;
let examId = 0;
let questionList = []

function onClickCreateExam(){
    document.getElementById('createExamSection').style.display = 'block';
    document.getElementById('editExamSection').style.display = 'none';
    createExam();
}

function onClickEditExam(){
    document.getElementById('editExamSection').style.display = 'block';
    document.getElementById('createExamSection').style.display = 'none';
}

function onClickWritten(){
    let question = '';
    const currentId = questionId;
    question += '<div class="question" id=written' + currentId + ' style="display: inline-grid">'
    question += '<p> Question: ' + (currentId + 1) +'</p>'
    question += '<p>Please add the question point: </p>'
    question += '<textarea class="questionPoint" id=questionPoint' + currentId + '> </textarea>'
    question += '<p>Please add your question explanation: </p>'
    question += '<textarea id=questionExplanation' + currentId + '> </textarea>'
    question += '<p>Please add your answer for this question: </p>'
    question += '<textarea id=questionAnswer' + currentId + '> </textarea>'
    question += "<button onclick=\"saveWrittenQuestion(" + currentId + ")\" > Save Question </button>"
    question += '</div>'
    questionId += 1;
    document.getElementById('createExamMainContext').innerHTML += question;
}

function saveWrittenQuestion(questionId){
    let questionExplanation = document.getElementById("questionExplanation"+questionId).value;
    let questionAnswer = document.getElementById("questionAnswer"+questionId).value;
    let questionPoint = document.getElementById("questionPoint"+questionId).value;

    let request = {
        "answer": questionAnswer,
        "questionExplanation": questionExplanation,
        "questionPoint": questionPoint,
        "examId": examId
    }
    axios.post('http://localhost:9000/question/written', request)

}

function onClickTrueFalse(){
    let question = '';
    const currentId = questionId;
    question += '<div class="question" id=truefalse' + currentId + ' style="display: inline-grid">'
    question += '<p> Question: ' + (currentId + 1) +'</p>'
    question += '<p>Please add the question point: </p>'
    question += '<textarea class="questionPoint" id=questionPoint' + currentId + '> </textarea>'
    question += '<p>Please add your question explanation: </p>'
    question += '<textarea id=questionExplanation' + currentId + '> </textarea>'
    question += '<p>Please add your answer for this question: </p>'
    question += '<input type="radio" name="radio" id=questionTrue' + currentId + ' value="True">'
    question += '<label htmlFor="html">True</label><br>'
    question += '<input type="radio" name="radio" id=questionFalse' + currentId+' value="False">'
    question += '<label htmlFor="css">False</label><br>'
    question += "<button onclick=\"saveTrueFalseQuestion(" + currentId + ")\" > Save Question </button>"
    question += '</div>'
    questionId += 1;
    document.getElementById('createExamMainContext').innerHTML += question;
}

function saveTrueFalseQuestion(questionId){
    let questionExplanation = document.getElementById("questionExplanation"+questionId).value;
    let questionAnswer;
    if(document.getElementById("questionTrue"+questionId).checked){
        questionAnswer="T"
    }
    else{
        questionAnswer="F"
    }

    let questionPoint = document.getElementById("questionPoint"+questionId).value;

    let request = {
        "answer": questionAnswer,
        "questionExplanation": questionExplanation,
        "questionPoint": questionPoint,
        "examId": examId
    }
    axios.post('http://localhost:9000/question/truefalse', request)

}

function onClickMultiChoice() {
    let question = '';
    const currentId = questionId;
    question += '<div class="question" id=multichoice' + currentId + ' style="display: inline-grid">'
    question += '<p> Question: ' + (currentId + 1) +'</p>'
    question += '<p>Please add the question point: </p>'
    question += '<textarea class="questionPoint" id=questionPoint' + currentId + '> </textarea>'
    question += '<p>Please add your question explanation: </p>'
    question += '<textarea id=questionExplanation' + currentId + '> </textarea>'
    question += '<p>Please add your answer for this question: </p>'
    question += '<input type="radio" name="radio" id=choiceA' + currentId + ' >'
    question += '<textarea style="height: 50px" class="multiChoices" htmlFor="html"></textarea><br>'
    question += '<input type="radio" name="radio" id=choiceB' + currentId+ ' >'
    question += '<textarea style="height: 50px" class="multiChoices" htmlFor="css"></textarea><br>'
    question += '<input type="radio" name="radio" id=choiceC' + currentId+' >'
    question += '<textarea style="height: 50px" class="multiChoices" htmlFor="css"></textarea><br>'
    question += '<input type="radio" name="radio" id=choiceD' + currentId+' >'
    question += '<textarea style="height: 50px" class="multiChoices" htmlFor="css"></textarea><br>'
    question += "<button onclick=\"saveMultiChoiceQuestion(" + currentId + ")\" > Save Question </button>"
    question += '</div>'
    questionId += 1;
    document.getElementById('createExamMainContext').innerHTML += question;
}

function saveMultiChoiceQuestion(questionId){
    let a = "choiceA"+questionId
    let b = "choiceB"+questionId
    let c = "choiceC"+questionId
    let d = "choiceD"+questionId

    let questionExplanation = document.getElementById("questionExplanation"+questionId).value;
    let questionAnswer;
    if (document.getElementById(a).checked) {
        questionAnswer = "A"
    }
    else if(document.getElementById(b).checked)
        questionAnswer = "B"
    else if(document.getElementById(c).checked)
        questionAnswer = "C"
    else if(document.getElementById(d).checked)
        questionAnswer = "D"

    let questionPoint = document.getElementById("questionPoint"+questionId).value;

    let request = {
        "answer": questionAnswer,
        "questionExplanation": questionExplanation,
        "questionPoint": questionPoint,
        "examId": examId
    }
    axios.post('http://localhost:9000/question/multichoice', request)
}

async function createExam() {

    await axios.post('http://localhost:9000/exam/'
    ).then(res => {
        examId = res.data.examId
    }).catch(err => console.log(err))

}

