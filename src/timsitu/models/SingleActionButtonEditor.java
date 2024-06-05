package timsitu.models;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import timsitu.components.SingleButtonComponent;
import timsitu.events.TableActionEvent;

public class SingleActionButtonEditor extends DefaultCellEditor {

    private TableActionEvent event;
    private String teks;

    public SingleActionButtonEditor(TableActionEvent event, String teks) {
        super(new JCheckBox());
        this.event = event;
        this.teks = teks;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        SingleButtonComponent action = new SingleButtonComponent(teks);
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
