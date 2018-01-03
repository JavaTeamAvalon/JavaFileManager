package JavaFileManager.Listeners;

import JavaFileManager.LogicMethodsClass;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class ColorListRender extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        label.setOpaque(isSelected); // Highlight only when selected
        label.setOpaque(true); // Highlight always

        //if(lm.getLabels()!=null) { // I faked a match for the second index, put you matching condition here.

            label.setForeground(Color.BLUE);
        return label;
    }



}
