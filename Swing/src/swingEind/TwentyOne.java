package swingEind;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TwentyOne extends JFrame {
	
	JButton button1;
	JTextField textFiled1;
	JTextArea textArea1;
	int buttonClicked;
	
	public TwentyOne() {
		this.setSize(400, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TwentyOne();
	}

}
