CREATE TABLE public.usuario (
	id bigserial NOT null primary key,
	name varchar(100) NOTNULL,
	age integer NOT NULL
);

CREATE TABLE public.posts (
	id bigserial NOT null primary key,
	mensagem varchar(100)  not NULL,
	dateTime timestamp NOT null,
	user_id bigint NOT NULL REFERENCES usuario(id)
);