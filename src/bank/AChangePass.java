package bank;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;



public class AChangePass {
	
	JFrame jf;
	JPanel jp;
	JLabel opl,npl,cpl;
	JPasswordField op,np,cp;
	JButton resbt,b,c;
	String usrid;
	
	
	public AChangePass()
	{
		
		
		jf= new JFrame("Admin User Change Password");
		jp=new JPanel();
		jp.setLayout(null);
		int i=(int)(Math.random()*255);
		int j=(int)(Math.random()*255);
		int k=(int)(Math.random()*255);
	Color cc1=new Color(i,j,k);
	jp.setBackground(cc1);
	
	
	opl= new JLabel(" Old password");
	opl.setBounds(50,150,100,30);
	jp.add(opl);
	
	op=new JPasswordField();
	op.setBounds(180,150,100,30);
	jp.add(op);
	
	npl= new JLabel(" New password");
	npl.setBounds(50,200,100,30);
	jp.add(npl);
	
	np=new JPasswordField();
	np.setBounds(180,200,100,30);
	jp.add(np);
	

	cpl= new JLabel(" Confirm password");
	cpl.setBounds(50,250,190,30);
	jp.add(cpl);
	
	cp=new JPasswordField();
	cp.setBounds(180,250,100,30);
	jp.add(cp);
	
	resbt= new JButton("change");
	resbt.addActionListener(new Change());
	resbt.setBounds(180, 300, 122, 30);
	jf.add(resbt);
	
	
	b= new JButton("Back");
	b.addActionListener(new Back());
	b.setBounds(150, 300, 100, 30);
	jf.add(b);
	
	c= new JButton("Logout");
	c.addActionListener(new LogOut());
	c.setBounds(300,300, 100, 30);
	jf.add(c);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
jf.add(jp);
	
	
	jf.setVisible(true);
	//jf.setSize(560,658);
	jf.setSize(jf.getToolkit().getScreenSize());
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
	
	class Change implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) 
		{
			
			String ss=JOptionPane.showInputDialog(null, "input id");
		
	
			String oldpass= op.getText();
			String newpass = np.getText();
			String conpass = cp.getText();
			if(!newpass.equals(conpass))
			{
				JOptionPane.showMessageDialog(null,"new and confirm password doesn't match");
				op.setText(null);
				np.setText(null);
				cp.setText(null);
				return;
			}
			Connection cnt =DataBaseConnection.javaConnection();
			try {
			
				Statement stt= cnt.createStatement();
				String q="update banking set password='"+newpass+"' where password='"+oldpass+"' and id='"+ss+"'";
				  int rr=stt.executeUpdate(q);
				 if(rr==1)
					{
					 System.out.println("hello");
					JOptionPane.showMessageDialog(null,"password changed succefully");
						jf.dispose();
						new UserLogin();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid old Password");
						op.setText(null);
						np.setText(null);
						cp.setText(null);
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
