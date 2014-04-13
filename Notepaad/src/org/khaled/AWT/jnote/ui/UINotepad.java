package org.khaled.AWT.jnote.ui;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UINotepad extends Frame implements ClipboardOwner{
	private static final long serialVersionUID = -452191335440782357L;

	// Components
	private Panel panel_content;
	private TextArea textArea_textContent;
	private MenuBar menubar_main;

	private Menu menu_File, menu_Edit, menu_help;
	private MenuItem menuitem_file_new, menuitem_file_open, menuitem_file_save,
			menuitem_file_saveas, menuitem_file_exit, menuitem_edit_copy,
			menuitem_edit_cut, menuitem_edit_paste, menuitem_edit_selectall,
			menuitem_help_info;

	private File currentFile;
	private static UINotepad instance;

	public UINotepad() {
		super("JNote");

		this.setSize(640, 480);
		this.initComponents();
		this.initListeners();
		instance = this;
	}

	private void initComponents() {
		// initComponents
		this.panel_content = new Panel(new BorderLayout());
		this.textArea_textContent = new TextArea("", 100, 100,
				TextArea.SCROLLBARS_NONE);
		this.menubar_main = new MenuBar();
		this.menu_File = new Menu("Datei");
		this.menu_Edit = new Menu("Bearbeiten");
		this.menu_help = new Menu("Hilfe");
		this.menuitem_file_new = new MenuItem("Neu");
		this.menuitem_file_open = new MenuItem("Öffnen ...");
		this.menuitem_file_save = new MenuItem("Speichern");
		this.menuitem_file_saveas = new MenuItem("Speichern unter ...");
		this.menuitem_file_exit = new MenuItem("Beenden");
		this.menuitem_edit_copy = new MenuItem("Kopieren");
		this.menuitem_edit_cut = new MenuItem("Ausschneiden");
		this.menuitem_edit_paste = new MenuItem("Einfügen");
		this.menuitem_edit_selectall = new MenuItem("Alles markieren");
		this.menuitem_help_info = new MenuItem("Info");

		// init menu
		this.menubar_main.add(menu_File);
		this.menubar_main.add(menu_Edit);
		this.menubar_main.add(menu_help);

		// Init menuItem
		this.menu_File.add(menuitem_file_new);
		this.menu_File.add(menuitem_file_open);
		this.menu_File.addSeparator();

		this.menu_File.add(menuitem_file_save);
		this.menu_File.add(menuitem_file_saveas);
		this.menu_File.addSeparator();

		this.menu_File.add(menuitem_file_exit);

		this.menu_Edit.add(menuitem_edit_selectall);
		this.menu_Edit.addSeparator();
		this.menu_Edit.add(menuitem_edit_copy);
		this.menu_Edit.add(menuitem_edit_cut);
		this.menu_Edit.add(menuitem_edit_paste);
		this.menu_help.add(menuitem_help_info);

		// Add component panel
		this.add(this.panel_content);
		this.setMenuBar(menubar_main);

		// Add components

		this.panel_content.add(this.textArea_textContent);
	}

	private void initListeners() {

		// Windows Close Listener
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				exit();
			}
		});

		// MenuItem Open Listener
		this.menuitem_file_open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileDialog fd = new FileDialog(instance);
				fd.setMode(FileDialog.LOAD);
				fd.setVisible(true);
				String selectedPath = fd.getDirectory() + fd.getFile();

				if (selectedPath != null) {
					try {
						openFile(selectedPath);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				fd.setVisible(false);
			}
		});

		// MenuItem Save
		this.menuitem_file_save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (currentFile != null) {
					try {
						saveFile(currentFile.getAbsolutePath());
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					FileDialog fd = new FileDialog(instance);
					fd.setMode(FileDialog.SAVE);
					fd.setVisible(true);

					String s = fd.getDirectory() + fd.getFile();
					try {
						saveFile(s);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						fd.setVisible(false);
					}

				}
			}
		});

		// MenuItem save as
		this.menuitem_file_saveas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileDialog fd = new FileDialog(instance);
				fd.setMode(FileDialog.SAVE);
				fd.setVisible(true);

				String s = fd.getDirectory() + fd.getFile();
				try {
					saveFile(s);
					currentFile = new File(s);

					setTitle(s);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					fd.setVisible(false);
				}

			}
		});

		// mwnuItem neu
		this.menuitem_file_new.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (currentFile != null) {
					FileDialog fd = new FileDialog(instance);
					fd.setMode(FileDialog.SAVE);
					fd.setVisible(true);

					String s = fd.getDirectory() + fd.getFile();
					try {
						saveFile(s);
						currentFile = new File(s);

						setTitle(s);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						fd.setVisible(false);
					}
				}

				currentFile = null;

				textArea_textContent.setText(null);

				setTitle("Jnote");
			}
		});

		// MenuItem exit
		this.menuitem_file_exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				exit();
			}
		});
		
		//MenuItem copy
		this.menuitem_edit_copy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!textArea_textContent.getText().isEmpty()){
					StringSelection sl = new StringSelection(textArea_textContent.getText());
					Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
					
					cb.setContents(sl, instance);
				}
			}
		});
		
		this.menuitem_edit_paste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		this.menuitem_edit_selectall.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int l = textArea_textContent.getText().length();
				textArea_textContent.setSelectionStart(0);
				textArea_textContent.setSelectionEnd(l);
			}
		});
		
		this.menu_help.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UIAbout.create();
			}
		});
	}

	private void exit() {
		if (currentFile != null) {
			FileDialog fd = new FileDialog(instance);
			fd.setMode(FileDialog.SAVE);
			fd.setVisible(true);

			String s = fd.getDirectory() + fd.getFile();
			try {
				saveFile(s);
				currentFile = new File(s);

				setTitle(s);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				fd.setVisible(false);
			}
		}
		System.exit(0);
	}

	public static Frame showWindow() {
		UINotepad ui = new UINotepad();
		ui.setVisible(true);

		return ui;
	}

	private boolean openFile(String filePath) throws IOException {
		File file = new File(filePath);
		if (file.isFile() && file.exists()) {

			BufferedReader br = new BufferedReader(new FileReader(file));

			String currentLine = null;
			StringBuilder sb = new StringBuilder();

			this.setTitle("JNOTE - " + file);
			while ((currentLine = br.readLine()) != null) {
				sb.append(currentLine);
			}

			br.close();

			this.currentFile = file;
			this.textArea_textContent.setText(sb.toString());
			this.setTitle(filePath);

			return true;
		} else {
			return false;
		}
	}

	private boolean saveFile(String file) throws IOException {
		File f = new File(file);

		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		bw.write(this.textArea_textContent.getText());
		bw.close();
		return true;
	}

	@Override
	public void lostOwnership(Clipboard arg0, Transferable arg1) {
	}
}
