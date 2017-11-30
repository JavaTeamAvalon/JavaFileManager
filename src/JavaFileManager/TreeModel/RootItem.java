package JavaFileManager.TreeModel;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Класс, реализующий интерфейс и отвечающий за отображение Root
public class RootItem implements FileTreeItem {

    @Override
    public int getChildCount() {
        return listItems().size();
    }

    //Получение дочернего элемента по индексу - переход в FileItems
    @Override
    public FileTreeItem getChild(int index) {
        List<File> items = listItems();
        if (index >= items.size()) {
            return null;
        }
        return new FileItem(items.get(index));
    }

    //Проверка на конечный элемент (папка/файл/рут)
    @Override
    public boolean isLeaf() {
        return false;
    }

    // Метод формирующий список Root (все диски и дополнительные ответвления)
    private List<File> listItems() {
        List<File> items = new ArrayList<>(Arrays.asList(File.listRoots()));
       // items.add(new File("C:\\Users\\Pamela\\Downloads"));  //Возможность добавлять дополнительные Root
        return items;
    }

    @Override
    public String toString() {
        return "My computer";
    }
}
