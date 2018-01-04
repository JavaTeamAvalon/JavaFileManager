package JavaFileManager.Listeners;

import JavaFileManager.Gui.AttributesPanel;
import JavaFileManager.Gui.TabbedPanelGui;
import JavaFileManager.Gui.WarningFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CopyCreateDateToModified implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String createDate = TabbedPanelGui.attributesPanel.createDateTxt.getText();
        if (AttributesPanel.checkCorrectFields(createDate))
            TabbedPanelGui.attributesPanel.modifiedDateTxt.setText(createDate);
        else new WarningFrame();
    }
}
