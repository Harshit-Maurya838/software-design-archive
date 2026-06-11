# API Design Template

## [Endpoint Name / Description]
**URL**: `/api/v1/...`
**Method**: `GET` | `POST` | `PUT` | `DELETE`

### Description
Brief explanation of what this endpoint does.

### Headers
* `Authorization: Bearer <token>`
* `Content-Type: application/json`

### Request Body (if applicable)
```json
{
  "field1": "value1",
  "field2": "value2"
}
```

### Path Parameters / Query Parameters
* `id` (string): The unique identifier.
* `limit` (int): Number of items to return.

### Response (Success)
**Code**: `200 OK`
```json
{
  "data": {
    "id": "123",
    "status": "success"
  }
}
```

### Response (Error)
**Code**: `400 Bad Request` or `404 Not Found`
```json
{
  "error": {
    "code": "INVALID_INPUT",
    "message": "Field 'x' is required."
  }
}
```
