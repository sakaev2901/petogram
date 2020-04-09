package ru.itis.models;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "timestamp",  columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Timestamp timestamp;
    private String picName;

    @ManyToOne
    @ToString.Exclude
    private User user;

    
}
