package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.nio.MappedByteBuffer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.BatchSize;
import static javax.persistence.FetchType.LAZY;

@Entity //기본1
@Table(name="orders")
@Getter @Setter //기본2
public class Order {

    @Id @GeneratedValue //기본3
    @Column(name="order_id") //pk 주키
    private Long id;

    @ManyToOne(fetch = LAZY)//many- 내가 주인이다 어노테이션(@)을 JoinColumn을 이용
    @JoinColumn(name= "member_id") // 당하는(읽기전용:거울) 테이블의 주키
    private Member member;

    //@JsonIgnore
    @OneToMany(mappedBy= "order", cascade = CascadeType.ALL) //One내가 one이라 읽기전용
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="delivery_id") //fk 주인의 어노테이션(@)은
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;//주문 상태: 주문 or 취소

    //==연관관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery= delivery;
        delivery.setOrder(this);
    }


}
