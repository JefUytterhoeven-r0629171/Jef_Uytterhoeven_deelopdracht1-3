package db;

import domain.Chat;

import java.util.List;

public interface ChatRepository {
    public abstract void add(Chat chat);
    public abstract void delete(Chat chat);
    public abstract List<Chat> getAll();
}
