package JavaFileManager.Gui;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

public class WarningFrame extends JFrame {

    public WarningFrame() {
        showMessageDialog(this,
                "Incorrect data",
                "Warning",
                WARNING_MESSAGE);
    }
    public WarningFrame(String message) {
        showMessageDialog(this,
                message,
                "Warning",
                WARNING_MESSAGE);
    }

}
