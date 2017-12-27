package JavaFileManager.TreeModel;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class TreeTransferHandler extends TransferHandler {

    @Override
    public int getSourceActions(JComponent component) {
        if (isJTree(component)) {
            return DnDConstants.ACTION_COPY;
        }
        return super.getSourceActions(component);
    }

    @Override
    protected Transferable createTransferable(JComponent component) {
        if (isJTree(component)) {
            JTree tree = (JTree) component;
            return new FileListTransferable(extractFiles(tree));
        }
        return super.createTransferable(component);
    }

    private boolean isJTree(Component component) {
        return component instanceof JTree;
    }

    private List<File> extractFiles(JTree tree) {
        List<File> files = new LinkedList<>();
        TreePath[] treePaths = tree.getSelectionModel().getSelectionPaths();
        for (TreePath treePath : treePaths) {
            Object selectedElement = treePath.getLastPathComponent();
            if (!(selectedElement instanceof FileItem)) {
                continue;
            }
            FileItem fileItem = (FileItem) selectedElement;
            files.add(fileItem.getFile());
        }
        return files;
    }
}
