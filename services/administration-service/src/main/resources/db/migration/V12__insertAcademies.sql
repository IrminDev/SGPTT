insert into academy (academy_id, name)
VALUES (3, 'SOFTWARE_ENGINEER')
on conflict (academy_id) do nothing;

insert into academy (academy_id, name)
VALUES (4, 'DIGITAL_SYSTEMS')
on conflict (academy_id) do nothing;

insert into academy (academy_id, name)
VALUES (5, 'COMPUTER_SCIENCE')
on conflict (academy_id) do nothing