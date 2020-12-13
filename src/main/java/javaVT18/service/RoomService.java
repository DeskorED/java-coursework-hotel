package javavt18.service;

import javavt18.rooms.Room;
import java.util.List;

public interface RoomService {
    void saveOrUpdate(Room item);

    void delete(int itemId);

    Room get(int itemId);

    List<Room> list();
}