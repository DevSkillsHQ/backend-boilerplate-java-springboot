package co.devskills.springbootboilerplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;   

import co.devskills.springbootboilerplate.entity.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long>{

}
