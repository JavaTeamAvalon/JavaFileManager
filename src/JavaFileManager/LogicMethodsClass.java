package JavaFileManager;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class LogicMethodsClass implements LogicMethods {


    @Override
    public void addDateToTheEnd(ArrayList<File> listFiles) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yy");
        for (File file: listFiles) {
            file.renameTo(new java.io.File(file.getName() + " " + dateFormat.format(new Date())));
        }

    }

    @Override
    public void addDateInFront(ArrayList<File> listFiles) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yy");
        for (File file: listFiles) {
            file.renameTo(new java.io.File(dateFormat.format(new Date()) + " " + file.getName()));
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
