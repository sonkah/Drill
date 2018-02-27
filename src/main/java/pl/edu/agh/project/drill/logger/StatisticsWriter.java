package pl.edu.agh.project.drill.logger;

import pl.edu.agh.project.drill.App;

import java.io.*;
import java.time.LocalDateTime;

public class StatisticsWriter {
    public void writeToFile(int points, String fileName) throws IOException {
        FileWriter writer = new FileWriter(App.fileName, true);
        BufferedWriter out = new BufferedWriter(writer);
        out.write(points+ " - " + fileName + " - " + LocalDateTime.now().toString() + "\n\n");
        out.close();
    }
}
