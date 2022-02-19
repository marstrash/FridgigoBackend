package com.example.BackendFridgiGo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;

public class DB {

    //Ruft ein Rezeptobjekt nach seiner RezeptID aus der Datenbank ab
    public static rezept callRezeptById(Integer input) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();


        session.beginTransaction();
        Rezept rezept = session.load(Rezept.class, input);
        session.flush();
        return rezept;
    }

    //Ruft eine Liste aller gespeicherten Rezepte aus der Datenbank ab
    public static ArrayList<rezept> callAllRezept() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        session.beginTransaction();
        ArrayList<rezept> entries = (ArrayList<rezept>) session.createCriteria(Rezept.class).list();
        session.flush();
        return entries;
    }

    //Persistiert das eingegebene Objekt
    public static void persist(Object Eingabe) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        session.beginTransaction();
        session.persist(Eingabe);
        session.flush();
        session.close();
    }

    //Ruft ein Nutzerobjekt (Nutzerdaten) nach seinem Nutzernamen aus der Datenbank ab
    public static User callUserByName(String input) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();


        session.beginTransaction();
        User user = session.load(User.class, input);
        session.flush();
        return user;
    }

    //Ruft ein Kategorieobjekt nach seiner rezeptid aus der Datenbank ab
    public static Kategorie callkategorieById(Integer input) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();


        session.beginTransaction();
        Zutat sensor = session.load(Zutat.class, input);
        session.flush();
        return sensor;
    }

    //Ruft eine Liste aller gespeicherten Zutaten aus der Datenbank ab
    public static ArrayList<zutat> callAllZutat() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        session.beginTransaction();
        ArrayList<Zutat> entries = (ArrayList<Zutat>) session.createCriteria(Zutat.class).list();
        session.flush();
        return entries;
    }
}
