package JavaFileManager.TreeModel;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileListTransferable implements Transferable {

    private static final DataFlavor DATA_FLAVOR = DataFlavor.javaFileListFlavor;
    private static final DataFlavor[] DATA_FLAVORS = {DATA_FLAVOR};

    private final List<File> files;

    public FileListTransferable(List<File> files) {
        this.files = new LinkedList<>(files);
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return DATA_FLAVORS;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DATA_FLAVOR);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        return files;
    }
}
