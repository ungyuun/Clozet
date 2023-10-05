package com.clozet.model.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long prodNo;
    private String title;
    private String category;
    private String content;
    private String thumbnail;
    private List<String> imgUrl;
    private LocalDateTime createdDate;

    @Override
    public String toString() {

        return "ProductDto{" +
                "prodNo=" + prodNo +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", imgUrl=" + imgUrl +
                ", createdDate=" + createdDate +
                '}';
    }
}
