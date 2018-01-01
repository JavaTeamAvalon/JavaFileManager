package JavaFileManager.Gui;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;


//Реализация DnD через JLabel

public class ListPanelV2 extends JPanel{

    private JList list = new JList();
    private DefaultListModel listModel = new DefaultListModel();

    ListPanelV2 (String name) {

//        DefaultListModel listModel = new DefaultListModel();
//        JList list = new JList();
        list.setModel(listModel);
        setLayout(new BorderLayout());
        JLabel listName = new JLabel(name);
        list.setLayoutOrientation(JList.VERTICAL);
        add(listName, BorderLayout.NORTH);
        list.setDropMode(DropMode.INSERT);
        list.setTransferHandler(new ListTransferHandler());

//
//
        add(list);

    }

    DefaultListModel getModel(){
        DefaultListModel model;
        model = (DefaultListModel) list.getModel();
        return model;
    }

    //Метод для получения массива строк листа (пути файлов)
     ArrayList<File> getList (){
        ArrayList<File> fileNames=new ArrayList<>();
        for(int i =0; i<list.getModel().getSize();i++)
            fileNames.add(new File(list.getModel().getElementAt(i).toString()));
        return fileNames;
    }

    /*
    Перестроение JList
     */
    void reBuildmodel (ArrayList<File> files){
        listModel.removeAllElements();
        System.out.println(listModel.size());
        for (int i = 0; i <files.size(); i++) {
           listModel.addElement(files.get(i));
            System.out.println(listModel.getElementAt(i));

        }


    }

}
