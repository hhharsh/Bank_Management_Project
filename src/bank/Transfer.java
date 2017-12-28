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





public class Transfer {
	JFrame jf;
	JPanel jp;
	JLabel amlb,ab;
	JTextField ammtf,accntf;
	JButton tranb,b,c;
	String name;
	String usrid;


	
	public Transfer(String usrid)
	{
		this.usrid=usrid;
		jf= new JFrame("Transfer");
		jp=new JPanel();
		jp.setLayout(null);
		int i=(int)(Math.random()*255);
		int j=(int)(Math.random()*255);
		int k=(int)(Math.random()*255);
	Color cc1=new Color(i,j,k);
	jp.setBackground(cc1);
	
	
amlb= new JLabel("Account no:");
	
	amlb.setBounds(50,100,100,30);
	jp.add(amlb);
	
	accntf=new JTextField();
	accntf.setBounds(150,100,100,30);
	jp.add(accntf);
	
ab= new JLabel("Ammount:");
	
	ab.setBounds(50,150,100,30);
	jp.add(ab);
	
	ammtf=new JTextField();
	ammtf.setBounds(150,150,100,30);
	jp.add(ammtf);
	
	
	
	tranb= new JButton("Deposit");
	tranb.addActionListener(new Transferr ());
	tranb.setBounds(300, 100, 100, 30);
	jf.add(tranb);
	
	b= new JButton("Back");
	b.addActionListener(new Back());
	b.setBounds(150, 250, 100, 30);
	jf.add(b);
	
	c= new JButton("Logout");
	c.addActionListener(new LogOut());
	c.setBounds(300,250, 100, 30);
	jf.add(c);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
jf.add(jp);
	
	
	jf.setVisible(true);
	//jf.setSize(560,658);
	jf.setSize(jf.getToolkit().getScreenSize());
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	


}
	
	class Transferr implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			String amount= ammtf.getText();
			int a = Integer.parseInt(amount);
			
			String accountn= accntf.getText();
			int n =Integer.parseInt(accountn);
			
			Connection con =DataBaseConnection.javaConnection();
			try
			{
			Statement st= con.createStatement();
			String q="select * from banking where id='"+usrid+"'";
			 ResultSet rr=st.executeQuery(q);
			 if(rr.next())
				{
				 int b = rr.getInt("balance");
					int f=b-a;
					String q2= "update banking set balance="+f+" where id = "+usrid+" ";

					int z=JOptionPane.showConfirmDialog(null, "Do you want to transfer?");
					if(z==0){
						st.executeUpdate(q2);
						JOptionPane.showMessageDialog(null, "Transfer Successful");
						
						java.util.Date date=new java.util.Date();
						String q3="insert into transaction(accno,date,type,remark,amount) values ("+usrid+",'"+date.toString()+"','savings','ammount deposited',"+f+")";
						st.executeUpdate(q3);
						
						
						
						
						
					}
			
				 
				}
			}
			 catch (SQLException e) {
					e.printStackTrace();
				}
			
			 
				Connection conn =DataBaseConnection.javaConnection();
				try
				{
				Statement st= conn.createStatement();
				String qq="select * from banking where id='"+n+"'";
				 ResultSet rrr=st.executeQuery(qq);
				 if(rrr.next())
					{
					 int b = rrr.getInt("balance");
						int f=b+a;
						String q4= "update banking set balance="+f+" where id = "+n+" ";
						st.executeUpdate(q4);
						
						
						
							
							java.util.Date date=new java.util.Date();
							String q3="insert into transaction(accno,date,type,remark,amount) values ("+usrid+",'"+date.toString()+"','savings','ammount deposited',"+f+")";
							st.executeUpdate(q3);
							
							
							
							
							
						}
				
					 
					
				}
				 catch (SQLException e) {
						e.printStackTrace();
					}
			
			
			
			
		}
		
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
