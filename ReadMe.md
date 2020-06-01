# Google search results counter
This is simple Java console application.
Its main purpose is to display total count of Google search query.
There are two modes:
* you can put Google search link (ex. https://www.google.com/search?q=java+jsoup)
* you can put words for Google search query (ex. "java jsoup")

Jsoup library is used for Google search page parsing. https://jsoup.org/

Build Maven command "mvn clean package" creates jar file with dependencies inside.

## Application run
You can find built application in the current folder.
Its name is google-search-counter-1.0.0.jar.
You can run the application on your Windows PC with preinstalled Java version 8 (1.8) or higher
if you download both file google-search-counter-1.0.0.jar and google-search-counter-1.0.0.bat,
put them in one folder and click on google-search-counter-1.0.0.bat.
It starts command console with a dialog.

## Note
Please notice, Google returns different total number of search results in different browsers.
That's why results in application can be another than results in your usual browser. 