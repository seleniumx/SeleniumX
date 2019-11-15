FROM selenium/standalone-chrome
LABEL authors = Aravinda<aravinda@seleniumx.com>

RUN sudo apt-get update \
  && sudo apt install maven -y \
  && mvn -version

RUN sudo apt-get install openjdk-8-jdk -y \
  && java -version