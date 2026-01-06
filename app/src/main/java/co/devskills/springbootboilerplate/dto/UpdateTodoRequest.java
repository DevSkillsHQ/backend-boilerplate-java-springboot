package co.devskills.springbootboilerplate.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

public record UpdateTodoRequest(
        @NotBlank @Size(max = 120) 
        String name,
        @Size(max = 500) 
        String description,
        @NotNull(message = "Use valid states: ACTIVE, PENDING, EXPIRED, COMPLETED")
        ActionStatus status
) {}