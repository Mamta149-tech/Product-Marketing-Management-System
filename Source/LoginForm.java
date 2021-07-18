import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.sql.*;
public class LoginForm extends JFrame implements ActionListener
{
   static boolean show = true;
	Connection con;
	ResultSet rst;
	PreparedStatement pst;
  String admin = "admin";
  String password = "sudha123";
  public static String admin_login , pwd_login;
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
  


	JLabel lbl=new JLabel("<html><u>Login</u></html>");
	JLabel name=new JLabel("User Id");
  JButton pwdvisible=new JButton()
    {
       public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("anti-click-fraud.png").getImage(),0 , 0 ,30,30 , null);
        }
    };
	JLabel uicon=new JLabel()
	{
		 public void paintComponent(Graphics g)
        {
        super.paintComponent(g); 	
        g.drawImage(new ImageIcon("Boss-icon.png").getImage(),0 , 0 ,70,70 , null);
        }
	};
	JTextField tname=new JTextField();
	JLabel pwd=new JLabel("Password");
	JLabel error=new JLabel();
	JLabel picon=new JLabel()
	{
      public void paintComponent(Graphics g)
        {
        super.paintComponent(g); 	
        g.drawImage(new ImageIcon("key.png").getImage(),0 , 0 ,60,60 , null);
        }
	};
	JPasswordField txtpwd=new JPasswordField('*');
	JButton login=new JButton()
  {
       public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("login-button-hi.png").getImage(),0 , 0 ,80,80 , null);
        }
    };
	JButton fpwd=new JButton()
  {
    public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("forgot-password-button-png-hi.png").getImage(),0 , 0 ,270,50 , null);
        }
  };
	JButton cancel=new JButton()
  {
     public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("button_clear.png").getImage(),0 , 0 ,80,80 , null);
        }
  };
	JButton exit=new JButton()
  {
     public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("1024px-Crystal_Clear_action_exit.svg.png").getImage(),0 , 0 ,70,70 , null);
        }
  };
	JPanel pmaster=new JPanel()
	{
        public void paintComponent(Graphics g)
        {
        super.paintComponent(g); 	
        g.drawImage(new ImageIcon("men.png").getImage(),0 , 0 ,700,400 , null);
        }
	};
	JPanel pchild=new JPanel();
	LoginForm()
	{
    setTitle("Product Marketing Management System -- Login");
    setResizable(false);

	add(pmaster);
	pmaster.setBackground(Color.PINK);
	pmaster.setLayout(null);
  pmaster.setBounds(0 , 0 , 700 , 480);
	pchild.setBounds(40,20,620,410);
	pmaster.add(pchild);
	pchild.setBackground(new Color(240,230,140,150));
	pchild.setLayout(null);
	lbl.setBounds(230,0,150,60);
	pchild.add(lbl);
	pchild.add(lbl);
		lbl.setHorizontalAlignment(JLabel.CENTER);
	lbl.setVerticalAlignment(JLabel.CENTER);
	lbl.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,50));
	lbl.setForeground(Color.BLACK);
    uicon.setBounds(90,70,70,70);pchild.add(uicon);
    name.setBounds(170,100,120,35);pchild.add(name);
    name.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    tname.setBounds(300,100,170,35);pchild.add(tname);
   
   pwd.setBounds(170,160,120,35);pchild.add(pwd);
   picon.setBounds(90,150,60,60);pchild.add(picon);
   pwd.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
   txtpwd.setBounds(300,160,170,35);pchild.add(txtpwd);
   txtpwd.setFont(new Font( "Arial",Font.PLAIN ,30));

   login.setBounds(50,230,80,80);pchild.add(login);
   login.setContentAreaFilled(false);
  login.setBorderPainted(false); 
  
   fpwd.setBounds(140,350,270,50);pchild.add(fpwd);
   fpwd.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
   fpwd.setOpaque(false);
   fpwd.setContentAreaFilled(false);
   fpwd.setBorderPainted(false);

   setIconImage(new ImageIcon("icon.jpg").getImage());
   
   cancel.setBounds(230,230,80,80);pchild.add(cancel);
    cancel.setContentAreaFilled(false);
    cancel.setBorderPainted(false); 
     exit.setBounds(420,230,70,70);pchild.add(exit);
      exit.setContentAreaFilled(false);
      exit.setBorderPainted(false);

       pchild.add(pwdvisible);pwdvisible.setBounds(475, 162 , 30 , 30);
       pwdvisible.setContentAreaFilled(false);
       pwdvisible.setBorderPainted(false); 
   
  
  setBounds(250 , 100 , 700 , 480);
  setVisible(true);


  login.addActionListener(this);
  fpwd.addActionListener(this);
  cancel.addActionListener(this);
  exit.addActionListener(this);
  pwdvisible.addActionListener(this);
  

}
  public void actionPerformed(ActionEvent evt)
  {
    boolean temp=false;
   
    if(evt.getSource()==exit)
    {
      int opt= JOptionPane.showConfirmDialog(this,"Do You Want To Exit..."); 
     if(opt==JOptionPane.YES_OPTION)
     {  
        System.exit(0);
      }
    }
    if(evt.getSource()==pwdvisible)
    {
      repaint();
      if(show == true)
      {
      txtpwd.setEchoChar((char)0);
      show = false;
      }
      else if(show == false)
      {
       txtpwd.setEchoChar('*'); 
       show = true;
      }
    }
    if(evt.getSource()==login)
    { 
      repaint();

       String a , b , c;
      a = tname.getText();
      c = txtpwd.getText();
      b = "";
      if(a.equals(admin) && c.equals(password))
      {
        dispose();
        Menu mnu = new Menu();
        admin_login = a;
        pwd_login = c;
      }
      else
      {
      try
   {
           pst =con.prepareStatement("select * from sign_in where user_id=?");
             pst.setString(1,a);
             rst=pst.executeQuery();
             if(rst.next())
             {
              a = rst.getString("user_id");
              b = rst.getString("pwd");
              if(b.equals(c))
             {      
                    dispose();
                    Menu mnu = new Menu();
                    admin_login = a;
                    pwd_login = c;
                  
             }
             else
             {
                  JOptionPane.showMessageDialog(this,"invalid user id or password!!..","Error Message",JOptionPane.ERROR_MESSAGE);
             }
    

             } 
              else
             {
     
                    JOptionPane.showMessageDialog(this,"invalid user id or password!!..","Error Mesaage",JOptionPane.ERROR_MESSAGE);

             }
             
     
        }

     catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this,"invalid user id or password!!..","Error Mesaage",JOptionPane.ERROR_MESSAGE);
            }
  }
            
      }
      if(evt.getSource()==fpwd)
{
  repaint();
       String a , b, c;
         a = tname.getText();
         b = "";
         c =JOptionPane.showInputDialog(this,"What is your favourite book?..");
         try
         {
             pst =con.prepareStatement("select * from sign_in where user_id=?");
               pst.setString(1,a);
               rst=pst.executeQuery();
               if(rst.next())
               {
                a = rst.getString("user_id");
                b = rst.getString("security_question");
                if(b.equals(c))
                {
                    String pwdc =JOptionPane.showInputDialog(this,"Enter new password.."); 
                      if(!ValidationPassword.checkPassword(pwdc))
                      {
                        JOptionPane.showMessageDialog(this,"Enter 10 Characters");
                        temp=true; 
                       } 
                       else
                       {
                           String cpwdc = JOptionPane.showInputDialog(this,"Enter new password to confirm..");
                           if(pwdc.equals(cpwdc))
                           {
                               pst=con.prepareStatement("update sign_in set pwd=? where user_id=?");
                               pst.setString(1,pwdc);

                
                                pst.setString(2,a);
                                if(pst.executeUpdate()>0)
                                {
                                 JOptionPane.showMessageDialog(this,"Password Changed...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
                                }
                                else
                                 {
                                    JOptionPane.showMessageDialog(this,"Password Not Changed...","Error Message",JOptionPane.ERROR_MESSAGE); 
                                 }
      
                           }
                           else
                           {
                                  JOptionPane.showMessageDialog(this,"Passwords don't match!!..Try Again!!..");
                           }

                       }
                        
                }
                else
                        {
                           JOptionPane.showMessageDialog(this,"Try Again");
                        }
                 
               }
               else
                            {
                           JOptionPane.showMessageDialog(this,"Invalid User!!..");
                            }
         }
         catch(Exception et){JOptionPane.showMessageDialog(this,"Password Not Changed...","Error Message",JOptionPane.ERROR_MESSAGE);}
}

   if(evt.getSource()==cancel){
    repaint();
    cancel();}
   
     
 }
 public void cancel()
 {
  repaint();
  tname.setText("");
  txtpwd.setText("");
 }

  public static void main(String...args)
  {
  new LoginForm();
  }
   }
   
