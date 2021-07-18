import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.*;
import java.text.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
public class Report extends JFrame implements ActionListener
{   

	Connection con;
    PreparedStatement pst , pst1;
    ResultSet rst , rst1;
    File  f;
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
    String opt;
    int opt1;
	int w , h ;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension dimension = toolkit.getScreenSize();
	{
		w = (int)dimension.getWidth();
		h = (int)dimension.getHeight();
	}

	JPanel panel = new JPanel()
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(new ImageIcon("Background-Wallpaper-Images-Pics.jpg").getImage(), 0 , 0 , w , h , null);
			g.drawRect(650 , 150 , 630 , 540);
            g.setColor(Color.BLACK);

		}
	};
	 JLabel lbl1 = new JLabel("PATNA DAIRY PROJECT");
     JLabel lbl2 = new JLabel("Vaishal Patliputra Dugdh Utpadak Sahkari Sangh Ltd.");
     JLabel lbl3 = new JLabel("FEEDER BALANCING DAIRY COMPLEX");
     JLabel lbl4 = new JLabel("P.O. PHULWARISHARIF , PATNA - 801505");
     JButton report = new JButton()
     {
     	public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("report3.png").getImage(),0 , 0 ,120,120 , null);
        }
     };
     JLabel report1 = new JLabel("Report");
     JLabel lbl5 = new JLabel("Report Type");
     
     JComboBox cmb1 = new JComboBox();
    
     
     JButton scopy = new JButton("Store Copy");
     JButton acopy = new JButton("Accounts Copy");
     JButton mcopy = new JButton("Marketing Copy");
     JLabel total = new JLabel("Total");
     JLabel ltotal = new JLabel();
     JLabel total1 = new JLabel("Total");
     JLabel ltotal1 = new JLabel();
     JLabel total2 = new JLabel("Total");
     JLabel ltotal2 = new JLabel();
     JLabel total3 = new JLabel("Total");
     JLabel ltotal3 = new JLabel();
     JButton exit = new JButton()
     {
     	public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("back1.png").getImage(),0 , 0 ,80,80 , null);
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

	JPanel inv = new JPanel();
	JPanel inv1 = new JPanel();
	JPanel inv2 = new JPanel();
	JPanel inv3 = new JPanel();
	JLabel lbl7 = new JLabel();
	JLabel lbl8 = new JLabel();
	JLabel lbl71 = new JLabel();
	JLabel lbl81 = new JLabel();
	JLabel lbl72 = new JLabel();
	JLabel lbl82 = new JLabel();
	JLabel lbl73 = new JLabel();
	JLabel lbl83 = new JLabel();
	JLabel hlbl = new JLabel("Patna Dairy Project");
	JLabel copy_lbl = new JLabel();
	JLabel hlbl1 = new JLabel("Patna Dairy Project");
	JLabel copy_lbl1 = new JLabel();
	JLabel hlbl2 = new JLabel("Patna Dairy Project");
	JLabel copy_lbl2 = new JLabel();
	JLabel hlbl3 = new JLabel("Patna Dairy Project");
	JLabel copy_lbl3 = new JLabel();
	JLabel pcopy = new JLabel();
	JLabel pcopy1 = new JLabel();
	JLabel pcopy2= new JLabel();
	JLabel pcopy3 = new JLabel();
	JDateChooser calendar=new JDateChooser(new java.util.Date());
	JDateChooser calendar1=new JDateChooser(new java.util.Date());
	String data[][];
	String heading[]={"S.No.","Distributor Id","Name","Invoice No.","Dated","Amount(Rs)"};
	String rows[][]=new String[0][0];
	DefaultTableModel dtm=new DefaultTableModel(rows,heading);
	JTable tab=new JTable(dtm);
	JScrollPane jsp=new JScrollPane(tab);

   String data1[][];
	String heading1[]={"S.No.","Product Id","Name","Quantity","Amount(Rs)"};
	String rows1[][]=new String[0][0];
	DefaultTableModel dtm1=new DefaultTableModel(rows1,heading1);
	JTable tab1=new JTable(dtm1);
	JScrollPane jsp1=new JScrollPane(tab1);

    String data3[][];
	String heading3[]={"S.No.","Product Id","Name","Quantity","Amount(Rs)"};
	String rows3[][]=new String[0][0];
	DefaultTableModel dtm3=new DefaultTableModel(rows3,heading3);
	JTable tab3=new JTable(dtm3);
	JScrollPane jsp3=new JScrollPane(tab3);

	String data2[][];
	String heading2[]={"S.No.","Distributor Id","Name","Invoice No.","Amount(Rs)"};
	String rows2[][]=new String[0][0];
	DefaultTableModel dtm2=new DefaultTableModel(rows2,heading2);
	JTable tab2=new JTable(dtm2);
	JScrollPane jsp2=new JScrollPane(tab2);

    JComboBox cmb3 = new JComboBox();
    JComboBox cmb31 = new JComboBox();

	public Report()
	{  

		add(panel);panel.setLayout(null);
        setBounds(0,0,w,h);
		setVisible(true);
		setTitle("Product Marketing Management System -- Report");
		setIconImage(new ImageIcon("icon.jpg").getImage());

		panel.add(lbl1);lbl1.setBounds(300 , 0 , 800 , 40);
		lbl1.setHorizontalAlignment(JLabel.CENTER);
		lbl1.setVerticalAlignment(JLabel.CENTER);
		lbl1.setFont(new Font("Times New Roman",Font.BOLD,40));
		lbl1.setForeground(Color.BLACK);
		panel.add(sicon);sicon.setBounds(380 , 10 , 70 , 70);
		setIconImage(new ImageIcon("icon.jpg").getImage());
		
		panel.add(lbl2);lbl2.setBounds(200 , 40 , 1000 , 15);
		lbl2.setHorizontalAlignment(JLabel.CENTER);
		lbl2.setVerticalAlignment(JLabel.CENTER);
		lbl2.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,15));
		lbl2.setForeground(Color.BLACK);

		panel.add(lbl3);lbl3.setBounds(200 , 55 , 1000 , 15);
		lbl3.setHorizontalAlignment(JLabel.CENTER);
		lbl3.setVerticalAlignment(JLabel.CENTER);
		lbl3.setFont(new Font("Times New Roman",Font.BOLD,15));
		lbl3.setForeground(Color.BLACK);

		panel.add(lbl4);lbl4.setBounds(300 , 70 , 800 , 15);
		lbl4.setHorizontalAlignment(JLabel.CENTER);
		lbl4.setVerticalAlignment(JLabel.CENTER);
		lbl4.setFont(new Font("Times New Roman",Font.BOLD,15));
		lbl4.setForeground(Color.BLACK);

		panel.add(report1);report1.setBounds(500 , 90 , 250 , 45);
		report1.setHorizontalAlignment(JLabel.CENTER);
		report1.setVerticalAlignment(JLabel.CENTER);
		report1.setFont(new Font("Times New Roman",Font.BOLD,40));
		report1.setForeground(Color.BLACK);
		panel.add(report);report.setBounds(460,60,120,120);		
		report.setOpaque(false);
        report.setContentAreaFilled(false);
        report.setBorderPainted(false);
        
        
        panel.add(lbl5);lbl5.setBounds(70 , 250 , 220 , 35);		
		lbl5.setForeground(Color.BLACK);
		lbl5.setFont(new Font("Times New Roman",Font.BOLD,30));
        
        
		cmb1.setBounds(265,250,300,35); panel.add(cmb1);
		cmb1.setFont(new Font( "Arial",Font.PLAIN ,22));
        cmb1.addItem("Invoice Wise Daily");cmb1.addItem("Product Wise Daily");
        
       
        cmb1.addItem("Product Wise Monthly");cmb1.addItem("Distributor Wise Monthly");

        panel.add(scopy);scopy.setBounds(100 , 500 , 250 , 35);
		scopy.setForeground(Color.BLACK);
		scopy.setFont(new Font("Times New Roman",Font.BOLD,30));
		scopy.setEnabled(false);

		panel.add(acopy);acopy.setBounds(100 , 545 , 250 , 35);
		acopy.setForeground(Color.BLACK);
		acopy.setFont(new Font("Times New Roman",Font.BOLD,30));
		acopy.setEnabled(false);

        panel.add(mcopy);mcopy.setBounds(100 , 590 , 250 , 35);
		mcopy.setForeground(Color.BLACK);
		mcopy.setFont(new Font("Times New Roman",Font.BOLD,30));
		mcopy.setEnabled(false);
		panel.add(exit);exit.setBounds(10, 10 , 80 , 80);
         exit.setContentAreaFilled(false);
         exit.setBorderPainted(false); 



        cmb1.addActionListener(this);
        
        report.addActionListener(this);
        scopy.addActionListener(this);
        acopy.addActionListener(this);
        mcopy.addActionListener(this);
       
        exit.addActionListener(this);
        
        //panel.add(sicon);
       // sicon.setBounds(150 , 400 , 70 , 70);
        //sicon.setOpaque(true);
		
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		
		
		if(evt.getSource()==cmb1)
		{
			String str1 = cmb1.getSelectedItem().toString();
			if(str1.equals("Invoice Wise Daily"))
			{   
				
				invoice_report();	
			}
			if(str1.equals("Product Wise Daily"))
			{ 
				
			    product_report();	
			}
			
			if(str1.equals("Product Wise Monthly"))
			{
               
               product_report_monthly();
			}
			if(str1.equals("Distributor Wise Monthly"))
			{
				
				distributor_report_monthly();
			}
		}
		
		if(evt.getSource()==report)
		{   
			int sno=1;
            float stotal = 0.0f;
			String str1 = cmb1.getSelectedItem().toString();
			
			if(str1.equals("Invoice Wise Daily"))
			{   
 
               dtm.setRowCount(0);
				try
				{   
				     SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
				     String st=sdf.format(calendar.getDate()); 
					 lbl8.setText("Report of Invoice Details of "+st);
					 pst=con.prepareStatement("Select transaction.dist_id ,dist_name, invoice_no , invoice_date , amount_chargeable from transaction,distributor_master where distributor_master.dist_id=transaction.dist_id and invoice_date =? order by(invoice_no)");
			         pst.setString(1,new SimpleDateFormat("dd-MMM-yyyy").format(calendar.getDate()));
			         rst=pst.executeQuery();
			         int i=0;
			

			     while(rst.next())
			    {
			    	
                    String s[]={sno+"",rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5)};
                     
	    			dtm.addRow(s);	
				    i++;
				    sno++;
				    
			    }
			    int row = tab.getRowCount();
			    System.out.println(row);
			    for(int iy = 0 ; iy<row ; iy++)
        	   {
        	      float stot =Float.parseFloat(tab.getValueAt(iy,5).toString());
        	       //System.out.println(s);
        	       stotal = stotal + stot;
        	       System.out.println(iy);
        	    
        	    }
		    
		    ltotal.setText(String.valueOf(stotal));
		    JOptionPane.showMessageDialog(this,"Report Generated...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
		    scopy.setEnabled(true);
		    acopy.setEnabled(true);
		    mcopy.setEnabled(true);
			  
				}
				catch(Exception e){JOptionPane.showMessageDialog(this,"Report Not Generated...","Error Message",JOptionPane.ERROR_MESSAGE);}
			}
			else if(str1.equals("Product Wise Daily"))
			{   

                dtm1.setRowCount(0);
				try
				{    
					 SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
				     String st1=sdf.format(calendar1.getDate()); 
					 lbl81.setText("Report of Product Supply on "+st1);
					 pst=con.prepareStatement("Select prod_id , prod_name , quantity , amount , transaction.invoice_no from transaction , invoice where invoice.invoice_no = transaction.invoice_no and invoice_date = ? order by(invoice_no)");
			         pst.setString(1,new SimpleDateFormat("dd-MMM-yyyy").format(calendar1.getDate()));
			         rst=pst.executeQuery();
			         int i=0;
			

			     while(rst.next())
			    {
			    	
                    String s[]={sno+"",rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)};
                    String y = rst.getString(5);
	    			dtm1.addRow(s);	
				    i++;
				    sno++;
			    }
			    int row = tab.getRowCount();
			    System.out.println(row);
			    for(int iy = 0 ; iy<row ; iy++)
        	   {
        	      float stot =Float.parseFloat(tab1.getValueAt(iy,4).toString());
        	       //System.out.println(s);
        	       stotal = stotal + stot;
        	       System.out.println(iy);
        	    
        	    }
		    
		    ltotal1.setText(String.valueOf(stotal));
		    JOptionPane.showMessageDialog(this,"Report Generated...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
		    scopy.setEnabled(true);
		    acopy.setEnabled(true);
		    mcopy.setEnabled(true);
			  
				}
				catch(Exception e){JOptionPane.showMessageDialog(this,"Report Not Generated...","Error Message",JOptionPane.ERROR_MESSAGE);}
			}
			else if(str1.equals("Product Wise Monthly"))
			{   

                dtm3.setRowCount(0);
                //System.out.println("Hello");
				try
				{    
					String mon = cmb3.getSelectedItem().toString();
					System.out.println(mon.toLowerCase().substring(0,3));
					lbl82.setText("Report of Product Supply in "+mon);
					 pst=con.prepareStatement(" select invoice_date,invoice.invoice_no,prod_id,prod_name,Quantity,amount from transaction,invoice where transaction.invoice_no=invoice.invoice_no and to_char(invoice_date,'mon')=? order by(invoice_no)");
			         pst.setString(1,mon.toLowerCase().substring(0,3));
			         rst=pst.executeQuery();
			         int i=0;
			         
			     while(rst.next())
			    {
			    	//System.out.println("row");
                    String s[]={sno+"",rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)};
	    			dtm3.addRow(s);	
				    i++;
				    sno++;
			    }
			    int row = tab3.getRowCount();
			    //System.out.println(row);
			    for(int iy = 0 ; iy<row ; iy++)
        	   {
        	      float stot =Float.parseFloat(tab3.getValueAt(iy,4).toString());
        	       //System.out.println(s);
        	       stotal = stotal + stot;
        	       //System.out.println(iy);
        	    
        	    }
		    
		    ltotal2.setText(String.valueOf(stotal));
		    JOptionPane.showMessageDialog(this,"Report Generated...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
		    scopy.setEnabled(true);
		    acopy.setEnabled(true);
		    mcopy.setEnabled(true);
			  
				}
				catch(Exception e){JOptionPane.showMessageDialog(this,"Report Not Generated...","Error Message",JOptionPane.ERROR_MESSAGE);}
			}
			if(str1.equals("Distributor Wise Monthly"))
			{   

                dtm2.setRowCount(0);
				try
				{     
					String mon1 = cmb31.getSelectedItem().toString();
					lbl83.setText("Report of Distributor Details in "+mon1);
					 pst=con.prepareStatement("Select transaction.dist_id ,dist_name, invoice_no , amount_chargeable from transaction,distributor_master where distributor_master.dist_id=transaction.dist_id and to_char(invoice_date , 'mon')=? order by(invoice_no)");
			         pst.setString(1,mon1.toLowerCase().substring(0,3));
			         rst=pst.executeQuery();
			         int i=0;
			

			     while(rst.next())
			    {
			    	
                    String s[]={sno+"",rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)};
	    			dtm2.addRow(s);	
				    i++;
				    sno++;
			    }
			    int row = tab2.getRowCount();
			    //System.out.println(row);
			    for(int iy = 0 ; iy<row ; iy++)
        	   {
        	      float stot =Float.parseFloat(tab2.getValueAt(iy,4).toString());
        	       //System.out.println(s);
        	       stotal = stotal + stot;
        	       //System.out.println(iy);
        	    
        	    }
		    
		    ltotal3.setText(String.valueOf(stotal));
		    JOptionPane.showMessageDialog(this,"Report Generated...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
		    scopy.setEnabled(true);
		    acopy.setEnabled(true);
		    mcopy.setEnabled(true);
			  
				}
				catch(Exception e){JOptionPane.showMessageDialog(this,"Report Not Generated...","Error Message",JOptionPane.ERROR_MESSAGE);}
			}
		}
		if(evt.getSource() == scopy)
		{
			String str1 = cmb1.getSelectedItem().toString();
			//String str2 = cmb2.getSelectedItem().toString();
			if(str1.equals("Invoice Wise Daily"))
               { 
                pcopy.setText("Store Copy"); 	
                  
               }     //PANEL NAME WHICH HAVE TO PRINT
               if(str1.equals("Product Wise Daily"))
               {
                  pcopy1.setText("Store Copy");
               	
               }
               if(str1.equals("Product Wise Monthly"))
               {
               	pcopy2.setText("Store Copy");
               	
               }
               if(str1.equals("Distributor Wise Monthly"))
               {
               	pcopy3.setText("Store Copy ");
               	
               }
               int opt= JOptionPane.showConfirmDialog(this,"Do You Want To Print Report..."); 
               if(opt==JOptionPane.YES_OPTION)
               {
			PrinterJob pj = PrinterJob.getPrinterJob();
               pj.setJobName(" Print Component ");

               pj.setPrintable (new Printable() 
               {    
               public int print(Graphics pg, PageFormat pf, int pageNum)
               {
                 if (pageNum > 0)
                 {
                  return Printable.NO_SUCH_PAGE;
                 }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                if(str1.equals("Invoice Wise Daily"))
               { 
                	
                inv.paint(g2);  
               }     //PANEL NAME WHICH HAVE TO PRINT
               if(str1.equals("Product Wise Daily"))
               {
                  
               	inv1.paint(g2);
               }
               if(str1.equals("Product Wise Monthly"))
               {
               	
               	inv2.paint(g2);
               }
               if(str1.equals("Distributor Wise Monthly"))
               {
               	
               	inv3.paint(g2);
               }

                return Printable.PAGE_EXISTS;
               }

       
        });
        if (pj.printDialog() == false)
        return;

         try
       {
           pj.print();
           scopy.setEnabled(false);
		   acopy.setEnabled(false);
		   mcopy.setEnabled(false);
		   JOptionPane.showMessageDialog(this,"Report Printed...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);

			  
       } 
       catch (PrinterException ex) {JOptionPane.showMessageDialog(this,"Report Not Printed...","Error Message",JOptionPane.ERROR_MESSAGE);}
   }
   else
	{
		JOptionPane.showMessageDialog(this,"Report Not Printed...","Error Message",JOptionPane.ERROR_MESSAGE); 
	}
    
    
		}
		if(evt.getSource() == acopy)
		{
			String str1 = cmb1.getSelectedItem().toString();
			//String str2 = cmb2.getSelectedItem().toString();
			if(str1.equals("Invoice Wise Daily"))
               { 
                pcopy.setText("Accounts Copy"); 	
                  
               }     //PANEL NAME WHICH HAVE TO PRINT
               if(str1.equals("Product Wise"))
               {
                  pcopy1.setText("Accounts Copy Daily");
               	
               }
               if(str1.equals("Product Wise Monthly"))
               {
               	pcopy2.setText("Accounts Copy");
               	
               }
               if(str1.equals("Distributor Wise Monthly"))
               {
               	pcopy3.setText("Accounts Copy ");
               	
               }
               int opt= JOptionPane.showConfirmDialog(this,"Do You Want To Print Report..."); 
               if(opt==JOptionPane.YES_OPTION)
               {
			PrinterJob pj = PrinterJob.getPrinterJob();
               pj.setJobName(" Print Component ");

               pj.setPrintable (new Printable() 
               {    
               public int print(Graphics pg, PageFormat pf, int pageNum)
               {
                 if (pageNum > 0)
                 {
                  return Printable.NO_SUCH_PAGE;
                 }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                if(str1.equals("Invoice Wise Daily"))
               { 
                	
                inv.paint(g2);  
               }     //PANEL NAME WHICH HAVE TO PRINT
               if(str1.equals("Product Wise Daily"))
               {
                  
               	inv1.paint(g2);
               }
               if(str1.equals("Product Wise Monthly"))
               {
               	;
               	inv2.paint(g2);
               }
               if(str1.equals("Distributor Wise Monthly"))
               {
               	
               	inv3.paint(g2);
               }

                return Printable.PAGE_EXISTS;
               }

       
        });
        if (pj.printDialog() == false)
        return;

         try
       {
           pj.print();
           scopy.setEnabled(false);
		   acopy.setEnabled(false);
		   mcopy.setEnabled(false);
           JOptionPane.showMessageDialog(this,"Report Printed...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
			  
       } 
       catch (PrinterException ex) {JOptionPane.showMessageDialog(this,"Report Not Printed...","Error Message",JOptionPane.ERROR_MESSAGE); }

    
		}
		else
	{
		JOptionPane.showMessageDialog(this,"Report Not Printed...","Error Message",JOptionPane.ERROR_MESSAGE); 
	}
    
	
	}
	
		if(evt.getSource() == mcopy)
		{
			String str1 = cmb1.getSelectedItem().toString();
			//String str2 = cmb2.getSelectedItem().toString();
			if(str1.equals("Invoice Wise Daily"))
               { 
                pcopy.setText("Marketing Copy"); 	
                  
               }     //PANEL NAME WHICH HAVE TO PRINT
               if(str1.equals("Product Wise Daily"))
               {
                  pcopy1.setText("Marketing Copy");
               	
               }
               if(str1.equals("Product Wise Monthly"))
               {
               	pcopy2.setText("Marketing Copy");
               	
               }
               if(str1.equals("Distributor Wise Monthly"))
               {
               	pcopy3.setText("Marketing Copy ");
               	
               }
               int opt= JOptionPane.showConfirmDialog(this,"Do You Want To Print Report..."); 
               if(opt==JOptionPane.YES_OPTION)
               {
			PrinterJob pj = PrinterJob.getPrinterJob();
               pj.setJobName(" Print Component ");

               pj.setPrintable (new Printable() 
               {    
               public int print(Graphics pg, PageFormat pf, int pageNum)
               {
                 if (pageNum > 0)
                 {
                  return Printable.NO_SUCH_PAGE;
                 }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                if(str1.equals("Invoice Wise Daily"))
               { 
                	
                inv.paint(g2);  
               }     //PANEL NAME WHICH HAVE TO PRINT
               if(str1.equals("Product Wise Daily"))
               {
                  
               	inv1.paint(g2);
               }
               if(str1.equals("Product Wise Monthly"))
               {
               	;
               	inv2.paint(g2);
               }
               if(str1.equals("Distributor Wise Monthly"))
               {
               	
               	inv3.paint(g2);
               }

                return Printable.PAGE_EXISTS;
               }

       
        });
        if (pj.printDialog() == false)
        return;

         try
       {
           pj.print();
           scopy.setEnabled(false);
		   acopy.setEnabled(false);
		   mcopy.setEnabled(false);
           JOptionPane.showMessageDialog(this,"Report Printed...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
			  
       } 
       catch (PrinterException ex) {JOptionPane.showMessageDialog(this,"Report Not Printed...","Error Message",JOptionPane.ERROR_MESSAGE); }
   }
       else
	{
		JOptionPane.showMessageDialog(this,"Report Not Printed...","Error Message",JOptionPane.ERROR_MESSAGE); 
	}
    
		}
    if(evt.getSource() == exit)
{
	int opt= JOptionPane.showConfirmDialog(this,"Do You Want To Exit..."); 
     if(opt==JOptionPane.YES_OPTION)
     {  
        dispose();
      }
}		
	}
	void invoice_report()
	{
		inv.setVisible(true);
		inv1.setVisible(false);
		inv2.setVisible(false);
		inv3.setVisible(false);
			    
         panel.add(inv);inv.setLayout(null);inv.setVisible(true);
         inv.setBounds(660 , 160 , 610 , 520);
         inv.setBackground(new Color(255 , 255 , 255));
         inv.add(hlbl);hlbl.setBounds(180 , 5 , 300 , 35);
         hlbl.setForeground(Color.BLACK);
		 hlbl.setFont(new Font("Times New Roman",Font.BOLD,32));
		 inv.add(lbl7);lbl7.setBounds(10 , 40 , 50 , 25);lbl7.setText("Date");
         lbl7.setForeground(Color.BLACK);
		 lbl7.setFont(new Font("Times New Roman",Font.BOLD,25));
		 inv.add(calendar);calendar.setBounds(65 , 40 , 200 , 25);
		 inv.add(pcopy);pcopy.setBounds(400 , 40 , 200 , 25);
         pcopy.setForeground(Color.BLACK);
		 pcopy.setFont(new Font("Times New Roman",Font.BOLD,25));       
		 inv.add(lbl8);lbl8.setBounds(90 , 70 , 500 , 27);
		 lbl8.setFont(new Font("Times New Roman",Font.BOLD,25));
		 lbl8.setHorizontalAlignment(JLabel.CENTER);
		 lbl8.setVerticalAlignment(JLabel.CENTER);   
         lbl8.setForeground(Color.BLACK);
         lbl8.setText("Report of Invoice Details of ");
         inv.add(jsp);jsp.setBounds(7 , 100 , 598 , 365);tab.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,15));
         JTableHeader eheader=tab.getTableHeader();tab.setBackground(Color.WHITE);
	  	eheader.setFont(new Font("Times Roman",Font.BOLD,15));
			tab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tab.setRowHeight(18);
			javax.swing.table.TableColumn tableColumn =tab.getColumnModel().getColumn(0);
				tableColumn.setPreferredWidth(40);
				tableColumn =tab.getColumnModel().getColumn(1);
				tableColumn.setPreferredWidth(100);
				tableColumn =tab.getColumnModel().getColumn(2);
				tableColumn.setPreferredWidth(160);
				tableColumn =tab.getColumnModel().getColumn(3);
				tableColumn.setPreferredWidth(90);
				tableColumn =tab.getColumnModel().getColumn(4);
				tableColumn.setPreferredWidth(100);
				tableColumn =tab.getColumnModel().getColumn(5);
				tableColumn.setPreferredWidth(105);
        inv.add(total);total.setBounds(360 , 470 , 90 , 30);
		total.setHorizontalAlignment(JLabel.CENTER);
		total.setVerticalAlignment(JLabel.CENTER);
		total.setFont(new Font("Times New Roman",Font.BOLD,25));
		total.setForeground(Color.BLACK);
		
	   inv.add(ltotal);ltotal.setBounds(460 , 470 , 140 , 35);ltotal.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	   ltotal.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));


							
	}
	void product_report()
	{
		inv.setVisible(false);
		inv1.setVisible(true);
		inv2.setVisible(false);
		inv3.setVisible(false);
			    
		panel.add(inv1);inv1.setLayout(null);inv1.setVisible(true);
         inv1.setBounds(660 , 160 , 610 , 520);
         inv1.setBackground(new Color(255 , 255 , 255));
         inv1.add(hlbl1);hlbl1.setBounds(180 , 5 , 300 , 35);
         hlbl1.setForeground(Color.BLACK);
		 hlbl1.setFont(new Font("Times New Roman",Font.BOLD,32));
		 inv1.add(lbl71);lbl71.setBounds(10 , 40 , 50 , 25);lbl71.setText("Date");
         lbl71.setForeground(Color.BLACK);
		 lbl71.setFont(new Font("Times New Roman",Font.BOLD,25));
		 inv1.add(calendar1);calendar1.setBounds(65 , 40 , 200 , 25);
		  inv1.add(pcopy1);pcopy1.setBounds(400 , 40 , 200 , 25);
         pcopy1.setForeground(Color.BLACK);
		 pcopy1.setFont(new Font("Times New Roman",Font.BOLD,25));         
		 inv1.add(lbl81);lbl81.setBounds(90 , 70 , 500 , 27);
		 lbl81.setFont(new Font("Times New Roman",Font.BOLD,25));
		 lbl81.setHorizontalAlignment(JLabel.CENTER);
		 lbl81.setVerticalAlignment(JLabel.CENTER);   
         lbl81.setForeground(Color.BLACK);
         lbl81.setText("Report of Product Supply on ");
         inv1.add(jsp1);jsp1.setBounds(7 , 100 , 598 , 365);tab1.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,15));
         JTableHeader eheader=tab1.getTableHeader();tab1.setBackground(Color.WHITE);
	  	eheader.setFont(new Font("Times Roman",Font.BOLD,15));
			tab1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tab1.setRowHeight(18);
			javax.swing.table.TableColumn tableColumn =tab.getColumnModel().getColumn(0);
				tableColumn.setPreferredWidth(35);
				tableColumn =tab1.getColumnModel().getColumn(1);
				tableColumn.setPreferredWidth(110);
				tableColumn =tab1.getColumnModel().getColumn(2);
				tableColumn.setPreferredWidth(210);
				tableColumn =tab1.getColumnModel().getColumn(3);
				tableColumn.setPreferredWidth(90);
				tableColumn =tab1.getColumnModel().getColumn(4);
				tableColumn.setPreferredWidth(110);
				
        inv1.add(total1);total1.setBounds(360 , 470 , 90 , 30);
		total1.setHorizontalAlignment(JLabel.CENTER);
		total1.setVerticalAlignment(JLabel.CENTER);
		total1.setFont(new Font("Times New Roman",Font.BOLD,25));
		total1.setForeground(Color.BLACK);
		
	   inv1.add(ltotal1);ltotal1.setBounds(460 , 470 , 140 , 35);ltotal1.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	   ltotal1.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));


	}
	void product_report_monthly()
	{
		inv.setVisible(false);
		inv1.setVisible(false);
		inv2.setVisible(true);
		inv3.setVisible(false);
			    
		panel.add(inv2);inv2.setLayout(null);inv2.setVisible(true);
         inv2.setBounds(660 , 160 , 610 , 520);
         inv2.setBackground(new Color(255 , 255 , 255));
         inv2.add(hlbl2);hlbl2.setBounds(180 , 5 , 300 , 35);
         hlbl2.setForeground(Color.BLACK);
		 hlbl2.setFont(new Font("Times New Roman",Font.BOLD,32));
         inv2.add(lbl72);lbl72.setBounds(10 , 40 , 80 , 25);lbl72.setText("Month");
         lbl72.setForeground(Color.BLACK);
		 lbl72.setFont(new Font("Times New Roman",Font.BOLD,25));
		 inv2.add(cmb3);cmb3.setBounds(95 , 40 , 200 , 25);
		 cmb3.addItem("January");
		 cmb3.addItem("February");
		 cmb3.addItem("March");
		 cmb3.addItem("April");
		 cmb3.addItem("May");
		 cmb3.addItem("June");
		 cmb3.addItem("July");
		 cmb3.addItem("August");
		 cmb3.addItem("September");
		 cmb3.addItem("October");
		 cmb3.addItem("November");
		 cmb3.addItem("December");
         inv2.add(pcopy2);pcopy2.setBounds(400 , 40 , 200 , 25);
         pcopy2.setForeground(Color.BLACK);
		 pcopy2.setFont(new Font("Times New Roman",Font.BOLD,25));   
		        
		 inv2.add(lbl82);lbl82.setBounds(90 , 70 , 500 , 27);
		 lbl82.setFont(new Font("Times New Roman",Font.BOLD,25));
		 lbl82.setHorizontalAlignment(JLabel.CENTER);
		 lbl82.setVerticalAlignment(JLabel.CENTER);   
         lbl82.setForeground(Color.BLACK);
         lbl82.setText("Report of Product Supply in ");
         inv2.add(jsp3);jsp3.setBounds(7 , 100 , 598 , 365);tab3.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,15));
         JTableHeader eheader=tab3.getTableHeader();tab3.setBackground(Color.WHITE);
	  	eheader.setFont(new Font("Times Roman",Font.BOLD,15));
			tab3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tab3.setRowHeight(18);
			javax.swing.table.TableColumn tableColumn =tab3.getColumnModel().getColumn(0);
				tableColumn.setPreferredWidth(40);
				tableColumn =tab3.getColumnModel().getColumn(1);
				tableColumn.setPreferredWidth(110);
				tableColumn =tab3.getColumnModel().getColumn(2);
				tableColumn.setPreferredWidth(210);
				tableColumn =tab3.getColumnModel().getColumn(3);
				tableColumn.setPreferredWidth(115);
				tableColumn =tab3.getColumnModel().getColumn(4);
				tableColumn.setPreferredWidth(120);
				
        inv2.add(total2);total2.setBounds(360 , 470 , 90 , 30);
		total2.setHorizontalAlignment(JLabel.CENTER);
		total2.setVerticalAlignment(JLabel.CENTER);
		total2.setFont(new Font("Times New Roman",Font.BOLD,25));
		total2.setForeground(Color.BLACK);
		
	   inv2.add(ltotal2);ltotal2.setBounds(460 , 470 , 140 , 35);ltotal2.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	   ltotal2.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));


	}
	void distributor_report_monthly()
	{
		inv.setVisible(false);
		inv1.setVisible(false);
		inv2.setVisible(false);
		inv3.setVisible(true);
			    
		panel.add(inv3);inv3.setLayout(null);inv3.setVisible(true);
         inv3.setBounds(660 , 160 , 610 , 520);
         inv3.setBackground(new Color(255 , 255 , 255));
         inv3.add(hlbl3);hlbl3.setBounds(180 , 5 , 300 , 35);
         hlbl3.setForeground(Color.BLACK);
		 hlbl3.setFont(new Font("Times New Roman",Font.BOLD,32));
         inv3.add(lbl73);lbl73.setBounds(10 , 40 , 80 , 25);lbl73.setText("Month");
         lbl73.setForeground(Color.BLACK);
		 lbl73.setFont(new Font("Times New Roman",Font.BOLD,25));
		 inv3.add(cmb31);cmb31.setBounds(95 , 40 , 200 , 25);
		 cmb31.addItem("January");
		 cmb31.addItem("February");
		 cmb31.addItem("March");
		 cmb31.addItem("April");
		 cmb31.addItem("May");
		 cmb31.addItem("June");
		 cmb31.addItem("July");
		 cmb31.addItem("August");
		 cmb31.addItem("September");
		 cmb31.addItem("October");
		 cmb31.addItem("November");
		 cmb31.addItem("December");
           inv3.add(pcopy3);pcopy3.setBounds(400 , 40 , 200 , 25);
         pcopy3.setForeground(Color.BLACK);
		 pcopy3.setFont(new Font("Times New Roman",Font.BOLD,25));   
		        
		 inv3.add(lbl83);lbl83.setBounds(90 , 70 , 500 , 27);
		 lbl83.setFont(new Font("Times New Roman",Font.BOLD,25));
		 lbl83.setHorizontalAlignment(JLabel.CENTER);
		 lbl83.setVerticalAlignment(JLabel.CENTER);   
         lbl83.setForeground(Color.BLACK);
         lbl83.setText("Report of Distributor Details in ");
         inv3.add(jsp2);jsp2.setBounds(7 , 100 , 598 , 365);tab2.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,15));
         JTableHeader eheader=tab2.getTableHeader();tab2.setBackground(Color.WHITE);
	  	eheader.setFont(new Font("Times Roman",Font.BOLD,15));
			tab2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tab2.setRowHeight(18);
			javax.swing.table.TableColumn tableColumn =tab2.getColumnModel().getColumn(0);
				tableColumn.setPreferredWidth(40);
				tableColumn =tab2.getColumnModel().getColumn(1);
				tableColumn.setPreferredWidth(110);
				tableColumn =tab2.getColumnModel().getColumn(2);
				tableColumn.setPreferredWidth(210);
				tableColumn =tab2.getColumnModel().getColumn(3);
				tableColumn.setPreferredWidth(115);
				tableColumn =tab2.getColumnModel().getColumn(4);
				tableColumn.setPreferredWidth(120);
				
        inv3.add(total3);total3.setBounds(360 , 470 , 90 , 30);
		total3.setHorizontalAlignment(JLabel.CENTER);
		total3.setVerticalAlignment(JLabel.CENTER);
		total3.setFont(new Font("Times New Roman",Font.BOLD,25));
		total3.setForeground(Color.BLACK);
		
	   inv3.add(ltotal3);ltotal3.setBounds(460 , 470 , 140 , 35);ltotal3.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	   ltotal3.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));


	}
	void reset()
	{
		remove(inv);
	}
	public static void main(String[]args)
	{
		new Report();
	}

}