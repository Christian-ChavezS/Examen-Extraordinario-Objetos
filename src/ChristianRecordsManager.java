import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChristianRecordsManager {
    private String filename;
    private int records;
    private List<GameRecord> gameRecords = new ArrayList<>();

    public ChristianRecordsManager(String name, int maxRecordsInFile) {
        filename = name;
        records = maxRecordsInFile;

    }


    public void save(GameRecord record) {
        gameRecords.add(record);
        gameRecords.sort();
        File file = new File(filename);

        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(record.getPlayerName() + " " + record.getScore());
            fileWriter.close();
        } catch (IOException e) {

            throw new RuntimeException(e);
        }


    }


    public List<GameRecord> getRecords() {

        return gameRecords;
    }


}
