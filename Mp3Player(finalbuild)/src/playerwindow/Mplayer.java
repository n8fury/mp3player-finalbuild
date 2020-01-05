package playerwindow;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import player.Controller;


import java.awt.Font;

public class Mplayer {

	private JFrame frame;
	
	Controller c=new Controller();
	private JTextField songname;
	private JTextField songtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Mplayer window = new Mplayer();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mplayer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			c.play();
			}
		});
		btnNewButton.setBounds(167, 185, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Open");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			c.open();
			songtxt.setText("Now playing"+c.S);
			}
		});
		btnNewButton_1.setBounds(266, 185, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Stop");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			c.stop();
			}
		});
		
		btnNewButton_2.setBounds(68, 185, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		songname = new JTextField();
		songname.setBounds(68, 69, 285, 32);
		//songname.setText(c.s);
		//frame.getContentPane().add(songname);
		songname.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Pause");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.pause();
			}
		});
		btnNewButton_3.setBounds(166, 151, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("resume");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.resume();
			}
		});
		btnNewButton_4.setBounds(167, 219, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		songtxt = new JTextField();
		songtxt.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		songtxt.setEditable(false);
		songtxt.setBounds(25, 28, 382, 55);
		
		frame.getContentPane().add(songtxt);
		songtxt.setColumns(10);
	}
}
