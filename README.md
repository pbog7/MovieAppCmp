This is a Kotlin Multiplatform project targeting Android, iOS.

This project uses TMDB API, the API key is contained in a file that is ignored by git so if you want to run this app you must register to get a free API key in https://developer.themoviedb.org/docs/getting-started.
You need to add a secrets.properties file and inside it two keys API_KEY_DEV and API_KEY_PROD. TMDB gives you one key but I wanted to add configurations for different environments like a real project would have. 

I have used clean architecture with modularization. Domain and data layer have their own module and in presentation layer we have 2 different types of module:
1. Library module - reusable feature that can be used in multiple parts of the app, for example moviesList can be used in multiple screens where we want to show a list of movies, 
the core module that contains reusable code that is used by all modules in presentation layer. 
2. Feature module - contains everything needed to implement a specific app feature or screen, such as UI and ViewModel. The feature module can depend on domain, core and library modules.

