DESCRIPTION 
This project lets us build a simple Twitter client that supports viewing a Twitter timeline and composing a new tweet.

LiceCap GIF is here https://www.dropbox.com/s/7jso0jf3w8szysu/BasicTwitter_LiceCap.gif
You may need to download the file first and then play in browser (~32MB)

Thank you for taking a look.

PROJECT OVERVIEW

A) This assignment took ~10 hrs to complete

B) All required stories are complete

User can sign in to Twitter using OAuth login

User can view the tweets from their home timeline
-User should be able to see the username, name, body and timestamp for each tweet
-User should be displayed the relative timestamp for a tweet "8m", "7h"
-User can view more tweets as they scroll with infinite pagination

User can compose a new tweet
-User can click a “Compose” icon in the Action Bar on the top right
-User can then enter a new tweet and post this to twitter
-User is taken back to home timeline with new tweet visible in timeline

INSTALLATION

This project is simple to compile from given source, or you may consider installing the binary. You will also need the libraries mentioned below.

LICENSE

Programmed and written entirely by mriat

ACKNOWLEDGEMENTS

The following libraries are used to make this possible:

 * [scribe-java](https://github.com/fernandezpablo85/scribe-java) - Simple OAuth library for handling the authentication flow.
 * [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
 * [codepath-oauth](https://github.com/thecodepath/android-oauth-handler) - Custom-built library for managing OAuth authentication and signing of requests
 * [UniversalImageLoader](https://github.com/nostra13/Android-Universal-Image-Loader) - Used for async image loading and caching them in memory and on disk.
 * [ActiveAndroid](https://github.com/pardom/ActiveAndroid) - Simple ORM for persisting a local SQLite database on the Android device

(Library) Android Async HTTP Client
(Library) codepath-oauth-0.3.0
(Library) scribe-codepath
(Library) codepath-utils
