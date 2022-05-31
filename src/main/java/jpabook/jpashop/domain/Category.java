package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

//야 이거 진짜 카테고리부문 너무 어렵다 :)
@Entity
@Getter @Setter
public class Category {
    @Id @GeneratedValue
    @Column(name="category_id")
    private Long id;
    private String name;

    @ManyToMany
    // 다:다는 1:다로 만들려고 중간테이블이 필요해서 JoinColumn이 아니라 JoinTable이다
    @JoinTable(name= "category_item",
                joinColumns = @JoinColumn(name="category_id"),
                inverseJoinColumns = @JoinColumn(name= "item_id"))
    private List<Item> items= new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child= new ArrayList<>();

    //==연관관계 메서드==//
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }

}
