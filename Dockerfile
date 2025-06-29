# Utilise une image Java officielle
FROM openjdk:17-jdk-slim

# Port exposé
EXPOSE 8080

# Copie le jar généré dans le conteneur
COPY target/portfolio-service-0.0.1-SNAPSHOT.jar app.jar

# Commande d'exécution
ENTRYPOINT ["java", "-jar", "/app.jar"]
