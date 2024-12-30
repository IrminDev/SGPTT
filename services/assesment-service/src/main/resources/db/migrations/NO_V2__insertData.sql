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

INSERT INTO Protocol (protocol_id, title, keywords, abstract, file_data, state)
VALUES (1, 'Análisis y propuesta de rediseño de la red de la escuela
superior de cómputo (ESCOM) del Instituto Politécnico
Nacional (IPN)', 'Red,Escuela Superior de Cómputo
(ESCOM),Modelo OSI, Componentes,Switches,Routers,Access
Points,Servidores,Diseño,Topología,Fallos,Gestión,Análisis,
Subredes,VLSM,Segmentación,LANs,Enrutamiento,Escalable,
Infraestructura,Tráfico de datos', 'El presente documento aborda el análisis y
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
        pg_read_binary_file('/home/red_de_escom.pdf'), 0) on conflict (protocol_id) do nothing;

insert into protocol (protocol_id, title, keywords, abstract, file_data, state)
VALUES (2, 'Signal_conditioner_for_capacitive_and_inductive_sensors', 'Blumlein bridge,Reactance,Sensor',
        'The Blumlein bridge, named after its
       inventor Alan Dower Blumlein, is a specialized AC bridge
       known for its exceptional sensitivity in measuring
       capacitance changes. It’s particularly well-suited for
       applications involving capacitance transducers, devices that
       convert physical quantities like pressure, strain, or
       displacement into changes in capacitance.
       Signal conditioning of inductive sensors to obtain an output
       proportional to the change in the inductance alone is fraught
       with problems. The large value of self-inductance that is
       present in a sensor coil and the change in the inductance being
       a small fraction of this large inductance coupled with the
       winding resistance of the sensor coil make signal
       conditioning of such inductive sensors a challenge',
        pg_read_binary_file('/home/Signal_conditioner_for_capacitive_and_inductive_sensors.pdf'), 1),
       (3, 'Techniques_to_linearise_resistive_sensors',
        'Wheatstone Bridge,Sensor,analogue,Thermistor,Operational amplifier',
        'Resistive sensors are widely used in various
       applications to measure physical quantities such as
       temperature, pressure, and strain. However, the output of
       these sensors is often nonlinear, which can complicate signal
       processing and reduce measurement accuracy. This paper
       presents a comprehensive review of analogue way techniques
       to linearise resistive sensors.',
        pg_read_binary_file('/home/Techniques_to_linearise_resistive_sensors.pdf'),
        0),
       (4, 'Uso de cartas ASM',
        'Cartas ASM,Diagramas de estado,Diagramas de flujo',
        'El uso de diagramas de estado, y cartas ASM
       ayuda a diseñar sistemas digitales cada vez más complejos. Los
       diagramas de fujo se ocupan para visualizar de una mejor manera
       los pasos a seguir en un orden específico para un algoritmo ya sea
       de software o hardware. Los diagramas de máquinas de estado
       también conocidos como cartas ASM son un tipo de diagrama de
       flujo que sirve para visualizar y poder realizar algoritmos en
       hardware digital. La principal diferencia entre un diagrama de
       flujo y las cartas ASM, es que, para estas últimas, hay casos en
       donde se requiere de un pulso de reloj para cambiar de estado, esto
       quiere decir que son síncronas, y en otros casos se cambia de estado
       cuando se cumplan ciertas condiciones. Estas cartas en la práctica
       sirven para visualizar circuitos digitales complejos como lo son los
       FPGA, memorias RAM y ROM, microcontroladores y
       microprocesadores, entre otros. Aplicar de manera correcta estos
       diseños es importante para entender el funcionamiento de
       circuitos complejos y que se puedan realizar de manera correcta',
        pg_read_binary_file('/home/Uso_de_cartas_ASM.pdf'),
        2),
       (5,
        'Uso de máquinas de estado,
       contadores y memorias',
        'Contadores,Máquina de estado,Mealy,Memoria, Moore',
        'El uso de máquinas de estado, contadores y
       memorias es fundamental en el diseño de sistemas digitales. Las
       máquinas de estado permiten modelar y controlar el
       comportamiento de sistemas complejos, definiendo estados y
       transiciones entre ellos. Los contadores se utilizan ampliamente
       para llevar un registro de eventos o para generar señales de
       temporización, mientras que las memorias permiten almacenar y
       recuperar datos de manera eficiente. En la práctica, estos
       elementos se emplean en una gran variedad de aplicaciones, desde
       controladores industriales hasta sistemas embebidos. Por ejemplo,
       las máquinas de estado se utilizan para gestionar protocolos de
       comunicación, los contadores se emplean en sistemas de monitoreo
       y las memorias son esenciales para el almacenamiento de datos en
       procesadores y microcontroladores. El diseño y la implementación
       adecuada de estos componentes es crucial para garantizar el
       correcto funcionamiento y el rendimiento de los sistemas digitales',
        pg_read_binary_file('/home/Uso_de_maquinas_de_estado_contadores_y_memorias.pdf'),
        2) on conflict(protocol_id) do nothing;

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

insert into protocol_academy (academy_id, protocol_id)
values (1, 1),
       (2, 2),
       (2, 4),
       (3, 4),
       (4, 1),
       (4, 2),
       (5, 1),
       (5, 2);

insert into sinodal (id, protocol_id, person_id)
values (1, 1, 3),
       (2, 5, 4) on conflict (id) do nothing;