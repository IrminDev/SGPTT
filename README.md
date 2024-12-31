
# Manager System of Protocols for Trabajos Terminales

A management system designed to organize, track, and manage protocols for "Trabajos Terminales" (final projects or thesis work). This system provides a user-friendly interface for students, advisors, and administrators to submit, review, and approve protocols efficiently.

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)

---

## Features

- **Protocol Submission**: Students can submit protocols for their final projects.
- **Review and Feedback**: Advisors can review protocols and provide feedback.
- **Approval Workflow**: Protocols can be approved or rejected by administrators.
- **User Authentication and Role Management**: Secure access for different types of users, including students, advisors, and admins.
- **Document Management**: Upload and organize documents related to protocols.
- **Search and Filtering**: Easily search and filter protocols.

## Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/irmindev/SGPTT.git
   cd SGPTT/

## Usage (Protocol Service)
It has four endpoints

|  Endpoint          |  Type     | Allowed roles|
|--------------------|-----------|--------------|
| /api/protocols/all | GET       | Catt         |

This endpoind retrieves all protocols with pagination, by default it retrieves 5 protocols per page order by the upload date, the response looks like this
```json
{
    "totalPages": 2,
    "totalItems": 6,
    "currentPage": 0,
    "protocols": [
        {
            "id": 7,
            "title": "A changed title",
            "keywords": [
                "This is a keyword",
                "This is another keyword"
            ],
            "abstract": "Sample abstract",
            "state": "PENDING",
            "createdAt": "2024-12-30T03:05:05.404+00:00"
        },
        {
            "id": 1,
            "title": "Análisis y propuesta de rediseño de la red de la escuela\r\nsuperior de cómputo (ESCOM) del Instituto Politécnico\r\nNacional (IPN)",
            "keywords": [
                "Red",
                "Escuela Superior de Cómputo\r\n(ESCOM)",
                "Modelo OSI",
                " Componentes",
                "Switches",
                "Routers",
                "Access\r\nPoints",
                "Servidores",
                "Diseño",
                "Topología",
                "Fallos",
                "Gestión",
                "Análisis",
                "\r\nSubredes",
                "VLSM",
                "Segmentación",
                "LANs",
                "Enrutamiento",
                "Escalable",
                "\r\nInfraestructura",
                "Tráfico de datos"
            ],
            "abstract": "El presente documento aborda el análisis y\r\nrediseño de la red de la Escuela Superior de Cómputo (ESCOM)\r\nmediante la aplicación del modelo OSI y la identificación de sus\r\ncomponentes clave. En la primera sección se presenta el marco\r\nteórico, donde se explica el modelo OSI y sus capas, así como\r\nlos diferentes dispositivos de red como switches, routers, access\r\npoints y servidores, que son esenciales para la infraestructura de\r\ncomunicación. Se enfatiza la importancia de un diseño\r\nadecuado de la red para garantizar su funcionalidad y eficiencia.\r\nPosteriormente, se realiza un análisis del estado actual de la red\r\nen ESCOM, destacando que la topología mixta,\r\npredominantemente en anillo, presenta inconvenientes como\r\npuntos únicos de fallo y dificultades para la expansión. Se\r\nincluye un conteo detallado de los dispositivos de red en cada\r\nedificio, lo que permite una mejor planificación y gestión. En la\r\nsección económica, se presenta un desglose de los costos de los\r\ncomponentes necesarios, resaltando la importancia de un\r\nanálisis financiero para asegurar la viabilidad del proyecto. El\r\ndocumento también propone un diseño preliminar que\r\ncontempla la creación de subredes utilizando VLSM, con el\r\nobjetivo de segmentar la red de acuerdo con la cantidad de hosts\r\nrequeridos en cada área de la escuela. Finalmente, se plantean\r\nconfiguraciones de red que incorporan VLANs y enrutamiento\r\nentre ellas, con el fin de mejorar la gestión del tráfico y asegurar\r\nuna infraestructura escalable",
            "state": "PENDING",
            "createdAt": "2024-12-28T08:07:40.816+00:00"
        },
        {
            "id": 2,
            "title": "Signal_conditioner_for_capacitive_and_inductive_sensors",
            "keywords": [
                "Blumlein bridge",
                "Reactance",
                "Sensor"
            ],
            "abstract": "The Blumlein bridge, named after its\r\ninventor Alan Dower Blumlein, is a specialized AC bridge\r\nknown for its exceptional sensitivity in measuring\r\ncapacitance changes. It’s particularly well-suited for\r\napplications involving capacitance transducers, devices that\r\nconvert physical quantities like pressure, strain, or\r\ndisplacement into changes in capacitance.\r\nSignal conditioning of inductive sensors to obtain an output\r\nproportional to the change in the inductance alone is fraught\r\nwith problems. The large value of self-inductance that is\r\npresent in a sensor coil and the change in the inductance being\r\na small fraction of this large inductance coupled with the\r\nwinding resistance of the sensor coil make signal\r\nconditioning of such inductive sensors a challenge",
            "state": "APPROVED",
            "createdAt": "2024-12-28T08:07:40.816+00:00"
        },
        {
            "id": 3,
            "title": "Techniques_to_linearise_resistive_sensors",
            "keywords": [
                "Wheatstone Bridge",
                "Sensor",
                "analogue",
                "Thermistor",
                "Operational amplifier"
            ],
            "abstract": "Resistive sensors are widely used in various\r\napplications to measure physical quantities such as\r\ntemperature, pressure, and strain. However, the output of\r\nthese sensors is often nonlinear, which can complicate signal\r\nprocessing and reduce measurement accuracy. This paper\r\npresents a comprehensive review of analogue way techniques\r\nto linearise resistive sensors.",
            "state": "PENDING",
            "createdAt": "2024-12-28T08:07:40.816+00:00"
        },
        {
            "id": 4,
            "title": "Uso de cartas ASM",
            "keywords": [
                "Cartas ASM",
                "Diagramas de estado",
                "Diagramas de flujo"
            ],
            "abstract": "El uso de diagramas de estado, y cartas ASM\r\nayuda a diseñar sistemas digitales cada vez más complejos. Los\r\ndiagramas de fujo se ocupan para visualizar de una mejor manera\r\nlos pasos a seguir en un orden específico para un algoritmo ya sea\r\nde software o hardware. Los diagramas de máquinas de estado\r\ntambién conocidos como cartas ASM son un tipo de diagrama de\r\nflujo que sirve para visualizar y poder realizar algoritmos en\r\nhardware digital. La principal diferencia entre un diagrama de\r\nflujo y las cartas ASM, es que, para estas últimas, hay casos en\r\ndonde se requiere de un pulso de reloj para cambiar de estado, esto\r\nquiere decir que son síncronas, y en otros casos se cambia de estado\r\ncuando se cumplan ciertas condiciones. Estas cartas en la práctica\r\nsirven para visualizar circuitos digitales complejos como lo son los\r\nFPGA, memorias RAM y ROM, microcontroladores y\r\nmicroprocesadores, entre otros. Aplicar de manera correcta estos\r\ndiseños es importante para entender el funcionamiento de\r\ncircuitos complejos y que se puedan realizar de manera correcta",
            "state": "REJECTED",
            "createdAt": "2024-12-28T08:07:40.816+00:00"
        }
    ]
}
```

