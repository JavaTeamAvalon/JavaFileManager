package JavaFileManager.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EnterBtnListener extends KeyAdapter{
    DoChangesListener listener = new DoChangesListener();
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println("EnerListener");
        if (keyEvent.getKeyCode() ==10){
            ActionEvent actionEvent = null;
            listener.actionPerformed(actionEvent);
            }
    }
}
