import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;





public class PanelSwap extends JPanel implements ActionListener {
    static JFrame frame = new JFrame("Payment Panel");
    static boolean size = false;
	//student number panel
    JPanel firstPanel = new JPanel();
    
	//pin number panel 
    JPanel secondPanel = new JPanel();
    
    //email Address panel 
    JPanel thirdPanel = new JPanel();
    
    // Confirmation Confirmation 
    JPanel forthPanel = new JPanel();
    
    // splash page ( *click anywhere page)
    JPanel spalsh = new JPanel();
    
    
    /** start of inner panels for within Confirmation (* forth ) panel   */
    JPanel confirmPanel = new JPanel();
    JPanel studentPanel = new JPanel();
    JPanel emailPanel = new JPanel();
    JPanel pinPanel = new JPanel();
    JPanel buttonPanel = new JPanel(); 
    JPanel infoPanel = new JPanel();
    /** end of inner panels for within Confirmation panel   */
    
    
    // Labels for student number , pin number , and email address( in order ).
   	private JLabel studentPlaceHolder;
	private JLabel pinPlaceHolder;
	private JLabel emailPlaceHolder;
	
	//Confirmation panel  labels
	private JLabel studentPlaceHolderC;
	private JLabel pinPlaceHolderC;
	private JLabel emailPlaceHolderC;
	private JLabel confirmLabel;
	

	 // text fields  for student number , pin number , and email address( in order ).
	private JTextField student;
	private JPasswordField pin;
	private JTextField email;

	private JTextField studentC;
	private JTextField emailC;
	private JTextField pinC;

	// splash screen click anywhere button 
	private JButton click;

	// student number next button 
    private JButton swap1N;

	// pin number next and back buttons 
    private JButton swap2B;
    private JButton swap2N;
    
	// email address  next and back buttons 
    private JButton swap3B;
    private JButton swap3N;
    
    // confirmation panel back and finish buttons 
    private JButton swap4B;
    private JButton swap4F;
    
    // keyboard for student number 
    private JButton[][] button1;
    
    // keyboard for pin number 
    private JButton[][] button2;
    
    // keyboard for email address 
    private JButton[][] button3;


    
    // these are for you Rob , do the file processing against these Strings 
    String studentNum="";
    String pinNum ="";
    String emailAd ="";
    
    // edit buttons on confirmation panel 
    private JButton edit1;
    private JButton edit2;
    private JButton edit3;

 
    
    // used for any alphanumeric keyboard 
    private static final String[][] alphaNumKey = {
    	{},
    	{},
        {"1","2","3","4","5","6","7","8","9","0",},
        {"Q","W","E","R","T","Y","U","I","O","P"}, 
        {"A","S","D","F","G","H","J","K","L"},
        {"Z","X","C","V","B","N","M","@","."},
        {"@yorku.ca", "@gmail.com","@yahoo.com", " ", "Enter","Delete"},
           };
    
    // used for any numeric keyboard.
    private static final String[][] NumKey = {
    	{},
    	{},
        {"1","2","3"},
        {"4","5","6",}, 
        {"7","8","9"},
        {"0",},
        { "Enter","Delete" }
           };

    
    
