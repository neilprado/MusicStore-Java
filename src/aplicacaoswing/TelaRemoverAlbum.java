package aplicacaoswing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Album;
import java.awt.Color;
import java.awt.Font;
public class TelaRemoverAlbum extends JFrame {

	private JFrame frame;
	private JTextField textField_album;
	private JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverAlbum window = new TelaRemoverAlbum();
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
	public TelaRemoverAlbum() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Remover M\u00FAsica");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 206);
		getContentPane().setLayout(null);
		
		textField_album = new JTextField();
		textField_album.setBounds(126, 45, 171, 20);
		getContentPane().add(textField_album);
		textField_album.setColumns(10);
		
		JLabel lblNomeAlbum = new JLabel("Nome do \u00C1lbum");
		lblNomeAlbum.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeAlbum.setBounds(10, 48, 106, 14);
		getContentPane().add(lblNomeAlbum);
		
		JButton btnCadastrar = new JButton("Remover");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.inicializar();
				try {
					if(textField_album.getText().equalsIgnoreCase(""))
						throw new Exception("Não é possível remover, campo em branco");
					Album al = Fachada.removerAlbum(textField_album.getText());
					status.setText("Album " + al.getNome() + " removido com sucesso");
					textField_album.setText("");
					textField_album.requestFocus();
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
