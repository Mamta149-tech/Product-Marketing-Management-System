import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.*;
import java.io.*;
import java.text.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.util.regex.*;
public class ProductMaster extends JFrame implements ActionListener , FocusListener
{
	Connection con;
    PreparedStatement pst;
    File f;
	ResultSet rst;
	int opt;

     
	JLabel lbl=new JLabel("<html><u>Product Entry</u></html>");
	JLabel lbl1=new JLabel("Product id");
	JLabel lbl2=new JLabel("Product Name");
	JLabel lbl3=new JLabel("Pack Size");
	JLabel lbl3E=new JLabel();
	JLabel lbl4=new JLabel("Basic price");
	JLabel lbl4E=new JLabel();
	JLabel lbl5=new JLabel("Taxable");
	JLabel lbl6=new JLabel("Cgst");
	JLabel lbl6E=new JLabel();
	JLabel lbl7=new JLabel("Sgst");
	JLabel lbl7E=new JLabel();
	JLabel lbl8=new JLabel("Dist commission");
	JLabel lbl8E=new JLabel();
	JLabel lbl9=new JLabel("Retailer commission");
	JLabel lbl9E=new JLabel();
	JLabel lbl10=new JLabel("Mrp");
	JLabel lbl10E=new JLabel();
	JLabel lbl11=new JLabel("Main Product Id");
	JLabel lbl12=new JLabel("Main Product Name");
	JLabel lbl13=new JLabel("Per");
	
	JTextField txt1=new JTextField();
	JTextField txt21=new JTextField();JTextField txt22=new JTextField();
	JTextField txt3=new JTextField();
	JTextField txt4=new JTextField();
	JRadioButton r1 = new JRadioButton("Yes");
	JRadioButton r2 = new JRadioButton("No");
	JTextField txt6=new JTextField();
	JTextField txt7=new JTextField();
	JTextField txt8=new JTextField();
	JTextField txt9=new JTextField();
	JTextField txt10=new JTextField();
	JTextField txt11=new JTextField();
	JTextField txt12=new JTextField();
	JComboBox cmb1=new JComboBox();
	
