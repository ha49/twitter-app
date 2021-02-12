# twitter-app

## POST: SIGNUP

__https://twitter2021.herokuapp.com/account/signup__ or

__http://localhost:8080/account/signup__

````
{
 "firstName":"myfirstName",
	"lastName":"myLastName",
	"email": "myname@email.com",
	"username":"me",
	"password":"1234"
}
````

## GET ALL USER DATA

__https://twitter2021.herokuapp.com/account/get/all__ or
__http://localhost:8080/account/get/all__

## GET SPECIFIC USER DATA

use one id from list above

__https://twitter2021.herokuapp.com/account/get/id__ or
__http://localhost:8080/account/get/id__

## GET RELATIONSHIP DATA (WHO FOLLOWS WHO)

__https://twitter2021.herokuapp.com/account/getrelationships__

__http://localhost:8080/getrelationships__

## 1. FOLLOW SOMEONE

Angelina follows Denzel

__https://twitter2021.herokuapp.com/account/follow__

__http://localhost:8080/account/follow__

````
{
    "follower": {
      "id":1
     
    },
    "followed": {
      "id": 7

    }
}
````

## 2. TWEET

Denzel tweets

### POST

__https://twitter2021.herokuapp.com/account/tweet__

````
{

"twitterUser": {
"id": 5,
"username": "Denzel"

},
"tweet": "Hello Everbody"

}
````

Angelina tweets

### POST

__https://twitter2021.herokuapp.com/account/tweet__

````
{

"twitterUser": {
"id": 1,

},
"tweet": "Hello Denzel"

}
````

## 3. SEE MY TIMELINE (Tweets of people I follow in reverse order)

__https://twitter2021.herokuapp.com/account/mytimeline/4__

## 4. SEE MY OWN TWEETS in reverse order

__https://twitter2021.herokuapp.com/account/mytweets/Tom__
__https://twitter2021.herokuapp.com/account/mytweets/Angelina__

## 5. LIST OF MY FOLLOWERS in alphabetic order (username)

__https://twitter2021.herokuapp.com/account/getfollowers/1__
__http://localhost:8080/account/getfollowers/1__