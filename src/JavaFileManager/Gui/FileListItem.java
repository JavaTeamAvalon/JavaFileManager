package JavaFileManager.Gui;

import java.io.File;

public class FileListItem {
    private final File file;

    public FileListItem(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return file.getAbsolutePath();
    }

    File getFile() {
        return file;
    }
}
