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

    public static void main(String[] args) throws MalformedURLException{
        ArgumentParser argumentParser = configureArgumentParser();

        argumentParser.parse(args);

        System.out.println(String.format("Longitude: %.2f Latitude: %.2f",
                argumentParser.getResult("longitude"),
                argumentParser.getResult("latitude")));

        WebApiClient api = new WebApiClient("http://airapi.airly.eu/");

        api.getAsString("v1/mapPoint/measurements?latitude=57&longitude=40" +
                "&apikey=fae55480ef384880871f8b40e77bbef9");

    }
}
