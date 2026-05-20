-- Create DB (run if not exists)
CREATE DATABASE IF NOT EXISTS ssm_demo CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE ssm_demo;

-- users
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- commodity
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  stock INT NOT NULL,
  description TEXT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- order table
DROP TABLE IF EXISTS `order_table`;
CREATE TABLE `order_table` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  commodity_id INT NOT NULL,
  quantity INT NOT NULL,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_order_user FOREIGN KEY (user_id) REFERENCES `user`(id) ON DELETE CASCADE,
  CONSTRAINT fk_order_commodity FOREIGN KEY (commodity_id) REFERENCES `commodity`(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- sample data
INSERT INTO `user` (username, password) VALUES
('alice', 'pass1'),
('bob', 'pass2');

INSERT INTO `commodity` (name, price, stock, description) VALUES
('商品A', 99.00, 10, '示例商品A 描述'),
('商品B', 199.00, 5, '示例商品B 描述'),
('商品C', 299.00, 2, '示例商品C 描述'),
('商品D', 49.99, 20, '示例商品D 描述'),
('商品E', 9.99, 50, '示例商品E 描述'),
('商品F', 19.99, 30, '示例商品F 描述');
