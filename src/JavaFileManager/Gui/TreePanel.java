package JavaFileManager.Gui;

import JavaFileManager.TreeModel.FileTreeModel;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

import java.io.IOException;

class TreePanel extends JPanel implements Transferable
{

    JTree tree = new JTree(new FileTreeModel());


    public static final DataFlavor[] flavors = new DataFlavor[]{DataFlavor.javaFileListFlavor};

    public TreePanel() {

        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(200,300));

        tree.setDragEnabled(true);
        add(tree);
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return flavors;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        if (dataFlavor.equals(flavors[0]))
        {
            return true;
        }
        return false;
    }

    @Override
    public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
        {
            if (!isDataFlavorSupported(dataFlavor))
            {
                System.out.println("unsuported flavor");
                return null;
            }
            if (dataFlavor.equals(flavors[0]))
            {
                return(null);
            }
            return null;
        }
    }
}
