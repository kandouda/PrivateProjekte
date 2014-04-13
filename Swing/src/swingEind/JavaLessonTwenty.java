package swingEind;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class JavaLessonTwenty extends JFrame {

	JButton button1;
	JTextField textfield1;
	JTextArea textarea1;
	int buttonClicked;

	public static void main(String[] args) {
		new JavaLessonTwenty();
	}

	public JavaLessonTwenty() {
		this.setSize(400, 400);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dm = tk.getScreenSize();

		int xPos = (dm.width / 2) - (this.getWidth() / 2);
		int yPos = (dm.height / 2) - (this.getHeight() / 2);
		this.setLocation(xPos, yPos);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setTitle("My First Frame");

		JPanel jpanel = new JPanel();
		JLabel jl1 = new JLabel("Tell me something");
		jl1.setText("New text");
		jl1.setToolTipText("this is a new text");
		jpanel.add(jl1);

		button1 = new JButton("Send");
		button1.setBorderPainted(true);
		button1.setContentAreaFilled(false);
		button1.setToolTipText("this is a button");
		button1.setText("New button");
		ListenForButton lForButton = new ListenForButton();
		button1.addActionListener(lForButton);
		jpanel.add(button1);

		textfield1 = new JTextField("Type here", 15);
		textfield1.setColumns(10);
		textfield1.setToolTipText("this is a textfield");
		ListenForKeys lForKeys = new ListenForKeys();
		textfield1.addKeyListener(lForKeys);
		jpanel.add(textfield1);

		textarea1 = new JTextArea(15, 20);
		textarea1.setText("Tracking Events\n");
		textarea1.setLineWrap(true);
		textarea1.setWrapStyleWord(true);

		JScrollPane textarea1Scroll = new JScrollPane(textarea1,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jpanel.add(textarea1Scroll);

		this.add(jpanel);

		ListenForWindow lForWindow = new ListenForWindow();
		this.addWindowListener(lForWindow);
		this.setVisible(true);

		ListenForMouse lForMouse = new ListenForMouse();
		this.addMouseListener(lForMouse);
	}

	private class ListenForButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) {
				buttonClicked++;
				textarea1
						.append("Button clicked " + buttonClicked + " times\n");
			}
		}
	}

	private class ListenForKeys implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			textarea1.append("key hit " + e.getKeyChar() + "\n");
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

	}

	private class ListenForWindow implements WindowListener {

		@Override
		public void windowActivated(WindowEvent e) {
			textarea1.append("Windows activated\n");
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class ListenForMouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			textarea1.append("Mouse clicked at (" + e.getX() + "," + e.getY() + ")\n");
			textarea1.append("mouse Button" + e.getButton() + "\n");
			textarea1.append("Mouse clickes " + e.getClickCount() + "\n");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
