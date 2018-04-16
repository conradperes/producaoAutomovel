package telas;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import dao.ProducaoAutomovelDAO;
import producaoAutomovel.ProducaoAutomovel;

public class TableExample extends JFrame {
	public TableExample() {
		// headers for the table
		String[] columns = new String[] { "Nome", "Marca", "Modelo", "Valor" };
		List<ProducaoAutomovel> lista = null;
		ProducaoAutomovelDAO dao = new ProducaoAutomovelDAO();
		try {
			lista = dao.consultaProducao("o");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] data = new Object[lista.size()][columns.length];
		// actual data for the table in a 2d array
		DefaultTableModel model = new DefaultTableModel(data, columns) {
			/**
			* 
			*/
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for (ProducaoAutomovel p : lista) {
			DecimalFormat tm = new DecimalFormat();
			int i = 0;
			model.insertRow(i, new Object[] { p.getNome(), 
					p.getMarca(), p.getModelo(), 
					tm.format(p.getValor()) });
			i++;
		}

		// create table with data
		JTable table = new JTable(model);

		// add the table to the frame
		this.add(new JScrollPane(table));

		this.setTitle("Table Example");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TableExample();
			}
		});
	}
}
