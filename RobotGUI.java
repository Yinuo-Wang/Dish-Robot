/**
***This java program is a
***RobotGUI,
***Which can help people
***to order dishes
*** 
***@Auther WANG Yinuo
***@Student Number 140920440
***@Date June 3rd
**/

import java.awt.*;

import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

import java.awt.event.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

import java.io.*;

public class RobotGUI extends JFrame implements ActionListener{

/*
**Create instance variables and 
**other necessary components
*/
  Color c1=new Color(255, 111, 65); 
  Color c3=new Color(96, 176, 230); 
  Color c2=new Color(165, 215, 106); 
  Color c4=new Color(86, 220, 225); 
  Color c5=new Color(253, 149, 172); 
  Color c6=new Color(250, 222, 114); 
  Color c7=new Color(255,255,255);
  Color c8=new Color(244, 202, 229);  
  JFrame robotFrame = new JFrame();
  JFrame sleepFrame;
  JPanel robotPanel = new JPanel();
  int sum = 0;
  ArrayList<String> dish = new ArrayList<String>();
  int dishSelected;
  int dishNum;
  int dishMoney;
  JTextField robotTextField;
  String textFieldInput;
  Timer timer;
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int screenWidth = (int)screenSize.getWidth();
  int screenHeight = (int)screenSize.getHeight();
  int width = screenWidth/2 - 460;     //Set the horizental position of the frame
  int height = screenHeight/2 - 260;   //Set the vertical position of the frame

/*
**This is the welcome GUI
*/
  public void startWelcome(){
	  
    RobotInterface robotInterface = new RobotInterface();
    String b;
    b = robotInterface.istartWelcome();

    JButton welcomeButton = new JButton();
    welcomeButton.setText(b);
    welcomeButton.setBackground(c3);
    welcomeButton.setSize(935,525);
    welcomeButton.setFont(new Font("Century", Font.BOLD, 28));
	
	robotPanel = new JPanel();
	robotPanel.setLayout(null);
	robotPanel.add(welcomeButton);
	robotPanel.setBackground(c3);
	robotPanel.setSize(935,525);
	
    robotFrame = new JFrame();
    robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    robotFrame.getContentPane().add(robotPanel);
    robotFrame.getContentPane().setBackground(c7);
    robotFrame.setLocation(width,height);
    robotFrame.setSize(935,525);
    robotFrame.setVisible(true);
    welcomeButton.addActionListener(new StartWelcome());
  }
/*
**This is a subclass of RobotGUI
**which serves as the ActionListener
** of the button in welcome interface
*/  
  public class StartWelcome implements ActionListener { 
    public void actionPerformed(ActionEvent e) { 
        robotPanel.removeAll();
        timer.cancel();
        sleepMethod();
        order();
    } 
  } 
/*
**This is an order
*/
  public void order(){

    JLabel l1, l2;
    JLabel b11, b12, b21, b22, b31, b32;
    JLabel b41, b42, b51, b52, b6;
    JPanel p0,p1, p2, p3, p4, p5, p6, p7;

  l1=new JLabel("Please select a dish to order:", JLabel.LEFT);
  l1.setFont(new Font("Century", Font.BOLD, 23));
  l1.setSize(350,75);
  l1.setBackground(c7);
  p7=new JPanel();
  p7.setLayout(null);
  p7.add(l1);
  p7.setSize(350, 75);
  p7.setBackground(c7);
  p7.setLocation(5,0);
  
  robotTextField =new JTextField("",200);
  l2=new JLabel("Operation selected:");
  l2.setFont(new Font("Century", Font.BOLD, 23));
  l2.setHorizontalTextPosition(JLabel.RIGHT);
  l2.setVerticalTextPosition(JLabel.TOP);
  p0=new JPanel();
  p0.setLayout(new GridLayout(1,2));
  p0.add(l2);
  p0.add(robotTextField);
  p0.setSize(500, 50);
  p0.setBackground(c7);
  p0.setLocation(405,400);

  b11=new JLabel("1",JLabel.CENTER);
  b12=new JLabel("fish",JLabel.CENTER);
  b11.setFont(new Font("Century", Font.BOLD, 25));
  b12.setFont(new Font("Bradley Hand ITC", Font.BOLD, 28));
  p1=new JPanel();
  p1.setLayout(new GridLayout(2,1));
  p1.add(b11);
  p1.add(b12);
  p1.setSize(300, 150);
  p1.setBackground(c1);
  p1.setLocation(5,75);

  b21=new JLabel("2",JLabel.CENTER);
  b22=new JLabel("meat",JLabel.CENTER);
  b21.setFont(new Font("Century", Font.BOLD, 25));
  b22.setFont(new Font("Bradley Hand ITC", Font.BOLD, 28));
  p2=new JPanel(); 
  p2.setLayout(new GridLayout(2,1));
  p2.add(b21);
  p2.add(b22);
  p2.setSize(300, 150);
  p2.setBackground(c2);
  p2.setLocation(305,75);

  b31=new JLabel("3",JLabel.CENTER);
  b32=new JLabel("rice",JLabel.CENTER);
  b31.setFont(new Font("Century", Font.BOLD, 25));
  b32.setFont(new Font("Bradley Hand ITC", Font.BOLD, 28));
  p3=new JPanel(); 
  p3.setLayout(new GridLayout(2,1));
  p3.add(b31);
  p3.add(b32);
  p3.setSize(300, 150);
  p3.setBackground(c3);
  p3.setLocation(605,75);

  b41=new JLabel("4",JLabel.CENTER);
  b42=new JLabel("noodle",JLabel.CENTER);
  b41.setFont(new Font("Century", Font.BOLD, 25));
  b42.setFont(new Font("Bradley Hand ITC", Font.BOLD, 28));
  p4=new JPanel(); 
  p4.setLayout(new GridLayout(2,1));
  p4.add(b41);
  p4.add(b42);
  p4.setSize(300, 150);
  p4.setBackground(c4);
  p4.setLocation(5,225);

  b51=new JLabel("5",JLabel.CENTER);
  b52=new JLabel("drink",JLabel.CENTER);
  b51.setFont(new Font("Century", Font.BOLD, 25));
  b52.setFont(new Font("Bradley Hand ITC", Font.BOLD, 28));
  p5=new JPanel(); 
  p5.setLayout(new GridLayout(2,1));
  p5.add(b51);
  p5.add(b52);
  p5.setSize(300, 150);
  p5.setBackground(c5);
  p5.setLocation(305,225);
  
  p6=new JPanel(); 
  p6.setLayout(new BorderLayout()); 
  p6.setSize(300, 150);
  p6.setBackground(c6);
  p6.setLocation(605,225);
  
  robotPanel = new JPanel();
  robotPanel.setLayout(null);
  robotPanel.add(p0);
  robotPanel.add(p1);
  robotPanel.add(p2);
  robotPanel.add(p3);
  robotPanel.add(p4);
  robotPanel.add(p5);
  robotPanel.add(p6);
  robotPanel.add(p7);
  robotPanel.setBackground(c7);
  
  robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  robotFrame.getContentPane().add(robotPanel);
  robotFrame.getContentPane().setBackground(c7);
  robotFrame.setLocation(width,height);
  robotFrame.setSize(935,525);
  robotFrame.setVisible(true);
    
  robotTextField.addActionListener(new Order());
  }
  public class Order implements ActionListener { 
    public void actionPerformed(ActionEvent e) { 
	   robotPanel.removeAll();
	   timer.cancel();
	   sleepMethod();
	   
	   textFieldInput = robotTextField.getText(); //Get the content of the textField
	   if(textFieldInput.equals("1"))             //Decide which order to use
		   order1();
	   else if(textFieldInput.equals("2"))
		   order2();
           else if(textFieldInput.equals("3"))
		   order3();
	   else if(textFieldInput.equals("4"))
		   order4();
	   else if(textFieldInput.equals("5"))
		   order5();
	   else
		   wrongOrder();
    } 
  } 
/*
**This is an wrong order
**Only diplay when there is an errer on the input number
*/
  public void wrongOrder(){

    JLabel l1, l2;
    JLabel b11, b12, b21, b22, b31, b32;
    JLabel b41, b42, b51, b52, b6;
    JPanel p0,p1, p2, p3, p4, p5, p6, p7;

  l1=new JLabel("!Wrong number, please select again:", JLabel.LEFT);
  l1.setFont(new Font("Century", Font.BOLD, 23));
  l1.setSize(650,75);
  l1.setBackground(c7);
  p7=new JPanel();
  p7.setLayout(null);
  p7.add(l1);
  p7.setSize(650, 75);
  p7.setBackground(c7);
  p7.setLocation(5,0);
  
  robotTextField =new JTextField("",200);
  l2=new JLabel("Operation selected:");
  l2.setFont(new Font("Century", Font.BOLD, 23));
  l2.setHorizontalTextPosition(JLabel.RIGHT);
  l2.setVerticalTextPosition(JLabel.TOP);
  p0=new JPanel();
  p0.setLayout(new GridLayout(1,2));
  p0.add(l2);
  p0.add(robotTextField);
  p0.setSize(500, 50);
  p0.setBackground(c7);
  p0.setLocation(405,400);

  b11=new JLabel("1",JLabel.CENTER);
  b12=new JLabel("fish",JLabel.CENTER);
  b11.setFont(new Font("Century", Font.BOLD, 25));
  b12.setFont(new Font("Bradley Hand ITC", Font.BOLD, 28));
  p1=new JPanel();
  p1.setLayout(new GridLayout(2,1));
  p1.add(b11);
  p1.add(b12);
  p1.setSize(300, 150);
  p1.setBackground(c1);
  p1.setLocation(5,75);

  b21=new JLabel("2",JLabel.CENTER);
  b22=new JLabel("meat",JLabel.CENTER);
  b21.setFont(new Font("Century", Font.BOLD, 25));
  b22.setFont(new Font("Bradley Hand ITC", Font.BOLD, 28));
  p2=new JPanel(); 
  p2.setLayout(new GridLayout(2,1));
  p2.add(b21);
  p2.add(b22);
  p2.setSize(300, 150);
  p2.setBackground(c2);
  p2.setLocation(305,75);

  b31=new JLabel("3",JLabel.CENTER);
  b32=new JLabel("rice",JLabel.CENTER);
  b31.setFont(new Font("Century", Font.BOLD, 25));
  b32.setFont(new Font("Bradley Hand ITC", Font.BOLD, 28));
  p3=new JPanel(); 
  p3.setLayout(new GridLayout(2,1));
  p3.add(b31);
  p3.add(b32);
  p3.setSize(300, 150);
  p3.setBackground(c3);
  p3.setLocation(605,75);

  b41=new JLabel("4",JLabel.CENTER);
  b42=new JLabel("noodle",JLabel.CENTER);
  b41.setFont(new Font("Century", Font.BOLD, 25));
  b42.setFont(new Font("Bradley Hand ITC", Font.BOLD, 28));
  p4=new JPanel(); 
  p4.setLayout(new GridLayout(2,1));
  p4.add(b41);
  p4.add(b42);
  p4.setSize(300, 150);
  p4.setBackground(c4);
  p4.setLocation(5,225);

  b51=new JLabel("5",JLabel.CENTER);
  b52=new JLabel("drink",JLabel.CENTER);
  b51.setFont(new Font("Century", Font.BOLD, 25));
  b52.setFont(new Font("Bradley Hand ITC", Font.BOLD, 28));
  p5=new JPanel(); 
  p5.setLayout(new GridLayout(2,1));
  p5.add(b51);
  p5.add(b52);
  p5.setSize(300, 150);
  p5.setBackground(c5);
  p5.setLocation(305,225);
  
  p6=new JPanel(); 
  p6.setLayout(new BorderLayout()); 
  p6.setSize(300, 150);
  p6.setBackground(c6);
  p6.setLocation(605,225);
  
  robotPanel = new JPanel();
  robotPanel.setLayout(null);
  robotPanel.add(p0);
  robotPanel.add(p1);
  robotPanel.add(p2);
  robotPanel.add(p3);
  robotPanel.add(p4);
  robotPanel.add(p5);
  robotPanel.add(p6);
  robotPanel.add(p7);
  robotPanel.setBackground(c7);
  
  robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  robotFrame.getContentPane().add(robotPanel);
  robotFrame.getContentPane().setBackground(c7);
  robotFrame.setLocation(width,height);
  robotFrame.setSize(935,525);
  robotFrame.setVisible(true);
    
  robotTextField.addActionListener(new Order());
  }
/*
**This is the fish order
*/ 
  public void order1(){

  JLabel l1, l2;
  JLabel b11, b12, b21, b22, b31, b32;
  JLabel b41, b42, b51, b52, b61, b62;
  JPanel p0,p1, p2, p3, p4, p5, p6, p7;

  l1=new JLabel("Please select a dish to order:", JLabel.LEFT);
  l1.setFont(new Font("Century", Font.BOLD, 23));
  l1.setSize(350,75);
  l1.setBackground(c7);
  p7=new JPanel();
  p7.setLayout(null);
  p7.add(l1);
  p7.setSize(350, 75);
  p7.setBackground(c7);
  p7.setLocation(5,0);

  robotTextField=null;
  robotTextField = new JTextField("",200);
  l2=new JLabel("Operation selected:");
  l2.setFont(new Font("Century", Font.BOLD, 23));
  l2.setHorizontalTextPosition(JLabel.RIGHT);
  l2.setVerticalTextPosition(JLabel.TOP);
  p0=new JPanel();
  p0.setLayout(new GridLayout(1,2));
  p0.add(l2);
  p0.add(robotTextField);
  p0.setSize(500, 50);
  p0.setBackground(c7);
  p0.setLocation(405,400);

  b11=new JLabel("1",JLabel.CENTER);
  b12=new JLabel("q¨©ngzh¨¥ng l¨²y¨²",JLabel.CENTER);
  b11.setFont(new Font("Century", Font.BOLD, 25));
  b12.setFont(new Font("Calibri Light", Font.BOLD, 23)); 
  p1=new JPanel();
  p1.setLayout(new GridLayout(2,1));
  p1.add(b11);
  p1.add(b12);
  p1.setSize(300, 150);
  p1.setBackground(c1);
  p1.setLocation(5,75);

  b21=new JLabel("2",JLabel.CENTER);
  b22=new JLabel("xi¨¤m¨¦n shu¨«zh¨³ h¨®uy¨²",JLabel.CENTER);
  b21.setFont(new Font("Century", Font.BOLD, 25));
  b22.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p2=new JPanel(); 
  p2.setLayout(new GridLayout(2,1));
  p2.add(b21);
  p2.add(b22);
  p2.setSize(300, 150);
  p2.setBackground(c2);
  p2.setLocation(305,75);

  b31=new JLabel("3",JLabel.CENTER);
  b32=new JLabel("s¨¬chu¨¡n hu¨¢ngm¨¨n m¨¢n",JLabel.CENTER);
  b31.setFont(new Font("Century", Font.BOLD, 25));
  b32.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p3=new JPanel(); 
  p3.setLayout(new GridLayout(2,1));
  p3.add(b31);
  p3.add(b32);
  p3.setSize(300, 150);
  p3.setBackground(c3);
  p3.setLocation(605,75);

  b41=new JLabel("4",JLabel.CENTER);
  b42=new JLabel("g¨¡nzh¨¢ hu¨¢nghu¨¡y¨²",JLabel.CENTER);
  b41.setFont(new Font("Century", Font.BOLD, 25));
  b42.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p4=new JPanel(); 
  p4.setLayout(new GridLayout(2,1));
  p4.add(b41);
  p4.add(b42);
  p4.setSize(300, 150);
  p4.setBackground(c4);
  p4.setLocation(5,225);

  b51=new JLabel("5",JLabel.CENTER);
  b52=new JLabel("h¨®ngm¨¨n l¨«y¨²",JLabel.CENTER);
  b51.setFont(new Font("Century", Font.BOLD, 25));
  b52.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p5=new JPanel(); 
  p5.setLayout(new GridLayout(2,1));
  p5.add(b51);
  p5.add(b52);
  p5.setSize(300, 150);
  p5.setBackground(c5);
  p5.setLocation(305,225);

  b61=new JLabel("6",JLabel.CENTER);
  b62=new JLabel("h¨­ngsh¨¡o b¨¤y¨²",JLabel.CENTER);
  b61.setFont(new Font("Century", Font.BOLD, 25));
  b62.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p6=new JPanel(); 
  p6.setLayout(new GridLayout(2,1));
  p6.add(b61);
  p6.add(b62);
  p6.setSize(300, 150);
  p6.setBackground(c6);
  p6.setLocation(605,225);
  
  robotPanel = new JPanel();
  robotPanel.setLayout(null);
  robotPanel.add(p0);
  robotPanel.add(p1);
  robotPanel.add(p2);
  robotPanel.add(p3);
  robotPanel.add(p4);
  robotPanel.add(p5);
  robotPanel.add(p6);
  robotPanel.add(p7);
  robotPanel.setBackground(c7);
  
  robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  robotFrame.getContentPane().add(robotPanel);  
  robotFrame.getContentPane().setBackground(c7);
  robotFrame.setLocation(width,height);
  robotFrame.setSize(935,525);
  robotFrame.setVisible(true);
  
    robotTextField.addActionListener(new Order1());
  }
  
