package ce1002.FP.s101502014;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Start extends JPanel implements ActionListener{
	private static final JOptionPane JOption = null;
	public boolean gamestart = false; 
	private String rule = "一開始玩家和四個電腦都會有五張牌，先由玩家先出牌，再由其他電腦依序出牌\n"
						  + "出牌後點數累計超過99點的人就算是輸家\n"
						  + "大多數的牌出了都是加本身的數字，不過其中某些牌是有特殊功能的，例如:\n"
						  +	"4是反轉出牌順序\n"
						  +	"5是指定某人出牌\n"
						  +	"10是可以選擇加10點或減10點\n"
						  +	"J是PASS換下一個人出牌\n"
						  +	"Q是可以選擇加20點或減20點\n"
						  +	"K是直接跳到99點";
	
	private JButton start = new JButton();
	private JButton ins = new JButton();
	private JButton exit = new JButton();
	
	private JLabel background = new JLabel(new ImageIcon("card/background.jpg"));
	public Start() {
		setLayout(null);
		setBounds(0 , 0 , 800 , 800);
		
		start.setIcon(new ImageIcon("card/button_start.jpg"));
		start.setBounds(300 , 300 , 200 , 100);
		add(start);
		
		ins.setIcon(new ImageIcon("card/button_ins.jpg"));
		ins.setBounds(300 , 450 , 200 , 100);
		add(ins);
		
		exit.setIcon(new ImageIcon("card/button_exit.jpg"));
		exit.setBounds(300 , 600 , 200 , 100);
		add(exit);
		
		background.setBounds(0 , 0 , 800 , 800);
		add(background);
		
		start.addActionListener(this);
		ins.addActionListener(this);
		exit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start)
			gamestart = true;
		else if(e.getSource() == ins)
		{
			JOption.showMessageDialog(null , rule , "遊戲訊息" , JOptionPane.PLAIN_MESSAGE);
		}
		else if(e.getSource() == exit)
			System.exit(0);
	}
	public boolean getstart() {
		return gamestart;
	}
}
