package th.ac.ku.menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import th.ac.ku.menu.model.Menu;
import th.ac.ku.menu.repository.MenuRepository;

import java.util.List;
import java.util.UUID;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    public Menu create(Menu menu) {
        Menu record = menuRepository.save(menu);
        return record;
    }

    //เพิ่มการค้นด้วย id ใน service
    @GetMapping("/{id}")
    public Menu getMenuById(UUID id){
        return menuRepository.findById(id).get();
    }

    //เพิ่มการ update ใน MenuService class
    public Menu update(Menu requestBody) {
        UUID id = requestBody.getId();
        Menu record = menuRepository.findById(id).get();
        record.setName(requestBody.getName());
        record.setPrice(requestBody.getPrice());
        record.setCategory(requestBody.getCategory());

        record = menuRepository.save(record);
        return record;
    }

    //เพิ่มการ delete ใน MenuService
    public Menu delete(UUID id) {
        Menu record = menuRepository.findById(id).get();
        menuRepository.deleteById(id);
        return record;
    }

    //เพิ่มการค้นด้วย name และ category ใน service
    
    public Menu getMenuByName(String name) {
        return menuRepository.findByName(name);
    }

    public List<Menu> getMenuByCategory(String category) {
        return menuRepository.findByCategory(category);
    }




}