  public class Order1 implements ActionListener{
	public void actionPerformed(ActionEvent e) { 
	  robotPanel.removeAll();
	  timer.cancel();
	  sleepMethod();

	   textFieldInput = "0";
	   textFieldInput = robotTextField.getText();
	   if(textFieldInput.equals("1"))
		   dishSelected = 1;
	   else if(textFieldInput.equals("2"))
		   dishSelected = 2;
           else if(textFieldInput.equals("3"))
		   dishSelected = 3;
	   else if(textFieldInput.equals("4"))
		   dishSelected = 4;
	   else if(textFieldInput.equals("5"))
		   dishSelected = 5;
	   else if(textFieldInput.equals("6"))
		   dishSelected = 6;
	   else{
		   wrongOrder1();
		   dishSelected = 0;
	   }
	  
	  FileReader fr;
	  BufferedReader br = null;
          dish=new ArrayList<String>();
	  
      try{
	    fr = new FileReader("FishDishes.txt");
            br = new BufferedReader(fr);
	  
	    for (int i=0;i<19;i++){
	      dish.add(br.readLine());    //Read the information stored in the text line by line
        }
	    
        br.close();
        fr.close(); 

      }catch (IOException event) { 
	       
      } 
	
	  dishNum = Integer.parseInt(dish.get(3*dishSelected));  //Turn the String to int 
	  dishMoney = Integer.parseInt(dish.get(3*dishSelected-1));
	  
	  if (dishNum>0)
	    dishInformation();
	  else
	    order1Unavailable();
	}
  }
  
