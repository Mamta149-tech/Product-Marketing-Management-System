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
public class Transaction extends JFrame implements ListSelectionListener , ActionListener
{   
	public static boolean entry_status = false;
	public static boolean print_status = true;
	public static boolean data_save = false;
    
	Connection con;
    PreparedStatement pst;
    ResultSet rst;
    File  f;
	DefaultListModel dlm=new DefaultListModel();
	JList lst=new JList(dlm);
	JScrollPane jsp=new JScrollPane(lst);
	DefaultListModel dlm1=new DefaultListModel();
	JList lst1=new JList(dlm1);
	JScrollPane jsp1=new JScrollPane(lst1);
{
	try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sudha","sudha123");
			pst=con.prepareStatement("Select * from distributor_master");
    		rst=pst.executeQuery();
    		while(rst.next())
    		{
    			dlm.addElement(rst.getString("dist_id"));
    		}					
    		pst=con.prepareStatement("Select * from product_master");
    	    rst=pst.executeQuery();
    		while(rst.next())
    		{
    			dlm1.addElement(rst.getString("prod_name"));
    		}					
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

	JPanel pan = new JPanel()
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(new ImageIcon("F:\\GUI\\102165051-money-transaction.1910x1000.jpg").getImage(), 0 , 0 , w , h , null);
		}
	};
	int opt;
	JPanel p1 = new JPanel();
	JLabel lbl = new JLabel("<html><u>Invoice</u></html>");
	JLabel l1 = new JLabel("VAISHALI PATLIPUTRA DUGDH UTPADAK SAHAKARI SANGH LIMITED FEEDER BALANCING DAIRY COMPLEX, PHULWARISHARIF, PATNA PIN-801505.");
	JLabel l2 = new JLabel("Invoice No.");
	JLabel l3 = new JLabel("Dated");
	JLabel l4 = new JLabel("Buyer's Details:");
	JLabel l5 = new JLabel("Distributor's Id");
	JLabel l6 = new JLabel("Amount Received");
	JLabel l7 = new JLabel("Mode/Terms of Payment");
	JLabel l8 = new JLabel("Balance Amount");
	JLabel l9 = new JLabel("Amount Chargeable");
	JLabel l10 = new JLabel("Products Name");
	
	JTextField t1 = new JTextField();
	JTextArea t2 = new JTextArea();
	JScrollPane jspt = new JScrollPane(t2);
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	JTextField t5 = new JTextField();
	JTextField t6 = new JTextField();

	 JLabel sicon=new JLabel()
  {
     public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("icon.jpg").getImage(),0 , 0 ,60,60 , null);
        
        }
  };

	JButton print = new JButton("Print")
	{
	public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("print.png").getImage(),8 , 8 ,20,20 , null);
        } 	
	};
	JButton reset = new JButton("Reset")
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
	JButton total = new JButton("Total")
	{
		public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("total.png").getImage(),8 , 8 ,20,20 , null);
        } 
	};
	JButton search = new JButton("Search")
	{
		public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("search.png").getImage(),2 , 8 ,20,20 , null);
        } 
	};
    JButton delete=new JButton("Remove Entry")
    {
   public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("delete.png").getImage(),8 , 5 ,20,20 , null);
        } 
  };
    JButton print1 = new JButton()
    {
    	public void paintComponent(Graphics g)
        {
        super.paintComponent(g);  
        g.drawImage(new ImageIcon("print-image.png").getImage(),0 , 0 ,100,100 , null);
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

    JDateChooser calendar=new JDateChooser(new java.util.Date());
    

    JLabel lblE1=new JLabel();

    String data[][];
	String heading[]={"Product Id","Product Name","Rate(Rs)","Cgst(in %)","Sgst(in %)","per","Quantity(crt.)","Amount(Rs)"};
	String rows[][]=new String[0][0];
	DefaultTableModel dtm=new DefaultTableModel(rows,heading)
	{
		public boolean isCellEditable(int row,int column)
		{
			return column==6?true:false;
		}
	};
	JTable tab=new JTable(dtm);
	JScrollPane jsp2=new JScrollPane(tab);
	int inv_id = PrintInvoice.id;

	
	Transaction()
	{

		setUndecorated(true);
		prn();
		setTitle("Product Marketing Management System  -- Transaction");
		
		calendar.setEnabled(false);
		JTableHeader eheader=tab.getTableHeader();tab.setBackground(new Color(255 , 255 , 255 , 150));
	  	eheader.setFont(new Font("Times Roman",Font.BOLD,20));
			tab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tab.setRowHeight(30);
			javax.swing.table.TableColumn tableColumn =tab.getColumnModel().getColumn(0);
				tableColumn.setPreferredWidth(120);
				tableColumn =tab.getColumnModel().getColumn(1);
				tableColumn.setPreferredWidth(380);
				tableColumn =tab.getColumnModel().getColumn(2);
				tableColumn.setPreferredWidth(120);
				tableColumn =tab.getColumnModel().getColumn(3);
				tableColumn.setPreferredWidth(120);
				tableColumn =tab.getColumnModel().getColumn(4);
				tableColumn.setPreferredWidth(120);
				tableColumn =tab.getColumnModel().getColumn(5);
				tableColumn.setPreferredWidth(120);
				tableColumn =tab.getColumnModel().getColumn(6);
				tableColumn.setPreferredWidth(150);
				tableColumn =tab.getColumnModel().getColumn(7);
				tableColumn.setPreferredWidth(170);
                 
		add(pan);pan.setBounds(0, 0 , w , h);pan.setLayout(null);
		p1.add(sicon);sicon.setBounds(470 , 3 , 60 , 60);
		setIconImage(new ImageIcon("icon.jpg").getImage());
      
        pan.add(p1);p1.setBounds(10 , 10 , w-40 ,h-40);p1.setBackground(new Color(255 , 255 , 255 , 150));p1.setLayout(null);
		p1.add(lbl);lbl.setBounds(550 , 0 , 200 , 60);
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setVerticalAlignment(JLabel.CENTER);
		lbl.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,50));
		lbl.setForeground(new Color(255,255,255,150));
		lbl.setBackground(Color.BLACK);
		lbl.setOpaque(true);
		p1.add(l1);l1.setBounds(10 , 60 , w-20 , 20);l1.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,15));
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setVerticalAlignment(JLabel.CENTER);
		
        p1.add(l2);l2.setBounds(10 , 85 , 120 , 30);l2.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,22));
        l2.setForeground(Color.WHITE);
		l2.setBackground(Color.BLACK);l2.setOpaque(true);
		l2.setHorizontalAlignment(JLabel.CENTER);
		l2.setVerticalAlignment(JLabel.CENTER);	
        p1.add(l3);l3.setBounds(10 , 120 , 120 , 30);l3.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,22));
        l3.setForeground(Color.WHITE);
		l3.setBackground(Color.BLACK);l3.setOpaque(true);
		l3.setHorizontalAlignment(JLabel.CENTER);
		l3.setVerticalAlignment(JLabel.CENTER);
	    p1.add(l4);l4.setBounds(300 , 155 , 200 , 30);l4.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,28));
	    l4.setForeground(Color.WHITE);l4.setOpaque(true);
		l4.setBackground(Color.BLACK);
		l4.setHorizontalAlignment(JLabel.CENTER);
		l4.setVerticalAlignment(JLabel.CENTER);
		p1.add(l5);l5.setBounds(10 , 190 , 150 , 30);l5.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,22));
		p1.add(l6);l6.setBounds(350 , 190 , 240 , 30);l6.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,22));
		p1.add(l7);l7.setBounds(350 , 225 , 240 , 30);l7.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,22));
		p1.add(l8);l8.setBounds(350 , 260 , 240 , 30);l8.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,22));
		p1.add(l9);l9.setBounds(350 , 295 , 240 , 30);l9.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,22));
		p1.add(l10);l10.setBounds(870 , 85 , 200 , 30);l10.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,28));
        l10.setForeground(Color.WHITE);
		l10.setBackground(Color.BLACK);l10.setOpaque(true);
		l10.setHorizontalAlignment(JLabel.CENTER);
		l10.setVerticalAlignment(JLabel.CENTER);	
        p1.add(t1);t1.setBounds(160 , 85 , 150 , 30);t1.setEditable(false);
       
        p1.add(calendar);calendar.setForeground(Color.black);calendar.setBounds(160 , 120 , 150 , 30);
		
		p1.add(jsp);jsp.setBounds(160 , 190 , 150 , 30);lst.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,22));	
		p1.add(jspt);jspt.setBounds(10 , 225 , 300 , 100);t2.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));t2.setEditable(false);

	    p1.add(t3);t3.setBounds(600 , 190 , 200 , 30);lblE1.setBounds(800 , 190 , 20 , 25);p1.add(lblE1);lblE1.setForeground(Color.RED);lblE1.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,20));	
	    p1.add(t4);t4.setBounds(600 , 225 , 200 , 30);
	    p1.add(t5);t5.setBounds(600 , 260 , 200 , 30);t5.setEditable(false);t5.setText("0");
	    p1.add(t6);t6.setBounds(600 , 295 , 200 , 30);t6.setEditable(false);t6.setText("0");
        
        p1.add(jsp1);jsp1.setBounds(830 , 120 , 300 , 200);lst1.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,22));

        jsp2.setBounds(10,350,1303,300);
		p1.add(jsp2);tab.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,22));

	    p1.add(total);total.setBounds(1180 , 105 , 135 , 35);total.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));
        p1.add(print);print.setBounds(1180 , 150 , 135 , 35);print.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));
        p1.add(search);search.setBounds(1180 , 195 , 135 , 35);search.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));
        p1.add(reset);reset.setBounds(1180 , 240 , 135 , 35);reset.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,30));
        p1.add(exit);exit.setBounds(10, 10 , 60 , 60);
         exit.setContentAreaFilled(false);
         exit.setBorderPainted(false); 
        p1.add(delete);delete.setBounds(500 , 655 , 250 , 30);delete.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD,25));
        p1.add(print1);print1.setBounds(1200 , 630 , 100 , 100);
         print1.setContentAreaFilled(false);
         print1.setBorderPainted(false);
         print1.setVisible(false); 

         p1.add(backup);backup.setBounds(1230,0,60,60);
         backup.setContentAreaFilled(false);
         backup.setBorderPainted(false);   
  
  
		setBounds(0 , 0 , w , h);
		setVisible(true);
	
	  	lst.addListSelectionListener(this); 
	  	lst1.addListSelectionListener(this);
	    search.addActionListener(this);	
	  	print.addActionListener(this);
	  	reset.addActionListener(this);
	  	exit.addActionListener(this);
	  	total.addActionListener(this);
	  	delete.addActionListener(this);
	  	print1.addActionListener(this);
	  	backup.addActionListener(this);
	  	
	  	tab.addMouseListener(new MouseAdapter()
	  		{
	  			public void mousePressed(MouseEvent evt)
	  			{
		  			int row=tab.getSelectedRow();
		  			float rate=Float.parseFloat(tab.getValueAt(row,2).toString());
		  			float sgst=Float.parseFloat(tab.getValueAt(row,4).toString());
		  			float cgst=Float.parseFloat(tab.getValueAt(row,3).toString());
		  			int qnty=Integer.parseInt(tab.getValueAt(row,6).toString());
		  			tab.setValueAt(((qnty*rate*(sgst+cgst)/100)+(qnty*rate))+"",row,7);
	  			}
	  		});
    }
