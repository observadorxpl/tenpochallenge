FROM openjdk:21-ea-1-jdk-oracle
VOLUME /tmp
ADD ./target/tenpochallenge-0.0.1-SNAPSHOT.jar tenpochallenge.jar
ENTRYPOINT ["java","-jar","/tenpochallenge.jar"]