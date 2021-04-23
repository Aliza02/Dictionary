import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.ComponentOrientation;

import javax.swing.BorderFactory;
import javax.swing.Box;
import com.jgoodies.forms.factories.DefaultComponentFactory;
//import com.sun.java.swing.plaf.windows.resources.windows;

import javax.swing.ImageIcon;

public class DSAProj implements ActionListener{

	private JFrame frame;Object temp;
	public  HashDictionary dict[]=new HashDictionary[51];
	 public    Hash2 h=new Hash2(51,0.75F);
	 JLabel Title = new JLabel("Word Search");
	 JButton Search = new JButton("Search");
	 JButton Addbtn = new JButton("Add");
	 JButton Exitbtn = new JButton("Exit");
	JTextArea area =new JTextArea();
		JTextField input=new JTextField();
		JButton find=new JButton("find");
		JLabel search_label=new JLabel("Enter Word:");
		JButton back=new JButton("Back");
		JButton addword=new JButton("Add");
		JScrollPane scroll=new JScrollPane(area);
		boolean ADD;
		
	/**
	 * Launch the application.
	 */
		
	public DSAProj() {
		initialize();
		Search.addActionListener(this);
		find.addActionListener(this);
		Addbtn.addActionListener(this);
		addword.addActionListener(this);
		back.addActionListener(this);
		
		
		
		 dict[0]=new HashDictionary("Adjective \n polite, respectful, or considerate in manner.");
		 dict[1]=new HashDictionary("Verb\n1.think carefully about (something), typically \nbefore making a decision.\n 2.look attentively at.");
		 dict[2]=new HashDictionary("verb\r\n1.give or grant someone (power, status, \n or recognition).\n 2.(of a concept or fact) be harmonious \nor consistent with.");
		 dict[3]=new HashDictionary("adjective\r\nclearly seen or understood; obvious.");
		 dict[4]=new HashDictionary("verb\r\n1.have (a course of action) as one's purpose \n or intention; plan. \n 2.design or destine something for a particular \npurpose.");
         dict[5]=new HashDictionary("verb\r\n1.relate to; be about.\n 2.make (someone) anxious or worried"+
		"\nnoun\r\n1.anxiety; worry.\n2.a matter of interest or importance to someone.");
         dict[6]=new HashDictionary("verb\r\n" + 
         		"1.perpetrate or carry out (a mistake, crime, \nor immoral act).\n 2.pledge or bind (a person or an organization) \nto a certain course or policy.");
         dict[7]=new HashDictionary("verb\r\n" + 
         		"1.come near or nearer to (someone or something) in distance or time.\n noun\r\n" + 
         		"1.a way of dealing with a situation or problem.\n 2.an initial proposal or request made to someone.");
         dict[8]=new HashDictionary("verb\r\n 1.set up on a firm or permanent basis.\n 2.achieve "
         		+ "permanent acceptance or recognition \nfor.");
         dict[9]=new HashDictionary("verb:\nto say something or to make a sound with your \n voice:\nadjective:\ncomplete; absolute.");
         dict[10]=new HashDictionary("noun\n1.the manner in which a person behaves,\n especially in a particular place or situation\n"
         		+ "2.the manner in which an organization or \nactivity is managed or directed.\n verb\n 1."
        		 + "organize and carry out. \n2." + 
        		 "lead or guide (someone) to or around a particular place.");
         dict[11]=new HashDictionary("verb\r\n" + 
         		"1.occupy or attract (someone's interest\n or attention).\n 2.participate or become involved in.");
         dict[12]=new HashDictionary("verb\r\n" + 
         		"1.get, acquire, or secure (something).\n 2.FORMAL\n be prevalent, customary, or established.");
         dict[13]=new HashDictionary("adjective\r\n (especially of food, money, or some other \n resource) insufficient for the demand.\n adverb\r\nscarcely.");
         dict[14]=new HashDictionary("noun\r\n" + 
         		"a course or principle of action adopted or \nproposed by an organization or individual.\n"
         		+ "ARCHAIC\r\n" + 
         		"prudent or expedient conduct or action.");
         dict[15]=new HashDictionary("adjective\r\n" + 
         		"1."+
         		"extending or moving uniformly in one direction\n  only; without a curve or bend.\n"
         		+ "adverb\r\n" +  
         		"in a straight line; directly.\n"
         		+ "noun\r\n" + 
        
         		"a part of something that is not curved\n or bent, especially a straight section of a\n racecourse.");
         dict[16]=new HashDictionary("capital raised by a corporation through\n  the issue of shares");
         dict[17]=new HashDictionary("adjective\r\n" + 
         		"1." + 
         		"clearly visible or understood; obvious.\n 2." + 
         		"seeming real or true, but not necessarily so.");
         dict[18]=new HashDictionary("noun:"+ 
         		"1.\r\n" + 
         		"a thing or things belonging to someone;\n possessions collectively.");
         dict[19]=new HashDictionary("adjective\r\n" +  
         		"1." + 
         		"elaborate in structure or decoration.");
         
         
         
		 h.put("Courteous", dict[0]);
		 h.put("Consider",dict[1] );
		 h.put("Accord",dict[2]);
		 h.put("Evident", dict[3]);
		 h.put("Intend", dict[4]);
		 h.put("Concern", dict[5]);
		 h.put("Commit",dict[6]);
		 h.put("Approach", dict[7]);
		 h.put("Establish", dict[8]);
		 h.put("Utter", dict[9]);
		 h.put("Conduct", dict[10]);
		 h.put("Engage",dict[11]);
		 h.put("Obtain", dict[12]);
		 h.put("Scarce",dict[13]);
		 h.put("Policy", dict[14]);
		 h.put("Straight", dict[15]);
		 h.put("Stock",dict[16]);
		 h.put("Apparent", dict[17]);
		 h.put("Property", dict[18]);
		 h.put("Fancy", dict[19]);
		 	
		 
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("WORD SEARCH");
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(UIManager.getColor("Button.darkShadow"));
	
		Title.setBackground(SystemColor.activeCaption);
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		
		Title.setLabelFor(Title);
		//Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("Segoe Print", Font.BOLD, 40));
	
		Title.setVerticalTextPosition(SwingConstants.TOP);
		
		//Title.setVerticalAlignment(SwingConstants.TOP);
		Title.setForeground(Color.WHITE);
		frame.getContentPane().add(Title, BorderLayout.CENTER);
		frame.setForeground(Color.WHITE);
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 608, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createLineBorder(Color.white, 2));
		Title.setBounds(120, 20, 363, 50);
		
		
		Search.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD | Font.ITALIC, 19));
		Search.setSelectedIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\DSA_TH\\search.jpeg"));
		Search.setBackground(SystemColor.inactiveCaptionBorder);
		Search.setBounds(240, 200, 120, 40);
		Search.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.gray));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(Search);
		

		Addbtn.setBackground(SystemColor.inactiveCaptionBorder);
		Addbtn.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD | Font.ITALIC, 19));
		Addbtn.setBounds(100, 200, 120, 40);
		Addbtn.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.gray));
		frame.getContentPane().add(Addbtn);
		

		Exitbtn.setBackground(SystemColor.inactiveCaptionBorder);
		Exitbtn.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD | Font.ITALIC, 19));
		Exitbtn.setBounds(380, 200, 120, 40);
		Exitbtn.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.gray));
		frame.setVisible(true);
		frame.getContentPane().add(Exitbtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Addbtn==e.getSource())
		{
			ADD=true;
			frame.getContentPane().removeAll();
			
			frame.repaint();
			frame.getContentPane().add(Title);
			  
		
		frame.getContentPane().add(input);
		input.setBounds(280, 110,200, 30);
		input.setFont(new Font("Arial",Font.BOLD,15));
		input.requestFocus();
		frame.getContentPane().add(search_label);
		search_label.setBounds(150, 110, 200, 30);
		search_label.setFont(new Font("Arial",Font.BOLD,20));
		search_label.setForeground(Color.white);
		addword.setBackground(SystemColor.inactiveCaptionBorder);
		addword.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD | Font.ITALIC, 19));
		addword.setBounds(170, 320, 120, 40);
		addword.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.gray));
		frame.getContentPane().add(addword);
		
		frame.getContentPane().add(area);
		area.setBounds(150,160,330,150);
		area.setFont(new Font("Microsoft JhengHei UI Light",Font.BOLD,15));
		area.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.white, Color.gray));
		area.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);		
		
		back.setBackground(SystemColor.inactiveCaptionBorder);
		back.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD | Font.ITALIC, 19));
		back.setBounds(320, 320, 120, 40);
		back.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.gray));
		frame.getContentPane().add(back);
		 
			}
		
			if(addword==e.getSource())
			{
				h.put(input.getText(),area.getText());
				if(!input.getText().equals(""))
				{
					area.setText("Added");
					
					
				}
					
			}
				
		if(Search==e.getSource())
		{
			frame.getContentPane().removeAll();
			
			frame.repaint();
			frame.getContentPane().add(Title);
			
		
		frame.getContentPane().add(input);
		input.setBounds(280, 90,200, 30);
		input.setFont(new Font("Arial",Font.BOLD,15));
		input.requestFocus();
		
		
		frame.getContentPane().add(search_label);
		search_label.setBounds(150, 90, 200, 30);
		search_label.setFont(new Font("Arial",Font.BOLD,20));
		search_label.setForeground(Color.white);
		
		
		frame.getContentPane().add(area);
		area.setBounds(150,130,330,180);
		area.setFont(new Font("Microsoft JhengHei UI Light",Font.BOLD,15));
		area.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.white, Color.gray));
		area.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		area.setEditable(false);
		
	
		
		frame.getContentPane().add(find);
		find.setBounds(240,320,120,40);
		find.setBackground(SystemColor.inactiveCaptionBorder);
		find.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD | Font.ITALIC, 19));
		find.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.gray));
	
		} // end of search
		if(back==e.getSource() && ADD==true)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().repaint();
			//initialize();

			frame = new JFrame("WORD SEARCH");
			frame.setVisible(true);
			frame.getContentPane().setForeground(Color.WHITE);
			frame.getContentPane().setBackground(UIManager.getColor("Button.darkShadow"));
			 
					 

			Title.setBackground(SystemColor.activeCaption);
			Title.setHorizontalAlignment(SwingConstants.CENTER);
			
		
			
			Title.setLabelFor(Title);
			//Title.setHorizontalAlignment(SwingConstants.CENTER);
			Title.setFont(new Font("Segoe Print", Font.BOLD, 40));
		
			Title.setVerticalTextPosition(SwingConstants.TOP);
			
			//Title.setVerticalAlignment(SwingConstants.TOP);
			Title.setForeground(Color.WHITE);
			frame.getContentPane().add(Title, BorderLayout.CENTER);
			frame.setForeground(Color.WHITE);
			frame.setBackground(Color.BLACK);
			frame.setBounds(100, 100, 608, 409);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			((JComponent) frame.getContentPane()).setBorder(BorderFactory.createLineBorder(Color.white, 2));
			Title.setBounds(120, 20, 363, 50);
			
			
			Search.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD | Font.ITALIC, 19));
			Search.setSelectedIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\DSA_TH\\search.jpeg"));
			Search.setBackground(SystemColor.inactiveCaptionBorder);
			Search.setBounds(240, 200, 120, 40);
			Search.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.gray));
			frame.getContentPane().setLayout(null);
			frame.getContentPane().add(Search);
			

			Addbtn.setBackground(SystemColor.inactiveCaptionBorder);
			Addbtn.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD | Font.ITALIC, 19));
			Addbtn.setBounds(100, 200, 120, 40);
			Addbtn.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.gray));
			frame.getContentPane().add(Addbtn);
			

			Exitbtn.setBackground(SystemColor.inactiveCaptionBorder);
			Exitbtn.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD | Font.ITALIC, 19));
			Exitbtn.setBounds(380, 200, 120, 40);
			Exitbtn.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.gray));
			frame.getContentPane().add(Exitbtn);
			

		}
		if(find==e.getSource())
		{
			String w=input.getText();
			String k=h.key(w).toString();
				
			if(w.equals(k))
			{
			String m=h.get(w).toString();
			area.setText(m);
			
			}
			else if(w.equals(""))
				{
				area.setText("Enter word");
				}
			else {
				area.setText(h.key(w).toString());
				}
			}
	}
	public static void main(String[] args) {
		DSAProj window = new DSAProj();
		window.frame.setVisible(true);
		

}
	}

