package JavaFileManager;

import java.io.File;
import java.util.ArrayList;

public interface MainMethods {

    void buildingFileStructure ();
    /*
     * Построение файловой стурктуры
     */

    ArrayList<File> copyFilesToArray ();
    /*
     * Копирование файлов в список
     */

    ArrayList<File> searchFiles ();
    /*
     * Поиск файлов
     */

    void pressRunButton ();
    /*
     * Выполнение выбранных операций
     */

    void saveSettings ();
    /*
     * Сохранение настроек
     */

    void resetSettings ();
    /*
     * Сброс настроек
     */

}
