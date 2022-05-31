package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
@Embeddable
@Getter //setter를 쓰지 않음으로써 값을 변경 불가능하게 만들자
public class Address {
    private String city;
    private String street;
    private String zipcode;
    protected  Address(){}

    //Embedded 타입은 public
    public Address(String city,String street, String  zipcode){
        this.city= city;
        this.street= street;
        this.zipcode= zipcode;}

}
