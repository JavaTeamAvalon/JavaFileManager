package JavaFileManager.Gui;

import JavaFileManager.TreeModel.FileTreeModel;

import javax.swing.*;

public class TreePanel extends JPanel{

    public TreePanel() {

    JTree tree = new JTree(new FileTreeModel());
    add(tree);
    }


}
