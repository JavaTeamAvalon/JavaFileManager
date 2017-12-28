package JavaFileManager.Gui;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


//Реализация DnD через JLabel

public class ListPanelV2 extends JPanel{

    private JList listfiles = new JList();

    ListPanelV2 (String name) {

        DefaultListModel listModel = new DefaultListModel();
        JList list = new JList();
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

    //Метод для получения массива строк листа (пути файлов)
    private ArrayList<String> getList (){
        ArrayList<String> fileNames=new ArrayList<>();
        for(int i =0; i<listfiles.getModel().getSize();i++)
            fileNames.add((String) listfiles.getModel().getElementAt(i));
        return fileNames;
    }
}
