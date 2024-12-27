-- Insert sample data into the Person table
INSERT INTO Person (name, paternal_surname, maternal_surname, email, password, created_at)
VALUES 
('John', 'Doe', 'Smith', 'john.doe@example.com', 'password', now()),
('Jane', 'Doe', 'Smith', 'jane.doe@example.com', 'password', now()),
('Alice', 'Johnson', 'Brown', 'alice.johnson@example.com', 'password', now()),
('Bob', 'Williams', 'Davis', 'bob.williams@example.com', 'password', now()),
('Charlie', 'Brown', 'Wilson', 'charlie.brown@example.com', 'password', now());

-- Insert sample data into the Academy table
INSERT INTO Academy (name) VALUES ('Computer Science'), ('Mathematics'), ('Physics');

-- Insert sample data into the Professor table
INSERT INTO Professor (person_id, professor_number, academy_id, school)
VALUES 
((SELECT person_id FROM Person WHERE email = 'john.doe@example.com'), 'P001', (SELECT academy_id FROM Academy WHERE name = 'Computer Science'), 'ESCOM'),
((SELECT person_id FROM Person WHERE email = 'jane.doe@example.com'), 'P002', (SELECT academy_id FROM Academy WHERE name = 'Mathematics'), 'ESCOM'),
((SELECT person_id FROM Person WHERE email = 'alice.johnson@example.com'), 'P003', (SELECT academy_id FROM Academy WHERE name = 'Physics'), 'ESCOM'),
((SELECT person_id FROM Person WHERE email = 'bob.williams@example.com'), 'P004', (SELECT academy_id FROM Academy WHERE name = 'Computer Science'), 'ESCOM'),
((SELECT person_id FROM Person WHERE email = 'charlie.brown@example.com'), 'P005', (SELECT academy_id FROM Academy WHERE name = 'Mathematics'), 'ESCOM');


-- Insert sample data into the Protocol table
INSERT INTO Protocol (title, keywords, abstract, file_data, state, created_at)
VALUES 
('Protocol 1', 'keyword1, keyword2', 'Abstract for protocol 1', NULL, 0, now()),
('Protocol 2', 'keyword3, keyword4', 'Abstract for protocol 2', NULL, 1, now()),
('Protocol 3', 'keyword5, keyword6', 'Abstract for protocol 3', NULL, 2, now()),
('Protocol 4', 'keyword7, keyword8', 'Abstract for protocol 4', NULL, 3, now()),
('Protocol 5', 'keyword1, keyword3', 'Abstract for protocol 5', NULL, 0, now()),
('Protocol 6', 'keyword2, keyword4', 'Abstract for protocol 6', NULL, 1, now()),
('Protocol 7', 'keyword5, keyword7', 'Abstract for protocol 7', NULL, 2, now()),
('Protocol 8', 'keyword6, keyword8', 'Abstract for protocol 8', NULL, 3, now()),
('Protocol 9', 'keyword1, keyword4', 'Abstract for protocol 9', NULL, 0, now()),
('Protocol 10', 'keyword2, keyword5', 'Abstract for protocol 10', NULL, 1, now());

-- Insert sample data into the Sinodal table
INSERT INTO Sinodal (protocol_id, person_id, is_sinodal)
VALUES 
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 1'), (SELECT person_id FROM Professor WHERE professor_number = 'P001'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 2'), (SELECT person_id FROM Professor WHERE professor_number = 'P001'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 3'), (SELECT person_id FROM Professor WHERE professor_number = 'P001'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 4'), (SELECT person_id FROM Professor WHERE professor_number = 'P001'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 5'), (SELECT person_id FROM Professor WHERE professor_number = 'P001'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 6'), (SELECT person_id FROM Professor WHERE professor_number = 'P002'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 7'), (SELECT person_id FROM Professor WHERE professor_number = 'P002'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 8'), (SELECT person_id FROM Professor WHERE professor_number = 'P002'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 9'), (SELECT person_id FROM Professor WHERE professor_number = 'P003'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 10'), (SELECT person_id FROM Professor WHERE professor_number = 'P003'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 1'), (SELECT person_id FROM Professor WHERE professor_number = 'P004'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 2'), (SELECT person_id FROM Professor WHERE professor_number = 'P004'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 3'), (SELECT person_id FROM Professor WHERE professor_number = 'P004'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 4'), (SELECT person_id FROM Professor WHERE professor_number = 'P004'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 5'), (SELECT person_id FROM Professor WHERE professor_number = 'P004'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 6'), (SELECT person_id FROM Professor WHERE professor_number = 'P005'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 7'), (SELECT person_id FROM Professor WHERE professor_number = 'P005'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 8'), (SELECT person_id FROM Professor WHERE professor_number = 'P005'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 9'), (SELECT person_id FROM Professor WHERE professor_number = 'P005'), true),
((SELECT protocol_id FROM Protocol WHERE title = 'Protocol 10'), (SELECT person_id FROM Professor WHERE professor_number = 'P005'), true);

-- Insert data into ProtocolAcademy
INSERT INTO protocol_academy (academy_id, protocol_id)
VALUES
((SELECT academy_id FROM Academy WHERE name = 'Computer Science'), (SELECT protocol_id FROM Protocol WHERE title = 'Protocol 1')),
((SELECT academy_id FROM Academy WHERE name = 'Mathematics'), (SELECT protocol_id FROM Protocol WHERE title = 'Protocol 2')),
((SELECT academy_id FROM Academy WHERE name = 'Physics'), (SELECT protocol_id FROM Protocol WHERE title = 'Protocol 3')),
((SELECT academy_id FROM Academy WHERE name = 'Computer Science'), (SELECT protocol_id FROM Protocol WHERE title = 'Protocol 4')),
((SELECT academy_id FROM Academy WHERE name = 'Mathematics'), (SELECT protocol_id FROM Protocol WHERE title = 'Protocol 5')),
((SELECT academy_id FROM Academy WHERE name = 'Physics'), (SELECT protocol_id FROM Protocol WHERE title = 'Protocol 6')),
((SELECT academy_id FROM Academy WHERE name = 'Computer Science'), (SELECT protocol_id FROM Protocol WHERE title = 'Protocol 7')),
((SELECT academy_id FROM Academy WHERE name = 'Mathematics'), (SELECT protocol_id FROM Protocol WHERE title = 'Protocol 8')),
((SELECT academy_id FROM Academy WHERE name = 'Physics'), (SELECT protocol_id FROM Protocol WHERE title = 'Protocol 9')),
((SELECT academy_id FROM Academy WHERE name = 'Computer Science'), (SELECT protocol_id FROM Protocol WHERE title = 'Protocol 10'));