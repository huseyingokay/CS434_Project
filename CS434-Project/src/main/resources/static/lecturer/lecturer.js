let questionId = 0;
let questionExplanation = "questionExplanation"
let written = "written"

function onClickCreateExam(){
    document.getElementById('createExamSection').style.display = 'block';
    document.getElementById('editExamSection').style.display = 'none';
}

function onClickEditExam(){
    document.getElementById('editExamSection').style.display = 'block';
    document.getElementById('createExamSection').style.display = 'none';
}

function onClickWritten(){
    let question = '';
    question += '<div class="question" id=written' + questionId + ' style="display: inline-grid">'
    question += '<p> Question: ' + (questionId + 1) +'</p>'
    question += '<p>Please add your question explanation: </p>'
    question += '<textarea placeholder={localStorage.getItem(written+questionId)} onchange=localStorage.setItem(written+questionId,document.getElementById(questionExplanation+(questionId-1)).value) id=questionExplanation' + questionId + '> </textarea>'
    question += '<p>Please add your answer for this question: </p>'
    question += '<textarea id=questionAnswer' + questionId + '> </textarea>'
    question += '</div>'
    questionId += 1;
    document.getElementById('createExamMainContext').innerHTML += question;
}

function onClickTrueFalse(){
    let question = '';
    question += '<div class="question" id=truefalse' + questionId + ' style="display: inline-grid">'
    question += '<p> Question: ' + (questionId + 1) +'</p>'
    question += '<p>Please add your question explanation: </p>'
    question += '<textarea id=questionExplanation' + questionId + '> </textarea>'
    question += '<p>Please add your answer for this question: </p>'
    question += '<input type="radio" name="radio" id=questionTrue' + questionId + ' value="True">'
    question += '<label htmlFor="html">True</label><br>'
    question += '<input type="radio" name="radio" id=questionFalse' + questionId+' value="False">'
    question += '<label htmlFor="css">False</label><br>'
    question += '</div>'
    questionId += 1;
    document.getElementById('createExamMainContext').innerHTML += question;
}

function onClickMultiChoice() {
    let question = '';
    question += '<div class="question" id=truefalse' + questionId + ' style="display: inline-grid">'
    question += '<p> Question: ' + (questionId + 1) +'</p>'
    question += '<p>Please add your question explanation: </p>'
    question += '<textarea id=questionExplanation' + questionId + '> </textarea>'
    question += '<p>Please add your answer for this question: </p>'
    question += '<input type="radio" name="radio" id=choiceA' + questionId + ' >'
    question += '<textarea style="height: 50px" class="multiChoices" htmlFor="html">Enter a choice</textarea><br>'
    question += '<input type="radio" name="radio" id=choiceB' + questionId+' >'
    question += '<textarea style="height: 50px" class="multiChoices" htmlFor="css">Enter a choice</textarea><br>'
    question += '<input type="radio" name="radio" id=choiceC' + questionId+' >'
    question += '<textarea style="height: 50px" class="multiChoices" htmlFor="css">Enter a choice</textarea><br>'
    question += '<input type="radio" name="radio" id=choiceD' + questionId+' >'
    question += '<textarea style="height: 50px" class="multiChoices" htmlFor="css">Enter a choice</textarea><br>'
    question += '</div>'
    questionId += 1;
    document.getElementById('createExamMainContext').innerHTML += question;
}

async function submitExam() {
    let examId = 0;
    const headers = {
        "Access-Control-Allow-Origin": "*"
    }

    await axios.post('http://localhost:9000/exam/'
    ).then(res => {
        examId = res.data.examId
    }).catch(err => console.log(err))



}

