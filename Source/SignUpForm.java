import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.sql.*;
public class SignUpForm extends JFrame implements ActionListener
{
  static boolean show = true;
	Connection con;
	ResultSet rst;
	PreparedStatement pst;
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
  String opt;
	JLabel head=new JLabel("<html><u>Sign Up</u></html>");
	JLabel uname=new JLabel("User Name");
  JLabel unameerror=new JLabel();
	JLabel pwd=new JLabel("Password");


	JLabel cpwderror=new JLabel();
	JLabel cpwd=new JLabel("Confirm Password");
	JLabel gen=new JLabel("Gender");
	 ButtonGroup bg=new ButtonGroup(); 
    JRadioButton rm=new JRadioButton("Male");
    JRadioButton rf=new JRadioButton("Female");
	JLabel sq=new JLabel("Security Question:- What is your favourite book?");
	JTextField tuname=new JTextField();
	JPasswordField tpwd=new JPasswordField();
	JPasswordField tcpwd=new JPasswordField();
    JTextField tsq=new JTextField();
    JLabel address=new JLabel("Address");
    JTextArea taddress=new JTextArea();
    JLabel contact=new JLabel("Contact No.");
     JLabel contacterror=new JLabel();
    JTextField tcontact=new JTextField();
    JLabel addhar=new JLabel("Addhar No.");
     JLabel addharerror=new JLabel();
    JTextField taddhar=new JTextField();
    JLabel id=new JLabel("User Id");
     JLabel iderror=new JLabel();
    JTextField tid=new JTextField();
    JLabel email=new JLabel("Email Id");
    JLabel emailerror=new JLabel();
    JTextField temail=new JTextField();
     JLabel sicon=new JLabel()
  {
     public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("icon.jpg").getImage(),0 , 0 ,60,60 , null);
        
        }
  };
    JButton submit=new JButton("Submit")
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
    JButton search = new JButton("Search")
    {
       public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("search.png").getImage(),5 , 10 ,20,20 , null);
        } 
    };
    JButton cancel=new JButton("Reset")
    {
      public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("reset.png").getImage(),0 , 0 ,40,40 , null);
        } 
    };
    JButton back = new JButton()
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
        g.drawImage(new ImageIcon("backup.png").getImage(),0 , 0 , 60,60 , null);
        } 
    };
    JPanel pmaster=new JPanel()
    {
        public void paintComponent(Graphics g)
        {
        super.paintComponent(g); 	
        g.drawImage(new ImageIcon("user.jpg").getImage(),0 , 0 ,w,h , null);
        }
	};
    JPanel pchild=new JPanel();
    Toolkit toolkit=Toolkit.getDefaultToolkit();
	Dimension dimension=toolkit.getScreenSize();
	int w,h;
	{
     w=(int)dimension.getWidth();
     h=(int)dimension.getHeight();
	}
   JButton pwdvisible=new JButton()
    {
       public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("anti-click-fraud.png").getImage(),0 , 0 ,30,30 , null);
        }
    };
	SignUpForm()
	{
    setTitle("Product Marketing Management System -- Sign Up");
	setResizable(false);

	add(pmaster);
  pmaster.setBounds(50 , 50 , w-100 , h-100);
	
	pmaster.setLayout(null);
	pchild.setBounds(20,20,w-140,h-160);
	pmaster.add(pchild);
	pchild.setBackground(new Color(100,100,111,100));
	pchild.setLayout(null);

  pchild.add(sicon);sicon.setBounds(450 , 0 , 60 , 60);
  setIconImage(new ImageIcon("icon.jpg").getImage());
    
	
    head.setBounds(490,0,250,60);
	
	pchild.add(head);
		head.setHorizontalAlignment(JLabel.CENTER);
	head.setVerticalAlignment(JLabel.CENTER);
	head.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,50));
	head.setForeground(Color.WHITE);
	
      id.setBounds(150,70,280,35);pchild.add(id);
    id.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    id.setForeground(Color.RED);
    iderror.setBounds(650,70,50,35);pchild.add(iderror);
    tid.setBounds(440,70,200,35);pchild.add(tid);
    
    uname.setBounds(150,115,280,35);pchild.add(uname);
    unameerror.setBounds(650,115,150,35);pchild.add(unameerror);
    unameerror.setForeground(Color.RED);
     unameerror.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,20));
    uname.setForeground(Color.RED);
    uname.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    tuname.setBounds(440,115,200,35);pchild.add(tuname);
   
     pwd.setBounds(150,160,250,35);pchild.add(pwd);
    
     pwd.setForeground(Color.RED);
    pwd.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    tpwd.setBounds(440,160,200,35);pchild.add(tpwd);
    tpwd.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    cpwd.setBounds(150,205,250,35);pchild.add(cpwd);
    cpwderror.setBounds(650,205,300,35);pchild.add(cpwderror);
    cpwd.setForeground(Color.RED);
    cpwd.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
 
    tcpwd.setBounds(440,205,200,35);pchild.add(tcpwd);
    tcpwd.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    
     contact.setBounds(150,250,250,35);pchild.add(contact);
     contacterror.setBounds(650,250,150,35);pchild.add(contacterror);
     contacterror.setForeground(Color.RED);
     contacterror.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
     contact.setForeground(Color.RED);
    contact.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
     tcontact.setBounds(440,250,200,35);pchild.add(tcontact);
    
     addhar.setBounds(150,295,250,35);pchild.add(addhar);
     addharerror.setBounds(650,295,150,35);pchild.add(addharerror);
     addharerror.setForeground(Color.RED);
     addharerror.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
     addhar.setForeground(Color.RED);
    addhar.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    taddhar.setBounds(440,295,200,35);pchild.add(taddhar);
    
     email.setBounds(150,340,250,35);pchild.add(email);
      emailerror.setBounds(650,340,150,35);pchild.add(emailerror);
      emailerror.setForeground(Color.RED);
     emailerror.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
     email.setForeground(Color.RED);
    email.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    temail.setBounds(440,340,200,35);pchild.add(temail);
    
     gen.setBounds(150,385,250,35);pchild.add(gen);
     gen.setForeground(Color.RED);
     gen.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    
      rm.setBounds(440,385,100,35); pchild.add(rm);
      rm.setFont(new Font( "Arial",Font.BOLD ,30));
      rm.setForeground(Color.RED);rm.setOpaque(false);
      rf.setBounds(550,385,150,35); pchild.add(rf);
      rf.setForeground(Color.RED);rf.setOpaque(false);
      rf.setFont(new Font( "Arial",Font.BOLD ,30));
      bg.add(rm);
      bg.add(rf); 


      sq.setBounds(150,520,w-50,35);pchild.add(sq);
      sq.setForeground(Color.RED);
    sq.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,35));
    tsq.setBounds(150,565,300,35);pchild.add(tsq);

     address.setBounds(150,430,255,35);pchild.add(address);
     address.setForeground(Color.RED);
    address.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30)); 
    taddress.setBounds(440,430,300,80);pchild.add(taddress);
    
    submit.setBounds(1000,300,150,40);pchild.add(submit);
    submit.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    
    cancel.setBounds(1000,350,150,40);pchild.add(cancel);
    cancel.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));

    pchild.add(search);search.setBounds(1000,400,150,40);
    search.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));

    pchild.add(update);update.setBounds(1000,450,150,40);
    update.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    
    pchild.add(back);
    back.setBounds(10, 10 , 60 , 60);
    back.setContentAreaFilled(false);
    back.setBorderPainted(false);   

    backup.setBounds(1080,10,60,60);pchild.add(backup);
    backup.setContentAreaFilled(false);
    backup.setBorderPainted(false);   

    pchild.add(pwdvisible);pwdvisible.setBounds(645, 162 , 30 , 30);
       pwdvisible.setContentAreaFilled(false);
       pwdvisible.setBorderPainted(false); 

    setBounds(50,50, w-100 , h-100);
    setVisible(true);
	 cpwderror.setOpaque(false);
	 submit.addActionListener(this);
	 cancel.addActionListener(this); 
   back.addActionListener(this);
   search.addActionListener(this);
   update.addActionListener(this);
   backup.addActionListener(this);
   pwdvisible.addActionListener(this);

    }
	
	public void actionPerformed(ActionEvent evt)
    {
     
    if(evt.getSource()==pwdvisible)
    {
      repaint();
      if(show == true)
      {
      tpwd.setEchoChar((char)0);
     tcpwd.setEchoChar((char)0);
      show = false;
      }
      else if(show == false)
      {
       tpwd.setEchoChar('*');
       tcpwd.setEchoChar('*'); 
       show = true;
      }
    }
     
    	if(evt.getSource()==submit)
    {  
      repaint();
      String a , b ;
      a = tpwd.getText();
      b = tcpwd.getText();
      boolean temp=false;
      
    if(!validationname.checkname(tuname.getText()))
    {
      unameerror.setText("Only Alphabets");
     temp=true;
   }
   
    
   else
   {
    unameerror.setText("");
   }
   if(!Validation.check(tcontact.getText()))
    {
      contacterror.setText("***");
      temp=true;
    }
    else
   {
    contacterror.setText("");
    
    }
      if(!ValidationEmail.checkEmail(temail.getText()))
    {
     emailerror.setText("***");
     temp=true; 
    }
    else
   {
    emailerror.setText("");
   }
   if(!validationaddhar.checkaddhar(taddhar.getText()))
    {
     addharerror.setText("***");
     temp=true; 
    }
    else
   {
    addharerror.setText("");
   }
    if(!ValidationPassword.checkPassword(tpwd.getText()))
    {
     JOptionPane.showMessageDialog(this,"Password must be 8 charcters long , it must contain an upper case alphabet , a lower case alphabet , a digit and a special charcter...","Error Message",JOptionPane.ERROR_MESSAGE);
     temp=true; 
    }
    
    if(temp)
    {
      JOptionPane.showMessageDialog(this,"Sign Up denied...","Error Message",JOptionPane.ERROR_MESSAGE);
      setVisible(false);
      setVisible(true);
      return;
    }


       String gender="";
  
   if(rm.isSelected())
        {gender="Male";}
      else if(rf.isSelected())
      {
        gender="Female";
      }
      if(a.equals(b))
  {
      cpwderror.setOpaque(false);
      cpwderror.setText("");
      cpwderror.setVisible(false);
      
   
      try
      {
         pst=con.prepareStatement("insert into sign_in values(?,?,?,?,?,?,?,?,?)");
         pst.setString(1,tid.getText());
         pst.setString(2,tuname.getText());
         pst.setString(3,tpwd.getText());
         pst.setString(4,gender);
         pst.setString(5,tsq.getText());
         pst.setString(6,taddress.getText());
         pst.setString(7,tcontact.getText());
         pst.setString(8,taddhar.getText());
         pst.setString(9,temail.getText());
      
       if(pst.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(this,"Signed Up Successfully...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Sign Up Denied...","Error Message",JOptionPane.ERROR_MESSAGE);   
                }
            }
            
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this,ex);
            }
      }
            else
  { 
    cpwderror.setText("The passwords don't match!!..");
    
    cpwderror.setForeground(Color.RED);
    cpwderror.setFont(new Font( "Arial",Font.BOLD ,20));
    cpwderror.setVisible(true);

  }
   
      }

  if(evt.getSource() == backup)
{
  repaint();
  String d = new SimpleDateFormat("dd-MMM-yyyy").format(new java.util.Date());
  String fnm = "SudhaUser"+d;
  String s = "exp sudha/sudha123 file = D:\\BackupUser\\"+fnm+".dmp";
  try
  {
    Process p = Runtime.getRuntime().exec(s);
    JOptionPane.showMessageDialog(this,"BackUp Done...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
  }
  catch(Exception e){JOptionPane.showMessageDialog(this,"BackUp Not Done...","Error Message",JOptionPane.ERROR_MESSAGE); }
}   
if(evt.getSource() == search)
{
  String id=JOptionPane.showInputDialog(this,"Enter your User Id");
  opt=id;
  reset();
  try
  {
     
    pst =con.prepareStatement("select * from sign_in where user_id =?");
    pst.setString(1,opt);
     rst=pst.executeQuery();
     if(rst.next())
     {tid.setText(rst.getString("user_id"));
      tuname.setText(rst.getString("user_name"));
      tpwd.setText(rst.getString("pwd"));
       String g=rst.getString("gender");
                if(g.equalsIgnoreCase("Male"))
                  rm.setSelected(true);
                else if(g.equalsIgnoreCase("Female"))
                rf.setSelected(true);
        tsq.setText(rst.getString("security_question"));
         taddress.setText(rst.getString("address"));
          tcontact.setText(rst.getString("contact_no"));
           taddhar.setText(rst.getString("addhar_no"));
           temail.setText(rst.getString("email"));
          
            
               
       
       rm.setEnabled(false);
       rf.setEnabled(false);
        tid.setEditable(false);
        tuname.setEditable(false);
        tpwd.setEditable(false);
              
      tsq.setEditable(false);
                
     taddhar.setEditable(false);
            
     tcpwd.setEditable(false);
  
     }
     else
     {
      
      JOptionPane.showMessageDialog(this,"Data Not found...","Error Message",JOptionPane.ERROR_MESSAGE);

     }
  }
     catch(Exception ef){JOptionPane.showMessageDialog(this,"Data Not Found...","Error Message",JOptionPane.ERROR_MESSAGE);}

}
if(evt.getSource() == back)
{
  int opt= JOptionPane.showConfirmDialog(this,"Do You Want To Exit..."); 
     if(opt==JOptionPane.YES_OPTION)
     {  
        dispose();
      }
}   
if(evt.getSource() == cancel)
{
  repaint();
  reset();
}
if(evt.getSource() == update)
{
  repaint();
   try
  {
    
        pst=con.prepareStatement("update sign_in set Address=?,Contact_no=?,addhar_no=?,email=? where user_id=?");
         
                 pst.setString(1,taddress.getText());

                pst.setString(2,tcontact.getText());

                pst.setString(3,taddhar.getText());
                pst.setString(4,temail.getText());
                pst.setString(5,tid.getText());

             
       if(pst.executeUpdate()>0)
        {
          JOptionPane.showMessageDialog(this,"Data Updated...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
          JOptionPane.showMessageDialog(this,"Data Not Updtaed...","Error Message",JOptionPane.ERROR_MESSAGE); 
        }
      
      
      }
        catch(Exception et){JOptionPane.showMessageDialog(this,et.toString());}
}
  
  }
  void reset()
  {
    repaint();
    rm.setEnabled(true);
       rf.setEnabled(true);
        tid.setEditable(true);
        tuname.setEditable(true);
        tpwd.setEditable(true);
              
      tsq.setEditable(true);
                
     taddhar.setEditable(true);
            
     tcpwd.setEditable(true);
     rm.setSelected(false);
     rf.setSelected(false);
     tid.setText("");
     tuname.setText("");
     tpwd.setText("");
     tcpwd.setText("");
     tsq.setText("");
     taddhar.setText("");
     taddress.setText("");
     tcontact.setText("");
     temail.setText("");
    
  }
    
	public static void main(String...args)
	{
	  new SignUpForm();
	}
}