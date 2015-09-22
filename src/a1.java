import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class a1 extends JFrame {

		private static final long serialVersionUID = 1L;
		
		private JButton backButton;
		private JButton nextButton;
		private JLabel title;
		private JTextField text;
		private int maxInput = 15;
	
		public a1(){
			/*
			 * Configuration of components
			 */
			super("Parking-Permit-Kiosk");
			
			
			InputPanel panel1 = new InputPanel(new JLabel("<html><b>Enter your student ID: </b></html>"));
			
			
			// Keyboard Panel
			JPanel keyboardPanel = new JPanel();
			keyboardPanel.add(new KeyPadPanel());
			
			
			JPanel contentPane = new JPanel();
			contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
			contentPane.add(panel1);
			contentPane.add(keyboardPanel);
			
			
			this.setContentPane(contentPane);
			this.pack();
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//			this.setSize(new Dimension(screenSize.width/2,screenSize.height/2));
			this.setLocation(screenSize.width/2- this.getSize().width/2, screenSize.height/2-this.getSize().height/2);
			//this.setResizable(false);
		}
	/*
	 * KeyBoard class that implement keyboard
	 */
	private class KeyPadPanel extends JPanel implements KeyListener{
		// Keyboard Rows
		String firstRow[] = {"1","2","3","4","5","6","7","8","9","0","Backspace"};
		String secondRow[] = {"Q","W","E","R","T","Y","U","I","O","P"};
		String thirdRow[] = {"A","S","D","F","G","H","J","K","L"};
		String fourthRow[] = {"Z","X","C","V","B","N","M","@","."};
		String fifthRow[]={"@yorku.ca", "@gmail.com", "           ", "Confirm"};
		
		//all keys without shift key press
		String noShift="1234567890qwertyuiopasdfghjklzxcvbnm@./";
		//special characters on keyboard that has to be addressed during keypress
		String specialChars ="~-+[]\\;',.?";

		//JButton corresponding to each individual rows 
		JButton first[];

		JButton second[];

		JButton third[];

		JButton fourth[];

		JButton fifth[];
		
		// Default color of the button to be repainted when key released 
		Color cc = new JButton().getBackground();
		
		// Constructor 
		public KeyPadPanel() {
			/*set the layout and place component in place and pack it */
		    this.setLayout(new GridLayout(5,1));
		    
		    
		    /* Each row of keyboard implementation */
		    first = new JButton[firstRow.length];
		    JPanel panelRows = new JPanel(new GridLayout(1, firstRow.length));
		    for(int i = 0; i < firstRow.length; i++) {
		    	first[i] = new JButton(firstRow[i]);
		        first[i].setPreferredSize(new Dimension(100,50));
		
		        panelRows.add(first[i]);
		    }
		    
		    this.add(panelRows);
		    
		    second = new JButton[secondRow.length];
		    panelRows = new JPanel(new GridLayout(1, secondRow.length));
		    for(int i = 0; i < secondRow.length; i++) {
		    	second[i] = new JButton(secondRow[i]);
		    	panelRows.add(second[i]);
		    }
		    
		    this.add(panelRows);
		    
		    third = new JButton[thirdRow.length];
		    panelRows = new JPanel(new GridLayout(1, thirdRow.length));
		    for(int i = 0; i < thirdRow.length; i++) {
		    	third[i] = new JButton(thirdRow[i]);
		    	panelRows.add(third[i]);
		    }
		    this.add(panelRows);
		    
		    fourth = new JButton[fourthRow.length];
		    panelRows = new JPanel(new GridLayout(1, fourthRow.length));
		    for(int i = 0; i < fourthRow.length; i++) {
		    	fourth[i] = new JButton(fourthRow[i]);
		    	panelRows.add(fourth[i]);
		    }
		    this.add(panelRows);
		    
		    fifth = new JButton[fifthRow.length];
		    panelRows = new JPanel(new GridLayout(1, fifthRow.length));
		    for(int i = 0; i < fifthRow.length; i++) {
		    	fifth[i] = new JButton(fifthRow[i]);
		    	panelRows.add(fifth[i]);
		    }
		    this.add(panelRows);
		}
		
	    @Override
		public void keyPressed(KeyEvent evt) 
		{

		}

	    @Override
		public void keyReleased(KeyEvent evt)
		{

		}

		@Override
		public void keyTyped(KeyEvent e) 
		{
			
		}
		
	}
	
	// For panels switches, we encapsulate the panels into input panel class
	private class InputPanel extends JPanel {
		private JButton backButton;
		private JPanel centerInput;
		private JButton nextButton;
		private JTextField text;
		private JPanel titlePanel;
		
		public InputPanel(JLabel lable) {
			// The layout of each input panel
			this.setLayout(new BorderLayout());
			
			// Specify the components, two buttons and one center panel
		
			backButton = new JButton("<<<");
			backButton.setPreferredSize(new Dimension(75,200));
			
			centerInput = new JPanel();

			text = new JTextField();
			
			nextButton = new JButton(">>>");
			nextButton.setPreferredSize(new Dimension(75,200));
			
			// arrange the central component (Title and TextField)
			
			centerInput.setLayout(new BoxLayout(centerInput, BoxLayout.Y_AXIS));
			centerInput.add(Box.createRigidArea(new Dimension(75, 50)));
			centerInput.add(lable);
			centerInput.add(Box.createRigidArea(new Dimension(0, 50)));
			centerInput.add(text);
			centerInput.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			
			// arrange the whole input panel
			this.add(backButton, BorderLayout.WEST);
			this.add(centerInput, BorderLayout.CENTER);
			this.add(nextButton, BorderLayout.EAST);
		}
	}
	
	// Main function
	public static void main(String[] args) {
		
		a1 main = new a1();
	}
}