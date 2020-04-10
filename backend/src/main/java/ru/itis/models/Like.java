package ru.itis.models;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private User user;
    @OneToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Post post;
}
