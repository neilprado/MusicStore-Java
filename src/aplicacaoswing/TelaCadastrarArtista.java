package aplicacaoswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaCadastrarArtista extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarArtista window = new TelaCadastrarArtista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastrarArtista() {
		setTitle("Cadastro de Artista");
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(126, 45, 171, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeDoArtista = new JLabel("Nome do Artista");
		lblNomeDoArtista.setBounds(10, 48, 106, 14);
		getContentPane().add(lblNomeDoArtista);
		
		JLabel lblNewLabel = new JLabel("Nacionalidade");
		lblNewLabel.setBounds(10, 79, 85, 14);
		getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 76, 171, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("N\u00FAmero de Integrantes");
		lblNewLabel_1.setBounds(10, 110, 131, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(126, 107, 43, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(167, 168, 89, 23);
		getContentPane().add(btnCadastrar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 237, 414, 14);
		getContentPane().add(lblNewLabel_2);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
