package JavaFileManager.Gui;

import JavaFileManager.TreeModel.FileTreeModel;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

 class TreePanel extends JPanel{

    JTree tree = new JTree(new FileTreeModel());
    BorderLayout borderLayout = new BorderLayout();



    public TreePanel() {

        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(200,300));



        tree.setDragEnabled(true);
        add(tree);
    }


}
