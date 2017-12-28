package bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Aedit {
	
	JFrame jf;
	JPanel jp;
	JLabel idlb,nalb, acctyplb, ballb,eallb,baalb,addlb,fallb,mollb,cillb,stllb;
	String name;
	String usrid;
	JButton a,b,c,cc;
	JRadioButton rb[];
	ButtonGroup bg;
	
	
	JTextField idtf[],nametf[],balancetf[],addresstf[],emailtf[],fnametf[],mnametf[],cttf[],sttf[];
	ArrayList<BankUserList>ll;
	public Aedit(ArrayList<BankUserList>lll)
	{   ll=lll;
		jf= new JFrame();
		jp= new JPanel();
		jp.setLayout(null);
		
		b= new JButton("Back");
		b.addActionListener(new Back());
		b.setBounds(1000, 150, 100, 30);
		jf.add(b);
		
		c= new JButton("Logout");
		c.addActionListener(new LogOut());
		c.setBounds(1200, 150, 100, 30);
		jf.add(c);
   
		cc= new JButton("Edit");
		cc.addActionListener(new Editpro());
		cc.setBounds(1100, 200, 100, 30);
		jf.add(cc);
   
	 
		idlb=new JLabel("ID");                
		idlb.setBounds(10, 30, 100, 25);
		jp.add(idlb);
		

		nalb=new JLabel("Name");
		nalb.setBounds(110, 30, 100, 25);
		jp.add(nalb);

		baalb=new JLabel("Balance");
		baalb.setBounds(210, 30, 100, 25);
		jp.add(baalb);

		addlb=new JLabel("Address");
		addlb.setBounds(310, 30, 100, 25);
		jp.add(addlb);
		
		eallb=new JLabel("Email");
		eallb.setBounds(410, 30, 100, 25);
		jp.add(eallb);
		
		fallb=new JLabel("Father name");
		fallb.setBounds(510, 30, 100, 25);
		jp.add(fallb);
		
		mollb=new JLabel("Mother name");
		mollb.setBounds(610, 30, 100, 25);
		jp.add(mollb);
		
		cillb=new JLabel("City");
		cillb.setBounds(710, 30, 100, 25);
		jp.add(cillb);
		
		stllb=new JLabel("State");
		stllb.setBounds(810, 30, 100, 25);
		jp.add(stllb);
		
		bg= new ButtonGroup();
		idtf= new JTextField[ll.size()];
        nametf= new JTextField[ll.size()];
		balancetf= new JTextField[ll.size()];
		addresstf= new JTextField [ll.size()];
		emailtf= new JTextField [ll.size()];
		fnametf= new JTextField [ll.size()];
		mnametf= new JTextField [ll.size()];
		cttf= new JTextField [ll.size()];
		sttf= new JTextField [ll.size()];
		rb= new JRadioButton[ll.size()];
	
		System.out.println(ll.size());
		int i=0,y=100;
		for(BankUserList ba:ll)
		{
		idtf[i] =new JTextField(ba.getId());
		idtf[i].setBounds(10, y, 100, 25);
		jp.add(idtf[i]);
		
		nametf[i]  =new JTextField(ba.getName());
		nametf[i].setBounds(110, y, 100, 25);
		jp.add(nametf[i]);
		
		balancetf[i]=new JTextField(ba.getBalance());
		balancetf[i].setBounds(210, y, 100, 25);
		jp.add(balancetf[i]);
		
		addresstf[i]=new JTextField(ba.getAddress());
		addresstf[i].setBounds(310, y, 100, 25);
		jp.add(addresstf[i]);
		
		emailtf[i] =new JTextField(ba.getEmail());
		emailtf[i].setBounds(410, y, 100, 25);
		jp.add(emailtf[i]);
		
		fnametf[i] =new JTextField(ba.getFathername());
		fnametf[i].setBounds(510, y, 100, 25);
		jp.add(fnametf[i]);
		
		mnametf[i] =new JTextField(ba.getMothername());
		mnametf[i].setBounds(610, y, 100, 25);
		jp.add(mnametf[i]);
		
		cttf[i] =new JTextField(ba.getCity());
		cttf[i].setBounds(710, y, 100, 25);
		jp.add(cttf[i]);
		
		sttf[i] =new JTextField(ba.getState());
		sttf[i].setBounds(810, y, 100, 25);
		jp.add(sttf[i]);
		
		rb[i] =new JRadioButton();
		rb[i].setBounds(910, y, 100, 25);
	    jp.add(rb[i]);
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
			new Editt();
		
			
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
	
	class Editpro implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			int i=0;
			
			for(i=0;i<ll.size();i++)
			{
				if(rb[i].isSelected()){
					String zzz=idtf[i].getText();
					int id = Integer.parseInt(zzz);
					jf.dispose();
					new Editproo(id);
					
					
				}
					
			}
			
			
		}
		
			
			
			
			
			
		
			
		}
		
	}
	
	



