import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.*;
import java.text.*;
import java.io.*;
import java.sql.*;
public class Status extends JFrame implements ActionListener
{
	
	 Connection con;
    PreparedStatement pst;
    ResultSet rst;
    File  f;
{
	try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");//ClassNotFoundException
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sudha","sudha123");//SQLException
			//JOptionPane.showMessageDialog(this,"Connected....");			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{}
}
    int w , h ;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension dimension = toolkit.getScreenSize();
	{
		w = (int)dimension.getWidth();
		h = (int)dimension.getHeight();
	}

	JPanel p = new JPanel()
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(new ImageIcon("F:\\GUI\\sudha-slider1.jpg").getImage(), 0 , 0 , w , h , null);
		}
	};
	JPanel p1 = new JPanel();
	JLabel lbl = new JLabel("<html><u>Status</u></html>");
	JLabel l1 = new JLabel("Financial Year");
    JLabel l2 = new JLabel("Date From");
    JLabel l3 = new JLabel("Date To");
    JLabel l4 = new JLabel("Entry Status");
    JLabel l5 = new JLabel("Print Status");
    JLabel l6 = new JLabel("Previous Invoice Number");
    JLabel l7 = new JLabel("Current Invoice Number");
    JLabel l8 = new JLabel("Main Product Last Ref.");
    JLabel l9 = new JLabel("Zone Last Ref.");
    JLabel l10 = new JLabel("Distributer Last Ref.");
     
    JTextField t1 = new JTextField();
    JDateChooser calendar2=new JDateChooser(new java.util.Date());
    JDateChooser calendar3=new JDateChooser(new java.util.Date());
    JTextField t6 = new JTextField();
    JTextField t7 = new JTextField();
    JTextField t8 = new JTextField();
    JTextField t9 = new JTextField();
    JTextField t10 = new JTextField();
    

    JRadioButton t4 = new JRadioButton("True");
    JRadioButton f4 = new JRadioButton("False");
    ButtonGroup bg4 = new ButtonGroup();
  
    JRadioButton t5 = new JRadioButton("True");
    JRadioButton f5 = new JRadioButton("False");
    ButtonGroup bg5 = new ButtonGroup();

     JLabel sicon=new JLabel()
  {
     public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("icon.jpg").getImage(),0 , 0 ,60,60 , null);
        
        }
  };
    
    
    
    JButton exit=new JButton()
    {
       public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("back1.png").getImage(),0 , 0 ,60,60 , null);
        }
    };

    int month = new java.util.Date().getMonth()+1;
    String year = new SimpleDateFormat("yyyy").format(new java.util.Date());
    public static String financial_yr;

    
    

	Status()
	{  
    setTitle("Product Marketing Management System -- Status");
     try
    {
      
       pst=con.prepareStatement("Select max(to_number(substr(zone_id,2))) from zone_master order by (to_number(substr(zone_id,2))) desc");
      int id=1;
      ResultSet rst=pst.executeQuery();
      if(rst.next())
      {
        id=rst.getInt(id)+1;
        System.out.println(id);
      }
      if(id<10)
      {
      t9.setText("Z"+"00"+String.valueOf(id));
      }
      else if(id>=10 && id<100)
      {
         t9.setText("Z"+"0"+String.valueOf(id));
      }
      else if(id>=100 && id<1000)
      {
         t9.setText("Z"+String.valueOf(id));
      }
       else
      {
        t9.setText("Out of Bounds");
      }

    }
    catch(Exception ee){System.out.println(ee);}
    
     try
    {
       pst=con.prepareStatement("Select max(dist_id) from distributor_master");
      int id=1;
      ResultSet rst=pst.executeQuery();
      if(rst.next())
      {
        id=rst.getInt(id)+1;
        
      }
      if(id<10)
      {
        t10.setText("000000"+String.valueOf(id));
      }
      else if(id>=10 && id<100 )
      {
        t10.setText("00000"+String.valueOf(id));
      }
      else if(id>=100 && id<1000 )
      {
        t10.setText("0000"+String.valueOf(id));
      }
      else if(id>=1000 && id<10000 )
      {
        t10.setText("000"+String.valueOf(id));
      }
      else if(id>=10000 && id<100000 )
      {
        t10.setText("00"+String.valueOf(id));
      }
      else if(id>=100000 && id<1000000 )
      {
        t10.setText("0"+String.valueOf(id));
      }
      else if(id>=1000000 && id<10000000)
      {
        t10.setText(String.valueOf(id));
      }
      else
      {
        t10.setText("Out of Bounds");
      }
      
    }
    catch(Exception ee){}
   
   try
    {
      repaint();
      pst=con.prepareStatement("Select max(invoice_no) from transaction");
         int id=1;
         ResultSet rst=pst.executeQuery();
        if(rst.next())
        {
          id=rst.getInt(id)+1;
        }
         t6.setText(String.valueOf(id-1));
         t7.setText(String.valueOf(id));
        }
        catch(Exception ee){System.out.println(ee);}
         try
    {
      
       pst=con.prepareStatement("Select max(to_number(substr(main_prod_id,2))) from main_product_master order by (to_number(substr(main_prod_id,2))) desc");
      int id=1;
      ResultSet rst=pst.executeQuery();
      if(rst.next())
      {
        id=rst.getInt(id)+1;
      }
      if(id<10)
     {
      t8.setText("P"+"0"+String.valueOf(id));
     }
     else if(id>=10 && id<100)
    {
       t8.setText("P"+String.valueOf(id));  
    }
     else
      {
        t8.setText("Out of Bounds");
      }
    }
    catch(Exception ee){System.out.println(ee);}
    if(Transaction.entry_status == true)
    {
      t4.setSelected(true);
    }
    else
    {
      f4.setSelected(true);
    }
    if(Transaction.print_status == true)
    {
      t5.setSelected(true);
    }
    else
    {
      f5.setSelected(true);
    }

		if(month >= 4)
		{
			financial_yr = year + "-" +(Integer.parseInt(year)+1);
		}
		else if(month >= 1 && month <= 3)
		{
			year=(Integer.parseInt(year)-1)+"";
			financial_yr = year + "-" + (Integer.parseInt(year)+1);
		}
		java.util.Date dt=new java.util.Date();
		dt.setDate(1);
		dt.setMonth(3);
		dt.setYear(Integer.parseInt(year)-1900);

		java.util.Date dt1=new java.util.Date();
		dt1.setDate(31);
		dt1.setMonth(2);
		dt1.setYear(Integer.parseInt(year)-1900+1);

		calendar2.setDate(dt);
		calendar3.setDate(dt1);
		t1.setText(financial_yr);
		add(p);p.setBounds(0, 0 , w , h);p.setLayout(null);
        p.add(p1);p1.setBounds(10 , 10 , w-40 ,h-40);p1.setBackground(new Color(112,112,113,150));p1.setLayout(null);
		p1.add(lbl);lbl.setBounds(500 , 10 , 250 , 60);
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setVerticalAlignment(JLabel.CENTER);
		lbl.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,50));
		lbl.setForeground(new Color(255 , 255 , 255 , 150));
		lbl.setBackground(Color.BLACK);
		lbl.setOpaque(true);

    p1.add(sicon);sicon.setBounds(430 , 10 , 60 , 60);
    setIconImage(new ImageIcon("icon.jpg").getImage());
    

		p1.add(l1);l1.setBounds(120 , 105 , 300 , 50);l1.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));l1.setForeground(Color.WHITE);
        p1.add(l2);l2.setBounds(120 , 170 , 300 , 50);l2.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));l2.setForeground(Color.WHITE);
        p1.add(l3);l3.setBounds(120 , 230 , 300 , 50);l3.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));l3.setForeground(Color.WHITE);
        p1.add(l4);l4.setBounds(120 , 290 , 300 , 50);l4.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));l4.setForeground(Color.WHITE);
        p1.add(l5);l5.setBounds(120 , 350 , 300 , 50);l5.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));l5.setForeground(Color.WHITE);
        p1.add(l6);l6.setBounds(120 , 400 , 300 , 50);l6.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,28));l6.setForeground(Color.WHITE);
        p1.add(l7);l7.setBounds(120 , 460 , 300 , 50);l7.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,28));l7.setForeground(Color.WHITE);
        p1.add(l8);l8.setBounds(120 , 520 , 300 , 50);l8.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));l8.setForeground(Color.WHITE);
        p1.add(l9);l9.setBounds(120 , 580 , 300 , 50);l9.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));l9.setForeground(Color.WHITE);
        p1.add(l10);l10.setBounds(120 , 640 , 300 , 50);l10.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));l10.setForeground(Color.WHITE);
        

        p1.add(calendar2);calendar2.setBounds(460 , 170 , 200 , 40);calendar2.setForeground(Color.black);calendar2.setEnabled(false);
        p1.add(calendar3);calendar3.setBounds(460 , 230 , 200 , 40);calendar3.setForeground(Color.black);calendar3.setEnabled(false);
        p1.add(t6);t6.setBounds(460 , 400 , 200 , 40);t6.setEditable(false);
        p1.add(t7);t7.setBounds(460 , 460 , 200 , 40);t7.setEditable(false);
        p1.add(t8);t8.setBounds(460 , 520 , 200 , 40);t8.setEditable(false);
        p1.add(t9);t9.setBounds(460 , 580 , 200 , 40);t9.setEditable(false);
        p1.add(t10);t10.setBounds(460 , 640 , 200 , 40);t10.setEditable(false);

        p1.add(t1);t1.setBounds(460 , 105 , 200 , 40);t1.setEditable(false);

        p1.add(t4);t4.setBounds(460 , 290 , 100 , 40);t4.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,20));t4.setEnabled(false);
        p1.add(f4);f4.setBounds(580 , 290 , 100 , 40);f4.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,20));f4.setEnabled(false);
        bg4.add(t4);bg4.add(f4);
        p1.add(t5);t5.setBounds(460 , 350 , 100 , 40);t5.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,20));t5.setEnabled(false);
        p1.add(f5);f5.setBounds(580 , 350 , 100 , 40);f5.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,20));f5.setEnabled(false);
        bg5.add(t5);bg5.add(f5);

              
        p1.add(exit);exit.setBounds(10 , 10 , 60 , 60);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false); 
        exit.setOpaque(false);
        
		setBounds(0 , 0 , w , h);
		setVisible(true);
     
      exit.addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent evt)
	 {
	 	if(evt.getSource() == exit)
{
  int opt= JOptionPane.showConfirmDialog(this,"Do You Want To Exit..."); 
     if(opt==JOptionPane.YES_OPTION)
     {  
        dispose();
      }
}   
	 }
	public static void main(String[]args)
	{
		new Status();
	}
} 