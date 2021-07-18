import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.sql.*;
public class zonemaster extends JFrame implements ActionListener
{
	Connection con;
	 PreparedStatement pst;
	 ResultSet rst;
	 int opt;
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
  
	JLabel lbl=new JLabel("<html><u>Zone Entry</u></html>");
	JLabel zone=new JLabel("Zone Id");
	JTextField tzone=new JTextField();
	JLabel loc=new JLabel("Location");
	JTextArea tloc=new JTextArea();
  JScrollPane jsp=new JScrollPane(tloc);
	JButton insert=new JButton("Insert")
  {
    public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("insert.png").getImage(),0 , 0 ,40,40 , null);
        } 
  };
   JLabel sicon=new JLabel()
  {
     public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("icon.jpg").getImage(),0 , 0 ,50,50 , null);
        
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
	JButton search=new JButton("Search")
  {
     public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("search.png").getImage(),5 , 10 ,20,20 , null);
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
	JButton exit=new JButton()
  {
    public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("back1 (2).png").getImage(),0 , 0 ,60,60 , null);
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
         g.drawImage(new ImageIcon("Travel.jpg").getImage(),0,0,800,500,null);
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

	zonemaster()
	{
    setTitle("Product Marketing Management System -- Zone");
    if(LoginForm.admin_login.equals("admin") && LoginForm.pwd_login.equals("sudha123"))
    {
      insert.setVisible(true);
      update.setVisible(true);
      reset.setVisible(true);
      search.setVisible(true);
      exit.setVisible(true);
     

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
      tzone.setText("Z"+"00"+String.valueOf(id));
      }
      else if(id>=10 && id<100)
      {
         tzone.setText("Z"+"0"+String.valueOf(id));
      }
      else if(id>=100 && id<1000)
      {
         tzone.setText("Z"+String.valueOf(id));
      }
       else
      {
        tzone.setText("Out of Bounds");
      }

    }
    catch(Exception ee){System.out.println(ee);}
  }
  else
    {
      
      insert.setVisible(false);
      update.setVisible(true);
      reset.setVisible(true);
      search.setVisible(true);
      exit.setVisible(true);
      
    }
    
   
		setResizable(false);
	add(pmaster);
	pmaster.setBackground(Color.WHITE);
	pmaster.setLayout(null);
	pchild.setBounds(20,20,750,430);
	pmaster.add(pchild);
	pchild.setBackground(new Color(112,112,112,110));
	pchild.setLayout(null);
	lbl.setBounds(250,0,300,60);
	pchild.add(lbl);
	pchild.add(lbl);
		lbl.setHorizontalAlignment(JLabel.CENTER);
	lbl.setVerticalAlignment(JLabel.CENTER);
	lbl.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,50));

  pchild.add(sicon);sicon.setBounds(220 , 10 , 50 , 50);
  setIconImage(new ImageIcon("icon.jpg").getImage());
    

	//lbl.setBackground(Color.BLACK);lbl.setOpaque(true);
	lbl.setForeground(Color.WHITE);
    
    zone.setBounds(50,100,200,50);pchild.add(zone);
    zone.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,40));zone.setForeground(Color.WHITE);
    tzone.setBounds(270,100,250,50);pchild.add(tzone);tzone.setEditable(false);
    tzone.setFont(new Font( "Arial",Font.PLAIN ,22));
   loc.setBounds(50,170,200,50);pchild.add(loc);
   loc.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,40));loc.setForeground(Color.WHITE);
   jsp.setBounds(270,170,250,100);pchild.add(jsp);
   tloc.setFont(new Font( "Arial",Font.PLAIN ,22));

   insert.setBounds(550,120,150,40);pchild.add(insert);
   insert.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));

   update.setBounds(550,180,150,40);pchild.add(update);
   update.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
   reset.setBounds(550,240,150,40);pchild.add(reset);
   reset.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
     search.setBounds(550,300,150,40);pchild.add(search);
     search.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,30));
    pchild.add(exit);exit.setBounds(10, 10 , 60 , 60);
   exit.setContentAreaFilled(false);
      exit.setBorderPainted(false);   


    backup.setBounds(650,10,60,60);pchild.add(backup);
   backup.setContentAreaFilled(false);
      backup.setBorderPainted(false);   

    
  setBounds(80,80,800,500);
  setVisible(true);
   insert.addActionListener(this);
   update.addActionListener(this);
   reset.addActionListener(this);
   search.addActionListener(this);
   exit.addActionListener(this);
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
		try
		{
		pst=con.prepareStatement("insert into zone_master values(?,?)");
			pst.setString(1,tzone.getText());
			pst.setString(2,tloc.getText());
			 if(pst.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(this,"Data Saved...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Data Not Saved...","Error Message",JOptionPane.ERROR_MESSAGE);   
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
			 pst=con.prepareStatement("update zone_master set location=? where zone_id=?");
			 pst.setString(1,tloc.getText());
			 pst.setString(2,tzone.getText());

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
     if(evt.getSource()==reset){
      repaint();
      reset();}
    if(evt.getSource()==search)
 { 
  repaint();
  String id=JOptionPane.showInputDialog(this,"Enter Zone Id");
  reset();
  try
  {
     
    pst =con.prepareStatement("select * from zone_master where zone_id=?");
    pst.setString(1,id);
     rst=pst.executeQuery();
     if(rst.next())
     {
     	 tzone.setText(rst.getString("zone_id"));
         tloc.setText(rst.getString("location"));
		 tzone.setEditable(false);
		 tloc.setEditable(false);

	 }
     else
     {
     
      JOptionPane.showMessageDialog(this,"Data Not Found","Error Message",JOptionPane.ERROR_MESSAGE);

     }
  }
     catch(Exception ef){JOptionPane.showMessageDialog(this,"Data Not Found...","Error Message",JOptionPane.ERROR_MESSAGE);}

}

if(evt.getSource() == backup)
{
  repaint();
  String d = new SimpleDateFormat("dd-MMM-yyyy").format(new java.util.Date());
  String fnm = "SudhaZone"+d;
  String s = "exp sudha/sudha123 file = D:\\BackupZone\\"+fnm+".dmp";
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
      tzone.setText("Z"+"00"+String.valueOf(id));
      }
      else if(id>=10 && id<100)
      {
         tzone.setText("Z"+"0"+String.valueOf(id));
      }
      else if(id>=100 && id<1000)
      {
         tzone.setText("Z"+String.valueOf(id));
      }
       else
      {
        tzone.setText("Out of Bounds");
      }

    }
    catch(Exception ee){System.out.println(ee);}
	  tloc.setText("");
	  tzone.setEditable(true);
	  tloc.setEditable(true);
}

	public static void main(String...args)
	{
	new zonemaster();
	}
} 