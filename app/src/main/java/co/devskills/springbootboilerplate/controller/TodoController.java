package co.devskills.springbootboilerplate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.devskills.springbootboilerplate.dto.RequestTodo;
import co.devskills.springbootboilerplate.entity.TodoEntity;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import co.devskills.springbootboilerplate.dto.TodoResponse;
import co.devskills.springbootboilerplate.dto.UpdateTodoRequest;
import co.devskills.springbootboilerplate.mapper.TodoResponseMapper;
import co.devskills.springbootboilerplate.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    public final TodoService todoService;

    public TodoController(final TodoService todoService) {
        this.todoService = todoService;
    }


    @PostMapping
    public ResponseEntity<TodoResponse> createTodo(@RequestBody RequestTodo requestTodo){
        TodoEntity createdTodo = todoService.save(requestTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(TodoResponseMapper.toResponse(createdTodo));
    }



    @GetMapping
    public Page<TodoResponse> getTodos(@PageableDefault(size = 20) Pageable pageable){
        return todoService.getTodos(pageable).map(TodoResponseMapper::toResponse);

    }


    @GetMapping(value="/{id}")
    public ResponseEntity<TodoResponse> getTodo(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(
                TodoResponseMapper.toResponse(todoService.getTodo(id)));
    }


    @PutMapping(value="/{id}")
    public ResponseEntity<TodoResponse> putTodoItem(@PathVariable("id") Long id,
                                                    @Valid @RequestBody UpdateTodoRequest updateTodoRequest){
            return ResponseEntity.status(HttpStatus.OK).body(
                TodoResponseMapper.toResponse(todoService.updateTodo(id, updateTodoRequest))
            );
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteTodos(@PathVariable("id") Long id){
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