  public void wrongOrder1(){

  JLabel l1, l2;
  JLabel b11, b12, b21, b22, b31, b32;
  JLabel b41, b42, b51, b52, b61, b62;
  JPanel p0,p1, p2, p3, p4, p5, p6, p7;

  l1=new JLabel("!Wrong number, please select again:", JLabel.LEFT);
  l1.setFont(new Font("Century", Font.BOLD, 23));
  l1.setSize(650,75);
  l1.setBackground(c7);
  p7=new JPanel();
  p7.setLayout(null);
  p7.add(l1);
  p7.setSize(650, 75);
  p7.setBackground(c7);
  p7.setLocation(5,0);

  robotTextField=null;
  robotTextField = new JTextField("",200);
  l2=new JLabel("Operation selected:");
  l2.setFont(new Font("Century", Font.BOLD, 23));
  l2.setHorizontalTextPosition(JLabel.RIGHT);
  l2.setVerticalTextPosition(JLabel.TOP);
  p0=new JPanel();
  p0.setLayout(new GridLayout(1,2));
  p0.add(l2);
  p0.add(robotTextField);
  p0.setSize(500, 50);
  p0.setBackground(c7);
  p0.setLocation(405,400);

  b11=new JLabel("1",JLabel.CENTER);
  b12=new JLabel("q¨©ngzh¨¥ng l¨²y¨²",JLabel.CENTER);
  b11.setFont(new Font("Century", Font.BOLD, 25));
  b12.setFont(new Font("Calibri Light", Font.BOLD, 23)); 
  p1=new JPanel();
  p1.setLayout(new GridLayout(2,1));
  p1.add(b11);
  p1.add(b12);
  p1.setSize(300, 150);
  p1.setBackground(c1);
  p1.setLocation(5,75);

  b21=new JLabel("2",JLabel.CENTER);
  b22=new JLabel("xi¨¤m¨¦n shu¨«zh¨³ h¨®uy¨²",JLabel.CENTER);
  b21.setFont(new Font("Century", Font.BOLD, 25));
  b22.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p2=new JPanel(); 
  p2.setLayout(new GridLayout(2,1));
  p2.add(b21);
  p2.add(b22);
  p2.setSize(300, 150);
  p2.setBackground(c2);
  p2.setLocation(305,75);

  b31=new JLabel("3",JLabel.CENTER);
  b32=new JLabel("s¨¬chu¨¡n hu¨¢ngm¨¨n m¨¢n",JLabel.CENTER);
  b31.setFont(new Font("Century", Font.BOLD, 25));
  b32.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p3=new JPanel(); 
  p3.setLayout(new GridLayout(2,1));
  p3.add(b31);
  p3.add(b32);
  p3.setSize(300, 150);
  p3.setBackground(c3);
  p3.setLocation(605,75);

  b41=new JLabel("4",JLabel.CENTER);
  b42=new JLabel("g¨¡nzh¨¢ hu¨¢nghu¨¡y¨²",JLabel.CENTER);
  b41.setFont(new Font("Century", Font.BOLD, 25));
  b42.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p4=new JPanel(); 
  p4.setLayout(new GridLayout(2,1));
  p4.add(b41);
  p4.add(b42);
  p4.setSize(300, 150);
  p4.setBackground(c4);
  p4.setLocation(5,225);

  b51=new JLabel("5",JLabel.CENTER);
  b52=new JLabel("h¨®ngm¨¨n l¨«y¨²",JLabel.CENTER);
  b51.setFont(new Font("Century", Font.BOLD, 25));
  b52.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p5=new JPanel(); 
  p5.setLayout(new GridLayout(2,1));
  p5.add(b51);
  p5.add(b52);
  p5.setSize(300, 150);
  p5.setBackground(c5);
  p5.setLocation(305,225);

  b61=new JLabel("6",JLabel.CENTER);
  b62=new JLabel("h¨­ngsh¨¡o b¨¤y¨²",JLabel.CENTER);
  b61.setFont(new Font("Century", Font.BOLD, 25));
  b62.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p6=new JPanel(); 
  p6.setLayout(new GridLayout(2,1));
  p6.add(b61);
  p6.add(b62);
  p6.setSize(300, 150);
  p6.setBackground(c6);
  p6.setLocation(605,225);
  
  robotPanel = new JPanel();
  robotPanel.setLayout(null);
  robotPanel.add(p0);
  robotPanel.add(p1);
  robotPanel.add(p2);
  robotPanel.add(p3);
  robotPanel.add(p4);
  robotPanel.add(p5);
  robotPanel.add(p6);
  robotPanel.add(p7);
  robotPanel.setBackground(c7);
  
  robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  robotFrame.getContentPane().add(robotPanel);  
  robotFrame.getContentPane().setBackground(c7);
  robotFrame.setLocation(width,height);
  robotFrame.setSize(935,525);
  robotFrame.setVisible(true);
  
    robotTextField.addActionListener(new Order1());
  }
/*
**This is the interface to show
**the information of the dish selected
**including its name, number, and costs
*/ 
  public void dishInformation(){
	JLabel l0, l11, l12, l21, l22, l31, l32;
        JButton b1, b2;
	JPanel p1, p2, p3;
	String name = null;
	String money = null;
        String num = null;
	
	name = dish.get(3*dishSelected-2);
	money = dish.get(3*dishSelected-1);
	num = dish.get(3*dishSelected);
	
	l0=new JLabel("Place make sure that you want to order this dish:", JLabel.LEFT);
        l0.setFont(new Font("Century", Font.BOLD, 23));
        l0.setSize(600,75);
        l0.setBackground(c7);
	l0.setLocation(5,0);
	
        l11=new JLabel("Dish Name: ", JLabel.RIGHT);
        l11.setFont(new Font("Century", Font.BOLD, 23));
	l12=new JLabel(name,JLabel.LEFT);
        l12.setFont(new Font("Calibri Light", Font.BOLD, 23));
	p1 = new JPanel();
	p1.setLayout(new GridLayout(1,2));
	p1.add(l11);
	p1.add(l12);
        p1.setSize(920,100);
        p1.setBackground(c6);
	p1.setLocation(5,75);
	 
        l21=new JLabel("Dish Costs(yuan): ", JLabel.RIGHT);
        l21.setFont(new Font("Century", Font.BOLD, 23));
	l22=new JLabel(money, JLabel.LEFT);
        l22.setFont(new Font("Century", Font.BOLD, 23));
	p2 = new JPanel();
	p2.setLayout(new GridLayout(1,2));
	p2.add(l21);
	p2.add(l22);
        p2.setSize(920,100);
        p2.setBackground(c6);
	p2.setLocation(5,175);
	
    l31=new JLabel("Dish Left: ", JLabel.RIGHT);
    l31.setFont(new Font("Century", Font.BOLD, 23));
    l32=new JLabel(num, JLabel.LEFT);
    l32.setFont(new Font("Century", Font.BOLD, 23));
    p3 = new JPanel();
    p3.setLayout(new GridLayout(1,2));
    p3.add(l31);
    p3.add(l32);
    p3.setSize(920,100);
    p3.setBackground(c6);
    p3.setLocation(5,275);
	
    b1 = new JButton("CANCLE");
    b1.setBackground(c3);
    b1.setSize(300,50);
    b1.setFont(new Font("Century", Font.BOLD, 20));
    b1.setLocation(155, 400);
	
    b2 = new JButton("SELECT");
    b2.setBackground(c3);
    b2.setSize(300,50);
    b2.setFont(new Font("Century", Font.BOLD, 20));
    b2.setLocation(480, 400);

    robotPanel = new JPanel();
    robotPanel.setLayout(null);
    robotPanel.add(p1);
    robotPanel.add(p2);
    robotPanel.add(p3);
    robotPanel.add(l0);
    robotPanel.add(b1);
    robotPanel.add(b2);
    robotPanel.setBackground(c7);
    	
    robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    robotFrame.getContentPane().add(robotPanel);  
    robotFrame.getContentPane().setBackground(c7);
    robotFrame.setLocation(width,height);
    robotFrame.setSize(935,525);
    robotFrame.setVisible(true);
	
    b1.addActionListener(new StartWelcome());
    b2.addActionListener(new DishInformation());
  }

