package JavaFileManager.Gui;

import javax.swing.*;
import java.awt.*;

public class TabbedPaneGui extends JTabbedPane {

    public TabbedPaneGui() {
        addTab("Изменить имя",new Button("test1"));
        addTab("Изменить расширение",new Button("test2"));
        addTab("Изменить атрибуты",new Button("test3"));
    }
}