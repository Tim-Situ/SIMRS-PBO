package timsitu.models;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.logging.Logger;

public class Menu {
    
    public static enum EnumMenuType{
        TITLE, MENU, EMPTY
    }
    
    String icon;
    String name;
    EnumMenuType type;
    
    public Menu(){}
    
    public Menu(String icon, String name, EnumMenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }
    
//    public Icon toIcon() {
//        URL url = null;
//        String urlImage = "timsitu/icons/ic_Pasien.png";
//        
//        try {
//            url = new URL(urlImage);
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        ImageIcon welcomeImage = new ImageIcon(url);
//        Image image = welcomeImage.getImage();
//        Image newImage = image.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
//        
////        return new ImageIcon(getClass().getResource("file:/Users/fauzeinmulyawarman/Drive%20Local/test-code/TesDashboard/src/main/java/com/famuwa/icon/logo.png"));
//        return new javax.swing.ImageIcon(newImage);
//        
////        ImageIcon welcomeImage = new ImageIcon(getClass().getResource("/timsitu/icons/ic_" + name + ".png"));
////        Image image = welcomeImage.getImage();
////        Image newImage = image.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
////        return new javax.swing.ImageIcon(newImage);
//    }
    
//    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timsitu/images/logo.png")));
    
    public Icon toIcon() {
        ImageIcon welcomeImage = new ImageIcon(getClass().getResource("/timsitu/icons/ic_" + name + ".png"));
        Image image = welcomeImage.getImage();
        Image newImage = image.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
//        return new ImageIcon(getClass().getResource("/timsitu/icons/ic_Pasien.png"));
        return new ImageIcon(newImage);
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumMenuType getType() {
        return type;
    }

    public void setType(EnumMenuType type) {
        this.type = type;
    }
    
}
