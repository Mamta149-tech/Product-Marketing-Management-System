import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ValidationForm extends JFrame implements ActionListener
{
	JLabel lblUser=new JLabel("User Name");
	JLabel lblContact=new JLabel("Contact No");
	JLabel lblEmail=new JLabel("Email");
	
	JTextField txtUser=new JTextField();
	JTextField txtContact=new JTextField();
	JTextField txtEmail=new JTextField();
	
	JButton btnSubmit=new JButton("Submit");
	
	JLabel lblUserError=new JLabel();
	JLabel lblContactError=new JLabel();
	JLabel lblEmailError=new JLabel();
	
	ValidationForm()
	{
		setLayout(null);
		lblUser.setBounds(50,50,100,30);add(lblUser);
		lblContact.setBounds(50,110,100,30);add(lblContact);
		lblEmail.setBounds(50,170,100,30);add(lblEmail);
		
		txtUser.setBounds(200,50,100,30);add(txtUser);
		txtContact.setBounds(200,110,100,30);add(txtContact);
		txtEmail.setBounds(200,170,100,30);add(txtEmail);
		
		lblUserError.setBounds(50,80,300,30);add(lblUserError);
		lblContactError.setBounds(50,140,300,30);add(lblContactError);
		lblEmailError.setBounds(50,200,300,30);add(lblEmailError);
		
		lblUserError.setForeground(Color.red);
		lblContactError.setForeground(Color.red);
		lblEmailError.setForeground(Color.red);
		
		btnSubmit.setBounds(150,230,100,30);add(btnSubmit);
		setSize(600,500);
		setVisible(true);
		btnSubmit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnSubmit)
		{
			boolean t=true;
			if(!Validation.check(txtContact.getText()))
			{
				lblContactError.setText("Invalid Contact No...");
				t=false;
			}
			else
			{
				lblContactError.setText("");
			}
			if(!ValidationEmail.checkEmail(txtEmail.getText()))
			{
				lblEmailError.setText("Invalid Email Id...");
				t=false;
			}
			else
			{
				lblEmailError.setText("");
			}
			if(!t)
			{
				return;
			}
			JOptionPane.showMessageDialog(this,"User Created.....");
		}
	}
	public static void main(String[]args)
	{
		new ValidationForm();
	}
	
}