# Start with a base image containing Java runtime and Maven
FROM maven:3.8.4-openjdk-17 as build

# Copy the project files into the container
COPY src /phamquyen/spring-mvc/src
COPY pom.xml /phamquyen/spring-mvc

# Set the working directory
WORKDIR /phamquyen/spring-mvc

# Build the application as a WAR file and skip tests
RUN mvn clean package -DskipTests


FROM openjdk:17-slim


# Copy WAR file to the webapps directory in Tomcat
# Ensure that the path to the WAR file matches the actual file name generated by Maven
COPY --from=build /phamquyen/spring-mvc/target/*.war /phamquyen/spring-mvc/app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/phamquyen/spring-mvc/app.war"]