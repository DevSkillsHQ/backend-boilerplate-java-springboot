package co.devskills.springbootboilerplate.mapper;

import co.devskills.springbootboilerplate.entity.TodoEntity;
import co.devskills.springbootboilerplate.dto.TodoResponse;


public final class TodoResponseMapper {
    private TodoResponseMapper() {
    }

    public static TodoResponse toResponse(TodoEntity todoEntity) {
        if (todoEntity == null) {
            return null;
        }
        return new TodoResponse(
                todoEntity.getId(),
                todoEntity.getName(),
                todoEntity.getDescription(),
                todoEntity.getStatus(),
                todoEntity.getCreatedAt()
        );
    }
}