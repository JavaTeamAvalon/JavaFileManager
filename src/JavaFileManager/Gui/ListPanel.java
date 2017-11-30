package JavaFileManager.Gui;

import javax.swing.*;
import java.util.ArrayList;

// Панель листа файлов
public class ListPanel extends JPanel{
    private JList listfiles = new JList();
    private JLabel listName = new JLabel("Список файлов");

    public ListPanel() {
        listfiles.setLayoutOrientation(JList.VERTICAL);
        add(listName);
        add(listfiles);
    }

    //Метод для получения массива строк листа (пути файлов)
    private ArrayList<String> getList (){
        ArrayList<String> fileNames=new ArrayList<>();
        for(int i =0; i<listfiles.getModel().getSize();i++)
            fileNames.add((String) listfiles.getModel().getElementAt(i));
        return fileNames;
    }
}
