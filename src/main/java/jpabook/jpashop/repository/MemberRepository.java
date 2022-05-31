package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext //em은 jpa, spring에서 관리한다
    private EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){ //단건 조회
        return em.find(Member.class, id);

    }
    public List<Member> findAll(){ //jpql 공부해야함
        em.createQuery("select m from Member m",Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name){
        em.createQuery("select m from Member m where m.name:=name",Member.class)
                .setParameter("name",name).getResultList();}

}
