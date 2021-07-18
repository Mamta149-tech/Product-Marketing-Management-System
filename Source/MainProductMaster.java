import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.*;
import java.io.*;
import java.text.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.util.regex.*;
public class MainProductMaster extends JFrame implements ActionListener
{
	Connection con;
    PreparedStatement pst;
	File f;
	ResultSet rst;
	int opt;
{
	try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sudha","sudha123");			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{System.out.println(e);}
}

	JLabel lbl=new JLabel("<html><u> Main Product Entry</u></html>");
	JLabel lbl1=new JLabel(" Main Product Id");
	JLabel lbl2=new JLabel("Main Product Name");
	JLabel lbl2E=new JLabel();
	JLabel lbl3=new JLabel("Taxable");
	JLabel lbl4=new JLabel("Product Last Ref");
	JLabel lbl5=new JLabel();
	
	
	JTextField txt1=new JTextField();
	JTextField txt2=new JTextField();
	
	JTextField txt4=new JTextField();
	
	JRadioButton r1 = new JRadioButton("Yes");
	JRadioButton r2 = new JRadioButton("No");
	
	ButtonGroup bg =  new ButtonGroup();
	 JLabel sicon=new JLabel()
	{
		 public void paintComponent(Graphics g)
        {
        super.paintComponent(g); 	
        g.drawImage(new ImageIcon("icon.jpg").getImage(),0 , 0 ,50,60 , null);
        
        }
	};
	
