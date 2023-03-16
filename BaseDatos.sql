DROP TABLE IF EXISTS client;
CREATE TABLE client
(
    "client_id" LONG PRIMARY KEY AUTO_INCREMENT,
    "password"  VARCHAR(20),
    "status"    BOOLEAN,
    PRIMARY KEY ("client_id")
);

DROP TABLE IF EXISTS person;
CREATE TABLE person
(
    "person_id"    LONG PRIMARY KEY AUTO_INCREMENT,
    "name"           VARCHAR(128) NOT NULL,
    "gender"         VARCHAR(20),
    "age "           INT,
    "identification" VARCHAR(12),
    "address"        VARCHAR(128),
    "phone"          VARCHAR(10),
    PRIMARY KEY ("person_id")
);

