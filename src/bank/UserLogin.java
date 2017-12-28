package bank;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;





public class UserLogin {
	JFrame jf;
	JPanel jp;
	JButton logbt,resbt,fpwbt,subt,adbt;
	JLabel idlb,pwlb,lolb,relb;
	JPasswordField usrpf,ausrpf;
	JTextField idtf,aidtf;

	
	
	
	
	public UserLogin()
	{
		jf= new JFrame("Bank");
		jp=new JPanel();
		jp.setLayout(null);
		int i=(int)(Math.random()*255);
		int j=(int)(Math.random()*255);
		int k=(int)(Math.random()*255);
	Color cc1=new Color(i,j,k);
	jp.setBackground(cc1);
	
	idlb= new JLabel("ID");
	idlb.setBounds(50,100,100,30);
	jp.add(idlb);
	
	idtf=new JTextField();
	idtf.addKeyListener(new LoginButton());
	idtf.setBounds(150,100,100,30);
	jp.add(idtf);
	
	pwlb= new JLabel("password");
	pwlb.setBounds(50,150,100,30);
	jp.add(pwlb);
	
	usrpf=new JPasswordField();
	usrpf.addKeyListener(new LoginButton());
	usrpf.setBounds(150,140,100,30);
	jp.add(usrpf);
	
	lolb= new JLabel("Login");
	lolb.setBounds(50,200,100,30);
	jp.add(lolb);
	
	logbt= new JButton("login");
	logbt.addActionListener(new LoginButton());
	logbt.addKeyListener(new LoginButton());
	
	logbt.setBounds(150, 200, 122, 30);
	jp.add(logbt);
	//jf.add(BorderLayout.EAST,logbt);
	
	relb= new JLabel("Reset");
	relb.setBounds(50,250,100,30);
	jp.add(relb);
	
	resbt= new JButton("Reset");
	resbt.addActionListener(new Reset());
	resbt.addKeyListener(new LoginButton());
	resbt.setBounds(150, 250, 120, 30);
	jf.add(resbt);
	
	fpwbt= new JButton("Forget Password");
	fpwbt.addActionListener(new harshit());
	fpwbt.addKeyListener(new LoginButton());
	fpwbt.setBounds(150, 300, 300, 30);
	jf.add(fpwbt);
	
	
	fpwbt= new JButton("Admin Login");
	fpwbt.addActionListener(new Admin());
	fpwbt.setBounds(150, 500, 300, 30);
	jf.add(fpwbt);
		
	
	
	aidtf=new JTextField();
	aidtf.setBounds(150,400,100,30);
	jp.add(aidtf);
	
	ausrpf=new JPasswordField();
	ausrpf.setBounds(150,450,100,30);
	jp.add(ausrpf);
	
	idlb= new JLabel("Admin ID");
	idlb.setBounds(80,400,100,30);
	jp.add(idlb);
	
	pwlb= new JLabel("Admin password");
	pwlb.setBounds(50,450,100,30);
	jp.add(pwlb);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	jf.add(jp);
	
	
	jf.setVisible(true);
	//jf.setSize(560,658);
	jf.setSize(jf.getToolkit().getScreenSize());
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	class harshit implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			new ForgetPass();
			jf.dispose();
		}
		
	}
	
	class Reset implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) 
		{
			new UserLogin();
		}
		}
	
	
	
	class Admin implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) 
		{
			String auid=aidtf.getText();
			String apwd=ausrpf.getText();
			if(auid.equals("1")&& apwd.equals("hhh"))
			{
				jf.dispose();
				new AdminWelcome();
				
			}
			
			
			
		}
		}
	
	
	
	class LoginButton implements ActionListener,KeyListener
	{

		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent arg0) 
		{
			String usrid= idtf.getText();
			String psw=usrpf.getText();
			//String psw=usrpf.getText();
			Connection cnt =DataBaseConnection.javaConnection();
			try {
				Statement stt= cnt.createStatement();
				String qq="select * from banking where id='"+usrid+"' and password='"+psw+"'";
				 ResultSet rr=stt.executeQuery(qq);
				 if(rr.next())
					{
						jf.dispose();
						new UserWelcome(rr.getString("id"));
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Username or Password");
						idtf.setText(null);
						usrpf.setText("");
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			}

		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int kk=e.getKeyCode();
			if (kk==e.VK_ENTER)
			{
				System.out.println("hello");

				String usrid= idtf.getText();
				String psw=usrpf.getText();
				Connection cnt =DataBaseConnection.javaConnection();
				try {
					Statement stt= cnt.createStatement();
					String qq="select * from banking where id='"+usrid+"' and password='"+psw+"'";
					 ResultSet rr=stt.executeQuery(qq);
					 if(rr.next())
						{
							jf.dispose();
							new UserWelcome(rr.getString("id"));
							
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Invalid Username or Password");
							idtf.setText(null);
							usrpf.setText("");
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			}
				
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		
			
		}
			
			
		}
		
	}
	
	


