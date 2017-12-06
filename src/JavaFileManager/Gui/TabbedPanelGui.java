package JavaFileManager.Gui;

import javax.swing.*;
import java.awt.*;

class TabbedPanelGui extends JPanel {

    private JTabbedPane tabbedPane = new JTabbedPane();
    private ChangeExtPanel changeExtPanel = new ChangeExtPanel();
    private ChangeNamePanel changeName = new ChangeNamePanel();

    public TabbedPanelGui() {
        tabbedPane.addTab("Дополнить имя",changeName);
        tabbedPane.addTab("Изменить расширение",changeExtPanel);
        tabbedPane.addTab("Изменить атрибуты",new Button("test3"));

        setLayout(new BorderLayout());
        add(tabbedPane,BorderLayout.CENTER);
        add(new Button("Do Changes"),BorderLayout.SOUTH);
    }
}