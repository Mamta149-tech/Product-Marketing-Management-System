import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.*;
import java.io.*;
import java.text.*;
import java.sql.*;


public class distributermaster extends JFrame implements ActionListener
  {

    PreparedStatement pst;
   Connection con;
   ResultSet rst;
  File  f;
 {
  
   
      try
    {
     Class.forName("oracle.jdbc.driver.OracleDriver");//class not found exception
    
    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sudha","sudha123");//sqlexcpetion
    
   }
   catch(SQLException e)
  {
    System.out.println(e);
  }
   catch(ClassNotFoundException e){}
  }
  int opt;
    JLabel lbL=new JLabel("<html><u>Distributor Entry</u></html>");
	JLabel lbl=new JLabel("Distributor Id");
	JLabel lbl1=new JLabel("Distributor Name");
  JLabel lbl1E=new JLabel();
	JLabel lbl2=new JLabel("Address");
	JLabel lbl3=new JLabel("Contact no");
  JLabel lbl3E=new JLabel();
	JLabel lbl4=new JLabel("E-mail");
  JLabel lbl4E=new JLabel("");
	JLabel lbl5=new JLabel("Addhar no.");
  JLabel lbl5E=new JLabel();
	JLabel lbl6=new JLabel("Pancard no.");
  JLabel lbl6E=new JLabel();
	JLabel lbl7=new JLabel("Zone id");
	JLabel lbl8=new JLabel("Date of Birth");
    JLabel lbl9=new JLabel("Select Image");
    JLabel lbl10=new JLabel("Office ref.");
    JLabel lbl11=new JLabel("Ref. Date");
    JTextField txt8=new JTextField();
	JTextField txt=new JTextField();
	JTextField txt1=new JTextField();
	JTextArea txt2=new JTextArea();
  JScrollPane jsp = new JScrollPane(txt2);
	JTextField txt3=new JTextField();
	JTextField txt4=new JTextField();
	JTextField txt5=new JTextField();
	JTextField txt6=new JTextField();
	JTextField txt7=new JTextField();
  
	JLabel Gen=new JLabel("Gender");
  ButtonGroup bg=new ButtonGroup(); 
  JRadioButton rm=new JRadioButton("Male");
  JRadioButton rf=new JRadioButton("Female");
   JLabel sicon=new JLabel()
  {
     public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("icon.jpg").getImage(),0 , 0 ,50,50 , null);
        
        }
  };
  
	JButton insert=new JButton("Insert")
  {
   public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("insert.png").getImage(),0 , 0 ,40,40 , null);
        } 
  };
    JButton update=new JButton("Update")
    {
   public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("update.png").getImage(),0 , 5 ,30,30 , null);
        } 
  };
    JButton reset=new JButton("Reset")
    {
   public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("reset.png").getImage(),0 , 0 ,40,40 , null);
        } 
  };
    JButton search=new JButton("Search")
    {
   public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("search.png").getImage(),5 , 10 ,20,20 , null);
        } 
  };
    JButton exit=new JButton()
    {
       public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("back1 (2).png").getImage(),0 , 0 ,60,60 , null);
        }
    };
    JButton browse=new JButton("Browse")
    {
   public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("browse.png").getImage(),5 , 10 ,20,20 , null);
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
        g.drawImage(new ImageIcon("23__RAJ0089.jpg").getImage(),0 , 0 ,w,h , null);
        }
    };
    JPanel p2=new JPanel();
    JDateChooser calendar=new JDateChooser(new java.util.Date());
    JDateChooser calendar1=new JDateChooser(new java.util.Date());
	Toolkit toolkit=Toolkit.getDefaultToolkit();
	Dimension dimension=toolkit.getScreenSize();
    int w,h;
    {
        w=(int)dimension.getWidth();
        h=(int)dimension.getHeight();
    }


	
	 distributermaster()
	{
    setTitle("Product Marketing Management System -- Distributor");
    if(LoginForm.admin_login.equals("admin") && LoginForm.pwd_login.equals("sudha123"))
    {
      insert.setVisible(true);
      update.setVisible(true);
      reset.setVisible(true);
      browse.setVisible(true);
      search.setVisible(true);
      exit.setVisible(true);
      

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
        txt.setText("000000"+String.valueOf(id));
      }
      else if(id>=10 && id<100 )
      {
        txt.setText("00000"+String.valueOf(id));
      }
      else if(id>=100 && id<1000 )
      {
        txt.setText("0000"+String.valueOf(id));
      }
      else if(id>=1000 && id<10000 )
      {
        txt.setText("000"+String.valueOf(id));
      }
      else if(id>=10000 && id<100000 )
      {
        txt.setText("00"+String.valueOf(id));
      }
      else if(id>=100000 && id<1000000 )
      {
        txt.setText("0"+String.valueOf(id));
      }
      else if(id>=1000000 && id<10000000)
      {
        txt.setText(String.valueOf(id));
      }
      else
      {
        txt.setText("Out of Bounds");
      }
      
    }
    catch(Exception ee){System.out.println(ee);}
   

    }
    else
    {
      
      insert.setVisible(false);
      update.setVisible(true);
      reset.setVisible(true);
      browse.setVisible(true);
      search.setVisible(true);
      exit.setVisible(true);
      
    }
    
   setResizable(false);     
	add(p1);
	p1.setBackground(Color.PINK);
	p1.setLayout(null);
	p2.setBounds(20,20,w-50,h-80);
    p1.add(p2);
    p2.setBackground(new Color(112,112,113,150));
    p2.setLayout(null);
    p2.add(calendar);
    lbL.setBounds(450 , 10 , 350 ,50);
    p2.add(lbL);
    p2.add(lbL);
    

	lbL.setHorizontalAlignment(JLabel.CENTER);
	lbL.setVerticalAlignment(JLabel.CENTER);
	lbL.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,45));
	lbL.setForeground(Color.WHITE);lbL.setBackground(Color.BLACK);lbL.setOpaque(true);
  
  p2.add(exit);exit.setBounds(10, 10 , 60 , 60);
   exit.setContentAreaFilled(false);
      exit.setBorderPainted(false); 

      p2.add(sicon);sicon.setBounds(380 , 10 , 50 , 50);

      setIconImage(new ImageIcon("icon.jpg").getImage());
      

	lbl.setBounds(100,80,250,35);p2.add(lbl);lbl.setForeground(Color.WHITE);
    lbl.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
   
	
	  lbl1.setBounds(100,120,250,35);p2.add(lbl1);lbl1.setForeground(Color.WHITE);
    lbl1.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    lbl1E.setBounds(620,120,250,50); p2.add(lbl1E);
    lbl1E.setFont(new Font( "Arial",Font.PLAIN ,22));
     lbl1E.setForeground(Color.RED);
	
    lbl2.setBounds(100,165,250,35);p2.add(lbl2);lbl2.setForeground(Color.WHITE);
   lbl2.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));

     Gen.setBounds(100,525,250,35);p2.add(Gen);Gen.setForeground(Color.WHITE);
     Gen.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    
      rm.setBounds(360,525,100,35); p2.add(rm);rm.setOpaque(false);
      rm.setFont(new Font( "Arial",Font.BOLD ,22));rm.setForeground(Color.WHITE);
      rf.setBounds(470,525,100,35); p2.add(rf);rf.setOpaque(false);
      rf.setFont(new Font( "Arial",Font.BOLD ,22));rf.setForeground(Color.WHITE);
      bg.add(rm);rm.setSelected(false);
      rf.setSelected(false);
      bg.add(rf); 
    lbl3.setBounds(100,250,250,35); p2.add(lbl3);lbl3.setForeground(Color.WHITE);
    lbl3E.setBounds(620,250,250,50); p2.add(lbl3E);
    lbl3E.setFont(new Font( "Arial",Font.PLAIN ,32));

    lbl3E.setForeground(Color.RED);
    lbl3.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    
   
    lbl4.setBounds(100,295,250,35);p2.add(lbl4);lbl4.setForeground(Color.WHITE);
     lbl4E.setBounds(620,295,250,50);p2.add(lbl4E);
     lbl4E.setFont(new Font( "Arial",Font.PLAIN ,32));

      lbl4E.setForeground(Color.RED);
    lbl4.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));

    
    lbl5.setBounds(100,345,250,35); p2.add(lbl5);lbl5.setForeground(Color.WHITE);
    lbl5.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    lbl5E.setBounds(620,345,250,50); p2.add(lbl5E);
    lbl5E.setFont(new Font( "Arial",Font.PLAIN ,32));
     lbl5E.setForeground(Color.RED);

   
    lbl6.setBounds(100,390,250,35); p2.add(lbl6);lbl6.setForeground(Color.WHITE);
    lbl6.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    lbl6E.setBounds(620,390,250,50); p2.add(lbl6E);
    lbl6E.setFont(new Font( "Arial",Font.PLAIN ,32));
     lbl6E.setForeground(Color.RED);
   
    lbl7.setBounds(100,435,250,35); p2.add(lbl7);lbl7.setForeground(Color.WHITE);
    lbl7.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));

   
    lbl8.setBounds(100,480,250,35); p2.add(lbl8);lbl8.setForeground(Color.WHITE);
    lbl8.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
     
     lbl9.setBounds(800,100,150,150);p2.add(lbl9);
     lbl9.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,25));
   lbl9.setOpaque(true);lbl9.setBackground(Color.WHITE);
   lbl9.setHorizontalAlignment(JLabel.CENTER);
   lbl9.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
    txt.setBounds(360,80,250,35);
    p2.add(txt);
    txt.setFont(new Font( "Arial",Font.PLAIN ,22));txt.setEditable(false);

    txt1.setBounds(360,120,250,35);
    p2.add(txt1);
    txt1.setFont(new Font( "Arial",Font.PLAIN ,22));

    jsp.setBounds(360,165,250,75);
    p2.add(jsp);
    txt2.setFont(new Font( "Arial",Font.PLAIN ,22));

    txt3.setBounds(360,250,250,35);
    p2.add(txt3);
    txt3.setFont(new Font( "Arial",Font.PLAIN ,22));

    txt4.setBounds(360,295,250,35);
    p2.add(txt4);
    txt4.setFont(new Font( "Arial",Font.PLAIN ,22));

    txt5.setBounds(360,340,250,35);
    p2.add(txt5);
    txt5.setFont(new Font( "Arial",Font.PLAIN ,22));

    txt6.setBounds(360,385,250,35);
    p2.add(txt6);
    txt6.setFont(new Font( "Arial",Font.PLAIN ,22));

    txt7.setBounds(360,430,250,35);
    p2.add(txt7);
    txt7.setFont(new Font( "Arial",Font.PLAIN ,22));
    lbl10.setBounds(100,570,250,35);p2.add(lbl10);
    lbl10.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));lbl10.setForeground(Color.WHITE);
    txt8.setBounds(360,570,250,35);p2.add(txt8);
    txt8.setFont(new Font( "Arial",Font.PLAIN ,22));
    lbl11.setBounds(100,615,250,35);p2.add(lbl11);lbl11.setForeground(Color.WHITE);
    
    lbl11.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
     calendar1.setBounds(360,615,250,35);p2.add(calendar1);
    calendar1.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,23));
  
    calendar1.setForeground(Color.BLACK);


    calendar.setBounds(360,480,250,35);
    calendar.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,23));
  
    calendar.setForeground(Color.BLACK);

    insert.setBounds(1050,200,150,40);
    insert.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));

    p2.add(insert);
     update.setBounds(1050,260,150,40);
   update.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));

    p2.add(update);
     reset.setBounds(1050,320,150,40);
    reset.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));

    p2.add(reset);
     search.setBounds(1050,380,150,40);
    search.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));

    p2.add(search);
   
    browse.setBounds(800,260,150,40);p2.add(browse);
    browse.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
     
    backup.setBounds(1180,10,60,60);p2.add(backup);
   backup.setContentAreaFilled(false);
      backup.setBorderPainted(false);   

    setSize(w,h);
    setVisible(true);
    insert.addActionListener(this);
     update.addActionListener(this);
      reset.addActionListener(this);
       search.addActionListener(this);
        exit.addActionListener(this);
        browse.addActionListener(this);
         
         backup.addActionListener(this);
}
public void actionPerformed(ActionEvent evt)

  {
   
      
    if(evt.getSource()==exit)
    {
      int opt= JOptionPane.showConfirmDialog(this,"Do You Want To Exit..."); 
     if(opt==JOptionPane.YES_OPTION)
     {  
        dispose();
      }
    }
  if(evt.getSource()==insert)

   {
    repaint();
    boolean temp=false;
    if(!validationname.checkname(txt1.getText()))
    {
      lbl1E.setText("Only Alphabets");
     temp=true;
   }
   else
   {
    lbl1E.setText("");
   }
    
    if(!Validation.check(txt3.getText()))
    {
      lbl3E.setText("***");
      temp=true;
    }
    else
   {
    lbl3E.setText("");
   }
       if(!ValidationEmail.checkEmail(txt4.getText()))
    {
     lbl4E.setText("***");
     temp=true; 
    }
    else
   {
    lbl4E.setText("");
   }
     if(!validationaddhar.checkaddhar(txt5.getText()))
    {
     lbl5E.setText("**");
     temp=true; 
    }
    else
   {
    lbl5E.setText("");
   }
      if(!validationpan.checkpan(txt6.getText()))
    {
     lbl6E.setText("**");
      temp=true; 
    }
    else
   {
    lbl6E.setText("");
   }
    
   
    if(temp){
      JOptionPane.showMessageDialog(this,"Recheck your details...","Error Message",JOptionPane.ERROR_MESSAGE);
      return;
    }
    
    String gender="";
  



if(rm.isSelected())
        {gender="Male";}
      else if(rf.isSelected())
      {
        gender="Female";
      }

   
    try
    {
       SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-YYYY");
     String str = sf.format(calendar.getDate());
     String str1 = sf.format(new java.util.Date());
     SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-YYYY");
     java.util.Date cur_date = sd.parse(str1);
     java.util.Date date_of_birth = sd.parse(str);
     long diff=cur_date.getTime()-date_of_birth.getTime();
     long no_of_days = (int)(diff/(60*60*1000*24));
     long no_of_year = (no_of_days/30)/12;
     JOptionPane.showMessageDialog(this,"Age="+no_of_year);
     if(no_of_year<18)
     {
      JOptionPane.showMessageDialog(this,"You Are Not Eligible...");
      return;
     }
     if(no_of_year>18)
     {
      
   SimpleDateFormat sdf1=new SimpleDateFormat("dd-MMM-yyyy");
      String st1=sdf1.format(calendar.getDate());
    
   SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
      String st=sdf.format(calendar1.getDate());
    
    
    

     
      pst=con.prepareStatement("insert into distributor_master values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(2,txt1.getText());
                pst.setInt(1,Integer.parseInt(txt.getText()));
                pst.setString(3,txt2.getText());
                pst.setString(4,txt3.getText());
                pst.setString(5,txt4.getText());
                pst.setString(6,txt5.getText());
                pst.setString(7,txt6.getText());
                pst.setString(8,txt7.getText());
                 pst.setString(10,txt8.getText());
                 pst.setBinaryStream(12,new FileInputStream(f),(int)f.length());
              pst.setString(9,st1);
              pst.setString(11,st);
              pst.setString(13,gender);


                
                if(pst.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(this,"Data Saved...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Data Not Saved...","Error Message",JOptionPane.ERROR_MESSAGE);   
                }
              }
            }
            
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this,"Data Not Saved...","Error Message",JOptionPane.ERROR_MESSAGE);
            }
          
}
if(evt.getSource()==update)
{
  repaint();
  try
  {
    
        pst=con.prepareStatement("update distributor_master set Address=?,Contact_no=?,e_mail=? where dist_id=?");
         
     
      
                 pst.setString(1,txt2.getText());

                pst.setString(2,txt3.getText());

                pst.setString(3,txt4.getText());
                pst.setInt(4,opt);
               
                 


                
       if(pst.executeUpdate()>0)
        {
          JOptionPane.showMessageDialog(this,"Data Updated...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
          JOptionPane.showMessageDialog(this,"Data Not Updtaed...","Error Message",JOptionPane.ERROR_MESSAGE); 
        }
      
      
      
        
      }
        catch(Exception et){JOptionPane.showMessageDialog(this,"Data Not Updated...","Error Message",JOptionPane.ERROR_MESSAGE);}
}

if(evt.getSource()==browse)
{ 
  repaint();
  JFileChooser fchooser=new JFileChooser();
      int opt=fchooser.showOpenDialog(this);
      if(opt==JFileChooser.OPEN_DIALOG)
      {
        f=fchooser.getSelectedFile();
        String path=f.getAbsolutePath();
        Image img=Toolkit.getDefaultToolkit().getImage(path);
        Image img1=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        lbl9.setIcon(new ImageIcon(img1));
      }
 }
  if(evt.getSource()==reset){
    repaint();
    reset();}
 if(evt.getSource()==search)
 { 
    
    repaint();
  String id=JOptionPane.showInputDialog(this,"Enter your distributor Id");
  opt=Integer.parseInt(id);
  reset();
  try
  {
    
    pst =con.prepareStatement("select * from distributor_master where dist_id=?");
    pst.setInt(1,opt);
     rst=pst.executeQuery();
     if(rst.next())
     {txt.setText(rst.getString("dist_id"));
      txt1.setText(rst.getString("dist_name"));
      txt2.setText(rst.getString("address"));
       txt3.setText(rst.getString("Contact_no"));
        txt4.setText(rst.getString("e_mail"));
         txt5.setText(rst.getString("aadhaar_no"));
          txt6.setText(rst.getString("pan_card_no"));
           txt7.setText(rst.getString("zone_id"));
           txt8.setText(rst.getString("office_ref"));
          
            calendar.setDate(rst.getDate("DOB"));
             
              calendar1.setDate(rst.getDate("ref_date"));
               
               String g=rst.getString("gender");
                if(g.equalsIgnoreCase("Male"))
                  rm.setSelected(true);
                else if(g.equalsIgnoreCase("Female"))
                rf.setSelected(true);
       byte b[]=rst.getBytes("image");
       Image img=Toolkit.getDefaultToolkit().createImage(b);
       img=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
       lbl9.setIcon(new ImageIcon(img));
       rm.setEnabled(false);
       rf.setEnabled(false);
        txt.setEditable(false);
        txt1.setEditable(false);
        txt5.setEditable(false);
              
      txt6.setEditable(false);
                
     txt7.setEditable(false);
            
     txt8.setEditable(false);
    
   calendar.setEnabled(false);
   calendar1.setEnabled(false);


     }
     else
     {
      lbl9.setIcon(null);

      JOptionPane.showMessageDialog(this,"Data Not Found...","Error Message",JOptionPane.ERROR_MESSAGE);

     }
   
  }
     catch(Exception ef){JOptionPane.showMessageDialog(this,"Data Not Found...","Error Message",JOptionPane.ERROR_MESSAGE);}

  }
  
if(evt.getSource() == backup)
{
  repaint();
  String d = new SimpleDateFormat("dd-MMM-yyyy").format(new java.util.Date());
  String fnm = "SudhaDistributor"+d;
  String s = "exp sudha/sudha123 file = D:\\BackupDistributor\\"+fnm+".dmp";
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
       pst=con.prepareStatement("Select max(dist_id) from distributor_master");
      int id=1;
      ResultSet rst=pst.executeQuery();
      if(rst.next())
      {
        id=rst.getInt(id)+1;
        
      }
      if(id<10)
      {
        txt.setText("000000"+String.valueOf(id));
      }
      else if(id>=10 && id<100 )
      {
        txt.setText("00000"+String.valueOf(id));
      }
      else if(id>=100 && id<1000 )
      {
        txt.setText("0000"+String.valueOf(id));
      }
      else if(id>=1000 && id<10000 )
      {
        txt.setText("000"+String.valueOf(id));
      }
      else if(id>=10000 && id<100000 )
      {
        txt.setText("00"+String.valueOf(id));
      }
      else if(id>=100000 && id<1000000 )
      {
        txt.setText("0"+String.valueOf(id));
      }
      else if(id>=1000000 && id<10000000)
      {
        txt.setText(String.valueOf(id));
      }
      else
      {
        txt.setText("Out of Bounds");
      }
      
    }
    catch(Exception ee){System.out.println(ee);}
   

    
  
  txt1.setText("");
  txt2.setText("");
  txt3.setText("");
  txt4.setText("");
  txt5.setText("");
  txt6.setText("");
  txt7.setText("");
  txt8.setText("");
  lbl1E.setText("");
  lbl3E.setText("");
  lbl4E.setText("");
  lbl5E.setText("");
  lbl6E.setText("");
  lbl9.setIcon(new ImageIcon(""));
  calendar.setDate(null);
  calendar1.setDate(null);
   txt5.setEditable(true);
              
  txt6.setEditable(true);
                
   txt7.setEditable(true);
            
   txt8.setEditable(true);
   txt.setEditable(true);
bg.clearSelection();
   txt1.setEditable(true);
calendar.setEnabled(true);
calendar1.setEnabled(true);

}
   public static void main(String[]args)
   {
   new distributermaster();
   }
}