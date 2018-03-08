package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ProducaoAutomovelDAO;
import producaoAutomovel.ProducaoAutomovel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaProducaoAutomovel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField modelo;
	private JTextField valor;
	private JTextField tipo;
	private JTextField transportadora;
	private JTextField qtde;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProducaoAutomovel frame = new TelaProducaoAutomovel();
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
	public TelaProducaoAutomovel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProuoDeAutomveis = new JLabel("Produ\u00E7\u00E3o de Autom\u00F3veis");
		lblProuoDeAutomveis.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 37));
		lblProuoDeAutomveis.setBounds(132, 11, 459, 79);
		contentPane.add(lblProuoDeAutomveis);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 103, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(142, 100, 240, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(10, 147, 46, 14);
		contentPane.add(lblModelo);
		
		modelo = new JTextField();
		modelo.setColumns(10);
		modelo.setBounds(142, 144, 240, 20);
		contentPane.add(modelo);
		
		JLabel lblValorr = new JLabel("Valor (R$):");
		lblValorr.setBounds(10, 207, 99, 14);
		contentPane.add(lblValorr);
		
		valor = new JTextField();
		valor.setColumns(10);
		valor.setBounds(142, 204, 240, 20);
		contentPane.add(valor);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 273, 46, 14);
		contentPane.add(lblTipo);
		
		tipo = new JTextField();
		tipo.setColumns(10);
		tipo.setBounds(142, 270, 240, 20);
		contentPane.add(tipo);
		
		JLabel lblTransportadora = new JLabel("Transportadora:");
		lblTransportadora.setBounds(10, 344, 99, 14);
		contentPane.add(lblTransportadora);
		
		transportadora = new JTextField();
		transportadora.setColumns(10);
		transportadora.setBounds(142, 341, 240, 20);
		contentPane.add(transportadora);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(401, 104, 46, 14);
		contentPane.add(lblMarca);
		
		JLabel lblQtde = new JLabel("Qtde");
		lblQtde.setBounds(401, 150, 46, 14);
		contentPane.add(lblQtde);
		
		qtde = new JTextField();
		qtde.setColumns(10);
		qtde.setBounds(533, 147, 240, 20);
		contentPane.add(qtde);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(401, 210, 46, 14);
		contentPane.add(lblData);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(533, 207, 240, 20);
		contentPane.add(textField_7);
		
		JLabel lblCmbio = new JLabel("C\u00E2mbio:");
		lblCmbio.setBounds(409, 276, 46, 14);
		contentPane.add(lblCmbio);
		
		JTextField cambio = new JTextField();
		cambio.setColumns(10);
		cambio.setBounds(541, 273, 240, 20);
		contentPane.add(cambio);
		
		JButton btnNewButton = new JButton("Gravar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(textField.getText());
				ProducaoAutomovel producao = new ProducaoAutomovel();
				producao.setNome(textField.getText());
				producao.setCambio(cambio.getText());
				producao.setMarca("Ferrari");
				producao.setModelo(modelo.getText());
				producao.setQuantidade(Integer.parseInt(qtde.getText()));
				producao.setTipo(tipo.getText());
				producao.setTransportadora(transportadora.getText());
				producao.setValor(Double.parseDouble(valor.getText()));
				ProducaoAutomovelDAO dao = new ProducaoAutomovelDAO();
				try {
					dao.insereProducao(producao);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(227, 397, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(401, 397, 89, 23);
		contentPane.add(btnCancelar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Citroen", "BMW", "Pegeout", "Fiat", "Volkswagen", "Ferrari", "Bulgatti", "GM", "Jeep", "Tesla", "Nissan", "Cherry", "Honda", "Toyota", "Lexus", "Lottus", "Suzuki"}));
		comboBox.setBounds(533, 100, 240, 20);
		contentPane.add(comboBox);
	}
}
