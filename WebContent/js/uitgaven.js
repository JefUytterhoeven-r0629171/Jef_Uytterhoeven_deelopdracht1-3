var uitgavenverzender = new XMLHttpRequest();
var uitgavenreciever = new XMLHttpRequest();

function senduitgaven(){
    uitgavenverzender.open("GET", "Controller?action=adduitgaven&type=assync&naam="+document.getElementById("naam").innerText +"&bedrag="+document.getElementById("bedrag").value +"&datum="+document.getElementById("datum").value, true);
    uitgavenverzender.onreadystatechange = adduitgaven;
    uitgavenverzender.send(null);
}
function adduitgaven() {

}


function viewUitgaven() {
    uitgavenreciever.open("GET", "Controller?action=getuitgaven&type=assync", true);
    uitgavenreciever.onreadystatechange = getUitgavendata; // onload doet ongeveer hetzelfde als onreadystatechanges maar checkt meteen of the ready state ==4 is
    uitgavenreciever.send(null);
}

function getUitgavendata() {
    if (uitgavenreciever.status == 200 && uitgavenreciever.readyState == 4) {
        var uitgave = JSON.parse(uitgavenreciever.responseText);

        var output;
        for (var i in uitgave) {
            output +=
                '<div class="uitgaven" id="uitgaven[i].naam" >' +
                '<ul>' +
                '<li>naam: ' + uitgave[i].naam + '</li>' +
                '<li>bedrag: ' + uitgave[i].bedrag + '</li>' +
                '<li>datum: ' + uitgave[i].datum + '</li>' +
                '</ul>' +
                '</div>'
            ;

        }
        setTimeout(viewFriendList, 3000);
        document.getElementById("uitgavenlijst").innerHTML = output;


    }
}