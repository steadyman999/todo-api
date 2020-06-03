package com.steadyman.todo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "TODO")
public class TodoEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MEMBER_SEQ")
    private Long memberSeq;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "CREATED_AT", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    private TodoEntity(Long memberSeq, String content, LocalDateTime updatedAt) {
        this.memberSeq = memberSeq;
        this.content = content;
        this.updatedAt = updatedAt;
    }

    public static TodoEntity of(Long memberSeq, String content) {
        return new TodoEntity(memberSeq, content, null);
    }
}
