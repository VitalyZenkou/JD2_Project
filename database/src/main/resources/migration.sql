CREATE DATABASE payment_system;

CREATE SCHEMA payment_system_storage;

SET SEARCH_PATH = payment_system_storage;

CREATE TABLE "user"
(
    id         bigserial PRIMARY KEY,
    login      varchar(50)  NOT NULL UNIQUE,
    password   varchar(300) NOT NULL,
    name       varchar(50)  NOT NULL,
    surname    varchar(50)  NOT NULL,
    birth_date date         NOT NULL,
    UNIQUE (name, surname)
);

CREATE TABLE role
(
    id   bigserial PRIMARY KEY,
    name varchar(20) NOT NULL UNIQUE
);

CREATE TABLE user_role
(
    user_id bigint,
    role_id bigint,
    FOREIGN KEY (user_id) REFERENCES "user" (id),
    FOREIGN KEY (role_id) REFERENCES role (id),
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE address
(
    id           bigserial PRIMARY KEY,
    user_id      bigint       NOT NULL,
    city         varchar(50)  NOT NULL,
    street       varchar(128) NOT NULL,
    house_number int          NOT NULL,
    flat_number  int,
    phone_number varchar(20),
    email        varchar(100) NOT NULL UNIQUE,
    FOREIGN KEY (user_id) REFERENCES "user" (id),
    UNIQUE (city, street, house_number, phone_number)
);

CREATE TABLE bank_account
(
    id         bigserial PRIMARY KEY,
    user_id    bigint         NOT NULL,
    balance    numeric(10, 2) NOT NUlL DEFAULT 0.00,
    is_blocked boolean        NOT NULL DEFAULT false,
    currency   varchar(3)     NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user" (id)
);

CREATE TABLE credit_card
(
    id               bigserial PRIMARY KEY,
    account_id       bigint      NOT NULL,
    number           varchar(50) NOT NULL UNIQUE,
    validity_date    varchar(50) NOT NULL,
    pin_code         smallint    NOT NULL,
    cvv              smallint    NOT NULL,
    is_blocked       boolean     NOT NULL DEFAULT false,
    credit_card_type varchar(20) NOT NULL,
    FOREIGN KEY (account_id) REFERENCES bank_account (id)
);

CREATE TABLE payment
(
    id                    bigserial PRIMARY KEY,
    user_id               bigint         NOT NULL,
    credit_card_id        bigint         NOT NULL,
    cost                  decimal(10, 2) NOT NULL DEFAULT 0.00,
    organization          varchar(128)   NOT NULL DEFAULT '',
    to_credit_card_number varchar(50)    NOT NULL DEFAULT '',
    is_transaction        boolean        NOT NULL DEFAULT false,
    FOREIGN KEY (user_id) REFERENCES "user" (id),
    FOREIGN KEY (credit_card_id) REFERENCES credit_card (id)

);

DROP TABLE "user" CASCADE;

DROP TABLE address CASCADE;

DROP TABLE credit_card CASCADE;

DROP TABLE payment CASCADE;

DROP TABLE role CASCADE;

DROP TABLE user_role CASCADE;

DROP TABLE bank_account CASCADE;