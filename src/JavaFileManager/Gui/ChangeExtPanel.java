package JavaFileManager.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.FlowLayout.RIGHT;

public class ChangeExtPanel extends JPanel{

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

        //Вспомогательные панели: панель кнопок и панель полей
        buttonPanel.add(newFieldButton);
        buttonPanel.add(delFieldButton);
        fieldPanel.setLayout(new GridLayout(0,2,20,10));

        //Основная панель
        setSize(200,400);
        setLayout(new BorderLayout());
        add(buttonPanel,BorderLayout.NORTH);
        fieldPanel.add(new JLabel("Текущее расширение"));
        fieldPanel.add(new JLabel("Новое расширение"));
        arraySetFields();
        add(fieldPanel,BorderLayout.CENTER);
  }


    //Метод формирования массива полей, ограниченный 10 штуками
    void arraySetFields ()
    {
        for(int i=0;i<10;i++) {
            currentExt.add(new JTextField());
            newExt.add(new JTextField());
            currentExt.get(i).setVisible(false);
            newExt.get(i).setVisible(false);
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