	JButton btn=new JButton("Browse")
	{
		public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("browse.png").getImage(),8 , 8 ,20,20 , null);
        }
	};
	JButton btn1=new JButton("Insert")
	{
		public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("insert.png").getImage(),0 , 0 ,40,40 , null);
        }
	};
	JButton btn2=new JButton("Search")
	{
		public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("search.png").getImage(),5 , 10 ,20,20 , null);
        }
	};
    JButton btn3=new JButton("Reset")
    {
    	public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("reset.png").getImage(),0 , 0 ,40,40 , null);
        }
    };
	JButton btn4=new JButton("Exit")
	{
       public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("back1.png").getImage(),0 , 0 ,60,60 , null);
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
	
	JPanel p1=new JPanel()
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(new ImageIcon("pro1.jpg").getImage(),0,0,1100,450,null);
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
	MainProductMaster()
	{  
		setTitle("Product Marketing Management System -- Main Product");
		if(LoginForm.admin_login.equals("admin") && LoginForm.pwd_login.equals("sudha123"))
    {
      btn.setVisible(true);
      btn1.setVisible(true);
      btn2.setVisible(true);
      btn3.setVisible(true);
      btn4.setVisible(true);
    
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
      txt1.setText("P"+"0"+String.valueOf(id));
     }
     else if(id>=10 && id<100)
    {
       txt1.setText("P"+String.valueOf(id));	
    }
     else
      {
        txt1.setText("Out of Bounds");
      }
    }
    catch(Exception ee){System.out.println(ee);}
   }
    else
    {
      
      btn1.setVisible(false);
      btn.setVisible(true);
      btn2.setVisible(true);
      btn3.setVisible(true);
      btn4.setVisible(true);
     
    }
   
	add(p1);
	p1.setBounds(100, 100 , 1100 , 450);
	p1.setBackground(Color.PINK);
	p1.setLayout(null);
	p2.setBounds(10,10,1050,380);
	p1.add(p2);
	p2.setBackground(new Color(255,255,255,120));
	p2.setLayout(null);
	lbl.setBounds(300 , 10 , 400 ,60);
	p2.add(lbl);
	p2.add(lbl);
	lbl.setHorizontalAlignment(JLabel.CENTER);
    lbl.setVerticalAlignment(JLabel.CENTER);
    lbl.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,45));
	lbl.setForeground(Color.WHITE);lbl.setOpaque(true);
	lbl.setBackground(Color.BLACK);

	p2.add(sicon);sicon.setBounds(240 , 10 , 50 , 60);

	setIconImage(new ImageIcon("icon.jpg").getImage());
		
	
	lbl1.setBounds(30,90,250,50);p2.add(lbl1);
	lbl1.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
	lbl2.setBounds(30,140,260,50);p2.add(lbl2);
	lbl2.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
	lbl2E.setBounds(460,140,50,50); p2.add(lbl2E);
    lbl2E.setFont(new Font( "Arial",Font.PLAIN ,20));
     lbl2E.setForeground(Color.RED);
	lbl3.setBounds(30,190,250,50);p2.add(lbl3);
	lbl3.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
	lbl4.setBounds(30,240,250,50);p2.add(lbl4);
	lbl4.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
	lbl5.setBounds(730,100,300,300);p2.add(lbl5);
     lbl5.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
  
		
	txt1.setBounds(300,100,200,40);
	p2.add(txt1);txt1.setEditable(false);
	txt2.setBounds(300,150,200,40);
	p2.add(txt2);
	r1.setBounds(300,200,80,40);r2.setBounds(390,200,80,40);
	r1.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
	r2.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
	bg.add(r1);r1.setSelected(false);
	bg.add(r2);r2.setSelected(false);
	p2.add(r1);p2.add(r2);
	txt4.setBounds(300,250,200,40);txt4.setEditable(false);
	p2.add(txt4);
	
	p2.add(btn1);
	 btn1.setBounds(560,100,150,40);
    btn1.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
	p2.add(btn2);
	btn2.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
	btn2.setBounds(560,150,150,40);
	p2.add(btn3);
	btn3.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
	btn3.setBounds(560,200,150,40);
	p2.add(btn4);
	
	btn4.setBounds(10,0,60,60);
	btn4.setContentAreaFilled(false);
         btn4.setBorderPainted(false);   
  
	
	p2.add(btn);
	btn.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
	btn.setBounds(560,250,150,40);
	
	p2.add(backup);backup.setBounds(950,0,60,60);
         backup.setContentAreaFilled(false);
         backup.setBorderPainted(false);   
  
  
	
	setBounds(100 , 100 , 1100 , 450);
	setVisible(true);
	btn.addActionListener(this);
	btn1.addActionListener(this);
	btn2.addActionListener(this);
	btn3.addActionListener(this);
	btn4.addActionListener(this);
	backup.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent evt)
	{
	
	if(evt.getSource()==btn)
		
{
	repaint();
	JFileChooser fchooser=new JFileChooser();
      int opt=fchooser.showOpenDialog(this);
      if(opt==JFileChooser.OPEN_DIALOG)
      {
        f=fchooser.getSelectedFile();
        String path=f.getAbsolutePath();
        Image img=Toolkit.getDefaultToolkit().getImage(path);
        Image img1=img.getScaledInstance(300,300,Image.SCALE_SMOOTH);
        lbl5.setIcon(new ImageIcon(img1));
      }
		
	}
	
		
if(evt.getSource()==btn1)
		{
			repaint();
			boolean temp=false;
    if(!validationname.checkname(txt2.getText()))
    {
      JOptionPane.showMessageDialog(this,"Main Product Name Should Contain Only Alphabets...","Error Message",JOptionPane.ERROR_MESSAGE);
     temp=true;
   }
    else
   {
    temp=false; 
   }
   
   if(temp){
      JOptionPane.showMessageDialog(this,"Recheck your details...","Error Message",JOptionPane.ERROR_MESSAGE);
      return;
    }
			String taxable="";
						if(r1.isSelected())
							taxable="Yes";
						else if(r2.isSelected())
							taxable="No";
			try
			{
				txt4.setText(txt1.getText()+"00");
				
				pst=con.prepareStatement("insert into Main_Product_Master values(?,?,?,?,?)");
				pst.setString(1,txt1.getText());
				pst.setString(2,txt2.getText());
				pst.setString(3,taxable);
				pst.setString(4,txt4.getText());
				pst.setBinaryStream(5,new FileInputStream(f),(int)f.length());
				
				if(pst.executeUpdate()>0)
				{
					JOptionPane.showMessageDialog(this,"Data Saved...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Data Not Saved...","Eror Message",JOptionPane.ERROR_MESSAGE);	
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,"Data Not Saved","Eror Message",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	else if(evt.getSource()==btn3){
		repaint();
		reset();}
	else if(evt.getSource()==btn4)
	{
		repaint();
		int opt= JOptionPane.showConfirmDialog(this,"Do You Want To Exit..."); 
     if(opt==JOptionPane.YES_OPTION)
     {  
        dispose();
      }
	}
	
	else if(evt.getSource()==btn2)
		{
			repaint();
			  String id=JOptionPane.showInputDialog(this,"Enter Your  Main Product Id");
			  
			  
			  try
			{
			pst	=con.prepareStatement("Select * from main_product_master where main_prod_id=?");
				  pst.setString(1,id);
				   rst=pst.executeQuery();
				  if(rst.next())
				  {
						txt1.setText(rst.getString("main_prod_id"));
						txt2.setText(rst.getString("main_prod_name"));
						String g=rst.getString("taxable");
						if(g.equalsIgnoreCase("yes"))
							r1.setSelected(true);
						else if(g.equalsIgnoreCase("no"))
							r2.setSelected(true);
						txt4.setText(rst.getString("prod_last_ref"));
						byte b[]=rst.getBytes("Prod_image");
						Image img=Toolkit.getDefaultToolkit().createImage(b);
                         img=img.getScaledInstance(300,300,Image.SCALE_SMOOTH);
                         lbl5.setIcon(new ImageIcon(img));
						 
				  }
					else
				   {
						lbl5.setIcon(null);
				        JOptionPane.showMessageDialog(this,"Data Not Found","Error Message",JOptionPane.ERROR_MESSAGE);						
				   }
			}
			
			catch(Exception e){JOptionPane.showMessageDialog(this,"Data Not Found","Error Message",JOptionPane.ERROR_MESSAGE);}
				
		}
		
		
		
	
if(evt.getSource() == backup)
{
	repaint();
  String d = new SimpleDateFormat("dd-MMM-yyyy").format(new java.util.Date());
  String fnm = "SudhaMainProduct"+d;
  String s = "exp sudha/sudha123 file = D:\\BackupMainProduct\\"+fnm+".dmp";
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
      txt1.setText("P"+"0"+String.valueOf(id));
     }
     else if(id>=10 && id<100)
    {
       txt1.setText("P"+String.valueOf(id));	
    }
     else
      {
        txt1.setText("Out of Bounds");
      }
    }
    catch(Exception ee){System.out.println(ee);}
		
		txt2.setText("");
		txt4.setText("");
		bg.clearSelection();
		lbl5.setIcon(new ImageIcon(""));
		
	}
	
	public static void main(String[]args)
	{
		new MainProductMaster();
	}
}