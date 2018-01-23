package agh.cs.lab.termly;

import agh.cs.lab.termly.airly.AirlyDataProvider;
import agh.cs.lab.termly.argparser.ArgumentParser;
import agh.cs.lab.termly.argparser.OptionParsers;
import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.Month;

public class TermlyApplication {

    private static ArgumentParser configureArgumentParser() {
        ArgumentParser argumentParser = new ArgumentParser();

        //argumentParser.addOption();
        argumentParser.addOption(new ArgumentParser.Option("latitude", "a",
                "Latitude of the point on map",
                OptionParsers.getDoubleParser()
        ));
        argumentParser.addOption(new ArgumentParser.Option("longitude", "o",
                "Longitude of the point on map",
                OptionParsers.getDoubleParser()
        ));
        argumentParser.addOption(new ArgumentParser.Option("sensor-id", "s",
                "ID of a sensor to obtain data from",
                OptionParsers.getStringParser()
        ));
        argumentParser.addOption(new ArgumentParser.Option("history", "h",
                "Enable display of historical data",
                OptionParsers.getBooleanParser()
        ));
        argumentParser.addOption(new ArgumentParser.Option("api-key", "k",
                "API key to use for communication with the airly API",
                OptionParsers.getStringParser()
        ));

        return argumentParser;
    }

    public static void main(String[] args) throws MalformedURLException {
        ArgumentParser argumentParser = configureArgumentParser();

        argumentParser.parse(args);

        Gson g = new Gson();
//        System.out.println(
//                g.fromJson("2018-01-23T13:59:59Z'", LocalDateTime.class));

        System.out.println(g.toJson(LocalDateTime.of(1994, Month.APRIL, 15, 11,
                30)));


        System.out.println(String.format("Longitude: %.2f Latitude: %.2f",
                argumentParser.getResult("longitude"),
                argumentParser.getResult("latitude")));

        WebApiClient api = new WebApiClient("http://airapi.airly.eu/");

        AirlyDataProvider dataProvider = new AirlyDataProvider
                ("fae55480ef384880871f8b40e77bbef9", api);

//        Gson gson = new Gson();
        System.out.println(dataProvider.getMapPoint(50, 19.6));

        System.out.println(dataProvider.getSensorData("1026"));

//        api.getAsString("v1/mapPoint/measurements?latitude=57&longitude=40" +
//                "&apikey=fae55480ef384880871f8b40e77bbef9");

    }
}
