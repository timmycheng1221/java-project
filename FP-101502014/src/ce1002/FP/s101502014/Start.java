package ce1002.FP.s101502014;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Start extends JPanel implements ActionListener{
	private static final JOptionPane JOption = null;
	public boolean gamestart = false; 
	private String rule = "�@�}�l���a�M�|�ӹq�����|�����i�P�A���Ѫ��a���X�P�A�A�Ѩ�L�q���̧ǥX�P\n"
						  + "�X�P���I�Ʋ֭p�W�L99�I���H�N��O��a\n"
						  + "�j�h�ƪ��P�X�F���O�[�������Ʀr�A���L�䤤�Y�ǵP�O���S��\�઺�A�Ҧp:\n"
						  +	"4�O����X�P����\n"
						  +	"5�O���w�Y�H�X�P\n"
						  +	"10�O�i�H��ܥ[10�I�δ�10�I\n"
						  +	"J�OPASS���U�@�ӤH�X�P\n"
						  +	"Q�O�i�H��ܥ[20�I�δ�20�I\n"
						  +	"K�O��������99�I";
	
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
			JOption.showMessageDialog(null , rule , "�C���T��" , JOptionPane.PLAIN_MESSAGE);
		}
		else if(e.getSource() == exit)
			System.exit(0);
	}
	public boolean getstart() {
		return gamestart;
	}
}
