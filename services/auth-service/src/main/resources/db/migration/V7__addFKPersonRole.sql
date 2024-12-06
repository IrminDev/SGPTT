insert into role(role_id, name) values(1, 'Estudiante') on conflict(name) do nothing;
insert into role(role_id, name) values(2, 'Profesor') on conflict(name) do nothing;
insert into role(role_id, name) values(3, 'CATT') on conflict(name) do nothing;

alter table person add column if not exists role_id integer not null default 1;

alter table person drop constraint if exists fk_person_role;
alter table person add constraint fk_person_role foreign key (role_id) references role(role_id)
on update cascade
on delete cascade;

