package bank;
import java.awt.Color;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ForgetPass {
	JFrame jf;
	JButton logbt,resbt,fpwbt;
	JPanel jp;
	JLabel idlb,pwlb,anlb,selb;
	JPasswordField usrpf;
	JTextField idtf,antf;
	JComboBox cb;
	
	public ForgetPass()
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
	idtf.setBounds(200,100,100,30);
	jp.add(idtf);
	
	selb= new JLabel("Security Question");
	selb.setBounds(50,150,300,30);
	jp.add(selb);
	
	cb=new JComboBox();
	cb.setBounds(200,150,100,30);
	jp.add(cb);
	
	anlb= new JLabel("Answer");
	anlb.setBounds(50,200,100,30);
	jp.add(anlb);
	
	antf=new JTextField();
	antf.setBounds(200,200,100,30);
	jp.add(antf);
	
	
	
	
	
	
	
	
	
	
	
	
	
	jf.add(jp);
	
	
	jf.setVisible(true);
	//jf.setSize(560,658);
	jf.setSize(jf.getToolkit().getScreenSize());
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	
	
	
	
	
	}
	

}
