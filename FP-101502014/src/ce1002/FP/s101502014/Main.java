package ce1002.FP.s101502014;
import javax.swing.*;
import java.awt.event.*;
public class Main {
	private Start start = new Start();
	public static void main(String[] args) {
		Display display = new Display(); //�إߵ���
		display.setSize(800 , 800); //�]�w�����j�p
		display.setTitle("99"); //�R�W����
		display.setLayout(null); //�����w�]�������]�w
		display.setLocationRelativeTo(null); //�T�w������m�X�{�b�ù�������
		display.setResizable(false); //�������T�w�j�p
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setVisible(true); //�������X�{
	}
}
