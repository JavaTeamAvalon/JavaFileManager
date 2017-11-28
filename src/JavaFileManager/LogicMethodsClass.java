package JavaFileManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
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
            catch (Exception ex1) {
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
            catch (Exception ex2) {
                System.out.println("Невозможно изменить файл.");
            }
        }
    }

    @Override
    public void changeExpansion(ArrayList<File> listFiles, String newExt) throws IOException {
        for (File file: listFiles) {
            if (!file.exists()||file.isDirectory()) {
                System.out.printf("Файл не найден, либо указана папка, а не файл.", file.getCanonicalPath());
            }
            try {
                String nameWithoutExt = (file.getAbsolutePath()).substring(0,(file.getAbsolutePath()).lastIndexOf("."));
                file.renameTo(new File(nameWithoutExt + "." + newExt));
            }
            catch (Exception ex3) {
                System.out.println("Невозможно изменить расширение.");
            }
        }
    }

    @Override
    public void changeOwner(ArrayList<File> listFiles, String newOwner) throws IOException {
        for (File file: listFiles) {
            if (!file.exists()) {
                System.out.printf("Файл не найден.", file.getCanonicalPath());
            }
            try {
                Path pathFile = Paths.get(file.getAbsolutePath());
                UserPrincipalLookupService lookupService = FileSystems.getDefault().getUserPrincipalLookupService();
                UserPrincipal owner = lookupService.lookupPrincipalByName(newOwner);
                Files.setOwner(pathFile, owner);
            }
            catch (Exception ex4) {
                System.out.println("Невозможно изменить владельца.");
            }
        }
    }

    @Override
    public void changeCreateDate(ArrayList<File> listFiles, Date newDate) throws IOException {
        for (File file: listFiles) {
            if (!file.exists()) {
                System.out.printf("Файл не найден.", file.getCanonicalPath());
            }
            try {
                file.setLastModified(newDate.getTime());
            }
            catch (Exception ex5) {
                System.out.println("Невозможно изменить дату последнего изменения файла.");
            }
        }
    }

}
