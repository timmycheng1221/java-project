package ce1002.FP.s101502014;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class Play_man {
	private Play_com[] play_com = null;
	public Card[] card = new Card[53];
	
	public boolean turn = true;
	public boolean appoint = false;
	
	public int[] condition = new int[5] , card_man; 
	public int sum = 0 , buffer , overanswer = 2;
	private Random ran = new Random();
	
	public String option5[] = {"com1" , "com2" , "com3" , "com4"};
	private String option10[] = {"+10" , "-10"};
	private String option12[] = {"+20" , "-20"};
	private String optionover[] = {"New game" , "Exit"};

	private JLabel direction = new JLabel();
	public Play_man() {
		for (int i = 0; i < 5; i++)
            condition[i] = 0;
        condition[0] = 1;
        card_man = new int[5];
        for(int i = 0 ; i < 4 ; i++)
			for(int j = 1 ; j < 14 ; j++)
				card[i * 13 + j] = new Card(i , j);
	}
	public int choose() {
		do{
			buffer = ran.nextInt(51) + 1;
		}while(card[buffer].used == true);
		card[buffer].used = true;
		return card[buffer].flower * 100 + card[buffer].number + 100;
	}
	public int getsum() {
		return sum;
	}
	public int getturn() {
		for(int i = 0 ; i < 5 ; i++)
			if(condition[i] == 1)
				return i;
		return -1;
	}
	public int getloser() {
		int loser = 0;
        for (int i = 0 ; i < 5 ; i++) 
        {
            if (condition[i] == 2)
                loser++;
        }
        return loser;
	}
	public int next(int turn) {
		for(int i = 0 ; i < 5 ; i++)
		{
			if(condition[(turn + 1) % 5] == 2)
				turn++;
			else
				return (turn + 1) % 5;
		}
		return -99;
	}
	public int last(int turn) {
		for(int i = 0 ; i < 5 ; i++)
		{
			if(condition[(turn + 4) % 5] == 2)
				turn--;
			else
				return (turn + 4) % 5;
		}
		return -99;
	}
	public void change(boolean dir , int turn) {
		if(dir)
			condition[next(turn)] = 1;
		else
			condition[last(turn)] = 1;
		if(condition[turn] != 2)
			condition[turn] = 0;
	}
	public void notecard(int number , int position) {
		card_man[position] = number;
	}
	public void man_judge(int position , JLabel draw , JLabel score , JLabel direction , JButton cardbutton , Play_com[] play_com) {
		draw.setIcon(new ImageIcon("card/" + card_man[position] + ".jpg"));
		this.direction = direction;
		card_function(card_man[position] , false);
		if(!appoint)
			change(turn , 0);
		appoint = false;
		if(sum > 99)
		{
			overanswer = JOptionPane.showOptionDialog(null , "You Lose!!!" , "遊戲訊息" , JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE , null , optionover , "New game");
			if (overanswer == 1)
				System.exit(0);
		}
		else
		{
			int buffer = (card_man[position] / 100 - 1) * 13 + card_man[position] % 100;
			score.setText(Integer.toString(sum));
			card_man[position] = choose();
			card[buffer].used = false;
			cardbutton.setIcon(new ImageIcon("card/" + card_man[position] + ".gif"));
			if(getloser() != 4)
				play_com[getturn()].judge();
			else
			{
				overanswer = JOptionPane.showOptionDialog(null , "You Win!!!" , "遊戲訊息" , JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE , null , optionover , "New game");
				if (overanswer == 1)
					System.exit(0);
			}
		}
	}
	public void card_function(int number , boolean com)
	{
		if(number % 100 == 4)
		{
			String dir = "";
			turn = !turn;
			if(turn)
			{
				dir = "順時針方向";
				direction.setIcon(new ImageIcon("card/clockwise.jpg"));
			}				
			else
			{
				dir = "逆時針方向";
				direction.setIcon(new ImageIcon("card/counter_clockwise.jpg"));
			}
			if(com)
				JOptionPane.showMessageDialog(null , "com" + getturn() + "出迴轉牌 , " + "現在為" + dir , "Game Message" , JOptionPane.INFORMATION_MESSAGE);
		}
		else if(number % 100 == 5)
		{
			appoint = true;
			if(com)
			{
				JOptionPane.showMessageDialog(null , "com" + getturn() + "指定你出牌" , "Game Message" , JOptionPane.INFORMATION_MESSAGE);
				condition[getturn()] = 0;
				condition[0] = 1;
			}
			else
			{
				int answer5 = JOptionPane.showOptionDialog(null , "請選擇要指定的下一家" , "Game Message" , JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE , null , option5 , "com1");
				condition[0] = 0;
				condition[answer5 + 1] = 1;
			}
		}
		else if(number % 100 == 10)
		{
			if(com)
			{
				if(sum > 89)
					sum -= 10;
				else
					sum += 10;
			}
			else if(sum < 10)
				sum += 10;
			else if(sum > 89)
				sum -= 10;
			else 
			{
				int answer10 = JOptionPane.showOptionDialog(null , "請選擇加10或減10" , "Game Message" , JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE , null , option10 , "-10");
				if(answer10 == 0)
					sum += 10;
				else
					sum -= 10;
			}
		}
		else if(number % 100 == 11)
		{
			
		}
		else if(number % 100 == 12)
		{
			if(com)
			{
				if(sum > 79)
					sum -= 20;
				else
					sum += 20;
			}
			else if(sum < 20)
				sum += 20;
			else if(sum > 79)
				sum -= 20;
			else
			{
				int answer12 = JOptionPane.showOptionDialog(null , "請選擇加20或減20" , "Game Message" , JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE , null , option12 , "-20");
				if(answer12 == 0)
					sum += 20;
				else
					sum -= 20;
			}
		}
		else if(number % 100 == 13)
			sum = 99;
		else
			sum += number % 100;
	}
}