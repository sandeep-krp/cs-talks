## Project structure

The folder `cs-talks` is the main parent folder of the project where all the modules reside

The folder `cs-talks-core-api` define all the specifications of the project. If there are new implentations are to be 
written, then those implementation modules will have to use this as a dependency. 

`cs-talks-memory-services` is one implementation of the api above. It saves all the objects in-memory and state is lost when 
the server restarts. A new module named `cs-talks-db` can be created to implement the same APIs and save states on restarts. 

The module `cs-talk-web` has the dependency of `cs-talks-memory-services` and exposes the RESTFul web-apis for the UI to interact with.

