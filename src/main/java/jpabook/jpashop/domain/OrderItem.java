package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity //entity테이블서 기본1
@Getter@Setter //기본 2
public class OrderItem {
    @Id @GeneratedValue //기본 3
    @Column(name= "order_item_id") //기본 4: 주키 pk
    private Long id;

    @ManyToOne(fetch = LAZY) //fk에서 주인일때 Many투-
    @JoinColumn(name = "item_id") //다:일에서 일의 주키를 참조한다
    private Item item;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private  Order order;

    private int orderPrice; //주문가격
    private int count;  //주문수량
}
