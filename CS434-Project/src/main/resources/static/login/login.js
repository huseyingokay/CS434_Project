$(document).ready(function(){

//--------- change color value of the form text/password inputs -----

    const textInputs =  $("input[type='textbox']");
    const passwordsInputs =  $("input[type='password']");
    //--------- Login screen swicth -----

    $("button").click(function(event){  //  prevent buttons in form to reload
        event.preventDefault();
    });

    $("a").click(function(event){  //  prevent 'a' links in form to reload
        event.preventDefault();
    });

    $("#admin_login").click(function(){ // when click Sign Up button, hide the Log In elements, and display the Sign Up elements
        $("#title-student_login").toggleClass("hidden",true);
        $("#student_login-fieldset").toggleClass("hidden",true);
        $("#student_login-form-submit").toggleClass("hidden",true);
        $("#lost-password-link").toggleClass("hidden",true);
        $("#admin_login").toggleClass("active-button",false);
        $("#student_login").removeAttr("disabled");

        $("#title-admin_login").toggleClass("hidden",false);
        $("#admin_login-fieldset").toggleClass("hidden",false);
        $("#admin_login-form-submit").toggleClass("hidden",false);
        $("#student_login").toggleClass("active-button",true);
        $("#admin_login").prop('disabled', true);
    });

    $("#student_login").click(function(){ // when click Log In button, hide the Sign Up elements, and display the Log In elements
        $("#title-login").toggleClass("hidden",false);
        $("#student_login-fieldset").toggleClass("hidden",false);
        $("#student_login-form-submit").toggleClass("hidden",false);
        $("#lost-password-link").toggleClass("hidden",false);
        $("#admin_login").toggleClass("active-button",true);
        $("#student_login").prop('disabled', true);
        $("#title-admin_login").toggleClass("hidden",true);

        $("#title-student_login").toggleClass("hidden",false);
        $("#admin_login-fieldset").toggleClass("hidden",true);
        $("#admin_login-form-submit").toggleClass("hidden",true);
        $("#student_login").toggleClass("active-button",false);
        $("#admin_login").removeAttr("disabled");

    });
});


async function checkLecturer() {
    let lecturerUsername = document.getElementById("lecturerUsername").value;
    let lecturerPassword = document.getElementById("lecturerPassword").value;

    let checkUserRequest = {
        "username": lecturerUsername,
        "password": lecturerPassword
    }

    const headers = {
        "Access-Control-Allow-Origin": "*"
    }

    await axios.post('http://localhost:9000/login/lecturer', checkUserRequest,
    ).then(res => {
        console.log(res);
    }).catch(err => console.log(err))

    return true;
}

async function checkStudent() {
    let studentType = document.getElementById("studentType").value;
    let studentUsername = document.getElementById("studentUsername").value;
    let studentPassword = document.getElementById("studentPassword").value;

    let checkUserRequest = {
        "username": studentUsername,
        "password": studentPassword
    }

    const headers = {
        "Access-Control-Allow-Origin": "*"
    }

    await axios.post('http://localhost:9000/login/' + studentType, checkUserRequest,
    ).then(res => {
        console.log(res);
    }).catch(err => console.log(err))

    return true;
}
