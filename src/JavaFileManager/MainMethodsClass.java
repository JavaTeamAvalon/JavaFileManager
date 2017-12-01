package JavaFileManager;

import java.io.File;
import java.util.ArrayList;

public class MainMethodsClass implements MainMethods {

    ArrayList<File> filesArray = new ArrayList<>();
    ArrayList<File> searchFilesArray = new ArrayList<>();

    @Override
    public void copyFilesToArray(File file) {
        filesArray.add(file);
    }

    @Override
    public void removeFilesFromArray(File file) {
        filesArray.remove(file);
    }

    @Override
    public void clearArray(File file) {
        for  (File removableFile: filesArray) {
            filesArray.remove(removableFile);
        }
    }

    @Override
    public void searchFiles(File path, String search) {
        for (File file: path.listFiles()) {
            if (file.isDirectory()) {
                searchFiles(file, search);
            } else if(file.getName().contains(search)) {
                searchFilesArray.add(file);
            }
        }
    }

    @Override
    public void pressRunButton() {

    }

    @Override
    public void saveSettings() {

    }

    @Override
    public void resetSettings() {

    }
}
