package com.example.BackendFridgigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@SpringBootApplication
@RestController
public class BackendFridgigoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendFridgigoApplication.class, args);
    }

    //Gibt eine einzelne Rezept nach ihrer ID zurück
    @GetMapping("/FridgiGo/show")
    @CrossOrigin(origins = "http://localhost:8100")
    public String viewPflanze(@RequestParam(value = "id", defaultValue = "1") Integer id) {
        Rezept pflanze = DB.callRezeptById(id);
        return Miscellaneous.MapObject(rezept);
    }

    //Gibt eine Liste aller auf der Datenbank befindlichen Rezepte zurück, quasi ein "Dump"
    @GetMapping(value = "/FridgiGo/showall", produces = "application/json")
    @CrossOrigin(origins = "http://localhost:8100")
    public String viewAllRezepte() {
        ArrayList<Rezept> rezepteList = DB.callAllRezepte();
        return Miscellaneous.MapObjectList(rezepteList);
    }

    //Persistiert ein Rezept-Objekt mit den eingegebenen Daten; Gibt nur "200" zurück
    @GetMapping("/FridgiGo/addrezept")
    @CrossOrigin(origins = "http://localhost:8100")
    public void addSensor(@RequestParam(value = "rid") Integer rid,
                          @RequestParam(value = "link") String link) {

        Zutat sensor = new Zutat();
        sensor.setLink(link);
        sensor.setPID(pid);
        DB.persist(sensor);


    }

    //Gibt das Passwort des eingegebenen Nutzers aus der Datenbank zurück
    @GetMapping("/planti/getPW")
    @CrossOrigin(origins = "http://localhost:8100")
    public String getPW(@RequestParam(value = "name") String username) {
        User user = DB.callUserByName(username);
        return Miscellaneous.MapObject(user.getPassword());
    }

    //Persistiert ein User-Objekt mit den eingegebenen Nutzer-Daten; Gibt nur "200" zurück
    @GetMapping("/planti/adduser")
    @CrossOrigin(origins = "http://localhost:8100")
    public void addUser(@RequestParam(value = "username") String username,
                        @RequestParam(value = "pw") String pw) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(pw);
        DB.persist(user);
    }

    //Gibt eine Liste aller Pflanzen, die einen Sensor haben zurück
    @GetMapping(value = "/planti/meinePflanzen", produces = "application/json")
    @CrossOrigin(origins = "http://localhost:8100")
    public String viewAllMyPlants() {
        ArrayList<Rezept> pflanzenList = new ArrayList<>();
        ArrayList<Zutat> sensorList = DB.callAllSensor();
        for (Zutat sensor : sensorList) {
            Rezept pflanze = DB.callPflanzeById(sensor.getPID());
            pflanzenList.add(pflanze);
        }
        return Miscellaneous.MapObjectList(pflanzenList);
    }

    //Gibt einen Dump der von TTN gespeicherten Feuchtigkeitsdaten, versehen mit Zeitstempeln, zurück
    @GetMapping("/planti/getData")
    @CrossOrigin(origins = "http://localhost:8100")
    public String getSensorData(@RequestParam(value = "SID") Integer SID) throws Exception {
        ArrayList<SData> FinaleListe = new ArrayList<>();
        String Ausgabe = Miscellaneous.getHTTPOutput(DB.callSensorById(SID).getLink());
        String[] AusgabenArray = Ausgabe.split("result");
        for (String s : AusgabenArray) {
            try {
                SData sData = new SData();
                try {
                    sData.setMoisture(Float.parseFloat(s.substring(s.indexOf("e25") + 5, s.indexOf("e25") + 9).trim()));
                } catch (NumberFormatException e) {
                    continue;
                }
                String ZeitStr = s.substring(s.indexOf("time") + 7, s.indexOf("time") + 26);
                LocalDateTime time = LocalDateTime.parse(ZeitStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                long millis = time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                sData.setTime(millis);
                FinaleListe.add(sData);
            } catch (StringIndexOutOfBoundsException ignored) {

            }
        }
        return Miscellaneous.MapObjectList(FinaleListe);
    }
}
