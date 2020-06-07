package com.steadyman.todo.repository;

import com.steadyman.todo.entity.MemberEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class MemberRepositoryTest {

    @Autowired
    MemberRepository sut;

    @Test
    public void findById() {
        //given
        Long id = 1L;

        //when
        MemberEntity entity = sut.findById(id).orElse(null);

        //then
        Assertions.assertNotNull(entity);
    }
}