  public class DishInformation implements ActionListener{  
	public void actionPerformed(ActionEvent event) { 
	  robotPanel.removeAll();
	  timer.cancel();
	  sleepMethod();
	  FileWriter fw;
	  BufferedWriter bw = null;
	  
	  dishNum = dishNum - 1;
	  dish.remove(3*dishSelected); 
	  dish.add(3*dishSelected,String.valueOf(dishNum));
	  sum = sum + dishMoney;
	  
	  try{
          fw = new FileWriter(dish.get(0));
          bw = new BufferedWriter(fw);
	  
	    for (int i=0;i<19;i++){
		  bw.write(dish.get(i));
		  bw.newLine();
          } 
	    
          bw.close();
          fw.close(); 

          }catch (IOException e) { 
          } 
	
	  tellJokes();
        }
  }

/*
**This is a mathod 
**display the jokes
*/
  public void tellJokes(){
	JLabel l0, l1;
	JButton b1, b2;
        JPanel p1;
	
      RobotInterface robotInterface = new RobotInterface();
      String b;
      b=robotInterface.itellJokes();         //Use the mathod of RobotInterface to read the jokes
	
	l0=new JLabel("I'd like to tell you a joke:", JLabel.LEFT);
        l0.setFont(new Font("Century", Font.BOLD, 23));
        l0.setSize(920,75);
        l0.setBackground(c7);
	l0.setLocation(5,0);
	
	l1=new JLabel(b, JLabel.CENTER);
	l1.setFont(new Font("Century", Font.BOLD, 23));
	p1 = new JPanel();
	p1.setLayout(new GridLayout(1,1));
	p1.add(l1);
        p1.setSize(920,300);
        p1.setBackground(c6);
	p1.setLocation(5,75);
	
	b1=new JButton("Stop telling and order");
	b1.setBackground(c3);
	b1.setSize(400, 50);
	b1.setLocation(55, 400);
	b1.setFont(new Font("Century", Font.BOLD, 20));
	
	b2=new JButton("Stop telling and pay");
	b2.setBackground(c3);
	b2.setSize(400, 50);
	b2.setLocation(480, 400);
	b2.setFont(new Font("Century", Font.BOLD, 20));
	
    robotPanel = new JPanel();
    robotPanel.setLayout(null);
    robotPanel.add(l0);
    robotPanel.add(p1);
    robotPanel.add(b1);
    robotPanel.add(b2);
    robotPanel.setBackground(c7);
    	
    robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    robotFrame.getContentPane().add(robotPanel);  
    robotFrame.getContentPane().setBackground(c7);
    robotFrame.setLocation(width,height);
    robotFrame.setSize(935,525);
    robotFrame.setVisible(true);
	
    b1.addActionListener(new StartWelcome());
    b2.addActionListener(new TellJokes());
  }
    public class TellJokes implements ActionListener{
	  public void actionPerformed(ActionEvent e) {
	    robotPanel.removeAll();
	    timer.cancel();
	    sleepMethod();
	    pay();
	  }
  }
  
/*
**This method is to show
**the total money cost
*/
  public void pay(){
	JLabel l0,l1;
        JButton b1,b2;	
	JPanel p1;
	 
	String a = null;
	a = String.valueOf(sum);
	
	l0=new JLabel("The dishes cost(yuan):", JLabel.LEFT);
        l0.setFont(new Font("Century", Font.BOLD, 23));
        l0.setSize(920,75);
        l0.setBackground(c7);
	l0.setLocation(5,0);
	
	l1=new JLabel(a, JLabel.CENTER);
	l1.setFont(new Font("Century", Font.BOLD, 25));
	p1 = new JPanel();
	p1.setLayout(new GridLayout(1,1));
	p1.add(l1);
        p1.setSize(920,300);
	p1.setLocation(5,75);
	p1.setBackground(c6);
	
	b1=new JButton("OK");
	b1.setBackground(c3);
	b1.setSize(200, 50);
	b1.setLocation(375, 400);
	b1.setFont(new Font("Century", Font.BOLD, 20));
	
    robotPanel = new JPanel();
    robotPanel.setLayout(null);
    robotPanel.add(l0);
    robotPanel.add(b1);
    robotPanel.add(p1);
    robotPanel.setBackground(c7);
    	
    robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    robotFrame.getContentPane().add(robotPanel);  
    robotFrame.getContentPane().setBackground(c7);
    robotFrame.setLocation(width,height);
    robotFrame.setSize(935,525);
    robotFrame.setVisible(true);
	
    b1.addActionListener(new Pay());
  }
  public class Pay implements ActionListener{
	  public void actionPerformed(ActionEvent e) {
	    robotPanel.removeAll();
	    timer.cancel();
	    sleepMethod();
	    fareWell();
	  }
  }
/*
**This is a farewell interface
*/
  public void fareWell(){
    JLabel l0, l1;
	JButton b1;
	JPanel p1;
    
    RobotInterface robotInterface = new RobotInterface();
    String b;
    b=robotInterface.ifareWell();
	
	l0=new JLabel("Never say goodby!", JLabel.LEFT);
        l0.setFont(new Font("Century", Font.BOLD, 23));
        l0.setSize(920,75);
        l0.setBackground(c7);
	l0.setLocation(5,0);
	
	l1=new JLabel(b, JLabel.CENTER);
        l1.setFont(new Font("Century", Font.BOLD, 23));
	p1 = new JPanel();
	p1.setLayout(new GridLayout(1,1));
	p1.add(l1);
        p1.setSize(920,300);
        p1.setBackground(c6);
	p1.setLocation(5,75);
	
	b1=new JButton("New Customer");
	b1.setBackground(c3);
	b1.setSize(200, 50);
	b1.setLocation(375, 400);
	b1.setFont(new Font("Century", Font.BOLD, 20));  
	
    robotPanel = new JPanel();
    robotPanel.setLayout(null);
    robotPanel.add(l0);
    robotPanel.add(p1);
    robotPanel.add(b1);
    robotPanel.setBackground(c7);
    	
    robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    robotFrame.getContentPane().add(robotPanel);  
    robotFrame.getContentPane().setBackground(c7);
    robotFrame.setLocation(width,height);
    robotFrame.setSize(935,525);
    robotFrame.setVisible(true);
	
    b1.addActionListener(new StartWelcome2());
  }
  public class StartWelcome2 implements ActionListener{
	  public void actionPerformed(ActionEvent e) {
	    robotPanel.removeAll();
	    robotFrame.dispose();
	    timer.cancel();
	    sleepMethod();
	    sum = 0;
	    startWelcome();
	  }
  }
/*
**This is a method only displayed
**when the number of the dish selected
**becomes 0
*/
  public void order1Unavailable(){

  JLabel l1, l2;
  JLabel b11, b12, b21, b22, b31, b32;
  JLabel b41, b42, b51, b52, b61, b62;
  JPanel p0,p1, p2, p3, p4, p5, p6, p7;

  l1=new JLabel("The choice is not available. Place select again:", JLabel.LEFT);
  l1.setFont(new Font("Century", Font.BOLD, 23));
  l1.setSize(650,75);
  l1.setBackground(c7);
  p7=new JPanel();
  p7.setLayout(null);
  p7.add(l1);
  p7.setSize(650, 75);
  p7.setBackground(c7);
  p7.setLocation(5,0);

  robotTextField=new JTextField("",200);
  robotTextField.addActionListener(this);
  l2=new JLabel("Operation selected:");
  l2.setFont(new Font("Century", Font.BOLD, 23));
  l2.setHorizontalTextPosition(JLabel.RIGHT);
  l2.setVerticalTextPosition(JLabel.TOP);
  p0=new JPanel();
  p0.setLayout(new GridLayout(1,2));
  p0.add(l2);
  p0.add(robotTextField);
  p0.setSize(500, 50);
  p0.setBackground(c7);
  p0.setLocation(405,400);

  b11=new JLabel("1",JLabel.CENTER);
  b12=new JLabel("q¨©ngzh¨¥ng l¨²y¨²",JLabel.CENTER);
  b11.setFont(new Font("Century", Font.BOLD, 25));
  b12.setFont(new Font("Calibri Light", Font.BOLD, 23)); 
  p1=new JPanel();
  p1.setLayout(new GridLayout(2,1));
  p1.add(b11);
  p1.add(b12);
  p1.setSize(300, 150);
  p1.setBackground(c1);
  p1.setLocation(5,75);

  b21=new JLabel("2",JLabel.CENTER);
  b22=new JLabel("xi¨¤m¨¦n shu¨«zh¨³ h¨®uy¨²",JLabel.CENTER);
  b21.setFont(new Font("Century", Font.BOLD, 25));
  b22.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p2=new JPanel(); 
  p2.setLayout(new GridLayout(2,1));
  p2.add(b21);
  p2.add(b22);
  p2.setSize(300, 150);
  p2.setBackground(c2);
  p2.setLocation(305,75);

  b31=new JLabel("3",JLabel.CENTER);
  b32=new JLabel("s¨¬chu¨¡n hu¨¢ngm¨¨n m¨¢n",JLabel.CENTER);
  b31.setFont(new Font("Century", Font.BOLD, 25));
  b32.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p3=new JPanel(); 
  p3.setLayout(new GridLayout(2,1));
  p3.add(b31);
  p3.add(b32);
  p3.setSize(300, 150);
  p3.setBackground(c3);
  p3.setLocation(605,75);

  b41=new JLabel("4",JLabel.CENTER);
  b42=new JLabel("g¨¡nzh¨¢ hu¨¢nghu¨¡y¨²",JLabel.CENTER);
  b41.setFont(new Font("Century", Font.BOLD, 25));
  b42.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p4=new JPanel(); 
  p4.setLayout(new GridLayout(2,1));
  p4.add(b41);
  p4.add(b42);
  p4.setSize(300, 150);
  p4.setBackground(c4);
  p4.setLocation(5,225);

  b51=new JLabel("5",JLabel.CENTER);
  b52=new JLabel("h¨®ngm¨¨n l¨«y¨²",JLabel.CENTER);
  b51.setFont(new Font("Century", Font.BOLD, 25));
  b52.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p5=new JPanel(); 
  p5.setLayout(new GridLayout(2,1));
  p5.add(b51);
  p5.add(b52);
  p5.setSize(300, 150);
  p5.setBackground(c5);
  p5.setLocation(305,225);

  b61=new JLabel("6",JLabel.CENTER);
  b62=new JLabel("h¨­ngsh¨¡o b¨¤y¨²",JLabel.CENTER);
  b61.setFont(new Font("Century", Font.BOLD, 25));
  b62.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p6=new JPanel(); 
  p6.setLayout(new GridLayout(2,1));
  p6.add(b61);
  p6.add(b62);
  p6.setSize(300, 150);
  p6.setBackground(c6);
  p6.setLocation(605,225);
  
  robotPanel = new JPanel();
  robotPanel.setLayout(null);
  robotPanel.add(p0);
  robotPanel.add(p1);
  robotPanel.add(p2);
  robotPanel.add(p3);
  robotPanel.add(p4);
  robotPanel.add(p5);
  robotPanel.add(p6);
  robotPanel.add(p7);
  robotPanel.setBackground(c7);
  
  robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  robotFrame.getContentPane().add(robotPanel);  
  robotFrame.getContentPane().setBackground(c7);
  robotFrame.setLocation(width,height);
  robotFrame.setSize(935,525);
  robotFrame.setVisible(true);
  
  robotTextField.addActionListener(new Order());
  }
/*
**This is the meat order
*/  
  public void order2(){

  JLabel l1, l2;
  JLabel b11, b12, b21, b22, b31, b32;
  JLabel b41, b42, b51, b52, b61, b62;
  JPanel p0,p1, p2, p3, p4, p5, p6, p7;

  l1=new JLabel("Please select a dish to order:", Label.LEFT);
  l1.setFont(new Font("Century", Font.BOLD, 23));
  l1.setSize(350,75);
  l1.setBackground(c7);
  p7=new JPanel();
  p7.setLayout(null);
  p7.add(l1);
  p7.setSize(350, 75);
  p7.setBackground(c7);
  p7.setLocation(5,0);

  robotTextField=new JTextField("",200);
  l2=new JLabel("Operation selected:");
  l2.setFont(new Font("Century", Font.BOLD, 23));
  l2.setHorizontalTextPosition(JLabel.RIGHT);
  l2.setVerticalTextPosition(JLabel.TOP);
  p0=new JPanel();
  p0.setLayout(new GridLayout(1,2));
  p0.add(l2);
  p0.add(robotTextField);
  p0.setSize(500, 50);
  p0.setBackground(c7);
  p0.setLocation(405,400);

  b11=new JLabel("1",JLabel.CENTER);
  b12=new JLabel("g¨­ngb¨£o j¨©d¨©ng",JLabel.CENTER);
  b11.setFont(new Font("Century", Font.BOLD, 25));
  b12.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p1=new JPanel();
  p1.setLayout(new GridLayout(2,1));
  p1.add(b11);
  p1.add(b12);
  p1.setSize(300, 150);
  p1.setBackground(c1);
  p1.setLocation(5,75);

  b21=new JLabel("2",JLabel.CENTER);
  b22=new JLabel("b¨­lu¨® g¨±l¨£or¨°u",JLabel.CENTER);
  b21.setFont(new Font("Century", Font.BOLD, 25));
  b22.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p2=new JPanel(); 
  p2.setLayout(new GridLayout(2,1));
  p2.add(b21);
  p2.add(b22);
  p2.setSize(300, 150);
  p2.setBackground(c2);
  p2.setLocation(305,75);

  b31=new JLabel("3",JLabel.CENTER);
  b32=new JLabel("su¨¤nt¨¢i r¨°us¨©",JLabel.CENTER);
  b31.setFont(new Font("Century", Font.BOLD, 25));
  b32.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p3=new JPanel(); 
  p3.setLayout(new GridLayout(2,1));
  p3.add(b31);
  p3.add(b32);
  p3.setSize(300, 150);
  p3.setBackground(c3);
  p3.setLocation(605,75);

  b41=new JLabel("4",JLabel.CENTER);
  b42=new JLabel("j¨©ngji¨¤ng r¨°us¨©",JLabel.CENTER);
  b41.setFont(new Font("Century", Font.BOLD, 25));
  b42.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p4=new JPanel(); 
  p4.setLayout(new GridLayout(2,1));
  p4.add(b41);
  p4.add(b42);
  p4.setSize(300, 150);
  p4.setBackground(c4);
  p4.setLocation(5,225);

  b51=new JLabel("5",JLabel.CENTER);
  b52=new JLabel("c¨´li¨± xi¨£opa¨ª",JLabel.CENTER);
  b51.setFont(new Font("Century", Font.BOLD, 25));
  b52.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p5=new JPanel(); 
  p5.setLayout(new GridLayout(2,1));
  p5.add(b51);
  p5.add(b52);
  p5.setSize(300, 150);
  p5.setBackground(c5);
  p5.setLocation(305,225);

  b61=new JLabel("6",JLabel.CENTER);
  b62=new JLabel("q¨©ngji¨¡o ch¨£or¨°u",JLabel.CENTER);
  b61.setFont(new Font("Century", Font.BOLD, 25));
  b62.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p6=new JPanel(); 
  p6.setLayout(new GridLayout(2,1));
  p6.add(b61);
  p6.add(b62);
  p6.setSize(300, 150);
  p6.setBackground(c6);
  p6.setLocation(605,225);
  
  robotPanel = new JPanel();
  robotPanel.setLayout(null);
  robotPanel.add(p0);
  robotPanel.add(p1);
  robotPanel.add(p2);
  robotPanel.add(p3);
  robotPanel.add(p4);
  robotPanel.add(p5);
  robotPanel.add(p6);
  robotPanel.add(p7);
  robotPanel.setBackground(c7);
  
  robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  robotFrame.getContentPane().add(robotPanel);  
  robotFrame.getContentPane().setBackground(c7);
  robotFrame.setLocation(width,height);
  robotFrame.setSize(935,525);
  robotFrame.setVisible(true);
  
  robotTextField.addActionListener(new Order2());
  }
  public class Order2 implements ActionListener{
	public void actionPerformed(ActionEvent e) { 
	  robotPanel.removeAll();
	  timer.cancel();
	  sleepMethod();
	  
	   textFieldInput = "0";
	   textFieldInput = robotTextField.getText();
	  
	   if(textFieldInput.equals("1"))
		   dishSelected = 1;
	   else if(textFieldInput.equals("2"))
		   dishSelected = 2;
           else if(textFieldInput.equals("3"))
		   dishSelected = 3;
	   else if(textFieldInput.equals("4"))
		   dishSelected = 4;
	   else if(textFieldInput.equals("5"))
		   dishSelected = 5;
	   else if(textFieldInput.equals("6"))
		   dishSelected = 6;
	   else{
		   wrongOrder2();
		   dishSelected = 0;
	   }
		   
	       
	   
	  FileReader fr;
	  BufferedReader br = null;
          dish=new ArrayList<String>();
	  
      try{
	    fr = new FileReader("MeatDishes.txt");
            br = new BufferedReader(fr);
	  
	    for (int i=0;i<19;i++){
	      dish.add(br.readLine());
        }
	    
        br.close();
        fr.close(); 

      }catch (IOException event) { 
	       
      } 
	
	  dishNum = Integer.parseInt(dish.get(3*dishSelected));
	  dishMoney = Integer.parseInt(dish.get(3*dishSelected-1));
	  
	  if (dishNum>0)
	    dishInformation();
	  else
	    order1Unavailable();
	}
  }

