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
public class TelaAtualizarMusica extends JFrame {

	private JFrame frame;
	private JTextField textField_musica;
	private JLabel status;
	private JLabel lblNovoNomeDaMusica;
	private JTextField textField_novo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarMusica window = new TelaAtualizarMusica();
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
	public TelaAtualizarMusica() {
		setTitle("Atualizar M\u00FAsica");
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
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.inicializar();
				try {
					if(textField_musica.getText().equalsIgnoreCase("") || textField_novo.getText().equalsIgnoreCase(""))
						throw new Exception("Existe um ou mais campos em branco, tente novamente");
					String nome = textField_musica.getText();
					String novo = textField_novo.getText();
					Fachada.atualizarMusica(nome, novo);
					status.setText("Gênero " + nome + " alterado com sucesso");
					textField_musica.setText("");
					textField_novo.setText("");
					textField_musica.requestFocus();
				}catch (Exception err) {
					status.setText(err.getMessage());
				}
			}
		});
		btnAtualizar.setBounds(165, 119, 106, 23);
		getContentPane().add(btnAtualizar);
		
		status = new JLabel("");
		status.setBounds(10, 153, 414, 14);
		getContentPane().add(status);
		
		lblNovoNomeDaMusica = new JLabel("Novo nome da M\u00FAsica");
		lblNovoNomeDaMusica.setBounds(10, 79, 106, 14);
		getContentPane().add(lblNovoNomeDaMusica);
		
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
