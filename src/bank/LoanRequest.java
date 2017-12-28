package bank;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D.Double;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import bank.ChangePass.Back;
import bank.ChangePass.LogOut;

public class LoanRequest {
	JFrame jf;
	JPanel jp;
	JLabel opl,a,b,c,d,aml,e, Monthslb;
	JTextField amt,abt,ny;
	JPasswordField op,np,cp;
	JComboBox com,com2,idfield;
	JButton cc,bb,dd,calcbt;
	String usrid,bbb;
	


	
	public LoanRequest(String usrid)
	{
		this.usrid=usrid;
		jf= new JFrame("Loan Request");
		jp=new JPanel();
		jp.setLayout(null);
		int i=(int)(Math.random()*255);
		int j=(int)(Math.random()*255);
		int k=(int)(Math.random()*255);
	Color cc1=new Color(i,j,k);
	jp.setBackground(cc1);
	
	
	
	opl= new JLabel(" Types of loan");
	
	opl.setBounds(50,150,100,30);
	jp.add(opl);
	
	com=new JComboBox();
	com.addItem("Personal Loan");
	com.addItem("Education Loan");
	com.addItem("Loan against bank FDs");
	com.addItem("Home Loan");
	com.setBounds(200,150,100,30);
	jp.add(com);
	
	
    aml= new JLabel("Loan Amount");
	aml.setBounds(50,200,100,30);
	jp.add(aml);
	
	amt=new JTextField();
	amt.setBounds(200,200,100,30);
	jp.add(amt);
    
	
	d= new JLabel("Tentative EMI");
	d.setBounds(50,300,100,30);
	jp.add(d);
	
	ny=new JTextField();
	ny.setBounds(200,300,100,30);
	jp.add(ny);
	
	 Monthslb= new JLabel("Months");
	 Monthslb.setBounds(50,350, 150, 30);
	 jp.add(Monthslb);
	 
	  idfield=  new JComboBox();
	 idfield.setBounds(200, 350, 150, 30);
	 idfield.addItem("12");
	 idfield.addItem("24");
	 idfield.addItem("36");
	 idfield.addItem("48");
	 idfield.addItem("60");
	 jp.add(idfield);
	
	
	 calcbt = new JButton("Calculate");
	 calcbt.addActionListener(new CalculateButton());
	 calcbt.setBounds(300,400,150,30);
	 jp.add(calcbt);
	
	
	
	
	cc= new JButton("Submit");
	cc.addActionListener(new SubmitButton());
	cc.setBounds(200, 400, 100, 30);
	jf.add(cc);	
	
	
	bb= new JButton("Back");
	bb.addActionListener(new Back());
	bb.setBounds(150, 450, 100, 30);
	jf.add(bb);
	
	dd= new JButton("Logout");
	dd.addActionListener(new LogOut());
	dd.setBounds(280,450, 100, 30);
	jf.add(dd);
	
jf.add(jp);
	
	
	jf.setVisible(true);
	//jf.setSize(560,658);
	jf.setSize(jf.getToolkit().getScreenSize());
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
	
	class CalculateButton implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) 
		{
			Connection cnt= DataBaseConnection.javaConnection();
			try {
				Statement stt= cnt.createStatement();
				String type=com.getSelectedItem().toString();
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																	
				String q1= "select * from loantype where type='"+type+"'";
				ResultSet r1= stt.executeQuery(q1);
				System.out.println("r1 working");
				
				int Rate=0;
				if (r1.next())
				{
				 
					Rate=r1.getInt("interestrate");
				}
				
				String am=amt.getText();   
				int amtt= Integer.parseInt(am);
				String months=idfield.getSelectedItem().toString();
				int Months= Integer.parseInt(months);
				

				int Temi= (Months*amtt*Rate)/12;
				String TentEmi= Integer.toString(Temi);
				
				if(Temi>0)
				{		  
					ny.setText(TentEmi);
				}
			    
				else
				{
					JOptionPane.showMessageDialog(null, " Error? please check the amount .");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
	
	class SubmitButton implements ActionListener
	{

	
		public void actionPerformed(ActionEvent arg0) 
		{
			Connection cnt= DataBaseConnection.javaConnection();
			String type=com.getSelectedItem().toString();  
			System.out.println("hi");
			
			String amtt=amt.getText();   
			int Amt= Integer.parseInt(amtt);
			
			String months=idfield.getSelectedItem().toString();
			int Months= Integer.parseInt(months);
			
		
			String Temi=ny.getText();
		
						
			int dialogButton=JOptionPane.YES_NO_OPTION;
			
		JOptionPane.showConfirmDialog(null, "Are you sure", "confirm",dialogButton );
		
		if(dialogButton==JOptionPane.YES_OPTION)
		{
			
			try {
				
				Statement stt= cnt.createStatement();

																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																	String q1= "select * from loantype where type='"+type+"'";
				ResultSet r1= stt.executeQuery(q1); 
			
				
				int Rate=0;
				if (r1.next())
				{
				 
					Rate=r1.getInt("interestrate");
				}
				
				Statement st=cnt.createStatement();
				String qqq = "select * from banking where id='"+usrid+"'";
				ResultSet rrr=st.executeQuery(qqq);
				
				if(rrr.next())
				{
			    System.out.println("singh");
				int aaa=rrr.getInt("id");
				System.out.println(aaa);
				 bbb=String.valueOf(aaa);
				 
				}
				java.util.Date date=new java.util.Date();
				
				String q5 = "select * from loanreq where loanid like '%-"+bbb+"%' ";
				ResultSet zz=st.executeQuery(q5);
				System.out.println("king1");
				if(zz.next())
				{
					System.out.println("king2");
				
					int i=2;
					while(zz.next())
					{
						i++;
					}
				
					if(i<10)
					{
					
						String priid="000"+i+"";
					
					
					
						String lid;
						lid= priid+"-"+bbb;
						
						System.out.println("hhh");
						
						
						String q3= "insert into loanreq(loanid,type,ammount,emiperiod,tentativeemi,status,irate,dof) values ('"+lid+"','"+type+"','"+Amt+"','"+Months+"','"+Temi+"','pending','"+Rate+"','"+date.toString()+"')";
						System.out.println("query working");
						st.executeUpdate(q3);
						System.out.println("statement working");
						
					}	
				
				else if(i<99)
				{

					String priid="00"+i+"";
					String lid;
					lid= priid+"-"+bbb;
					String q4= "insert into loanreq(loanid,type,ammount,emiperiod,tentativeemi,status,irate,dof) values ('"+lid+"','"+type+"','"+Amt+"','"+Months+"','"+Temi+"','pending','"+Rate+"','"+date.toString()+"')";
					 st.executeUpdate(q4);
				}
				}
				else
				{  
					System.out.println("statement working");
					String lid="0001"+"-"+bbb;
					String q4= "insert into loanreq(loanid,type,ammount,emiperiod,tentativeemi,status,irate,dof) values ('"+lid+"','"+type+"','"+Amt+"','"+Months+"','"+Temi+"','pending','"+Rate+"','"+date.toString()+"')";
					 st.executeUpdate(q4);
				}
				
			}
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			JOptionPane.showMessageDialog(null, "new loan request submitted");
			
		}
		}
	}
}
		
		
	
	
	
	

		
	


