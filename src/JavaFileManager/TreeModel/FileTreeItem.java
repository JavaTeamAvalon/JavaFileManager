package JavaFileManager.TreeModel;


//Интерфейс-обертка для File, его реализуют два класса (RootItem и FileItem)
// Class FileTreeModel работает не с File , а с данным интерфейсом
public interface FileTreeItem {
    int getChildCount();

    FileTreeItem getChild(int index);

    boolean isLeaf();
}