    public PanelSwap() {
        super(new BorderLayout());
        
        // student number 
         JPanel[] panel1 = new JPanel[9];
        for (int row = 0; row < alphaNumKey.length; row++) {
            panel1[row] = new JPanel();
            button1 = new JButton[12][12];
            for (int column = 0; column < NumKey[row].length; column++) {
                button1[row][column] = new JButton(NumKey[row][column]);
                button1[row][column].putClientProperty("column", column);
                button1[row][column].putClientProperty("row", row);
                button1[row][column].putClientProperty("key", NumKey[row][column]);
                button1[row][column].setPreferredSize(new Dimension(100,50));
                button1[row][column].addActionListener(this);
                // making space and enter bigger size 
                if(  button1[row][column] == button1[6][3] || button1[row][column] == button1[6][4] ){
                button1[row][column].setPreferredSize(new Dimension(200,50));
                	}
                panel1[row].add(button1[row][column]);
            }
        
            
            firstPanel.add(panel1[row]);
            
        }
        
        // keyboard for pin number
        JPanel[] panel2 = new JPanel[9];
        for (int row = 0; row < NumKey.length; row++) {
            panel2[row] = new JPanel();
            button2 = new JButton[12][12];
            for (int column = 0; column < NumKey[row].length; column++) {
          	  
                button2[row][column] = new JButton(NumKey[row][column]);
                button2[row][column].putClientProperty("column", column);
                button2[row][column].putClientProperty("row", row);
                button2[row][column].putClientProperty("key", NumKey[row][column]);
                button2[row][column].setPreferredSize(new Dimension(100,50));
                button2[row][column].addActionListener(this);
                // making space and enter bigger size 
                if(  button2[row][column] == button2[6][0] || button2[row][column] == button2[6][1] ){
                    button2[row][column].setPreferredSize(new Dimension(200,50));
                    	}
                panel2[row].add(button2[row][column]);
            }
        
            
            secondPanel.add(panel2[row]);
            
        }
      
      
      // keyboard for email
      JPanel[] panel3 = new JPanel[9];
    for (int row = 0; row < alphaNumKey.length; row++) {
        panel3[row] = new JPanel();
        button3 = new JButton[12][12];
        for (int column = 0; column < alphaNumKey[row].length; column++) {
      	  
            button3[row][column] = new JButton(alphaNumKey[row][column]);
            button3[row][column].putClientProperty("column", column);
            button3[row][column].putClientProperty("row", row);
            button3[row][column].putClientProperty("key", alphaNumKey[row][column]);
            button3[row][column].setPreferredSize(new Dimension(100,50));
            button3[row][column].addActionListener(this);
            
            if(  button3[row][column] == button3[6][3] || button3[row][column] == button3[6][4] ||  button3[row][column] == button3[6][5] ){
                button3[row][column].setPreferredSize(new Dimension(200,50));
                	}
            panel3[row].add(button3[row][column]);
        }
    
        
        thirdPanel.add(panel3[row]);
        
    }
      
    

    
    
    /**splash starts  here*/
    spalsh.setBackground(Color.white);

    // Building the splash screen
    JLabel title = new JLabel
      ("Welcome To Parking-Permit-Kiosk click anywhere  to start", JLabel.CENTER);

    // can be added afterward not used for now , assigned font as well 
    JLabel byWho = new JLabel
    	      ("by Shayan , Rob , Dave", JLabel.CENTER);
    title.setFont(new Font("Sans-Serif", Font.BOLD, 12));
    Color oraRed = new Color(156, 20, 20,  255);
    spalsh.setBorder(BorderFactory.createLineBorder(oraRed, 10));
    
    // assigning the click anywhere panel.
     click = new JButton("Welcome To Parking-Permit-Kiosk\n Click anywhere to start");
     click.setFont(new Font("Sans-Serif", Font.BOLD, 30));
     
     // making the button as big the screen lol.( feels like click anywhere type )
    click.setPreferredSize(new Dimension(1180,1180));
    spalsh.add(click);
    spalsh.setLayout(new GridLayout(1, 1));
    
    /**splash ends here*/
    
        
        // next and back buttons is being assigned. 
        swap1N = new JButton("Next");
        
        swap2B = new JButton("Back");
        swap2N = new JButton("Next");      
        
        swap3B = new JButton("Back");
        swap3N = new JButton("Next");
        
        swap4B = new JButton("back");
        swap4F = new JButton("finish");
        
        edit1 = new JButton("edit");
        edit2 = new JButton("edit");
        edit3 = new JButton("edit");


        
        // student place holder is being assigned. with given font 
        studentPlaceHolder = new JLabel("Enter your student number: ");
        studentPlaceHolder.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        
        // student place holder on confirmation panel  is being assigned. with given font 
        studentPlaceHolderC = new JLabel("your student #:");
        studentPlaceHolderC.setFont(new Font("Sans-Serif", Font.BOLD, 12));

        

        // pin place holder is being assigned. with given font 
		pinPlaceHolder = new JLabel("Enter your pin:");
		pinPlaceHolder.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		
        // pin place holder on confirmation panel is being assigned. with given font 
		pinPlaceHolderC = new JLabel("your pin is:");
		pinPlaceHolderC.setFont(new Font("Sans-Serif", Font.BOLD, 12));

		


		
        // email place holder is being assigned. with given font 
		emailPlaceHolder = new JLabel("Enter your email:");
		emailPlaceHolder.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		
        //  email place holder on confirmation panel is being assigned. with given font 
		emailPlaceHolderC = new JLabel("your email is:");
		emailPlaceHolderC.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		
		// title for confirmation panel 
		confirmLabel = new JLabel("Confirmation Page");
		confirmLabel.setFont(new Font("Sans-Serif", Font.BOLD, 16));


		

		// assigning text fields for student , pin , email (* we should make it disabled )
		student = new JTextField("");
		pin = new JPasswordField("");
		email = new JTextField("");

		// assigning text fields for student , pin , email on confirmation panel   (* we should make it disabled )
		studentC = new JTextField("");
		pinC = new JTextField("");
		emailC = new JTextField("");
		

		
		
		/** first panel adding components */ 
		firstPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 10, 100));
       
		firstPanel.setLayout(new GridLayout(11, 11));
		panel1[0].setLayout(new GridLayout(1, 1));
        panel1[1].setLayout(new GridLayout(1, 1));
		panel1[1].add(studentPlaceHolder);
		panel1[1].add(student);
        // adding the the next  button to the panel 1
        panel1[0].add(swap1N);
        swap1N.setPreferredSize(new Dimension(75,200));

        
        
		/** second panel adding components */ 
        secondPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 10, 100));
        secondPanel.setLayout(new GridLayout(11, 11));
        panel2[0].setLayout(new GridLayout(1, 1));
        panel2[1].setLayout(new GridLayout(1, 1));

        panel2[0].add(swap2B);
        panel2[1].add(pinPlaceHolder);
        panel2[1].add(pin);
        swap2N.setPreferredSize(new Dimension(75,200));
        swap2B.setPreferredSize(new Dimension(75,200));
        panel2[0].add(swap2N);
        

		/** third panel adding components */ 
        thirdPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 10, 100));
        panel3[0].setLayout(new GridLayout(1, 1));
        panel3[1].setLayout(new GridLayout(1, 1));
        thirdPanel.setLayout(new GridLayout(11, 11));

        panel3[0].add(swap3B);
        panel3[1].add(emailPlaceHolder);
        panel3[1].add(email);
        swap3N.setPreferredSize(new Dimension(75,200));
        swap3B.setPreferredSize(new Dimension(75,200));
        panel3[0].add(swap3N);
        
  
        

        




 
		/** forth  panel or confirm panel  adding components */ 
        studentC.setPreferredSize(new Dimension(200,34));
        emailC.setPreferredSize(new Dimension(200,34));
        pinC.setPreferredSize(new Dimension(200,34));
        
        // adding title label to confirm panel which then will  be added to forth panel
        confirmPanel.add(confirmLabel);
        
        // adding students label and text field to student panel which then will be added to forth panel
        studentPanel.add(studentPlaceHolderC);
        studentPanel.add(studentC);
        studentPanel.add(edit1);
        
        // adding email label and text field to email panel which then will be added to forth panel
        emailPanel.add(emailPlaceHolderC);
        emailPanel.add(emailC);
        emailPanel.add(edit2);

        // adding pin label and text field to email panel which then will be added to forth panel
        pinPanel.add(pinPlaceHolderC);
        pinPanel.add(pinC);
        pinPanel.add(edit3);

        // adding the inner panel to forth panel
        forthPanel.add(confirmPanel);
        forthPanel.add(studentPanel);
        forthPanel.add(emailPanel);
        forthPanel.add(pinPanel);
        
        // resizing the back and finish button
        swap4B.setPreferredSize(new Dimension(400,80));
        swap4F.setPreferredSize(new Dimension(400,80));
       
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // adding the finish and back button to buttonPanel,  which then will be added to forth panel
        buttonPanel.add(swap4B);
        buttonPanel.add(swap4F);         
        infoPanel.add(buttonPanel);
       
        infoPanel.setLayout(new GridLayout(1, 1));
        forthPanel.add(infoPanel);
        forthPanel.setLayout(new GridLayout(5, 1));

        
        
        
        /** Listens to the buttons start here . */
        click.addActionListener(this);

        swap1N.addActionListener(this);
        
        // Listening to next and back button second panel  
        swap2B.addActionListener(this);
        swap2N.addActionListener(this);
        
        // Listening to next and back button third panel  
        swap3B.addActionListener(this);
        swap3N.addActionListener(this);
        
        // Listening to  back and finish button on forth panel 
        swap4F.addActionListener(this);
        swap4B.addActionListener(this);

        // Listening to  edit buttons on confirmation panel 
        edit1.addActionListener(this);
        edit2.addActionListener(this);
        edit3.addActionListener(this);
        
        student.addActionListener(this);

        /** Listens to the buttons ends here . */


        // making the first panel to be the starting point 
        add(spalsh);

    }

    /** Listens to the buttons and perform the swap. */
    public void actionPerformed(ActionEvent e) {
  JButton btn = (JButton) e.getSource();
        String info = (String) btn.getClientProperty("key");

        for (Component component : getComponents())
        	
        	
        if (spalsh == component) {
        		 
        		 
           if(e.getSource() == click){
                     remove(spalsh);
                     add(firstPanel);
             		}
        	 }
        	
        	 else if (firstPanel == component) {
        		
        		 // example for giving the customer meaningful warning  
        		 if((e.getSource() == swap1N || e.getSource() == button1[6][0]) && studentNum.length() != 9 ){
        			
         			   JOptionPane.showMessageDialog(null, "Student Number is 9 digits, please check agian");

        		 }
        			 
                 
            	if((e.getSource() == swap1N || e.getSource() == button1[6][0]) )
            	{
            		if(studentNum.length() == 9){
            			if(hasID(studentNum) == true )
            			{
                    remove(firstPanel);
                    add(secondPanel);
            			}
            			else{
              			   JOptionPane.showMessageDialog(null, 
              					   "your student number does not match our records");	
            			}
            		}
            		
            		
            	}
               
            	else{
            		
                     studentNum += info;
                     if(info.compareTo("Delete") == 0 ){
                     	studentNum = studentNum.substring(0, studentNum.length() - 6);
                     }
                     
                     if(info.compareTo("Delete") == 0 && studentNum.length() != 0){
                     	studentNum = studentNum.substring(0, studentNum.length() - 1);
                     } 
         			student.setText(studentNum);
         			studentC.setText(studentNum);
         			
          			System.out.println("::::::::Student Number::::::::");
          			System.out.println("Student Numer matches? "+hasID(studentNum)); 
          			System.out.println(studentNum);
                     
            	}   
                     
            } 
            
            else if(secondPanel == component){
                
            	if(e.getSource() == swap2N || e.getSource() == button2[6][0]  ){
            		if(pinMatched(studentNum, pinNum) == true){
                    remove(secondPanel);
                    add(thirdPanel);
            		}
            		else{
            			 JOptionPane.showMessageDialog(null, 
            					   "the pin your entered is incorecred ");	
            		}


            	}
            	else if(e.getSource() == swap2B){
            		 remove(secondPanel);
                     add(firstPanel);


            	}
            	else{
            		  pinNum += info;
                      if(info.compareTo("Delete") == 0 ){
                    	  pinNum = pinNum.substring(0, pinNum.length() - 6);
                      }
                      
                      if(info.compareTo("Delete") == 0 && pinNum.length() != 0){
                    	  pinNum = pinNum.substring(0, pinNum.length() - 1);

                      } 
          			pin.setText(pinNum);
          		
          			System.out.println("::::::::PIN CODE::::::::");
          			System.out.println("Pin matches Student number ? "+ pinMatched(studentNum, pinNum)); 
          			System.out.println(pinNum);
                      
             	}   

            }
            
            else if(thirdPanel == component) {

            	if(e.getSource() == swap3N || e.getSource() == button3[6][4]  ){
                   remove(thirdPanel);
                   add(forthPanel);
            		
                   

            	}
            	else if(e.getSource() == swap3B){
            		remove(thirdPanel);
                    add(secondPanel);

            	}
            	else{
            		emailAd += info;
                      if(info.compareTo("Delete") == 0 ){
                    	  emailAd = emailAd.substring(0, emailAd.length() - 6);
                      }
                      
                      if(info.compareTo("Delete") == 0 && emailAd.length() != 0){
                    	  emailAd = emailAd.substring(0, emailAd.length() - 1);
                      } 
          			email.setText(emailAd);
          			emailC.setText(emailAd);
          			System.out.println("::::::::Email Adress::::::::");
          			System.out.println(emailAd);

                      
             	}   
          
            	}
            else{
            	
            	if(e.getSource() == swap4F ){
            		
            	//Rob I am resting all the string  for the next customer. 
            		  studentNum="";
           		      pinNum ="";
           		      emailAd ="";
           		      info ="";
           		  
           		      student.setText(studentNum);
           		      email.setText(emailAd);
           		      pin.setText(pinNum);
           		      studentC.setText(studentNum);
           		      emailC.setText(emailAd);
           		      
           		      
           			   JOptionPane.showMessageDialog(null, "You Just Purchased it");
           			   remove(forthPanel);
           			   add(spalsh);
           		
             	}
            	
            	else if(e.getSource() == edit1){
            		
            		  remove(forthPanel);
          			   add(firstPanel);
            	}
            	else if(e.getSource() == edit2){
            		
          		  remove(forthPanel);
        		   add(thirdPanel);
          	}
            	else if(e.getSource() == edit3){
            		
            		  remove(forthPanel);
          		   add(secondPanel);
            	}
            	
             	else if(e.getSource() == swap4B){
             		remove(forthPanel);
                     add(thirdPanel);

             	}
            	
            }
       
        
     updateUI();
     revalidate();
    }
    
    
    /**
     * File processing implementations
     */
    
    // check if students.txt contain user input id
   private static boolean hasID(String input){
	   
	   boolean hasId = false;
	   ArrayList<String> students = new ArrayList<String>();
	   String[] ids = new String[students.size()];
	   
	   students = readStudent();
	   ids = getField(students, 0);
	   for(String str : ids) {
		   if(input.equals(str)) {
			   hasId = true;
		   }
	   }
	   return hasId;
   }
   
   // check if students.txt contains user input pin and pin matches correspond student id
   private static boolean pinMatched(String id, String pin) {
	   boolean pinMatched = false;
	   ArrayList<String> students = new ArrayList<String>();
	   String[] pins = new String[students.size()];
	   String[] ids = new String[students.size()];
	   
	   students = readStudent();
	   ids = getField(students, 0);
	   pins = getField(students, 1);
	   
	   
	   for(int i = 0; i < students.size(); i++) {
		   if(ids[i].equals(id) && pins[i].equals(pin)) {
			   pinMatched = true;
		   }
	   }

	   return pinMatched;
   }
   
   // substract the student id field from each line
   private static String[] getField(ArrayList<String> students, int index) {
	   String[] field = new String[students.size()];
	   String[] temp = new String[5];
	   for(int i = 0; i < students.size(); i++) {
		 temp = students.get(i).split(",");
		 // note to remove any redundant spaces
		  field[i] = temp[index].trim(); 
	   }
	   return field;
   }
   // read student.txt file 
   private static ArrayList<String> readStudent() {

        String fileName = "students.txt";
        String line = null;
        ArrayList<String> students = new ArrayList<String>();
        try {
            FileReader fileReader = 
                new FileReader(fileName);
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                students.add(line);
                
            }   
            bufferedReader.close();         
        }
        // Exception handling
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }
        return students;
        
    }


    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
    	
        // Create and set up the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Putting the frame in the middle of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 6 - frame.getSize().width / 5, dim.height / 5 - frame.getSize().height / 5);

        // Create and set up the content pane.
        JComponent newContentPane = new PanelSwap();
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);

        frame.setSize(1300, 700);
        // Display the window.
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}