package domain;

import java.util.ArrayList;

public class Chat {
    String chatId = "";
    ArrayList<String> chat = new ArrayList<>();
    ArrayList<Person> deelnemers = new ArrayList<>();

    public Chat(Person user1, Person user2){
        deelnemers.add(user1);
        deelnemers.add(user2);
        chatId = user1.getUserId() + user2.getUserId();
        chat.add("dit is een teststring om te zien of de tekst doorkomt in het chatvenster");
    }

    public String getChatId() {
        return chatId;
    }

    public ArrayList<String> getChat() {
        return chat;
    }
    public void addMessage(String message){
        chat.add(message);
    }
    public void addDeelnemer(Person deelnemer){
        deelnemers.add(deelnemer);
    }

    public ArrayList<Person> getDeelnemers() {
        return deelnemers;
    }
    public Boolean isDeelnemer(Person deelnemer){
        if(deelnemers.contains(deelnemer)){
            return true;
        }else{
            return false;
        }
    }
}