  public void wrongOrder2(){

  JLabel l1, l2;
  JLabel b11, b12, b21, b22, b31, b32;
  JLabel b41, b42, b51, b52, b61, b62;
  JPanel p0,p1, p2, p3, p4, p5, p6, p7;

  l1=new JLabel("!Wrong number, please select again:", Label.LEFT);
  l1.setFont(new Font("Century", Font.BOLD, 23));
  l1.setSize(425,75);
  l1.setBackground(c7);
  p7=new JPanel();
  p7.setLayout(null);
  p7.add(l1);
  p7.setSize(425, 75);
  p7.setBackground(c7);
  p7.setLocation(5,0);

  robotTextField=new JTextField("",200);
  l2=new JLabel("Operation selected:");
  l2.setFont(new Font("Century", Font.BOLD, 23));
  l2.setHorizontalTextPosition(JLabel.RIGHT);
  l2.setVerticalTextPosition(JLabel.TOP);
  p0=new JPanel();
  p0.setLayout(new GridLayout(1,2));
  p0.add(l2);
  p0.add(robotTextField);
  p0.setSize(500, 50);
  p0.setBackground(c7);
  p0.setLocation(405,400);

  b11=new JLabel("1",JLabel.CENTER);
  b12=new JLabel("g¨­ngb¨£o j¨©d¨©ng",JLabel.CENTER);
  b11.setFont(new Font("Century", Font.BOLD, 25));
  b12.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p1=new JPanel();
  p1.setLayout(new GridLayout(2,1));
  p1.add(b11);
  p1.add(b12);
  p1.setSize(300, 150);
  p1.setBackground(c1);
  p1.setLocation(5,75);

  b21=new JLabel("2",JLabel.CENTER);
  b22=new JLabel("b¨­lu¨® g¨±l¨£or¨°u",JLabel.CENTER);
  b21.setFont(new Font("Century", Font.BOLD, 25));
  b22.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p2=new JPanel(); 
  p2.setLayout(new GridLayout(2,1));
  p2.add(b21);
  p2.add(b22);
  p2.setSize(300, 150);
  p2.setBackground(c2);
  p2.setLocation(305,75);

  b31=new JLabel("3",JLabel.CENTER);
  b32=new JLabel("su¨¤nt¨¢i r¨°us¨©",JLabel.CENTER);
  b31.setFont(new Font("Century", Font.BOLD, 25));
  b32.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p3=new JPanel(); 
  p3.setLayout(new GridLayout(2,1));
  p3.add(b31);
  p3.add(b32);
  p3.setSize(300, 150);
  p3.setBackground(c3);
  p3.setLocation(605,75);

  b41=new JLabel("4",JLabel.CENTER);
  b42=new JLabel("j¨©ngji¨¤ng r¨°us¨©",JLabel.CENTER);
  b41.setFont(new Font("Century", Font.BOLD, 25));
  b42.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p4=new JPanel(); 
  p4.setLayout(new GridLayout(2,1));
  p4.add(b41);
  p4.add(b42);
  p4.setSize(300, 150);
  p4.setBackground(c4);
  p4.setLocation(5,225);

  b51=new JLabel("5",JLabel.CENTER);
  b52=new JLabel("c¨´li¨± xi¨£opa¨ª",JLabel.CENTER);
  b51.setFont(new Font("Century", Font.BOLD, 25));
  b52.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p5=new JPanel(); 
  p5.setLayout(new GridLayout(2,1));
  p5.add(b51);
  p5.add(b52);
  p5.setSize(300, 150);
  p5.setBackground(c5);
  p5.setLocation(305,225);

  b61=new JLabel("6",JLabel.CENTER);
  b62=new JLabel("q¨©ngji¨¡o ch¨£or¨°u",JLabel.CENTER);
  b61.setFont(new Font("Century", Font.BOLD, 25));
  b62.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p6=new JPanel(); 
  p6.setLayout(new GridLayout(2,1));
  p6.add(b61);
  p6.add(b62);
  p6.setSize(300, 150);
  p6.setBackground(c6);
  p6.setLocation(605,225);
  
  robotPanel = new JPanel();
  robotPanel.setLayout(null);
  robotPanel.add(p0);
  robotPanel.add(p1);
  robotPanel.add(p2);
  robotPanel.add(p3);
  robotPanel.add(p4);
  robotPanel.add(p5);
  robotPanel.add(p6);
  robotPanel.add(p7);
  robotPanel.setBackground(c7);
  
  robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  robotFrame.getContentPane().add(robotPanel);  
  robotFrame.getContentPane().setBackground(c7);
  robotFrame.setLocation(width,height);
  robotFrame.setSize(935,525);
  robotFrame.setVisible(true);
  
  robotTextField.addActionListener(new Order2());
  }
/*
**This is the rice order
*/  
  public void order3(){

  JLabel l1, l2;
  JLabel b11, b12, b21, b22, b31, b32;
  JLabel b41, b42, b51, b52, b61, b62;
  JPanel p0,p1, p2, p3, p4, p5, p6, p7;

  l1=new JLabel("Please select a dish to order:", Label.LEFT);
  l1.setFont(new Font("Century", Font.BOLD, 23));
  l1.setSize(350,75);
  l1.setBackground(c7);
  p7=new JPanel();
  p7.setLayout(null);
  p7.add(l1);
  p7.setSize(350, 75);
  p7.setBackground(c7);
  p7.setLocation(5,0);

  robotTextField=new JTextField("",200);
  l2=new JLabel("Operation selected:");
  l2.setFont(new Font("Century", Font.BOLD, 23));
  l2.setHorizontalTextPosition(JLabel.RIGHT);
  l2.setVerticalTextPosition(JLabel.TOP);
  p0=new JPanel();
  p0.setLayout(new GridLayout(1,2));
  p0.add(l2);
  p0.add(robotTextField);
  p0.setSize(500, 50);
  p0.setBackground(c7);
  p0.setLocation(405,400);


  b11=new JLabel("1",JLabel.CENTER);
  b12=new JLabel("h¨®ng ch¨¢ng ch¨£of¨¤n",JLabel.CENTER);
  b11.setFont(new Font("Century", Font.BOLD, 25));
  b12.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p1=new JPanel();
  p1.setLayout(new GridLayout(2,1));
  p1.add(b11);
  p1.add(b12);
  p1.setSize(300, 150);
  p1.setBackground(c1);
  p1.setLocation(5,75);

  b21=new JLabel("2",JLabel.CENTER);
  b22=new JLabel("hu¨¢ngj¨©n d¨¤ p¨¢i f¨¤n",JLabel.CENTER);
  b21.setFont(new Font("Century", Font.BOLD, 25));
  b22.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p2=new JPanel(); 
  p2.setLayout(new GridLayout(2,1));
  p2.add(b21);
  p2.add(b22);
  p2.setSize(300, 150);
  p2.setBackground(c2);
  p2.setLocation(305,75);

  b31=new JLabel("3",JLabel.CENTER);
  b32=new JLabel("hu¨¯tu¨« ch¨£of¨¤n",JLabel.CENTER);
  b31.setFont(new Font("Century", Font.BOLD, 25));
  b32.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p3=new JPanel(); 
  p3.setLayout(new GridLayout(2,1));
  p3.add(b31);
  p3.add(b32);
  p3.setSize(300, 150);
  p3.setBackground(c3);
  p3.setLocation(605,75);


  b41=new JLabel("4",JLabel.CENTER);
  b42=new JLabel("q¨©ngji¨¡o ni¨²r¨°u d¨¤nch¨£of¨¤n",JLabel.CENTER);
  b41.setFont(new Font("Century", Font.BOLD, 25));
  b42.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p4=new JPanel(); 
  p4.setLayout(new GridLayout(2,1));
  p4.add(b41);
  p4.add(b42);
  p4.setSize(300, 150);
  p4.setBackground(c4);
  p4.setLocation(5,225);

  b51=new JLabel("5",JLabel.CENTER);
  b52=new JLabel("sh¨¥ngc¨¤i ni¨²r¨°u ch¨£of¨¤n",JLabel.CENTER);
  b51.setFont(new Font("Century", Font.BOLD, 25));
  b52.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p5=new JPanel(); 
  p5.setLayout(new GridLayout(2,1));
  p5.add(b51);
  p5.add(b52);
  p5.setSize(300, 150);
  p5.setBackground(c5);
  p5.setLocation(305,225);

  b61=new JLabel("6",JLabel.CENTER);
  b62=new JLabel("y¨¢ngzh¨­u ch¨£of¨¤n",JLabel.CENTER);
  b61.setFont(new Font("Century", Font.BOLD, 25));
  b62.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p6=new JPanel(); 
  p6.setLayout(new GridLayout(2,1));
  p6.add(b61);
  p6.add(b62);
  p6.setSize(300, 150);
  p6.setBackground(c6);
  p6.setLocation(605,225);
  
  robotPanel = new JPanel();
  robotPanel.setLayout(null);
  robotPanel.add(p0);
  robotPanel.add(p1);
  robotPanel.add(p2);
  robotPanel.add(p3);
  robotPanel.add(p4);
  robotPanel.add(p5);
  robotPanel.add(p6);
  robotPanel.add(p7);
  robotPanel.setBackground(c7);
  
  robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  robotFrame.getContentPane().add(robotPanel);  
  robotFrame.getContentPane().setBackground(c7);
  robotFrame.setLocation(width,height);
  robotFrame.setSize(935,525);
  robotFrame.setVisible(true);
  
  robotTextField.addActionListener(new Order3());
  }
  public class Order3 implements ActionListener{
	public void actionPerformed(ActionEvent e) { 
	  robotPanel.removeAll();
	  timer.cancel();
	  sleepMethod();
	  textFieldInput = "0";
	  
	   textFieldInput = robotTextField.getText();
	   if(textFieldInput.equals("1"))
		   dishSelected = 1;
	   else if(textFieldInput.equals("2"))
		   dishSelected = 2;
           else if(textFieldInput.equals("3"))
		   dishSelected = 3;
	   else if(textFieldInput.equals("4"))
		   dishSelected = 4;
	   else if(textFieldInput.equals("5"))
		   dishSelected = 5;
	   else if(textFieldInput.equals("6"))
		   dishSelected = 6;
	   else{
		   wrongOrder3();
		   dishSelected = 0;
	   }
	   
	  dishSelected = Integer.parseInt(textFieldInput);
	  FileReader fr;
	  BufferedReader br = null;
          dish=new ArrayList<String>();
	  
      try{
	    fr = new FileReader("RiceDishes.txt");
            br = new BufferedReader(fr);
	  
	    for (int i=0;i<19;i++){
	      dish.add(br.readLine());
        }
	    
        br.close();
        fr.close(); 

      }catch (IOException event) { 
	       
      } 
	
	  dishNum = Integer.parseInt(dish.get(3*dishSelected));
	  dishMoney = Integer.parseInt(dish.get(3*dishSelected-1));
	  
	  if (dishNum>0)
	    dishInformation();
	  else
	    order1Unavailable();
	}
  }

