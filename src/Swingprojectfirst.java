import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.imageio.ImageIO;
import javax.management.Notification;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.json.JSONObject;

public class Swingprojectfirst extends JFrame implements ActionListener{
    
    JPanel mainpanel;
 	JLabel current ,namelable,imagelabel,location, heading,region;
 	JTextField textfield,textfield1;	
  WeatherService weatherservice=new WeatherService();
 	JButton button;
 	Swingprojectfirst() throws IOException
	{
		super.setTitle("WeatherApplicatoin");
		super.setSize(600,500);
		super.setLocation(50, 50);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		    mainpanel=new JPanel();
			mainpanel.setLayout(null);
			//mainpanel.add(textfield);


	  //  this.getMeushow();
		 heading=new JLabel("Welcome to the weather Api Develop by Sanjay");

 	     namelable=new JLabel("enter the city");
 	     location=new JLabel("current city:dehradun");
 	     region=new JLabel("region:");
 	    current=new JLabel("current:");
 		 button=new JButton("search");
 		textfield=new JTextField();
 		textfield1=new JTextField();

 		 //BufferedImage img = ImageIO. read(new File("C:/Users/Pankaj Negi/Desktop/sanjay.jpg"));
 		 //imagelabel = new JLabel(new ImageIcon(img)); 
 		 this.setheading();   
         this.setLocation();
         this.setRegion();
         this.setCurrent();
 		 
         this.namelable();
         this.textfield();
         //this.imagelabel();
         
 	     this.setbutton();
 		
 		 super.setVisible(true);

 		 this.add(mainpanel);
    	}
 			private void setCurrent() {
		// TODO Auto-generated method stub
               current.setFont(new Font("Verdana", Font.ITALIC, 17));
 		 		
               current.setBounds(250, 300, 500, 70);
 				mainpanel.add(current);
 	 	
	}
			private void setRegion() {
		// TODO Auto-generated method stub
 				region.setFont(new Font("Verdana", Font.ITALIC, 17));
 		 		
 				region.setBounds(20, 350, 500, 70);
 				mainpanel.add(region);
 	 	
	}
			private void setLocation() {
 				location.setFont(new Font("Verdana", Font.ITALIC, 17));
 		
 				location.setBounds(20, 300, 500, 70);
 				mainpanel.add(location);
 	 		
	}
			private void textfield() {

			 textfield.setFont(new Font("Verdana", Font.ITALIC, 17));
			 textfield.setBounds(220,115,200,40);
			    mainpanel.add(textfield);
		}
		private void setheading() {
 			// TODO Auto-generated method stub
 			heading.setFont(new Font("Verdana", Font.ITALIC, 17));
 			heading.setAlignmentX(CENTER_ALIGNMENT);
 		 	heading.setBounds(30, 30, 500, 70);
 		    mainpanel.add(heading);
 		}

		
		
		
	private void namelable() {
		// TODO Auto-generated method stub

		namelable.setFont(new Font("Verdana", Font.ITALIC, 17));
	    namelable.setBounds(20, 100, 200, 70);
	    mainpanel.add(namelable);


	}

	private void setbutton() {

	    button.setBounds(450,115,120,45);
	    button.setFont(new Font("Verdana", Font.ITALIC, 18));
		button.setForeground(Color.CYAN);
	    button.setBackground(Color.darkGray);
		Cursor cur=new Cursor(Cursor.HAND_CURSOR);
		button.setCursor(cur);
		mainpanel.add(button);
		button.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) 
	
	{
		// TODO Auto-generated method stub

// 		apigetting(textfield.getText().toString());
	//		String str=textfield.getText().toString();
      
		if(!textfield.getText().equals(""))
		{
			updateApi();
			
		}
		else
		{
			JOptionPane.showMessageDialog(textfield, "enter the city");
		}
		
	//	textfield1.setText(str);
      //      textfield.setText("  ");
 	}
		private void updateApi() {
		
			String city=textfield.getText().toString();
			weatherservice.setCityName(city);
			location.setText("currently in: "+city);
			
			JSONObject mainobj=weatherservice.getLocation();
			String country=mainobj.getString("country");
			region.setText("country: "+country);
			JSONObject mainobj1=weatherservice.getCurrent();
			Double temperature=mainobj1.getDouble("temp_c");
			temperature.parseDouble(current.getText());
			
	}
		/*private void imagelabel()
      {	// TODO Auto-generated method stub
	imagelabel.setBounds(50,200,150,150);

	 mainpanel.add(imagelabel);
}*/






	}

