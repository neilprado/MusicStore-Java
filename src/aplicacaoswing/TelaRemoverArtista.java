package aplicacaoswing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Artista;
import java.awt.Color;
import java.awt.Font;

public class TelaRemoverArtista extends JFrame {

	private JFrame frame;
	private JTextField textField_artista;
	private JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverArtista window = new TelaRemoverArtista();
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
	public TelaRemoverArtista() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Remover Artista");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 206);
		getContentPane().setLayout(null);
		
		textField_artista = new JTextField();
		textField_artista.setBounds(126, 45, 171, 20);
		getContentPane().add(textField_artista);
		textField_artista.setColumns(10);
		
		JLabel lblNomeArtista = new JLabel("Nome do Artista");
		lblNomeArtista.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeArtista.setBounds(10, 48, 106, 14);
		getContentPane().add(lblNomeArtista);
		
		JButton btnCadastrar = new JButton("Remover");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.inicializar();
				try {
					if(textField_artista.getText().equalsIgnoreCase(""))
						throw new Exception("Não é possível remover, campo em branco");
					Artista a = Fachada.removerArtista(textField_artista.getText());
					status.setText("Artista " + a.getNome() + " removido com sucesso");
					textField_artista.setText("");
					textField_artista.requestFocus();
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
