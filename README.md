
<h1>Frickr’s Photo App</h1>

<h2> App Functionality </h2>

An App to help users to view Flickr photos. The App uses the Flickr image search API and shows the results in a 3-column scrollable view. It supports the following functionality

1) Endless scrolling i.e. automatically requesting and displaying more images when the user scrolls to the bottom of the list
2) Showing title and image, image lazy loading
3) It correctly handles orientation changes
4) Refresh mechanism
5) Property error handles i.e network connectivity error, server error
6) Support the latest version of Android OS and minimum support version Android 8.0 (API level 26)

Tech-Stack

To implement this project the following technologies have been used

Architecture

MVP:

MVP design patterns has been implemented for the architecture of this project. MVP (Model View Presenter) pattern is a derivative from the well known MVC (Model View Controller), and one of the most popular patterns to organize the presentation layer in Android Applications.

<img width="531" alt="Screen Shot 2021-03-21 at 4 01 08 pm" src="https://user-images.githubusercontent.com/10892760/111898117-1fd9ad00-8a78-11eb-8fce-41093af43342.png">

* Picasso (For displaying images)

* Dragger 2: (For Dependency Injection)

* RxJava

* Retrofit (For Networking)

* OkHttp

* GSON

* Mokito

* Kotlin
