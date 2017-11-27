package JavaFileManager;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class LogicMethodsClass implements LogicMethods {

    @Override
    public void addDate(ArrayList<File> listFiles, boolean end, SimpleDateFormat dateFormat) {
        for (File file: listFiles) {
            if (end == true) {
                file.renameTo(new java.io.File(file.getName() + " " + dateFormat.format(new Date())));
            } else file.renameTo(new java.io.File(dateFormat.format(new Date()) + " " + file.getName()));
        }
    }

    @Override
    public void addPostfix() {

    }

    @Override
    public void addSuffix() {

    }

    @Override
    public void changeExpansion() {

    }

    @Override
    public void changeOwner() {

    }

}
