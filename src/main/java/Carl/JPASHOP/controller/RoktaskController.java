package Carl.JPASHOP.controller;


import Carl.JPASHOP.domain.Roktask;
import Carl.JPASHOP.repository.HwanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @controller는 html로 응답함.
// Restcontroller는 사용자가 요청시 data로 응답해줌
@RestController
@RequestMapping(value = "/api")
public class RoktaskController {

    @Autowired // 오토와이어드 작업 안하면 빈 주입 안되어서 작동 안한다. 레파지토리에 빈 주입
    HwanRepository hwanRepository;

    // 글의 아이디를 넘기면 내용이 나오게 하는 기능을 구현한다.
    // 지금 만든 기능으로 예를 들면 1번을 누르면 이름이랑 폰넘버가 나오게 하는 기능.
    // 주소창에 find/id=1 이렇게 입력하면 1번 사용자가 나오고 이런 기능을 구현하는거임.


    @GetMapping(value = "/create") // select
    public String create() {
        Roktask roktask = new Roktask();
        roktask.setName("Hwan");
        roktask.setPhonenumber("010-3392-7642");
        Roktask newRoktask = hwanRepository.save(roktask);
        return "DB insert ok";
    }

    @GetMapping(value = "/webinsert")
    public Roktask httpparam(
            @RequestParam(value = "name", defaultValue = "50") String name,
            @RequestParam(value = "phone", defaultValue = "50") String phone
    ) {
        Roktask roktask = new Roktask();
        roktask.setName(name);
        roktask.setPhonenumber(phone);
        Roktask newRoktask = hwanRepository.save(roktask);
        return roktask;
    }
    // 주소창에 특정 파라메터 입력하면 mysql db에 저장되는 기능을 만들라.
    // 주소칸에 입력을 하면 스프링부트가 받고 받은 파라미터를 디비로 넘기면 되는 것.

    @GetMapping(value = "/find")
    public List<Roktask> findByname() {
        this.create();
        List<Roktask> roktaskList = hwanRepository.findByname("Hwan");
        for (Roktask roktask : roktaskList) {
            System.out.println(roktask.toString()); // 조회로 얻은 객체 한 줄 출력하기
        }
        return roktaskList;
    }


    @PostMapping(value = "/http/get") // insert
    public String updatTest(){
        return "insert 요청";
    }
    // 인터넷 브라우저 요청은 get요청 밖에 안돼.
    // update, delete, read 다 안됨. 오로지 겟만
    @PutMapping(value = "/http/put")  // update
    public String putTest() {
        return "update 요청";
    }

    @DeleteMapping(value = "/http/delete") // delete
    public String deleteTest() {
        return "delete 요청";
    }
}
//    @GetMapping(value = "/insert")
//    public Roktask creattalbe() {
//        Roktask roktask = new Roktask();
//        roktask.setName("Hwan");
//        roktask.setPhonenumber("010-3392-7642");
//        Roktask saveRoktask = hwanRepository.save(roktask);
//
//        return saveRoktask;
