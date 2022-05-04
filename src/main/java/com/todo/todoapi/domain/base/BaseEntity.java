package com.todo.todoapi.domain.base;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@EntityListeners(value = {AuditingEntityListener.class})
@Getter
@MappedSuperclass
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Instant createTime;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updateTime;

}
