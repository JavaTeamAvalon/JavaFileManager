package JavaFileManager;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public interface LogicMethods {

    void addDate (ArrayList<File> listFiles, boolean end, SimpleDateFormat dateFormat);
    /*
     * Добавление даты в конец илиначало имени по заданному шаблону
     */

    void addSuffix (ArrayList<File> listFiles, boolean end, String prefix);
    /*
     * Добавление префикса или постфикса по заданному шаблону
     */

    void changeExpansion ();
    /*
     * Изменение расширения файла или папки
     */

    void changeOwner ();
    /*
     * Изменение владельца файла или папки
     */

}
