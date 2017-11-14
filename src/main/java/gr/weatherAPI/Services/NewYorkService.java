package gr.weatherAPI.Services;

import gr.weatherAPI.APIModel.NewYorkWeatherAPI;

public class NewYorkService {

    public static String getData () throws Exception {
        NewYorkWeatherAPI api = NewYorkWeatherAPI.getInstance();
        StringBuilder stringBuilder = api.getHistoryData();
        return stringBuilder.toString();
    }
}
