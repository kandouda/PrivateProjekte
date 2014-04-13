package org.khaled.AWT.jnote.ui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UIAbout extends Frame {

	Button closeButton;
	Label pName, pText;

	Panel helpContent;

	public UIAbout() {
		super("JNote - Help");

		this.setSize(300, 100);

		this.initComponents();
		this.initListener();
		
		this.setVisible(true);
	}

	public void initComponents() {
		helpContent = new Panel(null);

		closeButton = new Button("Schlieﬂen");
		pName = new Label("Name");

		pText = new Label("Khaled");

		this.pName.setBounds(5, 5, 50, 25);
		this.pText.setBounds(50, 5, 100, 25);

		this.closeButton.setBounds(5, 30, 70, 25);

		this.add(helpContent);
		this.helpContent.add(pText);
		this.helpContent.add(pName);
		this.helpContent.add(closeButton);
	}

	public void initListener() {
		this.closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
			
		});
	}
	
	public static Frame create(){
		Frame f = new UIAbout();
		return f;
	}
}
