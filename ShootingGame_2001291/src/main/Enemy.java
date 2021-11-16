package main;

import java.awt.Image;

import javax.swing.ImageIcon;

// 적 공격 이미지 + 좌표 값 
public class Enemy {
    Image image = new ImageIcon("src/images/spring.png").getImage();
    int x, y;
    int width = image.getWidth(null);
    int height = image.getHeight(null);
    int hp = 10;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
         this.x -= 7;
    }
}
