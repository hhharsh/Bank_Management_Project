package bank;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bank.Deposit.Back;
import bank.Deposit.Depamount;
import bank.Deposit.LogOut;

import bank.UserWelcome.Balanceinq;
import bank.UserWelcome.Transaction;
import bank.UserWelcome.cpass;
import bank.UserWelcome.deposit;
import bank.UserWelcome.loanr;
import bank.UserWelcome.tran;
import bank.UserWelcome.with;

public class AdminWelcome {
	
	JFrame jf;
	JButton a,b,c,d,e,f,g,h,k,ii,subt,adbt;
	JPanel jp;
	String name;
	String usrid;

	
	
	
	
	public AdminWelcome()
	{
	
	
	jf= new JFrame("Admin Welcome");
	jp=new JPanel();
	jp.setLayout(null);
	int i=(int)(Math.random()*255);
	int j=(int)(Math.random()*255);
	int k=(int)(Math.random()*255);
Color cc1=new Color(i,j,k);
jp.setBackground(cc1);




a= new JButton("Balance enquiry");
a.addActionListener(new ABalanceinq());
a.setBounds(100, 100, 200, 30);
jf.add(a);

b= new JButton("Deposit");
b.addActionListener(new deposit());
b.setBounds(100, 150, 200, 30);
jf.add(b);

c= new JButton("withdrawl");
c.addActionListener(new with());
c.setBounds(100, 200, 200, 30);
jf.add(c);

d= new JButton("Transfer");
d.addActionListener(new tran());
d.setBounds(100, 250, 200, 30);
jf.add(d);

e= new JButton("Change Password");
e.addActionListener(new cpass());
e.setBounds(100, 300, 200, 30);
jf.add(e);

f= new JButton("Mini Statement");
f.addActionListener(new Transaction());
f.setBounds(100, 350, 200, 30);
jf.add(f);

g= new JButton("Loan request");
g.addActionListener(new loanr());
g.setBounds(100, 400, 200, 30);
jf.add(g);

h= new JButton("Loan status");
h.setBounds(100, 450, 200, 30);
jf.add(h);


ii= new JButton("Approve or Deny");
ii.addActionListener(new Approve());
ii.setBounds(100, 500, 200, 30);
jf.add(ii);

subt= new JButton("Sign up");
subt.addActionListener(new Signnn());
subt.setBounds(100, 550, 300, 30);
jf.add(subt);

adbt= new JButton("View");
adbt.addActionListener(new Edit());
adbt.setBounds(100, 600, 300, 30);
jf.add(adbt);













jf.add(jp);


jf.setVisible(true);
//jf.setSize(560,658);
jf.setSize(jf.getToolkit().getScreenSize());
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
	
	class deposit implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			new ADeposit();
			jf.dispose();
		}
		
	}
	
	class Approve implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
		   ArrayList<Adminuserlist>tt=new ArrayList<Adminuserlist>(); 
		   Connection cnt=DataBaseConnection.javaConnection();
		   try {
			Statement stt=cnt.createStatement();
			String qq="Select * from loanreq";
			ResultSet rr=stt.executeQuery(qq);
			while(rr.next())
			{
				Adminuserlist u=new Adminuserlist();
				 u.setLoanid(rr.getString("loanid"));
				 u.setType(rr.getString("type"));
				 u.setAmmount(rr.getString("ammount"));
				
				 
				 tt.add(u);
			}
			System.out.println(tt.size());
			new Adminapprovee(tt);
			   
		} catch (Exception e2) {
		  e2.printStackTrace();
			
		}
			
			
			}
		
	}
	
	
	
	
	class ABalanceinq implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
		
			Connection con =DataBaseConnection.javaConnection();
			try
			{
				String ss=JOptionPane.showInputDialog(null, "input");
			Statement st= con.createStatement();
			String q="select * from banking where id='"+ss+"'";
			 ResultSet rr=st.executeQuery(q);
			 if(rr.next())
				{
					JOptionPane.showMessageDialog(null, "Main balance is Rs."+rr.getInt("balance")+"");
				}
			}
			 catch (SQLException e) {
					e.printStackTrace();
				}
			
	         }
		
		
	}
	class with implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			new AWithdrawl();
			jf.dispose();
		}
		
	}
	class tran implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			new Transfer(usrid);
			jf.dispose();
		}
		
	}
	class cpass implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			new ChangePass(usrid);
			jf.dispose();
		}
		
	}
	class loanr implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
			jf.dispose();
		}
		
	}
	
	class Signnn implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) 
		{
			new Signn();
			jf.dispose();
		}
		}
	
	class Edit implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) 
		{
			new Editt();
			jf.dispose();
		}
		}
	
	class Balanceinq implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
		
			Connection con =DataBaseConnection.javaConnection();
			try
			{
			Statement st= con.createStatement();
			String q="select * from banking where id='"+usrid+"'";
			 ResultSet rr=st.executeQuery(q);
			 if(rr.next())
				{
					JOptionPane.showMessageDialog(null, "Main balance is Rs."+rr.getInt("balance")+"");
				}
			}
			 catch (SQLException e) {
					e.printStackTrace();
				}
			
	         }
		
		
	}
	
	class Transaction implements ActionListener
	{


		public void actionPerformed(ActionEvent e) {
	   ArrayList<UserList>l=new ArrayList<UserList>(); 
	   Connection cnt=DataBaseConnection.javaConnection();
	   try {
		Statement stt=cnt.createStatement();
		String qq="Select * from transaction where accno='"+usrid+"' ";
		ResultSet rr=stt.executeQuery(qq);
		while(rr.next())
		{
			UserList u=new UserList();
			 u.setAmount(rr.getString("amount"));
			 u.setType(rr.getString("type"));
			 u.setAccno(rr.getString("accno"));
			 u.setDate(rr.getString("date"));
			 
			 l.add(u);
		}
		System.out.println(l.size());
		new MiniStatement(l);
		   
	} catch (Exception e2) {
	  e2.printStackTrace();
		
	}
		}
	}
}


			

