package org.kiworkshop.community.User.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kiworkshop.community.post.domain.Post;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    private String name;
    private String password;
    private String email;

    @OneToMany
    @JoinColumn(name = "USER_ID")
    private List<Post> posts = new ArrayList<>();

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
