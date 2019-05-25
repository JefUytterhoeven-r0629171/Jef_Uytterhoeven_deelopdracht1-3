var uitgavenverzender = new XMLHttpRequest();
var uitgavenreciever = new XMLHttpRequest();

function sendStudenten(){
    console.log("student moet worden toegevoegf")
    uitgavenverzender.open("GET", "Controller?action=addstudent&type=assync&naam="+document.getElementById("studentnaam").value +"&vak="+document.getElementById("vak").value +"&datum="+document.getElementById("datum").value +"&uur="+document.getElementById("uur").value , true);
    uitgavenverzender.onreadystatechange = addStudent;
    uitgavenverzender.send(null);
}
function addStudent() {

}

function viewStudent() {
    uitgavenreciever.open("GET", "Controller?action=getStudenten&type=assync", true);
    uitgavenreciever.onreadystatechange = getStudentdata; // onload doet ongeveer hetzelfde als onreadystatechanges maar checkt meteen of the ready state ==4 is
    uitgavenreciever.send(null);
}

function getStudentdata() {

    if (uitgavenreciever.status == 200 && uitgavenreciever.readyState == 4) {
        var studenten = JSON.parse(uitgavenreciever.responseText);
        console.log(studenten);
        var output;
        for (var i in studenten) {
            output +=
                    '<div class="studenten"'+
                    '<ul>' +
                    '<li>naam: ' + studenten[i].naam + '</li>' +
                    '<li>bedrag: ' + studenten[i].vak + '</li>' +
                    '<li>datum: ' + studenten[i].datum + '</li>' +
                    '<li>uur: ' + studenten[i].uur + '</li>' +
                    '</ul>' +
                    '</div>'
        }
        setTimeout(viewStudent, 3000);
        document.getElementById("studentenlijst").innerHTML = output;


    }
}