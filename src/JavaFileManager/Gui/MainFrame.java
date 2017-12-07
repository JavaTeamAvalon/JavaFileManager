package JavaFileManager.Gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

     public MainFrame() throws HeadlessException {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container = getContentPane();
        setMinimumSize(new Dimension(300,300));
        setMaximumSize(new Dimension(700,500));
        setSize(700,700);
        setResizable(false);
        setLocationRelativeTo(null); //размещение фрэйма по центру экрана

        JPanel leftPanel = new JPanel(); //Панель для Tree и панели поиска
        leftPanel.setLayout(new BorderLayout());

         //Панель поиска
         JTextField searchTxt = new JTextField();
         JButton refreshBtn = new JButton();
         JButton enterBtn = new JButton();
         JPanel searchPanel = new JPanel();

         try {
             ImageIcon icon1 = new ImageIcon(TreePanel.class.getResource("refresh.png"));
             refreshBtn.setIcon(icon1);
             ImageIcon icon2 = new ImageIcon(TreePanel.class.getResource("Enter.png"));
             enterBtn.setIcon(icon2);
         } catch (Exception ex ) {}

         searchTxt.setPreferredSize(new Dimension(275,25));
         searchTxt.setDragEnabled(true);
         enterBtn.setPreferredSize(new Dimension(25,25));
         enterBtn.setBorderPainted(false);
         refreshBtn.setPreferredSize(new Dimension(25,25));
         refreshBtn.setBorderPainted(false);

         searchPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
         searchPanel.add(searchTxt);
         searchPanel.add(enterBtn);
         searchPanel.add(refreshBtn);




        //Init Components
        TreePanel treePanel = new TreePanel();
        ListPanel listPanelMain = new ListPanel("Список файлов");
        ListPanel listPanelPreview = new ListPanel("Превью файлов");
        TabbedPanelGui tabbedPaneGui = new TabbedPanelGui();
        JSplitPane split,splitList,splitInSplit;

         //Формирование левой панели
         leftPanel.add(searchPanel,BorderLayout.NORTH);
         leftPanel.add(addScroll(treePanel,350,700));


        //SplitListPane
        splitList = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitList.setTopComponent(addScroll(listPanelMain,200,300));
        splitList.setBottomComponent(addScroll(listPanelPreview,200,100));
        splitList.setContinuousLayout(true);
        splitList.setOneTouchExpandable(true);
        splitList.setMinimumSize(new Dimension(100,300));


        //SplitInSplit (Панель в панели)
        splitInSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitInSplit.setLeftComponent(leftPanel);
        splitInSplit.setRightComponent(splitList);//;
        splitInSplit.setOneTouchExpandable(true);
         splitList.setMinimumSize(new Dimension(100,450));


        //Main SplitPane
        split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        split.setTopComponent(splitInSplit);
        split.setBottomComponent(addScroll(tabbedPaneGui,300,700));
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
