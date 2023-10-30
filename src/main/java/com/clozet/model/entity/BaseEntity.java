package com.clozet.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
@Setter
abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    public LocalDate regDate;

    @PrePersist
    public void onPrePersist() {
        this.regDate = LocalDate.now();
    }
}