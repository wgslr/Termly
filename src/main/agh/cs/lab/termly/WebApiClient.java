package agh.cs.lab.termly;

import agh.cs.lab.termly.exceptions.ApiConnectionException;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WebApiClient {

    private final String apiUrl;

    private static final int EXPECTED_CODE = HttpURLConnection.HTTP_OK;

    public WebApiClient(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    /**
     * Requests a JSON resource from given endpoint and parses the response
     * into the desired object type.
     */
    public <T> T get(String endpoint, Class<T> type) {
        URL url;
        try {
            url = new URL(apiUrl + endpoint);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }

        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            if(conn.getResponseCode() != EXPECTED_CODE) {
                // TODO Specific exceptions
                throw new ApiConnectionException("Invalid response code: " +
                        conn.getResponseCode());
            }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            Gson gson = new Gson();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            throw new ApiConnectionException(e);
        }

    }


}
