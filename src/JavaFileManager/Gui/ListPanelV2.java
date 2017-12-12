package JavaFileManager.Gui;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.TransferHandler;


//Реализация DnD через JLabel

public class ListPanelV2 {

    JLabel label = new JLabel("Перетащите файлы в это поле", JLabel.CENTER);

    ListPanelV2 () {

        label.setTransferHandler(new TransferHandler(null) {

            @Override
            public boolean canImport(TransferHandler.TransferSupport support) {

                return support.isDataFlavorSupported(DataFlavor.javaFileListFlavor)
                        || support.isDataFlavorSupported(DataFlavor.stringFlavor);
            }

            @Override
            public boolean importData(TransferHandler.TransferSupport support) {

                Transferable t = support.getTransferable();
                try {

                    if (t.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {

                        Object o = t.getTransferData(DataFlavor.javaFileListFlavor);

                        List<File> files = (List<File>) o;

                        StringBuilder sb = new StringBuilder("<ul>");
                        for (File file : files)
                            sb.append("<br>" + file);
                        label.setText("<html>" + files.size() + " файлов выбрано<br>" + sb);

                    } else if (t.isDataFlavorSupported(DataFlavor.stringFlavor)) {

                        Object o = t.getTransferData(DataFlavor.stringFlavor);
                        String str = o.toString();

                        label.setText("<html>Слишком много файлов перенесено<br>" + str);
                        }

                } catch (UnsupportedFlavorException | IOException e) {
                }

                return super.importData(support);
            }
        });
    }
}
