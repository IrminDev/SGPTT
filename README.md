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
There is an endpoint called login

| Route | Type | 
|-------|-------|
| /api/auth/login | post |

It gets a simple login request object based on email and password
   ```json
   {
      "email" : "example@email.com",
      "password" : "mysupersecurepassword"
   }
   ```

## Usage

In this requirements project has been defined three different types of user
1. **Students**
2. **Professors**
3. **CATT**

And there are four use cases for this service
1. **The user has been logged correctly**
2. **The user has set bad credentials**
3. **The given credentials don't exist in the database**
4. **The user has been set up in an inactive state**

For example, with the given credentials
   ```json
   {
       "email" : "juan.perez@example.com",
       "password" : "password1"
   }
   ```
It begin an student user with an active status

And this one, begin a Person with an inactive status
```json
   {
      "email" : "edu4r@gmail.com",
      "password" : "Eduardo's password"
   }
```
The api responses for every use case.
<table>
   <tr>
      <td>
        Use case 1 - Login Success Status Code <div>200 OK</div>
      </td>
      <td>
         <h3>Student</h3>
         <pre>
         <code>
{
   "person": {
      "career": "ISC",
      "name": "Juan Pérez García",
      "number": "2021601366"
   },
   "token": "eyJhbGciOiJIUzI1NiJ9.eyJwZXJzb25JZCI6Miwicm9sZSI6IkVzdHVkaWFudGUiLCJpYXQiOjE3MzM2MTY5NTEsImV4cCI6MTczMzYxODc1MX0.vrfJLZCM-3UY3KIkCHc4qpE10g9ErlOE3FFd6E7faRU",
   "result": "Success"
}
         </code>
         </pre>
         <h3>Professors</h3>
         <pre>
            <code>
{
    "person": {
        "school": "ESCOM",
        "academy": "Sistemas computacionales",
        "name": "María López Martínez",
        "number": "9275018326"
    },
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJwZXJzb25JZCI6Mywicm9sZSI6IlByb2Zlc29yIiwiaWF0IjoxNzMzNjIxNzQ3LCJleHAiOjE3MzM2MjM1NDd9.zoTxmXUcwoCTxf93fOF4YVXd29Er6M9-MVRV5RTlpww",
    "result": "Success"
}
            </code>
         </pre>
         <h3>CATT</h3>
         <pre>
            <code>
{
    "person": {
        "name": "Carlos Sánchez Fernández",
        "number": "7521840395",
        "role": "SECRETARY"
    },
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJwZXJzb25JZCI6NCwicm9sZSI6IkNBVFQiLCJpYXQiOjE3MzM2MjE4MjYsImV4cCI6MTczMzYyMzYyNn0.nDOJ-rOYmyNqd_yw__3GSwPcRERudS3iHn9OUZtqQ1s",
    "result": "Success"
}
            </code>
         </pre>
      </td>
   </tr>
   <tr>
      <td>
         Use case 2 - Bad credentials Status Code 406 Not acceptable
      </td>
      <td>
         <pre>
         <code>
{
   "person": {
      "name": "Juan Pérez García",
      "number": null
   },
   "result": "Wrong password"
}
         </code>
         </pre>
      </td>
   </tr>
   <tr>
      <td>
         Use case 3 - email not found Status code 404 Not found
      </td>
      <td>
         <pre>
         <code>
{
   "person": null,
   "result": "Person not found"
}
         </code>
         </pre>
      </td>      
   </tr>
   <tr>
      <td>
         Use case 4 - Inactive user Status code 202 Accepted
      </td>
      <td>
         <pre>
         <code>
{
   "person": {
      "name": "Eduardo Martínez García",
      "number": "2023121314"
   },
   "result": "Inactive person"
}   
         </code>
         </pre>
      </td>
   </tr>
</table>

