package ce1002.FP.s101502014;
import javax.swing.*;
import java.awt.event.*;
public class Main {
	private Start start = new Start();
	public static void main(String[] args) {
		Display display = new Display(); //建立視窗
		display.setSize(800 , 800); //設定視窗大小
		display.setTitle("99"); //命名視窗
		display.setLayout(null); //取消預設的版面設定
		display.setLocationRelativeTo(null); //固定視窗位置出現在螢幕的中間
		display.setResizable(false); //讓視窗固定大小
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setVisible(true); //讓視窗出現
	}
}
