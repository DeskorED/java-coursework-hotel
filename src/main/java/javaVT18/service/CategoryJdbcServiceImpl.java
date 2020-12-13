package javavt18.service;

import javavt18.dao.CategoryDAO;
import javavt18.rooms.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("carBrandJdbcService")
public class CategoryJdbcServiceImpl implements CategoryService {
    @Autowired
    @Qualifier("getCategoryJdbcDAO")
    private CategoryDAO CategoryDAO;

    public void saveOrUpdate(Category item) {
        CategoryDAO.saveOrUpdate(item);
    }

    public void delete(int itemId) {
        CategoryDAO.delete(itemId);
    }

    public Category get(int itemId) {
        return CategoryDAO.get(itemId);
    }

    public List<Category> list() {
        return CategoryDAO.list();
    }
}