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
import java.awt.Color;

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
		setBounds(100, 100, 246, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ConfiguracoesButton = new JButton("Configurações");
		ConfiguracoesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ConfiguracoesButton.setBounds(20, 111, 101, 23);
		contentPane.add(ConfiguracoesButton);
		
		JButton SairButton = new JButton("Sair");
		SairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin TL = new TelaLogin();
				TL.setVisible(true);
				dispose();
			}
		});
		SairButton.setBounds(127, 111, 89, 23);
		contentPane.add(SairButton);
		
		JButton FuncionariosButton = new JButton("Funcionários");
		FuncionariosButton.setEnabled(false);
		FuncionariosButton.setBounds(123, 77, 93, 23);
		contentPane.add(FuncionariosButton);
		
		JButton EstoqueButton = new JButton("Estoque");
		EstoqueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal TP = new TelaPrincipal();
				TP.setVisible(true);
				dispose();
			}
		});
		EstoqueButton.setBounds(20, 77, 101, 23);
		contentPane.add(EstoqueButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 230, 37);
		contentPane.add(panel);
		
		JLabel BemVindoLabel = new JLabel("Sistema MusicBox");
		panel.add(BemVindoLabel);
		BemVindoLabel.setForeground(new Color(255, 255, 255));
		BemVindoLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBounds(-1, 37, 231, 29);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Seja bem-vindo(a)!");
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		
		this.setLocationRelativeTo(null);
	}
}
