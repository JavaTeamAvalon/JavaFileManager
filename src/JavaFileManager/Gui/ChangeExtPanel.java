package JavaFileManager.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import static java.awt.FlowLayout.RIGHT;

public class ChangeExtPanel extends JPanel{

         JPanel currentExtPanel = new JPanel();
         JPanel newExtPanel = new JPanel();
        public static JTextField curExtField = new JTextField();
        public static JTextField newExtField = new JTextField();
    JPanel fieldPanel = new JPanel();
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton newFieldButton = new JButton("Add fields");
    JButton delFieldButton = new JButton("Delete fields");

    ArrayList<JTextField> currentExt = new ArrayList<>();
    ArrayList<JTextField> newExt = new ArrayList<>();


    public ChangeExtPanel() {
        //Listners for buttons to do methods, described bellow
        newFieldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                arrayAddFields();
            }
        });
        delFieldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                arrayDelFields();
            }
        });

        //Новое наполнение класса (без кнопок, без гридлэйаута)
        currentExtPanel.setLayout(new BoxLayout(currentExtPanel,BoxLayout.Y_AXIS));
        newExtPanel.setLayout(new BoxLayout(newExtPanel,BoxLayout.Y_AXIS));
        curExtField.setPreferredSize(new Dimension(100,25));
        newExtField.setPreferredSize(new Dimension(100,25));
            currentExtPanel.add(new JLabel("Текущее расширение"));
            currentExtPanel.add(curExtField);
            newExtPanel.add(new JLabel("Новое расширение"));
            newExtPanel.add(newExtField);



        //Вспомогательные панели: панель кнопок и панель полей
        buttonPanel.add(newFieldButton);
        buttonPanel.add(delFieldButton);
        fieldPanel.setLayout(new GridLayout(0,2,20,10));

        //Основная панель

            setLayout(new FlowLayout(FlowLayout.LEFT));
            add(currentExtPanel);
            add(newExtPanel);

  }



    public boolean isExpansionTrue (File file, String oldExp){
        String Exp = file.getName().substring(file.getName().lastIndexOf(".")+1,file.getName().length());
        if (Exp.equals(oldExp)) {
            return true;
        }
        else {
            return false;
        }

}


    //Метод формирования массива полей, ограниченный 10 штуками
    void arraySetFields ()
    {
        for(int i=0;i<2;i++) {   //Количество полей. Решил не убирать метод, вдруг нужно будет добавить поля
            currentExt.add(new JTextField());
            newExt.add(new JTextField());
            currentExt.get(i).setVisible(true);  //изменить на false если нужно скрывать поля
            newExt.get(i).setVisible(true);      //изменить на false если нужно скрывать поля
            fieldPanel.add(currentExt.get(i));
            fieldPanel.add(newExt.get(i));
        }

        currentExt.get(0).setVisible(true);
        newExt.get(0).setVisible(true);

    }
    //Метод добавления(отображения) полей
    void arrayAddFields (){
        for(int i=0;i<currentExt.size();i++)
            if (!currentExt.get(i).isVisible())
            {
                currentExt.get(i).setVisible(true);
                newExt.get(i).setVisible(true);
                delFieldButton.setEnabled(true);
                if (i==currentExt.size()-1)
                    newFieldButton.setEnabled(false);
                break;
            }
    }
    //Метод удаления(отображения) полей
    void arrayDelFields (){
        for(int i=0;i<currentExt.size();i++)
            if (currentExt.get(currentExt.size()-i-1).isVisible())
            {
                currentExt.get(currentExt.size()-i-1).setVisible(false);
                newExt.get(currentExt.size()-i-1).setVisible(false);
                currentExt.get(currentExt.size()-i-1).setText("");
                newExt.get(currentExt.size()-i-1).setText("");
                newFieldButton.setEnabled(true);
                if (i==currentExt.size()-2)
                    delFieldButton.setEnabled(false);
                break;
            }
    }
}
