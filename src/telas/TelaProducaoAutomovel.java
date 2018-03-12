package telas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.ProducaoAutomovelDAO;
import producaoAutomovel.ProducaoAutomovel;

public class TelaProducaoAutomovel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5518384075295198102L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField valor;
	private JTextField tipo;
	private JTextField data;
	

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
		
		nome = new JTextField();
		nome.setBounds(142, 100, 240, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(10, 147, 46, 14);
		contentPane.add(lblModelo);
		
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
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(401, 104, 46, 14);
		contentPane.add(lblMarca);
		
		JLabel lblQtde = new JLabel("Qtde");
		lblQtde.setBounds(401, 150, 46, 14);
		contentPane.add(lblQtde);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(401, 210, 46, 14);
		contentPane.add(lblData);
		
		data = new JTextField();
		data.setColumns(10);
		data.setBounds(533, 207, 240, 20);
		contentPane.add(data);
		
		JLabel lblCmbio = new JLabel("C\u00E2mbio:");
		lblCmbio.setBounds(409, 276, 46, 14);
		contentPane.add(lblCmbio);
		

		JComboBox marca = new JComboBox();
		marca.setModel(new DefaultComboBoxModel(new String[] {"", "Citroen", "BMW", "Pegeout", "Fiat", "Volkswagen", "Ferrari", "Bulgatti", "GM", "Jeep", "Tesla", "Nissan", "Cherry", "Honda", "Toyota", "Lexus", "Lottus", "Suzuki"}));
		marca.setBounds(533, 100, 240, 20);
		contentPane.add(marca);
		
		JSpinner qtde = new JSpinner();
		qtde.setBounds(533, 144, 240, 20);
		contentPane.add(qtde);
		
		JComboBox modelo = new JComboBox();
		modelo.setModel(new DefaultComboBoxModel(new String[] {"", "Citroen C4 Lounge", "Ferrari 74", "Bulgatti Biturbo", "Audio A12", "LandRover", "Fusca", "Lamborguino", "Porsche", "Corvete", "Mercedez Classe A", "Conenzage", "Fiat Uno", "Fusca Betle", "Haboo", "Jeep"}));
		modelo.setBounds(142, 144, 240, 20);
		contentPane.add(modelo);
		
		JComboBox cambio = new JComboBox();
		cambio.setModel(new DefaultComboBoxModel(new String[] {"", "Mec\u00E2nico", "Autom\u00E1tico"}));
		cambio.setBounds(533, 273, 240, 20);
		contentPane.add(cambio);
		
		JComboBox transportadora = new JComboBox();
		transportadora.setModel(new DefaultComboBoxModel(new String[] {"", "Correio", "Sedex", "Fedex", "Aduaneiras", "Navio", "Amazon", "Avi\u00E3o", "Submarino"}));
		transportadora.setBounds(142, 341, 240, 20);	
		contentPane.add(transportadora);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(66, 76, 707, 14);
		contentPane.add(separator);
		
		JButton botao = new JButton("Gravar");
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nome.getText()==null || nome.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "Sua besta! Digite a porra do nome corretamente!");
				}
				if(marca.getSelectedItem()==null || marca.getSelectedItem().toString().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "Por favor selecione a Marca");
				}
				else {
					System.out.println(nome.getText());
					ProducaoAutomovel producao = new ProducaoAutomovel();
					producao.setNome(nome.getText());
					producao.setCambio(cambio.getSelectedItem().toString());
					producao.setMarca(marca.getSelectedItem().toString());
					producao.setModelo(modelo.getSelectedItem().toString());
					producao.setQuantidade(Integer.parseInt(qtde.getValue().toString()));
					producao.setTipo(tipo.getText());
					producao.setTransportadora(transportadora.getSelectedItem().toString()	);
					producao.setValor(Double.parseDouble(valor.getText()));
					ProducaoAutomovelDAO dao = new ProducaoAutomovelDAO();
					try {
						dao.insereProducao(producao);
					} catch (SQLException e) {	
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				
			}
		});
		botao.setBounds(227, 397, 89, 23);
		contentPane.add(botao);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(401, 397, 89, 23);
		contentPane.add(btnCancelar);
		
	}
}
