package com.steadyman.todo.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Todo {
    private Long id;
    private Long memberSeq;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
