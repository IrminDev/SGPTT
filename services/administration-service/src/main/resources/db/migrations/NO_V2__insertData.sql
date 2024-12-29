create
extension if not exists pgcrypto;
--Personas
INSERT INTO Person (person_id, name, paternal_surname, maternal_surname, email, password, created_at)
VALUES (1, 'Juan', 'Pérez', 'García', 'juan.perez@example.com',
        crypt('password1', gen_salt('md5')), current_timestamp),
       (2, 'María', 'López', 'Martínez', 'maria.lopez@example.com',
        crypt('password2', gen_salt('md5')), current_timestamp),
       (3, 'Carlos', 'Sánchez', 'Fernández', 'carlos.sanchez@example.com',
        crypt('password3', gen_salt('md5')), current_timestamp),
       (4, 'Ana', 'Gómez', 'Rodríguez', 'ana.gomez@example.com',
        crypt('password4', gen_salt('md5')), current_timestamp),
       (5, 'Pedro', 'Martín', 'Hernández', 'pedro.martin@example.com',
        crypt('password5', gen_salt('md5')), current_timestamp) on conflict (person_id) do nothing;

--Estudiantes
insert into student(person_id, student_id, career, is_irregular)
values (1, '2022475477', 0, false),
       (2, '2021601366', 0, true),
       (5, '2023401526', 2, false) on conflict(person_id) do nothing;

--Academy
insert into academy (academy_id, name)
values (1, 'Sistemas computacionales'),
       (2, 'Sistemas digitales') on conflict (academy_id) do nothing;

--Profesores
insert into professor (person_id, professor_number, academy_id)
values (3, '9275018326', 1),
       (4, '4839201574', 2) on conflict (person_id) do nothing;

--catt
insert into catt (person_id, catt_id, role)
values (5, '7521840395', 3) on conflict (person_id) do nothing;

--Protocol

insert into activity (activity_id, open_date, close_date, activity)
values (1, current_date, '2025-01-09 11:59:59',
        0),
       (2, '2024-12-19 00:00:00', '2025-01-09 11:59:59',
        1),
       (3, '2025-01-10 00:00:00', '2025-01-17 11:59:59',
        2),
       (4, '2025-01-17 00:00:00', '2025-01-24 11:59:59',
        3) on conflict (activity_id) do nothing;

insert into academy (academy_id, name)
values (1, 'Sistemas computacionales'),
       (2, 'Sistemas digitales'),
       (3, 'Ingenieria de software'),
       (4, 'Sistemas de control'),
       (5, 'Ciencias sociales') on conflict (academy_id) do nothing;
