package JavaFileManager.Gui;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ChangeNamePanel extends JPanel {

private JPanel inputPanel = new JPanel(new BorderLayout());
private JPanel radioBoxPanel = new JPanel();
private JPanel comboTextBoxPanel = new JPanel();
private JPanel datepanel = new JPanel();  //Панель с кнопками шаблонов дат
private JRadioButton beginRButton = new JRadioButton("В начало",true);
private JRadioButton endRButton = new JRadioButton("В конец",false);
private JComboBox combo = new JComboBox();
private ButtonGroup groupRadioBeginEnd = new ButtonGroup();
private ButtonGroup groupRadioDate = new ButtonGroup();
private JFormattedTextField text= new JFormattedTextField();   // Текстовое поля для форматированного текста



    public ChangeNamePanel() {
        setLayout(new BorderLayout());

        //RadioPanel to North of main Layout

        ///////

        ///////

        radioBoxPanel.setLayout(new BoxLayout(radioBoxPanel,BoxLayout.X_AXIS));
        radioBoxPanel.setBorder(BorderFactory.createLineBorder(Color.black,1));
        radioBoxPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        groupRadioBeginEnd.add(beginRButton);
        groupRadioBeginEnd.add(endRButton);
        radioBoxPanel.add(beginRButton);
        radioBoxPanel.add(endRButton);

        //InputPanel
        tamplateMethodEntry("null");   //Текст по дефолту
        combo.setPreferredSize(new Dimension(120,25));
        comboTextBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        comboTextBoxPanel.add(combo);
        comboTextBoxPanel.add(text);
        combo.addItem("Дополнение");
        combo.addItem("Дата/Время");
        combo.addActionListener(comboListener);
            inputPanel.add(comboTextBoxPanel,BorderLayout.NORTH);
            inputPanel.setBorder(BorderFactory.createLineBorder(Color.black,1));
            inputPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            inputPanel.add(dateExamplePanel(),BorderLayout.CENTER);


        //MainPanel
        add(radioBoxPanel,BorderLayout.NORTH);
        add(inputPanel);

        tamplateMethodEntry("dd/mm/yyy");

    }

    // Панель с радиокнопками
    JPanel dateExamplePanel() {

        JRadioButton rDate1 = new JRadioButton("DD/MM/YYYY",true);
        JRadioButton rDate2 = new JRadioButton("YYYY/MM/DD",false);
        JRadioButton rDate3 = new JRadioButton("HH/MM",false);
        JRadioButton rDate4 = new JRadioButton("YYYY/MM/DD + HH/MM",false);
            rDate1.addActionListener(dateRadioListener);
            rDate2.addActionListener(dateRadioListener);
            rDate3.addActionListener(dateRadioListener);
            rDate4.addActionListener(dateRadioListener);
        groupRadioDate.add(rDate1);
        groupRadioDate.add(rDate2);
        groupRadioDate.add(rDate3);
        groupRadioDate.add(rDate4);
        datepanel.setLayout(new BoxLayout(datepanel, BoxLayout.X_AXIS));
        datepanel.add(rDate1);
        datepanel.add(rDate2);
        datepanel.add(rDate3);
        datepanel.add(rDate4);
        datepanel.setVisible(false);
        return datepanel;
    }

// Метод отображения TextField
    void tamplateMethodEntry(String dateTamplate) {
       MaskFormatter dateMask = null;

       switch (dateTamplate) {
           case "null": {
                  break;
           }
           case "dd/mm/yyyy": {
               try {
                    dateMask = new MaskFormatter("##/##/####");
                    dateMask.setPlaceholderCharacter('_');
                    dateMask.setValidCharacters("0123456789");
             } catch (ParseException e) {
            // TODO Auto-generated catch block
                    e.printStackTrace();
               }
               break;
               }
           case "yyyy/mm/dd" : {
               try {
                   dateMask = new MaskFormatter("####/##/##");
                   dateMask.setPlaceholderCharacter('_');
                   dateMask.setValidCharacters("0123456789");
               } catch (ParseException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
               }
               break;
               }
           case "hh/mm" : {
               try {
                   dateMask = new MaskFormatter("##/##");
                   dateMask.setPlaceholderCharacter('_');
                   dateMask.setValidCharacters("0123456789");
               } catch (ParseException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
               }
               break;
               }
           case "yyyy/mm/dd/hh/mm" : {
               try {
                   dateMask = new MaskFormatter("####/##/##//##:##");
                   dateMask.setPlaceholderCharacter('_');
                   dateMask.setValidCharacters("0123456789");
               } catch (ParseException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
               }
               break;
               }
       }
       if (text!=null)
       {comboTextBoxPanel.remove(text);}

        text = new JFormattedTextField(dateMask);
        text.setPreferredSize(new Dimension(150,25));

        text.setHorizontalAlignment(JTextField.LEFT);
        comboTextBoxPanel.add(text);
        comboTextBoxPanel.validate();

    }

    //Листенер на радио кнопки выбора шаблона даты и изменение текстового поля
    ActionListener dateRadioListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent event)
        {
            switch (((JRadioButton)event.getSource()).getText() ) {
                case "DD/MM/YYYY" :
                    tamplateMethodEntry("dd/mm/yyyy");
                    break;
                case "YYYY/MM/DD" :
                    tamplateMethodEntry("yyyy/mm/dd");
                    break;
                case "HH/MM" :
                    tamplateMethodEntry("hh/mm");
                    break;
                case "YYYY/MM/DD + HH/MM" :
                    tamplateMethodEntry("yyyy/mm/dd/hh/mm");
                    break;
                default:
                    break;
            }

        }
    };
//Листенер на кнопки Начало и Конец
    ActionListener beginendRadioListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent event)
        {
            switch (((JRadioButton)event.getSource()).getText() ) {
                case "В начало" :
                    //описание события!!!!
                    break;
                case "В конец" :
                    //описание события!!!!
                    break;

            }

        }
    };

// Листенер на комбо бокс
    ActionListener comboListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent event)
        {
           switch (combo.getSelectedIndex()) {
                case 0 : {
                    datepanel.setVisible(false);
                    tamplateMethodEntry("null");
                    break;
                }
                case 1 :
                    datepanel.setVisible(true);
                    tamplateMethodEntry("dd/mm/yyyy");
                    break;

            }

        }

    };


}




