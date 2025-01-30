package com.example.feiyuan03.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "study_dynamic")
public class StudyDynamic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(nullable = false)
    private String content;

    private String image;

    @Column(name = "create_time", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createTime;
}