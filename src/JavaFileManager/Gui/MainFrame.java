package JavaFileManager.Gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

     public MainFrame() throws HeadlessException {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container = getContentPane();
        setMinimumSize(new Dimension(300,300));
        setMaximumSize(new Dimension(900,500));
        setSize(900,500);

        //Init Components
        TreePanel treePanel = new TreePanel();
        ListPanel listPanelMain = new ListPanel("Список файлов");
        ListPanel listPanelPreview = new ListPanel("Превью файлов");
        TabbedPanelGui tabbedPaneGui = new TabbedPanelGui();
        JSplitPane split,splitList,splitInSplit;


        //SplitListPane
        splitList = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitList.setTopComponent(addScroll(listPanelMain,200,300));
        splitList.setBottomComponent(addScroll(listPanelPreview,200,100));
        splitList.setContinuousLayout(true);
        splitList.setOneTouchExpandable(true);
        splitList.setMinimumSize(new Dimension(100,300));


        //SplitInSplit (Панель в панели)
        splitInSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitInSplit.setLeftComponent(splitList);
        splitInSplit.setRightComponent(addScroll(tabbedPaneGui,300,700));
        splitInSplit.setOneTouchExpandable(true);


        //Main SplitPane
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        split.setLeftComponent(addScroll(treePanel,200,700));
        split.setRightComponent(splitInSplit);
        split.setOneTouchExpandable(true);


        container.add(split);
        setVisible(true);

    }

    //Метод для обертки компонента в Scroll
        public JComponent addScroll(JComponent component,int row, int col) {
        JScrollPane Scroll = new JScrollPane(component);
        Scroll.setPreferredSize(new Dimension(row,col));
        return Scroll;
    }

}
