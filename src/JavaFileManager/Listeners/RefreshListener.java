package JavaFileManager.Listeners;

import JavaFileManager.Gui.TreePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RefreshListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        
      TreePanel.tree.updateUI();
    }


}
