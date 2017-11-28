package JavaFileManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public interface LogicMethods {

    void addDate (ArrayList<File> listFiles, boolean end, SimpleDateFormat dateFormat) throws IOException;
    /*
     * Добавление даты в конец илиначало имени по заданному шаблону
     */

    void addPrefix (ArrayList<File> listFiles, boolean end, String prefix) throws IOException;
    /*
     * Добавление префикса или постфикса по заданному шаблону
     */

    void changeExpansion (ArrayList<File> listFiles, String newExt) throws IOException;
    /*
     * Изменение расширения файла
     */

    void changeOwner (ArrayList<File> listFiles, String newOwner) throws IOException;
    /*
     * Изменение владельца файла или папки
     */

    void changeCreateDate (ArrayList<File> listFiles, Date newDate) throws IOException;
    /*
     * Изменение даты создания файла или папки
     */

}
