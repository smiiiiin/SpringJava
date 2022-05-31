package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.LifecycleState;
import org.apache.tomcat.jni.Address;
import javax.persistence.*;
// import javax.persistence.criteria.Order; //이게 들어가면 안된다 !!!
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name= "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
    //컬랙션을 변경하지 말라. 있는 것을 그대로 써라 ?? 무슨 얘기 2회차에 보기
}
