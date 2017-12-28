package bank;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;



public class Withdrawl {
	JFrame jf;
	JButton a,b,c;
	JPanel jp;
	JLabel amlb;
	JTextField amtf;
	String name;
	String usrid;

	
	public Withdrawl(String usrid)
	{
		
		this.usrid=usrid;
		jf= new JFrame("Withdrawl");
		jp=new JPanel();
		jp.setLayout(null);
		int i=(int)(Math.random()*255);
		int j=(int)(Math.random()*255);
		int k=(int)(Math.random()*255);
	Color cc1=new Color(i,j,k);
	jp.setBackground(cc1);
	
	
amlb= new JLabel("Amount");
	
	amlb.setBounds(50,100,100,30);
	jp.add(amlb);
	
	amtf=new JTextField();
	amtf.setBounds(150,100,100,30);
	jp.add(amtf);
	
	a= new JButton("Withdrawl");
	a.addActionListener(new Withdrawamount());
	a.setBounds(300, 100, 100, 30);
	jf.add(a);
	
	b= new JButton("Back");
	b.addActionListener(new Back());
	b.setBounds(150, 150, 100, 30);
	jf.add(b);
	
	c= new JButton("Logout");
	c.addActionListener(new LogOut());
	c.setBounds(300, 150, 100, 30);
	jf.add(c);
	
	
	
	
	
	
	
	
	
	
	
	
jf.add(jp);
	
	
	jf.setVisible(true);
	//jf.setSize(560,658);
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
	
	class Withdrawamount implements ActionListener
	{

		
		public void actionPerformed(ActionEvent arg0) 
		{
			String withdraw= amtf.getText();
			int w = Integer.parseInt(withdraw);
			Connection con = DataBaseConnection.javaConnection();
			try {
				Statement st = con.createStatement();
				String q1="select * from banking where id="+usrid+"";
				ResultSet r = st.executeQuery(q1);
				if(r.next())
				{
					int b=r.getInt("balance");
					if(b>=w)
					{
						int t=b-w;
						String q2 ="update banking set balance = "+t+" where id="+usrid+" ";
						
						st.executeUpdate(q2);
						JOptionPane.showMessageDialog(null, "Withdraw Successfull");
						
						java.util.Date date=new java.util.Date();
						String q3="insert into transaction(accno,date,type,remark,amount) values ("+usrid+",'"+date.toString()+"','savings','ammount withdrawl',"+w+")";
						st.executeUpdate(q3);
						
					}
				
						
						
			
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Not sufficient balance");
					}
				
				
				
			
				 
				
			}
			 catch (SQLException e) {
					e.printStackTrace();
				}
			
			
			
		}
	}
	

}
