package JavaFileManager.Listeners;

import JavaFileManager.Gui.*;
import JavaFileManager.LogicMethodsClass;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class ChengesToPreview implements DocumentListener {
    ArrayList<String> files = new ArrayList<>();
    ArrayList<File> mainFiles = new ArrayList<>();

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
       actionPerformed();
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        actionPerformed();
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
        actionPerformed();
    }


    public void actionPerformed() {
        System.out.println("Came to changing Listener");
        MainPanelToPreviewListener listener = new MainPanelToPreviewListener();

        LogicMethodsClass doSomething = new LogicMethodsClass();
//        if (MainFrame.listPanelMain.getList().isEmpty()){
//            new WarningFrame("List is Empty, Please select files");
//            return;
//        }

        switch (TabbedPanelGui.tabbedPane.getSelectedIndex()) {
            case 0: {
                String prefix;
                boolean end = false;
                //if (TabbedPanelGui.changeName.checkCorrectFields() == true) {
                    prefix= TabbedPanelGui.changeName.text.getText();

                    end = TabbedPanelGui.changeName.endRButton.isSelected();
//                    files = MainFrame.listPanelPreview.getStringList();
                    mainFiles = MainFrame.listPanelMain.getList();
                    files = convertToString(mainFiles);
                    try {
                        files = doSomething.addPreviewPrefix(files, end, prefix);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    MainFrame.listPanelPreview.reBuildmodelString(files);

//                }
//                else new WarningFrame();

                break;
            }
//            case 1:{
//                System.out.println("TabbedPane = "+1);
//                ArrayList<File> currentfiles = new ArrayList<>();
//                ArrayList<File> changedfiles = new ArrayList<>();
//                ArrayList<File> allfiles = new ArrayList<>();
//                String currentExp = ChangeExtPanel.curExtField.getText();
//                String newExp = ChangeExtPanel.newExtField.getText();
//                String str = "";
//
//                if (!currentExp.equals(str) && !newExp.equals(str)) {
//                    for (File file : MainFrame.listPanelMain.getList()) {
//                        if (TabbedPanelGui.changeExtPanel.isExpansionTrue(file, currentExp))
//                            currentfiles.add(file);
//                        else allfiles.add(file);
//                    }
//                    try {
//                        changedfiles = doSomething.changeExpansion(currentfiles, newExp);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    allfiles.addAll(changedfiles);
//                    MainFrame.listPanelMain.reBuildmodelFile(allfiles);
//                    TreePanel.tree.updateUI();
//
//                }
//                else new WarningFrame();
//
//                break;
            }
        }

        private ArrayList convertToString (ArrayList<File> arrlist){
        ArrayList<String> arr = new ArrayList<>();
            for (File file:arrlist) {
                arr.add(file.getName());
            }

            return arr;
        }

}

        /////////////////


