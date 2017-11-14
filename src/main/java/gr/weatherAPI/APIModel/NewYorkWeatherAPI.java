package gr.weatherAPI.APIModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class NewYorkWeatherAPI {

    private static NewYorkWeatherAPI instance = null;
    private URL wunderground;
    private final String url = "http://api.wunderground.com/api/2d6705d9e316e73a/history_20171030/q/NY/New_York.json";
    private URLConnection connection;
    private BufferedReader in;
    private String inputLine;
    private StringBuilder stringBuilder;

    private NewYorkWeatherAPI() throws Exception {
        wunderground = new URL(url);
        stringBuilder = new StringBuilder();
    }

    public StringBuilder getHistoryData() throws Exception {
        connection = wunderground.openConnection();
        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while ((inputLine = in.readLine()) != null)
            stringBuilder.append(inputLine);
        in.close();
        return stringBuilder;
    }

    public static NewYorkWeatherAPI getInstance() throws Exception {
        if (instance == null) {
            instance = new NewYorkWeatherAPI();
        }
        return instance;
    }
}
