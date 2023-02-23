package interfacegrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField LoginField;
	private JPasswordField passwordField;

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
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setTitle("Login");		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 260, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LoginLabel = new JLabel("Login:");
		LoginLabel.setBounds(10, 53, 46, 14);
		contentPane.add(LoginLabel);
		
		LoginField = new JTextField();
		LoginField.setBounds(10, 78, 220, 29);
		contentPane.add(LoginField);
		LoginField.setColumns(10);
		
		JLabel SenhaLabel = new JLabel("Senha:");
		SenhaLabel.setBounds(10, 118, 46, 14);
		contentPane.add(SenhaLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 143, 220, 29);
		contentPane.add(passwordField);
		
		JButton EntrarButton = new JButton("Entrar");
		EntrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkLogin(LoginField.getText(), new String (passwordField.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Bem-vindo ao sistema!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
					MenuPrincipal MP = new MenuPrincipal();
					MP.setVisible(true);
					dispose();
				}
					else
					JOptionPane.showMessageDialog(null, "Dados incorretos!", "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		});
		EntrarButton.setBounds(79, 183, 89, 23);
		contentPane.add(EntrarButton);
		
		JLabel BemVindoLabel = new JLabel("SEJA BEM VINDO(A)!");
		BemVindoLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		BemVindoLabel.setBounds(27, 11, 195, 29);
		contentPane.add(BemVindoLabel);
		
		JLabel CadastroInfoLabel = new JLabel("Não possui cadastro?");
		CadastroInfoLabel.setEnabled(false);
		CadastroInfoLabel.setBounds(18, 226, 102, 14);
		contentPane.add(CadastroInfoLabel);
		
		JButton CadastrarButton = new JButton("Cadastrar-se");
		CadastrarButton.setEnabled(false);
		CadastrarButton.setBounds(130, 222, 100, 23);
		contentPane.add(CadastrarButton);
		
		this.setLocationRelativeTo(null);
	}
	
	public boolean checkLogin(String login, String senha){
		return login.equals("admin")&& senha.equals("123");
	}
	
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSED);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
}