  public void wrongOrder3(){

  JLabel l1, l2;
  JLabel b11, b12, b21, b22, b31, b32;
  JLabel b41, b42, b51, b52, b61, b62;
  JPanel p0,p1, p2, p3, p4, p5, p6, p7;

  l1=new JLabel("!Wrong number, please select again:", Label.LEFT);
  l1.setFont(new Font("Century", Font.BOLD, 23));
  l1.setSize(425,75);
  l1.setBackground(c7);
  p7=new JPanel();
  p7.setLayout(null);
  p7.add(l1);
  p7.setSize(425, 75);
  p7.setBackground(c7);
  p7.setLocation(5,0);

  robotTextField=new JTextField("",200);
  l2=new JLabel("Operation selected:");
  l2.setFont(new Font("Century", Font.BOLD, 23));
  l2.setHorizontalTextPosition(JLabel.RIGHT);
  l2.setVerticalTextPosition(JLabel.TOP);
  p0=new JPanel();
  p0.setLayout(new GridLayout(1,2));
  p0.add(l2);
  p0.add(robotTextField);
  p0.setSize(500, 50);
  p0.setBackground(c7);
  p0.setLocation(405,400);


  b11=new JLabel("1",JLabel.CENTER);
  b12=new JLabel("h¨®ng ch¨¢ng ch¨£of¨¤n",JLabel.CENTER);
  b11.setFont(new Font("Century", Font.BOLD, 25));
  b12.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p1=new JPanel();
  p1.setLayout(new GridLayout(2,1));
  p1.add(b11);
  p1.add(b12);
  p1.setSize(300, 150);
  p1.setBackground(c1);
  p1.setLocation(5,75);

  b21=new JLabel("2",JLabel.CENTER);
  b22=new JLabel("hu¨¢ngj¨©n d¨¤ p¨¢i f¨¤n",JLabel.CENTER);
  b21.setFont(new Font("Century", Font.BOLD, 25));
  b22.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p2=new JPanel(); 
  p2.setLayout(new GridLayout(2,1));
  p2.add(b21);
  p2.add(b22);
  p2.setSize(300, 150);
  p2.setBackground(c2);
  p2.setLocation(305,75);

  b31=new JLabel("3",JLabel.CENTER);
  b32=new JLabel("hu¨¯tu¨« ch¨£of¨¤n",JLabel.CENTER);
  b31.setFont(new Font("Century", Font.BOLD, 25));
  b32.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p3=new JPanel(); 
  p3.setLayout(new GridLayout(2,1));
  p3.add(b31);
  p3.add(b32);
  p3.setSize(300, 150);
  p3.setBackground(c3);
  p3.setLocation(605,75);


  b41=new JLabel("4",JLabel.CENTER);
  b42=new JLabel("q¨©ngji¨¡o ni¨²r¨°u d¨¤nch¨£of¨¤n",JLabel.CENTER);
  b41.setFont(new Font("Century", Font.BOLD, 25));
  b42.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p4=new JPanel(); 
  p4.setLayout(new GridLayout(2,1));
  p4.add(b41);
  p4.add(b42);
  p4.setSize(300, 150);
  p4.setBackground(c4);
  p4.setLocation(5,225);

  b51=new JLabel("5",JLabel.CENTER);
  b52=new JLabel("sh¨¥ngc¨¤i ni¨²r¨°u ch¨£of¨¤n",JLabel.CENTER);
  b51.setFont(new Font("Century", Font.BOLD, 25));
  b52.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p5=new JPanel(); 
  p5.setLayout(new GridLayout(2,1));
  p5.add(b51);
  p5.add(b52);
  p5.setSize(300, 150);
  p5.setBackground(c5);
  p5.setLocation(305,225);

  b61=new JLabel("6",JLabel.CENTER);
  b62=new JLabel("y¨¢ngzh¨­u ch¨£of¨¤n",JLabel.CENTER);
  b61.setFont(new Font("Century", Font.BOLD, 25));
  b62.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p6=new JPanel(); 
  p6.setLayout(new GridLayout(2,1));
  p6.add(b61);
  p6.add(b62);
  p6.setSize(300, 150);
  p6.setBackground(c6);
  p6.setLocation(605,225);
  
  robotPanel = new JPanel();
  robotPanel.setLayout(null);
  robotPanel.add(p0);
  robotPanel.add(p1);
  robotPanel.add(p2);
  robotPanel.add(p3);
  robotPanel.add(p4);
  robotPanel.add(p5);
  robotPanel.add(p6);
  robotPanel.add(p7);
  robotPanel.setBackground(c7);
  
  robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  robotFrame.getContentPane().add(robotPanel);  
  robotFrame.getContentPane().setBackground(c7);
  robotFrame.setLocation(width,height);
  robotFrame.setSize(935,525);
  robotFrame.setVisible(true);
  
  robotTextField.addActionListener(new Order3());
  }
/*
**This is the noodle order
*/  
  public void order4(){

  JLabel l1, l2;
  JLabel b11, b12, b21, b22, b31, b32;
  JLabel b41, b42, b51, b52, b61, b62;
  JPanel p0,p1, p2, p3, p4, p5, p6, p7;

  l1=new JLabel("Please select a dish to order:", Label.LEFT);
  l1.setFont(new Font("Century", Font.BOLD, 23));
  l1.setSize(350,75);
  l1.setBackground(c7);
  p7=new JPanel();
  p7.setLayout(null);
  p7.add(l1);
  p7.setSize(350, 75);
  p7.setBackground(c7);
  p7.setLocation(5,0);

  robotTextField=new JTextField("",200);
  l2=new JLabel("Operation selected:");
  l2.setFont(new Font("Century", Font.BOLD, 23));
  l2.setHorizontalTextPosition(JLabel.RIGHT);
  l2.setVerticalTextPosition(JLabel.TOP);
  p0=new JPanel();
  p0.setLayout(new GridLayout(1,2));
  p0.add(l2);
  p0.add(robotTextField);
  p0.setSize(500, 50);
  p0.setBackground(c7);
  p0.setLocation(405,400);

  b11=new JLabel("1",JLabel.CENTER);
  b12=new JLabel("mi¨¤nti¨¢o",JLabel.CENTER);
  b11.setFont(new Font("Century", Font.BOLD, 25));
  b12.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p1=new JPanel();
  p1.setLayout(new GridLayout(2,1));
  p1.add(b11);
  p1.add(b12);
  p1.setSize(300, 150);
  p1.setBackground(c1);
  p1.setLocation(5,75);

  b21=new JLabel("2",JLabel.CENTER);
  b22=new JLabel("ch¨£omi¨¤n",JLabel.CENTER);
  b21.setFont(new Font("Century", Font.BOLD, 25));
  b22.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p2=new JPanel(); 
  p2.setLayout(new GridLayout(2,1));
  p2.add(b21);
  p2.add(b22);
  p2.setSize(300, 150);
  p2.setBackground(c2);
  p2.setLocation(305,75);

  b31=new JLabel("3",JLabel.CENTER);
  b32=new JLabel("t¨¡ngmi¨¤n",JLabel.CENTER);
  b31.setFont(new Font("Century", Font.BOLD, 25));
  b32.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p3=new JPanel(); 
  p3.setLayout(new GridLayout(2,1));
  p3.add(b31);
  p3.add(b32);
  p3.setSize(300, 150);
  p3.setBackground(c3);
  p3.setLocation(605,75);


  b41=new JLabel("4",JLabel.CENTER);
  b42=new JLabel("ch¨¥z¨£i mi¨¤n",JLabel.CENTER);
  b41.setFont(new Font("Century", Font.BOLD, 25));
  b42.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p4=new JPanel(); 
  p4.setLayout(new GridLayout(2,1));
  p4.add(b41);
  p4.add(b42);
  p4.setSize(300, 150);
  p4.setBackground(c4);
  p4.setLocation(5,225);

  b51=new JLabel("5",JLabel.CENTER);
  b52=new JLabel("ch¨®ngq¨¬ng xi¨£omi¨¤n",JLabel.CENTER);
  b51.setFont(new Font("Century", Font.BOLD, 25));
  b52.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p5=new JPanel(); 
  p5.setLayout(new GridLayout(2,1));
  p5.add(b51);
  p5.add(b52);
  p5.setSize(300, 150);
  p5.setBackground(c5);
  p5.setLocation(305,225);

  b61=new JLabel("6",JLabel.CENTER);
  b62=new JLabel("gu¨¤ngu¨¤n mi¨¤n",JLabel.CENTER);
  b61.setFont(new Font("Century", Font.BOLD, 25));
  b62.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p6=new JPanel(); 
  p6.setLayout(new GridLayout(2,1));
  p6.add(b61);
  p6.add(b62);
  p6.setSize(300, 150);
  p6.setBackground(c6);
  p6.setLocation(605,225);
  
  robotPanel = new JPanel();
  robotPanel.setLayout(null);
  robotPanel.add(p0);
  robotPanel.add(p1);
  robotPanel.add(p2);
  robotPanel.add(p3);
  robotPanel.add(p4);
  robotPanel.add(p5);
  robotPanel.add(p6);
  robotPanel.add(p7);
  robotPanel.setBackground(c7);
  
  robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  robotFrame.getContentPane().add(robotPanel);  
  robotFrame.getContentPane().setBackground(c7);
  robotFrame.setLocation(width,height);
  robotFrame.setSize(935,525);
  robotFrame.setVisible(true);
  
  robotTextField.addActionListener(new Order4());
  }
  public class Order4 implements ActionListener{
	public void actionPerformed(ActionEvent e) { 
	  robotPanel.removeAll();
	  timer.cancel();
	  sleepMethod();
	  
	   textFieldInput = "0";
           textFieldInput = robotTextField.getText();
	   if(textFieldInput.equals("1"))
		   dishSelected = 1;
	   else if(textFieldInput.equals("2"))
		   dishSelected = 2;
           else if(textFieldInput.equals("3"))
		   dishSelected = 3;
	   else if(textFieldInput.equals("4"))
		   dishSelected = 4;
	   else if(textFieldInput.equals("5"))
		   dishSelected = 5;
	   else if(textFieldInput.equals("6"))
		   dishSelected = 6;
	   else{
		   wrongOrder4();
		   dishSelected = 0;
	   }
	   
	  dishSelected = Integer.parseInt(textFieldInput);
	  FileReader fr;
	  BufferedReader br = null;
          dish=new ArrayList<String>();
	  
      try{
	    fr = new FileReader("NoodleDishes.txt");
            br = new BufferedReader(fr);
	  
	    for (int i=0;i<19;i++){
	      dish.add(br.readLine());
        }
	    
        br.close();
        fr.close(); 

      }catch (IOException event) { 
	       
      } 
	
	  dishNum = Integer.parseInt(dish.get(3*dishSelected));
	  dishMoney = Integer.parseInt(dish.get(3*dishSelected-1));
	  
	  if (dishNum>0)
	    dishInformation();
	  else
	    order1Unavailable();
	}
  }

