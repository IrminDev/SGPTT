insert into protocol (protocol_id, title, keywords, abstract, file_data, state_id) VALUES
(2, 'Signal_conditioner_for_capacitive_and_inductive_sensors', 'Blumlein bridge, Reactance, Sensor',
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
 pg_read_binary_file('/home/Signal_conditioner_for_capacitive_and_inductive_sensors.pdf'), 2),
(3, 'Techniques_to_linearise_resistive_sensors',
 'Wheatstone Bridge, Sensor, analogue, Thermistor, Operational amplifier',
 'Resistive sensors are widely used in various
applications to measure physical quantities such as
temperature, pressure, and strain. However, the output of
these sensors is often nonlinear, which can complicate signal
processing and reduce measurement accuracy. This paper
presents a comprehensive review of analogue way techniques
to linearise resistive sensors.',
pg_read_binary_file('/home/Techniques_to_linearise_resistive_sensors.pdf'),
 1),
(4, 'Uso de cartas ASM',
 'Cartas ASM, Diagramas de estado, Diagramas de flujo',
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
 3),
(5,
 'Uso de máquinas de estado,
contadores y memorias',
 'Contadores, Máquina de estado, Mealy,
Memoria, Moore',
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
 3)