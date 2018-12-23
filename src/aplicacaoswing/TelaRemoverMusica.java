package aplicacaoswing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Musica;

public class TelaRemoverMusica extends JFrame {

	private JFrame frame;
	private JTextField textField_musica;
	private JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverMusica window = new TelaRemoverMusica();
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
	public TelaRemoverMusica() {
		setTitle("Remover M\u00FAsica");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 206);
		getContentPane().setLayout(null);
		
		textField_musica = new JTextField();
		textField_musica.setBounds(126, 45, 171, 20);
		getContentPane().add(textField_musica);
		textField_musica.setColumns(10);
		
		JLabel lblNomeMusica = new JLabel("Nome da M\u00FAsica");
		lblNomeMusica.setBounds(10, 48, 106, 14);
		getContentPane().add(lblNomeMusica);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField_musica.getText().equalsIgnoreCase(""))
						throw new Exception("Não é possível remover, campo em branco");
					Musica m = Fachada.removerMusica(textField_musica.getText());
					status.setText("Musica " + m.getNome() + " removida com sucesso");
				}catch(Exception err) {
					status.setText(err.getMessage());
				}
			}
		});
		btnCadastrar.setBounds(165, 99, 106, 23);
		getContentPane().add(btnCadastrar);
		
		status = new JLabel("");
		status.setBounds(10, 153, 414, 14);
		getContentPane().add(status);
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
