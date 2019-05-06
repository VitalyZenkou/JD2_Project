CREATE DATABASE maven;

CREATE SCHEMA maven_intro;

CREATE TABLE "user"
(
    id   serial,
    name varchar(20) NOT NULL
);