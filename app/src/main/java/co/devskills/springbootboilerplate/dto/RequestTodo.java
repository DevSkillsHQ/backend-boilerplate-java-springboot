package co.devskills.springbootboilerplate.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record RequestTodo(
    @NotBlank @Size(max = 120) 
    String name,
    
    @NotBlank @Size(max = 500) 
    String description,

    @NotNull(message = "Use valid states: ACTIVE, PENDING, EXPIRED, COMPLETED")
    ActionStatus status
){}