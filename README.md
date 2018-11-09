# Bienvenue sur Gloster-e


![Gloster-e](Plan de travail 5 copie 6@3x.png?raw=true)



      C'est microservice batch
      C'est un point d'entrée de plusieurs projets qui veulent faire des traitements batch
      C'est un microservice paramètrable selon le besoin du client
      C'est un nouveau patterne pour mettre en ouvere la logique batch en relation avec plusieurs projet

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