int t=0;
   
    public void valueChanged(ListSelectionEvent evt)
	{
        
		if(evt.getSource() == lst)
		{  
			try
			{ 
				repaint();
				pst=con.prepareStatement("Select * from distributor_master where dist_id=?");
				pst.setString(1,lst.getSelectedValue().toString());
	    		rst=pst.executeQuery();
	    		if(rst.next())
				{
					t2.setText(rst.getString("dist_id")+" "+rst.getString("dist_name")+" "+rst.getString("address"));
				}
			}
			catch(Exception e){}
		}
		
		if(evt.getSource() == lst1)
		{   
			
			repaint();
		
			if(t!=0){t=0;return;}
			t=1;
			try
			{   int row = tab.getRowCount();
        	float amt = 0.0f;
        	String amnt;

			    float a , b , c;
		        a = Float.parseFloat(t3.getText());
		        b = Float.parseFloat(t5.getText());
		        c = Float.parseFloat(t6.getText());
                
           if(a>c)
		   {  
		 	
		 	    
				pst=con.prepareStatement("Select * from product_master where prod_name=?");
				pst.setString(1,lst1.getSelectedValue().toString());
	    	    rst=pst.executeQuery();
	    		if(rst.next())
	    		{
	    			String s[]={rst.getString("prod_id"),rst.getString("prod_name"),rst.getString("basic_price"),rst.getString("cgst"),rst.getString("sgst"),"0","0","0"};
	    			dtm.addRow(s);	
	    		}

		    }
		     else
		 {
		      JOptionPane.showMessageDialog(this ,"Not Enough Balance..." , "Confirm Message" , JOptionPane.INFORMATION_MESSAGE);
	
		 }
		  for(int i = 0 ; i<row ; i++)
        	   {
        	      float s =Float.parseFloat(tab.getValueAt(i,7).toString());
        	       amt = amt + s; 
        	    
        	    }
        	    amnt = String.valueOf(amt); 	
        	    t6.setText(amnt);
        	    b = a - amt ;
        	    t5.setText(String.valueOf(b));
	    
		    }
			catch(Exception ef){JOptionPane.showMessageDialog(this,"Error Occured","Error Message",JOptionPane.ERROR_MESSAGE);}			
			
		 }
		
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
           
	   
	   if(evt.getSource() == print1)
		{     
			repaint();
              int opt= JOptionPane.showConfirmDialog(this,"Do You Want To Print Invoice..."); 
     if(opt==JOptionPane.YES_OPTION)
     {	
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
				String st=sdf.format(calendar.getDate());
              PrintInvoice pi = new PrintInvoice();	
                    pi.invoice_no1.setText(t1.getText());
      				pi.dated1.setText(st);
      				pi.buyer_det1.setText(t2.getText());
      				pi.amount_received1.setText(t3.getText());
      				pi.t_o_p1.setText(t4.getText());
      				pi.balance_amount1.setText(t5.getText());
      				pi.amount_chargeable1.setText(t6.getText());

      				opt=Integer.parseInt(t1.getText());
            try
            {
                 pst=con.prepareStatement("Select count(*) from invoice");
			     rst=pst.executeQuery();
			    int row1=0;
			    if(rst.next())
			    {
				  row1=rst.getInt(1);
			    }
			    data=new String[row1][8];
			
			
			
			     pst=con.prepareStatement("Select * from invoice where invoice_no = ?");
			     pst.setInt(1,opt);
			     rst=pst.executeQuery();
			     int i=0;
			

			     while(rst.next())
			    {
			    	
                    String s[]={rst.getString(2),rst.getString(9),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8)};
	    			pi.dtm.addRow(s);	
				    i++;
			    }
		    
			}
			catch(Exception e){JOptionPane.showMessageDialog(this,e.toString());}	   
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
                pi.panel.paint(g2);       
                return Printable.PAGE_EXISTS;
               }

       
        });
        if (pj.printDialog() == false)
        return;

         try
       {
           pj.print();
           JOptionPane.showMessageDialog(this,"Invoice Printed...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
			  
       } 
       catch (PrinterException ex) {JOptionPane.showMessageDialog(this,"Invoice Not Printed...","Error Message",JOptionPane.ERROR_MESSAGE);
			  }
  
    reset();
    pi.setVisible(false);
   
    prn();
}
  else
  {
  	JOptionPane.showMessageDialog(this,"Invoice Not Printed...","Error Message",JOptionPane.ERROR_MESSAGE);
  }
   
      }
        
        if(evt.getSource()==print)
        {   
        	repaint();
        	
        	int opt= JOptionPane.showConfirmDialog(this,"Do You Want To Grenerate Invoice..."); 
     if(opt==JOptionPane.YES_OPTION)
     {

     
            print_status = false;
        	entry_status = true;
        	
        	 boolean temp=false;
        	        if(!validationamountreceived.checkamountreceived(t3.getText()))
                       {
                              lblE1.setText("***");
                              temp=true; 
                       }
                        else
                         {
                             lblE1.setText("");
                          }
                           if(temp){
                               JOptionPane.showMessageDialog(this,"Recheck your details...","Error Message",JOptionPane.ERROR_MESSAGE);
                                 return;
                                 }
        	 int row = tab.getRowCount();
        	float amt = 0.0f;
        	String amnt;

        	for(int i = 0 ; i<row ; i++)
        	{
        	    float s =Float.parseFloat(tab.getValueAt(i,7).toString());
        	    
        	   amt = amt + s; 
        	    
        	}
        	amnt = String.valueOf(amt); 	
        	t6.setText(amnt);

			 float a , b , c;
		a = Float.parseFloat(t3.getText());
		b = Float.parseFloat(t5.getText());
		c = Float.parseFloat(t6.getText());
		b = a - c;
		 	t5.setText(String.valueOf(b));
        	if(a>c)
	      {
        	try
			{
			    pst = con.prepareStatement("insert into transaction values(?,?,?,?,?,?,?)");
			    pst.setInt(1 , Integer.parseInt(t1.getText()));
				SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
				String st=sdf.format(calendar.getDate());
				pst.setString(2,st);
				pst.setFloat(3 , Float.parseFloat(t3.getText()));
				pst.setFloat(4 , Float.parseFloat(t5.getText()));
				String str = lst.getSelectedValue().toString();
				pst.setFloat(5 , Float.parseFloat(str));
				pst.setString(6 , t4.getText());
				pst.setFloat(7 , Float.parseFloat(t6.getText()));
				if(pst.executeUpdate()>0)
				{
					JOptionPane.showMessageDialog(this,"Transaction done...","Confirm Message",JOptionPane.QUESTION_MESSAGE);
					exit.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Transaction not done...","Eror Message",JOptionPane.ERROR_MESSAGE);	
				}

				

				int row2 = tab.getRowCount();
				String prod_id="";
				String prod_nm="";
				float rate;
				float cgst;
				float sgst;
				String per="";
				int qty;
				float amts;
				int rec=0;
				for(int i = 0 ; i<row2 ; i++)
				{   
					prod_id = tab.getValueAt(i,0).toString();
					prod_nm = tab.getValueAt(i,1).toString();
					rate=Float.parseFloat(tab.getValueAt(i,2).toString());
					cgst=Float.parseFloat(tab.getValueAt(i,3).toString());
					sgst=Float.parseFloat(tab.getValueAt(i,4).toString());
                    per = tab.getValueAt(i,5).toString();
                    qty=Integer.parseInt(tab.getValueAt(i,6).toString());
                    amts=Float.parseFloat(tab.getValueAt(i,7).toString());

                    //System.out.println(prod_id+" "+prod_nm+" "+rate+" "+cgst+" "+sgst+" "+per+" "+qty+" "+amt);

                     pst = con.prepareStatement("insert into invoice values(?,?,?,?,?,?,?,?,?)");
                     pst.setInt(1 , Integer.parseInt(t1.getText()));
                     pst.setString(2 , prod_id);
                     pst.setFloat(3 , rate );
                     pst.setFloat(4, cgst);
                     pst.setFloat(5 , sgst);
                     pst.setString(6 , per);
                     pst.setInt(7 , qty);
                     pst.setFloat(8 , amt);
                     pst.setString(9 , prod_nm);
                      if(pst.executeUpdate()>0)
      				  {rec++;}
                   }
                   opt=Integer.parseInt(t1.getText());
          


				JOptionPane.showMessageDialog(this ," Invoice generated..." , "Confirm Message" , JOptionPane.INFORMATION_MESSAGE);
				SimpleDateFormat sdf1=new SimpleDateFormat("dd-MMM-yyyy");
				String st1=sdf1.format(calendar.getDate());
              PrintInvoice pi = new PrintInvoice();	
                    pi.invoice_no1.setText(t1.getText());
      				pi.dated1.setText(st);
      				pi.buyer_det1.setText(t2.getText());
      				pi.amount_received1.setText(t3.getText());
      				pi.t_o_p1.setText(t4.getText());
      				pi.balance_amount1.setText(t5.getText());
      				pi.amount_chargeable1.setText(t6.getText());

      				opt=Integer.parseInt(t1.getText());
            try
            {
                 pst=con.prepareStatement("Select count(*) from invoice");
			     rst=pst.executeQuery();
			    int row1=0;
			    if(rst.next())
			    {
				  row1=rst.getInt(1);
			    }
			    data=new String[row1][8];
			
			
			
			     pst=con.prepareStatement("Select * from invoice where invoice_no = ?");
			     pst.setInt(1,opt);
			     rst=pst.executeQuery();
			     int i=0;
			

			     while(rst.next())
			    {
			    	
                    String s[]={rst.getString(2),rst.getString(9),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8)};
	    			pi.dtm.addRow(s);	
				    i++;
			    }
		    
			}
			catch(Exception e){JOptionPane.showMessageDialog(this,e.toString());}	   
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
                pi.panel.paint(g2);       
                return Printable.PAGE_EXISTS;
               }

       
        });
        if (pj.printDialog() == false)
        return;

         try
       {
           pj.print();
           JOptionPane.showMessageDialog(this,"Invoice Printed...","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
			  
       } 
       catch (PrinterException ex) {JOptionPane.showMessageDialog(this,"Invoice Not Printed...","Error Message",JOptionPane.ERROR_MESSAGE);
			  }
    exit.setEnabled(true);    
    reset();
    pi.setVisible(false);
    print_status = true;
    data_save = true;
    prn();


			   
      }
      catch(Exception f)
      {
        JOptionPane.showMessageDialog(this ,"Invoice Not Printed...","Error Message",JOptionPane.ERROR_MESSAGE);
      }

    }
    else
    {
         JOptionPane.showMessageDialog(this ,"Not Enough Balance..." , "Confirm Message" , JOptionPane.INFORMATION_MESSAGE);	
    }
     
}
else
{
	JOptionPane.showMessageDialog(this,"Invoice Not Generated...","Error Message",JOptionPane.ERROR_MESSAGE); 
}
   }
   
        if(evt.getSource()==reset)
        {
        	repaint();
           reset();
        }
        if(evt.getSource()==total)
        {   
        	repaint();
        	int row = tab.getRowCount();
        	 float amt = 0.0f;
        	String amnt;

        	for(int i = 0 ; i<row ; i++)
        	{
        	    float s =Float.parseFloat(tab.getValueAt(i,7).toString());
        	    
        	   amt = amt + s; 
        	    
        	}
        	amnt = String.valueOf(amt); 	
        	t6.setText(amnt);

			
		float a = Float.parseFloat(t3.getText());
		float b = Float.parseFloat(t5.getText());
		float c = Float.parseFloat(t6.getText());
		b = a - c;
		 	t5.setText(String.valueOf(b));
		 	if(a<c)
		 	{
                JOptionPane.showMessageDialog(this ,"Not Enough Balance..." , "Confirm Message" , JOptionPane.INFORMATION_MESSAGE);
	
		 	}

        }
        if(evt.getSource()==search)
        {  
            repaint(); 
        	String id=JOptionPane.showInputDialog(this,"Enter Invoice number:");
			opt=Integer.parseInt(id);
		 
			try
			{  

				   reset();
				   t3.setEditable(false);
				   t4.setEditable(false);
        	       delete.setEnabled(false);
        	       total.setEnabled(false);
        	       lst.setEnabled(false);
        	       lst1.setEnabled(false);
        	       print.setEnabled(false);
        	       print1.setVisible(true);
        	       tab.setEnabled(false);
				pst	=con.prepareStatement("Select * from transaction where invoice_no=?");
				pst.setInt(1,opt);
				ResultSet rst=pst.executeQuery();
				if(rst.next())
				{
						t1.setText(rst.getString("invoice_no"));
						java.util.Date dt=rst.getDate("invoice_date");
					    calendar.setDate(dt);
					    String did = rst.getString("dist_id");
					    Object obj = did;
						lst.setSelectedValue(obj , true);
						t3.setText(rst.getString("amount_received"));
						t4.setText(rst.getString("terms_of_payment"));
						t5.setText(rst.getString("balance_amount"));
						t6.setText(rst.getString("amount_chargeable"));
						try
			{
				pst=con.prepareStatement("Select * from distributor_master where dist_id=did");
				pst.setString(1,lst.getSelectedValue().toString());
	    		rst=pst.executeQuery();
	    		if(rst.next())
				{
					t2.setText(rst.getString("dist_id")+" "+rst.getString("dist_name")+" "+rst.getString("address"));
				}
			}
			catch(Exception e){}
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Data Not Found");				
				}
				 pst=con.prepareStatement("Select count(*) from invoice");
			     rst=pst.executeQuery();
			    int row1=0;
			    if(rst.next())
			    {
				  row1=rst.getInt(1);
			    }
			    data=new String[row1][8];
			
			
			
			     pst=con.prepareStatement("Select * from invoice where invoice_no = ?");
			     pst.setInt(1,opt);
			     rst=pst.executeQuery();
			     int i=0;
			

			     while(rst.next())
			    {
			    	
                    String s[]={rst.getString(2),rst.getString(9),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8)};
	    			dtm.addRow(s);	
				    i++;
			    }
		    
			}
			catch(Exception e){JOptionPane.showMessageDialog(this,"Data Not Found","Error Message",JOptionPane.ERROR_MESSAGE);}

		}
		if(evt.getSource()==delete)
		{
			repaint();
			int selectedRow = tab.getSelectedRow();
			dtm.removeRow(selectedRow);
		}
		if(evt.getSource() == backup)
{
  String d = new SimpleDateFormat("dd-MMM-yyyy").format(new java.util.Date());
  String fnm = "SudhaInvoice"+d;
  String s = "exp sudha/sudha123 file = D:\\BackupTransaction\\"+fnm+".dmp";
  try
  {
    Process p = Runtime.getRuntime().exec(s);
    JOptionPane.showMessageDialog(this,"BackUp Done...","Confirm Message",JOptionPane.QUESTION_MESSAGE);
  }
  catch(Exception e){JOptionPane.showMessageDialog(this,"BackUp Not Done...","Error Message",JOptionPane.ERROR_MESSAGE); }
}      
		
        
	}
	 public void prn()
	{  if(print_status == true)
		{
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
         t1.setText(String.valueOf(id));
        }
        catch(Exception ee){System.out.println(ee);}
    }
	}
	void reset()
	{
		t=0;
		    repaint();
		
            t2.setText("");
            t3.setText("0");t3.setEditable(true);
            t4.setText("");t4.setEditable(true);
            t5.setText("0");
            t6.setText("0");
            calendar.setDate( new java.util.Date());
            dtm.setRowCount(0);
            tab.setEnabled(true);
            delete.setEnabled(true);
            total.setEnabled(true);
            print.setEnabled(true);
        	lst.setEnabled(true);
        	lst1.setEnabled(true);
        	 print1.setVisible(false);
        	prn();
	}
     
     public static void main(String[]args)
     {
     	new Transaction();
     }
}
