package agh.cs.lab.termly;

import agh.cs.lab.termly.WebApiClient.RequestParam;
import agh.cs.lab.termly.airly.IApiResponse;
import agh.cs.lab.termly.airly.PointData;
import agh.cs.lab.termly.exceptions.DataUnavailableException;

import java.util.Arrays;
import java.util.List;

public class AirlyDataProvider implements IDataProvider {

    String apiKey;
    WebApiClient client;


    public AirlyDataProvider(String apiKey, WebApiClient client) {
        this.apiKey = apiKey;
        this.client = client;
    }

    @Override
    public PointData getMapPoint(double latitude, double longitude) {
        List<RequestParam> params = Arrays.asList(
                new RequestParam("apikey", apiKey),
                new RequestParam("longitude", longitude),
                new RequestParam("latitude", latitude)
        );

        return validateOrThrow(client.get("/v1/mapPoint/measurements",
                params, PointData.class));
    }

    @Override
    public PointData getSensorData(String sensorId) {
        List<RequestParam> params = Arrays.asList(
                new RequestParam("apikey", apiKey),
                new RequestParam("sensorId", sensorId)
        );
        return validateOrThrow(client.get("/v1/sensor/measurements",
                params, PointData.class));
    }

    private <T extends IApiResponse> T validateOrThrow(T response) {
        if (response.isEmpty()) {
            throw new DataUnavailableException();
        } else {
            return response;
        }
    }

}
