package javavt18.dao.jdbc;

import javavt18.dao.RoomDAO;
import javavt18.dao.CategoryDAO;
import javavt18.rooms.Room;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class RoomDAOJdbcImpl implements RoomDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RoomDAOJdbcImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveOrUpdate(Room item) {
        if (item.getIdRoom() > 0) {
            // update
            System.out.println("Room update");
            String sql = "UPDATE room SET roomName=?, roomNumber=?, Status=?, idCategory=? WHERE idRoom=?";
            jdbcTemplate.update(sql, item.getRoomName(),  item.getRoomNumber(), item.isStatus(), item.getIdCategory(),item.getIdRoom()  );
        } else {
            // insert
            System.out.println("Room insert");
            String sql = "INSERT INTO room (roomName, idCategory, Status, roomNumber)"
                    + " VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, item.getRoomName(), item.getIdCategory(), item.isStatus(), item.getRoomNumber());
        }
    }

    public void delete(int itemId) {
        String sql = "DELETE FROM room WHERE idRoom=?";
        jdbcTemplate.update(sql, itemId);
    }

    public Room get(int itemId) {
        String sql = "SELECT * FROM room WHERE idRoom=" + itemId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Room>() {

            public Room extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    return getRoomFromDB(rs);
                }
                return null;
            }
        });
    }

    public List<Room> list() {
        String sql = "SELECT * FROM room";
        List<Room> listRoom = jdbcTemplate.query(sql, new RowMapper<Room>() {

            public Room mapRow(ResultSet rs, int i) throws SQLException {

                return getRoomFromDB(rs);
            }
        });
        return listRoom;
    }

    private Room getRoomFromDB(ResultSet rs) throws SQLException{
        Room room = new Room();
        room.setIdRoom(rs.getShort("idRoom"));
        room.setIdCategory(rs.getShort("idCategory"));
        room.setRoomName(rs.getString("roomName"));
        room.setRoomNumber(rs.getShort("roomNumber"));
        room.setStatus(rs.getBoolean("Status"));
        return room;
    }
}