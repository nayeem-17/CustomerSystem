This service contains a set if endpoints
-    Functionality to search for and obtain a list of customers.

      `POST localhost:8080/api/v01/customer/{name}`

     the response will be the list of Customer information with this `name`.

-    Functionality to create a new customer with the head office address
      `POST localhost:8080/api/v01/customer`
        the request body will be the information of a customer
        ```json
        {
            "identificationNumber":"",
            "identificationType":"",
            "name":"",
            "email":"",
            "cellPhone":"",
            "mainProvince":"",
            "mainCity":"",
            "mainAddress":""
        }

        ```
    

-    Functionality to edit customer data
      `PUT localhost:8080/api/v01/customer/{identificationNumber}`
        the request body will be the information of a customer
        ```json
        {
            "identificationNumber":"",
            "identificationType":"",
            "name":"",
            "email":"",
            "cellPhone":"",
            "address" : [
                {
                    "mainProvince":"",
                    "mainCity":"",
                    "mainAddress":""
                }
            ]
        }

        ```
    
-    Functionality to delete a customer
      `DELETE localhost:8080/api/v01/customer/{identificationNumber}`

-    Functionality to register a new address per customer
      `POST localhost:8080/api/v01/customer/{identificationNumber}/address`

     the request body 

        ```json
    
            [
                    {
                        "mainProvince":"",
                        "mainCity":"",
                        "mainAddress":""
                    }
                ]
        ```
    
-    Functionality to list the additional addresses of the customer
      `GET localhost:8080/api/v01/customer/{identificationNumber}/address`

     the response is
        ```json

            [
                    {
                        "mainProvince":"",
                        "mainCity":"",
                        "mainAddress":""
                    }
                ]
        ```