package agh.cs.lab.termly;

import agh.cs.lab.termly.airly.PointData;
import agh.cs.lab.termly.argparser.ArgumentParser;
import agh.cs.lab.termly.argparser.OptionParsers;
import agh.cs.lab.termly.exceptions.ApiConnectionException;
import agh.cs.lab.termly.exceptions.BadArgumentsException;
import agh.cs.lab.termly.exceptions.DataUnavailableException;
import agh.cs.lab.termly.printers.DetailsPrinter;
import agh.cs.lab.termly.printers.HistoryPrinter;
import agh.cs.lab.termly.printers.IPrinter;

import java.net.MalformedURLException;

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
        // TODO javadoc

        // TODO ascii art


        try {
            ArgumentParser argumentParser = configureArgumentParser();
            argumentParser.parse(args);

            if (argumentParser.getResult("help")) {
                System.out.println(argumentParser.getArgsHelp());
                System.exit(0);
            }

            String apiKey = getApiKey(argumentParser);
            IPrinter printer = getPrinter(argumentParser);

            WebApiClient apiClient = new WebApiClient("http://airapi.airly.eu/");
            IDataProvider dataProvider = new AirlyDataProvider(apiKey, apiClient);

            PointData data = null;

            if (argumentParser.isSet("sensor-id")) {
                String sensorId = argumentParser.getResult("sensor-id");
                data = dataProvider.getSensorData(sensorId);

            } else if (areCoordsSpecified(argumentParser)) {
                Double latitude = argumentParser.getResult("latitude");
                Double longitude = argumentParser.getResult("longitude");
                data = dataProvider.getMapPoint(latitude, longitude);

            } else {
                throw new BadArgumentsException("Not enough location data provided");
            }

            printer.print(data);
        } catch (BadArgumentsException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (ApiConnectionException e) {
            System.out.println("Couldn't connect to the API: " + e.getMessage());
            System.exit(1);
        } catch(DataUnavailableException e) {
            System.out.println("There are no data available for this location");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            System.exit(1);
        }
    }

    private static String getApiKey(ArgumentParser argumentParser) {
        if (argumentParser.isSet("api-key")) {
            return argumentParser.getResult("api-key");
        } else if (System.getenv().containsKey("API_KEY")) {
            return System.getenv().get("API_KEY");
        } else {
            throw new BadArgumentsException(
                    "API key must be provided in environment or arguments");
        }
    }


    private static IPrinter getPrinter(ArgumentParser argumentParser) {
        return argumentParser.getResult("history") ?
                new HistoryPrinter() : new DetailsPrinter();
    }

    private static boolean areCoordsSpecified(ArgumentParser argumentParser) {
        return argumentParser.isSet("latitude") &&
                argumentParser.isSet("longitude");
    }
}
