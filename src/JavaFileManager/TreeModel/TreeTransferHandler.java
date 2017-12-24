package JavaFileManager.TreeModel;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TreeTransferHandler extends TransferHandler {



//    @Override
//    public int getSourceActions(JComponent jComponent) {
//        return COPY;
//    }
//
//    @Override
//    protected Transferable createTransferable(JComponent jComponent) {
//        JList l = (JList)jComponent;
//        return new StringSelection(l.getSelectedValue().toString());
//    }

//    @Override
//    protected void exportDone(JComponent jComponent, Transferable transferable, int action) {
//        if (action == COPY)
//        {
//            JList l = (JList)jComponent;
//            DefaultListModel dlm = (DefaultListModel)l.getModel();
//
//        }
//    }

    @Override
    public boolean canImport(TransferSupport supp) {

        return supp.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
//                || supp.isDataFlavorSupported(DataFlavor.stringFlavor);

    }


    @Override
    public boolean importData(TransferSupport supp) {
        if (!supp.isDrop())
            return  false;
        JList list = (JList)supp.getComponent();
       String data;
       Transferable t = supp.getTransferable();

        try
        {
            data = (String)t.getTransferData(DataFlavor.stringFlavor);

        } catch (Exception e) {
            return false;
        }


        DefaultListModel listModel = (DefaultListModel)list.getModel();
        JList.DropLocation dl = (JList.DropLocation)supp.getDropLocation();
        int index = dl.getIndex();
        listModel.add(index,data);
        return true;

    }

}
