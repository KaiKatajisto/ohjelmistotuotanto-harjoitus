# Vaihe 1: Käytetään pohjana Java 17 -imagea (sama kuin kehityksessä)
FROM eclipse-temurin:17-jdk-alpine

# Lisätään metadataa (hyvä tapa)
LABEL maintainer="sinun.sähköposti@example.com"

# Luodaan tilapäinen levyalue (Spring Bootin optimointi)
VOLUME /tmp

# Kopioidaan käännetty JAR-tiedosto kontin sisään ja nimetään se app.jar:ksi
COPY target/*.jar app.jar

# Kerrotaan, että sovellus kuuntelee porttia 8080
EXPOSE 8080

# Määritellään komento, jolla sovellus käynnistyy
ENTRYPOINT ["java","-jar","/app.jar"]