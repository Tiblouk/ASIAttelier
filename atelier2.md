# l'Atelier 2 :

**Q1 : Qu’est ce que des Services Web Full Rest ? Quelles sont les contraintes imposées par ce type de service ?**


- Les Services Web Full Rest (ou RESTful Web Services) sont un style d'architecture basé sur les principes de l'architecture REST, utilisant le protocole HTTP et les principes du web.

**Q2 : Qu’est-ce qu’une application classique Entreprise Java Application ? Donner un exemple d’usage avec web service, JSP, JavaBean, EJB et JMS.**


- Les contraintes imposées par les Services Web Full Rest sont : l'architecture client-serveur, l'étatless (sans état), l'interface uniforme, le système de cache, les couches et le code à la demande.

**Q3 : Qu’est-ce que Spring ? qu’apporte Spring boot vis-à-vis de Spring ?**


- Une application classique d'entreprise en Java suit le modèle d'architecture multi-niveaux et comprend des couches de présentation, métier, d'accès aux données, d'intégration et de messagerie. Elle utilise des technologies telles que les web services, les JSP, les JavaBeans, les EJB et les JMS.

**Q4 : Qu’est-ce que Spring Boot ? Quels sont les points communs/différences entre JEE et Spring Boot ?**


- Spring est un framework open source pour le développement d'applications Java, et Spring Boot est une extension de Spring qui simplifie la configuration et le déploiement des applications Spring.

**Q5 : Qu’est-ce qu’une annotation ? Quels apports présentent les Annotations ?**

- Une annotation est une forme de métadonnées ajoutée au code Java avec le symbole @, elle offre plusieurs avantages tels que l'amélioration de la documentation et la simplification de la configuration.

**Q6 : Comment fait-on pour créer un Web Service Rest avec Spring Boot ?**

- Pour créer un Web Service Rest avec Spring Boot, il faut configurer un projet Spring Boot avec les dépendances nécessaires, créer un contrôleur annoté avec @RestController, implémenter les méthodes du contrôleur avec des annotations telles que @RequestMapping, et tester le Web Service en exécutant l'application et en utilisant un client REST.

**Q7 : Qu’est-ce qu’un container de Servlet ? Comment fonctionne un container de Servlet ?**

- Un container de Servlet est un composant d'un serveur d'applications qui gère le cycle de vie et l'exécution des servlets. Il reçoit les requêtes, routage vers le servlet approprié, instanciation et initialisation du servlet, traitement de la requête, génération de la réponse et envoi de la réponse au client.

**Q8 : Expliquer la philosophie « Convention over Configuration » de Spring boot ?**

- La philosophie "Convention over Configuration" de Spring Boot vise à réduire la configuration explicite en fournissant des conventions et des configurations par défaut intelligentes.

**Q9 : Expliquer ce qu’il se passe lors de l’exécution «SpringApplication .run(App.class,args) » Qu’est ce qu’un DAO ? En quoi est-ce intéressant d’utiliser ce pattern ? Qu’est ce qu’un Singleton ? Que permet de réaliser les Entity dans Spring boot ? Est-ce spécifique à SpringBoot ?**

- L'exécution "SpringApplication.run(App.class, args)" initialise l'application Spring Boot en démarrant le conteneur Spring, en analysant la configuration et en lançant l'application en tant qu'application Spring Boot autonome.

**Q10 : DAO (Data Access Object) ? interets ?**

- Un DAO (Data Access Object) est un modèle de conception qui permet d'encapsuler l'accès aux données de la couche de persistance dans une application. Il facilite la séparation de la logique métier de l'accès aux données et améliore la maintenabilité et la modularité du code.



- Les entités dans Spring Boot sont des classes POJO qui représentent des objets persistants, généralement mappés à des tables dans une base de données relationnelle. Spring Boot facilite l'utilisation des entités avec le framework Java Persistence API (JPA).