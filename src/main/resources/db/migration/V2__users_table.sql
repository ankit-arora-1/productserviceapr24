CREATE TABLE users
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NULL,
    updated_at datetime NULL,
    is_deleted BIT(1) NOT NULL,
    title      VARCHAR(255) NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);



