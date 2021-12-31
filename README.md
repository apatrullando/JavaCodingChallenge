# JavaCodingChallenge

NOTES:
The current version of the Service does not allow for multiple phone numbers.
This is my first time usting H2 and Hibernate and was not able to make it work before the deadline.
This is the current JSON structure below.
{
  "name": {
    "first": "Harold",
    "middle": "Francis",
    "last": "Gilkey"
  },
  "address": {
    "street": "8360 High Autumn Row",
    "city": "Cannon",
    "state": "Delaware",
    "zip": "19797"
  },
  "phone": {
      "number": "302-611-9148",
      "type": "home"
    },
  "email": "harold.gilkey@yahoo.com"
}

Below I added a few curl statements used to test the different endpoints:
#Add
curl -X POST http://localhost:8080/assessment/contacts -H 'Content-Type: application/json' -d '{"id": 101,"name": {"first": "Juan", "middle": "M", "last": "Pepper" }, "address": { "street": "1 Main St", "city": "Luri", "state": "Ohio", "zip": "23456" },"phone": { "number": "389-999-2222", "type": "home" },"email": "burgerlove@hotmail.com"}'

#Delete
curl -X DELETE http://localhost:8080/assessment/contacts/1

#Update
curl -X PUT http://localhost:8080/assessment/contacts/2 -H 'Content-Type: application/json' -d '{"name": {"first": "Juan", "middle": "M", "last": "Pepper" }, "address": { "street": "1 Main St", "city": "Luri", "state": "Ohio", "zip": "23456" },"phone": { "number": "999-999-9999", "type": "home" },"email": "burgerlove@hotmail.com"}'
