package com.example.feiyuan03.model;

import lombok.Data;
import javax.persistence.*;

/**
 * 笔记本实体类
 */
@Data
@Entity
@Table(name = "notebook")
public class Notebook {
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
     * 笔记内容
     */
    @Column(nullable = false)
    private String note;

    /**
     * 创建时间
     */
    @Column(name = "create_time", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createTime;
}