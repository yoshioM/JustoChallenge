# Justo Challenge
## Consume api random user 

Android application build with kotlin comsume REST - Randomuser API https://randomuser.me/api/

## Features

- Consume Rest API to get json response
- Shows a list of users with partial view of the information
- When selecting an element from the list, the detail is shown as well as the location on the map
- When the user clicks the "add user" button, the web service is invoked and the information is stored in the local database.
- When the user clicks the "clear all users" button, the information stored in the local database is deleted


## Tech

Used libraries and technologies

- [Retrofit] - for rest api consumption
- [Room] - for data storage
- [Hilt] - for dependency injection
- [MVVM] - MVVM architecture 
- [GOOGLE MAPS] - for location display
- [GLIDE] - to display images from url
- [VIEW BINDING] - to access the graphic elements from the class


## Configuration google maps api key


To test the google map function it is necessary to add the google maps api key


Add maps api key obtained from https://console.cloud.google.com/apis/credentials in the google_maps_api.xml file in the google_maps_key parameter

```sh
    <string name="google_maps_key" templateMergeStrategy="preserve" translatable="false">ADD HERE GOOGLE API KEY</string>

```


to simulate QA and Production environments you must modify the "URL_DEV" and "URL_PROD" parameters in the gradle.properties file

```sh
URL_DEV = "https://randomuser.me/"
URL_PROD = "https://randomuser.me/"
```

## Running application
 
** First load from api rest, local storage and show in list **
![image](https://user-images.githubusercontent.com/32847159/178180044-715385a3-ed3c-419a-9fbb-a3826b9a22ef.png)

![image](https://user-images.githubusercontent.com/32847159/178180111-84b089f4-ca23-4dad-95a5-c2b1410e58b3.png)

![image](https://user-images.githubusercontent.com/32847159/178180124-31d068a1-f2d7-4a34-9a1d-6e39389fb70b.png)

![image](https://user-images.githubusercontent.com/32847159/178180159-4e4551d0-c8b0-4b8f-8213-1e4e79b3a559.png)

** clearing stored and displayed information **

![image](https://user-images.githubusercontent.com/32847159/178180369-b0f4a402-24ea-4fd9-9e82-bcce842a179f.png)

 




   [Retrofit]: <https://square.github.io/retrofit/>
   [ROOM]: <https://developer.android.com/jetpack/androidx/releases/room?gclid=Cj0KCQjw8amWBhCYARIsADqZJoV_TqmgdJDVwo-kfm7bU6sF7i0SZTwrgViAsnvc5V3CZd6GUqCQFvsaAkbpEALw_wcB&gclsrc=aw.ds>
   [HILT]: <https://developer.android.com/training/dependency-injection/hilt-android?hl=es-419>
   [MVVM]: <https://developer.android.com/jetpack/guide?gclid=Cj0KCQjw8amWBhCYARIsADqZJoUD4F-KUr56evLLi0Gc9JFnOogx5Uq6G_wCpo6fhfoPHk0oZ2COX9oaAkTgEALw_wcB&gclsrc=aw.ds#recommended-app-arch>
   [GOOGLE MAPS]: <https://developers.google.com/maps/documentation/android-sdk/start?hl=es-419>
   [GLIDE]: <https://github.com/bumptech/glide>
   [VIEW BINDING]: <https://developer.android.com/topic/libraries/view-binding>
