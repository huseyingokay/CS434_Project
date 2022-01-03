function checkUser(){
   if(document.getElementById("userType").value == "Lecturer") {
       console.log("HWEEEEEEEEEEEY")
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

    const headers = {
        "Access-Control-Allow-Origin": "*"
    }

    await axios.post('http://localhost:9000/login/lecturer', checkUserRequest,
    ).then(res => {
        console.log(res);
        if(res.data.valid)
            window.location.href = "../lecturer/lecturer.html";
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

    const headers = {
        "Access-Control-Allow-Origin": "*"
    }

    await axios.post('http://localhost:9000/login/' + studentType, checkUserRequest,
    ).then(res => {
        if(res.data.valid)
            window.location.href = "../student/student.html";
    }).catch(err => console.log(err))

    return true;
}
