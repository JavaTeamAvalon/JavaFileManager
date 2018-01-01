package JavaFileManager.Gui;

import javafx.scene.control.Tab;

import javax.swing.*;
import java.awt.*;

class TabbedPanelGui extends JPanel {

    static JTabbedPane tabbedPane = new JTabbedPane();
    private ChangeExtPanel changeExtPanel = new ChangeExtPanel();
    static ChangeNamePanel changeName = new ChangeNamePanel();
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