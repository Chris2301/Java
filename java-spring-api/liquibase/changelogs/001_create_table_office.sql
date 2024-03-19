--liquibase formatted sql
--comment: creation of office table

CREATE SEQUENCE hotel.office_id_seq increment 1 start 1;

CREATE TABLE IF NOT EXISTS hotel.office
(
    id                      integer NOT NULL PRIMARY KEY,
    name                    text NOT NULL,
    employee_amount          integer NOT NULL
    );