package com.rod.api.article;

import com.rod.api.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "articles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Article {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @Column(name = "register_date")
    private String registerDate;

    @ManyToOne
    @JoinColumn
    private User writer;



    @Builder(builderMethodName = "builder")
    public Article(Long id, String title, String content, User writer, String registerDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.registerDate = registerDate;
    }
}