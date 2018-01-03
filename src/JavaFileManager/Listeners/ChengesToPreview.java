package JavaFileManager.Listeners;

import JavaFileManager.Gui.*;
import JavaFileManager.LogicMethodsClass;

import javax.swing.*;
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
    public static boolean wasChanged = false; //Переменная для отработки ColorListRender
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
                String[] prefixmas;
                boolean end = false;

                prefix = TabbedPanelGui.changeName.text.getText();
                if (TabbedPanelGui.changeName.combo.getSelectedIndex()==1){
                    prefixmas = prefix.split("-");
                    prefix = "";
                    for(String str:prefixmas)
                        prefix =prefix+str;
                }

                end = TabbedPanelGui.changeName.endRButton.isSelected();
                mainFiles = MainFrame.listPanelMain.getList();
                files = convertToString(mainFiles);
                try {
                    files = doSomething.addPreviewPrefix(files, end, prefix);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                MainFrame.listPanelPreview.reBuildmodelString(files);

                break;
            }
            case 1: {
                System.out.println("TabbedPane = " + 1+"Expansion try no change");
                mainFiles = MainFrame.listPanelMain.getList();
                files = convertToString(mainFiles);
                String str = "";
                String currentExp = ChangeExtPanel.curExtField.getText();
                String newExp = ChangeExtPanel.newExtField.getText();

                ArrayList<File> currentfiles = new ArrayList<>();
                ArrayList<String> changedfiles = new ArrayList<>();
                ArrayList<String> allfiles = new ArrayList<>();

                if (!currentExp.equals(str) && !newExp.equals(str)) {
                    for (File file : MainFrame.listPanelMain.getList()) {
                        if (TabbedPanelGui.changeExtPanel.isExpansionTrue(file, currentExp))
                            currentfiles.add(file);
                        else allfiles.add(file.getName());
                    }
                    try {
                        changedfiles = doSomething.changePreviewExpansion(currentfiles, newExp);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    allfiles.addAll(changedfiles);
                    MainFrame.listPanelPreview.reBuildmodelString(allfiles);


                }else
                    listener.prewiewList();

                break;
            }
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


