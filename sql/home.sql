CREATE DATABASE study_room;
USE study_room;

-- 用户表
CREATE TABLE user (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      nickname VARCHAR(50) NOT NULL,
                      email VARCHAR(100) UNIQUE NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      avatar VARCHAR(255),
                      create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 学习记录表
CREATE TABLE study_record (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              user_id INT NOT NULL,
                              duration INT NOT NULL,
                              task VARCHAR(255) NOT NULL,
                              create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
);

-- 学习动态表
CREATE TABLE study_dynamic (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               user_id INT NOT NULL,
                               content TEXT NOT NULL,
                               image VARCHAR(255),
                               create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
);

-- 排行榜表
CREATE TABLE ranking (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         user_id INT NOT NULL,
                         total_study_time INT NOT NULL DEFAULT 0,
                         last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
);

-- 记事本表
CREATE TABLE notebook (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          user_id INT NOT NULL,
                          note TEXT NOT NULL,
                          create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
);

-- 点赞表
CREATE TABLE likes (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       user_id INT NOT NULL,
                       dynamic_id INT NOT NULL,
                       create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
                       FOREIGN KEY (dynamic_id) REFERENCES study_dynamic(id) ON DELETE CASCADE
);

-- 关注表
CREATE TABLE follow (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        follower_id INT NOT NULL,
                        following_id INT NOT NULL,
                        create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (follower_id) REFERENCES user(id) ON DELETE CASCADE,
                        FOREIGN KEY (following_id) REFERENCES user(id) ON DELETE CASCADE
);

-- 初始化管理员账号
INSERT INTO user (nickname, email, password) VALUES ('Admin', 'admin@example.com', 'admin123');
