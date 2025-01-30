package com.example.feiyuan03.model;

import lombok.Data;
import javax.persistence.*;

/**
 * 点赞记录实体类
 */
@Data
@Entity
@Table(name = "likes")
public class Likes {
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
     * 动态ID
     */
    @Column(name = "dynamic_id", nullable = false)
    private int dynamicId;

    /**
     * 创建时间
     */
    @Column(name = "create_time", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createTime;
}