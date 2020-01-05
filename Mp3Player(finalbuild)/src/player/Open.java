package player;

import java.io.File;

import javax.swing.JFileChooser;

public class Open {
	File songfile;
	String name;

	
	public void open()
	{
		try
		{
			JFileChooser chooser=new JFileChooser();
			chooser.setDialogTitle("song chooser");
			chooser.showOpenDialog(null);
			songfile=chooser.getSelectedFile();
			name=chooser.getSelectedFile().getName();
			//System.out.println("song:"+songfile.getName()+"selected");
		}catch(Exception e0)
		{
			e0.printStackTrace();
		}
	}
	public File getsongfile()
	{
		return this.songfile;
	}
	public String getsongname()
	{
		return this.name;
	}

}
