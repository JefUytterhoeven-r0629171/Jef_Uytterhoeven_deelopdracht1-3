var friendsxhr = new XMLHttpRequest();
var friendlist = new XMLHttpRequest();
function addFriend() {
    friendsxhr.open("GET", "Controller?action=addFriend&type=assync&user="+document.getElementById("logedinuserid").innerText +"&friend="+document.getElementById("friendsid").value, true);
    friendsxhr.onreadystatechange = testfunctie;
    friendsxhr.send(null);

}
function testfunctie() {
    if (friendsxhr.status == 200 && friendsxhr.readyState == 4) {
    }

}

function viewFriendList() {
    friendlist.open("GET", "Controller?action=getFriends&type=assync&user="+document.getElementById("logedinuserid").innerText, true);
    friendlist.onreadystatechange = getFriendData; // onload doet ongeveer hetzelfde als onreadystatechanges maar checkt meteen of the ready state ==4 is
    friendlist.send(null);
}



function getFriendData() {

    if (friendlist.status == 200 && friendlist.readyState == 4) {

        //if(xhr2.responseText != null)
        var friends = JSON.parse(friendlist.responseText);
        var online = 0;
        var offline = 0;
        var away = 0;
        var other = 0;
        for (var i in friends) {
            switch (friends[i].status) {
                case 'online': online++;
                    break;
                case 'away': away++;
                    break;
                case 'offline': offline++
                    break;
                default: other++;

            }
        }


        var output;
        output+= '<h4> there are ' + online + ' online ,' + offline +' offline ,' + away+' away and ' + other +' others in you\'r friendlist';
        for (var i in friends) {
            output +=
                '<div class="friend" id="friends[i].firstName" >' +
                '<ul>' +
                '<li>first name: ' + friends[i].firstName + '</li>' +
                '<li>userid: ' + friends[i].status + '</li>' +
                '<li> <button id="' + friends[i].userId + '" >chat</button></li>' +
                '</ul>' +
                '</div>'
            ;

        }
        setTimeout(viewFriendList, 3000);
        document.getElementById("friends").innerHTML = output;
        //$("#friends").on('click', '#startchat', openchat());


    }
}
