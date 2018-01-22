package agh.cs.lab.termly;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WebApiClient {

    class HistoryEntry {
        private String fromDateTime;
        private String tillDateTime;

        @Override
        public String toString() {
            return fromDateTime +  " - " + tillDateTime;
        }
    }

    class Response {
        public HistoryEntry history[];

        @Override
        public String toString() {
            return Arrays.stream(history).map(HistoryEntry::toString).collect
                    (Collectors.joining("\n"));
        }
    }


    private final String apiUrl;

    private static final int EXPECTED_STATUS = HttpURLConnection.HTTP_OK;

    public WebApiClient(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    String getAsString(String endpoint) throws MalformedURLException{
        URL url = new URL(apiUrl + endpoint);

        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            System.out.println(conn);
            System.out.println(conn.getResponseCode());

            BufferedReader reader = new BufferedReader(new InputStreamReader
                    (conn.getInputStream()));

//            reader.lines().forEach(System.out::println);

//            String content = reader.lines().collect(Collectors.joining("\n"));

            Gson gson = new Gson();
            Response result = gson.fromJson(reader, Response.class);

            System.out.println(result);

//            JsonReader jsonReader = new JsonReader(new InputStreamReader(conn
//                    .getInputStream()));

//            jsonReader.beginObject();
//            jsonReader.has



        } catch (Exception e) {
            // TODO
        }
        return "";
    }


}
