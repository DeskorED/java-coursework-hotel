package javavt18.controllers;

import javavt18.rooms.Category;
import javavt18.rooms.Room;
import javavt18.service.CategoryService;
import javavt18.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class JdbcController {

    private static final String INSTRUMENT = "rooms";
    private static final String TITLE = "SERG-HOTEL";

    @Autowired
    @Qualifier("CategoryJdbcService")
    private CategoryService CategoryService;

    @Autowired
    @Qualifier("RoomJdbcService")
    private RoomService RoomService;

    @RequestMapping(value = "/" + INSTRUMENT + "", method = RequestMethod.GET)
    public String printJdbc(ModelMap room) {
        room.addAttribute("title", TITLE);
        room.addAttribute("instrument", INSTRUMENT);

        List<Category> listCategory = CategoryService.list();
        List<Room> listRoom = RoomService.list();

        room.addAttribute("listRoom", listRoom);
        room.addAttribute("listCategory", listCategory);
        return "content";
    }

    //CRUD operations with CarBrand entity
    @RequestMapping(value = "/" + INSTRUMENT + "/newCategory", method = RequestMethod.GET)
    public String addCategory(ModelMap category) {
        category.addAttribute("title", TITLE);
        category.addAttribute("action", "Add new");

        Category Category = new Category();
        category.addAttribute("category", Category);

        return "CategoryForm";
    }

    @RequestMapping(value = {"/" + INSTRUMENT + "/newCategory"}, method = RequestMethod.POST)
    public String saveCategory(Category category) {

        CategoryService.saveOrUpdate(category);
        return "redirect:/" + INSTRUMENT;
    }

    @RequestMapping(value = {"/" + INSTRUMENT + "/delete-category/{idCategory}"}, method = RequestMethod.GET)
    public String deleteCategory(@PathVariable int idCategory) {
        CategoryService.delete(idCategory);
        return "redirect:/" + INSTRUMENT;
    }

    @RequestMapping(value = {"/" + INSTRUMENT + "/edit-category/{idCategory}"}, method = RequestMethod.GET)
    public String editCategory(@PathVariable int idCategory, ModelMap category) {
        category.addAttribute("title", TITLE);
        category.addAttribute("action", "Edit");

        Category cat = CategoryService.get(idCategory);
        category.addAttribute("category", cat);
        return "CategoryForm";
    }

    @RequestMapping(value = {"/" + INSTRUMENT + "/edit-category/{idCategory}"}, method = RequestMethod.POST)
    public String updateCategory(Category cat) {
        CategoryService.saveOrUpdate(cat);
        return "redirect:/" + INSTRUMENT;
    }

    //CRUD operations with CarModel entity
    @RequestMapping(value = "/" + INSTRUMENT + "/newRoom", method = RequestMethod.GET)
    public String addRoom(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Add new");

        Room room = new Room();
        model.addAttribute("room", room);

        List<Category> listCategory = CategoryService.list();
        model.addAttribute("listCategory", listCategory);

        return "RoomForm";
    }

    @RequestMapping(value = {"/" + INSTRUMENT + "/newRoom"}, method = RequestMethod.POST)
    public String saveRoom(Room room) {

        RoomService.saveOrUpdate(room);
        return "redirect:/" + INSTRUMENT;
    }

    @RequestMapping(value = {"/" + INSTRUMENT + "/delete-room/{idRoom}"}, method = RequestMethod.GET)
    public String deleteRoom(@PathVariable int idRoom) {
        RoomService.delete(idRoom);
        return "redirect:/" + INSTRUMENT;
    }

    @RequestMapping(value = {"/" + INSTRUMENT + "/edit-room/{idRoom}"}, method = RequestMethod.GET)
    public String editRoom(@PathVariable int idRoom, ModelMap rooms) {
        rooms.addAttribute("title", TITLE);
        rooms.addAttribute("action", "Edit");

        Room room = RoomService.get(idRoom);
        List<Category> listCategory = CategoryService.list();

        rooms.addAttribute("room", room);
        rooms.addAttribute("listCategory", listCategory);

        return "RoomForm";
    }

    @RequestMapping(value = {"/" + INSTRUMENT + "/edit-room/{idRoom}"}, method = RequestMethod.POST)
    public String updateRoom(Room room) {
        RoomService.saveOrUpdate(room);
        return "redirect:/" + INSTRUMENT;
    }

    @RequestMapping(value = {"/" + INSTRUMENT + "/pdfReport", "/" + INSTRUMENT + "/xlsxReport.xlsx"}, method = RequestMethod.GET)
    public ModelAndView downloadReport(@RequestParam("view") String view) {
        ModelAndView modelAndView = new ModelAndView();

        List<Category> listCategory = CategoryService.list();
        List<Room> listRoom = RoomService.list();
        // return a view which will be resolved by a ResourceBundleViewResolver
        modelAndView.addObject("Categories", listCategory);
        modelAndView.addObject("Rooms", listRoom);
        modelAndView.setViewName(view);

        return modelAndView;
    }
}