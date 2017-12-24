package JavaFileManager.Gui;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.*;


//Реализация DnD через JLabel

public class ListPanelV2 extends JPanel{

    ListPanelV2 (String name) {

        DefaultListModel listModel = new DefaultListModel();
        JList list = new JList();
        setLayout(new BorderLayout());
        JLabel listName = new JLabel(name);
        list.setLayoutOrientation(JList.VERTICAL);
        add(listName, BorderLayout.NORTH);
        list.setDropMode(DropMode.INSERT);
        list.setTransferHandler(new TransferHandler(null) {

            @Override
            public boolean canImport(TransferHandler.TransferSupport support) {

                return support.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
//                         support.isDataFlavorSupported(DataFlavor.stringFlavor);
            }

            @Override
            public boolean importData(TransferHandler.TransferSupport support) {

                Transferable t = support.getTransferable();
                try {

                    if (t.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {



                        List<File> files = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);

                        for (File file: files) {
                            listModel.addElement(file.toPath());
                        }



                    } else if (t.isDataFlavorSupported(DataFlavor.stringFlavor)) {

                        Object o = t.getTransferData(DataFlavor.stringFlavor);
                        String str = o.toString();
//                        listModel.addElement(str);


                    }

                } catch (UnsupportedFlavorException | IOException e) {
                }

                return super.importData(support);
            }
        });
        add(list);

    }
}
