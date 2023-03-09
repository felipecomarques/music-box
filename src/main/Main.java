package main;

import banco.AdmBD;
import interfacegrafica.Estoque;
import interfacegrafica.Menu;

public class Main {

    public static void main(String[] args) {
        AdmBD adm = new AdmBD();
        adm.gerarBanco();
        adm.gerarTab("CREATE TABLE IF NOT EXISTS `baixo` (\n"
                + "`id` int NOT NULL AUTO_INCREMENT,\n"
                + "`marca` varchar(40) NOT NULL,\n"
                + "`modelo` varchar(40) NOT NULL,\n"
                + "`uso` varchar(10) NOT NULL,\n"
                + "`madeiraCorpo` varchar(40) NOT NULL,\n"
                + "`madeiraBraco` varchar(40) NOT NULL,\n"
                + "`captacao` varchar(8) NOT NULL,\n"
                + "`numcordas` int NOT NULL,\n"
                + "`passivoativo` varchar(10) NOT NULL,\n"
                + "`estoque` int NOT NULL,\n"
                + "`preco` double NOT NULL,\n"
                + "PRIMARY KEY (`id`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;");

        adm.gerarTab("CREATE TABLE IF NOT EXISTS `guitarra` (\n"
                + "`id` int NOT NULL AUTO_INCREMENT,\n"
                + "`marca` varchar(40) NOT NULL,\n"
                + "`modelo` varchar(40) NOT NULL,\n"
                + "`uso` varchar(40) NOT NULL,\n"
                + "`madeiraCorpo` varchar(40) NOT NULL,\n"
                + "`madeiraBraco` varchar(40) NOT NULL,\n"
                + "`captacao` varchar(40) NOT NULL,\n"
                + "`tipocorpo` varchar(30) NOT NULL,\n"
                + "`estoque` int NOT NULL,\n"
                + "`preco` double NOT NULL,\n"
                + "`raio` double NOT NULL,\n"
                + "PRIMARY KEY (`id`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;");
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        new Estoque().setVisible(true);

    }

}
