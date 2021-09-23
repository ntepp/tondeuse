package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String INPUT_FILE = "/input.text";

    public List<String> readFile() throws IOException {
        List<String> inputData = new ArrayList<>();
        InputStream inputStream = getClass().getResourceAsStream(INPUT_FILE);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                inputData.add(line);
            }
        }
        return inputData;
    }

}
