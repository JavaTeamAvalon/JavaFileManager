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
                file.renameTo(new File(file.getName() + " " + dateFormat.format(new Date())));
            } else file.renameTo(new File(dateFormat.format(new Date()) + " " + file.getName()));
        }
    }

    @Override
    public void addPrefix(ArrayList<File> listFiles, boolean end, String prefix) {
        for (File file: listFiles) {
            if (end == true) {
                file.renameTo(new File(file.getName() + prefix));
            } else file.renameTo(new File(prefix + file.getName()));
        }
    }

    @Override
    public void changeExpansion(ArrayList<File> listFiles, String newExt) {
        for (File file: listFiles) {
            String nameWithoutExt = (file.getAbsolutePath()).substring(0,(file.getAbsolutePath()).lastIndexOf("."));
            file.renameTo(new File(nameWithoutExt + "." + newExt));
        }
    }

    @Override
    public void changeOwner() {

    }

}
