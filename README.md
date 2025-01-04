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