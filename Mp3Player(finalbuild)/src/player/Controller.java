package player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Controller {
	FileInputStream fis;
	BufferedInputStream bis;
	public Player player;
	private File songfile;
	private long pl;
	private long fl;
	
    public String S;
	Open o=new Open();
		
		public void stop()
		{
			if(player!=null)
			{
				player.close();
			}
		}
		public void pause()
		{
			if(player!=null)
			{
				try {
					pl=fis.available();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				player.close();
			}
		}
		
		public void open()
		{
			o.open();
			songfile=o.getsongfile();
			S=o.getsongname();
		}
		public void play()
		{
			try {
				fis=new FileInputStream(songfile);
				bis=new BufferedInputStream(fis);
				player=new Player(bis);
				try {
					fl=fis.available();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException | JavaLayerException e) {
				
			}
			new Thread()
			{
				public void run()
				{
					try {
						player.play();
					} catch (JavaLayerException e) {
					
					}
				}
			}.start();
			
		}
		public void resume()
		{
			try {
				fis=new FileInputStream(songfile);
				bis=new BufferedInputStream(fis);
				player=new Player(bis);
				try {
					fis.skip(fl-pl);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException | JavaLayerException e) {
				
			}
			new Thread()
			{
				public void run()
				{
					try {
						player.play();
					} catch (JavaLayerException e) {
					
					}
				}
			}.start();
			
		}

}
