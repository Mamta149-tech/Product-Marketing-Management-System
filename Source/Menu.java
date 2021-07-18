import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Menu extends JFrame implements ActionListener
{
	int w , h ;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension dimension = toolkit.getScreenSize();
	{
		w = (int)dimension.getWidth();
		h = (int)dimension.getHeight();
	}

	Image img;
	JPanel p = new JPanel()
	{
	  {
		img = Toolkit.getDefaultToolkit().createImage("F:\\GUI\\s1.gif");
	  }
	  public void paintComponent(Graphics g)
	  {
		super.paintComponent(g);
		if(img != null)
		{
		 g.drawImage(img ,0 ,0 , w , h , this);
		}
	  }
	 };
	 JPanel p1 = new JPanel();
	 JLabel lbl1 = new JLabel("PATNA DAIRY PROJECT");
     JLabel lbl2 = new JLabel("Vaishal Patliputra Dugdh Utpadak Sahkari Sangh Ltd.");
     JLabel lbl3 = new JLabel("FEEDER BALANCING DAIRY COMPLEX");
     JLabel lbl4 = new JLabel("P.O. PHULWARISHARIF , PATNA - 801505");
     JLabel lbl5 = new JLabel("<html><u>Product Marketing Management System</u></html>");
	 JMenuBar menuBar=new JMenuBar();
	 JMenu m1=new JMenu("Create User");
	JMenu m2=new JMenu("Distribution");
	JMenu m3=new JMenu("Product");
	JMenu m4=new JMenu("Invoice");
	JMenu m5=new JMenu("Status");
	JMenu m6=new JMenu("Report");
	JMenu m7 = new JMenu("Exit");
	JMenuItem mi1=new JMenuItem("Sign Up");
	JMenuItem mi21=new JMenuItem("Zone");
	JMenuItem mi22=new JMenuItem("Distributor");
	JMenuItem mi31=new JMenuItem("Main Product");
	JMenuItem mi32=new JMenuItem("Product");
	JMenuItem mi4=new JMenuItem("Invoice");
	JMenuItem mi5=new JMenuItem("Status");
	JMenuItem mi6=new JMenuItem("Report");
	JMenuItem mi7=new JMenuItem("Exit");
	JPanel panel=null;
	 Menu()
	 {  
	 	setTitle("Product Marketing Management System");
	 	setIconImage(new ImageIcon("icon.jpg").getImage());
	 	setBounds(0 , 0 , w , h);
	 	setVisible(true);
	 	add(p);p.setLayout(null);
	 	p.add(p1);p1.setBounds(50 , 20 , w-100 ,h-50);p1.setBackground(new Color(248 , 248 , 255 , 100));p1.setLayout(null);
	 	p1.add(lbl1);lbl1.setBounds(250 , 0 , 800 , 60);
		lbl1.setHorizontalAlignment(JLabel.CENTER);
		lbl1.setVerticalAlignment(JLabel.CENTER);
		lbl1.setFont(new Font("Times New Roman",Font.BOLD,60));
		lbl1.setForeground(Color.BLACK);
		
		p1.add(lbl2);lbl2.setBounds(150 , 60 , 1000 , 40);
		lbl2.setHorizontalAlignment(JLabel.CENTER);
		lbl2.setVerticalAlignment(JLabel.CENTER);
		lbl2.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,35));
		lbl2.setForeground(Color.BLACK);

		p1.add(lbl3);lbl3.setBounds(150 , 100 , 1000 , 40);
		lbl3.setHorizontalAlignment(JLabel.CENTER);
		lbl3.setVerticalAlignment(JLabel.CENTER);
		lbl3.setFont(new Font("Times New Roman",Font.BOLD,35));
		lbl3.setForeground(Color.BLACK);

		p1.add(lbl4);lbl4.setBounds(248 , 140 , 800 , 40);
		lbl4.setHorizontalAlignment(JLabel.CENTER);
		lbl4.setVerticalAlignment(JLabel.CENTER);
		lbl4.setFont(new Font("Times New Roman",Font.BOLD,35));
		lbl4.setForeground(Color.BLACK);


	 	p1.add(lbl5);lbl5.setBounds(100 , 220 , 1100 , 70);
		lbl5.setHorizontalAlignment(JLabel.CENTER);
		lbl5.setVerticalAlignment(JLabel.CENTER);
		lbl5.setFont(new Font("Times New Roman",Font.BOLD,60));
		lbl5.setForeground(Color.BLACK);

		setJMenuBar(menuBar);//menuBar.setFont(new Font("Times New Roman",Font.BOLD,70));
	    menuBar.add(m1);m1.setMnemonic('F');m1.add(mi1);m1.setFont(new Font("Times New Roman",Font.BOLD,20));
	    menuBar.add(m2);m2.setMnemonic('E');
	    m2.add(mi21);m2.setFont(new Font("Times New Roman",Font.BOLD,20));
	    m2.addSeparator();m3.setFont(new Font("Times New Roman",Font.BOLD,20));
	    m2.add(mi22);
	    menuBar.add(m3);m3.setMnemonic('G');
	    m3.add(mi31);
	    m3.addSeparator();
	    m3.add(mi32);
	    menuBar.add(m4);m4.setMnemonic('H');m4.add(mi4);m4.setFont(new Font("Times New Roman",Font.BOLD,20));
	    menuBar.add(m5);m5.setMnemonic('I');m5.add(mi5);m5.setFont(new Font("Times New Roman",Font.BOLD,20));
	    menuBar.add(m6);m6.setMnemonic('J');m6.add(mi6);m6.setFont(new Font("Times New Roman",Font.BOLD,20));
	    menuBar.add(m7);m7.setMnemonic('K');m7.add(mi7);m7.setFont(new Font("Times New Roman",Font.BOLD,20));
	    mi1.addActionListener(this);
	    mi21.addActionListener(this);
	    mi22.addActionListener(this);
	    mi31.addActionListener(this);
	    mi32.addActionListener(this);
	    mi4.addActionListener(this);
	    mi5.addActionListener(this);
	    mi6.addActionListener(this);
	    mi7.addActionListener(this);
		 }
	 public void actionPerformed(ActionEvent evt)
	 {  
	 	if(evt.getSource()==mi1)
	 	{ if(LoginForm.admin_login.equals("admin") && LoginForm.pwd_login.equals("sudha123"))
	       {
	 		SignUpForm sgf = new SignUpForm();
	 		sgf.setVisible(true);
	 	   }
	 	}
	 	if(evt.getSource()==mi21)
	 	{
	 	   zonemaster zm = new zonemaster();
	 		zm.setVisible(true);	
	 		
	 	}
	 	if(evt.getSource()==mi22)
	 	{
	 		
	 		
	 		distributermaster dm = new distributermaster();
	 		dm.setVisible(true);
	 	}
	 	
	 	if(evt.getSource()==mi31)
	 	{
	 		
	 		MainProductMaster mpm = new MainProductMaster();
	 		mpm.setVisible(true);
	 	}
	 	if(evt.getSource()==mi32)
	 	{
	 		
	 		ProductMaster pm = new ProductMaster();
	 		pm.setVisible(true);
	 	}
	 	if(evt.getSource()==mi4)
	 	{
	 		
	 		Transaction t = new Transaction();
	 		t.setVisible(true);
	 	}
	 	if(evt.getSource()==mi5)
	 	{
	 		
	 		Status s = new Status();
	 		s.setVisible(true);
	 	}
	 	if(evt.getSource()==mi6)
	 	{
	 		
	 		Report r = new Report();
	 		r.setVisible(true);
	 	}
	 	if(evt.getSource()==mi7)
	 	{
	 		int opt= JOptionPane.showConfirmDialog(this,"Do You Want To Quit..."); 
     if(opt==JOptionPane.YES_OPTION)
     {  
        dispose();
      }
	 		
	 	}
	 }
	 public static void main(String[]args)
	{
		new Menu();
	}
}