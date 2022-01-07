package Carl.JPASHOP.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "roktask")
@Getter
@Setter
@ToString
public class Roktask {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO) // 컨트롤러로 안넣어줘도 JPA 구현체가 자동생성
    private Long usernumber;
    @Column
    private String name;
    @Column
    private String phonenumber;


}