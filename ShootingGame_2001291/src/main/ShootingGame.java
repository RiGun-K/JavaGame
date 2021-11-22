package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


/*
 * 게임 화면 + 키 설정에 대한 클래스 
 */

public class ShootingGame extends JFrame {
	
    private Image bufferImage;
    private Graphics screenGraphic;

    // 화면 순서 
    private Image mainScreen = new ImageIcon("src/images/main2.png").getImage();
    private Image loginScreen = new ImageIcon("src/images/login.png").getImage();
    private Image loadingScreen = new ImageIcon("src/images/roading.jfif").getImage();
    private Image gameScreen = new ImageIcon("src/images/gameimage3.gif").getImage();

    // boolean 변수로 화면전환 설정
    private boolean isMainScreen, isLoginScreen, isLoadingScreen, isGameScreen;

    // 
    private Game game = new Game();

    private Audio backgroundMusic;
    
    public ShootingGame() {
        setTitle("Shooting Game");
        setUndecorated(true);
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);

        init();
    }
    
    // 초기화 메소드
    private void init() {
        isMainScreen = true;
        isLoginScreen = false;
        isLoadingScreen = false;
        isGameScreen = false;
        

        backgroundMusic = new Audio("src/audio/menuBGM.wav", true);
        backgroundMusic.start();

        // 컴포넌트에 키 이벤트 리스너를 등록
        addKeyListener(new KeyListener());
    }
    
    // 로그인화면
    private void loginStart() {
        isMainScreen = false;
        isLoginScreen = true;
        
        /*
         * 11/22 
         * 1) 이 화면에서 로그인 회원가입을 구현
         * 2) 로그인 버튼 이벤트 발생시(로그인 될 경우) gameStart()로 화면전환 
         * 3) 게임시작시 스코어를 축적하여 DB에 저장하여야 함 ! 
         * 4) 게임종료시 스코어가 높은순으로 화면에 랭킹 띄워야함 ! 
         * 
         * 그외) 각각의 물체들 이미지 전환
         *    ) 총 이미지,사운드 등 수정
         */

    }
    
    // 게임화면
    private void gameStart() {
        isLoginScreen = false;
        isLoadingScreen = true;

        // 자바 타이머 클래스
        /* 
         * Timer = 실제 타이머의 기능을 수행
         * TimerTask = Timer 가 수행할 내용 작성
         */
        Timer loadingTimer = new Timer();
        TimerTask loadingTask = new TimerTask() {
            @Override
            public void run() {
                backgroundMusic.stop();
                isLoadingScreen = false;
                isGameScreen = true;
                game.start();
            }
        };
        // 3초뒤에 설정한 run 메소드 수행한다.
        loadingTimer.schedule(loadingTask, 3000);
    }

    public void paint(Graphics g) {
        bufferImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = bufferImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(bufferImage, 0, 0, null);
    }

    public void screenDraw(Graphics g) {
        if (isMainScreen) {
            g.drawImage(mainScreen, 0, 0, null);
        }
        if (isLoginScreen) {
            g.drawImage(loginScreen, 0, 0, null);
        }
        if (isLoadingScreen) {
            g.drawImage(loadingScreen, 0, 0, null);
        }
        if (isGameScreen) {
            g.drawImage(gameScreen, 0, 0, null);
            game.gameDraw(g);
        }
        this.repaint();
    }

    // 버튼이 클릭되거나 리스트, 메뉴 등이 선택되었을 때 발생하는 이벤트
    // ActionListener 인터페이스의 actionPerformed(ActionEvent) 메서드를 이용해서 처리
    
    class KeyListener extends KeyAdapter {
    	// 키가 눌러지면 호출
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    game.setUp(true);
                    break;
                case KeyEvent.VK_S:
                    game.setDown(true);
                    break;
                case KeyEvent.VK_A:
                    game.setLeft(true);
                    break;
                case KeyEvent.VK_D:
                    game.setRight(true);
                    break;
                case KeyEvent.VK_R:
                    if (game.isOver()) game.reset();
                    break;
                case KeyEvent.VK_SPACE:
                    game.setShooting(true);
                    break;
                case KeyEvent.VK_ENTER:
                    if (isMainScreen) {
                    	loginStart();
                    }
                    break;
                // ESC 키 -> 종료 
                case KeyEvent.VK_ESCAPE:
                    System.exit(0);
                    break;
            }
        }
        
        // 키에서 뗄 때 호출
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    game.setUp(false);
                    break;
                case KeyEvent.VK_S:
                    game.setDown(false);
                    break;
                case KeyEvent.VK_A:
                    game.setLeft(false);
                    break;
                case KeyEvent.VK_D:
                    game.setRight(false);
                    break;
                case KeyEvent.VK_SPACE:
                    game.setShooting(false);
                    break;
            }
        }
    }
    



}
