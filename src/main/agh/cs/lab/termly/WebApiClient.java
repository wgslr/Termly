package agh.cs.lab.termly;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class WebApiClient {

    

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

            reader.lines().forEach(System.out::println);

        } catch (Exception e) {
            // TODO
        }
        return "";
    }


}
