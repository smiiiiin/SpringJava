package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter@Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name= "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)//
    //자동으로 숫자가 붙는다: ORDINAL은 중간에 삽입이 안된다
    //반드시 STRING으로 해야한다. READY, COMP
    private  DeliveryStatus status;



}
