package JavaFileManager.Gui;

import JavaFileManager.Listeners.ChengesToPreview;
import JavaFileManager.Listeners.EnterBtnListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class AttributesPanel extends JPanel {

    private JPanel changeCreateDate = new JPanel();
    private JPanel changeModifiesDate = new JPanel();
    private JPanel changeOwner = new JPanel();
    public JFormattedTextField createDateTxt= new JFormattedTextField();
    public JFormattedTextField modifiedDateTxt= new JFormattedTextField();
    public JTextField ownerTxt= new JTextField();


    public AttributesPanel() {

        createDateTxt.setPreferredSize(new Dimension(130,25));
        modifiedDateTxt.setPreferredSize(new Dimension(130,25));
        ownerTxt.setPreferredSize(new Dimension(130,25));

        changeCreateDate.setLayout(new BoxLayout(changeCreateDate,BoxLayout.Y_AXIS));
        changeModifiesDate.setLayout(new BoxLayout(changeModifiesDate,BoxLayout.Y_AXIS));
        changeOwner.setLayout(new BoxLayout(changeOwner,BoxLayout.Y_AXIS));

        changeCreateDate.add(new JLabel("Create Date"));
        changeCreateDate.add(createDateTxt);
        changeModifiesDate.add(new JLabel("Modified Date"));
        changeModifiesDate.add(modifiedDateTxt);
        changeOwner.add(new JLabel("Owner"));
        changeOwner.add(ownerTxt);


        //MainPanel
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(changeCreateDate);
        add(changeModifiesDate);
        add(changeOwner);

    }



    // Панель с радиокнопками

    JRadioButton rDate1 = new JRadioButton("DD/MM/YYYY",true);
    JRadioButton rDate2 = new JRadioButton("YYYY/MM/DD",false);
    JRadioButton rDate3 = new JRadioButton("HH/MM",false);
    JRadioButton rDate4 = new JRadioButton("YYYY/MM/DD + HH/MM",false);



    // Метод отображения TextField
    void tamplateMethodEntry(String dateTamplate) {
        MaskFormatter dateMask = null;

        switch (dateTamplate) {
            case "null": {
                break;
            }
            case "dd/mm/yyyy": {
                try {
                    dateMask = new MaskFormatter("##-##-####");
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
                    dateMask = new MaskFormatter("####-##-##");
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
                    dateMask = new MaskFormatter("##-##");
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
                    dateMask = new MaskFormatter("####-##-##--##:##");
                    dateMask.setPlaceholderCharacter('_');
                    dateMask.setValidCharacters("0123456789");
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            }
        }


    }


}
