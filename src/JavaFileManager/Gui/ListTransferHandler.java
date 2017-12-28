package JavaFileManager.Gui;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ListTransferHandler extends TransferHandler {


    @Override
            public boolean canImport(TransferHandler.TransferSupport support) {

                return support.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
            }

            @Override
            public boolean importData(TransferHandler.TransferSupport support) {
                JList list = (JList)support.getComponent();
                DefaultListModel listModel = (DefaultListModel)list.getModel();
                Transferable t = support.getTransferable();
                try {

                    if (t.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                        List<File> files = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);

                        for (File file: files) {
                            if (isElement(listModel,file)&&file.isFile())
                            listModel.addElement(new FileListItem(file));
                        }



                    } else if (t.isDataFlavorSupported(DataFlavor.stringFlavor)) {

                        Object o = t.getTransferData(DataFlavor.stringFlavor);
                        String str = o.toString();
                      }

                } catch (UnsupportedFlavorException | IOException e) {
                }

                return super.importData(support);
            }


    private boolean isElement (DefaultListModel listmodel, File file){
       for (int i = 0; i <listmodel.size() ; i++) {

            if (new File(listmodel.getElementAt(i).toString()).equals(file))
                return false;
        }
                return  true;
    }
}


