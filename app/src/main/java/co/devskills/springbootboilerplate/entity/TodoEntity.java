package co.devskills.springbootboilerplate.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp; 
import java.time.LocalDateTime;
import co.devskills.springbootboilerplate.dto.ActionStatus;

@Entity
@Getter
@Setter
@Table(name = "TodoData")
@NoArgsConstructor
public class TodoEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActionStatus status;
    
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}