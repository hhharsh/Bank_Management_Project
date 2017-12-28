package bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Adminapprovee {
	JFrame jf;
	JPanel jp;   
	JLabel accnolb, datelb, acctyplb, ballb;
	String name;
	String usrid;
	String lid;
	JButton a,b,c,ad,dd;
	JCheckBox cb;
	
	JTextField loanidtf[],typetf[],ammounttf[];
	JCheckBox checkboxt[];
	ArrayList<Adminuserlist>tt;
	public Adminapprovee(ArrayList<Adminuserlist>ttt)
	{  
		tt=ttt;
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
		
		ad= new JButton("Approve");
		ad.addActionListener(new Approveee());
		ad.setBounds(500,200, 100, 30);
		jf.add(ad);
		
		dd= new JButton("Deny");
		dd.addActionListener(new Deny());
		dd.setBounds(650,200, 100, 30);
		jf.add(dd);
   
	 
		accnolb=new JLabel("LoanId");                
		accnolb.setBounds(10, 30, 100, 25);
		jp.add(accnolb);
		

		datelb=new JLabel("Type");
		datelb.setBounds(110, 30, 100, 25);
		jp.add(datelb);

		acctyplb=new JLabel("Ammount");
		acctyplb.setBounds(210, 30, 100, 25);
		jp.add(acctyplb);

		loanidtf= new JTextField[tt.size()];
        typetf= new JTextField[tt.size()];
		ammounttf= new JTextField[tt.size()];
		checkboxt=new JCheckBox[tt.size()];
		
		System.out.println(tt.size());
		int i=0,y=100;
		for(Adminuserlist uu:tt)
		{
		loanidtf[i] =new JTextField(uu.getLoanid());
		loanidtf[i].setBounds(10, y, 100, 25);
		jp.add(loanidtf[i]);
		
		typetf[i]  =new JTextField(uu.getType());
		typetf[i].setBounds(110, y, 100, 25);
		jp.add(typetf[i]);
		
		ammounttf[i]=new JTextField(uu.getAmmount());
		ammounttf[i].setBounds(210, y, 100, 25);
		jp.add(ammounttf[i]);
		
		checkboxt[i] =new JCheckBox(uu.getLoanid());
		checkboxt[i].setBounds(310, y, 100, 25);
	    jp.add(checkboxt[i]);
		
		i++;
		y=y+30;
		}
		
		
		
		jf.add(jp);
		jf.setVisible(true);
		jf.setSize(jf.getToolkit().getScreenSize());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	
	class Approveee implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
	

		int i=0,j=0,k=0;
		Connection con = DataBaseConnection.javaConnection();
		
		try {
			Statement st = con.createStatement();
			
			String q1 = "select * from loanreq";
			ResultSet r1 = st.executeQuery(q1);
			
			while(r1.next()){
				i++;
				}
			int m =JOptionPane.showConfirmDialog(null,  "Do you want to approve the selected loans?", "Confirmation", 2);
			if(m==0){
				for(j=0; j<i;j++){
					if(checkboxt[j].isSelected()){
						
						String loanid= loanidtf[j].getText();
						String q2 = "update loanreq set Status='Approved' where loanid='"+loanid+"'";
						k = st.executeUpdate(q2);
							
						}
					}
			
				if(k==1){
					JOptionPane.showMessageDialog(null, "Loan Status changed to Approved");
										
				}
			}
			for(j=0;j<i;j++){
				checkboxt[j].setSelected(false);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
	}
		
	
	class Deny implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
	

		int i=0,j=0,k=0;
		Connection con = DataBaseConnection.javaConnection();
		
		try {
			Statement st = con.createStatement();
			
			String q1 = "select * from loanreq";
			ResultSet r1 = st.executeQuery(q1);
			
			while(r1.next()){
				i++;
				}
			int m =JOptionPane.showConfirmDialog(null,  "Do you want to deny the selected loans?", "Confirmation", 2);
			if(m==0){
				for(j=0; j<i;j++){
					if(checkboxt[j].isSelected()){
						
						String loanid= loanidtf[j].getText();
						String q2 = "update loanreq set Status='Denied' where loanid='"+loanid+"'";
						k = st.executeUpdate(q2);
							
						}
					}
			
				if(k==1){
					JOptionPane.showMessageDialog(null, "Loan Status changed to Denied");
										
				}
			}
			for(j=0;j<i;j++){
				checkboxt[j].setSelected(false);
			}
		} catch (SQLException e) {
			
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
