# Étape 1 : Build Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copier tout le code source + pom.xml
COPY . .

# Compiler et créer le JAR (sans tests ici car exécutés via Jenkins)
RUN mvn clean package -DskipTests

# Étape 2 : Image d'exécution
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copier le JAR depuis l'étape précédente
COPY --from=build /app/target/*.jar app.jar

# Exposer le port de l’application
EXPOSE 9090

# Commande de lancement
ENTRYPOINT ["java", "-jar", "app.jar"]
