
# Manager System of Protocols for Trabajos Terminales


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
