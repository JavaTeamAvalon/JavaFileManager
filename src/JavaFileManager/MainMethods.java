package JavaFileManager;

import java.io.File;
import java.util.ArrayList;

public interface MainMethods {

    void copyFilesToArray (File file);
    /*
     * Копирование файлов и папок в список
     */

    void removeFilesFromArray (File file);
    /*
     * Удаление файлов и папок из списка
     */

    void clearArray (File file);
    /*
     * Очистка списка
     */

    void searchFiles (File path, String search);
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
