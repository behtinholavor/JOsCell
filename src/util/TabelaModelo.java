package util;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class TabelaModelo extends AbstractTableModel {		
	private ArrayList<?> linhas = null;
	private String[] colunas = null;
	public DefaultTableCellRenderer CellLeft;
	public DefaultTableCellRenderer CellCenter;
	public DefaultTableCellRenderer CellRight;
	public DefaultTableCellRenderer ColLeft;
	public DefaultTableCellRenderer ColCenter;
	public DefaultTableCellRenderer ColRight;
	
	public TabelaModelo() {	
		CellLeft = new DefaultTableCellRenderer();
		CellLeft.setHorizontalAlignment(SwingConstants.LEFT);
		
		CellCenter = new DefaultTableCellRenderer();
		CellCenter.setHorizontalAlignment(SwingConstants.CENTER);
		
		CellRight = new DefaultTableCellRenderer();
		CellRight.setHorizontalAlignment(SwingConstants.RIGHT);
		
		ColLeft = new DefaultTableCellRenderer();
		ColLeft.setHorizontalAlignment(SwingConstants.LEFT);
		ColLeft.setFont(new Font("Segoe UI", Font.BOLD, 13));
		ColLeft.setForeground(UIManager.getColor("Button.foreground"));	
		ColLeft.setBackground(UIManager.getColor("Button.background"));
				
		ColCenter = new DefaultTableCellRenderer();		
		ColCenter.setHorizontalAlignment(SwingConstants.CENTER);
		ColCenter.setFont(new Font("Segoe UI", Font.BOLD, 13));
		ColCenter.setForeground(UIManager.getColor("Button.foreground"));
		ColCenter.setBackground(UIManager.getColor("Button.background"));
				
		ColRight = new DefaultTableCellRenderer(); 
		ColRight.setHorizontalAlignment(SwingConstants.RIGHT);
		ColRight.setFont(new Font("Segoe UI", Font.BOLD, 13));
		ColRight.setForeground(UIManager.getColor("Button.foreground"));
		ColRight.setBackground(UIManager.getColor("Button.background"));
	}
	
	public TabelaModelo(ArrayList<?> linhas, String[] colunas) {		
		this();
		setLinhas(linhas);
		setColunas(colunas);
	}
		
	public ArrayList<?> getLinhas() {
		return linhas;
	}


	public void setLinhas(ArrayList<?> linhas) {
		this.linhas = linhas;
	}


	public String[] getColunas() {
		return colunas;
	}


	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}

	
	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public int getColumnCount() {		
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object[] linha = (Object[])getLinhas().get(rowIndex);
		return linha[columnIndex];
	}
		
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}	

}
