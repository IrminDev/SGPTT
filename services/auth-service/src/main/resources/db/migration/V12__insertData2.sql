insert into activity (activity_id, open_date, close_date, activity)
values
    (1, current_date, '2025-01-09 11:59:59',
        'Subida de protocolos para alumnos regulares'),
    (2, '2024-12-19 00:00:00', '2025-01-09 11:59:59',
     'Subida de protocolos para alumnos irregulares'),
    (3, '2025-01-10 00:00:00', '2025-01-17 11:59:59',
     'Registro de sinodales a protocolos'),
    (4, '2025-01-17 00:00:00', '2025-01-24 11:59:59',
     'Asignación manual de sinodales a protocolos'),
    (5, '2025-02-01 00:00:00', '2025-02-15 11:59:59',
     'Evaluación de protocolos')
on conflict (activity_id) do nothing;

insert into academy (academy_id, name) values
    (1, 'Sistemas computacionales'),
    (2, 'Sistemas digitales'),
    (3, 'Ingenieria de software'),
    (4, 'Sistemas de control'),
    (5, 'Ciencias sociales')
on conflict (academy_id) do nothing;

insert into protocolacademy (academy_id, protocol_id) values
(1, 1),
(2, 2),
(2, 4),
(3, 4),
(4, 1),
(4, 2),
(5, 1),
(5, 2);

insert into sinodal (sinodal_id, protocol_id, professor_id) values
(1, 1, 3),
(2, 5, 6) on conflict (sinodal_id) do nothing;