package javakeshe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;


public class Save extends JFrame{
	JButton s = new JButton("save");
	private static Document document;
	private static JTextArea text = new JTextArea(document,null,10,45);
	private String str = "";
	public void init(){
		//setResizable(false);
		//setSize(700,900);
		JPanel panel = new JPanel();
		JPanel button1 = new JPanel();
		JPanel page = new JPanel();
		JPanel pCenter = new JPanel();
		JPanel pSouth = new JPanel();
		pCenter.add(page);
		pSouth.add(button1);
		this.add(BorderLayout.CENTER,pCenter);
		this.add(BorderLayout.SOUTH,pSouth);
		page.add(text);
		button1.add(s);
		s.setEnabled(false);
		panel.add(page);
		panel.add(s);
		this.add(panel);
	}
	public void showMe(JFrame parent,Document document){
		this.document = document;
		init();
		addEventHandler();
		setResizable(false);
		setSize(800,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void addEventHandler(){
		text.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				s.setEnabled(true);
			}
			public void removeUpdate(DocumentEvent e){
				s.setEnabled(true);
			}
			public void changedUpdate(DocumentEvent e){
				s.setEnabled(true);
			}
		});
		
		s.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				str = text.getText();
				text.setText(null);
				System.out.println(str);
				s.setEnabled(false);
			}
		});
		s.addActionListener(new SaveFile(text));
	}
		/*panel.add(page);
		panel.add(save);
		this.add(panel);
		*/
		
		//save.addActionListener(new SaveFile(text));
}

