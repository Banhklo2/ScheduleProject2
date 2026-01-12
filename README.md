# 📋 API 명세

---

## ✅ 일정 관리 앱 (Schedule)

### 1️⃣ 일정 생성

| 구분 | 내용 |
|----|----|
| Method | POST |
| URL | /schedules |
| Description | 새로운 일정을 생성한다. |
| Body | userId, title, content |
| Success Code | 201 CREATED |

**Request Example**
```json
{
  "userId": 1,
  "title": "첫 일정",
  "content": "포스트맨 테스트"
}

```

**Response Example**
```json
{
    "id": 1,
    "title": "첫 일정",
    "content": "포스트맨 테스트",
    "userId": 1,
    "userName": "효경",
    "createdAt": "2026-01-12T10:20:41.6436389",
    "modifiedAt": "2026-01-12T10:20:41.6436389"
}

```

### 2️⃣ 일정 전체 조회

| 구분 | 내용 |
|----|----|
| Method | GET |
| URL | /schedules |
| Description | 등록된 전체 일정을 조회한다. |
| Success Code | 200 OK |

**Response Example**
```json
[
    {
        "id": 1,
        "title": "첫 일정",
        "content": "포스트맨 테스트",
        "userId": 1,
        "userName": "효경",
        "createdAt": "2026-01-12T10:20:41.643639",
        "modifiedAt": "2026-01-12T10:20:41.643639"
    }
]

```

### 3️⃣ 일정 단건 조회

| 구분 | 내용 |
|----|----|
| Method | GET |
| URL | /schedules/{id} |
| Description | 특정 일정 1개를 조회한다. |
| Success Code | 200 OK |

**Response Example**
```json
{
    "id": 1,
    "title": "첫 일정",
    "content": "포스트맨 테스트",
    "userId": 1,
    "userName": "효경",
    "createdAt": "2026-01-12T10:20:41.643639",
    "modifiedAt": "2026-01-12T10:20:41.643639"
}
```

### 4️⃣ 일정 수정

| 구분 | 내용 |
|----|----|
| Method | PUT |
| URL | /schedules/{id} |
| Description | 특정 일정 정보를를 수정한다. |
| Body | title, content |
| Success Code | 200 OK |

**Request Example**
```json
{
    "title" : "첫 일정2",
    "content" : "포스트맨 수정"
}

```

**Response Example**
```json
{
    "id": 1,
    "title": "첫 일정2",
    "content": "포스트맨 수정",
    "userId": 1,
    "userName": "효경",
    "createdAt": "2026-01-12T10:20:41.643639",
    "modifiedAt": "2026-01-12T10:20:41.643639"
}

```

### 5️⃣ 일정 삭제

| 구분 | 내용 |
|----|----|
| Method | DELETE |
| URL | /schedules/{id} |
| Description | 특정 일정 정보를 삭제한다. |
| Success Code | 200 OK |

---

## ✅ 일정 관리 앱 (User)

### 1️⃣ 유저 생성

| 구분 | 내용 |
|----|----|
| Method | POST |
| URL | /users |
| Description | 새로운 유저를 생성한다. |
| Body | name, email, password |
| Success Code | 201 CREATED |

**Request Example**
```json
{
    "name" : "효경",
    "email": "a@a.com",
    "password": "12345678"
}

```

**Response Example**
```json
{
    "id": 2,
    "name": "효경",
    "email": "a@a.com",
    "createdAt": "2026-01-12T10:24:12.2462144",
    "modifiedAt": "2026-01-12T10:24:12.2462144"
}

```

### 2️⃣ 유저 전체 조회

| 구분 | 내용 |
|----|----|
| Method | GET |
| URL | /users |
| Description | 등록된 전체 유저를 조회한다. |
| Success Code | 200 OK |

**Response Example**
```json
[
    {
        "id": 1,
        "name": "효경",
        "email": "a@a.com",
        "createdAt": "2026-01-12T10:16:27.847928",
        "modifiedAt": "2026-01-12T10:16:27.847928"
    },
    {
        "id": 2,
        "name": "효경",
        "email": "a@a.com",
        "createdAt": "2026-01-12T10:24:12.246214",
        "modifiedAt": "2026-01-12T10:24:12.246214"
    }
]

```

### 3️⃣ 유저 단건 조회

| 구분 | 내용 |
|----|----|
| Method | GET |
| URL | /users/{id} |
| Description | 특정 유저 1개를 조회한다. |
| Success Code | 200 OK |

**Response Example**
```json
{
    "id": 2,
    "name": "효경",
    "email": "a@a.com",
    "createdAt": "2026-01-12T10:24:12.246214",
    "modifiedAt": "2026-01-12T10:24:12.246214"
}

```

### 4️⃣ 유저 수정

| 구분 | 내용 |
|----|----|
| Method | PUT |
| URL | /users/{id} |
| Description | 특정 유저 정보를 수정한다. |
| Body | name, email |
| Success Code | 200 OK |

**Request Example**
```json
{
  "name": "효경2",
  "email": "b@b.com"
}

```

**Response Example**
```json
{
    "id": 1,
    "name": "효경2",
    "email": "b@b.com",
    "createdAt": "2026-01-12T10:16:27.847928",
    "modifiedAt": "2026-01-12T10:16:27.847928"
}

```

### 5️⃣ 유저 삭제  

| 구분 | 내용 |
|----|----|
| Method | DELETE |
| URL | /users/{id} |
| Description | 특정 유저 정보를 삭제한다. |
| Success Code | 200 OK |

---

## ✅ 일정 관리 앱 (회원가입/로그인)

### 1️⃣ 회원가입
| 구분 | 내용 |
|----|----|
| Method | POST |
| URL | /singup |
| Description | 회원가입을 진행한다. |
| Body | name, email, password |
| Success Code | 201 CREATED |

**Request Example**
```json
{
  "name": "효경",
  "email": "a@a.com",
  "password": "12345678"
}

```

**Response Example**
```json
{
    "userId": 1,
    "name": "효경",
    "email": "a@a.com",
    "createdAt": "2026-01-12T10:16:27.8479279",
    "modifiedAt": "2026-01-12T10:16:27.8479279"
}

```

### 2️⃣ 로그인

| 구분 | 내용 |
|----|----|
| Method | POST |
| URL | /signin |
| Description | 로그인을 진행한다. |
| Success Code | 200 OK |

**Request Example**
```json
{
  "email": "a@a.com",
  "password": "12345678"
}

```

**Response Example**
```json
success

```

### 3️⃣ 로그아웃
| 구분 | 내용 |
|----|----|
| Method | POST |
| URL | /logout |
| Description | 로그아웃을 진행한다. |
| Success Code | 204 No Content |

**Response Example**
```json
{
  "email": "a@a.com",
  "password": "12345678"
}
```
