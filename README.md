# minesweeper-API-client
Solution by Leandro Deveikis <leandro.deveikis@gmail.com>

This API client solution presented for the [Minesweeper challenge](challenge.md)

This was developed in Kotlin, using the following libraries
* [Fuel](https://github.com/kittinunf/fuel): HTTP networking library
* [Gson](https://github.com/google/gson): Json parsing library

No more libraries were added to keep the client as small as possible.

The solution is represented in 2 main clients, which provide the services exposed at the server:
* GameClient
    * getGame
    * createGame
    * flag
    * click
* PlayerClient
    * getPlayer
    * createPlayer

There is also InfoClient, but only consults the version information at the deployed app.
    
The model is also represented in the classes under the package 'com.minesweeper.client'

The tests function also as example of the usage of the library (GameClientTest, PlayerTest)

As this exercise was develop under a time constrain, there are some improvements that can be done, for example:
* The tests are using the real services of the application (deployed at Heroku servers), this is wrong, and a mocking library should be included to avoid side-effect.
* Configuration of the client should be exposed to the user for easily maintenance, for example, url or libraries to use.
* An AbstractClient class can be develop to group some common functionality.
* Improve error handling