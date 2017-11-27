package JavaFileManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class LogicMethodsClass implements LogicMethods {

    @Override
    public void addDate(ArrayList<File> listFiles, boolean end, SimpleDateFormat dateFormat) throws IOException {
        for (File file: listFiles) {
            if (!file.exists()) {
                System.out.printf("Файл не найден.", file.getCanonicalPath());
            }
            try {
                if (end == true) {
                    file.renameTo(new File(file.getAbsolutePath() + "_" + dateFormat.format(new Date())));
                } else file.renameTo(new File(
                        (file.getAbsolutePath()).substring(0, (file.getAbsolutePath()).lastIndexOf("\\"))
                                + "." + (dateFormat.format(new Date()) + file.getName())));
            }
            catch (Exception x1) {
                System.out.println("Невозможно изменить файл.");
            }
        }
    }

    @Override
    public void addPrefix(ArrayList<File> listFiles, boolean end, String prefix) throws IOException {
        for (File file: listFiles) {
            if (!file.exists()) {
                System.out.printf("Файл не найден.", file.getCanonicalPath());
            }
            try {
                if (end == true) {
                    file.renameTo(new File(file.getAbsolutePath() + prefix));
                } else file.renameTo(new File(
                        (file.getAbsolutePath()).substring(0, (file.getAbsolutePath()).lastIndexOf("\\"))
                                + "." + (prefix + file.getName())));
            }
            catch (Exception x2) {
                System.out.println("Невозможно изменить файл.");
            }
        }
    }

    @Override
    public void changeExpansion(ArrayList<File> listFiles, String newExt) throws IOException {
        for (File file: listFiles) {
            if (!file.exists()) {
                System.out.printf("Файл не найден.", file.getCanonicalPath());
            }
            try {
                String nameWithoutExt = (file.getAbsolutePath()).substring(0,(file.getAbsolutePath()).lastIndexOf("."));
                file.renameTo(new File(nameWithoutExt + "." + newExt));
            }
            catch (Exception x3) {
                System.out.println("Невозможно изменить расширение.");
            }
        }
    }

    @Override
    public void changeOwner() {

    }

}
