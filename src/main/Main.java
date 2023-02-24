package main;

import banco.AdmBD;
import interfacegrafica.TelaLogin;

public class Main {

    public static void main(String[] args) {
        AdmBD adm = new AdmBD();
        adm.gerarBanco();
        adm.gerarTab("CREATE TABLE IF NOT EXISTS `baixo` (\r\n"
                + "`id` int NOT NULL AUTO_INCREMENT,\r\n"
                + "`marca` varchar(40) NOT NULL,\r\n"
                + "`modelo` varchar(40) NOT NULL,\r\n"
                + "`madeiraCorpo` varchar(40) NOT NULL,\r\n"
                + "`madeiraBraco` varchar(40) NOT NULL,\r\n"
                + "`captacao` varchar(40) NOT NULL,\r\n"
                + "`numcordas` int NOT NULL,\r\n"
                + "`passivoativo` char NOT NULL,\r\n"
                + "`estoque` int NOT NULL,\r\n"
                + "`preco` double NOT NULL,\r\n"
                + "PRIMARY KEY (`id`)\r\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;");

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
                + "PRIMARY KEY (`id`)\n" +
        ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;");
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        new TelaLogin().setVisible(true);

    }

}
