# l'Atelier 1 :

**Question 1 : Qu’est-ce que le pattern MVC ? Quels avantages présente-t-il ? Qu’est-ce que le Web dynamique ? pourquoi est-il intéressant ? Comment sont récupérés les fichiers par le Web Browser en Web statique ? Quels sont les avantages d’utiliser du Web Statique avec des services REST ?**

- Le pattern MVC est une architecture en 3-tiers qui sépare le modèle, la vue et le contrôleur. Les avantages incluent la séparation des préoccupations, la réutilisabilité du code et la possibilité de travailler simultanément sur différentes parties de l'application.

- Le Web dynamique permet de modifier le contenu en temps réel ou en fonction des demandes des utilisateurs. Il offre une flexibilité pour mettre à jour et personnaliser facilement le contenu, ce qui est utile pour les sites Web interactifs.

- Dans le Web statique, les fichiers sont pré-existants et sont servis tels quels au navigateur par le serveur web. Le navigateur les récupère via des requêtes HTTP standard.

- Les avantages d'utiliser du Web statique avec des services REST incluent la performance élevée, la possibilité de mettre en cache le contenu et la combinaison de l'approche statique avec des éléments dynamiques lorsque nécessaire.

**Question 2 : Qu’est-ce que les architectures N-Tiers ? Quels avantages apportent-elles ?**
- Les architectures N-Tiers divisent une application en couches distinctes, offrant des avantages tels que la séparation des préoccupations, la réutilisabilité, la scalabilité et la flexibilité.

**Question 3 : Comment fonction l’AJAX ?**

- AJAX (Asynchronous JavaScript And XML) est une technique permettant aux pages web de communiquer avec le serveur sans recharger la page entière, ce qui les rend plus réactives et interactives.

**Question 4 : Qu’est-ce que JEE ? Comment fonctionne un serveur JEE ? Qu’est-ce qu’un Web Container en JEE ?**

- JEE (Java Enterprise Edition) est une plateforme de développement d'applications d'entreprise en Java. Un serveur JEE est un environnement d'exécution pour les applications JEE, tandis qu'un Web Container gère l'exécution des composants web dans un environnement JEE.

**Question 5 : Qu’est-ce que Springboot ? quelles différences avec JEE ?**

- Spring Boot est un framework Java qui simplifie le développement d'applications en fournissant une configuration par défaut et des fonctionnalités intégrées. Il est plus léger et flexible que JEE, qui est une spécification plus complète pour les applications d'entreprise.

**Question 6 : Qu’apport Thymeleaf à Springboot ?**

- Thymeleaf est un moteur de templates utilisé avec Spring Boot pour générer des pages web dynamiques en intégrant facilement des données provenant du backend dans les templates HTML.

**Question 7 : Que signifie l’annotation @Controller, pourquoi est-elle importante lors de la génération de pas coté serveur ?**

- L'annotation @Controller est utilisée en Spring pour marquer une classe en tant que contrôleur responsable du traitement des requêtes HTTP. Elle joue un rôle clé dans le routage des requêtes et la génération des réponses dans une application Spring côté serveur.

**Question 8 : Que représente le répertoire ‘src/main/resources’ dans un projet SpringBoot ?** Quelles sont les informations stockées à cet endroit ?
- Le répertoire "src/main/resources" dans un projet Spring Boot est l'emplacement par défaut pour stocker les ressources non Java de l'application, telles que des fichiers de configuration, des fichiers statiques, des modèles de vues et des fichiers de données.