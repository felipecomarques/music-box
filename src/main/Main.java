package main;

import banco.admBD;
import interfacegrafica.TelaLogin;

public class Main {

	public static void main(String[] args) {
		admBD adm = new admBD();
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
        
        adm.gerarTab("CREATE TABLE IF NOT EXISTS `guitarra` ("
        		+ "`id` int NOT NULL AUTO_INCREMENT, "
        		+ "`marca` varchar(40) NOT NULL, "
        		+ "`modelo` varchar(40) NOT NULL, "
        		+ "`madeiraCorpo` varchar(40) NOT NULL, "
        		+ "`madeiraBraco` varchar(40) NOT NULL, "
        		+ "`captacao` varchar(40) NOT NULL, "
        		+ "`tipocorpo` varchar(30) NOT NULL, "
        		+ "`estoque` int NOT NULL, "
        		+ "`preco` double NOT NULL, "
        		+ "`raio` double NOT NULL, "
        		+ "PRIMARY KEY (`id`)"
        		+ ")");
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


