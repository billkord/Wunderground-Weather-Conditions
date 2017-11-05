package gr.weatherAPI;

import gr.weatherAPI.Services.FileService;
import gr.weatherAPI.Services.NewYorkService;
import gr.weatherAPI.Services.PopulateAPIResponse;

import java.util.Map;

public class Application {

    public static void main(String[] args) {
        FileService fileService = new FileService();
        try {
            String JSONResponse = NewYorkService.getData();
            Map<String, String> data = PopulateAPIResponse.getNewYorkMap(JSONResponse);
            fileService.writeNewYarkHistoryData(data);
            System.out.println("Results were written in (project path)/Results/NewYork_(2017-10-30).txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
