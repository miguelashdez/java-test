# Evaluación Java Nisum

## Ruta de los servicios:

```
Get
http://localhost:8080/api/users

JSON de respuesta inicial:

[
    {
        "idUser": 1,
        "name": "Miguel",
        "email": "miguel@domain.com",
        "password": "12Miguel",
        "phones": [
            {
                "idPhone": 1,
                "number": "0000000000",
                "cityCode": 241,
                "countryCode": 52
            },
            {
                "idPhone": 2,
                "number": "1111111111",
                "cityCode": 241,
                "countryCode": 52
            },
            {
                "idPhone": 3,
                "number": "2222222222",
                "cityCode": 241,
                "countryCode": 52
            }
        ],
        "created": null,
        "modified": null,
        "lastLogin": null,
        "token": null,
        "isActive": null
    },
    {
        "idUser": 2,
        "name": "Santiago",
        "email": "santiago@domain.com",
        "password": "07Santi",
        "phones": [
            {
                "idPhone": 4,
                "number": "3333333333",
                "cityCode": 55,
                "countryCode": 52
            }
        ],
        "created": null,
        "modified": null,
        "lastLogin": null,
        "token": null,
        "isActive": null
    }
]

Post
http://localhost:8080/api/users

Put
http://localhost:8080/api/users/id

Put (eliminar ya que es una baja lógica)
http://localhost:8080/api/users/delete/id
```

## Se pueden utilizar los siguientes datos para crear un usuario

```
----- JSON de entrada, ejemplo 1 -----
{
    "name": "User1",
    "email": "user1@domain.com",
    "password": "10User",
    "phones": [
        {
            "number": "4444444444",
            "cityCode": 55,
            "countryCode": 52
        }
    ]
}

----- Respuesta, ejemplo 1 -----

{
    "idUser": 3,
    "name": "User1",
    "email": "user1@domain.com",
    "password": "10User",
    "phones": [
        {
            "idPhone": 5,
            "number": "4444444444",
            "cityCode": 55,
            "countryCode": 52
        }
    ],
    "created": "2021-01-14T00:18:51.915+00:00",
    "modified": null,
    "lastLogin": "2021-01-14T00:18:51.915+00:00",
    "token": "6bd75ede-5586-4ec2-bd1c-27308eab47f1",
    "isActive": 1
}

----- JSON de entrada, ejemplo 2 -----

{
    "name": "User2",
    "email": "user2@domain.com",
    "password": "12User",
    "phones": [
        {
            "number": "5555555555",
            "cityCode": 55,
            "countryCode": 52
        },
        {
            "number": "6666666666",
            "cityCode": 55,
            "countryCode": 52
        }
    ]
}

----- Respuesta, ejemplo 2 -----

{
    "idUser": 4,
    "name": "User2",
    "email": "user2@domain.com",
    "password": "12User",
    "phones": [
        {
            "idPhone": 6,
            "number": "5555555555",
            "cityCode": 55,
            "countryCode": 52
        },
        {
            "idPhone": 7,
            "number": "6666666666",
            "cityCode": 55,
            "countryCode": 52
        }
    ],
    "created": "2021-01-14T00:22:34.855+00:00",
    "modified": null,
    "lastLogin": "2021-01-14T00:22:34.855+00:00",
    "token": "3373e10a-01af-4c7f-999c-5e99b9dc0f47",
    "isActive": 1
}
```

## Se pueden utilizar los siguientes datos para editar un usuario

```
----- JSON de entrada -----

{
    "name": "Update",
    "email": "update@domain.com",
    "password": "12Miguel",
    "phones": [
        {
            "idPhone": 1,
            "number": "0000000000",
            "cityCode": 241,
            "countryCode": 52
        }
    ]
}

----- Respuesta -----
{
    "idUser": 1,
    "name": "Update",
    "email": "update@domain.com",
    "password": "12Miguel",
    "phones": [
        {
            "idPhone": 1,
            "number": "0000000000",
            "cityCode": 241,
            "countryCode": 52
        }
    ],
    "created": null,
    "modified": "2021-01-14T00:24:58.174+00:00",
    "lastLogin": null,
    "token": null,
    "isActive": null
}
```

## Se pueden utilizar los siguientes datos para eliminar un usuario (baja lógica)

```
----- Respuesta -----

{
    "idUser": 1,
    "name": "Update",
    "email": "update@domain.com",
    "password": "12Miguel",
    "phones": [
        {
            "idPhone": 1,
            "number": "0000000000",
            "cityCode": 241,
            "countryCode": 52
        }
    ],
    "created": null,
    "modified": "2021-01-13",
    "lastLogin": null,
    "token": null,
    "isActive": 2
}
```

## Formato de mensajes de error

```
----- Ejemplo 1 -----

{
    "password": "Field 'Password' is required.",
    "name": "Field 'Name' is required.",
    "email": "Field 'Email' is required."
}

----- Ejemplo 2 -----

{
    "password": "Field 'Password' must have a correct format.",
    "email": "Field 'Email' must have a correct format."
}
```