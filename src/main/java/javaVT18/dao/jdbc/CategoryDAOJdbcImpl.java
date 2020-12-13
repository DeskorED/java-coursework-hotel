package javavt18.dao.jdbc;

import javavt18.dao.CategoryDAO;
import javavt18.rooms.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryDAOJdbcImpl implements CategoryDAO {
    @Autowired
    @Qualifier("getCategoryJdbcDAO")

    private JdbcTemplate jdbcTemplate;

    public CategoryDAOJdbcImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveOrUpdate(Category item) {
        if (item.getIdModel() > 0) {
            // update
            String sql = "UPDATE category SET Name=?, numberOfPlaces=?, Wifi=?, Breakfast=?, Dinner=?, Jacuzzi=?, TV=?, Price=? WHERE idCategory=?";
            jdbcTemplate.update(sql, item.getNumberOfPlaces(), item.isWifi(),item.isBreakfast(),
                    item.isDinner(), item.isJacuzzi(), item.isTv(), item.getPrice(), item.getIdCategory());
        } else {
            // insert
            String sql = "INSERT INTO category (numberOfPlaces, Wifi, Breakfast, Dinner, Jacuzzi, TV,Price)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, item.getNumberOfPlaces(), item.isWifi(),item.isBreakfast(),
                    item.isDinner(), item.isJacuzzi(), item.isTv(), item.getPrice());
        }
    }

    public void delete(int itemId) {
        String sql = "DELETE FROM category WHERE idCategory=?";
        jdbcTemplate.update(sql, itemId);
    }

    public Category get(int itemId) {
        String sql = "SELECT * FROM category WHERE idCategory=" + itemId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Category>() {

            public Category extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    return getCategoryFromDB(rs);
                }
                return null;
            }
        });
    }

    public List<Category> list() {
        String sql = "SELECT * FROM category";
        List<Category> listCategory = jdbcTemplate.query(sql, new RowMapper<Category>() {

            public Category mapRow(ResultSet rs, int i) throws SQLException {

                return getCategoryFromDB(rs);
            }
        });
        return listCategory;
    }

    private Category getCategoryFromDB(ResultSet rs) throws SQLException{
        Category category = new Category();
        category.setBreakfast(rs.getBoolean("Breakfast"));
        category.setDinner(rs.getBoolean("idDinner"));
        category.setJacuzzi(rs.getBoolean("Jacuzzi"));
        category.setName(rs.getString("Name"));
        category.setTv(rs.getBoolean("TV"));
        category.setPrice(rs.getShort("Price"));
        category.setNumberOfPlaces(rs.getByte("numberOfPlaces"));
        category.setWifi(rs.getByte("Wifi"));
        category.setIdCategory(rs.getShort("idCategory"));
        return category;
    }
}