package JavaFileManager.Gui;

import JavaFileManager.LogicMethodsClass;
import JavaFileManager.Main;

import javax.swing.*;
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
        switch (TabbedPanelGui.tabbedPane.getSelectedIndex()) {
            case 0: {
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
                    MainFrame.listPanelMain.reBuildmodel(files);
                }
                else {
                    new WarninFrame();

                }



                break;
            }



//        System.out.println("Begin For///");
//        for (int i = 0; i < model.getSize(); i++) {
//            String s = model.getElementAt(i).toString();
//            files.add(new File(s));
//            System.out.println(files.get(i));
//        }
//               try {
//                   doSomething.addPrefix(files,true,"FuckinfShit");
//               } catch (IOException e) {
//                   e.printStackTrace();
//               }
//               for (File file:files){
//                   model.addElement(file);
//               }
//               MainFrame.listPanelMain.repaint();

//
//               ArrayList<File> arlist = new ArrayList<>();
//               arlist = MainFrame.listPanelMain.getList();
//               for (int i = 0; i <arlist.size() ; i++) {
//                   arlist.get(i) =
//               }
//               break;
//           }
//           case 1:{
//               break;
//           }
//           case 2:{
//               break;
//           }
//       }

        }
    }}

