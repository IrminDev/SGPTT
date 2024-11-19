create table if not exists Person(
	person_id serial primary key,
	name varchar(50) not null,
	pathernal_surname varchar(50) not null,
	mathernal_surname varchar(50) not null,
	email varchar(100) unique not null,
	password varchar(50) not null,
	created_at timestamp not null default current_timestamp,
	is_enabled boolean not null default true
);


alter table Person add column person_key varchar(10) unique not null;

create type Career as enum('ISC', 'LCD', 'IA');

create table if not exists Student(
	career Career
) inherits (Person);

create table if not exists Academy(
	academy_id serial primary key,
	name varchar(100) not null
);

create table if not exists Professor(
	academy_id integer not null,
	school varchar(25) default 'ESCOM',
	constraint fk_professor_academy foreign key(academy_id) references Academy(academy_id) on update cascade on delete cascade
) inherits (Person);

create table if not exists CATT(
	role varchar(50),
	is_active boolean not null default true
) inherits (Person);

create type ProtocolState as enum('Pendiente', 'Aprobado', 'Rechazado');

create table if not exists Protocol(
	protocol_id serial primary key,
	title varchar(255) not null,
	keywords text not null,
	abstract text not null,
	pdf_file bytea not null,
	state ProtocolState,
	upload_at timestamp not null default current_timestamp
);

create table if not exists ChangeRequest(
	request_id serial primary key,
	format bytea not null,
	request_comments text not null,
	arrived_at timestamp not null,
	status ProtocolState,
	protocol_id serial not null,
	constraint fk_changerequest_protocol
	foreign key (protocol_id) references Protocol(protocol_id) on update cascade on delete cascade
);

create table if not exists ProtocolAcademy(
	academy_id integer not null,
	protocol_id integer not null,
	target_date timestamp,
	constraint fk_academy_protocol
	foreign key (academy_id) references Academy(academy_id) on update cascade on delete cascade,
	constraint fk_protocol_academy
	foreign key (protocol_id) references Protocol(protocol_id) on update cascade on delete cascade
);

create table if not exists ProtocolStudent(
	protocol_id serial not null,
	student_id serial not null,
	registration_date timestamp,
	constraint fk_protocol_student
	foreign key (protocol_id) references Protocol(protocol_id) on update cascade on delete cascade,
	constraint fk_student_protocol
	foreign key (student_id) references Person(person_id) on update cascade on delete cascade
);

create table if not exists Sinodal(
	protocol_id integer not null,
	target_date timestamp,
	constraint fk_protocol_sinodal
	foreign key (protocol_id) references Protocol(protocol_id) on update cascade on delete cascade
) inherits (Professor);

create table if not exists Activity(
	period_id serial primary key,
	open_date date,
	end_date date,
	activity text
);

create table if not exists Evaluation(
	evaluation_id serial primary key,
	sinodal_id integer not null,
	is_approved boolean not null default false,
	evaluation_comments text,
	evaluation_date timestamp,
	constraint fk_evaluation_sinodal
	foreign key (sinodal_id) references Person(person_id) on update cascade on delete cascade
);

create type CriterionResult as enum('Aprovado', 'Rechazado', 'Correciones');

create table if not exists Criterion(
	criterion_id serial primary key,
	criterion text,
	evaluation_id integer not null,
	results CriterionResult,
	criterion_comments text,
	evaluation_date timestamp,
	constraint fk_evaluation_criterion
	foreign key (evaluation_id) references Evaluation(evaluation_id) on update cascade on delete cascade
);