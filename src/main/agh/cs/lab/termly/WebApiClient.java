package agh.cs.lab.termly;

import agh.cs.lab.termly.exceptions.ApiConnectionException;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.stream.Collectors;

public class WebApiClient {

    public static class RequestParam {
        public final String key;
        public final String value;

        public RequestParam(String key, Object value) {
            this.key = key;
            this.value = value.toString();
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }


    private final String apiUrl;

    private static final int EXPECTED_CODE = HttpURLConnection.HTTP_OK;

    public WebApiClient(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    /**
     * Requests a JSON resource from given endpoint and parses the response
     * into the desired object type.
     */
    public <T> T get(String endpoint, Collection params, Class<T> type) {
        URL url;
        try {
            url = prepareURL(endpoint, params);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }

        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            switch (conn.getResponseCode()) {
                case EXPECTED_CODE:
                    break;
                case HttpURLConnection.HTTP_FORBIDDEN:
                    throw new ApiConnectionException(
                            "Invalid API key");
                default:
                    throw new ApiConnectionException(
                            "Invalid response code: " + conn.getResponseCode());
            }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            Gson gson = new Gson();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            throw new ApiConnectionException(e);
        }
    }

    private URL prepareURL(String endpoint, Collection<RequestParam> params)
            throws MalformedURLException {
        return new URL(apiUrl + endpoint + "?" +
                params.stream()
                        .map(RequestParam::toString)
                        .collect(Collectors.joining("&")));
    }


}
