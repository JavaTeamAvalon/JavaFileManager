package JavaFileManager.Gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private GridBagLayout gridbagLayout = new GridBagLayout();
    private GridBagConstraints gridConstraints = new GridBagConstraints();

    private void MysetConstraints(GridBagConstraints c){
        c.anchor = GridBagConstraints.WEST;
        c.fill   = GridBagConstraints.VERTICAL;
        c.gridheight = 10;
        c.gridwidth  = 1;
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipadx = 100;
        c.ipady =1000;
        c.weightx = 0.0;
        c.weighty = 0.1;

    }

    public MainFrame() throws HeadlessException {

JPanel panel = new JPanel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container = getContentPane();
        setMinimumSize(new Dimension(300,300));
        setSize(700,700);

        TreePanel treePanel = new TreePanel();
        //treePanel.setPreferredSize(new Dimension(300,500));
        ListPanel listPanel = new ListPanel();
        TabbedPanelGui tabbedPaneGui = new TabbedPanelGui();
        JButton btn = new JButton("New Button");

        setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());

        panel.add(addScroll(listPanel,150,700),BorderLayout.WEST);
        panel.add(addScroll(tabbedPaneGui,300,700),BorderLayout.CENTER);

        container.add(addScroll(treePanel,200,700),BorderLayout.WEST);
        container.add(panel,BorderLayout.CENTER);
        setVisible(true);
        //pack();
    }

    //Метод для обертки компонента в Scroll
        public JComponent addScroll(JComponent component,int row, int col) {
        JScrollPane Scroll = new JScrollPane(component);
        //Scroll.setPreferredSize(new Dimension(row,col));
        return Scroll;
    }

}
