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
public class TelaAtualizarArtista extends JFrame {

	private JFrame frame;
	private JTextField textField_artista;
	private JLabel status;
	private JLabel lblNovoNomeDo;
	private JTextField textField_novo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarArtista window = new TelaAtualizarArtista();
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
	public TelaAtualizarArtista() {
		setTitle("Atualizar Artista");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 206);
		getContentPane().setLayout(null);
		
		textField_artista = new JTextField();
		textField_artista.setBounds(126, 45, 171, 20);
		getContentPane().add(textField_artista);
		textField_artista.setColumns(10);
		
		JLabel lblNomeAlbum = new JLabel("Nome do Artista");
		lblNomeAlbum.setBounds(10, 48, 106, 14);
		getContentPane().add(lblNomeAlbum);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.inicializar();
				try {
					if(textField_artista.getText().equalsIgnoreCase("") || textField_novo.getText().equalsIgnoreCase(""))
						throw new Exception("Existe um ou mais campos em branco");
					String nome = textField_artista.getText();
					String novo = textField_novo.getText();
					Fachada.atualizarArtista(nome, novo);
					status.setText("Artista "+ nome + " atualizado com sucesso");
					textField_artista.setText("");
					textField_novo.setText("");
					textField_artista.requestFocus();
				}catch(Exception err) {
					status.setText(err.getMessage());
				}
			}
		});
		btnAtualizar.setBounds(165, 119, 106, 23);
		getContentPane().add(btnAtualizar);
		
		status = new JLabel("");
		status.setBounds(10, 153, 414, 14);
		getContentPane().add(status);
		
		lblNovoNomeDo = new JLabel("Novo nome do Artista");
		lblNovoNomeDo.setBounds(10, 79, 106, 14);
		getContentPane().add(lblNovoNomeDo);
		
		textField_novo = new JTextField();
		textField_novo.setColumns(10);
		textField_novo.setBounds(126, 76, 171, 20);
		getContentPane().add(textField_novo);
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
