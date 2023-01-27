import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Gaming_Window implements ActionListener{
	
	JFrame f=new JFrame("Guessing Game");
	public static int attempt=1,score;
	static String textValue;
	boolean flag=true;
	int txtValue,temp; 
	byte a=0;
	String str,str1,str2;

	TextField tf,tf1;
	Label l1,l2,l3,l4,l5;
	Button b1,b2,b3;
	JPopupMenu pop;
		
	Gaming_Window(){
	try{

		f.setSize(500,500);
		f.setLayout(null);
		b1=new Button("Submit");
		b1.setBounds(200,400,100,50);
		b1.addActionListener(this);
		b2=new Button("Ok");
		b2.setBounds(150,80,10,5);
		b2.setBackground(Color.red);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pop.setVisible(false);	
			}
		});
	

		l1=new Label("Enter number between 1 to 100");
		l1.setBounds(175,100,200,50);
		l2=new Label("Guessing number");
		l2.setBounds(100,200,110,50);
		l3=new Label("Note: Give your guess by clicking 'give here' button then ");
		l3.setBounds(75,325,350,30);
		l5=new Label("click on 'submit' to check your result");
		l5.setBounds(75,355,350,30);

		b3=new Button("Give here!");
		b3.setBounds(300,200,100,50);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				a=1;
				
				JFrame f1=new JFrame();
				
				textValue=JOptionPane.showInputDialog(f1,"Type here");
				try{
				txtValue=Integer.parseInt(textValue);
				System.out.println(txtValue);
				if(pop.isVisible())
					pop.setVisible(false);
				}
				catch(InputMismatchException iex){
			
					pop=new JPopupMenu("Result");
					pop.setPopupSize(400,100);
					l4=new Label("Give number between 1 to 100",Label.CENTER);
					l4.setBounds(75,50,100,50);
					pop.add(l4);
					pop.add(b2);
					pop.setVisible(true);
					
				}
				
				catch(Exception exc){}
				
			}
		});

		f.add(l2);
		f.add(l1);
		f.add(l3);
		f.add(l5);
		f.add(b1);
		f.add(b3);

		f.setVisible(true);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	}
	catch(Exception ex){
		System.out.println(ex.getMessage());
	}
	}
	public void actionPerformed(ActionEvent e){
		if(a==1){
			a=0;
			
			if(Game.p==1 || (Game.q==1 && attempt<10) || (Game.r==1 && attempt<5)){
			
				compare(txtValue);
				str=l4.getText();
				str=l4.getText();
				attempt++;
			
				pop=new JPopupMenu("Result");
				pop.setPopupSize(400,100);
				pop.add(l4);
				pop.add(b2);
				pop.setVisible(true);
			}
			else if((Game.q==1 && attempt==10) || (Game.r==1 && attempt==5) || (str==str1) || (str==str2)){
				
				compare(txtValue);
				pop=new JPopupMenu("Result");
				pop.setPopupSize(400,100);
				pop.add(l4);
				pop.add(b2);
				f.setVisible(false);
				f.dispose();
				pop.setVisible(true);
			}
		}
		
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	
	public void compare(int value){
		
		int n=1;
		int max=100,min=1;
		
		if(flag==true){
			n=(int)(Math.random()*(max-min+1)+min);	
			temp=n;
			flag=false;
		}
		
		System.out.println("n="+temp);
		if(value>0 && value<=100){
		System.out.println("value="+value);
		if(Game.p==1 || (Game.q==1 && attempt<10) || (Game.r==1 && attempt<5)){
		if(value!=temp){
			if(value>temp){
				l4=new Label("Your guess is wrong! The number is smaller than "+value,Label.CENTER);
				l4.setBounds(75,50,100,50);		
			}
			else if(value<temp){
				l4=new Label("Your guess is wrong! The number is greater than "+value,Label.CENTER);
				l4.setBounds(75,50,100,50);	
			}
		}
		if(value==temp){
			str1="YOU WIN! Your guess is correct! Number of attempts="+attempt;
			l4=new Label(str1,Label.CENTER);
			l4.setBounds(75,50,100,50);	
			f.setVisible(false);
		}
		}
		else if(value==temp){
			str1="YOU WIN! Your guess is correct! Number of attempts="+attempt;
			l4=new Label(str1,Label.CENTER);
			l4.setBounds(75,50,100,50);	
			f.setVisible(false);
		}
		else{
			str2="You lose the game! You used all the "+attempt+" attempts";
			l4=new Label(str2,Label.CENTER);
			l4.setBounds(75,50,100,50);
		}
		}
		else{
			l4=new Label("Give number between 1 to 100",Label.CENTER);
			l4.setBounds(75,50,100,50);
			attempt=attempt-1;
		}		
	}
}