package JavaFileManager.Gui;

import JavaFileManager.Listeners.DoChangesListener;

import javax.swing.*;
import java.awt.*;

public class TabbedPanelGui extends JPanel {

    public static JTabbedPane tabbedPane = new JTabbedPane();
    public static ChangeExtPanel changeExtPanel = new ChangeExtPanel();
    public static ChangeNamePanel changeName = new ChangeNamePanel();
    private JButton changeBtn = new JButton("Do Changes");

    public TabbedPanelGui() {

        tabbedPane.addTab("Дополнить имя",changeName);
        tabbedPane.addTab("Изменить расширение",changeExtPanel);
        tabbedPane.addTab("Изменить атрибуты",new Button("test3"));

        setLayout(new BorderLayout());
        add(tabbedPane,BorderLayout.CENTER);
        changeBtn.addActionListener(new DoChangesListener());
        add(changeBtn,BorderLayout.SOUTH);
    }

    private boolean checkFields(){

        return true;
    }


}