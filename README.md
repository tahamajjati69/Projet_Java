# 📦 Projet Java Swing — Gestion Logistique 
  
  
### Colis • Livreurs • Livraisons

##  1. Objectif du Projet

Ce projet a pour objectif de développer une **application Java Swing**
permettant la gestion complète d'un système logistique : colis, livreurs
et livraisons.

##  2. Fonctionnalités Principales

###  Gestion des Colis

-   Ajouter un colis\
-   Modifier un colis\
-   Supprimer un colis\
-   Afficher tous les colis dans un tableau (`JTable`)\
-   Référence auto-incrémentée

###  Gestion des Livreurs

-   Ajouter un livreur\
-   Modifier / Supprimer\
-   Utilisation dans les livraisons

###  Gestion des Livraisons

-   Créer une livraison\
-   Assigner un colis + livreur\
-   Changer le statut (En cours, Livré, Annulé)\
-   Affichage complet des livraisons
-   Filtrage par Status
##  3. Architecture du Projet

    src/
    │
    ├── ui/
    │   ├── ColisUI.java
    │   ├── LivreurUI.java
    │   └── LivraisonUI.java
    │
    ├── services/
    │   ├── ColisService.java
    │   ├── LivreurService.java
    │   └── LivraisonService.java
    │
    ├── dao/
    │   ├── ColisDao.java
    │   ├── LivreurDao.java
    │   └── LivraisonDao.java
    │
    ├── entities/
    │   ├── Colis.java
    │   ├── Livreur.java
    │   └── Livraison.java
    │
    └── utils/
        └── DBConnection.java
##  4. Modèle relationnel du système de gestion des livraisons
<img width="1252" height="557" alt="image" src="https://github.com/user-attachments/assets/79b8fb9d-16db-4bb0-a552-204d556af207" />

##  5. Base de Données (MySQL)

``` sql
CREATE TABLE livreur (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100),
    zone VARCHAR(100),
    vehicule VARCHAR(50)
);

CREATE TABLE colis (
    reference INT PRIMARY KEY AUTO_INCREMENT,
    poids DOUBLE,
    villeDestination VARCHAR(150)
);

CREATE TABLE livraison (
    statut VARCHAR(50),
    dateLivraison DATE,
    colisRef INT,
    livreurId INT,
    PRIMARY KEY (colisRef, livreurId, dataLivraison),
    FOREIGN KEY (colisRef) REFERENCES colis(reference) ON DELETE CASCADE,
    FOREIGN KEY (livreurId) REFERENCES livreur(id) ON DELETE CASCADE
);
```

## 6. Exécution du programme (version installée)

### Installation

* Ouvrir le dossier `setup/`.
* Lancer le fichier `setup_logistique.exe` (créé avec Inno Setup).
* Suivre les étapes de l’assistant d’installation pour installer l’application sur ton PC.

### Base de données

* Démarrer XAMPP et activer **Apache** et **MySQL**.
* Ouvrir phpMyAdmin via `http://localhost/phpmyadmin`.
* Créer une base de données nommée `logistique`.
* Importer le fichier SQL situé dans le dossier :  
  * `## /base_des_donnees/logistique.sql`
* Vérifier que la classe `ConnexionSingleton` pointe bien vers :  
  * Serveur : `localhost`  
  * Base : `logistique`  
  * Utilisateur : `root`  
  * Mot de passe : *(vide par défaut sous XAMPP)*

### Lancement

* Après installation, un raccourci vers l’application est créé sur le bureau ou dans le menu démarrer.
* Double-cliquer pour lancer l’application.
* La fenêtre de connexion (`LoginMain`) s’ouvre.
* Se connecter avec :  
  * Email : `test@gmail.com`  
  * Mot de passe : `1234`

### Vidéo de démonstration






https://github.com/user-attachments/assets/b850ebe1-a70f-4538-863f-0d956c377926







## 👤 Auteur

Projet Java Swing --- Gestion Logistique\
Année 2025 <br>
 Mohamed Taha Majjati <br>
Instructor Mr.LACHGAR


