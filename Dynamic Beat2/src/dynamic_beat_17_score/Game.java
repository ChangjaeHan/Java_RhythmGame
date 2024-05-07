package dynamic_beat_17_score;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	
	
	//노트 찍기 연습
	private boolean gameMaker = true; // 제작모드
	
	private boolean musicEnd = false;
	
	
	
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();	
		
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image blueFlareImage;
	private Image judgeImage;
	private Image keyPadSImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadDImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadFImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace1Image= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace2Image= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadJImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadKImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadLImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

	
	
	
	
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	private int theInt = 0;
	private String scoreDetermined;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
		
	
	}
	
	public void screenDraw(Graphics2D g) {
		
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
				
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
				
		// 노트 눈에 보이게 출력
		for (int i=0; i<noteList.size(); i++)
		{
			Note note = noteList.get(i);
			if(note.getY() > 620)
			{
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
			
		}
		
		
		g.setColor(Color.white);
		// 글자 깨짐 방지
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		//Key
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString(String.valueOf(theInt), 565, 702);
		g.drawImage(blueFlareImage, 450, 370, null);
		g.drawImage(judgeImage, 460, 420, null);
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 748, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);
		
		
	}
	
	
	char quotes = '"';
	
	public void pressS() {			
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();

		//new Music("스페이스.mp3", false).start();	
		// 제작모드
		if (gameMaker == true)
		{
			System.out.println("new Beat(" + (gameMusic.getTime() - 4080) + ", " + quotes + "S" + quotes + "),");
		}	
	}	
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

	}
	
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();

		//new Music("스페이스.mp3", false).start();
		if (gameMaker == true)
		{
			System.out.println("new Beat(" + (gameMusic.getTime() - 4080) + ", " + quotes + "D" + quotes + "),");
		}
	}	
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

	}
	
	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();

		//new Music("스페이스.mp3", false).start();
		if (gameMaker == true)
		{
			System.out.println("new Beat(" + (gameMusic.getTime() - 4080) + ", " + quotes + "F" + quotes + "),");
		}
	}	
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

	}
	
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		
		//new Music("스페이스.mp3", false).start();
		if (gameMaker == true)
		{
			System.out.println("new Beat(" + (gameMusic.getTime() - 4080) + ", " + quotes + "Space" + quotes + "),");
		}
	}	
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

	}
	
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();

		//new Music("스페이스.mp3", false).start();
		if (gameMaker == true)
		{
			System.out.println("new Beat(" + (gameMusic.getTime() - 4080) + ", " + quotes + "J" + quotes + "),");
		}
	}	
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

	}
	
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();

		//new Music("스페이스.mp3", false).start();
		if (gameMaker == true)
		{
			System.out.println("new Beat(" + (gameMusic.getTime() - 4080) + ", " + quotes + "K" + quotes + "),");
		}
	}	
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

	}
	
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();

		//new Music("스페이스.mp3", false).start();
		if (gameMaker == true)
		{
			System.out.println("new Beat(" + (gameMusic.getTime() - 4080) + ", " + quotes + "L" + quotes + "),");
		}
	}	
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

	}
	
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	
	
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if(titleName.equals("Wild World") && difficulty.equals("Easy")) {
	
			//int startTime = 4460 - Main.REACH_TIME * 1000;
			//int gap = 125;
			beats = new Beat[] {
					new Beat(7040, "D"),
					new Beat(8110, "K"),
					new Beat(9180, "Space"),
					new Beat(10230, "F"),
					new Beat(11310, "L"),
					new Beat(12330, "S"),
					new Beat(13410, "J"),
					new Beat(14490, "D"),
					new Beat(15540, "J"),
					new Beat(15560, "L"),
					new Beat(16610, "F"),
					new Beat(16630, "S"),
					new Beat(17640, "D"),
					new Beat(17640, "K"),
					new Beat(18680, "Space"),
					new Beat(20180, "S"),
					new Beat(21240, "F"),
					new Beat(22290, "K"),
					new Beat(23350, "K"),
					new Beat(23860, "D"),
					new Beat(25120, "L"),
					new Beat(25120, "J"),
					new Beat(26200, "F"),
					new Beat(26200, "S"),
					new Beat(27390, "Space"),
					new Beat(27390, "K"),
					new Beat(27390, "D"),
					new Beat(35240, "D"),
					new Beat(36240, "J"),
					new Beat(37290, "L"),
					new Beat(38310, "K"),
					new Beat(39390, "K"),
					new Beat(40370, "S"),
					new Beat(41430, "S"),
					new Beat(42480, "F"),
					new Beat(43520, "Space"),
					new Beat(44520, "D"),
					new Beat(45570, "D"),
					new Beat(46650, "L"),
					new Beat(47700, "F"),
					new Beat(48720, "K"),
					new Beat(49770, "D"),
					new Beat(50840, "L"),
					new Beat(51900, "S"),
					new Beat(52930, "J"),
					new Beat(53990, "D"),
					new Beat(55030, "F"),
					new Beat(56040, "Space"),
					new Beat(57090, "Space"),
					new Beat(58160, "Space"),
					new Beat(59180, "D"),
					new Beat(59190, "K"),
					new Beat(60720, "S"),
					new Beat(61740, "L"),
					new Beat(62800, "F"),
					new Beat(63850, "J"),
					new Beat(64410, "D"),
					new Beat(65530, "K"),
					new Beat(66570, "S"),
					new Beat(67850, "L"),
					new Beat(67870, "J"),
					new Beat(69320, "D"),
					new Beat(70340, "J"),
					new Beat(71430, "F"),
					new Beat(72430, "K"),
					new Beat(73450, "S"),
					new Beat(74450, "F"),
					new Beat(75570, "J"),
					new Beat(75570, "L"),
					new Beat(76570, "D"),
					new Beat(77600, "J"),
					new Beat(77620, "Space"),
					new Beat(78610, "S"),
					new Beat(79680, "D"),
					new Beat(80730, "L"),
					new Beat(80730, "J"),
					new Beat(81710, "F"),
					new Beat(82730, "D"),
					new Beat(82730, "K"),
					new Beat(83800, "S"),
					new Beat(84830, "L"),
					new Beat(85860, "L"),
					new Beat(86940, "F"),
					new Beat(87980, "K"),
					new Beat(89050, "D"),
					new Beat(90050, "F"),
					new Beat(90060, "S"),
					new Beat(90080, "J"),
					new Beat(90080, "L"),
					new Beat(91120, "D"),
					new Beat(92150, "K"),
					new Beat(93180, "F"),
					new Beat(93180, "J"),
					new Beat(93190, "S"),
					new Beat(93200, "L"),
					new Beat(94250, "Space"),
					new Beat(95260, "D"),
					new Beat(96310, "K"),
					new Beat(97280, "J"),
					new Beat(98410, "S"),
					new Beat(98910, "D"),
					new Beat(99460, "F"),
					new Beat(99930, "J"),
					new Beat(100460, "K"),
					new Beat(101000, "L"),
					new Beat(101550, "Space"),
					new Beat(102080, "Space"),
					new Beat(103200, "Space"),
					new Beat(104350, "Space")
					

					
			};
		}
		else if(titleName.equals("Wild World") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(2720, "S"),
					new Beat(3290, "L"),
					new Beat(3290, "J"),
					new Beat(3790, "D"),
					new Beat(4350, "Space"),
					new Beat(4350, "K"),
					new Beat(4900, "F"),
					new Beat(5440, "J"),
					new Beat(5440, "L"),
					new Beat(6000, "D"),
					new Beat(6520, "Space"),
					new Beat(6520, "K"),
					new Beat(7060, "S"),
					new Beat(7320, "F"),
					new Beat(7570, "D"),
					new Beat(8150, "L"),
					new Beat(8380, "J"),
					new Beat(8650, "K"),
					new Beat(9190, "D"),
					new Beat(9460, "K"),
					new Beat(9700, "F"),
					new Beat(9970, "J"),
					new Beat(10560, "S"),
					new Beat(10810, "L"),
					new Beat(11320, "D"),
					new Beat(11850, "F"),
					new Beat(12360, "D"),
					new Beat(12900, "F"),
					new Beat(13470, "K"),
					new Beat(13980, "J"),
					new Beat(14520, "K"),
					new Beat(14970, "J"),
					new Beat(15540, "L"),
					new Beat(15800, "S"),
					new Beat(16050, "K"),
					new Beat(16600, "D"),
					new Beat(16850, "F"),
					new Beat(17110, "J"),
					new Beat(17650, "Space"),
					new Beat(17910, "K"),
					new Beat(18130, "D"),
					new Beat(18420, "L"),
					new Beat(18640, "S"),
					new Beat(19220, "F"),
					new Beat(19730, "Space"),
					new Beat(20280, "F"),
					new Beat(20500, "D"),
					new Beat(20750, "S"),
					new Beat(21310, "L"),
					new Beat(21820, "K"),
					new Beat(22650, "J"),
					new Beat(23400, "Space"),
					new Beat(23950, "L"),
					new Beat(23950, "S"),
					new Beat(23950, "F"),
					new Beat(23950, "J"),
					new Beat(25120, "Space"),
					new Beat(25120, "K"),
					new Beat(25140, "D"),
					new Beat(26210, "F"),
					new Beat(26210, "J"),
					new Beat(27430, "S"),
					new Beat(27450, "L"),
					new Beat(33190, "D"),
					new Beat(33700, "F"),
					new Beat(33970, "K"),
					new Beat(34530, "L"),
					new Beat(34740, "J"),
					new Beat(35240, "S"),
					new Beat(35460, "S"),
					new Beat(35710, "S"),
					new Beat(35970, "S"),
					new Beat(36230, "F"),
					new Beat(36760, "K"),
					new Beat(37310, "D"),
					new Beat(37860, "J"),
					new Beat(38090, "K"),
					new Beat(38600, "F"),
					new Beat(38880, "K"),
					new Beat(39400, "L"),
					new Beat(39630, "L"),
					new Beat(39890, "L"),
					new Beat(40130, "L"),
					new Beat(40410, "K"),
					new Beat(40910, "J"),
					new Beat(41460, "D"),
					new Beat(41990, "F"),
					new Beat(42260, "J"),
					new Beat(42740, "K"),
					new Beat(43000, "J"),
					new Beat(43520, "K"),
					new Beat(43800, "K"),
					new Beat(44040, "K"),
					new Beat(44280, "K"),
					new Beat(44510, "F"),
					new Beat(45070, "J"),
					new Beat(45580, "D"),
					new Beat(46130, "D"),
					new Beat(46380, "S"),
					new Beat(46950, "F"),
					new Beat(47190, "K"),
					new Beat(47720, "D"),
					new Beat(47950, "S"),
					new Beat(48210, "F"),
					new Beat(48750, "K"),
					new Beat(48960, "L"),
					new Beat(49240, "J"),
					new Beat(49780, "D"),
					new Beat(50030, "K"),
					new Beat(50300, "F"),
					new Beat(50560, "J"),
					new Beat(51130, "S"),
					new Beat(51370, "L"),
					new Beat(51910, "Space"),
					new Beat(52410, "D"),
					new Beat(52930, "K"),
					new Beat(53430, "J"),
					new Beat(53990, "K"),
					new Beat(54250, "J"),
					new Beat(54530, "D"),
					new Beat(54770, "S"),
					new Beat(55290, "S"),
					new Beat(55560, "J"),
					new Beat(56080, "F"),
					new Beat(56330, "J"),
					new Beat(56590, "L"),
					new Beat(57110, "L"),
					new Beat(57330, "D"),
					new Beat(57620, "K"),
					new Beat(58150, "D"),
					new Beat(58400, "F"),
					new Beat(58660, "S"),
					new Beat(58910, "J"),
					new Beat(59170, "Space"),
					new Beat(59670, "K"),
					new Beat(60230, "D"),
					new Beat(60720, "S"),
					new Beat(60990, "D"),
					new Beat(61260, "F"),
					new Beat(61840, "J"),
					new Beat(62360, "K"),
					new Beat(63130, "L"),
					new Beat(63890, "Space"),
					new Beat(64410, "J"),
					new Beat(64430, "L"),
					new Beat(64430, "F"),
					new Beat(64430, "S"),
					new Beat(65560, "K"),
					new Beat(65560, "D"),
					new Beat(66580, "F"),
					new Beat(66600, "J"),
					new Beat(67800, "S"),
					new Beat(67800, "L"),
					new Beat(69380, "D"),
					new Beat(69620, "J"),
					new Beat(69880, "K"),
					new Beat(70410, "S"),
					new Beat(70960, "D"),
					new Beat(70960, "F"),
					new Beat(71520, "L"),
					new Beat(71730, "K"),
					new Beat(72240, "F"),
					new Beat(72500, "J"),
					new Beat(73010, "J"),
					new Beat(73010, "K"),
					new Beat(73250, "D"),
					new Beat(73490, "S"),
					new Beat(73740, "F"),
					new Beat(73980, "J"),
					new Beat(73990, "L"),
					new Beat(74510, "D"),
					new Beat(75040, "K"),
					new Beat(75580, "Space"),
					new Beat(75810, "J"),
					new Beat(76330, "F"),
					new Beat(76590, "J"),
					new Beat(77050, "Space"),
					new Beat(77340, "Space"),
					new Beat(77610, "Space"),
					new Beat(77870, "Space"),
					new Beat(78090, "L"),
					new Beat(78610, "K"),
					new Beat(79160, "D"),
					new Beat(79680, "S"),
					new Beat(79970, "F"),
					new Beat(80480, "D"),
					new Beat(80720, "F"),
					new Beat(81240, "K"),
					new Beat(81470, "K"),
					new Beat(81730, "K"),
					new Beat(81970, "K"),
					new Beat(82220, "L"),
					new Beat(82770, "J"),
					new Beat(83290, "F"),
					new Beat(83850, "Space"),
					new Beat(84070, "J"),
					new Beat(84610, "D"),
					new Beat(84840, "S"),
					new Beat(85370, "F"),
					new Beat(85620, "K"),
					new Beat(85890, "D"),
					new Beat(86410, "L"),
					new Beat(86710, "K"),
					new Beat(86950, "F"),
					new Beat(87510, "J"),
					new Beat(87750, "S"),
					new Beat(88020, "S"),
					new Beat(88260, "D"),
					new Beat(88830, "Space"),
					new Beat(89090, "K"),
					new Beat(89610, "Space"),
					new Beat(90080, "J"),
					new Beat(90600, "L"),
					new Beat(91100, "S"),
					new Beat(91660, "D"),
					new Beat(91910, "D"),
					new Beat(92190, "F"),
					new Beat(92440, "K"),
					new Beat(92990, "Space"),
					new Beat(93230, "J"),
					new Beat(93730, "D"),
					new Beat(93950, "L"),
					new Beat(94230, "S"),
					new Beat(94760, "F"),
					new Beat(94990, "F"),
					new Beat(95260, "K"),
					new Beat(95770, "D"),
					new Beat(96060, "F"),
					new Beat(96320, "Space"),
					new Beat(96590, "J"),
					new Beat(96890, "K"),
					new Beat(97350, "L"),
					new Beat(97870, "L"),
					new Beat(97890, "J"),
					new Beat(97890, "S"),
					new Beat(97890, "F"),
					new Beat(98410, "D"),
					new Beat(98650, "F"),
					new Beat(98950, "Space"),
					new Beat(99490, "K"),
					new Beat(99970, "L"),
					new Beat(100760, "L"),
					new Beat(100760, "J"),
					new Beat(100780, "S"),
					new Beat(100780, "F"),
					new Beat(101590, "K"),
					new Beat(101600, "D"),
					new Beat(102090, "Space"),
					new Beat(102090, "S"),
					new Beat(102090, "L"),
					new Beat(103240, "L"),
					new Beat(103240, "F"),
					new Beat(103240, "J"),
					new Beat(103240, "S"),
					new Beat(104340, "Space"),
					new Beat(104340, "D"),
					new Beat(104340, "K")
					
			};
		}
		
		else if(titleName.equals("Temple of Time") && difficulty.equals("Easy")) {
			//int startTime = 1000;
			beats = new Beat[] {
					new Beat(9420, "S"),
					new Beat(10030, "D"),
					new Beat(10700, "K"),
					new Beat(11280, "J"),
					new Beat(11940, "D"),
					new Beat(12530, "F"),
					new Beat(13180, "L"),
					new Beat(14460, "S"),
					new Beat(15030, "J"),
					new Beat(15630, "K"),
					new Beat(16240, "L"),
					new Beat(16860, "J"),
					new Beat(17470, "L"),
					new Beat(18080, "J"),
					new Beat(19340, "D"),
					new Beat(19940, "K"),
					new Beat(20530, "F"),
					new Beat(21180, "J"),
					new Beat(21790, "J"),
					new Beat(22380, "F"),
					new Beat(23010, "J"),
					new Beat(24300, "Space"),
					new Beat(24910, "L"),
					new Beat(25510, "S"),
					new Beat(26090, "S"),
					new Beat(26730, "D"),
					new Beat(29190, "F"),
					new Beat(29890, "K"),
					new Beat(30550, "S"),
					new Beat(31140, "J"),
					new Beat(31780, "L"),
					new Beat(32040, "D"),
					new Beat(32330, "K"),
					new Beat(32630, "F"),
					new Beat(34190, "D"),
					new Beat(34800, "J"),
					new Beat(35440, "S"),
					new Beat(36070, "K"),
					new Beat(36680, "D"),
					new Beat(36970, "J"),
					new Beat(37280, "S"),
					new Beat(37600, "K"),
					new Beat(37910, "F"),
					new Beat(39110, "D"),
					new Beat(39790, "K"),
					new Beat(40410, "K"),
					new Beat(41010, "D"),
					new Beat(41630, "S"),
					new Beat(41930, "F"),
					new Beat(42260, "J"),
					new Beat(42560, "L"),
					new Beat(42860, "D"),
					new Beat(42860, "K"),
					new Beat(44080, "F"),
					new Beat(44710, "Space"),
					new Beat(45310, "J"),
					new Beat(48990, "S"),
					new Beat(51490, "L"),
					new Beat(52090, "J"),
					new Beat(52710, "D"),
					new Beat(53990, "K"),
					new Beat(56460, "S"),
					new Beat(57070, "F"),
					new Beat(57670, "D"),
					new Beat(59000, "D"),
					new Beat(59570, "K"),
					new Beat(60210, "Space"),
					new Beat(61440, "F"),
					new Beat(61440, "S"),
					new Beat(61450, "J"),
					new Beat(61450, "L"),
					new Beat(62070, "K"),
					new Beat(62090, "D"),
					new Beat(62740, "J"),
					new Beat(62740, "Space"),
					new Beat(62760, "F"),
					new Beat(63890, "S"),
					new Beat(64810, "D"),
					new Beat(68830, "D"),
					new Beat(69490, "K"),
					new Beat(70140, "L"),
					new Beat(70740, "J"),
					new Beat(71360, "D"),
					new Beat(71660, "F"),
					new Beat(71970, "D"),
					new Beat(72300, "S"),
					new Beat(73790, "K"),
					new Beat(74440, "D"),
					new Beat(75040, "J"),
					new Beat(75650, "F"),
					new Beat(76320, "L"),
					new Beat(76610, "K"),
					new Beat(76890, "J"),
					new Beat(77210, "K"),
					new Beat(77500, "L"),
					new Beat(78780, "J"),
					new Beat(78780, "F"),
					new Beat(78790, "L"),
					new Beat(78800, "S"),
					new Beat(79420, "K"),
					new Beat(79450, "D"),
					new Beat(80040, "S"),
					new Beat(80040, "F"),
					new Beat(80040, "J"),
					new Beat(80060, "L"),
					new Beat(80640, "K"),
					new Beat(80660, "D"),
					new Beat(81240, "S"),
					new Beat(81520, "F"),
					new Beat(81860, "J"),
					new Beat(82200, "L"),
					new Beat(82510, "K"),
					new Beat(83090, "D"),
					new Beat(83360, "F"),
					new Beat(83680, "K"),
					new Beat(84320, "L"),
					new Beat(84920, "J"),
					new Beat(84920, "L"),
					new Beat(85540, "S"),
					new Beat(86170, "S"),
					new Beat(86170, "F"),
					new Beat(88600, "D"),
					new Beat(89220, "K"),
					new Beat(89890, "S"),
					new Beat(90500, "J"),
					new Beat(91110, "S"),
					new Beat(91420, "D"),
					new Beat(91740, "F"),
					new Beat(92040, "J"),
					new Beat(93620, "L"),
					new Beat(94270, "J"),
					new Beat(94870, "L"),
					new Beat(95410, "J"),
					new Beat(96090, "K"),
					new Beat(96350, "D"),
					new Beat(96710, "J"),
					new Beat(96970, "F"),
					new Beat(97320, "L"),
					new Beat(98540, "D"),
					new Beat(99250, "Space"),
					new Beat(99820, "K"),
					new Beat(100400, "Space"),
					new Beat(101040, "S"),
					new Beat(101370, "F"),
					new Beat(101680, "J"),
					new Beat(102000, "L"),
					new Beat(102280, "K"),
					new Beat(102300, "D"),
					new Beat(102880, "F"),
					new Beat(103150, "J"),
					new Beat(103490, "K"),
					new Beat(104170, "S"),
					new Beat(104750, "D"),
					new Beat(105340, "F"),
					new Beat(105980, "J"),
					new Beat(105990, "L"),
					new Beat(105990, "F"),
					new Beat(106010, "S"),
					new Beat(118370, "S"),
					new Beat(119530, "F"),
					new Beat(120820, "J"),
					new Beat(122030, "L"),
					new Beat(123330, "K"),
					new Beat(123920, "D"),
					new Beat(124720, "J"),
					new Beat(125570, "F")
					
			};
		}
		else if(titleName.equals("Temple of Time") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(8860, "S"),
					new Beat(9040, "D"),
					new Beat(9170, "F"),
					new Beat(9290, "Space"),
					new Beat(9490, "K"),
					new Beat(9790, "D"),
					new Beat(10090, "K"),
					new Beat(10370, "F"),
					new Beat(10690, "J"),
					new Beat(10990, "S"),
					new Beat(11320, "Space"),
					new Beat(11610, "L"),
					new Beat(11940, "F"),
					new Beat(12240, "K"),
					new Beat(12620, "D"),
					new Beat(12870, "K"),
					new Beat(13160, "Space"),
					new Beat(14430, "S"),
					new Beat(14700, "J"),
					new Beat(15050, "D"),
					new Beat(15290, "K"),
					new Beat(15630, "F"),
					new Beat(15970, "L"),
					new Beat(16270, "Space"),
					new Beat(16540, "K"),
					new Beat(16900, "D"),
					new Beat(17170, "K"),
					new Beat(17470, "D"),
					new Beat(17790, "K"),
					new Beat(18140, "Space"),
					new Beat(19390, "S"),
					new Beat(19650, "J"),
					new Beat(19950, "F"),
					new Beat(20270, "L"),
					new Beat(20550, "D"),
					new Beat(20890, "K"),
					new Beat(21170, "Space"),
					new Beat(21480, "F"),
					new Beat(21770, "K"),
					new Beat(22100, "J"),
					new Beat(22390, "S"),
					new Beat(22720, "J"),
					new Beat(23040, "Space"),
					new Beat(24310, "L"),
					new Beat(24590, "F"),
					new Beat(24900, "K"),
					new Beat(25170, "D"),
					new Beat(25490, "L"),
					new Beat(25840, "J"),
					new Beat(26180, "D"),
					new Beat(26450, "S"),
					new Beat(26770, "Space"),
					new Beat(29200, "D"),
					new Beat(29550, "K"),
					new Beat(29890, "F"),
					new Beat(30560, "J"),
					new Beat(30850, "L"),
					new Beat(31170, "S"),
					new Beat(31770, "D"),
					new Beat(32070, "F"),
					new Beat(32370, "Space"),
					new Beat(32660, "J"),
					new Beat(32990, "K"),
					new Beat(34180, "S"),
					new Beat(34790, "F"),
					new Beat(35450, "L"),
					new Beat(36010, "J"),
					new Beat(36690, "K"),
					new Beat(36980, "D"),
					new Beat(37320, "J"),
					new Beat(37550, "F"),
					new Beat(37910, "Space"),
					new Beat(39150, "S"),
					new Beat(39450, "D"),
					new Beat(39770, "F"),
					new Beat(40440, "J"),
					new Beat(40740, "K"),
					new Beat(41040, "L"),
					new Beat(41690, "S"),
					new Beat(41950, "L"),
					new Beat(42270, "D"),
					new Beat(42570, "K"),
					new Beat(42910, "Space"),
					new Beat(44130, "F"),
					new Beat(44740, "J"),
					new Beat(45320, "Space"),
					new Beat(46590, "J"),
					new Beat(46590, "F"),
					new Beat(46590, "L"),
					new Beat(46610, "S"),
					new Beat(49020, "S"),
					new Beat(49340, "F"),
					new Beat(49620, "J"),
					new Beat(49920, "L"),
					new Beat(50580, "D"),
					new Beat(50900, "K"),
					new Beat(51230, "F"),
					new Beat(51490, "Space"),
					new Beat(51820, "J"),
					new Beat(52140, "K"),
					new Beat(52440, "L"),
					new Beat(52740, "S"),
					new Beat(53370, "F"),
					new Beat(53530, "K"),
					new Beat(53620, "D"),
					new Beat(53760, "K"),
					new Beat(53920, "F"),
					new Beat(54250, "J"),
					new Beat(54540, "Space"),
					new Beat(54820, "F"),
					new Beat(55570, "K"),
					new Beat(56230, "D"),
					new Beat(56500, "S"),
					new Beat(56750, "F"),
					new Beat(57100, "L"),
					new Beat(57390, "J"),
					new Beat(57700, "K"),
					new Beat(58370, "D"),
					new Beat(59000, "Space"),
					new Beat(59300, "J"),
					new Beat(59590, "F"),
					new Beat(59900, "S"),
					new Beat(59900, "L"),
					new Beat(60620, "D"),
					new Beat(61170, "K"),
					new Beat(61430, "J"),
					new Beat(61450, "F"),
					new Beat(62080, "K"),
					new Beat(62100, "D"),
					new Beat(62700, "S"),
					new Beat(62710, "L"),
					new Beat(63950, "Space"),
					new Beat(64240, "F"),
					new Beat(64530, "J"),
					new Beat(64850, "D"),
					new Beat(64870, "K"),
					new Beat(65570, "S"),
					new Beat(65850, "F"),
					new Beat(66120, "K"),
					new Beat(66360, "L"),
					new Beat(68230, "S"),
					new Beat(68430, "K"),
					new Beat(68500, "D"),
					new Beat(68660, "J"),
					new Beat(68850, "F"),
					new Beat(69140, "Space"),
					new Beat(69500, "J"),
					new Beat(69780, "S"),
					new Beat(70120, "L"),
					new Beat(70400, "D"),
					new Beat(70740, "K"),
					new Beat(71010, "F"),
					new Beat(71350, "J"),
					new Beat(71600, "S"),
					new Beat(71950, "D"),
					new Beat(72270, "F"),
					new Beat(72590, "Space"),
					new Beat(73800, "L"),
					new Beat(73830, "F"),
					new Beat(73830, "J"),
					new Beat(73830, "S"),
					new Beat(74450, "K"),
					new Beat(74470, "D"),
					new Beat(75080, "J"),
					new Beat(75080, "F"),
					new Beat(75690, "L"),
					new Beat(75700, "S"),
					new Beat(76250, "D"),
					new Beat(76580, "F"),
					new Beat(76900, "J"),
					new Beat(77170, "K"),
					new Beat(77500, "L"),
					new Beat(78160, "D"),
					new Beat(78790, "Space"),
					new Beat(78790, "K"),
					new Beat(79400, "J"),
					new Beat(80020, "S"),
					new Beat(80620, "F"),
					new Beat(81230, "J"),
					new Beat(81250, "L"),
					new Beat(81530, "D"),
					new Beat(81830, "K"),
					new Beat(82150, "Space"),
					new Beat(82470, "F"),
					new Beat(82490, "J"),
					new Beat(83100, "D"),
					new Beat(83380, "S"),
					new Beat(83680, "L"),
					new Beat(84350, "K"),
					new Beat(84920, "J"),
					new Beat(85530, "F"),
					new Beat(86180, "D"),
					new Beat(88660, "S"),
					new Beat(88930, "J"),
					new Beat(89240, "F"),
					new Beat(89560, "K"),
					new Beat(89860, "D"),
					new Beat(90170, "L"),
					new Beat(90510, "F"),
					new Beat(90820, "J"),
					new Beat(91110, "S"),
					new Beat(91420, "D"),
					new Beat(91740, "F"),
					new Beat(92070, "Space"),
					new Beat(92380, "J"),
					new Beat(92680, "K"),
					new Beat(93000, "L"),
					new Beat(93660, "S"),
					new Beat(93950, "J"),
					new Beat(94280, "F"),
					new Beat(94580, "K"),
					new Beat(94900, "L"),
					new Beat(95210, "F"),
					new Beat(95480, "K"),
					new Beat(95760, "D"),
					new Beat(96100, "Space"),
					new Beat(96360, "S"),
					new Beat(96720, "D"),
					new Beat(97010, "F"),
					new Beat(97350, "Space"),
					new Beat(98550, "F"),
					new Beat(98560, "L"),
					new Beat(98560, "S"),
					new Beat(98560, "J"),
					new Beat(99230, "K"),
					new Beat(99260, "D"),
					new Beat(99830, "Space"),
					new Beat(99840, "J"),
					new Beat(99850, "F"),
					new Beat(100450, "D"),
					new Beat(100450, "K"),
					new Beat(101060, "S"),
					new Beat(101360, "F"),
					new Beat(101670, "J"),
					new Beat(101980, "L"),
					new Beat(102240, "Space"),
					new Beat(102910, "S"),
					new Beat(103180, "F"),
					new Beat(103510, "K"),
					new Beat(104150, "D"),
					new Beat(104770, "J"),
					new Beat(105330, "F"),
					new Beat(105970, "J"),
					new Beat(106020, "K"),
					new Beat(106070, "L"),
					new Beat(108620, "S"),
					new Beat(109700, "F"),
					new Beat(110880, "J"),
					new Beat(112150, "L"),
					new Beat(113410, "D"),
					new Beat(114640, "K"),
					new Beat(115850, "F"),
					new Beat(116470, "Space"),
					new Beat(117060, "J"),
					new Beat(118360, "S"),
					new Beat(118670, "D"),
					new Beat(118970, "F"),
					new Beat(119260, "K"),
					new Beat(119570, "D"),
					new Beat(119850, "L"),
					new Beat(120140, "F"),
					new Beat(120470, "K"),
					new Beat(120820, "J"),
					new Beat(121110, "D"),
					new Beat(121430, "J"),
					new Beat(121730, "S"),
					new Beat(122020, "L"),
					new Beat(122040, "F"),
					new Beat(122040, "S"),
					new Beat(122040, "J"),
					new Beat(123290, "D"),
					new Beat(123570, "K"),
					new Beat(123980, "D"),
					new Beat(124300, "K"),
					new Beat(124710, "F"),
					new Beat(125090, "J"),
					new Beat(125520, "L"),
					new Beat(125930, "K")
			};
		}
		else if(titleName.equals("The Cygnus Garden") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					
					
			};
		}
		else if(titleName.equals("The Cygnus Garden") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					
			};
		}
		
		else if(titleName.equals("Shattered Time") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					
					

					
					
			};
		}
		else if(titleName.equals("Shattered Time") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					
			};
		}
		
		else if(titleName.equals("The Tune of The Azure Light") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					
					
			};
		}
		else if(titleName.equals("The Tune of the Azure Light") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					
			};
		}
		else if(titleName.equals("Kamado Tanjiro No Uta") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					
					
					
			};
		}
		else if(titleName.equals("Kamado Tanjiro No Uta") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(3290, "S"),
					new Beat(3550, "D"),
					new Beat(3820, "F"),
					new Beat(4820, "K"),
					new Beat(5760, "L"),
					new Beat(5760, "J"),
					new Beat(7380, "K"),
					new Beat(7640, "D"),
					new Beat(7880, "L"),
					new Beat(8860, "L"),
					new Beat(8880, "J"),
					new Beat(9800, "F"),
					new Beat(11440, "K"),
					new Beat(11700, "D"),
					new Beat(11990, "S"),
					new Beat(12910, "J"),
					new Beat(13920, "L"),
					new Beat(14960, "D"),
					new Beat(14960, "Space"),
					new Beat(14960, "K"),
					new Beat(15490, "S"),
					new Beat(15730, "F"),
					new Beat(16030, "K"),
					new Beat(16480, "J"),
					new Beat(16950, "S"),
					new Beat(17390, "D"),
					new Beat(17920, "J"),
					new Beat(18390, "F"),
					new Beat(18890, "L"),
					new Beat(19830, "S"),
					new Beat(20240, "D"),
					new Beat(20730, "K"),
					new Beat(21680, "L"),
					new Beat(22170, "J"),
					new Beat(22670, "K"),
					new Beat(23650, "Space"),
					new Beat(24040, "F"),
					new Beat(24540, "K"),
					new Beat(25480, "Space"),
					new Beat(25920, "J"),
					new Beat(26490, "S"),
					new Beat(27550, "D"),
					new Beat(28530, "J"),
					new Beat(29450, "K"),
					new Beat(30560, "L"),
					new Beat(31080, "S"),
					new Beat(31340, "D"),
					new Beat(31660, "F"),
					new Beat(32620, "K"),
					new Beat(33570, "F"),
					new Beat(33590, "S"),
					new Beat(33590, "J"),
					new Beat(33590, "L"),
					new Beat(35060, "D"),
					new Beat(35690, "J"),
					new Beat(36630, "Space"),
					new Beat(37560, "S"),
					new Beat(38000, "F"),
					new Beat(38460, "D"),
					new Beat(38950, "Space"),
					new Beat(39480, "L"),
					new Beat(39970, "J"),
					new Beat(40460, "K"),
					new Beat(41530, "F"),
					new Beat(41550, "S"),
					new Beat(42560, "K"),
					new Beat(43090, "D"),
					new Beat(43600, "S"),
					new Beat(43600, "L"),
					new Beat(43600, "F"),
					new Beat(43600, "J"),
					new Beat(45580, "L"),
					new Beat(46020, "K"),
					new Beat(46560, "J"),
					new Beat(47010, "Space"),
					new Beat(47540, "L"),
					new Beat(47980, "K"),
					new Beat(48520, "J"),
					new Beat(49080, "Space"),
					new Beat(49580, "L"),
					new Beat(50000, "K"),
					new Beat(50520, "J"),
					new Beat(51040, "Space"),
					new Beat(51780, "S"),
					new Beat(52310, "D"),
					new Beat(52560, "K"),
					new Beat(52820, "F"),
					new Beat(53010, "J"),
					new Beat(53270, "S"),
					new Beat(53410, "L"),
					new Beat(53610, "D"),
					new Beat(53830, "K"),
					new Beat(53950, "F"),
					new Beat(54140, "J"),
					new Beat(54310, "Space"),
					new Beat(54490, "K"),
					new Beat(54700, "D"),
					new Beat(54890, "L"),
					new Beat(55170, "S"),
					new Beat(55400, "J"),
					new Beat(55740, "D"),
					new Beat(56070, "K"),
					new Beat(56330, "F"),
					new Beat(56620, "L"),
					new Beat(56820, "S"),
					new Beat(57110, "J"),
					new Beat(57300, "S"),
					new Beat(57500, "J"),
					new Beat(57710, "D"),
					new Beat(57940, "K"),
					new Beat(58110, "F"),
					new Beat(58370, "L"),
					new Beat(58580, "Space"),
					new Beat(58790, "J"),
					new Beat(59020, "Space"),
					new Beat(59390, "J"),
					new Beat(59800, "S"),
					new Beat(59980, "D"),
					new Beat(60230, "F"),
					new Beat(60470, "Space"),
					new Beat(60760, "L"),
					new Beat(60950, "S"),
					new Beat(61160, "K"),
					new Beat(61380, "D"),
					new Beat(61630, "J"),
					new Beat(61800, "F"),
					new Beat(62070, "K"),
					new Beat(62280, "D"),
					new Beat(62780, "S"),
					new Beat(62980, "L"),
					new Beat(63210, "F"),
					new Beat(63430, "J"),
					new Beat(63450, "L"),
					new Beat(63680, "D"),
					new Beat(63960, "K"),
					new Beat(64280, "F"),
					new Beat(64490, "J"),
					new Beat(64670, "Space"),
					new Beat(64910, "K"),
					new Beat(65110, "S"),
					new Beat(65360, "J"),
					new Beat(65600, "Space"),
					new Beat(65870, "K"),
					new Beat(66160, "D"),
					new Beat(66420, "J"),
					new Beat(66680, "F"),
					new Beat(66880, "J"),
					new Beat(67160, "F"),
					new Beat(67470, "D"),
					new Beat(67490, "Space"),
					new Beat(68060, "S"),
					new Beat(68310, "K"),
					new Beat(68590, "D"),
					new Beat(68970, "F"),
					new Beat(69280, "J"),
					new Beat(69490, "D"),
					new Beat(69730, "K"),
					new Beat(69910, "S"),
					new Beat(70100, "L"),
					new Beat(70380, "F"),
					new Beat(70620, "K"),
					new Beat(70830, "D"),
					new Beat(71100, "J"),
					new Beat(71330, "Space"),
					new Beat(71610, "L"),
					new Beat(71880, "S"),
					new Beat(72120, "K"),
					new Beat(72340, "D"),
					new Beat(72560, "J"),
					new Beat(72780, "F"),
					new Beat(73060, "D"),
					new Beat(73460, "S"),
					new Beat(73690, "D"),
					new Beat(73920, "F"),
					new Beat(74390, "D"),
					new Beat(75180, "D"),
					new Beat(75880, "S"),
					new Beat(76090, "J"),
					new Beat(76330, "F"),
					new Beat(76610, "K"),
					new Beat(76770, "D"),
					new Beat(76980, "L"),
					new Beat(77210, "F"),
					new Beat(77660, "D"),
					new Beat(77840, "K"),
					new Beat(78030, "S"),
					new Beat(78540, "J"),
					new Beat(78780, "J"),
					new Beat(79010, "F"),
					new Beat(79730, "K"),
					new Beat(80020, "L"),
					new Beat(80220, "D"),
					new Beat(80460, "K"),
					new Beat(80660, "F"),
					new Beat(80870, "J"),
					new Beat(81110, "S"),
					new Beat(81570, "D"),
					new Beat(82040, "F"),
					new Beat(82500, "J"),
					new Beat(83010, "Space"),
					new Beat(84050, "J"),
					new Beat(84050, "L"),
					new Beat(84910, "D"),
					new Beat(85350, "F"),
					new Beat(85830, "K"),
					new Beat(86340, "S"),
					new Beat(87050, "D"),
					new Beat(88430, "F"),
					new Beat(89340, "Space"),
					new Beat(89880, "J"),
					new Beat(90340, "D"),
					new Beat(90870, "S"),
					new Beat(90870, "F"),
					new Beat(90870, "J"),
					new Beat(90870, "L"),
					new Beat(94950, "D"),
					new Beat(99120, "S"),
					new Beat(99720, "J"),
					new Beat(100010, "Space"),
					new Beat(100220, "K"),
					new Beat(100410, "D"),
					new Beat(100610, "L"),
					new Beat(100780, "F"),
					new Beat(101070, "Space"),
					new Beat(101280, "J"),
					new Beat(101470, "D"),
					new Beat(101710, "K"),
					new Beat(101940, "S"),
					new Beat(102110, "L"),
					new Beat(102470, "D"),
					new Beat(102960, "Space"),
					new Beat(103180, "J"),
					new Beat(103460, "S"),
					new Beat(103670, "K"),
					new Beat(103940, "F"),
					new Beat(104420, "D"),
					new Beat(104670, "K"),
					new Beat(104910, "F"),
					new Beat(105080, "J"),
					new Beat(105290, "S"),
					new Beat(105470, "L"),
					new Beat(105730, "D"),
					new Beat(105940, "K"),
					new Beat(106210, "Space"),
					new Beat(106540, "S"),
					new Beat(106770, "D"),
					new Beat(107060, "K"),
					new Beat(107240, "F"),
					new Beat(107490, "J"),
					new Beat(107760, "S"),
					new Beat(107970, "L"),
					new Beat(108160, "D"),
					new Beat(108420, "K"),
					new Beat(108630, "F"),
					new Beat(108810, "Space"),
					new Beat(109110, "D"),
					new Beat(109540, "F"),
					new Beat(109770, "J"),
					new Beat(110020, "Space"),
					new Beat(110220, "K"),
					new Beat(110470, "Space"),
					new Beat(110750, "L"),
					new Beat(111020, "S"),
					new Beat(111290, "K"),
					new Beat(111460, "D"),
					new Beat(111780, "Space"),
					new Beat(112010, "Space"),
					new Beat(112230, "J"),
					new Beat(112400, "F"),
					new Beat(112590, "K"),
					new Beat(112840, "D"),
					new Beat(113200, "J"),
					new Beat(113420, "D"),
					new Beat(113620, "J"),
					new Beat(113850, "S"),
					new Beat(114180, "K"),
					new Beat(114470, "D"),
					new Beat(114750, "L"),
					new Beat(114940, "Space"),
					new Beat(115200, "J"),
					new Beat(115370, "D"),
					new Beat(115610, "K"),
					new Beat(115780, "F"),
					new Beat(116220, "D"),
					new Beat(116660, "S"),
					new Beat(117120, "F"),
					new Beat(117590, "K"),
					new Beat(118040, "F"),
					new Beat(118400, "J"),
					new Beat(118900, "D"),
					new Beat(119370, "L"),
					new Beat(119580, "J"),
					new Beat(120050, "D"),
					new Beat(120240, "K"),
					new Beat(120470, "Space"),
					new Beat(120700, "S"),
					new Beat(121140, "D"),
					new Beat(121600, "F"),
					new Beat(122500, "J"),
					new Beat(122950, "K"),
					new Beat(123400, "K"),
					new Beat(123880, "D"),
					new Beat(124290, "J"),
					new Beat(124720, "S"),
					new Beat(125140, "S"),
					new Beat(125140, "J"),
					new Beat(125140, "L"),
					new Beat(125160, "F"),
					new Beat(126050, "D"),
					new Beat(126520, "F"),
					new Beat(126700, "K"),
					new Beat(126940, "Space"),
					new Beat(127370, "J"),
					new Beat(127570, "S"),
					new Beat(128070, "Space"),
					new Beat(128290, "D"),
					new Beat(128490, "K"),
					new Beat(128710, "F"),
					new Beat(129160, "J"),
					new Beat(129660, "F"),
					new Beat(130070, "S"),
					new Beat(130520, "D"),
					new Beat(130980, "F"),
					new Beat(131400, "F"),
					new Beat(131810, "D"),
					new Beat(132270, "L"),
					new Beat(132720, "K"),
					new Beat(133140, "F"),
					new Beat(133590, "L"),
					new Beat(133820, "K"),
					new Beat(134290, "D"),
					new Beat(134460, "J"),
					new Beat(134620, "S"),
					new Beat(135150, "K"),
					new Beat(135350, "F"),
					new Beat(135590, "L"),
					new Beat(135790, "D"),
					new Beat(136230, "S"),
					new Beat(136490, "F"),
					new Beat(136680, "D"),
					new Beat(137140, "L"),
					new Beat(137370, "K"),
					new Beat(137570, "J"),
					new Beat(138000, "S"),
					new Beat(138200, "F"),
					new Beat(138460, "D"),
					new Beat(138930, "L"),
					new Beat(139140, "J"),
					new Beat(139370, "K"),
					new Beat(139730, "S"),
					new Beat(139970, "F"),
					new Beat(140200, "D"),
					new Beat(140620, "J"),
					new Beat(140790, "D"),
					new Beat(140990, "K"),
					new Beat(141500, "L"),
					new Beat(141970, "S"),
					new Beat(142530, "L"),
					new Beat(142530, "J"),
					new Beat(143070, "D"),
					new Beat(143080, "K"),
					new Beat(143480, "F"),
					new Beat(143670, "J"),
					new Beat(143940, "S"),
					new Beat(144150, "K"),
					new Beat(144350, "D"),
					new Beat(144520, "L"),
					new Beat(144700, "F"),
					new Beat(144920, "J"),
					new Beat(145090, "S"),
					new Beat(145280, "K"),
					new Beat(145600, "D"),
					new Beat(146020, "Space"),
					new Beat(146220, "Space"),
					new Beat(146500, "D"),
					new Beat(146900, "F"),
					new Beat(147370, "J"),
					new Beat(147810, "K"),
					new Beat(148030, "L"),
					new Beat(148290, "S"),
					new Beat(148780, "D"),
					new Beat(149270, "F"),
					new Beat(149730, "J"),
					new Beat(149750, "L"),
					new Beat(149750, "F"),
					new Beat(149770, "S"),
					new Beat(150340, "Space"),
					new Beat(150360, "K"),
					new Beat(150370, "D"),
					new Beat(150990, "F"),
					new Beat(151180, "J"),
					new Beat(151440, "S"),
					new Beat(151650, "K"),
					new Beat(151850, "D"),
					new Beat(152040, "L"),
					new Beat(152530, "D"),
					new Beat(152750, "J"),
					new Beat(152970, "F"),
					new Beat(153190, "K"),
					new Beat(153370, "D"),
					new Beat(153650, "J"),
					new Beat(154120, "J"),
					new Beat(154120, "Space"),
					new Beat(154120, "S"),
					new Beat(154140, "F"),
					new Beat(154540, "L"),
					new Beat(154760, "F"),
					new Beat(155020, "K"),
					new Beat(155430, "D"),
					new Beat(155480, "L"),
					new Beat(155480, "J"),
					new Beat(155670, "J"),
					new Beat(155690, "F"),
					new Beat(156220, "D"),
					new Beat(156730, "S"),
					new Beat(157230, "S"),
					new Beat(157230, "F"),
					new Beat(157250, "J"),
					new Beat(157250, "L"),
					new Beat(157470, "D"),
					new Beat(157520, "K"),
					new Beat(157720, "Space"),
					new Beat(158120, "D"),
					new Beat(158620, "S"),
					new Beat(159050, "F"),
					new Beat(159230, "J"),
					new Beat(159520, "D"),
					new Beat(159940, "K"),
					new Beat(160370, "F"),
					new Beat(160820, "F"),
					new Beat(161030, "S"),
					new Beat(161300, "F"),
					new Beat(161370, "J"),
					new Beat(161370, "L"),
					new Beat(161750, "D"),
					new Beat(162170, "L"),
					new Beat(162170, "J"),
					new Beat(162580, "D"),
					new Beat(162790, "F"),
					new Beat(163050, "Space"),
					new Beat(163470, "S"),
					new Beat(163930, "J"),
					new Beat(163940, "L"),
					new Beat(163940, "K"),
					new Beat(164380, "D"),
					new Beat(164550, "F"),
					new Beat(164840, "Space"),
					new Beat(164840, "J"),
					new Beat(164840, "L"),
					new Beat(164840, "K"),
					new Beat(164840, "S"),
					new Beat(164860, "F"),
					new Beat(165300, "S"),
					new Beat(165720, "S"),
					new Beat(165980, "F"),
					new Beat(166150, "D"),
					new Beat(166620, "K"),
					new Beat(166980, "F"),
					new Beat(167430, "J"),
					new Beat(167840, "S"),
					new Beat(168290, "S"),
					new Beat(168290, "F"),
					new Beat(168300, "J"),
					new Beat(168300, "L"),
					new Beat(168310, "Space"),
					new Beat(168700, "K"),
					new Beat(168700, "D"),
					new Beat(169130, "J"),
					new Beat(169140, "Space"),
					new Beat(169140, "F"),
					new Beat(169580, "K"),
					new Beat(169580, "D"),
					new Beat(169770, "S"),
					new Beat(169770, "L"),
					new Beat(170240, "J"),
					new Beat(170240, "F"),
					new Beat(170430, "D"),
					new Beat(170440, "K"),
					new Beat(170670, "L"),
					new Beat(170670, "S"),
					new Beat(170890, "K"),
					new Beat(170910, "D"),
					new Beat(171100, "F"),
					new Beat(171100, "J"),
					new Beat(171310, "Space"),
					new Beat(171550, "D"),
					new Beat(171570, "K"),
					new Beat(171780, "S"),
					new Beat(171780, "L"),
					new Beat(172010, "F"),
					new Beat(172200, "D"),
					new Beat(172690, "S"),
					new Beat(172890, "D"),
					new Beat(173100, "F"),
					new Beat(173590, "Space"),
					new Beat(173980, "K"),
					new Beat(174440, "J"),
					new Beat(174830, "D"),
					new Beat(175030, "F"),
					new Beat(175260, "S"),
					new Beat(176150, "F"),
					new Beat(176600, "Space"),
					new Beat(177900, "Space"),
					new Beat(178800, "S"),
					new Beat(178810, "F"),
					new Beat(178810, "J"),
					new Beat(178830, "L"),
					new Beat(179690, "D"),
					new Beat(179710, "K"),
					new Beat(180600, "Space"),
					new Beat(182180, "S"),
					new Beat(182370, "D"),
					new Beat(182570, "F")
			};
		}
		
		
		
		int i = 0;
		gameMusic.start();
		
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			
			if(beats[i].getTime() <= gameMusic.getTime()) {
				//System.out.println("Music Start");
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			
				
			}
			////////////
			/*else
			{
				System.out.println("Music End");
				musicEnd = true;
			}*/
			if(!dropped) {
				try {
					Thread.sleep(5);
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		}
		System.out.println("Music End");
		musicEnd = true;
		
		assignScore();
		
	}
	
	public void judge(String input) {
		for(int i=0; i<noteList.size(); i++)
		{
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
		}
		if(judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
		}
		else if(judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
			theInt += 30;
		}
		else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
			theInt += 100;
		}
		else if(judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
			theInt += 200;
		}
		else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
			theInt += 300;
		}
		else if(judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
			theInt += 30;
		}
	}
	
	public boolean isMusicEnd() {
		return this.musicEnd;
	}
	
	public String getScore() {
		return this.scoreDetermined;
	}
	
	
	public void assignScore() {
		if(titleName.equals("Wild World") && difficulty.equals("Easy"))
		{
			if(theInt >= 25500)
			{
				scoreDetermined = "S";
			}
			else if(theInt >=23000)
			{
				scoreDetermined = "A";
			}
			else if(theInt >= 21000)
			{
				scoreDetermined = "B";
			}
			else
			{
				scoreDetermined = "C";
			}
		}
		else if(titleName.equals("Wild World") && difficulty.equals("Hard"))
		{
			if(theInt >= 58000)
			{
				scoreDetermined = "S";
			}
			else if(theInt >= 56000)
			{
				scoreDetermined = "A";
			}
			else if(theInt >= 54000)
			{
				scoreDetermined = "B";
			}
			else
			{
				scoreDetermined = "C";
			}
		}
		else if(titleName.equals("Temple of Time") && difficulty.equals("Easy"))
		{
			if(theInt >= 37500)
			{
				scoreDetermined = "S";
			}
			else if(theInt >=35500)
			{
				scoreDetermined = "A";
			}
			else if(theInt >= 33000)
			{
				scoreDetermined = "B";
			}
			else
			{
				scoreDetermined = "C";
			}
		}
		else if(titleName.equals("Temple of Time") && difficulty.equals("Hard"))
		{
			if(theInt >= 61000)
			{
				scoreDetermined = "S";
			}
			else if(theInt >=59500)
			{
				scoreDetermined = "A";
			}
			else if(theInt >= 57500)
			{
				scoreDetermined = "B";
			}
			else
			{
				scoreDetermined = "C";
			}
		}
		else if(titleName.equals("Energy-Bensound") && difficulty.equals("Easy"))
		{
			if(theInt >= 3000)
			{
				scoreDetermined = "S";
			}
			else if(theInt >=2000)
			{
				scoreDetermined = "A";
			}
			else if(theInt >= 1000)
			{
				scoreDetermined = "B";
			}
			else
			{
				scoreDetermined = "C";
			}
		}
		else if(titleName.equals("Energy-Bensound") && difficulty.equals("Hard"))
		{
			if(theInt >= 3000)
			{
				scoreDetermined = "S";
			}
			else if(theInt >=2000)
			{
				scoreDetermined = "A";
			}
			else if(theInt >= 1000)
			{
				scoreDetermined = "B";
			}
			else
			{
				scoreDetermined = "C";
			}
		}
		else if(titleName.equals("Memory of Kritias") && difficulty.equals("Easy"))
		{
			if(theInt >= 3000)
			{
				scoreDetermined = "S";
			}
			else if(theInt >=2000)
			{
				scoreDetermined = "A";
			}
			else if(theInt >= 1000)
			{
				scoreDetermined = "B";
			}
			else
			{
				scoreDetermined = "C";
			}
		}
		else if(titleName.equals("Memory of Kritias") && difficulty.equals("Hard"))
		{
			if(theInt >= 3000)
			{
				scoreDetermined = "S";
			}
			else if(theInt >=2000)
			{
				scoreDetermined = "A";
			}
			else if(theInt >= 1000)
			{
				scoreDetermined = "B";
			}
			else
			{
				scoreDetermined = "C";
			}
		}
		else if(titleName.equals("The Shattered Time") && difficulty.equals("Easy"))
		{
			if(theInt >= 3000)
			{
				scoreDetermined = "S";
			}
			else if(theInt >=2000)
			{
				scoreDetermined = "A";
			}
			else if(theInt >= 1000)
			{
				scoreDetermined = "B";
			}
			else
			{
				scoreDetermined = "C";
			}
		}
		else if(titleName.equals("The Shattered Time") && difficulty.equals("Hard"))
		{
			if(theInt >= 3000)
			{
				scoreDetermined = "S";
			}
			else if(theInt >=2000)
			{
				scoreDetermined = "A";
			}
			else if(theInt >= 1000)
			{
				scoreDetermined = "B";
			}
			else
			{
				scoreDetermined = "C";
			}
		}
		else if(titleName.equals("The Tune of the Azure Light") && difficulty.equals("Easy"))
		{
			if(theInt >= 3000)
			{
				scoreDetermined = "S";
			}
			else if(theInt >=2000)
			{
				scoreDetermined = "A";
			}
			else if(theInt >= 1000)
			{
				scoreDetermined = "B";
			}
			else
			{
				scoreDetermined = "C";
			}
		}
		else if(titleName.equals("The Tune of the Azure Light") && difficulty.equals("Hard"))
		{
			if(theInt >= 3000)
			{
				scoreDetermined = "S";
			}
			else if(theInt >=2000)
			{
				scoreDetermined = "A";
			}
			else if(theInt >= 1000)
			{
				scoreDetermined = "B";
			}
			else
			{
				scoreDetermined = "C";
			}
		}
		
		
	}
}
