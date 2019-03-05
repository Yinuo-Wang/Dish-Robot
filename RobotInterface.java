/**
***This is a program 
***to help the customers
***interact with the robot
***
***@Auther WANG Yinuo
***@Student Number 140920440
***@Date June 3rd;
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

public class RobotInterface{
    
/*
**This method is
**to read welcome message
*/
  public String istartWelcome(){

    BufferedReader br = null;
    FileReader fr; 

    String welcomeLine;
    welcomeLine = null;
    String a;
    a = null;
    int i=0;
    int x;
    x = (int)(Math.random()*3)+1;
	
    try{
      fr = new FileReader("WelcomeMessage.txt");
      br = new BufferedReader(fr);
	  
	  for (i=0;i<=3;i++){
		  welcomeLine = br.readLine();
		  if (i == x)
			  a = welcomeLine;
      }  
	    
    br.close();
    fr.close(); 

    }catch (IOException e) { 
    } 
    
    return a;

  }

/*
**This method is
**to read joke message
*/
  public String itellJokes(){
    BufferedReader br = null;
    FileReader fr; 

    String joke;
    joke = null;
    String a;
    a = null;
    int x;
    x = (int)(Math.random()*3)+1;
	
    try{
      fr = new FileReader("Jokes.txt");
      br = new BufferedReader(fr);
	  
	  for (int i=0;i<=3;i++){
		  joke = br.readLine();
		  if (i == x)
			  a = joke;
      }  
	    
    br.close();
    fr.close(); 

    }catch (IOException e) { 
    } 
   
    return a;
  }

/*
**This method is
**to read farewell message
*/
  public String ifareWell(){
    BufferedReader br = null;
    FileReader fr; 
    String fareWell;
    fareWell = null;
    String a;
    a = null;
    int x;
    x = (int)(Math.random()*3)+1;
	
    try{
      fr = new FileReader("FarewellMessage.txt");
      br = new BufferedReader(fr);
	  
	  for (int i=0;i<=3;i++){
		  fareWell = br.readLine();
		  if (i == x)
			  a = fareWell;
      }  
	    
    br.close();
    fr.close(); 

    }catch (IOException e) { 
    } 

    return a;
  }
}