package JavaFileManager.Gui;

import JavaFileManager.TreeModel.FileTreeModel;
import JavaFileManager.TreeModel.TreeTransferHandler;

import javax.swing.*;
import java.awt.*;

class TreePanel extends JPanel {

    JTree tree = new JTree(new FileTreeModel());

    public TreePanel() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(200, 300));
        tree.setDragEnabled(true);
        tree.setTransferHandler(new TreeTransferHandler());
        add(tree);
    }


}
