package ce1002.FP.s101502014;
import java.util.*;

import javax.swing.*;
public class Play_com {
	private Play_man play_man = null;
	private Play_com[] play_com = new Play_com[5];
	
	private int[] card_com;
	
	private JLabel draw = null;
	private JLabel score = null;
	
	private Random ran = new Random();
	public Play_com() {
		card_com = new int[5];
	}
	public void getobject(JLabel draw , JLabel score , Play_com[] play_com , Play_man play_man) {
		this.draw = draw;
		this.score = score;
		this.play_com = play_com;
		this.play_man = play_man;
	}
	public void getcard() {
		for(int i = 0 ; i < 5 ; i++)
			card_com[i] = play_man.choose();
	}
	public int sendcard() {
		if(play_man.getsum() < 99)
		{
			for(int i = 9 ; i > 0 ; i--)
			{
				if(i == 4 || i == 5)
					continue;
				else
				{
					if(search(card_com , i) != -1)
					{
						if(i + play_man.getsum() <= 99)
							return search(card_com , i);
					}
				}
			}
		}
		else if(play_man.getsum() == 99)
		{
			if(search(card_com , 11) != -1)
				return search(card_com , 11);
			else if(search(card_com , 13) != -1)
				return search(card_com , 13);
			else if(search(card_com , 5) != -1)
				return search(card_com , 5);
			else if(search(card_com , 4) != -1)
				return search(card_com , 4);
			else if(search(card_com , 10) != -1)
				return search(card_com , 10);
			else if(search(card_com , 12) != -1)
				return search(card_com , 12);
		}
		return ran.nextInt(4);
	}
	public int search(int[] cards, int number) {
		for(int i = 0 ; i < 5 ; i++)
			if(cards[i] % 100 == number)
				return i;
		return -1;
	}
	public void judge() {
		int temp = play_man.getturn();
		int send = sendcard();
		int old_sum = play_man.getsum();
		//JOptionPane.showMessageDialog(null , "com" + temp + "出牌" + card_com[send] + " " + card_com[0] + " " + card_com[1] + " " + card_com[2] + " " + card_com[3] + " " + card_com[4] + " ", "遊戲訊息" , JOptionPane.INFORMATION_MESSAGE );
		play_man.card_function(card_com[send] , true);
		draw.setIcon(new ImageIcon("card/" + card_com[send] + ".jpg"));
		if(play_man.sum > 99)
		{
			play_man.sum = old_sum;
			JOptionPane.showMessageDialog(null , "com" + temp + "已經輸了" , "遊戲訊息" , JOptionPane.INFORMATION_MESSAGE );
			play_man.condition[temp] = 2;
			draw.setVisible(false);
		}
		else
		{
			int buffer = (card_com[send] / 100 - 1) * 13 + card_com[send] % 100;
			score.setText(Integer.toString(play_man.getsum()));
			card_com[send] = play_man.choose();
			play_man.card[buffer].used = false;
		}
		if(!play_man.appoint)
			play_man.change(play_man.turn , temp);
		play_man.appoint = false;
		if(play_man.getturn() != 0)
			play_com[play_man.getturn()].judge();
	}
}
