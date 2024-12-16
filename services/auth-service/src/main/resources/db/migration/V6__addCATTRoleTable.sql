create table if not exists catt_role(
    catt_role_id serial primary key,
    catt_role_name varchar(15) not null
);

insert into catt_role(catt_role_id, catt_role_name)
values (1, 'Coordinador'),
(2, 'Asistente'),
(3, 'Administrador'),
(4, 'Secretario') on conflict (catt_role_id) do nothing;

alter table catt drop constraint if exists fk_catt_role;

alter table catt drop constraint if exists fk_catt_catt_role;

alter table catt add constraint fk_catt_catt_role foreign key(role_id)
references catt_role(catt_role_id) on update cascade on delete cascade;