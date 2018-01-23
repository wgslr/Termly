package agh.cs.lab.termly.airly;

import agh.cs.lab.termly.IDataProvider;
import agh.cs.lab.termly.WebApiClient;

public class AirlyDataProvider implements IDataProvider {

    WebApiClient client;


    public AirlyDataProvider(WebApiClient client) {
        this.client = client;
    }

    public MapPoint getMapPoint(double latitude, double longitude) {
        MapPoint mp = client.get
                ("/v1/mapPoint/measurements?latitude=" + latitude +
                        "&longitude=" + longitude +
                        "&apikey=fae55480ef384880871f8b40e77bbef9", MapPoint
                        .class);
        return mp;
    }

    public MapPoint getSensorData(String sensorId) {
        MapPoint mp = client.get
                ("/v1/sensor/measurements?" +
                        "sensorId=" + sensorId +
                        "&apikey=fae55480ef384880871f8b40e77bbef9",
                        MapPoint
                        .class);
        return mp;
    }

}
