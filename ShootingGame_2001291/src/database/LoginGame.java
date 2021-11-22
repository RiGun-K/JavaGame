package database;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import javax.swing.*;

import main.ShootingGame;



public class LoginGame extends JFrame {

	
	public LoginGame() {
		
		// DB 연동
		DBConnection connection = new DBConnection();
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID : ");
		JLabel pw = new JLabel("PW : ");
		
		JTextField twtID = new JTextField(10);
		JPasswordField twtPW = new JPasswordField(10);
		
		JButton button = new JButton("Login");
		button.setFont(new Font("Lato", Font.BOLD, 20));
		
		JLabel Welcome = new JLabel("Please Login Your Account!!");
		Welcome.setFont(new Font("Arial Black", Font.BOLD, 25));
		Welcome.setBounds(262, 27, 459, 53);
		
		panel.add(label);
		panel.add(twtID);
		panel.add(pw);
		panel.add(twtPW);
		panel.add(button);
		panel.add(Welcome);
		
		// 로그인 버튼 클릭 이벤트
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "Gun";
				String pw = "1234";
				
				panel.setVisible(false);
//				mainScreen.setVisible(true);
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
