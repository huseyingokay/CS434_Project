function checkUser(){
   if(document.getElementById("userType").value == "Lecturer") {
       checkLecturer()
   }
   else if(document.getElementById("userType").value == "UnderGrad"){
       checkStudent("undergrad");
   }
   else{
       checkStudent("grad");
   }
}

async function checkLecturer() {
    let lecturerUsername = document.getElementById("username").value;
    let lecturerPassword = document.getElementById("password").value;

    console.log(lecturerUsername)
    console.log(lecturerPassword)

    let checkUserRequest = {
        "username": lecturerUsername,
        "password": lecturerPassword
    }

    await axios.post('http://localhost:9000/login/lecturer', checkUserRequest,
    ).then(res => {
        if(res.data.valid)
            window.location.href = "../lecturer/lecturer.html";
        else
            alert("Your username or password is incorrect")
    }).catch(err => console.log(err))

    return true;
}

async function checkStudent(studentType) {
    let studentUsername = document.getElementById("username").value;
    let studentPassword = document.getElementById("password").value;

    let checkUserRequest = {
        "username": studentUsername,
        "password": studentPassword
    }

    await axios.post('http://localhost:9000/login/' + studentType, checkUserRequest,
    ).then(res => {
        if(res.data.valid)
            window.location.href = "../student/student.html";
        else
            alert("Your username or password is incorrect")
    }).catch(err => console.log(err))

    return true;
}
