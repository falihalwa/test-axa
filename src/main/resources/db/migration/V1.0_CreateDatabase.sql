-- Database: test_axa_db

-- DROP DATABASE IF EXISTS test_axa_db;

CREATE DATABASE test_axa_db
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en-US'
    LC_CTYPE = 'en-US'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

create table users (
	user_id serial primary key,
	username text not null,
	password text not null
)

create table roles (
	role_id serial primary key,
	role_name text not null
)

CREATE TYPE permission_type AS ENUM ('READ', 'WRITE');

create table pemissions (
	permission_id serial primary key,
	permission permission_type not null
)