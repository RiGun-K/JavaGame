package database;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.ShootingGame;

public class LoginGame extends JFrame {

	
	public LoginGame() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID : ");
		JLabel pw = new JLabel("PW : ");
		
		JTextField twtID = new JTextField(10);
		JPasswordField twtPW = new JPasswordField(10);
		JButton button = new JButton("Login");
		
		panel.add(label);
		panel.add(twtID);
		panel.add(pw);
		panel.add(twtPW);
		panel.add(button);
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = "admin";
				String pw = "admin";
				
				
				if(id.equals(twtID.getText())&&pw.equals(twtPW.getText())) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
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
