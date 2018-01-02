package JavaFileManager.Gui;

import JavaFileManager.TreeModel.FileTreeModel;
import JavaFileManager.TreeModel.TreeTransferHandler;

import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel {

    public static JTree tree = new JTree(new FileTreeModel());

    public TreePanel() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(200, 300));
        tree.setDragEnabled(true);
        tree.setTransferHandler(new TreeTransferHandler());
        add(tree);
    }


}
