package com.clozet.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter @Getter
@EntityListeners(AuditingEntityListener.class)
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String size;
    private Long amount;

    @ManyToOne @JsonIgnore
    @JoinColumn(name = "email")
    private User user;

    @ManyToOne @JsonIgnore
    @JoinColumn(name="prodNo")
    private Product product;
}
