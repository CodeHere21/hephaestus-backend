

CREATE TABLE COMMENT(
    ID INT NOT NULL AUTO_INCREMENT,
    BODY VARCHAR2(500) NOT NULL DEFAULT '',
    AUTHOR VARCHAR2(255) NOT NULL DEFAULT '',
    WRITTEN_ON DATE DEFAULT NULL,
    POST_ID SMALLINT DEFAULT NULL,
    PRIMARY KEY (ID));



CREATE TABLE POST (
    ID INT NOT NULL AUTO_INCREMENT,
    TITLE VARCHAR2(255) NOT NULL DEFAULT '',
    BODY VARCHAR2(3000) NOT NULL DEFAULT '',
    AUTHOR VARCHAR2(255) NOT NULL DEFAULT '',
    PUBLISHED DATE DEFAULT NULL,
    PRIMARY KEY (ID));

CREATE TABLE TAG(
    ID INT NOT NULL AUTO_INCREMENT,
    LABEL VARCHAR2(50) NOT NULL DEFAULT '',
    POST_ID INT DEFAULT NULL,
    PRIMARY KEY(ID));



CREATE SEQUENCE hibernate_sequence;