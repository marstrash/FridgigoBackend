# FridgiGo 
### Backend für die App Fridgigo
***
Diese App hilft dem Nutzer seine wöchentlichen Mahlzeiten zu planen und organisieren.

Diese spezielle Bibliothek stellt dabei das Backend der Anwendung dar, welches zusammen mit dem Frontend (t) benutzt werden sollte.

## Technologien
***
* Framework: Spring
* Packetmanager: Maven
* Plugin für die Datenbank-Abfragen: Hibernate


## Setup
***
Um dieses Projekt auszuführen, installieren Sie es lokal mit 
`maven install`;<br/>
Führen Sie das Projekt mit `spring-boot:run` aus

## Aufbau der App
***
* um ein interkatives UI zu erhalten, führen Sie bitte das bereits benannte  Frontend "Planti" (https://github.com/Johanna0708/Planti.git) aus

1. BackendFridgiGoApplication:
    * Hauptklasse, beinhaltet die zum Starten notwendige Main-Funktion
    * APIs:
      * http://localhost:8080/fridgigo/show: Gibt ein einzelnes Rezept nach seiner ID zurück
        * Parameter: 
          * ID: Die RezeptID des geforderten Rezepts
      * http://localhost:8080/fridgigo/showall: Gibt eine Liste aller auf der Datenbank befindlichen Rezepte zurück, quasi ein "Dump"
   
     
      * http://localhost:8080/fridgigo/adduser: Persistiert ein User-Objekt mit den eingegebenen Nutzer-Daten; Gibt nur "200" zurück
        * Parameter: 
          * username: Nutzername, der persistiert werden soll
          * pw: Passwort, das persisitert werden soll
      * http://localhost:8080/fridgigo/Rezept2: Gibt eine Liste aller Pflanzen, die einen Sensor haben zurück
     

2. DB:
    * Klasse, welche die Persistenz/ORM-bezogenen Funktionen bietet
    * Funktionen:
      * callRezeptById: Ruft ein Rezeptobjekt nach seiner ID aus der Datenbank ab
      * callAllRezepte: Ruft eine Liste aller gespeicherten Rezepte aus der Datenbank ab
      * persist: Persistiert das eingegebene Objekt
      * callUserByName: Ruft ein Nutzerobjekt (Nutzerdaten) nach seinem Nutzernamen aus der Datenbank ab
      * callZutatById: Ruft ein Zutatobjekt nach seiner ID aus der Datenbank ab
      * callAllZutat: Ruft eine Liste aller gespeicherten Zutaten aus der Datenbank ab


3. Miscellaneous:
    * Diverse Funktionen, die so häufig vorkamen oder so lang waren, dass sie zwecks Lesbarkeit ausgelagert wurden
    * Funktionen:
      * getHTTPOutput: Ruft den Output des eingegeben Links ab und gibt diesen zurück
      * MapObject: Wandelt das übergebene (einzelne) Objekt in einen String um
      * MapObjectList: Wandelt die übergebene Array-Liste in einen String um