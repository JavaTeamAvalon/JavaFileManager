package JavaFileManager.Gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {

        Container container = getContentPane();
        TreePanel treePanel = new TreePanel();
        container.add(addScroll(treePanel));
        setVisible(true);
        pack();
    }

    //Метод для обертки компонента в Scroll
        public JComponent addScroll(JComponent component) {
        JScrollPane Scroll = new JScrollPane(component);
        return Scroll;
    }

}
