--Personas
INSERT INTO Person (person_id, name, paternal_surname, maternal_surname, email, password, role_id)
VALUES (2, 'Juan', 'Pérez', 'García', 'juan.perez@example.com',
        crypt('password1', gen_salt('md5')), 1),
       (3, 'María', 'López', 'Martínez', 'maria.lopez@example.com',
        crypt('password2', gen_salt('md5')), 2),
       (4, 'Carlos', 'Sánchez', 'Fernández', 'carlos.sanchez@example.com',
        crypt('password3', gen_salt('md5')), 3),
       (5, 'Ana', 'Gómez', 'Rodríguez', 'ana.gomez@example.com',
        crypt('password4', gen_salt('md5')), 1),
       (6, 'Pedro', 'Martín', 'Hernández', 'pedro.martin@example.com',
        crypt('password5', gen_salt('md5')), 2)
on conflict (person_id) do nothing;

--Estudiantes
insert into student(person_id, student_number, career_id)
values (2, '2021601366', 1),
(5, '2023401526', 3) on conflict(person_id) do nothing;

--Academy
insert into academy (academy_id, name) values
(1, 'Sistemas computacionales'),
(2, 'Sistemas digitales')
on conflict (academy_id) do nothing;

--Profesores
insert into professor (person_id, professor_id, academy_id)
values (3,'9275018326', 1),
       (6, '4839201574', 2)
on conflict (person_id) do nothing;

--catt
insert into catt (person_id, catt_id, role_id)
values (4, '7521840395', 3)
on conflict (person_id) do nothing ;

--protocol
/*INSERT INTO Protocol (protocol_id, title, keywords, abstract, file_data, state_id)
VALUES
(1,'Análisis y propuesta de rediseño de la red de la escuela
superior de cómputo (ESCOM) del Instituto Politécnico
Nacional (IPN)', 'Red, Escuela Superior de Cómputo
(ESCOM), Modelo OSI, Componentes, Switches, Routers, Access
Points, Servidores, Diseño, Topología, Fallos, Gestión, Análisis,
Subredes, VLSM, Segmentación, LANs, Enrutamiento, Escalable,
Infraestructura, Tráfico de datos', 'El presente documento aborda el análisis y
rediseño de la red de la Escuela Superior de Cómputo (ESCOM)
mediante la aplicación del modelo OSI y la identificación de sus
componentes clave. En la primera sección se presenta el marco
teórico, donde se explica el modelo OSI y sus capas, así como
los diferentes dispositivos de red como switches, routers, access
points y servidores, que son esenciales para la infraestructura de
comunicación. Se enfatiza la importancia de un diseño
adecuado de la red para garantizar su funcionalidad y eficiencia.
Posteriormente, se realiza un análisis del estado actual de la red
en ESCOM, destacando que la topología mixta,
predominantemente en anillo, presenta inconvenientes como
puntos únicos de fallo y dificultades para la expansión. Se
incluye un conteo detallado de los dispositivos de red en cada
edificio, lo que permite una mejor planificación y gestión. En la
sección económica, se presenta un desglose de los costos de los
componentes necesarios, resaltando la importancia de un
análisis financiero para asegurar la viabilidad del proyecto. El
documento también propone un diseño preliminar que
contempla la creación de subredes utilizando VLSM, con el
objetivo de segmentar la red de acuerdo con la cantidad de hosts
requeridos en cada área de la escuela. Finalmente, se plantean
configuraciones de red que incorporan VLANs y enrutamiento
entre ellas, con el fin de mejorar la gestión del tráfico y asegurar
una infraestructura escalable',
 pg_read_binary_file('/app/build/resources/main/static/red_de_escom.pdf'), 1) on conflict (protocol_id) do nothing;*/