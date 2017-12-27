package JavaFileManager.Gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Панель листа файлов
public class ListPanel extends JPanel{
    private JList listfiles = new JList();


    public ListPanel(String name) {
        setLayout(new BorderLayout());
        JLabel listName = new JLabel(name);
        listfiles.setLayoutOrientation(JList.VERTICAL);
        add(listName, BorderLayout.NORTH);
        listfiles.setDropMode(DropMode.INSERT);
        listfiles.setTransferHandler(new ListTransferHandler());
        DefaultListModel listModel = new DefaultListModel();
        listfiles.setModel(listModel);
//        listModel.addElement("1111");
//        listModel.addElement("2222");
//        listModel.addElement("3333");
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
