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
    public JFormattedTextField createDateTxt;//= new JFormattedTextField();
    public JFormattedTextField modifiedDateTxt;//= new JFormattedTextField();
    public JTextField ownerTxt= new JTextField();


    public AttributesPanel() {

//        createDateTxt.setPreferredSize(new Dimension(130,25));
       // modifiedDateTxt.setPreferredSize(new Dimension(130, 25));
        ownerTxt.setPreferredSize(new Dimension(150, 25));

        changeCreateDate.setLayout(new BoxLayout(changeCreateDate, BoxLayout.Y_AXIS));
        changeModifiesDate.setLayout(new BoxLayout(changeModifiesDate, BoxLayout.Y_AXIS));
        changeOwner.setLayout(new BoxLayout(changeOwner, BoxLayout.Y_AXIS));

        createDateTxt = tamplateMethodEntry();
        modifiedDateTxt = tamplateMethodEntry();

//        createDateTxt =  new JFormattedTextField();
//        modifiedDateTxt = new JFormattedTextField();

        changeCreateDate.add(new JLabel("Create Date"));
        changeCreateDate.add(createDateTxt);
        changeCreateDate.add(new Label("dd-MM-yyyy-HH-mm-ss"));
        changeModifiesDate.add(new JLabel("Modified Date"));
        changeModifiesDate.add(modifiedDateTxt);
        changeModifiesDate.add(new Label("dd-MM-yyyy-HH-mm-ss"));
        changeOwner.add(new JLabel("Owner"));
        changeOwner.add(ownerTxt);


        //MainPanel
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(changeCreateDate);
        add(changeModifiesDate);
        add(changeOwner);

    }

        ///////
    JFormattedTextField tamplateMethodEntry() {
        JFormattedTextField text;
            MaskFormatter dateMask = null;
                try {
                        dateMask = new MaskFormatter("##-##-####-##-##-##");
                        dateMask.setPlaceholderCharacter('_');
                        dateMask.setValidCharacters("0123456789");
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }


            text = new JFormattedTextField(dateMask);
            text.setPreferredSize(new Dimension(150,25));

//            text.setHorizontalAlignment(JTextField.LEFT);
//            comboTextBoxPanel.add(text);
//            text.getDocument().addDocumentListener(new ChengesToPreview());
//            comboTextBoxPanel.validate();

            return text;
        }
        /////////

    public static boolean checkCorrectFields (String s) {
        boolean flag = false;
        String[] array = s.split("-");
        if (array!=null) {
            try {
                System.out.println("String"+array.toString());
                if ((Integer.parseInt(array[0])) < 32 &&
                        (Integer.parseInt(array[1])) < 13 &&
                        (Integer.parseInt(array[2])) > 1900 &&
                        (Integer.parseInt(array[3])) < 24 &&
                        (Integer.parseInt(array[4])) < 60 &&
                        (Integer.parseInt(array[5])) < 60)
                    flag = true;
            } catch (NumberFormatException e) {
                flag = false;
            }


        }
        return flag;
    }



}
