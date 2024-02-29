package org.belotelov.hw05.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    @Column
    @Enumerated
    private Status status;
    @Column
    private LocalDateTime timeOfCreation = LocalDateTime.now();

}
