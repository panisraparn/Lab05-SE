package th.ac.ku.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.menu.model.Menu;
import th.ac.ku.menu.service.MenuService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService service;

    @GetMapping
    public List<Menu> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Menu create(@RequestBody Menu menu) {
        return service.create(menu);
    }

    //เพิ่ม get mapping ที่รับ path variable เป็น name
    @GetMapping("/{id}")
    public Menu getMenuById(@PathVariable UUID id) {
        return service.getMenuById(id);
    }

    //เพิ่ม put mapping ที่รับ request body ใน MenuController
    @PutMapping
    public Menu update(@RequestBody Menu menu) {
        return service.update(menu);
    }

    //เพิ่ม delete mapping ที่รับ path variable เป็น id ใน MenuController
    @DeleteMapping("/{id}")
    public Menu delete(@PathVariable UUID id) {
        return service.delete(id);
    }

    //เพิ่ม get mapping ที่รับ path variable เป็น name และ category
    @GetMapping("/name/{name}")
    public Menu getMenuByName(@PathVariable String name) {
        return service.getMenuByName(name);
    }

    @GetMapping("/category/{category}")
    public List<Menu> getMenuByCategory(@PathVariable String category) {
        return service.getMenuByCategory(category);
    }


}

