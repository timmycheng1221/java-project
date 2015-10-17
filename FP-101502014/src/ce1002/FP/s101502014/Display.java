package ce1002.FP.s101502014;

import java.awt.event.*;
import javax.swing.*;

public class Display extends JFrame{
	private Timer timer = new Timer(16 , new TimerListener());
	private Start start = new Start();
	private Game99 game = new Game99();
	Display() {
		add(start);
		timer.start();
	}
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			if(start.getstart())
			{
				remove(start);
				add(game);
				game.show();
				start.gamestart = false;
			}
			else if(game.result() == 0)
			{
				remove(game);
				add(start);
				game = new Game99();
			}
			repaint();
		}
	}
}
