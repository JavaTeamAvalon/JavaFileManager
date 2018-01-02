package JavaFileManager.Listeners;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DelListener extends KeyAdapter {
   private DefaultListModel listModel;
   private JList list;

   public DelListener(DefaultListModel listModel, JList list){
       this.listModel = listModel;
       this.list = list;
   }
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 127)
            for (int i = 0; i <listModel.size(); i++) {
                while (!list.isSelectionEmpty())
                    listModel.remove(list.getSelectedIndex());
            }
    }
}
