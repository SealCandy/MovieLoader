package cz.osu.dataProcessing;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class FileManager {
    public static ArrayList<String> readCsv(String fileName){
        ArrayList<String> ret = new ArrayList<>();
        URL path = FileManager.class.getClassLoader().getResource(fileName);
        String filePath = URLDecoder.decode(path.getFile(), StandardCharsets.UTF_8);
        File file = new File(filePath);
        try {
            for(String line : Files.readAllLines(file.toPath())){
                ret.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
