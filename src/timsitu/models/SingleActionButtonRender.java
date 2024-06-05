package timsitu.models;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import timsitu.components.SingleButtonComponent;

public class SingleActionButtonRender extends DefaultTableCellRenderer {
    
    String teks;

    public SingleActionButtonRender(String teks) {
        this.teks = teks;
    }

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
        Component com = super.getTableCellRendererComponent(jtable, o, isSeleted, bln1, row, column);
        SingleButtonComponent action = new SingleButtonComponent(teks);
        if (isSeleted == false && row % 2 == 0) {
            action.setBackground(Color.WHITE);
        } else {
            action.setBackground(com.getBackground());
        }
        return action;
    }
}
