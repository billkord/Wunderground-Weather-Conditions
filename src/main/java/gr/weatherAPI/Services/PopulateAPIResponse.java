package gr.weatherAPI.Services;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class PopulateAPIResponse {

    public static HashMap<String, String> getNewYorkMap (String jsonStringReceived) throws JSONException {
        HashMap<String, String> data = new HashMap<>();

        JSONObject jsonReceived = new JSONObject(jsonStringReceived)
                .getJSONObject("history")
                .getJSONArray("dailysummary")
                .getJSONObject(0);

        data.put("Max percentage humidity", jsonReceived.getString("maxhumidity"));
        data.put("Max Temp in C", jsonReceived.getString("maxtempm"));
        data.put("Min Temp in C", jsonReceived.getString("mintempm"));
        data.put("Precipitation in mm", jsonReceived.getString("precipm"));
        return data;
    }
}
