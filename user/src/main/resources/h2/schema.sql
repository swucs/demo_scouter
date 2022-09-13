DROP TABLE IF exists user;

CREATE TABLE user (
    id BIGINT PRIMARY KEY,
    email VARCHAR(30),
    name VARCHAR(30),
    tel VARCHAR(30)
);
