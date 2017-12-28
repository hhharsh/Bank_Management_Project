package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Editt {
	
	JFrame jf;
	JButton supbt,lb,se;
	JPanel jp;
	JLabel a,b,c,d,e,f,g,h,ij,jk,selb,anlb;
	JPasswordField usrpf;
	JTextField a1,antf,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11;
	JRadioButton rad;
	JComboBox cb;
	
	
	public Editt()
	{
		jf= new JFrame("View Page");
		jp=new JPanel();
		jp.setLayout(null);
		int i=(int)(Math.random()*255);
		int j=(int)(Math.random()*255);
		int k=(int)(Math.random()*255);
	Color cc1=new Color(i,j,k);
	jp.setBackground(cc1);
	
	
	a=new JLabel("User Name");
	a.setBounds(50,20,200,80);
	jp.add(a);
	Font ff=new Font("forte",Font.BOLD,30);
	a.setFont(ff);
	
	a1=new JTextField();
	a1.setBounds(270,45,200,30);
	jp.add(a1);
	
	
	b=new JLabel("Father Name");
	b.setBounds(50,70,200,80);
	jp.add(b);
	Font gg=new Font("forte",Font.BOLD,30);
	b.setFont(gg);
	
	a2=new JTextField();
	a2.setBounds(270,90,200,30);
	jp.add(a2);
	
	se= new JButton("Search");
	se.addActionListener(new Searchh());
	se.setBounds(1000,200, 200, 30);
	jf.add(se);
	
	
	lb= new JButton("Logout");
	lb.addActionListener(new LogOut());
	lb.setBounds(1000,300, 200, 30);
	jf.add(lb);
	
	
	
	
	
	
	
	
	
jf.add(jp);
	
	
	jf.setVisible(true);
	//jf.setSize(560,658);
	jf.setSize(jf.getToolkit().getScreenSize());
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
}
	
	class LogOut implements ActionListener
	{

		
		public void actionPerformed(ActionEvent arg0) 
		{
			jf.dispose();
			new UserLogin();
		}
		
	}
	
	
	
	class Searchh implements ActionListener
	{

		
		public void actionPerformed(ActionEvent arg0) 
		{
			
			String uname= a1.getText(); 
			String fname= a2.getText(); 
			
			 ArrayList<BankUserList>ll=new ArrayList<BankUserList>(); 
			Connection cnnt = DataBaseConnection.javaConnection();
			try {
				
				Statement sttt=cnnt.createStatement();
				
				String q6 = "select * from banking where name like '%"+uname+"%' and fathername like '%"+fname+"%'";
                ResultSet rr=sttt.executeQuery(q6);	
				System.out.println("statement working hhh");
				if(rr.next())
				{
					while(rr.next())
					{
				
					BankUserList ba=new BankUserList();
					
					 ba.setId(rr.getString("id"));
					 ba.setName(rr.getString("name"));
					 ba.setBalance(rr.getString("balance"));
					 ba.setAddress(rr.getString("address"));
					 ba.setEmail(rr.getString("email"));
                     ba.setMothername(rr.getString("mothername"));
                     ba.setCity(rr.getString("city"));
                     ba.setState(rr.getString("state"));
                     ba.setFathername(rr.getString("fathername"));
                    
					 
					 ll.add(ba);
					
					}
				System.out.println(ll.size());
				new Aedit(ll);
				}
				
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
	}

}