The Token contains in its payload personId, their roles and iat and exp, it looks like that
```json
{
  "personId": 2,
  "role": "Student",
  "iat": 1733616951,
  "exp": 1733618751
}
```
> [!NOTE] 
> The sceret key is base64 encoded, that means the code get the environment variable JWT_SECRET and encodes it on Base 64, after it is signed, for getting more details see [this](https://github.com/jwtk/jjwt)

There's another endpoint called /me
| Route | Type | 
|-------|----------------|
| /api/auth/authorize/me | Get |

It just returns a token payload, the token payload **must** be present in the Authorization header as always it's been
response looks like
```json
{
    "role": "Student",
    "personId": 1
}
```
retuns null as body when the token has expired.
| Use case                 | Status code |
|------------------------  | ----------  |
| The token is not present | 401         |
| The token has expired    | 403         |
| Token is valid           | 200         |

## Technologies Used
|   Name      | Version       | Icon |
|-------------|---------------|--------------------------------------------------------------------------------- |
|   Kotlin    | 2.1.0 | [![My Skills](https://skillicons.dev/icons?i=kotlin&theme=dark)](https://skillicons.dev) |
| Spring boot | 3.0.4 | [![My Skills](https://skillicons.dev/icons?i=spring&theme=dark)](https://skillicons.dev) |
|  PostgreSQL | 15.9  | [![My Skills](https://skillicons.dev/icons?i=postgresql&theme=dark)](https://skillicons.dev)|
| Docker      | 27.2.0| [![My Skills](https://skillicons.dev/icons?i=docker&theme=dark)](https://skillicons.dev) |


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


## Endpoints

---

### 1. Protocol Assessment

| Route                    | Type |
|--------------------------|------|
| /api/assessment/evaluate | PUT  |

Receive an object ProtocolAssessmentRequest with the following data:

- Integer protocolId
- EvaluationDTO evaluationDTO

EvaluationDTO:

- Long professorId
- List<CriterionDTO> evaluationCriteria
- String comments

CriterionDTO:

- Criterion criterion
- Boolean result
- String comment

Criterion is an enum with the following values:

FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH, EIGHTH, NINTH, TENTH

The body request have to be like this:

```json
{
  "protocolId": 1,
  "evaluationDTO": {
    "professorId": 1,
    "evaluationCriteria": [
      {
        "criterion": "FIRST",
        "result": true,
        "comment": "This is a comment"
      },
      {
        "criterion": "SECOND",
        "result": true,
        "comment": "This is another comment"
      },
      {
        "criterion": "THIRD",
        "result": true,
        "comment": "This is another comment"
      },
      {
        "criterion": "FOURTH",
        "result": true,
        "comment": "This is another comment"
      },
      {
        "criterion": "FIFTH",
        "result": true,
        "comment": "This is another comment"
      },
      {
        "criterion": "SIXTH",
        "result": true,
        "comment": "This is another comment"
      },
      {
        "criterion": "SEVENTH",
        "result": true,
        "comment": "This is another comment"
      },
      {
        "criterion": "EIGHTH",
        "result": true,
        "comment": "This is another comment"
      },
      {
        "criterion": "NINTH",
        "result": true,
        "comment": "This is another comment"
      },
      {
        "criterion": "TENTH",
        "result": false,
        "comment": "This is another comment"
      }
    ],
    "comments": "This is a general comment"
  }
}
```

The order of each criterion does not matter because they already have the enum

### 2. Assign Protocol to academies

| Route                  | Type |
|------------------------|------|
| /api/assessment/assign | PUT  |

Receive an object AssignmentProtocolRequest with the following data:

- Integer protocolId
- Set\<Long> academies

The body request have to be like this:

```json
{
  "protocolId": 1,
  "academiesId": [1, 2, 3]
}
```

## Database

---

### 1. Protocol Assessment

The evaluation will be inserted into the database with its respective criteria

- #### Evaluation table

| evaluation_id | is_approved | evaluation_comments | evaluation_date | sinodal_id |
|---------------|-------------|---------------------|-----------------|------------|
| 1             | true        | This is a comment   | 2021-10-10      | 1          |

- #### Criterion Evaluation table

| criterion_id | criterion | criterion_comments      | criterion_result | criterion_evaluation_id |
|--------------|-----------|-------------------------|------------------|-------------------------|
| 1            | 0         | This is a comment       | true             | 1                       |
| 2            | 1         | This is another comment | true             | 1                       |
| 3            | 2         | This is another comment | true             | 1                       |
| 4            | 3         | This is another comment | true             | 1                       |
| 5            | 4         | This is another comment | true             | 1                       |
| 6            | 5         | This is another comment | true             | 1                       |
| 7            | 6         | This is another comment | true             | 1                       |
| 8            | 7         | This is another comment | true             | 1                       |
| 9            | 8         | This is another comment | true             | 1                       |
| 10           | 9         | This is another comment | false            | 1                       |

### 2. Assign Protocol to academies

The protocol will be linked to the academies 

- #### Protocol Academy table

| protocol_id | academy_id |
|-------------|------------|
| 1           | 1          |
| 1           | 2          |
| 1           | 3          |

## Responses

For both services, the response, if all fields are correct, is **202 Accepted**