package javakeshe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class SaveFile implements ActionListener {
	JTextArea text;
	public SaveFile(JTextArea text){
		this.text = text;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES|JFileChooser.FILES_AND_DIRECTORIES);
		jfc.setDialogTitle("保存文件");
		jfc.setApproveButtonText("保存");
		jfc.showDialog(null,null);
		File fi = jfc.getSelectedFile();
		String f = null;
		if(fi!=null){
			f = fi.getAbsolutePath()+"\\sentive.txt";
		}
		try{
			FileWriter out = new FileWriter(f,true);
			System.out.println(text.getText());
			String sentext = text.getText();
			String[] sentivtext = sentext.split("\n");
			for(int i=0;i<sentivtext.length;i++){
				sentext = sentivtext[i]+"\r\n";
				out.write(sentext);
			}out.close();
		}catch(Exception e1){
			
		}
	}

}