  public void wrongOrder4(){

  JLabel l1, l2;
  JLabel b11, b12, b21, b22, b31, b32;
  JLabel b41, b42, b51, b52, b61, b62;
  JPanel p0,p1, p2, p3, p4, p5, p6, p7;

  l1=new JLabel("!Wrong number, please select again:", Label.LEFT);
  l1.setFont(new Font("Century", Font.BOLD, 23));
  l1.setSize(425,75);
  l1.setBackground(c7);
  p7=new JPanel();
  p7.setLayout(null);
  p7.add(l1);
  p7.setSize(425, 75);
  p7.setBackground(c7);
  p7.setLocation(5,0);

  robotTextField=new JTextField("",200);
  l2=new JLabel("Operation selected:");
  l2.setFont(new Font("Century", Font.BOLD, 23));
  l2.setHorizontalTextPosition(JLabel.RIGHT);
  l2.setVerticalTextPosition(JLabel.TOP);
  p0=new JPanel();
  p0.setLayout(new GridLayout(1,2));
  p0.add(l2);
  p0.add(robotTextField);
  p0.setSize(500, 50);
  p0.setBackground(c7);
  p0.setLocation(405,400);

  b11=new JLabel("1",JLabel.CENTER);
  b12=new JLabel("mi¨¤nti¨¢o",JLabel.CENTER);
  b11.setFont(new Font("Century", Font.BOLD, 25));
  b12.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p1=new JPanel();
  p1.setLayout(new GridLayout(2,1));
  p1.add(b11);
  p1.add(b12);
  p1.setSize(300, 150);
  p1.setBackground(c1);
  p1.setLocation(5,75);

  b21=new JLabel("2",JLabel.CENTER);
  b22=new JLabel("ch¨£omi¨¤n",JLabel.CENTER);
  b21.setFont(new Font("Century", Font.BOLD, 25));
  b22.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p2=new JPanel(); 
  p2.setLayout(new GridLayout(2,1));
  p2.add(b21);
  p2.add(b22);
  p2.setSize(300, 150);
  p2.setBackground(c2);
  p2.setLocation(305,75);

  b31=new JLabel("3",JLabel.CENTER);
  b32=new JLabel("t¨¡ngmi¨¤n",JLabel.CENTER);
  b31.setFont(new Font("Century", Font.BOLD, 25));
  b32.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p3=new JPanel(); 
  p3.setLayout(new GridLayout(2,1));
  p3.add(b31);
  p3.add(b32);
  p3.setSize(300, 150);
  p3.setBackground(c3);
  p3.setLocation(605,75);


  b41=new JLabel("4",JLabel.CENTER);
  b42=new JLabel("ch¨¥z¨£i mi¨¤n",JLabel.CENTER);
  b41.setFont(new Font("Century", Font.BOLD, 25));
  b42.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p4=new JPanel(); 
  p4.setLayout(new GridLayout(2,1));
  p4.add(b41);
  p4.add(b42);
  p4.setSize(300, 150);
  p4.setBackground(c4);
  p4.setLocation(5,225);

  b51=new JLabel("5",JLabel.CENTER);
  b52=new JLabel("ch¨®ngq¨¬ng xi¨£omi¨¤n",JLabel.CENTER);
  b51.setFont(new Font("Century", Font.BOLD, 25));
  b52.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p5=new JPanel(); 
  p5.setLayout(new GridLayout(2,1));
  p5.add(b51);
  p5.add(b52);
  p5.setSize(300, 150);
  p5.setBackground(c5);
  p5.setLocation(305,225);

  b61=new JLabel("6",JLabel.CENTER);
  b62=new JLabel("gu¨¤ngu¨¤n mi¨¤n",JLabel.CENTER);
  b61.setFont(new Font("Century", Font.BOLD, 25));
  b62.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p6=new JPanel(); 
  p6.setLayout(new GridLayout(2,1));
  p6.add(b61);
  p6.add(b62);
  p6.setSize(300, 150);
  p6.setBackground(c6);
  p6.setLocation(605,225);
  
  robotPanel = new JPanel();
  robotPanel.setLayout(null);
  robotPanel.add(p0);
  robotPanel.add(p1);
  robotPanel.add(p2);
  robotPanel.add(p3);
  robotPanel.add(p4);
  robotPanel.add(p5);
  robotPanel.add(p6);
  robotPanel.add(p7);
  robotPanel.setBackground(c7);
  
  robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  robotFrame.getContentPane().add(robotPanel);  
  robotFrame.getContentPane().setBackground(c7);
  robotFrame.setLocation(width,height);
  robotFrame.setSize(935,525);
  robotFrame.setVisible(true);
  
  robotTextField.addActionListener(new Order4());
  }
/*
**This is the drink order
*/  
  public void order5(){

  JLabel l1, l2;
  JLabel b11, b12, b21, b22, b31, b32;
  JLabel b41, b42, b51, b52, b61, b62;
  JPanel p0,p1, p2, p3, p4, p5, p6, p7;

  l1=new JLabel("Please select a dish to order:", Label.LEFT);
  l1.setFont(new Font("Century", Font.BOLD, 23));
  l1.setSize(350,75);
  l1.setBackground(c7);
  p7=new JPanel();
  p7.setLayout(null);
  p7.add(l1);
  p7.setSize(350, 75);
  p7.setBackground(c7);
  p7.setLocation(5,0);

  robotTextField=new JTextField("",200);
  l2=new JLabel("Operation selected:");
  l2.setFont(new Font("Century", Font.BOLD, 23));
  l2.setHorizontalTextPosition(JLabel.RIGHT);
  l2.setVerticalTextPosition(JLabel.TOP);
  p0=new JPanel();
  p0.setLayout(new GridLayout(1,2));
  p0.add(l2);
  p0.add(robotTextField);
  p0.setSize(500, 50);
  p0.setBackground(c7);
  p0.setLocation(405,400);

  b11=new JLabel("1",JLabel.CENTER);
  b12=new JLabel("l¨¸ch¨¢",JLabel.CENTER);
  b11.setFont(new Font("Century", Font.BOLD, 25));
  b12.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p1=new JPanel();
  p1.setLayout(new GridLayout(2,1));
  p1.add(b11);
  p1.add(b12);
  p1.setSize(300, 150);
  p1.setBackground(c1);
  p1.setLocation(5,75);

  b21=new JLabel("2",JLabel.CENTER);
  b22=new JLabel("h¨®ngch¨¢",JLabel.CENTER);
  b21.setFont(new Font("Century", Font.BOLD, 25));
  b22.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p2=new JPanel(); 
  p2.setLayout(new GridLayout(2,1));
  p2.add(b21);
  p2.add(b22);
  p2.setSize(300, 150);
  p2.setBackground(c2);
  p2.setLocation(305,75);

  b31=new JLabel("3",JLabel.CENTER);
  b32=new JLabel("m¨°l¨¬hu¨¡ ch¨¢",JLabel.CENTER);
  b31.setFont(new Font("Century", Font.BOLD, 25));
  b32.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p3=new JPanel(); 
  p3.setLayout(new GridLayout(2,1));
  p3.add(b31);
  p3.add(b32);
  p3.setSize(300, 150);
  p3.setBackground(c3);
  p3.setLocation(605,75);

  b41=new JLabel("4",JLabel.CENTER);
  b42=new JLabel("k¨§l¨¨",JLabel.CENTER);
  b41.setFont(new Font("Century", Font.BOLD, 25));
  b42.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p4=new JPanel(); 
  p4.setLayout(new GridLayout(2,1));
  p4.add(b41);
  p4.add(b42);
  p4.setSize(300, 150);
  p4.setBackground(c4);
  p4.setLocation(5,225);

  b51=new JLabel("5",JLabel.CENTER);
  b52=new JLabel("k¨¡f¨¥i",JLabel.CENTER);
  b51.setFont(new Font("Century", Font.BOLD, 25));
  b52.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p5=new JPanel(); 
  p5.setLayout(new GridLayout(2,1));
  p5.add(b51);
  p5.add(b52);
  p5.setSize(300, 150);
  p5.setBackground(c5);
  p5.setLocation(305,225);

  b61=new JLabel("6",JLabel.CENTER);
  b62=new JLabel("ch¨¦ngzh¨©",JLabel.CENTER);
  b61.setFont(new Font("Century", Font.BOLD, 25));
  b62.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p6=new JPanel(); 
  p6.setLayout(new GridLayout(2,1));
  p6.add(b61);
  p6.add(b62);
  p6.setSize(300, 150);
  p6.setBackground(c6);
  p6.setLocation(605,225);
  
  robotPanel = new JPanel();
  robotPanel.setLayout(null);
  robotPanel.add(p0);
  robotPanel.add(p1);
  robotPanel.add(p2);
  robotPanel.add(p3);
  robotPanel.add(p4);
  robotPanel.add(p5);
  robotPanel.add(p6);
  robotPanel.add(p7);
  robotPanel.setBackground(c7);
  
  robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  robotFrame.getContentPane().add(robotPanel);  
  robotFrame.getContentPane().setBackground(c7);
  robotFrame.setLocation(width,height);
  robotFrame.setSize(935,525);
  robotFrame.setVisible(true);
  
  robotTextField.addActionListener(new Order5());
  }
  public class Order5 implements ActionListener{
	public void actionPerformed(ActionEvent e) { 
	  robotPanel.removeAll();
	  timer.cancel();
	  sleepMethod();
	  
	   textFieldInput = "0";
	   textFieldInput = robotTextField.getText();
	   if(textFieldInput.equals("1"))
		   dishSelected = 1;
	   else if(textFieldInput.equals("2"))
		   dishSelected = 2;
           else if(textFieldInput.equals("3"))
		   dishSelected = 3;
	   else if(textFieldInput.equals("4"))
		   dishSelected = 4;
	   else if(textFieldInput.equals("5"))
		   dishSelected = 5;
	   else if(textFieldInput.equals("6"))
		   dishSelected = 6;
	   else{
		   wrongOrder5();
		   dishSelected = 0;
	   }
	   
	  dishSelected = Integer.parseInt(textFieldInput);
	  FileReader fr;
	  BufferedReader br = null;
          dish=new ArrayList<String>();
	  
      try{
	    fr = new FileReader("DrinkDishes.txt");
            br = new BufferedReader(fr);
	  
	    for (int i=0;i<19;i++){
	    dish.add(br.readLine());
        }
	    
        br.close();
        fr.close(); 

      }catch (IOException event) { 
	       
      } 
	
	  dishNum = Integer.parseInt(dish.get(3*dishSelected));
	  dishMoney = Integer.parseInt(dish.get(3*dishSelected-1));
	  
	  if (dishNum>0)
	    dishInformation();
	  else
	    order1Unavailable();
	}
  }
  
