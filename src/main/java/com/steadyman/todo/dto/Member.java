package com.steadyman.todo.dto;

import com.steadyman.todo.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class Member {
    private Long id;

    private String email;

    private String nickname;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Member(Long id, String email, String nickname, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Member from(MemberEntity memberEntity) {
        return new Member(memberEntity.getId(), memberEntity.getEmail(), memberEntity.getNickname(), memberEntity.getCreatedAt(), memberEntity.getUpdatedAt());
    }
}
