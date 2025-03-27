package application;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FileLister {

    public ArrayList<String> loadOperations(String dir) {
        ArrayList<String> operations = new ArrayList<>();
        try {
            Path path = Paths.get(dir);

            File[] files = path.toFile().listFiles();

            if (files != null && files.length > 0) {
                Arrays.sort(files, Comparator.comparing(File::getName));

                for (File file : files) {
                    // First, we get the filename with extension, then pick substring before .
                    String fileWithoutExtension = file.getName();
                    operations.add(fileWithoutExtension.substring(0, fileWithoutExtension.lastIndexOf('.')));
                }
            } else {
                System.out.println("No files or dir found.");
            }
        } catch (Exception e) {
            System.err.println("Error in show files: " + e.getMessage());
        }
        return operations;
    }
}
