CREATE TABLE IF NOT EXISTS Role (
	role_id SERIAL PRIMARY KEY,
	name VARCHAR(50) UNIQUE NOT NULL
);

insert into role(role_id, name) values(1, 'Estudiante') on conflict(name) do nothing;
insert into role(role_id, name) values(2, 'Profesor') on conflict(name) do nothing;
insert into role(role_id, name) values(3, 'CATT') on conflict(name) do nothing;

CREATE TABLE IF NOT EXISTS Person (
    person_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    paternal_surname VARCHAR(50) NOT NULL,
    maternal_surname VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT current_timestamp,
    is_active BOOLEAN NOT NULL DEFAULT true,
    role_id INTEGER NOT NULL DEFAULT 1,
    CONSTRAINT fk_person_role FOREIGN KEY (role_id) REFERENCES Role(role_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Career (
    career_id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

INSERT INTO Career (name) VALUES ('ISC'), ('LCD'), ('IA');

CREATE TABLE IF NOT EXISTS Student (
    person_id INTEGER PRIMARY KEY,
    student_number VARCHAR(20) UNIQUE NOT NULL, -- Número de estudiante
    career_id INTEGER NOT NULL,
    recursor BOOLEAN NOT NULL DEFAULT false,
    CONSTRAINT fk_student_person FOREIGN KEY (person_id) REFERENCES Person(person_id) ON DELETE CASCADE,
    CONSTRAINT fk_student_career FOREIGN KEY (career_id) REFERENCES Career(career_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Academy (
    academy_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Professor (
    person_id INTEGER PRIMARY KEY,
    professor_id VARCHAR(20) UNIQUE NOT NULL, -- Número de empleado del profesor
    academy_id INTEGER NOT NULL,
    school VARCHAR(25) DEFAULT 'ESCOM',
    CONSTRAINT fk_professor_person FOREIGN KEY (person_id) REFERENCES Person(person_id) ON DELETE CASCADE,
    CONSTRAINT fk_professor_academy FOREIGN KEY (academy_id) REFERENCES Academy(academy_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS CATT (
    person_id INTEGER PRIMARY KEY,
    catt_id VARCHAR(20) UNIQUE NOT NULL, -- Número identificador de CATT
	role_id INTEGER NOT NULL,
	CONSTRAINT fk_catt_role FOREIGN KEY (role_id) REFERENCES Role(role_id) ON DELETE CASCADE,
    CONSTRAINT fk_catt_person FOREIGN KEY (person_id) REFERENCES Person(person_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ProtocolState (
    state_id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

INSERT INTO ProtocolState (name) VALUES ('Pendiente'), ('Aprobado'), ('Rechazado'), ('Finalizado');

CREATE TABLE IF NOT EXISTS Protocol (
    protocol_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    keywords TEXT NOT NULL,
    abstract TEXT NOT NULL,
    file_data BYTEA,
    state_id INTEGER NOT NULL,
    upload_at TIMESTAMP NOT NULL DEFAULT current_timestamp,
    CONSTRAINT fk_protocol_state FOREIGN KEY (state_id) REFERENCES ProtocolState(state_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ChangeRequest (
    request_id SERIAL PRIMARY KEY,
    format_data BYTEA NOT NULL,
    request_comments TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    state_id INTEGER NOT NULL,
    protocol_id INTEGER NOT NULL,
    CONSTRAINT fk_changerequest_protocol FOREIGN KEY (protocol_id) REFERENCES Protocol(protocol_id) ON DELETE CASCADE,
    CONSTRAINT fk_changerequest_status FOREIGN KEY (state_id) REFERENCES ProtocolState(state_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ProtocolAcademy (
    academy_id INTEGER NOT NULL,
    protocol_id INTEGER NOT NULL,
    CONSTRAINT fk_academy_protocol FOREIGN KEY (academy_id) REFERENCES Academy(academy_id) ON DELETE CASCADE,
    CONSTRAINT fk_protocol_academy FOREIGN KEY (protocol_id) REFERENCES Protocol(protocol_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ProtocolStudent (
    protocol_id INTEGER NOT NULL,
    student_id INTEGER NOT NULL,
    CONSTRAINT fk_protocol_student FOREIGN KEY (protocol_id) REFERENCES Protocol(protocol_id) ON DELETE CASCADE,
    CONSTRAINT fk_student_protocol FOREIGN KEY (student_id) REFERENCES Student(person_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Sinodal (
    sinodal_id SERIAL PRIMARY KEY,
    protocol_id INTEGER NOT NULL,
    professor_id INTEGER NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT true,
    CONSTRAINT fk_sinodal_protocol FOREIGN KEY (protocol_id) REFERENCES Protocol(protocol_id) ON DELETE CASCADE,
    CONSTRAINT fk_sinodal_professor FOREIGN KEY (professor_id) REFERENCES Professor(person_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Activity (
    activity_id SERIAL PRIMARY KEY,
    open_date DATE,
    close_date DATE,
    activity VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Evaluation (
    evaluation_id SERIAL PRIMARY KEY,
    sinodal_id INTEGER NOT NULL,
    is_approved BOOLEAN NOT NULL DEFAULT false,
    evaluation_comments TEXT,
    evaluation_date TIMESTAMP,
    CONSTRAINT fk_evaluation_sinodal FOREIGN KEY (sinodal_id) REFERENCES Sinodal(sinodal_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Director (
    director_id SERIAL PRIMARY KEY,
    professor_id INTEGER NOT NULL,
    protocol_id INTEGER NOT NULL,
    CONSTRAINT fk_director_professor FOREIGN KEY (professor_id) REFERENCES Professor(person_id) ON DELETE CASCADE,
    CONSTRAINT fk_director_protocol FOREIGN KEY (protocol_id) REFERENCES Protocol(protocol_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS CriterionResult (
    result_id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

INSERT INTO CriterionResult (name) VALUES ('Aprobado'), ('Rechazado'), ('Correciones');

CREATE TABLE IF NOT EXISTS Criterion (
    criterion_id SERIAL PRIMARY KEY,
    criterion VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS CriterionEvaluation (
	evaluation_id INTEGER NOT NULL,
	criterion_id INTEGER NOT NULL,
	result_id INTEGER NOT NULL,
	criterion_comments TEXT,
	evaluation_date TIMESTAMP,
	CONSTRAINT fk_criterion_evaluation_evaluation FOREIGN KEY (evaluation_id) REFERENCES Evaluation(evaluation_id) ON DELETE CASCADE,
	CONSTRAINT fk_criterion_evaluation_criterion FOREIGN KEY (criterion_id) REFERENCES Criterion(criterion_id) ON DELETE CASCADE,
	CONSTRAINT fk_criterion_evaluation_result FOREIGN KEY (result_id) REFERENCES CriterionResult(result_id) ON DELETE CASCADE
);
