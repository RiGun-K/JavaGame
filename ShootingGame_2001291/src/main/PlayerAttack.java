package main;

import java.awt.Image;

import javax.swing.ImageIcon;

// 플레이어의 공격 이미지 , 좌표 값 설정 
public class PlayerAttack {
	  Image image = new ImageIcon("src/images/player_attack.png").getImage();
	    int x, y;
	    int width = image.getWidth(null);
	    int height = image.getHeight(null);
	    int attack = 5;

	    public PlayerAttack(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

	    public void fire() {
	        this.x += 15;
	    }
}
