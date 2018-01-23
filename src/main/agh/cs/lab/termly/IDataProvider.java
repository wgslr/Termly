package agh.cs.lab.termly;

import agh.cs.lab.termly.airly.PointData;

public interface IDataProvider {

    PointData getMapPoint(double latitude, double longitude);

    PointData getSensorData(String sensorId);
}
