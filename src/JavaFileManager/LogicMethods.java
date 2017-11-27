package JavaFileManager;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public interface LogicMethods {

    void addDate (ArrayList<File> listFiles, boolean end, SimpleDateFormat dateFormat);
    /*
     * Добавление даты в конец илиначало имени по заданному шаблону
     */

    void addPostfix ();
    /*
     * Добавление постфикса по заданному шаблону
     */

    void addSuffix ();
    /*
     * Добавление суффикса по заданному шаблону
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
