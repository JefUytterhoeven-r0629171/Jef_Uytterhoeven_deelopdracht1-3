package db;

import domain.Chat;
import domain.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatRepositoryStub implements ChatRepository {
    private ArrayList<Chat> chats ;

    public ChatRepositoryStub (){
            chats = new ArrayList<Chat>();
    }

    @Override
    public void delete(Chat chat) {
        if(chats.contains(chat)){
            chats.remove(chat);
        }
    }

    @Override
    public void add(Chat chat) {
        chats.add(chat);
    }

    @Override
    public List<Chat> getAll() {
        return chats;
    }
}