  public void wrongOrder5(){

  JLabel l1, l2;
  JLabel b11, b12, b21, b22, b31, b32;
  JLabel b41, b42, b51, b52, b61, b62;
  JPanel p0,p1, p2, p3, p4, p5, p6, p7;

  l1=new JLabel("!Wrong number, please select again:", Label.LEFT);
  l1.setFont(new Font("Century", Font.BOLD, 23));
  l1.setSize(425,75);
  l1.setBackground(c7);
  p7=new JPanel();
  p7.setLayout(null);
  p7.add(l1);
  p7.setSize(425, 75);
  p7.setBackground(c7);
  p7.setLocation(5,0);

  robotTextField=new JTextField("",200);
  l2=new JLabel("Operation selected:");
  l2.setFont(new Font("Century", Font.BOLD, 23));
  l2.setHorizontalTextPosition(JLabel.RIGHT);
  l2.setVerticalTextPosition(JLabel.TOP);
  p0=new JPanel();
  p0.setLayout(new GridLayout(1,2));
  p0.add(l2);
  p0.add(robotTextField);
  p0.setSize(500, 50);
  p0.setBackground(c7);
  p0.setLocation(405,400);

  b11=new JLabel("1",JLabel.CENTER);
  b12=new JLabel("l¨¸ch¨¢",JLabel.CENTER);
  b11.setFont(new Font("Century", Font.BOLD, 25));
  b12.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p1=new JPanel();
  p1.setLayout(new GridLayout(2,1));
  p1.add(b11);
  p1.add(b12);
  p1.setSize(300, 150);
  p1.setBackground(c1);
  p1.setLocation(5,75);

  b21=new JLabel("2",JLabel.CENTER);
  b22=new JLabel("h¨®ngch¨¢",JLabel.CENTER);
  b21.setFont(new Font("Century", Font.BOLD, 25));
  b22.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p2=new JPanel(); 
  p2.setLayout(new GridLayout(2,1));
  p2.add(b21);
  p2.add(b22);
  p2.setSize(300, 150);
  p2.setBackground(c2);
  p2.setLocation(305,75);

  b31=new JLabel("3",JLabel.CENTER);
  b32=new JLabel("m¨°l¨¬hu¨¡ ch¨¢",JLabel.CENTER);
  b31.setFont(new Font("Century", Font.BOLD, 25));
  b32.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p3=new JPanel(); 
  p3.setLayout(new GridLayout(2,1));
  p3.add(b31);
  p3.add(b32);
  p3.setSize(300, 150);
  p3.setBackground(c3);
  p3.setLocation(605,75);

  b41=new JLabel("4",JLabel.CENTER);
  b42=new JLabel("k¨§l¨¨",JLabel.CENTER);
  b41.setFont(new Font("Century", Font.BOLD, 25));
  b42.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p4=new JPanel(); 
  p4.setLayout(new GridLayout(2,1));
  p4.add(b41);
  p4.add(b42);
  p4.setSize(300, 150);
  p4.setBackground(c4);
  p4.setLocation(5,225);

  b51=new JLabel("5",JLabel.CENTER);
  b52=new JLabel("k¨¡f¨¥i",JLabel.CENTER);
  b51.setFont(new Font("Century", Font.BOLD, 25));
  b52.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p5=new JPanel(); 
  p5.setLayout(new GridLayout(2,1));
  p5.add(b51);
  p5.add(b52);
  p5.setSize(300, 150);
  p5.setBackground(c5);
  p5.setLocation(305,225);

  b61=new JLabel("6",JLabel.CENTER);
  b62=new JLabel("ch¨¦ngzh¨©",JLabel.CENTER);
  b61.setFont(new Font("Century", Font.BOLD, 25));
  b62.setFont(new Font("Calibri Light", Font.BOLD, 23));
  p6=new JPanel(); 
  p6.setLayout(new GridLayout(2,1));
  p6.add(b61);
  p6.add(b62);
  p6.setSize(300, 150);
  p6.setBackground(c6);
  p6.setLocation(605,225);
  
  robotPanel = new JPanel();
  robotPanel.setLayout(null);
  robotPanel.add(p0);
  robotPanel.add(p1);
  robotPanel.add(p2);
  robotPanel.add(p3);
  robotPanel.add(p4);
  robotPanel.add(p5);
  robotPanel.add(p6);
  robotPanel.add(p7);
  robotPanel.setBackground(c7);
  
  robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  robotFrame.getContentPane().add(robotPanel);  
  robotFrame.getContentPane().setBackground(c7);
  robotFrame.setLocation(width,height);
  robotFrame.setSize(935,525);
  robotFrame.setVisible(true);
  
  robotTextField.addActionListener(new Order5());
  }
  
/*
**This is the method
**to make the robot sleep
**if no action is taken
**within 30 seconds
*/
  public void sleepMethod(){
	  JButton b1;
	  
	  b1 = new JButton("SLEEPING ZZZ...");
	  b1.setBackground(c3);
	  b1.setSize(935,525);
	  b1.setLocation(0,0);
	  b1.setFont(new Font("Calibri Light", Font.BOLD, 25));
	  
	  try{
	  timer = new Timer();
	  timer.scheduleAtFixedRate(new TimerTask(){
	    public void run(){
	      sleepFrame = new JFrame();
	      sleepFrame.setLocation(width,height);
	      sleepFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
              sleepFrame.getContentPane().add(b1);  
              sleepFrame.getContentPane().setBackground(c6);
              sleepFrame.setSize(935,525);
              sleepFrame.setVisible(true);
	      }
	      }, 30000, 30000);
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  
	  b1.addActionListener(new SleepMethod());
  }
  public class SleepMethod implements ActionListener{
	  public void actionPerformed(ActionEvent e) {
		  sleepFrame.dispose();
		  timer.cancel();   //end the timer
		  sleepMethod();
	  }
  }
    public void actionPerformed(ActionEvent event){

  }
  
  public static void main(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    RobotGUI robot = new RobotGUI();
    robot.startWelcome();
    robot.sleepMethod();

  }

} 