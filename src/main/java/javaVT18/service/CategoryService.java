package javavt18.service;

import javavt18.rooms.Category;
import java.util.List;

public interface CategoryService {

    void saveOrUpdate(Category item);

    void delete(int itemId);

    Category get(int itemId);

    List<Category> list();
}