Where the filed **protocols** is an array that contains objects protocols, in they there are superficial information about themselves, id is retrieved by future requests about single protocol.
**totalPages** is an integer field that means the maximum value of parameter pages can have.
> [!NOTE]
> Page is a 0 base index parameter
> **0 <= page <= totalPages - 1**

totalItems is a long type field, it means all records into the database. <br>
currentPage is a integer field, it means the current page you got. <br>

You can change the page by adding the parameter page to the request <br>
**/api/protocols/all?page=1** <br>

Or change the page's size by adding size parameter <br>
**/api/protocols/all?size=4** <br>

You can change both if you do prefer. <br>
**/api/protocols/all?size=4&page=3** <br>

|  Endpoint          |  Type     | Allowed roles             |
|--------------------|-----------|---------------------------|
| /api/protocols/get | GET       | Catt, Student, Professor  |

This endpoint retrieve information about single protocol or a list of protocols associated by a user, it **always** retreive a list of protocols, witch contains the file encoded in Base 64, it looks like:
```json
[
    {
        "id": 7,
        "title": "A changed title",
        "keywords": [
            "This is a keyword",
            "This is another keyword"
        ],
        "abstract": "Sample abstract",
        "state": "PENDING",
        "createdAt": "2024-12-30T03:05:05.404+00:00",
        "fileDataBase64": "A Base 64 encoded PDF file",
        "students": [
            "Juan Pérez García",
            "María López Martínez"
        ],
        "directors": [
            "Carlos Sánchez Fernández",
            "Ana Gómez Rodríguez"
        ]
    }
]

```
for Catt user, you must provide with a protocolId parameter <br>
/api/protocols/get?protocolId=4 <br>

