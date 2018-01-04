package JavaFileManager.Listeners;

import JavaFileManager.Gui.*;
import JavaFileManager.LogicMethodsClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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

                else if (currentExp.equals(str) && !newExp.equals(str)) {
                    for (File file : MainFrame.listPanelMain.getList()) {
                        allfiles.add(file);
                    }
                    try {
                        allfiles = doSomething.changeExpansion(allfiles, newExp);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    MainFrame.listPanelMain.reBuildmodelFile(allfiles);
                    TreePanel.tree.updateUI();

                }else new WarningFrame();

                break;
            }
            case 2:{
                String modifiedDate,createDate;

                ArrayList<File> currentfiles = new ArrayList<>();
                if (!MainFrame.listPanelMain.getList().isEmpty())
                currentfiles=MainFrame.listPanelMain.getList();

                createDate = TabbedPanelGui.attributesPanel.createDateTxt.getText();
                modifiedDate = TabbedPanelGui.attributesPanel.modifiedDateTxt.getText();
                if(!AttributesPanel.checkCorrectFields(createDate)&&!AttributesPanel.checkCorrectFields(modifiedDate)){
                    new WarningFrame();
                    TabbedPanelGui.attributesPanel.createDateTxt.setText("");
                    TabbedPanelGui.attributesPanel.modifiedDateTxt.setText("");
                    return;
                }
                try {
                    if (!AttributesPanel.checkCreateLessModified(createDate,modifiedDate))
                        return;
                    doSomething.changeCreateDate(currentfiles,createDate);
                    TabbedPanelGui.attributesPanel.createDateTxt.setText("");
                    doSomething.changeLastModifiedDate(currentfiles,modifiedDate);
                    TabbedPanelGui.attributesPanel.modifiedDateTxt.setText("");
//
                } catch (ParseException ignore) {}
                catch (IOException ignore) {}
            }
        }
    }
}

