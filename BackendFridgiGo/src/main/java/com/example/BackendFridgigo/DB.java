package com.example.BackendFridgigo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;



public class DB {

    //Ruft ein Rezeptobjekt nach seiner RezeptID aus der Datenbank ab
    public static Rezept2 callRezeptById(Integer input) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();


        session.beginTransaction();
        Rezept2 rezept = session.load(Rezept2.class, input);
        session.flush();
        return rezept;
    }

    //Ruft eine Liste aller gespeicherten Rezepte aus der Datenbank ab
    public static ArrayList<Rezept2> callAllRezepte() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        session.beginTransaction();
        ArrayList<Rezept2> entries = (ArrayList<Rezept>) session.createCriteria(Rezept.class).list();
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
    public static <KData> KData callkategorieById(Integer input) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();


        session.beginTransaction();
        Zutat zutat = session.load(Zutat.class, input);
        session.flush();
        return zutat;
    }

    //Ruft eine Liste aller gespeicherten Zutaten aus der Datenbank ab
    public static ArrayList<Zutat> callAllZutat() {
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
