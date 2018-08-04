$chatvensters = 0
$lastmessageindex = 0
function openchat( id ) {

    var user1 = id
    var user2 = document.getElementById("logedinuserid").innerText ;

    $.post("Controller?action=NewChat&type=assync", {user1: user1, user2: user2});

    //$otheruser = this.value;

};

function  openChatWindow() {
    $user = '';
    if(document.getElementById("logedinuserid") !== null) {
        $user = document.getElementById("logedinuserid").innerText;
    }
    $.post("Controller?action=OpenChatWindows&type=assync", {user:$user}, function(data) {

        //var chats = JSON.parse(data);
        var output;
        var n = $('#chatdiv .chat-box').length
        if(n<data.length) {

            for (var i in data) {
                naam = data[i].chatId;
                $('#chatdiv').append('<div class="chat-box" id="' + naam + '">\n' +
                    '    <div class="chat-closed"> Chat Now </div>\n' +
                    '    <div class="chat-header hide"><div class="box"></div>' + naam + '</div>\n' +
                    '    <div class="chat-content hide">\n' +
                    '\n' +
                    '        you\'r now chatting with ' + naam + '\n' +
                    '<br>' +
                    data[i].chat[0] +
                    '<div class="chat-input"><input type="text" id="chatmessage" name="message">  <button>send</button> </div> ' +
                    '    </div>\n' +

                    '</div>');

            }
        }


    $(".chat-closed").on("click",function(e){
        $(".chat-header,.chat-content").removeClass("hide");
        $(this).addClass("hide");
    });

    $(".chat-header").on("click",function(e){
        $(".chat-header,.chat-content").addClass("hide");
        $(".chat-closed").removeClass("hide");
    });

    },"JSON");

    setTimeout(openChatWindow, 1000);
    checkCHatText()
}

function checkCHatText() {
    var IDs = [];
    $(".chat-box").each(function(){
        IDs.push($(this).attr('id'));
    });

    $.post("Controller?action=CheckChatTexts&type=assync", {chatid:IDs[0]}, function(data) {
        if(data == null){

        }else {
            for (var i in data.chat) {
                if (i > $lastmessageindex) {
                    $('#chatdiv .chat-content').append('<br>' + data.chat[i])
                }

            }
            $lastmessageindex = data.chat.length - 1;
        }
    });

}

$(document).ready(function(){
    openChatWindow();
    $("#friends").on("click", "ul li button", function(){
        title=$(this).attr("id");

        openchat(title);
    });

    $("#chatdiv").on("click", "div.chat-input button", function(){

        $message = document.getElementById("logedinuserid").innerText +": " +  $("#chatdiv input").val();
        //alert($message);
        var IDs = [];
        $(".chat-box").each(function(){
            IDs.push($(this).attr('id'));
        });

        $.post("Controller?action=ChatAddMessage&type=assync", {message:$message , chatid:IDs[0]});

    });


});