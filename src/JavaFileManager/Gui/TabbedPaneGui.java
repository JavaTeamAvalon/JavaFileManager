package JavaFileManager.Gui;

import javax.swing.*;
import java.awt.*;

class TabbedPanelGui extends JPanel {

    JTabbedPane tabbedPane = new JTabbedPane();
    ChangeExtPanel changeExtPanel = new ChangeExtPanel();
    ChangeNamePanel changeName = new ChangeNamePanel();

    public TabbedPanelGui() {
        tabbedPane.addTab("Дополнить имя",changeName);
        tabbedPane.addTab("Изменить расширение",changeExtPanel);
        tabbedPane.addTab("Изменить атрибуты",new Button("test3"));

        setLayout(new BorderLayout());
        add(tabbedPane,BorderLayout.CENTER);
        add(new Button("Do Changes"),BorderLayout.SOUTH);
    }
}