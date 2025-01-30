CREATE DATABASE fy_admin_system;
USE fy_admin_system;

-- 用户表
CREATE TABLE fy_user (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         username VARCHAR(50) NOT NULL UNIQUE,
                         password VARCHAR(255) NOT NULL,
                         email VARCHAR(100) UNIQUE,
                         phone VARCHAR(20),
                         role ENUM('ADMIN', 'USER') DEFAULT 'USER',
                         status TINYINT(1) DEFAULT 1,
                         create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 角色表
CREATE TABLE fy_role (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         role_name VARCHAR(50) UNIQUE NOT NULL,
                         description VARCHAR(255),
                         create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 用户角色关联表
CREATE TABLE fy_user_role (
                              user_id INT NOT NULL,
                              role_id INT NOT NULL,
                              PRIMARY KEY (user_id, role_id),
                              FOREIGN KEY (user_id) REFERENCES fy_user(id) ON DELETE CASCADE,
                              FOREIGN KEY (role_id) REFERENCES fy_role(id) ON DELETE CASCADE
);

-- 权限表
CREATE TABLE fy_permission (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               permission_name VARCHAR(100) NOT NULL UNIQUE,
                               description VARCHAR(255),
                               create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 角色权限关联表
CREATE TABLE fy_role_permission (
                                    role_id INT NOT NULL,
                                    permission_id INT NOT NULL,
                                    PRIMARY KEY (role_id, permission_id),
                                    FOREIGN KEY (role_id) REFERENCES fy_role(id) ON DELETE CASCADE,
                                    FOREIGN KEY (permission_id) REFERENCES fy_permission(id) ON DELETE CASCADE
);

-- 操作日志表
CREATE TABLE fy_log (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        user_id INT,
                        action VARCHAR(255) NOT NULL,
                        ip_address VARCHAR(50),
                        create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (user_id) REFERENCES fy_user(id) ON DELETE SET NULL
);

-- 系统设置表
CREATE TABLE fy_settings (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             setting_key VARCHAR(100) NOT NULL UNIQUE,
                             setting_value TEXT NOT NULL,
                             description VARCHAR(255),
                             update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
