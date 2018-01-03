package JavaFileManager;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;


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
    public ArrayList addPrefix(ArrayList<File> listFiles, boolean end, String prefix) throws IOException {
        ArrayList<File> files = new ArrayList<>();
        File specialFile;
        for (File file: listFiles) {
            if (!file.exists()) {
                System.out.printf("Файл не найден.", file.getCanonicalPath());
            }
            try {

                if (end == true) {
                    specialFile = new File((file.getParent()+"\\"+ file.getName().substring(0,file.getName().lastIndexOf("."))+prefix+
                            file.getName().substring(file.getName().lastIndexOf("."), file.getName().length())));
                    file.renameTo(specialFile);


                } else {
                    specialFile = new File((file.getParent()+"\\"+ prefix + file.getName()));
                    file.renameTo(specialFile);

                }

                files.add(specialFile);

            }
            catch (Exception ex2) {
                System.out.println("Невозможно изменить файл.");
            }
        }
        return files;
    }

    @Override
    public ArrayList changeExpansion(ArrayList<File> listFiles, String newExt) throws IOException {
        ArrayList<File> files = new ArrayList<>();
        File specialFile;
        for (File file: listFiles) {
            if (!file.exists()||file.isDirectory()) {
                System.out.printf("Файл не найден, либо указана папка, а не файл.", file.getCanonicalPath());
            }
            try {
                String nameWithoutExt = (file.getAbsolutePath()).substring(0,(file.getAbsolutePath()).lastIndexOf("."));
                specialFile = new File(nameWithoutExt + "." + newExt);
                file.renameTo(specialFile);
                files.add(specialFile);
                System.out.println(specialFile);
            }
            catch (Exception ex3) {
                System.out.println("Невозможно изменить расширение.");
            }
        }

        return files;
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
    public void changeLastModifiedDate(ArrayList<File> listFiles, Date newDate) throws IOException {
        for (File file: listFiles) {
            if (!file.exists()) {
                System.out.printf("Файл не найден.", file.getCanonicalPath());
            }
            FileTime time = FileTime.fromMillis(newDate.getTime());
            Files.getFileAttributeView(file.toPath(), BasicFileAttributeView.class).setTimes(time, null, null);
        }
    }

    @Override
    public void changeCreateDate(ArrayList<File> listFiles, Date newDate) throws IOException {
        for (File file: listFiles) {
            if (!file.exists()) {
                System.out.printf("Файл не найден.", file.getCanonicalPath());
            }
            FileTime time = FileTime.fromMillis(newDate.getTime());
            Files.getFileAttributeView(file.toPath(), BasicFileAttributeView.class).setTimes(null, null, time);
        }
    }

    @Override
    public ArrayList addPreviewPrefix(ArrayList<String> listFiles, boolean end, String prefix) throws IOException {
        ArrayList<String> files = new ArrayList<>();


        String specialFile;
        for (String file: listFiles) {

            try {

                if (end == true) {
                    specialFile = file.substring(0,file.lastIndexOf("."))+prefix+"."+file.substring(file.lastIndexOf("."),file.length());
                    labelarr.add(new JLabel("<html>Text color:"+file.substring(0,file.lastIndexOf("."))+"."+
                            "<font color='red'>"+file.substring(file.lastIndexOf("."),file.length())+"</font></html>"));

                } else {
                    specialFile = prefix+file;

                }

                files.add(specialFile);

            }
            catch (Exception ex2) {
                System.out.println("Невозможно изменить файл.");
            }
        }

        return files;
    }

    @Override
    public ArrayList changePreviewExpansion(ArrayList<File> listFiles, String newExt) throws IOException {
        ArrayList<String> files = new ArrayList<>();
//        File specialFile;
        for (File file: listFiles) {

            try {
                String nameNewExt = (file.getName()).substring(0,(file.getName()).lastIndexOf("."))+"."+newExt;
                //specialFile = new File(nameWithoutExt + "." + newExt);
                //file.renameTo(specialFile);
                files.add(nameNewExt);
                System.out.println(nameNewExt);
            }
            catch (Exception ex3) {
                System.out.println("Невозможно изменить расширение.");
            }
        }

        return files;
    }

    ArrayList<JLabel> labelarr= new ArrayList<>();
    //Метод для возврата массива Label, для передачи в класс ColorListRender
    public ArrayList getLabels(){
        ArrayList<JLabel> labelarr1= new ArrayList<>();
        labelarr1 = null;
        if (labelarr!=null)
            return labelarr1=labelarr;
        else return labelarr1;

    }

}