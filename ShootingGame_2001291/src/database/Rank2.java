package database;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;



import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JScrollPane;

import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;


public class Rank2 extends JFrame {
	
	private static final String ID = "root";
	private static final String PW = "4238";
	private static final String URL = "jdbc:mariadb://127.0.0.1:3306/javagame";
	
	String [][] datas = new String[0][2];

	String [] title = {"아이디", "점수"};

	DefaultTableModel model; //표의 실질적 데이터를 가지게될 model

	JTable table;

	JLabel lblCount;

	

	int nRow,nColumn;

	String cRow,cColumn;

	Object cValue;

	JLabel lblCell;

	

	Connection conn;

	PreparedStatement pstmt;

	ResultSet rs;

	

	public Rank2() {

		setTitle("최종 스코어");

		

		layInit();

		accDb();

		

		setBounds(0, 0, 954, 544);

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

		//테이블 자료 클릭시 값 얻기

		table.addMouseListener(new MouseAdapter() {

			@Override

			public void mouseClicked(MouseEvent e) {

				table = (JTable)e.getComponent();

				model = (DefaultTableModel)table.getModel();

				/*

				System.out.println("행/열 번호 : "+table.getSelectedRow()+"/"+table.getSelectedColumn());

				System.out.println("열이름 : " + table.getColumnName(table.getSelectedColumn()));

				System.out.println("값은 : " + model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));

				//model.getValueAt(row,column)은 row와 column을 숫자값으로 받는다

				*/

				//선택한 행 열번호를 알아냄

				nRow = table.getSelectedRow();

		

				

				//알아낸 행열번호를 통해서 각각의 값을 알아냄

				cRow = table.getColumnName(nColumn); //열이름

				cValue = model.getValueAt(nRow, nColumn); //값

				

				String str = "선택한 계정 : " + nRow + "번째 사용자 점수 : "+ cValue;

				lblCell.setText(str);

				

				//행은 선택하고 열 고정

				System.out.println(table.getValueAt(table.getSelectedRow(), 1)); //(행, 열)

			}

		});

		

	}

	private void layInit(){

		model = new DefaultTableModel(datas, title);

		table = new JTable(model);

		table.setRowHeight(30);
		table.setFont(new Font("Sanserif", Font.BOLD, 15));
		table.setAlignmentX(0);
		table.setSize(800, 600);
		table.setPreferredScrollableViewportSize(new Dimension(800, 600));
		JScrollPane scrollPane = new JScrollPane(table);

		lblCount =  new JLabel("참여자 : 0");

		lblCell = new JLabel("선택한 계정 : ");

		

		add("Center",scrollPane);

		add("South",lblCount);

		add("North",lblCell);

	}

	private void accDb(){

		try {

			Class.forName("org.mariadb.jdbc.Driver");

			conn = DriverManager.getConnection(URL,ID,PW);

			pstmt = conn.prepareStatement("select * from users ORDER BY `score` DESC");

			rs = pstmt.executeQuery();

			int cou = 0;

			// 11/23 
			// 시작할때 바로뜸 , + 죽어서 R눌러도 DB에 스코어가 저장안됨 ! 
			// You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'id=javax.swing.JTextField[,228,5,94x20,layout=javax.swing.plaf.basic.BasicTex...'
			
			while(rs.next()){

				String id = rs.getString("id");

				String score = rs.getString("score");

			;

				String []imsi = {id, score};

				model.addRow(imsi); //자료를 model에 넘겨주고 model을 통해 table에 표현

				cou++;

			}

			lblCount.setText("참여자 : "+ cou);

			

		} catch (Exception e) {

			JOptionPane.showMessageDialog(this, "accDb err : " + e); //알림창으로 에러 출력

			

		} finally {						// 작업이 끝나면 닫아주어야 한다

			try {

				if(rs != null) rs.close();

				if(pstmt != null) pstmt.close();

				if(conn != null) conn.close();

			} catch (Exception e2) {

				// TODO: handle exception

			}

		}

		

	}



	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Rank2();
	}

}
