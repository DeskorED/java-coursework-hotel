package javavt18.service;

import javavt18.dao.RoomDAO;
import javavt18.rooms.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("RoomJdbcService")
public class RoomJdbcServiceImpl implements RoomService {
    @Autowired
    @Qualifier("getRoomJdbcDAO")
    private RoomDAO RoomDAO;

    public void saveOrUpdate(Room item) {
        RoomDAO.saveOrUpdate(item);
    }

    public void delete(int itemId) {
        RoomDAO.delete(itemId);
    }

    public Room get(int itemId) {
        return RoomDAO.get(itemId);
    }

    public List<Room> list() {
        return RoomDAO.list();
    }
}