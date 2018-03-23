package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import producaoAutomovel.ProducaoAutomovel;

public class ProducaoAutomovelDAO {
	ConnectionFactory connectionFactory = new ConnectionFactory();
	Connection con = connectionFactory.getConnection();

	public int insereProducao(ProducaoAutomovel producao) throws SQLException {

		// cria um preparedStatement
		String sql = "insert into producaoautomovel"
				+ " (nome, transportadora , marca , modelo , quantidade, valor, data, tipo, cambio)"
				+ " values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);

		// preenche os valores
		stmt.setString(1, producao.getNome());
		stmt.setString(2, producao.getTransportadora());
		stmt.setString(3, producao.getMarca());
		stmt.setString(4, producao.getModelo());
		stmt.setInt(5, producao.getQuantidade());
		stmt.setDouble(6, producao.getValor());
		stmt.setDate(7, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		stmt.setString(8, producao.getTipo());
		stmt.setString(9, producao.getCambio());
		// executa
		int qtdeRegistros = stmt.executeUpdate();
		stmt.close();

		connectionFactory.closeConnection();

		System.out.println("Gravado!");

		return qtdeRegistros;
	}

	public List<ProducaoAutomovel> consultaProducao(String nome) throws SQLException {
		List<ProducaoAutomovel> automoveis = new ArrayList<ProducaoAutomovel>();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT * FROM producaoautomovel " + "WHERE nome like '%" + nome + "%'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ProducaoAutomovel p = new ProducaoAutomovel();
				p.setNome(rs.getString("nome"));
				p.setModelo(rs.getString("modelo"));
				p.setMarca(rs.getString("marca"));
				automoveis.add(p);
			}
		} finally {
			connectionFactory.closeConnection();
		}
		return automoveis;
	}

	public static void main(String[] args) {
		try {

			ProducaoAutomovelDAO producaoAutomovelDAO = new ProducaoAutomovelDAO();
			List<ProducaoAutomovel> lista = producaoAutomovelDAO
					.consultaProducao(JOptionPane.showInputDialog(null, 
							"Escolha o nome da produção:"));
			lista.forEach(item -> JOptionPane.showMessageDialog(null, item.getModelo()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