	ButtonGroup bg =  new ButtonGroup();
	JButton btn1=new JButton("Insert")
	{
		public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("insert.png").getImage(),0 , 0 ,30,30 , null);
        }
	};
	JButton btn2=new JButton("Search")
	{
		public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("search.png").getImage(),5 , 5 ,20,20 , null);
        }
	};
    JButton btn3=new JButton("Update")
    {
    	
		public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("update.png").getImage(),5 , 5 ,20,20 , null);
        }
	};
    
    
	JButton btn4=new JButton("Reset")
	{
    	public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("reset.png").getImage(),0 , 0 ,30,30 , null);
        }
    };
	JButton btn5=new JButton()
	{
       public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("back1.png").getImage(),0 , 0 ,60,60 , null);
        }
    };
     JLabel sicon=new JLabel()
	{
		 public void paintComponent(Graphics g)
        {
        super.paintComponent(g); 	
        g.drawImage(new ImageIcon("icon.jpg").getImage(),0 , 0 ,70,70 , null);
        
        }
	};
	JButton backup = new JButton()
	{
		 public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("backup.png").getImage(),0 , 0 ,60,60 , null);
        } 
	};
	
	{
	try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sudha","sudha123");
			pst=con.prepareStatement("Select Main_prod_name from main_product_master");
			rst=pst.executeQuery();
			while(rst.next())
			{
				cmb1.addItem(rst.getString(1));
			}
			pst=con.prepareStatement("Select prod_name from product_master");
			ResultSet rst=pst.executeQuery();
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{System.out.println(e);}
}
	
	
	JPanel p1=new JPanel()
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(new ImageIcon("pro.jpg").getImage(),0,0,1200,600,null);
		}
	};
	JPanel p2=new JPanel();
	Toolkit toolkit=Toolkit.getDefaultToolkit();
	Dimension dimension=toolkit.getScreenSize();
	int w;
	int h;
	{
		w=(int)dimension.getWidth();
		h=(int)dimension.getHeight();
	}
	ProductMaster()
	{  
		setTitle("Product Marketing Management System -- Product");
		if(LoginForm.admin_login.equals("admin") && LoginForm.pwd_login.equals("sudha123"))
    {
      btn1.setVisible(true);
      btn2.setVisible(true);
      btn3.setVisible(true);
      btn4.setVisible(true);
      btn5.setVisible(true);
      
      }
      else
    {
      
      btn1.setVisible(false);
      btn2.setVisible(true);
      btn3.setVisible(true);
      btn4.setVisible(true);
      btn5.setVisible(true);
      
    }

	add(p1);
	p1.setBackground(Color.ORANGE);
	p1.setLayout(null);
	p2.setBounds(30,10,1140,520);
	p1.add(p2);
	p2.setBackground(new Color(255,255,255,140));

	setIconImage(new ImageIcon("icon.jpg").getImage());
	p2.setLayout(null);
	lbl.setBounds(340,0,390,70);
	p2.add(lbl);
	p2.add(lbl);
	p2.add(sicon);sicon.setBounds(250 , 3 , 70 , 70);
		
	lbl.setHorizontalAlignment(JLabel.CENTER);
    lbl.setVerticalAlignment(JLabel.CENTER);
    lbl.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,55));
	lbl.setForeground(Color.WHITE);lbl.setOpaque(true);
	lbl.setBackground(Color.BLACK);
	lbl1.setBounds(100,70,150,50);p2.add(lbl1);
	lbl1.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	lbl2.setBounds(100,110,150,50);p2.add(lbl2);
	lbl2.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	lbl3.setBounds(100,150,150,50);p2.add(lbl3);
	lbl3.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	lbl3E.setBounds(520,150,250,50); p2.add(lbl3E);
    lbl3E.setFont(new Font( "Arial",Font.PLAIN ,22));
     lbl3E.setForeground(Color.RED);
	lbl4.setBounds(100,190,150,50);p2.add(lbl4);
	lbl4.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	lbl4E.setBounds(520,190,250,50); p2.add(lbl4E);
    lbl4E.setFont(new Font( "Arial",Font.PLAIN ,22));
     lbl4E.setForeground(Color.RED);
	lbl5.setBounds(100,230,150,50);p2.add(lbl5);
	lbl5.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	lbl6.setBounds(100,270,150,50);p2.add(lbl6);
	lbl6.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	lbl6E.setBounds(520,270,250,50); p2.add(lbl6E);
    lbl6E.setFont(new Font( "Arial",Font.PLAIN ,22));
    lbl6E.setForeground(Color.RED);
	lbl7.setBounds(100,310,150,50);p2.add(lbl7);
	lbl7.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	lbl7E.setBounds(520,310,250,50); p2.add(lbl7E);
    lbl7E.setFont(new Font( "Arial",Font.PLAIN ,22));
     lbl7E.setForeground(Color.RED);
	lbl8.setBounds(100,350,170,50);p2.add(lbl8);
	lbl8.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	lbl8E.setBounds(520,350,250,50); p2.add(lbl8E);
    lbl8E.setFont(new Font( "Arial",Font.PLAIN ,22));
     lbl8E.setForeground(Color.RED);
	lbl9.setBounds(100,390,200,50);p2.add(lbl9);
	lbl9.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	lbl9E.setBounds(520,390,250,50); p2.add(lbl9E);
    lbl9E.setFont(new Font( "Arial",Font.PLAIN ,22));
     lbl9E.setForeground(Color.RED);
	lbl10.setBounds(100,430,150,50);p2.add(lbl10);
	lbl10.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	lbl13.setBounds(100,475,150,50);p2.add(lbl13);
	lbl13.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	lbl10E.setBounds(520,430,250,50); p2.add(lbl10E);
    lbl10E.setFont(new Font( "Arial",Font.PLAIN ,22));
     lbl10E.setForeground(Color.RED);
	lbl11.setBounds(650,70,190,50);p2.add(lbl11);
	lbl11.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	lbl12.setBounds(650,110,190,50);p2.add(lbl12);
	lbl12.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	
	txt1.setBounds(320,80,140,30);
	p2.add(txt1);txt1.setEditable(false);
	txt21.setBounds(320,120,140,30);
	p2.add(txt21);txt21.setEditable(false);
	txt22.setBounds(460,120,140,30);
	p2.add(txt22);
	txt3.setBounds(320,160,140,30);
	p2.add(txt3);
	txt4.setBounds(320,200,140,30);
	p2.add(txt4);
	r1.setBounds(320,240,80,30);r2.setBounds(420,240,80,30);
	r1.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,23));
	r2.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,23));
	bg.add(r1);bg.add(r2);
	p2.add(r1);p2.add(r2);
	txt6.setBounds(320,280,140,30);
	p2.add(txt6);
	txt7.setBounds(320,320,140,30);
	p2.add(txt7);
	txt8.setBounds(320,360,140,30);
	p2.add(txt8);
	txt9.setBounds(320,400,140,30);
	p2.add(txt9);
	txt10.setBounds(320,440,140,30);txt10.setEditable(false);
	p2.add(txt10);
	txt11.setBounds(840,70,140,30);
	p2.add(txt11);txt11.setEditable(false);
	txt12.setBounds(320,480,140,30);
	p2.add(txt12);
	cmb1.setBounds(840,120,140,30);p2.add(cmb1);
	cmb1.addItem("Sudha Balushahi");
	cmb1.addItem("Sudha Dahi");
	cmb1.addItem("Sudha Rassogulla");
	cmb1.addItem("sudha Raskadam");
	cmb1.addItem("Sudha Gulab-jamun");
	cmb1.addItem("Sudha Butter");
	cmb1.addItem("Sudha Kalakand");
	cmb1.addItem("Sudha Paneer");
	cmb1.addItem("Sudha Peda");
	cmb1.addItem("Sudha Ghee");
	cmb1.addItem("Sudha Lassi");
	
	p2.add(btn1);
	btn1.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	btn1.setBounds(900,200,110,30);
	p2.add(btn2);
	btn2.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	btn2.setBounds(900,250,110,30);
	p2.add(btn3);
	btn3.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	btn3.setBounds(900,300,110,30);
	p2.add(btn4);
	btn4.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,22));
	btn4.setBounds(900,350,110,30);
	p2.add(btn5);
	btn5.setBounds(10,0,60,60);
	btn5.setContentAreaFilled(false);
         btn5.setBorderPainted(false);   
  
	
	p2.add(backup);backup.setBounds(1050,0,60,60);
         backup.setContentAreaFilled(false);
         backup.setBorderPainted(false);   
  
	
	setBounds(100 , 100 , 1200,600);
	setVisible(true);
	btn1.addActionListener(this);
	btn2.addActionListener(this);
	btn3.addActionListener(this);
	btn4.addActionListener(this);
	btn5.addActionListener(this);
	backup.addActionListener(this);
	cmb1.addActionListener(this);
	txt10.addFocusListener(this);
	//txt2.addActionListener(this);
	}
	public void focusGained(FocusEvent evtt)
	{
		if(evtt.getSource()==txt10)
{
	repaint();
	float a = Float.parseFloat(txt4.getText());
    float b = Float.parseFloat(txt6.getText());
	float c = Float.parseFloat(txt7.getText());
	float d = Float.parseFloat(txt8.getText());
	float e = Float.parseFloat(txt9.getText());
	float u = 0.0f;
	u = a+((b/100)*a)+((c/100)*a)+((d/100)*a)+((e/100)*a);
	txt10.setText(String.valueOf(u));

}
	}
	public void focusLost(FocusEvent evtt)
	{
        repaint();
	}
	public void actionPerformed(ActionEvent evt)
	{
		String taxable="";
						if(r1.isSelected())
							taxable="Yes";
						else if(r2.isSelected())
							taxable="No";
	if(evt.getSource()==cmb1)
	{
		repaint();
		try
		{
			pst=con.prepareStatement("Select Main_prod_id from main_product_master where main_prod_name=?");
			pst.setString(1,cmb1.getSelectedItem().toString());
			ResultSet rst=pst.executeQuery();
			if(rst.next())
			{
				txt11.setText(rst.getString(1));
			
		 try
    {
    	
       pst=con.prepareStatement("Select to_number(substr(prod_last_ref,4)) from main_product_master where main_prod_id = ?");
      int id=1;
      pst.setString(1,txt11.getText());
      rst=pst.executeQuery();
      if(rst.next())
      {
        id=rst.getInt(id)+1;
      }
      if(id<10)
      {
      txt1.setText(txt11.getText()+"0"+String.valueOf(id));
      }
      else if(id>=10 && id<100)
      {
      	txt1.setText(txt11.getText()+String.valueOf(id));
      }
       else
      {
        txt1.setText("Out of Bounds");
      }
      txt21.setText(cmb1.getSelectedItem().toString());
    }
    catch(Exception ee){System.out.println(ee);}
   
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	if(evt.getSource()==btn1)
		{
			repaint();
			boolean temp=false;
			 if(!validationnumeric.checknumeric(txt3.getText()))
    {
     lbl3E.setText("***");
     temp=true; 
    }
    else
   {
    lbl3E.setText("");
    temp = false;
   }
   
			 if(!validationnumeric1.checknumeric1(txt4.getText()))
    {
     lbl4E.setText("***");
     temp=true; 
    }
    else
   {
    lbl4E.setText("");
    temp=false; 
   }
   
			 if(!validationnumeric1.checknumeric1(txt6.getText()))
    {
     lbl6E.setText("***");
     temp=true; 
    }
    else
   {
    lbl6E.setText("");
    temp=false; 
   }
   if(!validationnumeric1.checknumeric1(txt7.getText()))
    {
     lbl7E.setText("***");
     temp=true; 
    }
    else
   {
    lbl7E.setText("");
    temp=false; 
   }
    if(!validationnumeric1.checknumeric1(txt8.getText()))
    {
     lbl8E.setText("***");
     temp=true; 
    }
    else
   {
    lbl8E.setText("");
    temp=false; 
   }
   if(!validationnumeric1.checknumeric1(txt9.getText()))
    {
     lbl9E.setText("***");
     temp=true; 
    }
    else
   {
    lbl9E.setText("");
    temp=false; 
   }
   if(!validationnumeric1.checknumeric1(txt10.getText()))
    {
     lbl10E.setText("***");
     temp=true; 
    }
    else
   {
    lbl10E.setText("");
    temp=false; 
   }
   String prd_nm = txt21.getText() + txt22.getText();
	if(temp){return;}		
			try
			{
				
				pst=con.prepareStatement("insert into Product_Master values(?,?,?,?,?,?,?,?,?,?,?)");
				pst.setString(1,txt1.getText());
				pst.setString(2,prd_nm);
				pst.setString(3,txt3.getText());
				pst.setString(4,txt4.getText());
				pst.setString(5,taxable);
				pst.setString(6,txt6.getText());
				pst.setString(7,txt7.getText());
				pst.setString(8,txt8.getText());
				pst.setString(9,txt9.getText());
				pst.setString(10,txt10.getText());
				pst.setString(11,txt12.getText());
				
				if(pst.executeUpdate()>0)
				{
					String plf = "";
					PreparedStatement pst1=con.prepareStatement("Select to_number(substr(prod_last_ref,4)) from main_product_master where main_prod_id = ?");
				  int id=1;
      pst1.setString(1,txt11.getText());
      rst=pst1.executeQuery();
      if(rst.next())
      {
        id=rst.getInt(id)+1;
        System.out.println(id);
      }
      if(id<10)
      {
      plf = txt11.getText()+"0"+String.valueOf(id);
      }
      else if(id>=10 && id<100)
      {
      	plf = txt11.getText()+String.valueOf(id);
      }
       
					pst1=con.prepareStatement("update main_product_master set prod_last_ref =? where main_prod_id=?");
                 
                 pst1.setString(1,plf);

                pst1.setString(2,txt11.getText());
             
       if(pst1.executeUpdate()>0)
        {
          System.out.println("Done");
        }
				JOptionPane.showMessageDialog(this,"Data Saved...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Data Not Saved...","Eror Message",JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,"Data Not Saved...","Eror Message",JOptionPane.ERROR_MESSAGE);
			}
		}	
	
	
	if(evt.getSource()==btn3)
{
	repaint();
  try
      {
        pst=con.prepareStatement("update product_master set basic_Price=?,taxable=?,cgst=?,sgst=?,dist_commission=?,retailer_commission=?,mrp=? where prod_id=?");
        
                
                pst.setInt(1,Integer.parseInt(txt4.getText()));
				pst.setString(2,taxable);
				pst.setInt(3,Integer.parseInt(txt6.getText()));
				pst.setInt(4,Integer.parseInt(txt7.getText()));
				pst.setInt(5,Integer.parseInt(txt8.getText()));
				pst.setInt(6,Integer.parseInt(txt9.getText()));
				pst.setInt(7,Integer.parseInt(txt10.getText()));
                pst.setString(8,txt1.getText());
                
       if(pst.executeUpdate()>0)
        {
          JOptionPane.showMessageDialog(this,"Data Updated...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
          JOptionPane.showMessageDialog(this,"Data Not Updated...","Eror Message",JOptionPane.ERROR_MESSAGE); 
        }
      }
      
      catch(SQLException e)
	  {
        JOptionPane.showMessageDialog(this,"Data Not Updated...","Eror Message",JOptionPane.ERROR_MESSAGE);
	  }
}

	else if(evt.getSource()==btn4){
        repaint();
		reset();}
	else if(evt.getSource()==btn5)
	{
		int opt= JOptionPane.showConfirmDialog(this,"Do You Want To Exit..."); 
     if(opt==JOptionPane.YES_OPTION)
     {  
        dispose();
      }
	}
	
    else if(evt.getSource()==btn2)
		{
			repaint();
			  String id=JOptionPane.showInputDialog(this,"Enter Your Product Id");
			  cmb1.setEnabled(false);
			  
			  
			  try
			{
			pst	=con.prepareStatement("Select * from product_master where prod_id=?");
				  pst.setString(1,id);
				   rst=pst.executeQuery();
				  if(rst.next())
				  {
						txt1.setText(rst.getString("prod_id"));txt1.setEditable(false);
						txt21.setText(rst.getString("prod_name"));txt21.setEditable(false);
						txt22.setEditable(false);
						txt3.setText(rst.getString("prod_unit"));txt3.setEditable(false);
						txt4.setText(rst.getString("Basic_Price"));
						String g=rst.getString("taxable");
						if(g.equalsIgnoreCase("yes"))
							r1.setSelected(true);
						else if(g.equalsIgnoreCase("no"))
							r2.setSelected(true);
						txt6.setText(rst.getString("cgst"));
						txt7.setText(rst.getString("sgst"));
						txt8.setText(rst.getString("DIST_COMMISSION"));
						txt9.setText(rst.getString("retailer_commission"));
						txt10.setText(rst.getString("mrp"));
						txt12.setText(rst.getString("per"));
						
				  }
					else
				   {
						lbl5.setIcon(null);
				        JOptionPane.showMessageDialog(this,"Data Not Found");				
				   }
				   pst	=con.prepareStatement("Select * from main_product_master where main_prod_id=substr(?,1,3)");
				  pst.setString(1,id);
				   rst=pst.executeQuery();
				  if(rst.next())
				  {
                        txt11.setText(rst.getString("main_prod_id"));
                        cmb1.setSelectedItem(rst.getString("main_prod_name"));
				  }
			}
			
			catch(Exception e){JOptionPane.showMessageDialog(this,"Data Not Found...","Eror Message",JOptionPane.ERROR_MESSAGE);}
					
		}

if(evt.getSource() == backup)
{
	repaint();
  String d = new SimpleDateFormat("dd-MMM-yyyy").format(new java.util.Date());
  String fnm = "SudhaProduct"+d;
  String s = "exp sudha/sudha123 file = D:\\BackupProduct\\"+fnm+".dmp";
  try
  {
    Process p = Runtime.getRuntime().exec(s);
    JOptionPane.showMessageDialog(this,"BackUp Done...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
  }
  catch(Exception e){JOptionPane.showMessageDialog(this,"BackUp Not Done...","Error Message",JOptionPane.ERROR_MESSAGE); }
}          

  }
	
	
	public void reset()
	{
		repaint();
		txt1.setText("");txt1.setEditable(true);
		txt21.setText("");
		txt22.setText("");txt22.setEditable(true);
		txt3.setText("");txt3.setEditable(true);
		txt4.setText("");
		r1.setEnabled(true);
		r2.setEnabled(true);
		r1.setSelected(false);
		r2.setSelected(false);
		txt6.setText("");
		txt7.setText("");
		txt8.setText("");
		txt9.setText("");
		txt10.setText("");
		txt11.setText("");
		txt12.setText("");
		cmb1.setEnabled(true);
	}
	public static void main(String[]args)
	{
		new ProductMaster();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	