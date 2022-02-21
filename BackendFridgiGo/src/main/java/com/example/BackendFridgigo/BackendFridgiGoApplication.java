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
public class BackendFridgiGoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendFridgiGoApplication.class, args);
    }

    //Gibt eine einzelne Rezept nach ihrer ID zurück
    @GetMapping("/FridgiGo/show")
    @CrossOrigin(origins = "http://localhost:8100")
    public String viewRezept(@RequestParam(value = "id", defaultValue = "1") Integer id) {
        Rezept2 rezept = DB.callRezeptById(id);
        return Miscellaneous.MapObject(rezept);
    }

    //Gibt eine Liste aller auf der Datenbank befindlichen Rezepte zurück, quasi ein "Dump"
    @GetMapping(value = "/FridgiGo/showall", produces = "application/json")
    @CrossOrigin(origins = "http://localhost:8100")
    public String viewAllRezepte() {
        ArrayList<Rezept2> rezepteList = DB.callAllRezepte();
        return Miscellaneous.MapObjectList(rezepteList);
    }

    //Persistiert ein Rezept-Objekt mit den eingegebenen Daten; Gibt nur "200" zurück
    @GetMapping("/FridgiGo/addrezept")
    @CrossOrigin(origins = "http://localhost:8100")
    public void addSensor(@RequestParam(value = "rezeptid") Integer rezeptid,
                          @RequestParam(value = "link") String link) {

        Rezept2 rezept = new Rezept2();
       Zutat.setLink(link);
        Zutat.setrezeptid(rezeptid);
        DB.persist(rezeptid);


    }

  

    //Gibt eine Liste aller Rezepte, die eine Zutat haben zurück
    @GetMapping(value = "/fridgigo/meineRezepte", produces = "application/json")
    @CrossOrigin(origins = "http://localhost:8100")
    public String viewAllRezepteString() {
        ArrayList<Rezept2> rezeptList = new ArrayList<>();
        ArrayList<Zutat> zutatList = DB.callAllZutat();
        for (Zutat zutat : zutatList) {
            Rezept2 rezept = DB.callRezeptById(Rezept2.getrezeptid());
            rezeptList.add(rezept);
        }
        return Miscellaneous.MapObjectList(rezeptList);
    }
}

 