# Planti GmbH
### Backend für die App Planti
***
Diese App hilft dem Nutzer den Wasserbedarf seiner Pflanze zu bestimmen.
Der Nutzer benötigt dafür einen Feuchtigkeitssensor, den er über The Things Network (https://eu1.cloud.thethings.network/console/applications) registriert.
Nach der Registrierung auf TTN kann der Sensor auf Planti eingetragen werden.
Der Sensor wird anschließend in die Blumenerde neben der Pflanze gesteckt und die App ruft nun über TTN die empfangenen Sensordaten ab.
Der Nutzer erhält immer dann eine Gieß-Info in der App, wenn die Pflanze nicht genug Wasser hat.
Diese spezielle Bibliothek stellt dabei das Backend der Anwendung dar, welches zusammen mit dem Frontend (https://github.com/Johanna0708/Planti.git) benutzt werden sollte.

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

1. BackendPlantiApplication:
    * Hauptklasse, beinhaltet die zum Starten notwendige Main-Funktion
    * APIs:
      * http://localhost:8080/planti/show: Gibt eine einzelne Pflanze nach ihrer ID zurück
        * Parameter: 
          * ID: Die PID der geforderten Pflanze
      * http://localhost:8080/planti/showall: Gibt eine Liste aller auf der Datenbank befindlichen Pflanzen zurück, quasi ein "Dump"
      * http://localhost:8080/planti/addsensor: Persistiert ein Sensor-Objekt mit den eingegebenen Daten; Gibt nur "200" zurück
        * Parameter:
          * pid: PID der Pflanze, bei der der Sensor angebracht wurde
          * link: TTN-StorageAPI-Link des zugehörigen Sensors
      * http://localhost:8080/planti/getPW: Gibt das Passwort des eingegebenen Nutzers aus der Datenbank zurück
        * Parameter:
          * name: Nutzername des Nutzers, dessen Passwort abgerufen werden soll
      * http://localhost:8080/planti/adduser: Persistiert ein User-Objekt mit den eingegebenen Nutzer-Daten; Gibt nur "200" zurück
        * Parameter: 
          * username: Nutzername, der persistiert werden soll
          * pw: Passwort, das persisitert werden soll
      * http://localhost:8080/planti/meinePflanzen: Gibt eine Liste aller Pflanzen, die einen Sensor haben zurück
      * http://localhost:8080/planti/getData: Gibt einen Dump der von TTN gespeicherten Feuchtigkeitsdaten, versehen mit Zeitstempeln, zurück
        * Parameter:
          * SID: SID des abgerufenen Sensors


2. DB:
    * Klasse, welche die Persistenz/ORM-bezogenen Funktionen bietet
    * Funktionen:
      * callPflanzeById: Ruft ein Pflanzenobjekt nach seiner PID aus der Datenbank ab
      * callAllPflanze: Ruft eine Liste aller gespeicherten Pflanzen aus der Datenbank ab
      * persist: Persistiert das eingegebene Objekt
      * callUserByName: Ruft ein Nutzerobjekt (Nutzerdaten) nach seinem Nutzernamen aus der Datenbank ab
      * callSensorById: Ruft ein Sensorobjekt nach seiner SID aus der Datenbank ab
      * callAllSensor: Ruft eine Liste aller gespeicherten Sensoren aus der Datenbank ab


3. Miscellaneous:
    * Diverse Funktionen, die so häufig vorkamen oder so lang waren, dass sie zwecks Lesbarkeit ausgelagert wurden
    * Funktionen:
      * getHTTPOutput: Ruft den Output des eingegeben Links ab und gibt diesen zurück
      * MapObject: Wandelt das übergebene (einzelne) Objekt in einen String um
      * MapObjectList: Wandelt die übergebene Array-Liste in einen String um