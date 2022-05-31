package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.junit.Test;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

//SpringBoot로 Test
//RunWith : JUnit한테 Spring 과 관련해서 테스트 할것 이라고 알려줌
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    //@Autowired를 통해 MemberRepository 인젝션 받음
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() throws Exception{
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        //Ctrl + Alt + V : 변수 자동 생성 단축키
        Long saveId = memberRepository.save(member);
        //save 한 것 이 잘 저장되었는지 확인
        Member findMember = memberRepository.findOne(saveId);

        //then
        //검증
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member);
        System.out.println("findMember == member:"+ (findMember == member));

    }
}