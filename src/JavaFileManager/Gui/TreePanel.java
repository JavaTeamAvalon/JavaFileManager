package JavaFileManager.Gui;

import JavaFileManager.TreeModel.FileTreeModel;


import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel{

    private JTree tree = new JTree(new FileTreeModel());
    FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);

    public TreePanel() {
        // setLayout(flowLayout);
        //setMinimumSize(new Dimension(200,400));
         setMaximumSize(new Dimension(400,400));
         //tree.setPreferredSize(new Dimension(400,400));
         add(tree,new BorderLayout());
    }


}
