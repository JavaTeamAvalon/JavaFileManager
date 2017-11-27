package JavaFileManager;

import java.io.File;
import java.util.ArrayList;

public interface LogicMethods {

    public void addDateToTheEnd (ArrayList<File> listFiles);
    /*
     * Добавление даты в конец имени по заданному шаблону
     */

    public void addDateInFront (ArrayList<File> listFiles);
    /*
     * Добавление даты в начало имени по заданному шаблону
     */

    public void addPostfix ();
    /*
     * Добавление постфикса по заданному шаблону
     */

    public void addSuffix ();
    /*
     * Добавление суффикса по заданному шаблону
     */

    public void changeExpansion ();
    /*
     * Изменение расширения файла или папки
     */

    public void changeOwner ();
    /*
     * Изменение владельца файла или папки
     */

}
