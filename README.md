# Manager System of Protocols for Trabajos Terminales

A management system designed to organize, track, and manage protocols for "Trabajos Terminales" (final projects or
thesis work). This system provides a user-friendly interface for students, advisors, and administrators to submit,
review, and approve protocols efficiently.

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
- **User Authentication and Role Management**: Secure access for different types of users, including students, advisors,
  and admins.
- **Document Management**: Upload and organize documents related to protocols.
- **Search and Filtering**: Easily search and filter protocols.

## Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/irmindev/SGPTT.git
   cd SGPTT/

## Endpoints

### 1. Register

| Route                        | Type |
|------------------------------|------|
| /api/administration/register | post |

it gets a RegisterRequest object which has class variables

1. PersonDTO person
2. String email
3. String password

where PersonDTO can be of type Student or Professor

#### For Student

```json
{
  "person": {
    "type": "student",
    "name": "Emiliano",
    "paternalSurname": "Diaz",
    "maternalSurname": "Hernandez",
    "number": "2023630884",
    "career": "ISC",
    "isIrregular": false
  },
  "email": "ediazh1900@alumno.ipn.mx",
  "password": "emiliano123"
}
```

The **career** field is an enum, and the values it can receive are

- ISC
- IA
- LCD

Otherwise, it will return an exception

#### For Professor

```json
{
  "person": {
    "type": "professor",
    "name": "Diego",
    "lasName": "Moreno",
    "surname": "Martinez",
    "number": "2021601366",
    "school": "ESCOM",
    "academy": "SOFTWARE_ENGINEER"
  },
  "email": "dmorenom2002@alumno.ipn.mx",
  "password": "diego123"
}
```

### 2. Open Activity

| Route                            | Type |
|----------------------------------|------|
| /api/administration/openActivity | post |

```json
{
  "activity": "UPLOAD_PROTOCOL_FOR_REGULAR_STUDENTS",
  "startDate": "2024-01-07",
  "endDate": "2024-01-08"
}
```

The **activity** field is an enum, and the values it can receive are

- UPLOAD_PROTOCOL_FOR_REGULAR_STUDENTS
- UPLOAD_PROTOCOLS_IRREGULAR_STUDENTS
- REVIEW_PROTOCOLS
- ASSESSMENT_PROTOCOLS

Otherwise, it will return an exception

## Query's

### 1. Register

Regardless of whether it is a Student or a Professor, a Person will be inserted into the database, where their role will
be assigned accordingly, and the Student or Professor will also be inserted into their own table.

The password is encrypted using the PostgreSQL **crypt** function with the MD5 algorithm.

- #### Person table

| person_id | name     | paternal_surname | maternal_surname | email                      | password                             | created_at                  | is_active |
|-----------|----------|------------------|------------------|----------------------------|--------------------------------------|-----------------------------|-----------|
| 1         | Emiliano | Díaz             | Hernandez        | ediazh1900@alumno.ipn.mx   | \$1\$vJCpe.Px$ZrnjuPQer7CPcgH1CglcQ0 | 2024-12-07 18:00: 18.257000 | true      |
| 2         | Diego    | Moreno           | Martinez         | dmorenom2002@alumno.ipn.mx | \$1\$hsGxTiiR$2IeKy0QyXvgCiOKU4c3MU0 | 2024-12-07 20:44:37.077000  | true      |

- #### Student table

| person_id | student_id | career | is_irregular |
|-----------|------------|--------|--------------|
| 1         | 2023630884 | 0      | false        |

- #### Professor table

| person_id | professor_id | academy_id | school |
|-----------|--------------|------------|--------|
| 2         | 2021601366   | 1          | ESCOM  |

### 2. Open Activity

For the activities, it is a simple data insertion into the Activity table.

- #### Activity table

| activity_id | open_date  | close_date | activity                             |
|-------------|------------|------------|--------------------------------------|
| 1           | 2024-01-07 | 2024-01-08 | UPLOAD_PROTOCOL_FOR_REGULAR_STUDENTS |

## Responses

For both services, the response, if all fields are correct, is **201 Created**
