CREATE TABLE users(
    id INT PRIMARY KEY,
    login VARCHAR(32),
    password VARCHAR(32)
);

CREATE TABLE granted_authorities (
    user_id INT,
    role VARCHAR(10),
    primary key (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users(id)
);