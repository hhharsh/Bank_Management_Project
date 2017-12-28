package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Editproo {
	
	JFrame jf;
	JButton supbt,lb;
	JPanel jp;
	JLabel a,b,c,d,e,f,g,h,ij,jk,selb,anlb,ga,fa;
	JPasswordField usrpf;
	JTextField a1,antf,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11;
	JRadioButton mrad,frad;
	JComboBox cb;
	ButtonGroup genrb;
	int usrid;
	
	
	public Editproo(int id)
	{
        usrid=id;
		jf= new JFrame("Edit Profile");
		jp=new JPanel();
		jp.setLayout(null);
		int i=(int)(Math.random()*255);
		int j=(int)(Math.random()*255);
		int k=(int)(Math.random()*255);
	Color cc1=new Color(i,j,k);
	jp.setBackground(cc1);
	
	 Connection con = DataBaseConnection.javaConnection();
	 
	 try {
		Statement st = con.createStatement();
		
		String q1 = "select * from banking where id="+usrid+" ";
		
		ResultSet r1= st.executeQuery(q1);
	
		if(r1.next()){
	
	
	a=new JLabel("User Name");
	a.setBounds(50,20,200,80);
	jp.add(a);
	Font ff=new Font("forte",Font.BOLD,30);
	a.setFont(ff);
	
	a1=new JTextField();
	a1.setText(r1.getString("name"));
	a1.setBounds(270,45,200,30);
	jp.add(a1);
	
	
	b=new JLabel("Father Name");
	b.setBounds(50,70,200,80);
	jp.add(b);
	Font gg=new Font("forte",Font.BOLD,30);
	b.setFont(gg);
	
	a2=new JTextField();
	a2.setText(r1.getString("fathername"));
	a2.setBounds(270,90,200,30);
	jp.add(a2);
	
	c=new JLabel("Mother Name");
	c.setBounds(50,120,300,80);
	jp.add(c);
	Font hh=new Font("forte",Font.BOLD,30);
	c.setFont(hh);
	
	a3=new JTextField();
	a3.setText(r1.getString("mothername"));
	a3.setBounds(270,140,200,30);
	jp.add(a3);
	
	
	d=new JLabel("Gender");
	d.setBounds(50,170,200,80);
	jp.add(d);
	Font jj=new Font("forte",Font.BOLD,50);
	d.setFont(jj);
	
	e=new JLabel("Male");
	e.setBounds(50,220,200,80);
	jp.add(e);
	Font kk=new Font("forte",Font.BOLD,30);
	e.setFont(kk);
	
	mrad=new JRadioButton();
	mrad.setBounds(150, 250,20,20);
	jp.add(mrad);
	
	e=new JLabel("Female");
	e.setBounds(400,220,200,80);
	jp.add(e);
	Font ll=new Font("forte",Font.BOLD,30);
	e.setFont(ll);
	
	frad=new JRadioButton();
	frad.setBounds(530,250,20,20);
	jp.add(frad);
	
	 genrb = new ButtonGroup();
	 genrb.add(mrad);
	 genrb.add(frad);
	 
	 
	 String ggg= r1.getString("gender");
	 if(ggg.equals("male"))
	 {
		 mrad.setSelected(true);
		 frad.setSelected(false);
	 }
	 else{
		 frad.setSelected(true);
		 mrad.setSelected(false);
	 }
	 
	
	f=new JLabel("Mobile No:");
	f.setBounds(50,260,200,80);
	jp.add(f);
	Font zz=new Font("forte",Font.BOLD,30);
	f.setFont(zz);
	
	a4=new JTextField();
	a4.setBounds(270,280,200,30);
	jp.add(a4);
	
	ga=new JLabel("Landline No:");
	ga.setBounds(50,310,200,80);
	Font xx=new Font("forte",Font.BOLD,30);
	ga.setFont(xx);
	jp.add(ga);
	
	a5=new JTextField();
	a5.setBounds(270,330,200,30);
	jp.add(a5);
	
	
	f=new JLabel("Email Id");
	f.setBounds(50,360,200,80);
	jp.add(f);
	Font cc=new Font("forte",Font.BOLD,30);
	f.setFont(cc);
	
	a6=new JTextField();
	a6.setText(r1.getString("email"));
	a6.setBounds(270,390,200,30);
	jp.add(a6);
	
	
	fa=new JLabel("Address");
	fa.setBounds(50,410,200,80);
	jp.add(fa);
	Font vv=new Font("forte",Font.BOLD,30);
	fa.setFont(vv);
	
	a7=new JTextField();
	a7.setText(r1.getString("address"));
	a7.setBounds(270,440,200,30);
	jp.add(a7);
	
	
	f=new JLabel("City");
	f.setBounds(50,460,200,80);
	jp.add(f);
	Font bb=new Font("forte",Font.BOLD,30);
	f.setFont(bb);
	
	a8=new JTextField();
	a8.setText(r1.getString("city"));
	a8.setBounds(270,490,200,30);
	jp.add(a8);
	
	
	g=new JLabel("State");
	g.setBounds(50,510,200,80);
	jp.add(g);
	Font nn=new Font("forte",Font.BOLD,30);
	g.setFont(nn);
	
	a9=new JTextField();
	a9.setText(r1.getString("state"));
	a9.setBounds(270,540,200,30);
	jp.add(a9);
	
	
	h=new JLabel("Country");
	h.setBounds(50,560,200,80);
	jp.add(h);
	Font mm=new Font("forte",Font.BOLD,30);
	h.setFont(mm);
	
	a10=new JTextField();
	a10.setBounds(270,590,200,30);
	jp.add(a10);
	
	ij=new JLabel("Account Type");
	ij.setBounds(50,600,200,80);
	jp.add(ij);
	Font tt=new Font("forte",Font.BOLD,30);
	ij.setFont(tt);
	
	
	cb=new JComboBox();
	cb.addItem("saving");
	cb.addItem("current");
	cb.addItem("ppf");
	cb.setBounds(270,630,200,30);
	jp.add(cb);
	
	jk=new JLabel("Starting Amount");
	jk.setBounds(50,650,400,80);
	jp.add(jk);
	Font yy=new Font("forte",Font.BOLD,30);
	jk.setFont(yy);
	
	a11=new JTextField();
	a11.setBounds(300,675,200,30);
	jp.add(a11);
	
	
	
	selb= new JLabel("Security Question");
	selb.setBounds(700,40,300,30);
	jp.add(selb);
	Font sq=new Font("forte",Font.BOLD,30);
	selb.setFont(sq);
	
	cb=new JComboBox();
	 cb.addItem("Which is your birth place");
	 
	 
	cb.setBounds(1000,40,300,30);
	jp.add(cb);
	
	anlb= new JLabel("Answer..........");
	anlb.setBounds(700,110,500,30);
	jp.add(anlb);
	Font an=new Font("forte",Font.BOLD,30);
	anlb.setFont(an);
	
	antf=new JTextField();
	antf.setText(r1.getString("securityans"));
	antf.setBounds(1000,110,300,30);
	jp.add(antf);
	
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	supbt=new JButton("Edit");
	supbt.addActionListener(new Edittt());
	supbt.setBounds(1000,200,200,30);
	jp.add(supbt);
	
	
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
	
	class Edittt implements ActionListener
	{

		
		public void actionPerformed(ActionEvent arg0) 
		{
			
			String name = a1.getText();
			String father = a2.getText();
			String mother = a3.getText();
			String email  = a6.getText();
			String address =a7.getText();
			String city = a8.getText();
			String state = a9.getText();
			String country =a10.getText();
			String mobile = a4.getText();
			String land = a5.getText();
			try {
				Connection con =  DataBaseConnection.javaConnection();
				Statement st = con.createStatement();
				String q2="select * from banking where id="+usrid+"";
				ResultSet r1=st.executeQuery(q2);
				if(r1.next()){
				String q1="update banking set name='"+name+"',fathername='"+father+"',mothername='"+mother+"',email='"+email+"',address='"+address+"',city='"+city+"',state='"+state+"',mobile='"+mobile+"',landline='"+land+"',country='"+country+"' where id="+usrid+"";
				int j=JOptionPane.showConfirmDialog(null, "Do you want to update the changes", "Confirmation", 2);
				if(j==0){
					int i= st.executeUpdate(q1);
					
					if (i==1){
						JOptionPane.showMessageDialog(null, "Information Updated");
						jf.dispose();
						new Editt();
					}
				}
				
				else if(j==1)
				{
					jf.dispose();
					new Editt();
				}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	
	class Signput implements ActionListener
	{

		
		public void actionPerformed(ActionEvent arg0) 
		{
			
			String uname= a1.getText(); 
			String balance= a11.getText(); 
			String address= a7.getText(); 
			String email= a6.getText(); 
			String secans= antf.getText(); 
			String fname= a2.getText(); 
			String mname= a3.getText(); 
			String city= a8.getText(); 
			String state= a9.getText(); 
			int dialogButton=JOptionPane.YES_NO_OPTION;
			
			JOptionPane.showConfirmDialog(null, "Are you sure", "confirm",dialogButton );
			
			if(dialogButton==JOptionPane.YES_OPTION)
			{
				Connection cnnt = DataBaseConnection.javaConnection();
				try {
					
					Statement sttt=cnnt.createStatement();
                    String qqqq= "insert into banking(password,balance,address,email,gender,securityans,fathername,mothername,city,state,name,type) values ('password','"+balance+"','"+address+"','"+email+"','male','"+secans+"','"+fname+"','"+mname+"','"+city+"','"+state+"','"+uname+"','aaa')";
                   sttt.executeUpdate(qqqq);	
					System.out.println("statement working");
					
					
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	           }
			}
					
			
			
			
			
			
			
			
			
			
		}

}
