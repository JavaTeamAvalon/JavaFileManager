package JavaFileManager.Others;

import JavaFileManager.Gui.TreePanel;
import JavaFileManager.TreeModel.FileItem;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class EditListAction extends AbstractAction
{
    private JList list;

    private JPopupMenu editPopup;
    private JTextField editTextField;
    private Class<?> modelClass;

    public EditListAction()
    {
        setModelClass(DefaultListModel.class);
    }

    protected void setModelClass(Class modelClass)
    {
        this.modelClass = modelClass;
    }

    protected void applyValueToModel(String value, ListModel model, int row)
    {
        DefaultListModel dlm = (DefaultListModel)model;
        dlm.set(row, value);
    }

    /*
     *	Display the popup editor when requested
     */
    public void actionPerformed(ActionEvent e)
    {
        list = (JList)e.getSource();
        ListModel model = list.getModel();

        if (! modelClass.isAssignableFrom(model.getClass())) return;

        //  Do a lazy creation of the popup editor

        if (editPopup == null)
            createEditPopup();

        //  Position the popup editor over top of the selected row

        int row = list.getSelectedIndex();
        Rectangle r = list.getCellBounds(row, row);

        editPopup.setPreferredSize(new Dimension(r.width, r.height));
        editPopup.show(list, r.x, r.y);

        //  Prepare the text field for editing

        editTextField.setText( list.getSelectedValue().toString() );
        editTextField.selectAll();
        editTextField.requestFocusInWindow();

    }

    /*
     *  Create the popup editor
     */
    private void createEditPopup()
    {
        //  Use a text field as the editor

        editTextField = new JTextField();
        Border border = UIManager.getBorder("List.focusCellHighlightBorder");
        editTextField.setBorder( border );

        //  Add an Action to the text field to save the new value to the model

        editTextField.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String value = editTextField.getText();
                ListModel model = list.getModel();
                int row = list.getSelectedIndex();
                    System.out.println(model.getElementAt(row));
                    File file = new File(model.getElementAt(row).toString());
                applyValueToModel(value, model, row);
                editPopup.setVisible(false);
//
                System.out.println(model.getElementAt(row));
                System.out.println(value);
                file.renameTo(new File(value.toString()));
                TreePanel.tree.updateUI();
            }
        });

        //  Add the editor to the popup

        editPopup = new JPopupMenu();
        editPopup.setBorder( new EmptyBorder(0, 0, 0, 0) );
        editPopup.add(editTextField);
    }
}
