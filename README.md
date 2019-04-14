# Telecoms API
This project creates a simple API for an imaginary telecoms provider.

## Table of Contents
1. [Building](#building)
2. [Running The Application](#running-the-application)
3. [API Endpoints](#api-endpoints)

## Building
Open a command window in the telecoms-api project and run: ```mvn package -Prunnable-war```

This will create a jar which contains a standalone Tomcat 7 server with the Telecoms API WAR deployed to it.

## Running The Application
Run the JAR that you either built from the previous step, or downloaded from the releases tab by running:

```java -jar telecoms-api-1.0.jar```

Open your internet browser and navigate to: <http://localhost:8080/api/> 

## API Endpoints
1. [Get All Phone Numbers](#1-get-all-phone-numbers) - ```GET /api/numbers/```
2. [Get A Customer's Phone Numbers](#2-get-a-customers-phone-numbers) - ```GET /api/numbers/?customer:id```
3. [Activate A Phone Number](#3-activate-a-phone-number) - ```GET /api/numbers/?activate:phoneNumber```

### 1. Get All Phone Numbers
Get an array of all phone numbers.

**URL** : ```/api/numbers/```

**Method** : ```GET```

**Auth Required** : NO

**Permissions Required** : None

#### Response Example
```
[
  {
    "number": "1",
    "activated": false
  },
  {
    "number": "2",
    "activated": false
  },
  {
    "number": "3",
    "activated": false
  },
  {
    "number": "4",
    "activated": false
  },
  {
    "number": "5",
    "activated": false
  },
  {
    "number": "6",
    "activated": false
  },
  {
    "number": "7",
    "activated": false
  },
  {
    "number": "8",
    "activated": false
  },
  {
    "number": "9",
    "activated": false
  },
  {
    "number": "10",
    "activated": false
  }
]
```

### 2. Get A Customer's Phone Numbers
Get an array of all phone numbers associated with a given customer.

**URL** : ```/api/numbers/?customer:id```

**Method** : ```GET```

**Auth Required** : NO

**Permissions Required** : None

#### Response Example
```
[
  {
    "number": "1",
    "activated": false
  },
  {
    "number": "2",
    "activated": false
  },
  {
    "number": "3",
    "activated": false
  }
]
```

### 3. Activate A Phone Number
Activate a given phone number.

**URL** : ```/api/numbers/?activate:phoneNumber```

**Method** : ```GET```

**Auth Required** : NO

**Permissions Required** : None

#### Response Example
##### Success Response
```
{
  "message": "Phone number was activated successfully."
}
```

##### Error Response
```
{
  "message": "Phone number not found!"
}
```
