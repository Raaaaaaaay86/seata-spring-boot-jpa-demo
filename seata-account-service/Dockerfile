FROM openjdk:11.0.14.1-oraclelinux7

COPY ./target/*.jar /Documents/mydocker/demo.jar

WORKDIR /Documents/mydocker

RUN sh -c 'touch demo.jar'

ENTRYPOINT ["java","-jar","demo.jar"]