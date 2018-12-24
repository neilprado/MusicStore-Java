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
import modelo.Artista;

public class TelaCadastrarAlbum extends JFrame {

	private JFrame frame;
	private JTextField textField_album;
	private JTextField textField_preco;
	private JLabel lblNewLabel_artista;
	private JTextField textField_artista;
	private JLabel lblAno;
	private JTextField textField_ano;
	private JLabel lblNmeroDeFaixas;
	private JTextField textField_faixas;
	private JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarAlbum window = new TelaCadastrarAlbum();
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
	public TelaCadastrarAlbum() {
		setTitle("Cadastro de \u00C1lbum");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField_album = new JTextField();
		textField_album.setBounds(126, 45, 171, 20);
		getContentPane().add(textField_album);
		textField_album.setColumns(10);
		
		JLabel lblNomeDoAlbum = new JLabel("Nome do Album");
		lblNomeDoAlbum.setBounds(10, 48, 106, 14);
		getContentPane().add(lblNomeDoAlbum);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setBounds(10, 79, 85, 14);
		getContentPane().add(lblPreco);
		
		textField_preco = new JTextField();
		textField_preco.setBounds(126, 76, 49, 20);
		getContentPane().add(textField_preco);
		textField_preco.setColumns(10);
		
		lblNewLabel_artista = new JLabel("Nome do Artista");
		lblNewLabel_artista.setBounds(10, 110, 131, 14);
		getContentPane().add(lblNewLabel_artista);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.inicializar();
				try {
					if(textField_album.getText().equalsIgnoreCase("") || textField_artista.getText().equalsIgnoreCase("") || textField_ano.getText().equalsIgnoreCase("") || textField_faixas.getText().equalsIgnoreCase("") || textField_preco.getText().equalsIgnoreCase(""))
						throw new Exception("Campos em branco, por favor tente novamente");
					String nome = textField_album.getText();
					Artista artista = Fachada.buscarArtista(textField_artista.getText());
					int ano = Integer.parseInt(textField_ano.getText());
					int faixas = Integer.parseInt(textField_faixas.getText());
					double preco = Double.parseDouble(textField_preco.getText());
					Album al = Fachada.cadastrarAlbum(nome, preco, ano, faixas, artista);
					status.setText("Album " + al.getNome() + " cadastrado com sucesso");
					textField_album.setText("");
					textField_ano.setText("");
					textField_artista.setText("");
					textField_faixas.setText("");
					textField_preco.setText("");
					textField_album.requestFocus();
				}catch(Exception err) {
					
				}
			}
		});
		btnCadastrar.setBounds(167, 168, 106, 23);
		getContentPane().add(btnCadastrar);
		
		status = new JLabel("");
		status.setBounds(10, 237, 414, 14);
		getContentPane().add(status);
		
		textField_artista = new JTextField();
		textField_artista.setColumns(10);
		textField_artista.setBounds(126, 107, 171, 20);
		getContentPane().add(textField_artista);
		
		lblAno = new JLabel("Ano");
		lblAno.setBounds(205, 79, 49, 14);
		getContentPane().add(lblAno);
		
		textField_ano = new JTextField();
		textField_ano.setColumns(10);
		textField_ano.setBounds(248, 76, 49, 20);
		getContentPane().add(textField_ano);
		
		lblNmeroDeFaixas = new JLabel("N\u00FAmero de Faixas");
		lblNmeroDeFaixas.setBounds(10, 142, 131, 14);
		getContentPane().add(lblNmeroDeFaixas);
		
		textField_faixas = new JTextField();
		textField_faixas.setColumns(10);
		textField_faixas.setBounds(191, 137, 49, 20);
		getContentPane().add(textField_faixas);
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
