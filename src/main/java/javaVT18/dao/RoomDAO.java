package javavt18.dao;

import javavt18.rooms.Room;
import java.util.List;

public interface RoomDAO {

    void saveOrUpdate(Room item);

    void delete(int itemId);

    Room get(int itemId);

    List<Room> list();

}}
