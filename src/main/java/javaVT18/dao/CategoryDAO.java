package javavt18.dao;

import javavt18.rooms.Category;
import java.util.List;

public interface CategoryDAO{

    void saveOrUpdate(Category item);

    void delete(int itemId);

    Category get(int itemId);

    List<Category> list();

}
