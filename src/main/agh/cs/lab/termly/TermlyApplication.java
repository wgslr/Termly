package agh.cs.lab.termly;

import agh.cs.lab.termly.airly.AirlyDataProvider;
import agh.cs.lab.termly.airly.PointData;
import agh.cs.lab.termly.argparser.ArgumentParser;
import agh.cs.lab.termly.argparser.OptionParsers;
import agh.cs.lab.termly.printers.DetailsPrinter;
import agh.cs.lab.termly.printers.HistoryPrinter;
import agh.cs.lab.termly.printers.IPrinter;
import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.net.StandardSocketOptions;
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
        argumentParser.addOption(new ArgumentParser.Option("history", "y",
                "Enable display of historical data",
                OptionParsers.getBooleanParser()
        ));
        argumentParser.addOption(new ArgumentParser.Option("api-key", "k",
                "API key to use for communication with the airly API",
                OptionParsers.getStringParser()
        ));
        argumentParser.addOption(new ArgumentParser.Option("help", "h",
                "Display help",
                OptionParsers.getBooleanParser()

        ));

        return argumentParser;
    }

    public static void main(String[] args) throws MalformedURLException {
        ArgumentParser argumentParser = configureArgumentParser();
        argumentParser.parse(args);

        if (argumentParser.getResult("help")) {
            System.out.println(argumentParser.getArgsHelp());
            System.exit(0);
        }

        String apiKey = "";
        if (argumentParser.isSet("api-key")) {
            apiKey = argumentParser.getResult("api-key");
        } else if (System.getenv().containsKey("API_KEY")) {
            apiKey = System.getenv().get("API_KEY");
        } else {
            System.out.println("Api key must be provided in an environmental " +
                    "variable or via an argument");
            System.exit(1);
        }

        IPrinter printer = argumentParser.getResult("history") ?
                new HistoryPrinter() : new DetailsPrinter();

        WebApiClient api = new WebApiClient("http://airapi.airly.eu/");
        AirlyDataProvider dataProvider = new AirlyDataProvider
                (apiKey, api);

        PointData data = null;
        if(argumentParser.isSet("sensor-id")) {
            String sensorId = argumentParser.getResult("sensor-id");
            data = dataProvider.getSensorData(sensorId);
        } else if (argumentParser.isSet("latitude") && argumentParser.isSet
                ("longitude")) {
            Double latitude = argumentParser.getResult("latitude");
            Double longitude = argumentParser.getResult("longitude");
            data = dataProvider.getMapPoint(latitude, longitude);
        } else {
            System.out.println("You must provider sensor-id or latitude AND " +
                    "longitude.");
            System.exit(1);
        }

        printer.print(data);

    }
}
