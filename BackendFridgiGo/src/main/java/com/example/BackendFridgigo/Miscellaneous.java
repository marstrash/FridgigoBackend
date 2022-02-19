package com.example.BackendFridgigo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Miscellaneous {

    //Ruft den Output des eingegeben Links ab und gibt diesen zurück
    public static String getHTTPOutput(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "text/event-stream");
        conn.setRequestProperty("Accept", "text/event-stream");
        conn.setRequestProperty("Authorization", "Bearer NNSXS.YVMTHRSE23RDO26NK2GAFNYMHX5FCO7KGKSAWOA.KADWQTL46PKLHIOSSPR6IGMNUPRW2BQ7TY7ZNKVAREQGSXZIWUWA");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }

    //Wandelt das übergebene (einzelne) Objekt in einen String um
    public static String MapObject(Object input) {
        String output = null;
        ObjectMapper om = new ObjectMapper();
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            output = om.writeValueAsString(input);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return output;
    }

    //Wandelt die übergebene Array-Liste in einen String um
    public static String MapObjectList(ArrayList input) {
        String output = null;
        ObjectMapper om = new ObjectMapper();
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            output = om.writerWithDefaultPrettyPrinter().writeValueAsString(input);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return output;
    }
}
