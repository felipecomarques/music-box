package interfacegrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println(ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setTitle("MusicBox");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel BemVindoLabel = new JLabel("Sistema MusicBox");
		BemVindoLabel.setBounds(70, 11, 205, 36);
		BemVindoLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(BemVindoLabel);
		
		JButton ConfiguracoesButton = new JButton("Configurações");
		ConfiguracoesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ConfiguracoesButton.setBounds(139, 227, 101, 23);
		contentPane.add(ConfiguracoesButton);
		
		JButton SairButton = new JButton("Sair");
		SairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin TL = new TelaLogin();
				TL.setVisible(true);
				dispose();
			}
		});
		SairButton.setBounds(245, 227, 89, 23);
		contentPane.add(SairButton);
		
		JButton FuncionariosButton = new JButton("Funcionários");
		FuncionariosButton.setEnabled(false);
		FuncionariosButton.setBounds(25, 139, 89, 23);
		contentPane.add(FuncionariosButton);
		
		JButton VenderButton = new JButton("Vender");
		VenderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		VenderButton.setBounds(25, 105, 89, 23);
		contentPane.add(VenderButton);
		
		JButton EstoqueButton = new JButton("Estoque");
		EstoqueButton.setBounds(124, 105, 89, 23);
		contentPane.add(EstoqueButton);
		
		this.setLocationRelativeTo(null);
	}
}
