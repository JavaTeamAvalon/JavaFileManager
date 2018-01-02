package JavaFileManager.Listeners;

import JavaFileManager.Gui.*;
import JavaFileManager.LogicMethodsClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DoChangesListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Came to Listener");
        LogicMethodsClass doSomething = new LogicMethodsClass();
        if (MainFrame.listPanelMain.getList().isEmpty()){
            new WarningFrame("List is Empty, Please select files");
            return;
        }

        switch (TabbedPanelGui.tabbedPane.getSelectedIndex()) {
            case 0: {
                System.out.println("TabbedPane = "+0);
                String prefix;
                boolean end = false;
                if (TabbedPanelGui.changeName.checkCorrectFields() == true) {
                    prefix= TabbedPanelGui.changeName.text.getText();
                    end = TabbedPanelGui.changeName.endRButton.isSelected();
                    ArrayList<File> files = MainFrame.listPanelMain.getList();
                    try {
                        files = doSomething.addPrefix(files, end, prefix);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    MainFrame.listPanelMain.reBuildmodelFile(files);
                    TreePanel.tree.updateUI();
                }
                else new WarningFrame();

                break;
            }
            case 1:{
                System.out.println("TabbedPane = "+1);
                ArrayList<File> currentfiles = new ArrayList<>();
                ArrayList<File> changedfiles = new ArrayList<>();
                ArrayList<File> allfiles = new ArrayList<>();
                String currentExp = ChangeExtPanel.curExtField.getText();
                String newExp = ChangeExtPanel.newExtField.getText();
                String str = "";

                if (!currentExp.equals(str) && !newExp.equals(str)) {
                    for (File file : MainFrame.listPanelMain.getList()) {
                        if (TabbedPanelGui.changeExtPanel.isExpansionTrue(file, currentExp))
                            currentfiles.add(file);
                        else allfiles.add(file);
                    }
                    try {
                        changedfiles = doSomething.changeExpansion(currentfiles, newExp);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    allfiles.addAll(changedfiles);
                    MainFrame.listPanelMain.reBuildmodelFile(allfiles);
                    TreePanel.tree.updateUI();

                }
                else new WarningFrame();

                break;
            }
        }
    }
}

