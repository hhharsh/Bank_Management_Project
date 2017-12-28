package bank;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MiniStatement {
	
	JFrame jf;
	JPanel jp;
	JLabel accnolb, datelb, acctyplb, ballb;
	String name;
	String usrid;
	JButton a,b,c;
	
	JTextField accnotf[], datetf[], acctyptf[], baltf[];
	ArrayList<UserList>l;
	public MiniStatement(ArrayList<UserList>ll)
	{   l=ll;
		jf= new JFrame();
		jp= new JPanel();
		jp.setLayout(null);
		
		b= new JButton("Back");
		b.addActionListener(new Back());
		b.setBounds(500, 150, 100, 30);
		jf.add(b);
		
		c= new JButton("Logout");
		c.addActionListener(new LogOut());
		c.setBounds(650, 150, 100, 30);
		jf.add(c);
   
	 
		accnolb=new JLabel("Userid");                
		accnolb.setBounds(10, 30, 100, 25);
		jp.add(accnolb);
		

		datelb=new JLabel("Date");
		datelb.setBounds(110, 30, 100, 25);
		jp.add(datelb);

		acctyplb=new JLabel("Account type");
		acctyplb.setBounds(210, 30, 100, 25);
		jp.add(acctyplb);

		ballb=new JLabel("Balance");
		ballb.setBounds(310, 30, 100, 25);
		jp.add(ballb);
		
		accnotf= new JTextField[l.size()];
        datetf= new JTextField[l.size()];
		acctyptf= new JTextField[l.size()];
		baltf= new JTextField [l.size()];
		System.out.println(l.size());
		int i=0,y=100;
		for(UserList uu:l)
		{
		accnotf[i] =new JTextField(uu.getAccno());
		accnotf[i].setBounds(10, y, 100, 25);
		jp.add(accnotf[i]);
		
		datetf[i]  =new JTextField(uu.getDate());
		datetf[i].setBounds(110, y, 100, 25);
		jp.add(datetf[i]);
		
		acctyptf[i]=new JTextField(uu.getType());
		acctyptf[i].setBounds(210, y, 100, 25);
		jp.add(acctyptf[i]);
		
		baltf[i]=new JTextField(uu.getAmount());
		baltf[i].setBounds(310, y, 100, 25);
		jp.add(baltf[i]);
		i++;
		y=y+30;
		}
		
		jf.add(jp);
		jf.setVisible(true);
		jf.setSize(jf.getToolkit().getScreenSize());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	

	class Back implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			jf.dispose();
			new UserWelcome(usrid);
		
			
		}
		
	}
	
	class LogOut implements ActionListener
	{

		
		public void actionPerformed(ActionEvent arg0) 
		{
			jf.dispose();
			new UserLogin();
		}
		
	}
	
}


