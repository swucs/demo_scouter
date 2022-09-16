DROP TABLE IF exists user;

CREATE TABLE user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100),
    name VARCHAR(100),
    tel VARCHAR(30)
);
