Movie search using a unidirectional state flow pattern
This is an attempt at coming up with a unidirectional state flow pattern that uses the concepts of patterns like Redux, Cycle.js, MVI etc.

Many of my contemporaries have already done amazing work in this area and I've drawn a lot of lessons and learnings from their work already:

The state of managing state with RxJava - JakeWharton
MVI patterns with Hannes Dorfmann - Hannes Dorfmann
LCE: Modeling Data Loading in RxJava - Laimonas
I wanted to achieve the benefits of this pattern without necessarily introducing any new libraries (aside from Rx). How would one familiar with an MVVM model today step to a world where all data flows in a single direction? I hope to demo those concepts with this app.

The app in itself is a simple movie searching app. Clicking the movie result populates a history list. While this is not an extremely complex app, it isn't a silly Hello World one either, so the hope is that it'll cover regular use cases for a basic application.

I've also started meaninful test cases in the repo.

Setting up your OMDB API KEY
We use the wonderful OMDB api to fetch movie information.

There are quotas on this api, so please don't use mine :)

Get an api key for OMDB here
Run this in a terminal like application
touch $HOME/.gradle/gradle.properties
echo "omdb_apikey=\"<API_KEY_GOES_HERE>\"" >> $HOME/.gradle/gradle.properties
You can read this post for instructions on this private api setting up process.

For great movie recommendations, ping me @kaushikgopal (seriously, I watch a lot of movies).

I gave a talk at MBLT}Dev 2018 on how I went about building this app. Slides can be found here.

iOS app
I gave another talk at Mobilization IX showing how we can use the same concepts on iOS too and wrote my first iOS app to demonstrate these concepts - You can check that out here.

