package JavaFileManager.Listeners;

import JavaFileManager.Gui.AttributesPanel;
import JavaFileManager.Gui.ChangeNamePanel;
import JavaFileManager.Gui.MainFrame;
import JavaFileManager.Gui.TabbedPanelGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateListener implements ActionListener {
    public static int dateTemplate;
    DateFormat dateFormat;

  public CurrentDateListener(int i){
      dateTemplate = i;
  }
    public CurrentDateListener(){

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        switch (dateTemplate){
            case 0:{
                dateFormat = new SimpleDateFormat("dd-MM-YYYY");
                Date date = new Date();
                TabbedPanelGui.changeName.text.setText(dateFormat.format(date));
                break;
            }
            case 1:{
                dateFormat = new SimpleDateFormat("YYYY-MM-DD");
                Date date = new Date();
                TabbedPanelGui.changeName.text.setText(dateFormat.format(date));
                break;
            }
            case 2:{
                dateFormat = new SimpleDateFormat("HH-mm");
                Date date = new Date();
                TabbedPanelGui.changeName.text.setText(dateFormat.format(date));
                break;
            }
            case 4:{
                dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
                Date date = new Date();
                TabbedPanelGui.attributesPanel.createDateTxt.setText(dateFormat.format(date));
                TabbedPanelGui.attributesPanel.modifiedDateTxt.setText(dateFormat.format(date));
                break;
            }

        }
    }
}
