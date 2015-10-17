package ce1002.FP.s101502014;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
public class Game99 extends JPanel implements ActionListener{
	private Play_man play_man = new Play_man(); 
	private Play_com[] play_com = new Play_com[5];
	
	private JLabel score = new JLabel("0");
	private JLabel background = new JLabel(new ImageIcon("card/table.jpg"));
	private JLabel direction = new JLabel(new ImageIcon("card/clockwise.jpg"));
	
	private JButton[] p_card = new JButton[5];
	private JLabel[] com1_card = new JLabel[5];
	private JLabel[] com2_card = new JLabel[5];
	private JLabel[] com3_card = new JLabel[5];
	private JLabel[] com4_card = new JLabel[5];
	
	private JLabel[] name = new JLabel[5];
	
	private JLabel[] draw = new JLabel[5];
	
	private String play_name;
	public Game99() {
		setLayout(null);
		setBounds(0 , 0 , 800 , 800);
	}
	public void show() {
		play_name = JOptionPane.showInputDialog(null , "請輸入你的名字" , "遊戲訊息" , JOptionPane.QUESTION_MESSAGE);
		for(int k = 0 ; k < 5 ; k++)
		{
			int number = play_man.choose();
			play_man.notecard(number , k);
			draw[k] = new JLabel();
			
			p_card[k] = new JButton(new ImageIcon("card/" + Integer.toString(number) +".gif"));
			p_card[k].setBounds(100 + 120 * k , 580 , 111 , 166);
			add(p_card[k]);
			
			com1_card[k] = new JLabel(new ImageIcon("card/card_back.jpg"));
			com1_card[k].setBounds(40 + 25 * k , 350 , 111 , 166);
			add(com1_card[k]);
			
			com2_card[k] = new JLabel(new ImageIcon("card/card_back.jpg"));
			com2_card[k].setBounds(430 + 25 * k , 100 , 111 , 166);
			add(com2_card[k]);
			
			com3_card[k] = new JLabel(new ImageIcon("card/card_back.jpg"));
			com3_card[k].setBounds(170 + 25 * k , 100 , 111 , 166);
			add(com3_card[k]);
			
			com4_card[k] = new JLabel(new ImageIcon("card/card_back.jpg"));
			com4_card[k].setBounds(560 + 25 * k , 350 , 111 , 166);
			add(com4_card[k]);
		}
		
		for(int i = 1 ; i < 5 ; i++) //建立電腦物件 , 並且取五張牌 , 傳遞出牌物件到play_com
		{
			play_com[i] = new Play_com();
			play_com[i].getobject(draw[i] , score , play_com , play_man);
			play_com[i].getcard();
		}
		
		p_card[0].addActionListener(this);
		p_card[1].addActionListener(this);
		p_card[2].addActionListener(this);
		p_card[3].addActionListener(this);
		p_card[4].addActionListener(this);
		
		Font font = new Font("Consolas" , Font.PLAIN , 40);
		
		name[0] = new JLabel(play_name);
		name[0].setBounds(350 , 500 , 200 , 100);
		name[0].setFont(font);
		add(name[0]);
		
		name[1] = new JLabel("com1");
		name[1].setBounds(110 , 270 , 100 , 100);
		name[1].setFont(font);
		add(name[1]);
		
		name[2] = new JLabel("com2");
		name[2].setBounds(240 , 20 , 100 , 100);
		name[2].setFont(font);
		add(name[2]);
		
		name[3] = new JLabel("com3");
		name[3].setBounds(500 , 20 , 100 , 100);
		name[3].setFont(font);
		add(name[3]);
		
		name[4] = new JLabel("com4");
		name[4].setBounds(630 , 270 , 100 , 100);
		name[4].setFont(font);
		add(name[4]);
		
		draw[0].setBounds(380 , 440 , 56 , 83);
		add(draw[0]);
		
		draw[1].setBounds(290 , 390 , 56 , 83);
		add(draw[1]);
		
		draw[2].setBounds(320 , 280 , 56 , 83);
		add(draw[2]);
		
		draw[3].setBounds(440 , 280 , 56 , 83);
		add(draw[3]);
		
		draw[4].setBounds(470 , 390 , 56 , 83);
		add(draw[4]);
		
		score.setBounds(660 , 30 , 150 , 150);
		score.setFont(new Font("Consolas" , Font.PLAIN , 80));
		add(score);
		
		direction.setBounds(0 , 0 , 176 , 176);
		add(direction);
		
		background.setBounds(0 , 0 , 800 , 800);
		add(background);
	}
	public int result () {
		return play_man.overanswer;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == p_card[0])
			play_man.man_judge(0 , draw[0] , score , direction , p_card[0] , play_com);
		else if(e.getSource() == p_card[1])
			play_man.man_judge(1 , draw[0] , score , direction , p_card[1] , play_com);
		else if(e.getSource() == p_card[2])
			play_man.man_judge(2 , draw[0] , score , direction , p_card[2] , play_com);
		else if(e.getSource() == p_card[3])
			play_man.man_judge(3 , draw[0] , score , direction , p_card[3] , play_com);
		else if(e.getSource() == p_card[4])
			play_man.man_judge(4 , draw[0] , score , direction , p_card[4] , play_com);
	}
}