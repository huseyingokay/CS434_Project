let questionId = 0;


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
    question += '<div class="question" id=written' + questionId + ' style='display: inline-grid'>'
    question += '<p> Question: ' + (questionId + 1) +'</p>'
    question += '<p>Please add your question explanation: </p>'
    question += '<textarea id=questionExplanation' + questionId + '> </textarea>'
    question += '<p>Please add your answer for this question: </p>'
    question += '<textarea id=questionAnswer' + questionId + '> </textarea>'
    question += '</div>'
    questionId += 1;
    document.getElementById('createExamMainContext').innerHTML += question;
}

function onClickTrueFalse(){
    let question = '';
    question += '<div class='question' id=truefalse' + questionId + ' style='display: inline-grid'>'
    question += '<p> Question: ' + (questionId + 1) +'</p>'
    question += '<p>Please add your question explanation: </p>'
    question += '<textarea id=questionExplanation' + questionId + '> </textarea>'
    question += '<p>Please add your answer for this question: </p>'
    question += '<input type='radio' id='html' name='fav_language' value='HTML'>'
    question += '<label htmlFor='html'>HTML</label><br>'
    question += '<input type='radio' id='css' name='fav_language' value='CSS'>'
    question += '<label htmlFor='css'>CSS</label><br>'
    question += '</div>'
    questionId += 1;
    document.getElementById('createExamMainContext').innerHTML += question;
}