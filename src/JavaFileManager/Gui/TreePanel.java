package JavaFileManager.Gui;

import JavaFileManager.TreeModel.FileTreeModel;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;

class TreePanel extends JPanel implements Transferable
{

    JTree tree = new JTree(new FileTreeModel());
    BorderLayout borderLayout = new BorderLayout();



    public TreePanel() {

        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(200,300));

        tree.setDragEnabled(true);
        add(tree);
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[0];
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        return false;
    }

    @Override
    public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
        return null;
    }


}
