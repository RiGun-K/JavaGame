package database;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import javax.swing.*;

import main.ShootingGame;




public class LoginGame extends JFrame {

	private JTextField id;
	private JPasswordField pw;
	
	public LoginGame() {
		
		
		// DBConnection 클래스와 연동
		DBConnection db = new DBConnection();
		
		JPanel panel = new JPanel();
		JLabel idlabel = new JLabel("ID : ");
		JLabel pwlabel = new JLabel("PW : ");
		
		id = new JTextField();
		pw = new JPasswordField();
				
		JLabel Welcome = new JLabel("Please Login Your Account!!");
		Welcome.setFont(new Font("Arial Black", Font.BOLD, 25));
		Welcome.setBounds(262, 27, 459, 53);
		
		panel.add(idlabel);
		panel.add(pwlabel);
		panel.add(id);
		panel.add(pw);
		panel.add(Welcome);
		
		id.setColumns(10);
		pw.setColumns(10);
		
		JButton button = new JButton("Login");
		button.setFont(new Font("Lato", Font.BOLD, 20));
		panel.add(button);
		
		// 로그인 버튼 클릭 이벤트
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String idTxt = id.getText();
				// 비밀번호는 String 이 안되서 Object 로 받음 ( DB 저장시 암호화 됬음 ) 
				Object pwTxt = pw.getPassword();
				
				// 입력받은 값을 DBConnection insert 클래스 에 넘김
				db.insertTable(idTxt, pwTxt);
				JOptionPane.showMessageDialog(null, "Your data has been saved successfully");
				panel.setVisible(false);
		        boolean isLoginScreen = true;
				}
		});
				
		add(panel);
		
		setVisible(true);
		setSize(600,400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	   
		public static void main(String[] args) {
			LoginGame lg = new LoginGame();
			
		}

}
