package com.clozet.model.entity;


import com.clozet.model.dto.ImageDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodNo;
    private String title;
    private String category;
    @Column(length = 1000)
    private String content;
    @ElementCollection
    @CollectionTable(name = "image")
    private List<String> imgUrl = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name="prodNo")
    private List<ProductDetail> productDetail = new ArrayList<>();
    private Long price;
    private String thumbnail;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime createdDate;

    @OneToMany
    @JoinColumn(name = "prodNo", referencedColumnName = "prodNo")
    private List<Cart> carts;

    @Override
    public String toString() {
        return "Product{" +
                "prodNo=" + prodNo +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                ", imgUrl=" + imgUrl +
                ", productDetail=" + productDetail +
                ", thumbnail='" + thumbnail + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
