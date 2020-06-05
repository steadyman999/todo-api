package com.steadyman.todo.service;

import com.steadyman.todo.dto.Todo;
import com.steadyman.todo.entity.TodoEntity;
import com.steadyman.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static util.StringUtils.sf;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo registerTodo(Todo todo) {
        TodoEntity entity = TodoEntity.of(todo.getMemberSeq(), todo.getContent());
        return Todo.from(todoRepository.save(entity));
    }

    public Todo editTodo(Todo todo) {
        TodoEntity todoEntity = todoRepository.findById(todo.getId()).orElse(null);
        if (Objects.isNull(todoEntity)) {
            throw new IllegalArgumentException(sf("Not found todo (id = {})", todo.getId()));
        }
        todoEntity.setTodoForEdit(todo.getContent());
        return Todo.from(todoRepository.save(todoEntity));
    }
}
