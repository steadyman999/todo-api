package com.steadyman.todo.dto;

import com.steadyman.todo.entity.TodoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class Todo {
    private Long id;

    @NonNull
    @Setter
    private Long memberSeq;

    @NonNull
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

    public static Todo from(TodoEntity entity) {
        return new Todo(entity.getId(), entity.getMemberSeq(), entity.getContent(), entity.getCreatedAt(), entity.getUpdatedAt());
    }

    public static Todo of(Long memberSeq, String content) {
        return new Todo(memberSeq, content);
    }

}
