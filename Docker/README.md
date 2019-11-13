SeleniumX now supports docker. You can run your SeleniuX maven test cases directly in the seleniumx/standalone-chrome docker image. 

Selenium Server default port will be 4444. Usercan use @ServerSettings annotation and set the port as 4444 to run the test case in the docker container

Docker image - [https://hub.docker.com/repository/docker/seleniumx/standalone-chrome](https://hub.docker.com/repository/docker/seleniumx/standalone-chrome)

If you want to run your test case in a CI platform, configure the following command at your CI YAML file. To avoid the conflict with default server port use different port (Eg. 5555)

```sudo java -Dwebdriver.chrome.driver="/opt/selenium/chromedriver-78.0.3904.70" -jar /opt/selenium/selenium-server-standalone.jar -port 5555 -log /opt/selenium/selenium.log```