for Student user, you must provide a studentId parameter <br>
/api/protocols/get?studentId=1 <br>

for Professor user, you must provide a professorId parameter <br>
/api/protocols/get?professorId=3 <br>

If you provide most one parameter, the resolution order is this <br>

 1. protocolId
 2. professorId
 3. studentId <br>
 
If you don't provide any parameter, a empty list is returned

|  Endpoint              |  Type     | Allowed roles             |
|------------------------|-----------|---------------------------|
| /api/protocols/upload  | PUT       | Student                   |

> [!IMPORTANT]
> This is a multipart request, you must send a protocol PDF file and a JSON file that contains request information.

**Example of structure JSON file** <br>
<h2> sample.json </h2>

```json
{
    "studentId" : 1,
    "protocolTitle" : "Sample title",
    "keywords" : ["Keyword 1", "Keyword 2", "Keyword 3"],
    "abstract" : "Sample abstract",
    "workMates" : ["2021601366", "2023401526"],
    "directors" : ["9275018326"]
}
```

The following rules are valited by the endpoint betore to regist the protocol
 1. StudentId must be positive
 2. protocolTitle must have between 8 and 50 characteres and be not null or blank
 3. keywords at least one keyword must be provided and maximun 100
 4. abstract must not be blank or null
 5. workmates must have maximum size of 4 (it can be empty but not null), and each student number must have a length of 10 and all characters must be numeric
 6. directors must have a minimun size of 1 and maximun of 4, the same rule for workmates it's applied

<h3>if there are some erros into json, a json response like this is returned with <b>400 bad request status</b></h3>

```json
{
    "message": "protocolTitle: size must be between 8 and 50 
                keywords: size must be between 1 and 100 
                directors: size must be between 1 and 3 
                workMates: Any enrollment number isn't valid 
                studentId: must be greater than 0"
}
```

<h2>There could be some erros during the execution of this endpoint, for example:</h2>

<h3>If any student or professor was'nt found in the system with its enrollment number a json response like this is returned with 404 not found status code</h3>

```json
{
    "message": "(Student or Professor) with enrollment 1010101010 not found"
}
```
<h2>If the students with enrollment number in the field workmates are not in the same career a json response like this is returned with 404 not found status code</h2>

```json
{
    "message": "These students are not in the same career",
    "students": {
        "María López Martínez": "ISC",
        " Pedro Martín Hernández": "LCD"
    }
}
```

<h2>If the student is trying to upload its protocol out of the allowed dates a json response like this is returned with 503 not found status code</h2>

```json
{
    "message": "This service is temporally unavailable
                you can upload your protocol between the following dates 2025-01-01 and 2025-01-09"
}
```

<h2>If protocol PDF is missing or file isn't a PDF type a json response like this is returned with 415 not found status code</h2>

```json
{
    "message": "Your file must be a PDF file"
}
```

<h2>If the file of the procol is greater than the allowed file size (4MB) a null body is returned with code 413 Request Entity Too Large</h2>

<h3>If everything it's OK a json response like this is returned</h3>

```json
{
    "new": {
        "id": 8,
        "title": "protocol title",
        "keywords": [
            "k1",
            "k2"
        ],
        "abstract": "protocol abstract",
        "state": "PENDING",
        "createdAt": "2024-12-31T06:50:18.348+00:00"
    },
    "message": "Successfully uploaded the new protocol"
}
```
