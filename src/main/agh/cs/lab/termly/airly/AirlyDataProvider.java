package agh.cs.lab.termly.airly;

import agh.cs.lab.termly.IDataProvider;
import agh.cs.lab.termly.WebApiClient;
import agh.cs.lab.termly.WebApiClient.RequestParam;

import java.util.Arrays;
import java.util.List;

public class AirlyDataProvider implements IDataProvider {

    String apiKey;
    WebApiClient client;


    public AirlyDataProvider(String apiKey, WebApiClient client) {
        this.apiKey = apiKey;
        this.client = client;
    }

    public PointData getMapPoint(double latitude, double longitude) {
        List<RequestParam> params = Arrays.asList(
                new RequestParam("apikey", apiKey),
                new RequestParam("longitude", longitude),
                new RequestParam("latitude", latitude)
        );

        return client.get("/v1/mapPoint/measurements", params,
                PointData.class);
    }

    public PointData getSensorData(String sensorId) {
        List<RequestParam> params = Arrays.asList(
                new RequestParam("apikey", apiKey),
                new RequestParam("sensorId", sensorId)
                );
        return client.get
                ("/v1/sensor/measurements", params, PointData.class);
    }

}
