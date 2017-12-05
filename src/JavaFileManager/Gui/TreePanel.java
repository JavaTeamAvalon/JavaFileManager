package JavaFileManager.Gui;

import JavaFileManager.TreeModel.FileTreeModel;


import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel{

    private JTree tree = new JTree(new FileTreeModel());
    BorderLayout borderLayout = new BorderLayout();

    public TreePanel() {

        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(200,300));
         add(tree);
    }


}
