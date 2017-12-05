package JavaFileManager.Gui;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ChangeNamePanel extends JPanel {

JPanel inputPanel = new JPanel(new BorderLayout());
JPanel radioBoxPanel = new JPanel();
JPanel comboTextBoxPanel = new JPanel();
JRadioButton beginRButton = new JRadioButton("В начало",true);
JRadioButton endRButton = new JRadioButton("В конец",false);
JComboBox combo = new JComboBox();
ButtonGroup groupRadioBeginEnd = new ButtonGroup();
ButtonGroup groupRadioDate = new ButtonGroup();
JFormattedTextField text= new JFormattedTextField();   // Текстовое поля для форматированного текста


    public ChangeNamePanel() {
        setLayout(new BorderLayout());

        //RadioPanel to North of main Layout
        /////


        /////
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
        JPanel datepanel = new JPanel();
        JRadioButton rDate1 = new JRadioButton("DD/MM/YYYY",true);
        JRadioButton rDate2 = new JRadioButton("YYYY/MM/DD",false);
        JRadioButton rDate3 = new JRadioButton("HH/MM",false);
        JRadioButton rDate4 = new JRadioButton("YYYY/MM/DD + HH/MM",false);
        groupRadioDate.add(rDate1);
        groupRadioDate.add(rDate2);
        groupRadioDate.add(rDate3);
        groupRadioDate.add(rDate4);
        datepanel.setLayout(new BoxLayout(datepanel, BoxLayout.Y_AXIS));
        datepanel.add(rDate1);
        datepanel.add(rDate2);
        datepanel.add(rDate3);
        datepanel.add(rDate4);
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
        text.setPreferredSize(new Dimension(150,25));
        text = new JFormattedTextField(dateMask);
        text.setHorizontalAlignment(JTextField.RIGHT);
    }



    }




