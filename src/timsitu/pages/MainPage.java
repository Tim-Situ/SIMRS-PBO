package timsitu.pages;

import javax.swing.JComponent;
import timsitu.events.EventMenuSelected;
import timsitu.main.Routing;
import timsitu.models.UserSessions;
import timsitu.pages.apoteker.ApotekerPage;
import timsitu.pages.dokter.DokterPage;
import timsitu.pages.obat.ObatPage;
import timsitu.pages.pasien.PasienPage;
import timsitu.pages.reservasi.ReservasiByAdminPage;
import timsitu.pages.transaksi.FormTransaksiPage;


public class MainPage extends javax.swing.JFrame {

    private Routing menuRouter;
    
//    private DashboardPage dashboard;
//    private ObatPage obatPage;
//    private PasienPage pasienPage;
//    private DokterPage dokterPage;
//    private ApotekerPage apotekerPage;
//    private PendaftaranAdminPage pendaftaranAdmin;
//    private FormTransaksiPage formTransaksiPage;
   
    
    
    public MainPage() {
        initComponents();
        
        menuRouter = new Routing(this);
        
        MainPage mainPage = this;
        
//        dashboard = new DashboardPage();
//        obatPage = new ObatPage();
//        pasienPage = new PasienPage();
//        dokterPage = new DokterPage();
//        pendaftaranAdmin = new PendaftaranAdminPage();
//        formTransaksiPage = new FormTransaksiPage();
//        apotekerPage = new ApotekerPage();
        
        menuC.addEventMenuSelected(new EventMenuSelected() {
            
//            @Override
//            public void selected(int index) {
//                if(index == 1){
//                    setForm(pendaftaranAdmin);
//                }else if(index == 2){
//                    setForm(formTransaksiPage);
//                }else if (index == 0) {
//                    setForm(dashboard);
//                }else if(index == 6){
//                    setForm(pasienPage);
//                }else if(index == 7){
//                    setForm(dokterPage);
//                }else if(index == 8){
//                    setForm(apotekerPage);
//                }else if(index == 9){
//                    setForm(obatPage);
//                }else if(index == 13 && UserSessions.getRole().equals("Admin")){
//                    LoginPage loginPage = new LoginPage();
//                    loginPage.setVisible(true);
//                    mainPage.dispose();
//                }else if(index == 5 && UserSessions.getRole().equals("Dokter")){
//                    LoginPage loginPage = new LoginPage();
//                    loginPage.setVisible(true);
//                    mainPage.dispose();
//                }
//            }
            
            @Override
            public void selected(int index) {
                menuRouter.handleSelection(index);
            }
        });
        
        setForm(new DashboardPage());
    }
    
    public static void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new timsitu.customs.PanelBorder();
        menuC = new timsitu.components.MenuComponent();
        headerComponent1 = new timsitu.components.HeaderComponent();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuC.setMinimumSize(new java.awt.Dimension(0, 0));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        mainPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menuC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerComponent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(headerComponent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addComponent(menuC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private timsitu.components.HeaderComponent headerComponent1;
    public static javax.swing.JPanel mainPanel;
    private timsitu.components.MenuComponent menuC;
    private timsitu.customs.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
