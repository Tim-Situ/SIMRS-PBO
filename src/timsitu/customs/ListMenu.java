package timsitu.customs;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import timsitu.events.EventMenuSelected;
import timsitu.models.Menu;

public class ListMenu<E extends Object> extends JList<E>{
    private DefaultListModel model = null;
    private int selectedIndex = 0;
    
    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
    }
    
    public ListMenu() {
        model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object o = model.getElementAt(index);
                    if (o instanceof Menu) {
                        Menu menu = (Menu) o;
                        if (menu.getType() == Menu.EnumMenuType.MENU) {
                            selectedIndex = index;
                            
                            if (event != null) {
                                event.selected(index);
                            }
                        }
                    } else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }
        });
    }
    
    
    
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean focus) {
                Menu data;
                
                if(value instanceof Menu){
                    data = (Menu) value;
                }else {
                    data = new Menu("", value + "", Menu.EnumMenuType.EMPTY);
                }
                
                ItemMenu item = new ItemMenu(data);
                item.setSelected(selectedIndex == index);
                return item;
            }
            
        };
    }
    
    public void addItem(Menu data) {
        model.addElement(data);
    }
}
