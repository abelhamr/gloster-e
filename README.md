# Bienvenue sur Gloster-e


![Gloster-e](https://raw.githubusercontent.com/marocraft/gloster-e/master/Plan%20de%20travail%205%20copie%206%403x.png?raw=true)


      C'est microservice batch
      C'est un point d'entrée de plusieurs projets qui veulent faire des triatments batch
      C'est un microservice paramètrable selon le besoin
      C'est un nouveau patterne pour mettre en ouvere la logique batch en relation avec plusieurs projets

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
