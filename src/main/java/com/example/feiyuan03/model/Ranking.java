package com.example.feiyuan03.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "ranking")
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "total_study_time", nullable = false)
    private int totalStudyTime;

    @Column(name = "last_update", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date lastUpdate;
}