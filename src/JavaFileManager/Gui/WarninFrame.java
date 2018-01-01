package JavaFileManager.Gui;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

public class WarninFrame extends JFrame {

    public WarninFrame() {
        showMessageDialog(this,
                "Incorrect format",
                "Warning",
                WARNING_MESSAGE);
    }
}
