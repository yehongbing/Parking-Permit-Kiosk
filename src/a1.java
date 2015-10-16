import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.synth.SynthLookAndFeel;

import de.javasoft.plaf.synthetica.SyntheticaLookAndFeel;

public class a1 extends JPanel implements ActionListener, FocusListener {
	static JFrame frame = new JFrame("Payment Panel");

	private final String LOGO_PATH = "/images/york-university-log.png";
	private ImageIcon logo = new ImageIcon(LOGO_PATH);
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private DateFormat yearFormat = new SimpleDateFormat("yyyy");
	private DateFormat monthFormat = new SimpleDateFormat("MM");
	private DateFormat dayFormat = new SimpleDateFormat("dd");

	private final Calendar cal = Calendar.getInstance();
	private final Date currentDate = cal.getTime();
	private final String currentYear = yearFormat.format(currentDate);
	private final String currentMonth = monthFormat.format(currentDate);
	private final String currentDay = dayFormat.format(currentDate);
	final String[] years = { "2015", "2016", "2017", "2018", "2019" };
	final String[] monthes = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
			"Aug", "Sep", "Oct", "Nov", "Dec" };
	final String[] longer = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	final String[] shorter = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
	final String[] shortest = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25", "26", "27", "28" };
	final double DAILY_RATE = 3.5;
	private final String DEFAULT_START_YEAR = currentYear;
	private final int DEFAULT_START_MONTH_INDEX = Integer
			.parseInt(currentMonth) - 1;
	private final int DEFAULT_START_DAY_INDEX = Integer.parseInt(currentDay) - 1;

	int daysCount;
	double amount;
	private String tapPlaceHolder = "Tap Here to Enter";
	private String tapPlaceHolder1 = "Tap Here to Enter (Optional)";
	private String tempPin = "";

	private JLabel todayLabel;
	private JLabel currentDateLabel;
	private JLabel startLabel;
	private JLabel endLabel;
	private JLabel amountLabel;
	private JLabel daysCountLabel;

	private JTextField amountDisplay;
	private JTextField daysCountDisplay;

	private JPanel startDatePanel;
	private Date startDate;
	private JComboBox<String> startYearBox;
	private JComboBox<String> startMonthBox;
	private JComboBox<String> startDayBox;

	private JPanel endDatePanel;
	private Date endDate;
	private JComboBox<String> endYearBox;
	private JComboBox<String> endMonthBox;
	private JComboBox<String> endDayBox;

	private JButton next;
	private JButton back;
	private JButton checkOut;

	JButton exitButton;
	JButton exitButton1;
	JButton exitButton2;
	JButton exitButton3;
	JButton exitButton4;

	


	
	

	
	static boolean size = false;

	JPanel navPanel = new JPanel();

	// student number panel
	JPanel firstPanel = new JPanel();

	// pin number panel
	JPanel secondPanel = new JPanel();

	// email Address panel
	JPanel thirdPanel = new JPanel();

	// Confirmation Confirmation
	JPanel forthPanel = new JPanel();
	JPanel forthMainPanel = new JPanel();

	JPanel fifthPanel = new JPanel();

	// splash page ( *click anywhere page)
	JPanel splash = new JPanel();

	/** start of inner panels for within Confirmation (* forth ) panel */
	JPanel confirmPanel = new JPanel();
	JPanel studentPanel = new JPanel();
	JPanel emailPanel = new JPanel();
	JPanel namePanel = new JPanel();
	JPanel platePanel1 = new JPanel();

	JPanel carMakePanelC = new JPanel();
	JPanel carModelPanelC = new JPanel();
	JPanel companyPanelC = new JPanel();
	JPanel policyPanelC = new JPanel();
	JPanel amountPanelC = new JPanel();
	JPanel daysPanelC = new JPanel();

	JPanel buttonPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	JPanel sN = new JPanel();
	JPanel sI = new JPanel();

	private boolean isFocusID;
	private boolean isFocusPin;

	private boolean isFocusPlate;
	private boolean isFocusModel;
	private boolean isFocusEmail;
	private boolean isFocusPolicy;

	/** end of inner panels for within Confirmation panel */

	// Labels for student number , pin number , and email address( in order ).
	private JLabel studentPlaceHolder;
	private JLabel pinPlaceHolder;
	private JLabel emailPlaceHolder;

	// Confirmation panel labels
	private JLabel studentPlaceHolderC;
	private JLabel namePlaceHolderC;
	private JLabel emailPlaceHolderC;
	private JLabel confirmLabel;
	private JLabel plateLabelC;
	private JLabel makeLabelC;
	private JLabel modelLabelC;
	private JLabel insuranceLabelC;
	private JLabel policyLabelC;
	private JLabel daysLabelC;
	private JLabel amountLabelC;
	
	
	// text fields for student number , pin number , and email address( in order
	// ).
	private JTextField student;
	private JTextField pin;
	private JTextField email;

	private JTextField studentC;
	private JTextField emailC;
	private JTextField nameC;
	private JTextField plateC;
	private JTextField makeC;
	private JTextField modelC;

	private JTextField insuranceC;
	private JTextField policyC;
	private JTextField daysC;
	private JTextField amountC;

	// splash screen click anywhere button
	private JButton click;

	// student number next button
	private JButton swap1N;

	// pin number next and back buttons
	private JButton swap2B;
	private JButton swap2N;

	// email address next and back buttons
	private JButton swap3B;
	private JButton swap3N;

	// confirmation panel back and finish buttons
	private JButton swap4B;
	private JButton swap4F;

	private JButton swap5B;
	private JButton swap5N;

	// keyboard for student number
	private JButton[][] button1;

	// keyboard for pin number
	private JButton[][] button2;

	// keyboard for email address
	private JButton[][] button3;

	private JButton[][] button4;

	// these are for you Rob , do the file processing against these Strings
	String studentNum = "";
	String pinNum = "";
	String emailAd = "";

	String modelNum = "";
	String plateNum = "";
	String policyNum = "";

	// edit buttons on confirmation panel
	private JButton editPlate;
	private JButton editEmail;
	private JButton editMake;
	private JButton editModel;
	private JButton editCompany;
	private JButton editPolicy;
	private JButton editDays;
	

	JComboBox make;

	private JTextField model;
	private JTextField plate;

	private JLabel modelPlaceHolder;
	private JLabel platePlaceHolderC;

	JComboBox insurance;

	private JTextField policy;
	private JLabel policyPlaceHolder;

	private JPanel date = new JPanel();

	// used for any alphanumeric keyboard
	private static final String[][] alphaNumKey = { {}, {},
			{ "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", },
			{ "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P" },
			{ "A", "S", "D", "F", "G", "H", "J", "K", "L" },
			{ "Z", "X", "C", "V", "B", "N", "M", "@", "." },
			{ " ", "Enter", "Delete" }, };

	// used for any numeric keyboard.
	

	private static final String[][] NumKey1 = {

	{ "1", "2", "3" }, { "4", "5", "6", }, { "7", "8", "9" },
			{ "<<", "0", "<" }, };

	public a1() {
		super(new BorderLayout());

		try {
			UIManager
					.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel");
			SyntheticaLookAndFeel.setFont("Sans", 24);
		} catch (Exception e) {
		}
		

		JButton alaki = new JButton("?");

		// next and back buttons is being assigned.
		swap1N = new JButton("Login");

		swap2B = new JButton("Back");
		swap2N = new JButton("Next");

		swap3B = new JButton("Back");
		swap3N = new JButton("Next");

		swap4B = new JButton("Back");
		swap4F = new JButton("Finish");

		swap5B = new JButton("Back");
		swap5N = new JButton("Next");

		editPlate = new JButton("Edit");
		editEmail = new JButton("Edit");
		editMake = new JButton("Edit");
		editModel = new JButton("Edit");
		editCompany = new JButton("Edit");
		editPolicy = new JButton("Edit");
		editDays = new JButton("Edit");
		

		// student place holder is being assigned. with given font
		studentPlaceHolder = new JLabel("Student Number: ");
		// studentPlaceHolder.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		
		// student place holder on confirmation panel is being assigned. with
		// given font
		studentPlaceHolderC = new JLabel("Your student #:");

		// pin place holder is being assigned. with given font
		pinPlaceHolder = new JLabel("Your Pin Number:");
		// pinPlaceHolder.setFont(new Font("Sans-Serif", Font.BOLD, 12));

		// pin place holder on confirmation panel is being assigned. with given
		// font
		namePlaceHolderC = new JLabel("Name:");
		namePlaceHolderC.setPreferredSize(new Dimension(70,50));

		// email place holder is being assigned. with given font
		emailPlaceHolder = new JLabel("Enter your email:");
		emailPlaceHolder.setFont(new Font("Sans-Serif", Font.BOLD, 12));

		// email place holder on confirmation panel is being assigned. with
		// given font
		emailPlaceHolderC = new JLabel("Email:");
		emailPlaceHolderC.setPreferredSize(new Dimension(65,50));

		// title for confirmation panel
		confirmLabel = new JLabel("Confirmation Page");
		confirmLabel.setPreferredSize(new Dimension(200,50));
		confirmLabel.setFont(new Font("Sans-Serif", Font.BOLD, 20));

		modelPlaceHolder = new JLabel("Model:");
		modelPlaceHolder.setFont(new Font("Sans-Serif", Font.BOLD, 12));

		platePlaceHolderC = new JLabel("Plate Number");
		platePlaceHolderC.setFont(new Font("Sans-Serif", Font.BOLD, 12));

		model = new JTextField(tapPlaceHolder1);
		model.setForeground(Color.gray);
		plate = new JTextField(tapPlaceHolder1);
		plate.setForeground(Color.gray);

		policyPlaceHolder = new JLabel("Policy Number: ");
		policyPlaceHolder.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		policy = new JTextField(tapPlaceHolder1);
		policy.setForeground(Color.gray);

		JPanel panelA = new JPanel();
		JPanel panelPin = new JPanel();

		swap1N.setPreferredSize(new Dimension(400, 45));

		sN.add(swap1N);
		sN.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

		// assigning text fields for student , pin , email (* we should make it
		// disabled )
		student = new JTextField(tapPlaceHolder);
		student.setForeground(Color.gray);
		pin = new JTextField(tapPlaceHolder);
		pin.setForeground(Color.gray);
		email = new JTextField(tapPlaceHolder1);
		email.setForeground(Color.gray);

		// assigning text fields for student , pin , email on confirmation panel
		// (* we should make it disabled )
		studentC = new JTextField("");
		nameC = new JTextField("");
		emailC = new JTextField("");
		// sI.setLayout(new GridLayout(1, 2));
		panelPin.add(pinPlaceHolder);
		pin.setPreferredSize(new Dimension(300, 50));
		panelPin.add(pin);

		
		panelA.add(studentPlaceHolder);
		panelA.add(student);

		student.setPreferredSize(new Dimension(300, 50));
		sI.add(alaki);

		JLabel thumb = new JLabel();

		ImageIcon iconLogo = new ImageIcon("LassondeYork.png");
		// In init() method write this code
		thumb.setIcon(iconLogo);
		
		
		JLabel thumb1 = new JLabel();

		ImageIcon iconLogo1 = new ImageIcon("LassondeYork.png");
		// In init() method write this code
		thumb1.setIcon(iconLogo1);
		
		JLabel thumb2 = new JLabel();

		ImageIcon iconLogo2 = new ImageIcon("LassondeYork.png");
		// In init() method write this code
		thumb1.setIcon(iconLogo2);
		
		
		
		JLabel thumb3 = new JLabel();

		ImageIcon iconLogo3 = new ImageIcon("LassondeYork.png");
		// In init() method write this code
		thumb1.setIcon(iconLogo3);
		
		
		
		
		
		
	
		firstPanel.add(thumb);
		JLabel loginT = new JLabel("Please Log-In");
		loginT.setPreferredSize(new Dimension(170,50));
		loginT.setFont(new Font("Sans-serif", Font.BOLD, 20 ));
		JPanel title = new JPanel();
		title.setPreferredSize(new Dimension(800,40));
		title.add(loginT);
		firstPanel.add(title);
		
		panelA.setBorder(BorderFactory.createEmptyBorder(0, 0, 80, 190));
		panelPin.setBorder(BorderFactory.createEmptyBorder(0, 0, 80, 190));
		firstPanel.add(panelA);
		firstPanel.add(panelPin);

		policy.addActionListener(this);

		/**********/

		JPanel currentDatePanel = new JPanel();

		JPanel clalcute = new JPanel();
		JPanel daysPanel = new JPanel();
		JPanel amountPanel = new JPanel();
		startDate = new Date();
		endDate = new Date();

		// components in the expire panel and the initial value of comoboxes
		startDatePanel = new JPanel();
		startDatePanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 20,
				100));

		endDatePanel = new JPanel();
		endDatePanel
				.setBorder(BorderFactory.createEmptyBorder(10, 100, 20, 100));

		daysCountLabel = new JLabel("						Days: ");
		daysCountLabel.setFont(new Font("Sans-Serif", Font.BOLD, 12));

		daysCountDisplay = new JTextField();
		daysCountDisplay.setPreferredSize(new Dimension(350, 50));

		amountLabel = new JLabel("							The amount: ");
		amountLabel.setFont(new Font("Sans-Serif", Font.BOLD, 12));

		amountDisplay = new JTextField();
		amountDisplay.setPreferredSize(new Dimension(350, 50));
		checkOut = new JButton("Click here to Calculate");
		checkOut.setPreferredSize(new Dimension(450, 50));

		next = new JButton("Next");
		next.setPreferredSize(new Dimension(400, 50));

		back = new JButton("Back");
		back.setPreferredSize(new Dimension(400, 50));

		todayLabel = new JLabel("Today's Date is: ");
		todayLabel.setFont(new Font("Sans-Serif", Font.BOLD, 20));

		// make today's display as yyyy-Oct-dd
		currentDateLabel = new JLabel(yearFormat.format(currentDate) + "-"
				+ convertMonthStr(Integer.parseInt(currentMonth)) + "-"
				+ dayFormat.format(currentDate));
		currentDateLabel.setFont(new Font("Sans-Serif", Font.BOLD, 20));

		startLabel = new JLabel("Choose the start date: ");
		startLabel.setFont(new Font("Sans-Serif", Font.BOLD, 12));

		startYearBox = new JComboBox<String>(years);
		startYearBox.setPrototypeDisplayValue("XXXX");
		startYearBox.setPreferredSize(new Dimension(120, 50));

		startYearBox.setSelectedItem(DEFAULT_START_YEAR);
		startMonthBox = new JComboBox<String>(monthes);
		startMonthBox.setPreferredSize(new Dimension(120, 50));

		startMonthBox.setSelectedIndex(DEFAULT_START_MONTH_INDEX);
		startDayBox = new JComboBox<String>(
				daysInMonth(convertMonthStr(Integer.parseInt(currentMonth))));
		startDayBox.setSelectedIndex(DEFAULT_START_DAY_INDEX);

		startDayBox.setPreferredSize(new Dimension(120, 50));

		endLabel = new JLabel("Choose the end date: ");
		endLabel.setFont(new Font("Sans-Serif", Font.BOLD, 12));

		endYearBox = new JComboBox<String>(years);

		endYearBox.setPreferredSize(new Dimension(120, 50));

		endYearBox.setSelectedItem(DEFAULT_START_YEAR);

		endMonthBox = new JComboBox<String>(monthes);

		endMonthBox.setPreferredSize(new Dimension(120, 50));

		endMonthBox.setSelectedIndex(DEFAULT_START_MONTH_INDEX);

		endDayBox = new JComboBox<String>(
				daysInMonth(convertMonthStr(Integer.parseInt(currentMonth))));
		endDayBox.setPreferredSize(new Dimension(120, 50));
		endDayBox.setSelectedIndex(DEFAULT_START_DAY_INDEX);

		// add listener
		startMonthBox.addActionListener(this);
		endMonthBox.addActionListener(this);
		checkOut.addActionListener(this);
		next.addActionListener(this);
		back.addActionListener(this);

		// layout

		startDatePanel.add(startLabel);

		startDatePanel.add(startYearBox);
		startDatePanel.add(startMonthBox);
		startDatePanel.add(startDayBox);

		endDatePanel.add(endLabel);
		endDatePanel.add(endYearBox);
		endDatePanel.add(endMonthBox);
		endDatePanel.add(endDayBox);

		daysPanel.add(daysCountLabel);
		daysPanel.add(daysCountDisplay);
		daysPanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 60));

		JPanel dateNBPanel = new JPanel();
		dateNBPanel.add(back);
		dateNBPanel.add(next);
		dateNBPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		currentDatePanel.add(todayLabel);
		currentDatePanel.add(currentDateLabel);
		currentDatePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		amountPanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));
		amountPanel.add(amountLabel);
		amountPanel.add(amountDisplay);

		 exitButton3 = new JButton("Exit");
			
			exitButton3.setPreferredSize(new Dimension(70,40));
			exitButton3.setBackground(Color.red);
			exitButton3.setFont(new Font("Sans-serif", Font.BOLD, 14 ));

			JPanel exitPanel = new JPanel();
			
			exitPanel.add(exitButton3);
			exitPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 800));

			date.add(exitPanel);
		
		date.add(currentDatePanel);
		date.add(dateNBPanel);

		date.add(startDatePanel);
		date.add(endDatePanel);
		date.add(daysPanel);
		date.add(amountPanel);

		clalcute.add(checkOut);
		clalcute.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 50));

		date.add(clalcute);

		/**********/

		// adding the the next button to the panel 1

		// student number
		JPanel[] panel1 = new JPanel[9];
		for (int row = 0; row < NumKey1.length; row++) {
			panel1[row] = new JPanel();
			button1 = new JButton[12][12];
			for (int column = 0; column < NumKey1[row].length; column++) {
				button1[row][column] = new JButton(NumKey1[row][column]);
				button1[row][column].putClientProperty("column", column);
				button1[row][column].putClientProperty("row", row);
				button1[row][column].putClientProperty("key",
						NumKey1[row][column]);
				button1[row][column].setPreferredSize(new Dimension(100, 50));
				button1[row][column].addActionListener(this);
				// making space and enter bigger size
				if (button1[row][column] == button1[4][0]
						|| button1[row][column] == button1[4][1]) {
					button1[row][column]
							.setPreferredSize(new Dimension(200, 50));
				}
				panel1[row].add(button1[row][column]);
			}
			panel1[row]
					.setBorder(BorderFactory.createEmptyBorder(5, 20, 20, 0));

			firstPanel.add(panel1[row]);

		}

		sN.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		firstPanel.add(sN);

		JPanel swapSecod = new JPanel();

		swap2B.setPreferredSize(new Dimension(400, 50));
		swap2N.setPreferredSize(new Dimension(400, 50));

		swapSecod.add(swap2N);

		JPanel makePanel = new JPanel();
		makePanel.setLayout(new BorderLayout());

		JPanel modelPanel = new JPanel();
		modelPanel.setLayout(new BorderLayout());

		JPanel platePanel = new JPanel();

		model.setPreferredSize(new Dimension(400, 50));
		modelPanel.setBorder(BorderFactory.createEmptyBorder(0, 110, 20, 0));

		modelPanel.add(modelPlaceHolder, BorderLayout.WEST);
		modelPanel.add(model, BorderLayout.EAST);

		plate.setPreferredSize(new Dimension(400, 50));
		platePanel.setBorder(BorderFactory.createEmptyBorder(0, 100, 20, 0));

		platePanel.add(platePlaceHolderC);
		platePanel.add(plate);
		

		String[] options = { "-----Select The Make of Your Car------", "Ford",
				"Toyota", "Hyundai", "Chevrolet", "Honda", "Dodge", "Ram",
				"Nissan", "Kia", "Mazda", "GMC", "VW", "Jeep", "Subaru",
				"Mercedes-Benz", "BMW", "Chrysler", "Misubishi", "Audi",
				"Acura", "Lexus", "Buick", "Infiniti", "Cadilliak", "Misubishi" };
		make = new JComboBox(options);

		make.setPreferredSize(new Dimension(550, 50));
		makePanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 20, 0));
		makePanel.add(make);
		
		JLabel vehicle = new JLabel("Vehicle Information");
		vehicle.setPreferredSize(new Dimension(240,50));
		vehicle.setFont(new Font("Sans-serif", Font.BOLD, 20 ));
		JPanel title1 = new JPanel();
		swapSecod.setBorder(BorderFactory.createEmptyBorder(15, 100, 0, 60));
		title1.setPreferredSize(new Dimension(800,40));
		title1.add(vehicle);

		 exitButton = new JButton("Exit");
		
		exitButton.setPreferredSize(new Dimension(70,40));
		exitButton.setBackground(Color.red);
		exitButton.setFont(new Font("Sans-serif", Font.BOLD, 14 ));

		secondPanel.add(exitButton);
		secondPanel.add(title1);
		secondPanel.add(swapSecod);
		secondPanel.add(makePanel);

		secondPanel.add(modelPanel);
		secondPanel.add(platePanel);

		// keyboard for pin number
		JPanel[] panel2 = new JPanel[9];
		for (int row = 0; row < alphaNumKey.length; row++) {
			panel2[row] = new JPanel();
			button2 = new JButton[12][12];
			for (int column = 0; column < alphaNumKey[row].length; column++) {

				button2[row][column] = new JButton(alphaNumKey[row][column]);
				button2[row][column].putClientProperty("column", column);
				button2[row][column].putClientProperty("row", row);
				button2[row][column].putClientProperty("key",
						alphaNumKey[row][column]);
				button2[row][column].setPreferredSize(new Dimension(100, 50));
				button2[row][column].addActionListener(this);

				// making space and enter bigger size
				if (button2[row][column] == button2[6][0]
						|| button2[row][column] == button2[6][1] ||  button2[row][column] == button2[6][2]) {
					button2[row][column]
							.setPreferredSize(new Dimension(200, 50));
				}

				panel2[row].add(button2[row][column]);
			}

			secondPanel.add(panel2[row]);

		}
		
		JLabel emailT = new JLabel("Email");
		emailT.setPreferredSize(new Dimension(80,50));
		emailT.setFont(new Font("Sans-serif", Font.BOLD, 20 ));
		JPanel title2 = new JPanel();
		title2.setPreferredSize(new Dimension(800,40));
		title2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 40));
		title2.add(emailT);
		
		 exitButton2 = new JButton("Exit");
			
			exitButton2.setPreferredSize(new Dimension(70,40));
			exitButton2.setBackground(Color.red);
			exitButton2.setFont(new Font("Sans-serif", Font.BOLD, 14 ));

			thirdPanel.add(exitButton2);
		
		thirdPanel.add(title2);

		swap3N.setPreferredSize(new Dimension(400, 50));
		swap3B.setPreferredSize(new Dimension(400, 50));
		JPanel thirdNB = new JPanel();
		thirdNB.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		JPanel emailPlace = new JPanel();
		thirdNB.add(swap3B);
		thirdNB.add(swap3N);
		thirdPanel.add(thirdNB);
		email.setPreferredSize(new Dimension(400, 50));
		emailPlace.setBorder(BorderFactory.createEmptyBorder(98, 40, 80, 80));

		emailPlace.add(emailPlaceHolder);
		emailPlace.add(email);

		thirdPanel.add(emailPlace);

		// keyboard for email
		JPanel[] panel3 = new JPanel[9];
		for (int row = 0; row < alphaNumKey.length; row++) {
			panel3[row] = new JPanel();
			button3 = new JButton[12][12];
			for (int column = 0; column < alphaNumKey[row].length; column++) {

				button3[row][column] = new JButton(alphaNumKey[row][column]);
				button3[row][column].putClientProperty("column", column);
				button3[row][column].putClientProperty("row", row);
				button3[row][column].putClientProperty("key",
						alphaNumKey[row][column]);
				button3[row][column].setPreferredSize(new Dimension(100, 50));
				button3[row][column].addActionListener(this);

				if (button3[row][column] == button3[6][3]
						|| button3[row][column] == button3[6][0]
						|| button3[row][column] == button3[6][1]||  button2[row][column] == button2[6][2]) {
					button3[row][column]
							.setPreferredSize(new Dimension(300, 50));
				}
				panel3[row].add(button3[row][column]);
			}

			thirdPanel.add(panel3[row]);

		}

		JPanel swapPanel5 = new JPanel();
		swapPanel5.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 0));

		swap2B.setPreferredSize(new Dimension(400, 50));
		swap2N.setPreferredSize(new Dimension(500, 50));

		JPanel insurancePanel = new JPanel();
		insurancePanel
				.setBorder(BorderFactory.createEmptyBorder(0, 100, 10, 0));
		
		JLabel insuranceT = new JLabel("Insurance Information");
		insuranceT.setPreferredSize(new Dimension(250,50));
		insuranceT.setFont(new Font("Sans-serif", Font.BOLD, 20 ));
		JPanel title3 = new JPanel();
		title3.setPreferredSize(new Dimension(800,40));
		title3.add(insuranceT);
		 exitButton1 = new JButton("Exit");
			
		exitButton1.setPreferredSize(new Dimension(70,40));
		exitButton1.setBackground(Color.red);
		exitButton1.setFont(new Font("Sans-serif", Font.BOLD, 14 ));

		fifthPanel.add(exitButton1);
		
		fifthPanel.add(title3);

		JPanel ploicyPanel = new JPanel();
		ploicyPanel.setBorder(BorderFactory.createEmptyBorder(50, 120, 45, 0));

		swapPanel5.add(swap5B);
		swapPanel5.add(swap5N);
		swap5B.setPreferredSize(new Dimension(400, 50));
		swap5N.setPreferredSize(new Dimension(400, 50));

		policy.setPreferredSize(new Dimension(400, 50));

		ploicyPanel.add(policyPlaceHolder);
		ploicyPanel.add(policy);

		ArrayList<String> temp = readCompany();
		String[] InsuranceOptions = new String[temp.size()];

		InsuranceOptions[0] = "-----Select an insurance company-----";

		for (int i = 1; i < temp.size(); i++) {

			InsuranceOptions[i] = temp.get(i);

		}

		insurance = new JComboBox(InsuranceOptions);
		insurance.setPreferredSize(new Dimension(500, 50));
		insurancePanel.add(insurance);

		fifthPanel.add(swapPanel5);
		fifthPanel.add(insurancePanel);
		fifthPanel.add(ploicyPanel);

		// keyboard for email
		JPanel[] panel4 = new JPanel[9];
		for (int row = 0; row < alphaNumKey.length; row++) {
			panel4[row] = new JPanel();
			button4 = new JButton[12][12];
			for (int column = 0; column < alphaNumKey[row].length; column++) {

				button4[row][column] = new JButton(alphaNumKey[row][column]);
				button4[row][column].putClientProperty("row", row);
				button4[row][column].putClientProperty("key",
						alphaNumKey[row][column]);
				button4[row][column].setPreferredSize(new Dimension(100, 50));
				button4[row][column].addActionListener(this);

				if (button4[row][column] == button4[6][0]
						|| button4[row][column] == button4[6][1]
						|| button4[row][column] == button4[6][2]) {
					button4[row][column]
							.setPreferredSize(new Dimension(200, 50));
				}
				panel4[row].add(button4[row][column]);
			}

			fifthPanel.add(panel4[row]);

		}

		fifthPanel.setBorder((BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		/** splash starts here */
		splash.setBackground(Color.white);

		// can be added afterward not used for now , assigned font as well

		Color oraRed = new Color(156, 20, 20, 255);
		splash.setBorder(BorderFactory.createLineBorder(oraRed, 2));

		// assigning the click anywhere panel.

		Icon img = new ImageIcon("WelcomeScreen2.png");
		click = new JButton(img);

		// making the button as big the screen lol.( feels like click anywhere
		// type )
		click.setPreferredSize(new Dimension(1180, 1180));
		splash.add(click);
		splash.setLayout(new GridLayout(1, 1));

		/** splash ends here */

		/** first panel adding components */
		firstPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
		firstPanel.setLayout(new GridLayout(9, 9));

		/** second panel adding components */
		secondPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		/** third panel adding components */
		thirdPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		/** forth panel or confirm panel adding components */
		forthPanel.setLayout(new BorderLayout());
		forthMainPanel.setLayout(new GridLayout(2, 5));

		plateLabelC = new JLabel("Plate #:");
		plateLabelC.setPreferredSize(new Dimension(80,50));
		plateC = new JTextField("");
		plateC.setEditable(false);
		plateC.setPreferredSize(new Dimension(200, 34));

		makeLabelC = new JLabel("Make & Model:");
		makeLabelC.setPreferredSize(new Dimension(170,50));
		makeC = new JTextField("");
		makeC.setEditable(false);
		makeC.setPreferredSize(new Dimension(250, 50));

		modelLabelC = new JLabel("Model: ");
		modelC = new JTextField("");
		modelC.setEditable(false);
		modelC.setPreferredSize(new Dimension(200, 34));

		insuranceLabelC = new JLabel("Insurance:");
		insuranceLabelC.setPreferredSize(new Dimension(120,50));
		insuranceC = new JTextField("");

		insuranceC.setFont(new Font("Sans-Serif", Font.BOLD, 10));

		insuranceC.setEditable(false);
		insuranceC.setPreferredSize(new Dimension(250, 50));

		policyLabelC = new JLabel("Policy #:");
		policyLabelC.setPreferredSize(new Dimension(100,50));
		policyC = new JTextField("");
		policyC.setEditable(false);
		policyC.setPreferredSize(new Dimension(250, 50));

		amountLabelC = new JLabel("Amount($):");
		amountLabelC.setPreferredSize(new Dimension(120,50));
		amountC = new JTextField("");
		amountC.setEditable(false);
		amountC.setPreferredSize(new Dimension(250, 50));

		daysLabelC = new JLabel("Days:");
		daysLabelC.setPreferredSize(new Dimension(60,50));
		daysC = new JTextField("");
		daysC.setEditable(false);
		daysC.setPreferredSize(new Dimension(250, 50));

		platePanel1.add(plateLabelC);
		plateC.setPreferredSize(new Dimension(250,50));
		platePanel1.add(plateC);
		platePanel1.add(editPlate);

		namePanel.add(namePlaceHolderC);
		nameC = new JTextField("");

		studentC.setPreferredSize(new Dimension(200, 34));
		emailC.setPreferredSize(new Dimension(200, 34));
		nameC.setPreferredSize(new Dimension(200, 34));

		// adding title label to confirm panel which then will be added to forth
		// panel
		confirmPanel.add(confirmLabel);
		
		
		JLabel empty1 = new JLabel();
		empty1.setPreferredSize(new Dimension(60,10));
		JLabel empty2 = new JLabel();
		empty2.setPreferredSize(new Dimension(30,10));
		JLabel empty3 = new JLabel();
		empty3.setPreferredSize(new Dimension(40,10));
		JLabel empty4 = new JLabel();
		empty4.setPreferredSize(new Dimension(10,10));
		JLabel empty = new JLabel();
		empty.setPreferredSize(new Dimension(100,10));

		// adding students label and text field to student panel which then will
		// be added to forth panel
		studentPanel.add(studentPlaceHolderC);
		studentPanel.add(studentC);
		studentPanel.add(empty1);

		// adding email label and text field to email panel which then will be
		// added to forth panel
		emailPanel.add(emailPlaceHolderC);
		emailC.setPreferredSize(new Dimension(250,50));
		emailC.setEditable(false);
		emailPanel.add(emailC);
		emailPanel.add(editEmail);

		// adding pin label and text field to email panel which then will be
		// added to forth panel
		namePanel.add(namePlaceHolderC);
		nameC.setPreferredSize(new Dimension(250,50));
		nameC.setEditable(false);
		namePanel.add(nameC);

		carMakePanelC.add(makeLabelC);
		carMakePanelC.add(makeC);
		carMakePanelC.add(editMake);

		carModelPanelC.add(modelLabelC);
		carModelPanelC.add(modelC);
		carModelPanelC.add(editModel);

		companyPanelC.add(insuranceLabelC);
		companyPanelC.add(insuranceC);
		companyPanelC.add(editCompany);

		policyPanelC.add(policyLabelC);
		policyPanelC.add(policyC);
		policyPanelC.add(editPolicy);

		amountPanelC.add(amountLabelC);
		amountPanelC.add(amountC);

		daysPanelC.add(daysLabelC);
		daysPanelC.add(daysC);
		daysPanelC.add(editDays);

		// adding the inner panel to forth panel


//		forthMainPanel.add(studentPanel);
		forthMainPanel.add(emailPanel);

		forthMainPanel.add(namePanel);
		forthMainPanel.add(platePanel1);

		forthMainPanel.add(carMakePanelC);
//		forthMainPanel.add(carModelPanelC);
		forthMainPanel.add(companyPanelC);
		forthMainPanel.add(policyPanelC);
		forthMainPanel.add(amountPanelC);
		forthMainPanel.add(daysPanelC);

		forthPanel.add(confirmPanel, BorderLayout.NORTH);
		forthPanel.add(forthMainPanel, BorderLayout.CENTER);
		forthPanel.add(infoPanel, BorderLayout.SOUTH);
		// resizing the back and finish button
		swap4B.setPreferredSize(new Dimension(400, 80));
		swap4F.setPreferredSize(new Dimension(400, 80));

		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// adding the finish and back button to buttonPanel, which then will be
		// added to forth panel
		buttonPanel.add(swap4B);
		buttonPanel.add(swap4F);
		infoPanel.add(buttonPanel);

		infoPanel.setLayout(new GridLayout(1, 1));

		/** Listens to the buttons start here . */
		click.addActionListener(this);

		swap1N.addActionListener(this);

		// Listening to next and back button second panel
		swap2B.addActionListener(this);
		swap2N.addActionListener(this);

		// Listening to next and back button third panel
		swap3B.addActionListener(this);
		swap3N.addActionListener(this);

		// Listening to back and finish button on forth panel
		swap4F.addActionListener(this);
		swap4B.addActionListener(this);

		swap5N.addActionListener(this);
		swap5B.addActionListener(this);

		// Listening to edit buttons on confirmation panel
		editMake.addActionListener(this);
		editEmail.addActionListener(this);
		editPlate.addActionListener(this);
		editModel.addActionListener(this);
		editCompany.addActionListener(this);
		editPolicy.addActionListener(this);
		editDays.addActionListener(this);
		editPlate.addActionListener(this);

		student.addActionListener(this);
		student.addFocusListener(this);

		pin.addFocusListener(this);
		model.addFocusListener(this);
		plate.addFocusListener(this);
		email.addFocusListener(this);
		policy.addFocusListener(this);

		next.addActionListener(this);
		back.addActionListener(this);
		
		exitButton.addActionListener(this);
		exitButton1.addActionListener(this);
		exitButton2.addActionListener(this);
		exitButton3.addActionListener(this);




		/** Listens to the buttons ends here . */

		// making the splash panel to be the starting point
		add(splash);

	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource().equals(student)) {
			isFocusModel = false;
			isFocusID = true;
			isFocusPin = false;
			isFocusPlate = false;
			isFocusEmail = false;
			isFocusPolicy = false;
			if(student.getText().equals(tapPlaceHolder)) {
				student.setText("");
				student.setForeground(Color.black);
			}

		} else if (e.getSource().equals(pin)) {
			isFocusModel = false;
			isFocusID = false;
			isFocusPin = true;
			isFocusPlate = false;
			isFocusEmail = false;
			isFocusPolicy = false;
			if(pin.getText().equals(tapPlaceHolder)) {
				pin.setText("");
				pin.setForeground(Color.black);
			}

		}

		else if (e.getSource().equals(model)) {
			isFocusModel = true;
			isFocusID = false;
			isFocusPin = false;
			isFocusPlate = false;
			isFocusEmail = false;
			isFocusPolicy = false;
			if(model.getText().equals(tapPlaceHolder1)) {
				model.setText("");
				model.setForeground(Color.black);
			}

		}

		else if (e.getSource().equals(plate)) {
			isFocusModel = false;
			isFocusID = false;
			isFocusPin = false;
			isFocusPlate = true;
			isFocusEmail = false;
			isFocusPolicy = false;
			if(plate.getText().equals(tapPlaceHolder1)) {
				plate.setText("");
				plate.setForeground(Color.black);
			}
		}

		else if (e.getSource().equals(email)) {
			isFocusModel = false;
			isFocusID = false;
			isFocusPin = false;
			isFocusPlate = false;
			isFocusEmail = true;
			isFocusPolicy = false;
			if(email.getText().equals(tapPlaceHolder1)) {
				email.setText("");
				email.setForeground(Color.black);
			}
		}
		
		else if (e.getSource().equals(policy)) {
			isFocusModel = false;
			isFocusID = false;
			isFocusPin = false;
			isFocusPlate = false;
			isFocusEmail = false;
			isFocusPolicy = true;
			if(policy.getText().equals(tapPlaceHolder1)) {
				policy.setText("");
				policy.setForeground(Color.black);
			}
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	// class for number pad

	private class NumPad extends JPanel {

		// constructor for number pad
		private NumPad() {

		}
	}

	/*
	 * method for days in specific month
	 */
	private String[] daysInMonth(String month) {

		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("Jan", longer);
		map.put("Feb", shortest);
		map.put("Mar", longer);
		map.put("Apr", shorter);
		map.put("May", longer);
		map.put("Jun", shorter);
		map.put("Jul", longer);
		map.put("Aug", longer);
		map.put("Sep", shorter);
		map.put("Oct", longer);
		map.put("Nov", shorter);
		map.put("Dec", longer);
		return map.get(month);
	}

	// method to convert integer month to string month for example 1 --> Jan
	private String convertMonthStr(int monthInDigit) {
		String monthInStr = "";
		switch (monthInDigit) {
		case 1:
			monthInStr = "Jan";
			break;
		case 2:
			monthInStr = "Feb";
			break;
		case 3:
			monthInStr = "Mar";
			break;
		case 4:
			monthInStr = "Apr";
			break;
		case 5:
			monthInStr = "May";
			break;
		case 6:
			monthInStr = "Jun";
			break;
		case 7:
			monthInStr = "Jul";
			break;
		case 8:
			monthInStr = "Aug";
			break;
		case 9:
			monthInStr = "Sep";
			break;
		case 10:
			monthInStr = "Oct";
			break;
		case 11:
			monthInStr = "Nov";
			break;
		case 12:
			monthInStr = "Dec";
			break;
		}

		return monthInStr;
	}

	private int convertMonthDigit(String monthInStr) {
		int monthInDigit = 0;
		switch (monthInStr) {
		case "Jan":
			monthInDigit = 0;
			break;
		case "Feb":
			monthInDigit = 1;
			break;
		case "Mar":
			monthInDigit = 2;
			break;
		case "Apr":
			monthInDigit = 3;
			break;
		case "May":
			monthInDigit = 4;
			break;
		case "Jun":
			monthInDigit = 5;
			break;
		case "Jul":
			monthInDigit = 6;
			break;
		case "Aug":
			monthInDigit = 7;
			break;
		case "Sep":
			monthInDigit = 8;
			break;
		case "Oct":
			monthInDigit = 9;
			break;
		case "Nov":
			monthInDigit = 10;
			break;
		case "Dec":
			monthInDigit = 11;
			break;
		}
		return monthInDigit;
	}

	/*
	 * method for calculate the amount
	 */
	private double calAmount(int days) {
		double amount = 0;
		amount = (days) * DAILY_RATE;
		if (amount > 0) {
			return amount;
		}
		return 0;
	}

	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

	/** Listens to the buttons and perform the swap. */
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		JButton btn = new JButton();

		if (source instanceof JButton) {
			btn = (JButton) source;
		}

		String info = "";
		if (btn.getClientProperty("key") != null) {
			info = (String) btn.getClientProperty("key");
		}
		String alaki = "";
		String alakz = "";

		for (Component component : getComponents())

			if (splash == component) {

				if (e.getSource() == click) {
					remove(splash);
					add(firstPanel);
				}
			}

			else if (firstPanel == component) {

				// example for giving the customer meaningful warning
				if ((e.getSource() == swap1N || e.getSource() == button1[4][0])
						&& studentNum.length() != 9) {

					JOptionPane
							.showMessageDialog(null,
									"Student Number is not 9 digits, please check agian");

				}

				if (e.getSource() == swap1N) {

					if (pinMatched(studentNum, pinNum) == true) {
						remove(firstPanel);
						add(secondPanel);
					} else if (studentNum.length() == 9) {
						if (hasID(studentNum) == false)
							JOptionPane
									.showMessageDialog(null,
											"your student number does not match our records");

						else if (pinMatched(studentNum, pinNum) == false) {
							JOptionPane
									.showMessageDialog(null,
											"your pin number does not match our records");

						}

					}
				}

				else {

					if (isFocusID) {

//						String firstPart = "";
//						String secondPat = "";
//						firstPart = studentNum.substring(0,
//								student.getCaretPosition());
//						
//						secondPat = studentNum.substring(
//								student.getCaretPosition(),
//								studentNum.length());
//						
//						firstPart = firstPart + info;
					
						studentNum += info;

						if (info.compareTo("<<") == 0) {
							studentNum = "";
						}
						if (info.compareTo("<") == 0) {

							studentNum = studentNum.substring(0,
									studentNum.length() - 1);
						}

						if (info.compareTo("<") == 0
								&& studentNum.length() != 0) {
							alaki = studentNum.substring(
									student.getCaretPosition(),
									studentNum.length());
							alakz = studentNum.substring(0,
									student.getCaretPosition() - 1);
							studentNum = alakz + alaki;
						}

						student.setText(studentNum);
						studentC.setText(studentNum);

						System.out.println("::::::::Student Number::::::::");
						System.out.println("Student Numer matches? "
								+ hasID(studentNum));
						System.out.println(studentNum);

					}
					if (isFocusPin == true) {
						pinNum += info;
						tempPin += "*";
						if (info.compareTo("<<") == 0) {
							pinNum = "";
							tempPin = "";
						}
						if (info.compareTo("<") == 0) {
							pinNum = pinNum.substring(0, pinNum.length() - 1);
							tempPin = tempPin.substring(0, tempPin.length() - 1);
						}

						if (info.compareTo("<") == 0 && pinNum.length() != 0) {
							String firstPart = "";
							String secondPart = "";
							firstPart = pinNum.substring(
									pin.getCaretPosition(), pinNum.length());
							secondPart = pinNum.substring(0,
									pin.getCaretPosition() - 1);
							pinNum = secondPart + firstPart;
							
							
							firstPart = tempPin.substring(
									pin.getCaretPosition(), tempPin.length());
							secondPart = tempPin.substring(0,
									pin.getCaretPosition() - 1);
							tempPin = secondPart + firstPart;
						}
						pin.setText(tempPin);
						nameC.setText(pinNum);
						System.out.println("::::::::Pin Number::::::::");
						System.out.println(pinNum);

					}
				}
			}

			else if (secondPanel == component) {

				if(e.getSource() == exitButton){
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(this, "Are you Sure you want to exit?", "Loging Out", dialogButton);
					if(dialogResult == 0) {

						resetFrame();
						remove(secondPanel);
						add(splash);
						
					} else {
					  System.out.println("strying");
					} 
					
				}
				
				if (e.getSource() == swap2N || e.getSource() == button2[6][1] ) {
					remove(secondPanel);
					add(fifthPanel);
					isFocusModel = false;
					isFocusPlate = false;

				}

				if (e.getSource() == swap2B) {
					remove(secondPanel);
					add(firstPanel);
				}

				if (isFocusModel == true) {
					modelNum += info;
					if (e.getSource() == button2[6][2]) {
						modelNum = modelNum.substring(0, modelNum.length() - 6);
					}

					if (e.getSource() == button2[6][2]
							&& modelNum.length() != 0) {
						String firstPart = "";
						String secondPart = "";
						firstPart = modelNum.substring(
								model.getCaretPosition(), modelNum.length());
						secondPart = modelNum.substring(0,
								model.getCaretPosition() - 1);
						modelNum = secondPart + firstPart;
					}

					model.setText(modelNum);

				}

				if (isFocusPlate == true) {
					plateNum += info;

					if (e.getSource() == button2[6][2]) {
						plateNum = plateNum.substring(0, plateNum.length() - 6);
					}

					if (e.getSource() == button2[6][2]
							&& plateNum.length() != 0) {
						String firstPart = "";
						String secondPart = "";
						firstPart = plateNum.substring(
								plate.getCaretPosition(), plateNum.length());
						secondPart = plateNum.substring(0,
								plate.getCaretPosition() - 1);
						plateNum = secondPart + firstPart;

					}

					plate.setText(plateNum);

				}

			}

			else if (fifthPanel == component) {

				if(e.getSource() == exitButton1){
					
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(this, "Are you Sure you want to exit?", "Loging Out", dialogButton);
				
					if(dialogResult == 0) {
						resetFrame();
						remove(fifthPanel);
						add(splash);
							} 
							
					else {
					  System.out.println("staying");
							} 
				}
				
				
				
				if ((e.getSource() == swap5N || e.getSource() == button4[6][1] )) {
					if(insurance.getSelectedIndex() == 0){
						
						JOptionPane
						.showMessageDialog(null,
								"You need to Select an insurance company");
					}
					else{
					
					remove(fifthPanel);
					add(thirdPanel);
					}
					}

				else if (e.getSource() == swap5B) {
					remove(fifthPanel);
					add(secondPanel);
				}

				else{
					policyNum += info;

					if (e.getSource() == button4[6][2]) {
						policyNum = policyNum.substring(0,
								policyNum.length() - 6);
					}

					if (e.getSource() == button4[6][2]
							&& policyNum.length() != 0) {
						String firstPart = "";
						String secondPart = "";
						firstPart = policyNum.substring(
								policy.getCaretPosition(), policyNum.length());
						secondPart = policyNum.substring(0,
								policy.getCaretPosition() - 1);
						policyNum = secondPart + firstPart;

					}

					policy.setText(policyNum);

				}

			}

			else if (date == component) {
				
				if(e.getSource() == exitButton3){
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(this, "Are you Sure you want to exit?", "Loging Out", dialogButton);
						
							if(dialogResult == 0) {
								resetFrame();
								remove(date);
								add(splash);
									} 
									
							else {
							  System.out.println("strying");
									} 
						}
				

				if (e.getSource() == back) {

					remove(date);
					add(thirdPanel);

				}

				// these two actions make days comboboxes change when month
				// change, since each month has different days
				if (e.getSource() == startMonthBox) {
					String month = (String) startMonthBox.getSelectedItem();

					// remove all the items and add new days in that specific
					// month
					startDayBox.removeAllItems();
					for (String days : daysInMonth(month)) {
						startDayBox.addItem(days);
					}
				} else if (e.getSource() == endMonthBox) {
					String month = (String) startMonthBox.getSelectedItem();

					// remove all the items and add new days in that specific
					// month
					endDayBox.removeAllItems();
					for (String days : daysInMonth(month)) {
						endDayBox.addItem(days);
					}
				}
				// next button make it to check valid date
				else if (e.getSource() == next) {
					Date startDate = new Date();
					Date endDate = new Date();

					// get info from start comboboxes
					int selectedStartYear = Integer
							.parseInt((String) startYearBox.getSelectedItem());
					int selectedStartMonth = convertMonthDigit((String) startMonthBox
							.getSelectedItem());
					int selectedStartDay = Integer
							.parseInt((String) startDayBox.getSelectedItem());
					startDate.setYear(selectedStartYear);
					startDate.setMonth(selectedStartMonth);
					startDate.setDate(selectedStartDay);

					// get info from end comboboxes
					int selectedEndYear = Integer.parseInt((String) endYearBox
							.getSelectedItem());
					int selectedEndMonth = convertMonthDigit((String) endMonthBox
							.getSelectedItem());
					int selectedEndDay = Integer.parseInt((String) endDayBox
							.getSelectedItem());
					endDate.setYear(selectedEndYear);
					endDate.setMonth(selectedEndMonth);
					endDate.setDate(selectedEndDay);

					remove(date);
					add(forthPanel);

					if (startDate.after(endDate) || endDate.before(startDate)) {
						JOptionPane.showMessageDialog(null,
								"Wrong date order, please check again");
					}

					daysCount = (int) getDateDiff(startDate, endDate,
							TimeUnit.DAYS) + 1;
					System.out.println(daysCount);
					amountDisplay
							.setText(Double.toString(calAmount(daysCount)));
					daysCountDisplay.setText(Integer.toString(daysCount));

				} else if (e.getSource() == checkOut) {
					Date startDate = new Date();
					Date endDate = new Date();

					// get info from start comboboxes
					int selectedStartYear = Integer
							.parseInt((String) startYearBox.getSelectedItem());
					int selectedStartMonth = convertMonthDigit((String) startMonthBox
							.getSelectedItem());
					int selectedStartDay = Integer
							.parseInt((String) startDayBox.getSelectedItem());
					startDate.setYear(selectedStartYear);
					startDate.setMonth(selectedStartMonth);
					startDate.setDate(selectedStartDay);

					// get info from end comboboxes
					int selectedEndYear = Integer.parseInt((String) endYearBox
							.getSelectedItem());
					int selectedEndMonth = convertMonthDigit((String) endMonthBox
							.getSelectedItem());
					int selectedEndDay = Integer.parseInt((String) endDayBox
							.getSelectedItem());
					endDate.setYear(selectedEndYear);
					endDate.setMonth(selectedEndMonth);
					endDate.setDate(selectedEndDay);

					if (startDate.after(endDate) || endDate.before(startDate)) {
						JOptionPane.showMessageDialog(null,
								"Wrong date order, please check again");
					}

					daysCount = (int) getDateDiff(startDate, endDate,
							TimeUnit.DAYS) + 1;
					System.out.println(daysCount);
					amountDisplay
							.setText(Double.toString(calAmount(daysCount)));
					if (daysCount > 0)
						daysCountDisplay.setText(Integer.toString(daysCount));

				}
				info = "";
			}

			else if (thirdPanel == component) {
				
			if(e.getSource() == exitButton2){
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(this, "Are you Sure you want to exit?", "Loging Out", dialogButton);
						
							if(dialogResult == 0) {
								resetFrame();
								remove(thirdPanel);
								add(splash);
									} 
									
							else {
							  System.out.println("strying");
									} 
						}
				
		
				

				if ((e.getSource() == swap3N || e.getSource() == button3[6][1]) ) {

					System.out.print(isEmailValid(emailAd));
					if(isEmailValid(emailAd) || (emailAd.isEmpty())){
					remove(thirdPanel);
					add(date);
					}
					else{
						
						JOptionPane.showMessageDialog(null,
								"Email subscription is optional ,However the email you have entered is incorret");
					}

				} else if (e.getSource() == swap3B) {
					remove(thirdPanel);
					add(fifthPanel);

				} else {

					emailAd += info;
					if (e.getSource() == button3[6][2]) {
						emailAd = emailAd.substring(0, emailAd.length() - 6);
					}

					if (e.getSource() == button3[6][2] && emailAd.length() != 0) {
						emailAd = emailAd.substring(0, emailAd.length() - 1);
					}
					email.setText(emailAd);
					emailC.setText(emailAd);
					System.out.println("::::::::Email Adress::::::::");
					System.out.println(emailAd);

				}

			} 
			// confirmation panel listener
			else {

				setTextField(email.getText(), emailC);
				nameC.setText(getName(studentNum));
				setTextField(plateNum, plateC);
				setTextField(policy.getText(), policyC);
				setTextField(email.getText(), emailC);
				if(make.getSelectedItem().toString() == "-----Select The Make of Your Car------") {
					makeC.setText("Not Provied");
				}
				else {
					makeC.setText(make.getSelectedItem().toString() + " " + model.getText().toString());
				}
				setTextField(model.getText(),modelC);
				if(insurance.getSelectedItem().toString() == "Select a company name") {
					insuranceC.setText("Not Provied");
				}
				else {
					insuranceC.setText(insurance.getSelectedItem().toString());
				}
				setTextField(policy.getText(), policyC);
				amountC.setText(amountDisplay.getText());
				daysC.setText(daysCountDisplay.getText());
				if (e.getSource() == swap4F) {

					Object[] options = {"Thank You Guyz",
	                   };
						
						String dayz = daysCount + "";
						String  amountz =Double.toString(calAmount(daysCount));
						System.out.print(amount);

	int n = JOptionPane.showOptionDialog(frame,
			"		Detalies"+"\n"+ "Student Number: "+studentNum + "\n" + 
					"Name: "+ getName(studentNum) + "\n" + "Permit for " + dayz + " Days " +"\n"
					 + "Amount Charged:" + amountz +"$",
	    "Cofirm",
	    JOptionPane.YES_NO_OPTION,
	    JOptionPane.QUESTION_MESSAGE,
	    null,     //do not use a custom Icon
	    options,  //the titles of buttons
	    options[0]); //default button title
	
	resetFrame();
	info = "";	

	// Rob I am resting all the string for the next customer.

					remove(forthPanel);
					add(splash);

				}

				else if (e.getSource() == editMake) {

					remove(forthPanel);
					add(secondPanel);
				} else if (e.getSource() == editEmail) {

					remove(forthPanel);
					add(thirdPanel);
				} else if (e.getSource() == editPlate) {

					remove(forthPanel);
					add(secondPanel);
				}
				else if (e.getSource() == editModel) {

					remove(forthPanel);
					add(secondPanel);
				}
				
				else if (e.getSource() == editCompany) {

					remove(forthPanel);
					add(fifthPanel);
				}
				else if (e.getSource() == editPolicy) {

					remove(forthPanel);
					add(fifthPanel);
				}
				else if (e.getSource() == editDays) {

					remove(forthPanel);
					add(date);
				}
				

				else if (e.getSource() == swap4B) {
					remove(forthPanel);
					add(date);

				}

			}

		updateUI();
		revalidate();
	}

	/**
	 * File processing implementations
	 */

	// read companies.txt file return string array.
	private static ArrayList<String> readCompany() {
		String fileName = "companies.txt";
		String line = null;
		ArrayList<String> companies = new ArrayList<String>();
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				companies.add(line);
			}
			bufferedReader.close();
		}
		// Exception handling
		catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		return companies;
	}

	// check if students.txt contain user input id
	private static boolean hasID(String input) {

		boolean hasId = false;
		ArrayList<String> students = new ArrayList<String>();
		String[] ids = new String[students.size()];

		students = readStudent();
		ids = getField(students, 0);
		for (String str : ids) {
			if (input.equals(str)) {
				hasId = true;
			}
		}
		return hasId;
	}

	private static String getName(String studentNum) {

		ArrayList<String> students = readStudent();

		String[] student = new String[5];
		String firstName = "";
		String lastName = "";
		String fullName = "";
		for (String str : students) {
			if (str.contains(studentNum)) {
				student = str.split(",");
				firstName = student[2];
				lastName = student[3];
			}
		}
		fullName = firstName + lastName;
		return fullName;

	}

	// check if students.txt contains user input pin and pin matches correspond
	// student id
	private static boolean pinMatched(String id, String pin) {
		boolean pinMatched = false;
		ArrayList<String> students = new ArrayList<String>();
		String[] pins = new String[students.size()];
		String[] ids = new String[students.size()];

		students = readStudent();
		ids = getField(students, 0);

		pins = getField(students, 1);

		for (int i = 0; i < students.size(); i++) {
			if (ids[i].equals(id) && pins[i].equals(pin)) {
				pinMatched = true;
			}
		}

		return pinMatched;
	}
	
	
	private static boolean isEmailValid(String email) {
		boolean isValid = false;
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(email);
		    
		 if(matcher.matches()){
			 
			 isValid = true;
		 }
				
		return isValid;
	}
	
	
	

	// substract the student id field from each line
	private static String[] getField(ArrayList<String> students, int index) {
		String[] field = new String[students.size()];
		String[] temp = new String[5];
		for (int i = 0; i < students.size(); i++) {
			temp = students.get(i).split(",");

			// note to remove any redundant spaces
			field[i] = temp[index].trim();
		}
		return field;
	}
	
	private static void setTextField(String str, JTextField textFieldC){
		if (str.isEmpty() || str.contains("Tap")) {
			textFieldC.setText("Not Provied");
		} else {
			textFieldC.setText(str);
		}
	}

	// read student.txt file
	private static ArrayList<String> readStudent() {

		String fileName = "students.txt";

		// Path p = Paths.get("./students.txt");

		String line = null;
		ArrayList<String> students = new ArrayList<String>();
		try {

			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				students.add(line);

			}
			bufferedReader.close();
		}

		// Exception handling
		catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		return students;

	}
	
	
	
	private  void resetFrame(){
	
		student.setText("");
		email.setText("");
		policy.setText("");
		model.setText("");
		plate.setText("");
		pin.setText("");
		make.setSelectedIndex(0);
		insurance.setSelectedIndex(0);
		daysCountDisplay.setText("1");
		amountDisplay.setText("3.5");
		
		studentNum = "";
		pinNum = "";
		tempPin = "";
		emailAd = "";
		policyNum = "";
		modelNum = "";
		plateNum = "";
		
		int selectedStartYear = Integer
				.parseInt((String) startYearBox.getSelectedItem());
		int selectedStartMonth = convertMonthDigit((String) startMonthBox
				.getSelectedItem());
		int selectedStartDay = Integer
				.parseInt((String) startDayBox.getSelectedItem());
		startDate.setYear(selectedStartYear);
		startDate.setMonth(selectedStartMonth);
		startDate.setDate(selectedStartDay);

		// get info from end comboboxes
		int selectedEndYear = Integer.parseInt((String) endYearBox
				.getSelectedItem());
		int selectedEndMonth = convertMonthDigit((String) endMonthBox
				.getSelectedItem());
		int selectedEndDay = Integer.parseInt((String) endDayBox
				.getSelectedItem());
		endDate.setYear(selectedEndYear);
		endDate.setMonth(selectedEndMonth);
		endDate.setDate(selectedEndDay);
		
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
		frame.setLocation(dim.width / 6 - frame.getSize().width / 5, dim.height
				/ 5 - frame.getSize().height / 5);

		// Create and set up the content pane.
		JComponent newContentPane = new a1();
		newContentPane.setBackground(new Color( 255, 255, 255) );

		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);
		frame.setSize(1150, 800);

		// frame.pack();
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
