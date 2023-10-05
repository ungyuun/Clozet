package com.clozet.model.entity;




import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @Column(length = 30)
    private String userId;

    @Column(length = 100)
    private String commentContent;
    @Column(length = 30)
    private String password;

    private Long prodNo;
    private Timestamp regDate;
    private Long recommend;

    public Comment(Long commentNo, String userId, String commentContent, String password, Long prodNo, Timestamp regDate, Long recommend) {
        this.commentNo = commentNo;
        this.userId = userId;
        this.commentContent = commentContent;
        this.password = password;
        this.prodNo = prodNo;
        this.regDate = regDate;
        this.recommend = recommend;
    }

    public Comment() {

    }

}
