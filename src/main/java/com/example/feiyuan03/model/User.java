package com.example.feiyuan03.model;

import lombok.Data;
import javax.persistence.*;

/**
 * 用户实体类
 */
@Data
@Entity
@Table(name = "user")
public class User {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 昵称
     */
    @Column(nullable = false)
    private String nickname;

    /**
     * 邮箱
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * 密码
     */
    @Column(nullable = false)
    private String password;

    /**
     * 头像URL
     */
    private String avatar;

    /**
     * 创建时间
     */
    @Column(name = "create_time", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createTime;
}