# Project Name

Pet Store APIs

## About the Services

All these sevices internall calls actual endpoint provided(http://petstore-demo-endpoint.execute-api.com/petstore/pets) and perform the operations

* GET PET by ID: http://localhost:8080/all-pets/n (n is pet id)
* GET ALL PETs: http://localhost:8080/all-pets/
* POST PET : http://localhost:8080/pets below is sample request body

{
"id": 6,
"type": "zz",
"price": 12,
"additionalProperties": {}
}

## DELETE PET DESIGN

* DELETE PET by ID: http://localhost:8080/all-pets/n (n is the path variable which we delete through this request)