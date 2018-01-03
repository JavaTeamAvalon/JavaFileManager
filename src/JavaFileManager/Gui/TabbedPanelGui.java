package JavaFileManager.Gui;

import JavaFileManager.Listeners.DoChangesListener;

import javax.swing.*;
import java.awt.*;

public class TabbedPanelGui extends JPanel {

    public static JTabbedPane tabbedPane = new JTabbedPane();
    public static ChangeExtPanel changeExtPanel = new ChangeExtPanel();
    public static ChangeNamePanel changeName = new ChangeNamePanel();
    public static AttributesPanel attributesPanel = new AttributesPanel();
    private JButton changeBtn = new JButton("Do Changes");

    public TabbedPanelGui() {

        tabbedPane.addTab("Change Name",changeName);
        tabbedPane.addTab("Change Expansion",changeExtPanel);
        tabbedPane.addTab("Change Attributes",attributesPanel);


        setLayout(new BorderLayout());
        add(tabbedPane,BorderLayout.CENTER);
        changeBtn.addActionListener(new DoChangesListener());
        add(changeBtn,BorderLayout.SOUTH);

    }

    private boolean checkFields(){

        return true;
    }


}