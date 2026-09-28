function showcourses(){
   fetch("http://localhost:8081/courses")
   .then((response) => response.json()) 
   .then((courses) => {
    const dataTable=document.getElementById("coursetable")
    courses.forEach(course => {
         var row = `<tr>
         <td >${course.courseId}</td>
         <td>${course.courseName}</td>
         <td>${course.trainer}</td>
         <td>${course.durationInWeeks}</td>
        </tr>`;
        dataTable.innerHTML+=row;
    });
   });
   
}
function showencourses(){
   fetch("http://localhost:8081/courses/enrolled")
   .then((response) => response.json()) 
   .then((students) => {
    const dataTable=document.getElementById("enrolltable")
    students.forEach(student => {
         var row = `<tr>
         <td>${student.id}</td>
         <td>${student.name}</td>
         <td>${student.emailId}</td>
         <td>${student.courseName}</td>
         <td><button onclick="deleteStudent(${student.id})">Delete</button></td>
        </tr>`;
        dataTable.innerHTML+=row;
    });
   });
   
}

    
function bill(){
   alert("successfully registered!");
}
         
     
   
