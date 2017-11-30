package JavaFileManager.TreeModel;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class FileTreeModel implements TreeModel {

    private final RootItem rootItem;

    public FileTreeModel() {
        this.rootItem = new RootItem();
    }

    @Override
    public FileTreeItem getRoot() {
        return rootItem;
    }

    @Override
    public FileTreeItem getChild(Object parent, int i) {
        return ((FileTreeItem) parent).getChild(i);
    }

    @Override
    public int getChildCount(Object parent) {
        return ((FileTreeItem) parent).getChildCount();
    }

    @Override
    public boolean isLeaf(Object o) {
        return ((FileTreeItem) o).isLeaf();
    }

    @Override
    public void valueForPathChanged(TreePath treePath, Object o) { }

    @Override
    public int getIndexOfChild(Object o, Object o1) {
        return 0;
    }

    //!!!Надо переопределить
    @Override
    public void addTreeModelListener(TreeModelListener treeModelListener) { }


    @Override
    public void removeTreeModelListener(TreeModelListener treeModelListener) {

    }
}
