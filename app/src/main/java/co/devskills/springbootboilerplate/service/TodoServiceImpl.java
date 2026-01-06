package co.devskills.springbootboilerplate.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.devskills.springbootboilerplate.dto.ActionStatus;
import co.devskills.springbootboilerplate.dto.RequestTodo;
import co.devskills.springbootboilerplate.entity.TodoEntity;
import co.devskills.springbootboilerplate.error.NotFoundException;
import co.devskills.springbootboilerplate.repository.TodoRepository;
import co.devskills.springbootboilerplate.dto.UpdateTodoRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class TodoServiceImpl implements TodoService{
    private final TodoRepository todoRepository;


    public TodoServiceImpl(final TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Transactional(readOnly = true) 
    public TodoEntity getTodo(Long id){
        return todoRepository.findById(id).orElseThrow(() -> new NotFoundException("Todo not found"));
    }

    @Transactional
    public TodoEntity save(RequestTodo requestTodo){
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setName(requestTodo.name());
        todoEntity.setDescription(requestTodo.description());
        todoEntity.setStatus(ActionStatus.PENDING);
        return todoRepository.save(todoEntity);
    }

    @Transactional(readOnly = true)
    public Page<TodoEntity> getTodos(Pageable pageable){
        return todoRepository.findAll(pageable);
    }

    @Transactional
    public TodoEntity updateTodo(Long id, UpdateTodoRequest updateTodoRequest){
        TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(() -> new NotFoundException("Todo not found"));
        todoEntity.setName(updateTodoRequest.name());
        todoEntity.setDescription(updateTodoRequest.description());
        todoEntity.setStatus(updateTodoRequest.status());
        return todoRepository.save(todoEntity);     
    }

    @Transactional
    public void deleteTodo(Long id){
        TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(() -> new NotFoundException("Todo not found"));
        todoRepository.delete(todoEntity);  
    }
}