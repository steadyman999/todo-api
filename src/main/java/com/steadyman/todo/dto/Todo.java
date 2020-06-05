package com.steadyman.todo.dto;

import com.steadyman.todo.entity.TodoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class Todo {
    private Long id;

    @Setter
    private Long memberSeq;

    @Setter
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Todo(Long id, Long memberSeq, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.memberSeq = memberSeq;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private Todo(Long id, Long memberSeq, String content) {
        this.id = id;
        this.memberSeq = memberSeq;
        this.content = content;
    }

    private Todo(Long memberSeq, String content) {
        this.memberSeq = memberSeq;
        this.content = content;
    }

    public static Todo from(TodoEntity entity) {
        return new Todo(entity.getId(), entity.getMemberSeq(), entity.getContent(), entity.getCreatedAt(), entity.getUpdatedAt());
    }

    public static Todo of(Long id, Long memberSeq, String content) {
        return new Todo(id, memberSeq, content);
    }

    public static Todo of(Long memberSeq, String content) {
        return new Todo(memberSeq, content);
    }

}
