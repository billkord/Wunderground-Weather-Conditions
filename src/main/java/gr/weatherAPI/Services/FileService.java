package gr.weatherAPI.Services;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileService {

    public void writeNewYarkHistoryData (Map<String, String> data) throws IOException {
        File dir = new File("./Results");
        dir.mkdir();
        List<String> lines = new ArrayList<>();
        Path file = Paths.get(dir + "/NewYork_(2017-10-30).txt");
        for (Map.Entry<String, String> entry : data.entrySet()) {
            lines.add(entry.getKey() + ": " + entry.getValue());
        }
        Files.write(file, lines, Charset.forName("UTF-8"));
    }
}
