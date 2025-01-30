package com.example.feiyuan03.model;

import lombok.Data;
import javax.persistence.*;

/**
 * 学习记录实体类
 */
@Data
@Entity
@Table(name = "study_record")
public class StudyRecord {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 用户ID
     */
    @Column(name = "user_id", nullable = false)
    private int userId;

    /**
     * 学习时长
     */
    @Column(nullable = false)
    private int duration;

    /**
     * 学习任务
     */
    @Column(nullable = false)
    private String task;

    /**
     * 创建时间
     */
    @Column(name = "create_time", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createTime;
}