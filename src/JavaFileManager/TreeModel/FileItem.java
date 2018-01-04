package JavaFileManager.TreeModel;

import java.io.File;

import static java.util.Objects.isNull;


//Класс для работы с File
public class FileItem implements FileTreeItem {

    private final File file;

    public FileItem(File file) {
        this.file = file;
    }

    @Override
    public int getChildCount() {
        String[] children = file.list();
        if (isNull(children)) {
            return 0;
        }
        return children.length;
    }

    @Override
    public FileTreeItem getChild(int index) {
        File[] children = file.listFiles();
        if (isNull(children) || (index >= children.length)) {
            return null;
        }
        return new FileItem(children[index]);
    }

    @Override
    public boolean isLeaf() {
        return file.isFile();
    }

    @Override
    public String toString() {
        if (file.getName().isEmpty()) {
            return file.getAbsolutePath();
        }
        return file.getName();
    }

    public File getFile() {
        return file;
    }
}