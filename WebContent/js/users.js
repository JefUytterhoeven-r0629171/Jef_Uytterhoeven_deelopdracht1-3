var xhr = new XMLHttpRequest();

function changeState() {
    var buttons = document.getElementsByName('status');
    var user = document.getElementById("logedinuserid").innerText;
    var state = "undifind";

    if(document.getElementById("online").checked){
        state = "online";
    }
    if(document.getElementById("away").checked){
        state = "away";
    }
    if(document.getElementById("offline").checked){
        state = "offline";
    }

    if(document.getElementById("other").checked){
        state = document.getElementById("eigenstatusfield").value;
    }


    console.log("gebruiker heeft zijn status gechanged naar "+state);
    xhr.open("get", "Controller?action=ChangeState&type=assync&state="+state+"&user="+user, true);
    xhr.onreadystatechange = aplychangedstate;
    xhr.send(null);

}
function aplychangedstate() {
    if(xhr.status == 200) {
        if (xhr.readyState == 4) {
            var user = JSON.parse(xhr.responseText);
            output = '<h3> je huidige status is changed to ' + user.status + '</h3>';
            document.getElementById("userstatus").innerHTML = output;
        }
    }
}

function getUsers() {
   xhr.open("GET", "Controller?action=Users&type=assync", true);
    xhr.onreadystatechange = getData; // onload doet ongeveer hetzelfde als onreadystatechanges maar checkt meteen of the ready state ==4 is
    xhr.send(null);

}

function getData() {

    if(xhr.status == 200){
        if (xhr.readyState == 4) {

            var users = JSON.parse(xhr.responseText);
            var output = '<h2> all users</h2>';
            for (var i in users) {
                output +=
                    '<div class="user">' +
                    '<ul>' +
                    '<li>first name: ' + users[i].firstName + '</li>' +
                    '<li>userid: ' + users[i].userId + '</li>' +
                    '<li>role: ' + users[i].role + '</li>' +
                    //'<li> <button id="addfriend" value="'+users[i].userId+'">add friend</button></li>' +
                    '</ul>' +
                    '</div>'
                ;

            }

            document.getElementById("users").innerHTML = output;

        }
    }

}
