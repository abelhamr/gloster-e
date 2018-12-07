# Bienvenue sur Gloster-e

	Le schema ci-dessous présente la vue globale de notre projet , tel que Gloster-E c'est un batsh as a service qui
	exécute une logique métier derrière.

![Gloster-e](https://raw.githubusercontent.com/marocraft/gloster-e/develop/Baas.JPG?raw=true)

# Gloster-E

        Plusieurs projets ont besoin d'un traitement batch ,et cela nous a amenés de réaliser un patterne sous forme d'un microservice
	configurable qui va s'adapter avec les besoins complexes d'un projet infomatique dans un contexte d'entreprise dans
	lequel plusieurs projets veulent executer des traitements batch avec une certaine logique.
 
## Quick start
      exigence:
       - SGBDR MySql
       - JAVA
       - MAVEN
      1) configuration de la base de données  
      2) cloner le projet : git clone https://github.com/marocraft/gloster-e.git
      3) cd gloster-e
      4) lancer mvn clean install 
      5) mvn package && java -jar target/gloster-e-0.0.1-SNAPSHOT.jar

## Les fonctionnalités

      -Creation compte projet
      -Creation d'une configuration pour un batch
          -action (Write/Read)
          -config
              -time execution
              -type source (file/database)
              -url input
              -type output data
          -logique transformation pour les données (Groovy script)
          
## Todo (Next Steps)

      1-Creation d'une API pour céer un compte
      2-Creation d'une API pour valider et persister une configuration
      3-Ceation d'une fonction pour valider un code Groovy
      4-Creation d'une logique pour mesurer le coté de la securité de code Groovy
