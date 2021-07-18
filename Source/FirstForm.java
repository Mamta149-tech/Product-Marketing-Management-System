import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.sql.*;
import javax.media.*;
import javax.sound.sampled.*;
import java.awt.event.*;

public class FirstForm extends JFrame implements Runnable
{   Connection con;
    PreparedStatement pst;
    JProgressBar progress=new JProgressBar();
    JLabel prg = new JLabel();

    public void run()
    {
    	for(int i=1;i<100;i++)
    	{
    		progress.setValue(i);
    		prg.setText("Loading... "+i+"%");
    		
    		try{Thread.sleep(70);}catch(Exception e){}
    	}
    	dispose();
    	new LoginForm();
    }
    {
	try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");//ClassNotFoundException
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sudha","sudha123");//SQLException		
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{}
}
Thread th;
    int opt;
	 Toolkit toolkit=Toolkit.getDefaultToolkit();
	Dimension dimension=toolkit.getScreenSize();
	ButtonGroup bg=new ButtonGroup();
	int w;
	int h;
	{
		w=(int)dimension.getWidth();
		h=(int)dimension.getHeight();
	} 
  
   JPanel panel=new JPanel()
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(new ImageIcon("IMG-20190731-WA0008.jpg").getImage(), 0 , 0 , 1000 , 400 , null);
		}
	};
	
	
	 public FirstForm()
	 {
	 	progress.setBackground(Color.white);
	 	progress.setForeground(Color.blue);
	 	progress.setStringPainted(true);
	 	th=new Thread(this);
	 	th.start();
	 add(panel);
	 panel.setLayout(null);
	 setIconImage(new ImageIcon("icon.jpg").getImage());
	 panel.add(prg);prg.setBounds(325,310,200,50);prg.setFont(new Font("Times New Roman", Font.BOLD,25));prg.setForeground(Color.BLACK);
	 progress.setBounds(300,280,250,30);
	 panel.add(progress);
	setTitle("Product Marketing Management System");
	setBounds(170 , 150 , 1000 , 400);
	setVisible(true);

	try
           {
           	AudioInputStream aud = AudioSystem.getAudioInputStream(new File("o95.wav"));
           	Clip clip = AudioSystem.getClip();
           	clip.open(aud);
           	//clip.play();
           	//clip.loop(Clip.LOOP_CONTINUOUSLY);
           	clip.start();
           }
           catch(Exception e){System.out.println(e);}

	 }
	 public static void main(String[]args)
   {
	   new FirstForm();
   }
}