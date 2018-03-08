package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import connection.ConnectionFactory;
import producaoAutomovel.ProducaoAutomovel;

public class ProducaoAutomovelDAO {
	
	public int insereProducao(ProducaoAutomovel producao) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.getConnection();

        // cria um preparedStatement
        String sql = "insert into producaoautomovel" +
                " (nome, transportadora , marca , modelo , quantidade, valor, data, tipo, cambio)" +
                " values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, producao.getNome());
        stmt.setString(2, producao.getTransportadora());
        stmt.setString(3, producao.getMarca());
        stmt.setString(4, producao.getModelo());
        stmt.setInt(5, producao.getQuantidade());
        stmt.setDouble(6, producao.getValor());
        stmt.setDate(7, new java.sql.Date(
                Calendar.getInstance().getTimeInMillis()));
        stmt.setString(8, producao.getTipo());
        stmt.setString(9, producao.getCambio());
        // executa
        int qtdeRegistros = stmt.executeUpdate();
        stmt.close();
        
        connectionFactory.closeConnection();

        System.out.println("Gravado!");
        
		return qtdeRegistros;
	}

}
