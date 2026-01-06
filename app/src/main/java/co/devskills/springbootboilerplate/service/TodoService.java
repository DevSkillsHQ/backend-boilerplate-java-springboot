package co.devskills.springbootboilerplate.service;

import co.devskills.springbootboilerplate.entity.TodoEntity;
import co.devskills.springbootboilerplate.dto.RequestTodo;
import co.devskills.springbootboilerplate.dto.UpdateTodoRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TodoService{
    TodoEntity getTodo(Long id);
    
    TodoEntity save(RequestTodo requestTodo);

    Page<TodoEntity> getTodos(Pageable pageable);

    TodoEntity updateTodo(Long id, UpdateTodoRequest updateTodoRequest);

    void deleteTodo(Long id);

}