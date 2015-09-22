import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PanelSwap extends JPanel implements ActionListener {

    JPanel firstPanel = new JPanel();
    JPanel secondPanel = new JPanel();
    JPanel thirdPanel = new JPanel();

	private JLabel studentPlaceHolder;
	private JLabel pinPlaceHolder;
	private JLabel emailPlaceHolder;
	
	private JTextField student;
	private JTextField pin;
	private JTextField email;
    private JButton swap1N;

	
    private JButton swap2B;
    private JButton swap2N;

    private JButton swap3B;
    private JButton swap3N;


    public PanelSwap() {
        super(new BorderLayout());
        
        
        swap1N = new JButton("Next");
        swap2B = new JButton("Back");
        swap2N = new JButton("Next");      
        swap3B = new JButton("Back");
        swap3N = new JButton("Next");
        
        studentPlaceHolder = new JLabel("Enter your student number: ");
		pinPlaceHolder = new JLabel("Enter your pin:");
		emailPlaceHolder = new JLabel("Enter your email:");
		student = new JTextField("");
		pin = new JTextField("");
		email = new JTextField("");
		

		// first panel adding components  
		firstPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		firstPanel.setLayout(new GridLayout(1, 1));
		firstPanel.add(studentPlaceHolder);
		firstPanel.add(student);

		// second panel adding components  
        secondPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        secondPanel.setLayout(new GridLayout(1, 1));
        secondPanel.add(pinPlaceHolder);
        secondPanel.add(pin);
        
		// third panel adding components  
        thirdPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        thirdPanel.setLayout(new GridLayout(1, 1));
        thirdPanel.add(emailPlaceHolder);
        thirdPanel.add(email);
        

        // Listening to next button first panel  
        swap1N.addActionListener(this);
        
        // Listening to next and back button second panel  
        swap2B.addActionListener(this);
        swap2N.addActionListener(this);
        
        // Listening to next and back button thirs panel  
        swap3B.addActionListener(this);
        swap3N.addActionListener(this);
        

        // adding the the button to the panels 
        firstPanel.add(swap1N);
        secondPanel.add(swap2B);
        secondPanel.add(swap2N);
        
        thirdPanel.add(swap3B);
        thirdPanel.add(swap3N);

        // making the first panel to be the starting point 
        add(firstPanel);
    }

    /** Listens to the buttons and perform the swap. */
    public void actionPerformed(ActionEvent e) {

        for (Component component : getComponents())
            if (firstPanel == component) {
            	
                remove(firstPanel);
                add(secondPanel);

            } 
            
            else if(secondPanel == component){
            	if(e.getSource() == swap2N){
                    remove(secondPanel);
                    add(thirdPanel);
            	}
            	else{
            		 remove(secondPanel);
                     add(firstPanel);
            	}
            }
            
            else {
            	if(e.getSource() == swap3B){
                    remove(thirdPanel);
                    add(secondPanel);
            	}
            	
            	/* for now nothing happens when clicked on button Next
            	 * we will handle swap3N here as an else conditon 
            	*/
            	
            	}
     updateUI();
     revalidate();
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
    	
        // Create and set up the window.
        JFrame frame = new JFrame("Payment Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Putting the frame in the middle of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        // Create and set up the content pane.
        JComponent newContentPane = new PanelSwap();
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);

        // Display the window.
        frame.pack();
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
