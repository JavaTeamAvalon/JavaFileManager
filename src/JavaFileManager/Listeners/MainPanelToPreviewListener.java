package JavaFileManager.Listeners;

import JavaFileManager.Gui.MainFrame;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class MainPanelToPreviewListener implements ListDataListener {
    ArrayList<File> files;
    ArrayList<String> stringFiles;
    ChengesToPreview changesPreview = new ChengesToPreview();




    @Override
    public void contentsChanged(ListDataEvent listDataEvent) {
        System.out.println("Content "+listDataEvent.toString());
        prewiewList();
//
    }

    @Override
    public void intervalAdded(ListDataEvent listDataEvent) {
        System.out.println("IntervalAdd "+listDataEvent.toString());
        prewiewList();
    }

    @Override
    public void intervalRemoved(ListDataEvent listDataEvent) {
        System.out.println("IntervalDel "+listDataEvent.toString());
        prewiewList();
    }

    private void prewiewList (){
        if (!MainFrame.listPanelMain.getList().isEmpty()){
            MainFrame.listPanelPreview.listModel.removeAllElements();
            files  = MainFrame.listPanelMain.getList();
            for (File file:files) {

                MainFrame.listPanelPreview.listModel.addElement(file.getName());

            }

        }
        else MainFrame.listPanelPreview.listModel.removeAllElements();



    }
}
