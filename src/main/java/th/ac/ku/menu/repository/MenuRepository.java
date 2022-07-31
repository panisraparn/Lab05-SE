package th.ac.ku.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.ku.menu.model.Menu;

import java.util.List;
import java.util.UUID;

@Repository
public interface MenuRepository extends JpaRepository<Menu, UUID> {
    //เพิ่มการ query ด้วย name หรือ category ใน Repository
    //(ตั้งสมมติฐานว่า ชื่อเมนูอาหาร นั้น unique)
    //ถ้า query ด้วย attribute ใน class เราแค่ประกาศ findByAttribute() ก็พอแล้ว Spring จะ implement ให้อัตโนมัติ

    Menu findByName(String name);
    List<Menu> findByCategory(String category);

}
