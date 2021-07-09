# CREATE USER 'adlister_admin'@'localhost' IDENTIFIED BY 'codeup';
# CREATE DATABASE adlister_db;
# GRANT ALL ON adlister_db TO 'adlister_admin'@'localhost';

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(50),
    email    VARCHAR(100) NOT NULL,
    password VARCHAR(50),
    PRIMARY KEY (id)

);

USE codeup_test_db;
DESCRIBE quote_topic;


USE adlister_db;

DROP TABLE IF EXISTS ads;
CREATE TABLE ads
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     INT UNSIGNED NOT NULL,
    title       VARCHAR(50)  NOT NULL,
    description VARCHAR(200),

    PRIMARY KEY (id),

        FOREIGN KEY (user_id) REFERENCES users (id)
ON DELETE CASCADE
);

# seeder stuff below
USE adlister_db;

TRUNCATE users;

INSERT INTO users (username, email, password)
VALUES ('testUser', 'testEmail@me.com', 'testPass'),
       ('2ndtestUser', '2ndtestEmail@me.com', '2ndtestPass');

TRUNCATE ads;

INSERT INTO ads (user_id, title, description)
VALUES (1,'playstation for sale','This is a slightly used playstation'),
       (1,'Super Nintendo','Get your game on with this old-school classic!'),
       (2,'Junior Java Developer Position','Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript'),
       (2,'JavaScript Developer needed','Must have strong Java skills');









