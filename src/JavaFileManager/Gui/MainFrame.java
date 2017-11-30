package JavaFileManager.Gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300,300));
        setSize(700,700);

        TreePanel treePanel = new TreePanel();
        ListPanel listPanel = new ListPanel();
        TabbedPaneGui tabbedPaneGui = new TabbedPaneGui();

        add(addScroll(treePanel),BorderLayout.WEST);
        add(addScroll(listPanel),BorderLayout.CENTER);
        add(addScroll(tabbedPaneGui),BorderLayout.EAST);
        setVisible(true);
        //pack();
    }

    //Метод для обертки компонента в Scroll
        public JComponent addScroll(JComponent component) {
        JScrollPane Scroll = new JScrollPane(component);
        return Scroll;
    }

}
