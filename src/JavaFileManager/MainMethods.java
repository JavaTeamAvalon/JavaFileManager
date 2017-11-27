package JavaFileManager;

import java.io.File;
import java.util.ArrayList;

public interface MainMethods {

    public void buildingFileStructure ();
    /*
     * Построение файловой стурктуры
     */

    public ArrayList<File> copyFilesToArray ();
    /*
     * Копирование файлов в список
     */

    public ArrayList<File> searchFiles ();
    /*
     * Поиск файлов
     */

    public void pressRunButton ();
    /*
     * Выполнение выбранных операций
     */

    public void saveSettings ();
    /*
     * Сохранение настроек
     */

    public void resetSettings ();
    /*
     * Сброс настроек
     */

}
