
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

## Responses

In this requirements project has been defined a three different types of user
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

It begin an student user with an active status, the api responses for every use case
<table>
   <tr>
      <td>
        Use case 1 - Login Success Status Code 200 OK
      </td>
      <td>
         Use case 2 - Bad credentials Status Code 406 Not acceptable
      </td>
      <td>
         Use case 3 - email not found Status code 404 Not found
      </td>
      <td>
         Use case 4 - Inactive user Status code 202 Accepted
      </td>
   </tr>
<tr>
      <td>
<code>
{
   "person": {
      "career": "ISC",
      "name": "Juan Pérez García",
      "number": "2021601366",
      "isActive": true
   },
      "token": "token",
      "result": "Success"
}   
      </code>
      </td>
      <td>
<code>
{
   "person": {
      "name": "Juan Pérez García",
      "number": null,
      "isActive": true
   },
    "result": "Wrong password"
}
</code>
</td>
<td>
<code>
{
   "person": null,
   "result": "Person not found"
}
</code>
</td>
<td>
<code>
{
    "person": {
        "name": "Eduardo Martínez García",
        "number": "2023121314",
        "isActive": false
    },
    "result": "Inactive person"
}   
</code>
</td>
</td>      
</tr>
</table>

The Token will contain information like the user id and role, it is comming soon!
