package dynamic_beat_17_score;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame; // Made by 'ctrl+shift+o' 
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon infoButtonBasicImage = new ImageIcon(Main.class.getResource("../images/infoBasicImage.png"));	
	private ImageIcon infoButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/infoEnteredImage.png"));	
	private ImageIcon infoBackButtonBasicImage = new ImageIcon(Main.class.getResource("../images/infoBackBasicImage.png"));	
	private ImageIcon infoBackButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/infoBackEnteredImage.png"));	
	private ImageIcon sourceImage = new ImageIcon(Main.class.getResource("../images/source.png"));
	
	//private Image scoreImage = new ImageIcon(Main.class.getResource("../images/scoreImage.png")).getImage();
	private ImageIcon scoreButtonBasicImage = new ImageIcon(Main.class.getResource("../images/scoreButtonBasicImage.png"));
	private ImageIcon scoreButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/scoreButtonEnteredImage.png"));
	private ImageIcon scoreSImage = new ImageIcon(Main.class.getResource("../images/scoreS.png"));
	private ImageIcon scoreAImage = new ImageIcon(Main.class.getResource("../images/scoreA.png"));
	private ImageIcon scoreBImage = new ImageIcon(Main.class.getResource("../images/scoreB.png"));
	private ImageIcon scoreCImage = new ImageIcon(Main.class.getResource("../images/scoreC.png"));

	
	
	
	
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground(title).jpg"))
			.getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);
	private JButton infoButton = new JButton(infoButtonBasicImage);
	private JButton infoBackButton = new JButton(infoBackButtonBasicImage);
	private JButton source = new JButton(sourceImage);
	private JButton scoreButton = new JButton(scoreButtonBasicImage);
	private JButton scoreS = new JButton(scoreSImage);
	private JButton scoreA = new JButton(scoreAImage);
	private JButton scoreB = new JButton(scoreBImage);
	private JButton scoreC = new JButton(scoreCImage);
	
	
	private int mouseX, mouseY; // coordinates of mouse
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	

	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private Music introMusic = new Music("introMusic.mp3", true); // music played (계속)
	private int nowSelected = 0;
	
	public static Game game;
	
	/*public endMusic() {
		if (game.isMusicEnd())
		{
			showScore();
			//
		}
	}*/
	
	public DynamicBeat() { // constructor

		//0 index
		trackList.add(new Track("Wild World Title Image.png", "Wild World Start Image.png",
				"Wild World Game Image.png", "Town Hall Selected.mp3", "Town Hall.mp3", "Wild World"));		
		//1 index
		trackList.add(new Track("Temple of Time Title Image.png", "Temple of Time Start Image.png",
				"Temple of Time Game Image.png", "Temple of Time Selected.mp3", "Temple of Time.mp3", "Temple of Time"));
		//2 index
		trackList.add(new Track("The Cygnus Garden Title Image.png", "The Cygnus Garden Start Image.png",
				"The Cygnus Garden Game Image.png", "The Cygnus Garden Selected.mp3", "The Cygnus Garden.mp3", "The Cygnus Garden"));
		//3 index
		trackList.add(new Track("Shattered Time Title Image.png", "Shattered Time Start Image.png",
				"Shattered Time Game Image.png", "Shattered Time Selected.mp3", "Shattered Time.mp3", "Shattered Time"));
		//4 index
		trackList.add(new Track("The Tune of The Azure Light Title Image.png", "The Tune of The Azure Light Start Image.png",
				"The Tune of The Azure Light Game Image.png", "The Tune of The Azure Light Selected.mp3", "The Tune of The Azure Light.mp3", "The Tune of The Azure Light"));
		//5
		trackList.add(new Track("Kamado Tanjiro No Uta Title Image.png", "Kamado Tanjiro No Uta Start Image.png",
				"Kamado Tanjiro No Uta Game Image.png", "Kamado Tanjiro No Uta Selected.mp3", "Kamado Tanjiro No Uta.mp3", "Kamado Tanjiro No Uta"));
		
		
		/*
		 * 게임 환경 설정 http://wallpaperswide.com
		 */
		setUndecorated(true);
		setTitle("Dynamic Beat"); // set game title name
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // set size of the game
		setResizable(false); // not allow users to adjust size of the game
		setLocationRelativeTo(null); // appear game in the middle of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit game
		setVisible(true); // successfully appear on the screen
		setBackground(new Color(0, 0, 0, 0)); // white
		setLayout(null);
		
		addKeyListener(new KeyListener());
		
		
		// Music
		
		introMusic.start();
		
		
		
		
		//ExitButton
		exitButton.setBounds(1245, 0, 30, 30);
		// make button layout clear
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
				buttonEnteredMusic.start();
				 try {
				 Thread.sleep(1000);
				 } catch (InterruptedException ex) {
				 	ex.printStackTrace();
				 }
				 
				System.exit(0);
				
			}
		});
		
		add(exitButton);
		
		
		
		//StartButton
		startButton.setBounds(40, 200, 400, 100);
		// make button layout clear
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
				buttonEnteredMusic.start();
				 try {
				 Thread.sleep(1000);
				 } catch (InterruptedException ex) {
				 	ex.printStackTrace();
				 }
				
				//게임 시작 이벤트
				enterMain();
				
			}
		});
		
		add(startButton);
		

		
		//StartButton
		quitButton.setBounds(40, 330, 400, 100);
		// make button layout clear
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
				buttonEnteredMusic.start();
				 try {
				 Thread.sleep(1000);
				 } catch (InterruptedException ex) {
				 	ex.printStackTrace();
				 }
				System.exit(0);
			}
		});
		
		add(quitButton);
		
		

		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 100, 100);
		// make button layout clear
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				/*Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
				buttonEnteredMusic.start();
				 try {
				 Thread.sleep(1000);
				 } catch (InterruptedException ex) {
				 	ex.printStackTrace();
				 }*/
				
				//왼쪽 버튼 이벤트
				selectLeft();
			}
		});
		
		add(leftButton);
				

		rightButton.setVisible(false);
		rightButton.setBounds(1030, 310, 100, 100);
		// make button layout clear
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				/*Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
				buttonEnteredMusic.start();
				 try {
				 Thread.sleep(1000);
				 } catch (InterruptedException ex) {
				 	ex.printStackTrace();
				 }*/
				
				//오른쪽 버튼 이벤트
				selectRight();
			}
		});
		
		add(rightButton);
		
		
		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 250, 67);
		// make button layout clear
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				/*Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
				buttonEnteredMusic.start();
				 try {
				 Thread.sleep(1000);
				 } catch (InterruptedException ex) {
				 	ex.printStackTrace();
				 }*/
				
				//난이도 쉬움 이벤트

				gameStart(nowSelected, "Easy");
				
			}
		});
		
		add(easyButton);
		
		
		
		hardButton.setVisible(false);
		hardButton.setBounds(655, 580, 250, 67);
		// make button layout clear
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				/*Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
				buttonEnteredMusic.start();
				 try {
				 Thread.sleep(1000);
				 } catch (InterruptedException ex) {
				 	ex.printStackTrace();
				 }*/
				
				//난이도 어려움 이벤트
				gameStart(nowSelected, "Hard");
				
				
			}
		});
		
		add(hardButton);
		
		
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 100, 100);
		// make button layout clear
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				/*Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
				buttonEnteredMusic.start();
				 try {
				 Thread.sleep(1000);
				 } catch (InterruptedException ex) {
				 	ex.printStackTrace();
				 }*/
				
				//메인 화면 돌아가는 이벤트
				backMain();
				
			}
		});
		
		add(backButton);
		
		
		
		
		
		infoButton.setVisible(false);
		infoButton.setBounds(1100, 600, 50, 50);
		// make button layout clear
		infoButton.setBorderPainted(false);
		infoButton.setContentAreaFilled(false);
		infoButton.setFocusPainted(false);
		infoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				infoButton.setIcon(infoButtonEnteredImage);
				infoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				infoButton.setIcon(infoButtonBasicImage);
				infoButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
				buttonEnteredMusic.start();
				 try {
				 Thread.sleep(1000);
				 } catch (InterruptedException ex) {
				 	ex.printStackTrace();
				 }
				
				
				//info
				 enterInfo();
			}
		});
		
		add(infoButton);
		
		
		
		infoBackButton.setVisible(false);
		infoBackButton.setBounds(40, 650, 50, 50);
		// make button layout clear
		infoBackButton.setBorderPainted(false);
		infoBackButton.setContentAreaFilled(false);
		infoBackButton.setFocusPainted(false);
		infoBackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				infoBackButton.setIcon(infoBackButtonEnteredImage);
				infoBackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				infoBackButton.setIcon(infoBackButtonBasicImage);
				infoBackButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
				buttonEnteredMusic.start();
				 try {
				 Thread.sleep(1000);
				 } catch (InterruptedException ex) {
				 	ex.printStackTrace();
				 }
				
				
				//backMain
				 backMain();
				 
			}
		});
		
		add(infoBackButton);
		
		
		
		
		source.setVisible(false);
		source.setBounds(0,0,1280,720);
		source.setBorderPainted(false);
		source.setContentAreaFilled(false);
		source.setFocusPainted(false);		
		add(source);
		
		
		
		
		scoreS.setVisible(false);
		scoreS.setBounds(0, 30, 1280, 720);
		scoreS.setBorderPainted(false);
		scoreS.setContentAreaFilled(false);
		scoreS.setFocusPainted(false);		
		add(scoreS);
		
		scoreA.setVisible(false);
		scoreA.setBounds(0, 30, 1280, 720);
		// make button layout clear
		scoreA.setBorderPainted(false);
		scoreA.setContentAreaFilled(false);
		scoreA.setFocusPainted(false);		
		add(scoreA);
		
		scoreB.setVisible(false);
		scoreB.setBounds(0, 30, 1280, 720);
		// make button layout clear
		scoreB.setBorderPainted(false);
		scoreB.setContentAreaFilled(false);
		scoreB.setFocusPainted(false);		
		add(scoreB);
		
		scoreC.setVisible(false);
		scoreC.setBounds(0, 30, 1280, 720);
		// make button layout clear
		scoreC.setBorderPainted(false);
		scoreC.setContentAreaFilled(false);
		scoreC.setFocusPainted(false);		
		add(scoreC);
		
		
		

		scoreButton.setVisible(false);
		scoreButton.setBounds(700, 680, 100, 30);
		// make button layout clear
		scoreButton.setBorderPainted(false);
		scoreButton.setContentAreaFilled(false);
		scoreButton.setFocusPainted(false);
		scoreButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				scoreButton.setIcon(scoreButtonEnteredImage);
				scoreButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				scoreButton.setIcon(scoreButtonBasicImage);
				scoreButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				/*Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
				buttonEnteredMusic.start();
				 try {
				 Thread.sleep(1000);
				 } catch (InterruptedException ex) {
				 	ex.printStackTrace();
				 }*/
				
				//점수 화면 돌아가는 이벤트
				if (game.isMusicEnd())
				{
					showScore();
					//
				}
				
				
			}
		});
		
		add(scoreButton);
		
		
		
		
		
		
		

		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);
			}
		});
		add(menuBar);

		while (!game.isMusicEnd())
		{
			System.out.println("Music progressing..");
		}
		scoreButton.setVisible(true);	
		
		
		
		
	}

	public void paint(Graphics g) { // 약속된 메서드
		// create image
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		// draw image
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null); // draw for background
		if(isMainScreen)
		{
			g.drawImage(selectedImage, 335, 100, null);
			g.drawImage(titleImage, 335, 55, null);
		}
		if(isGameScreen)
		{
			game.screenDraw(g);
		}
		
		paintComponents(g); // draw for Jlabel
		try {
			Thread.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.repaint(); // call paint function again
		// double buffering technique
	}
	
	
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage()))
				.getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage()))
				.getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(),true);
		selectedMusic.start();
	}
	
	
	public void selectLeft() {
		if(nowSelected == 0)
			nowSelected = trackList.size() -1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected == trackList.size() -1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		backButton.setVisible(true);
		scoreButton.setVisible(true);
		infoButton.setVisible(false);
		
		isGameScreen = true;
		
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
		game.start();
		setFocusable(true);
		requestFocus();
			
		
		
	}
	
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		source.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
				.getImage();
		backButton.setVisible(false);
		infoButton.setVisible(true);
		infoBackButton.setVisible(false);
		scoreS.setVisible(false);
		scoreA.setVisible(false);
		scoreB.setVisible(false);
		scoreC.setVisible(false);
		scoreButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
		game.close();
		
	}
	
	public void enterMain() {
		
		startButton.setVisible(false);
		quitButton.setVisible(false);
		source.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
				.getImage();
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		infoButton.setVisible(true);
		
		introMusic.close();
		
		selectTrack(0);
	}
	
	public void enterInfo() {
		
		startButton.setVisible(false);
		quitButton.setVisible(false);
		source.setVisible(true);
		/*background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
				.getImage();*/
		isMainScreen = false;	
		infoBackButton.setVisible(true);
		infoButton.setVisible(false);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		
		
	}
	
	
	public void showScore() {
	
		if(game.getScore() == "S")
		{
			scoreS.setVisible(true);
		}
		else if(game.getScore() == "A")
		{
			scoreA.setVisible(true);
		}
		else if(game.getScore() == "B")
		{
			scoreB.setVisible(true);
		}
		else if(game.getScore() == "C")
		{
			scoreC.setVisible(true);
		}		
		
	}
	
}
