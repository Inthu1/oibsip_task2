import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Game extends Gaming_Window {
    public static int p,q,r;
	static JFrame f=new JFrame("Guessing Game");
	public static void main(String args[]){

		f.setSize(600,600);
		f.setLayout(null);
		Label l1,l2,l3;
		JButton jb,jb1,jb2;
		
		l1=new Label("Welcome to the Guessing Game!");
		l1.setBounds(210,100,300,50);
		f.add(l1);
		l2=new Label("Attempts:10");
		l2.setBounds(220,350,150,50);
		f.add(l2);
		l3=new Label("Attempts:5");
		l3.setBounds(380,350,150,50);
		f.add(l3);
		jb=new JButton(new ImageIcon("easy.png"));
		jb.setBounds(60,200,150,150);
		f.add(jb);
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				p=1;
				attempt=1;
				new Gaming_Window();
			}
		});
		jb1=new JButton(new ImageIcon("medium.png"));
		jb1.setBounds(220,200,150,150);
		f.add(jb1);
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				q=1;
				attempt=1;
				new Gaming_Window();
			}
		});
		jb2=new JButton(new ImageIcon("hard.png"));
		jb2.setBounds(380,200,150,150);
		f.add(jb2);
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				r=1;
				attempt=1;
				new Gaming_Window();
			}
		});
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//Closing the frame
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				int a=JOptionPane.showConfirmDialog(f,"Do you want to Quit?");
				if(a==JOptionPane.YES_OPTION){
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				
			}
		});
	}
}