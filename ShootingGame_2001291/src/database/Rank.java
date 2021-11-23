package database;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


// Ctrl + Shift + o  // 자동 import 
public class Rank extends JFrame {

	private JFrame frame;
	
	public Rank() {
		
		// DBConnection 클래스와 연동
		DBConnection db = new DBConnection();
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 0, 954, 544);
		tablePanel.setVisible(true);
		
		String[][] data = db.getRank();
		String[] headers = {"아이디","점수"};
		
		JTable table = new JTable(data, headers);
		table.setRowHeight(30);
		table.setFont(new Font("Sanserif", Font.BOLD, 15));
		table.setAlignmentX(0);
		table.setSize(800, 600);
		table.setPreferredScrollableViewportSize(new Dimension(800, 600));
		tablePanel.add(new JScrollPane(table));
		
		setVisible(true);
		setSize(900,400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(tablePanel);
		}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Rank();
	}

}
