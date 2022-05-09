package com.todo.todoapi.domain.todo.entity;

import com.todo.todoapi.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@ToString
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Boolean completed;

    public static Todo create(Todo todo) {
        return Todo.builder()
                .name(todo.getName())
                .completed(todo.getCompleted())
                .build();
    }

    public void update(Todo todo) {
        this.name = todo.getName();
        this.completed = todo.getCompleted();
    }

}
