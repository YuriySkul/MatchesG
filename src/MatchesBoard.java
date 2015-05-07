
import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MatchesBoard extends JPanel implements ActionListener {

	int n = 13;
	Image image;
	JFrame frame;
	int scale = 16;
	int hight = 20;
	int width = 70;
	JButton start;
	JButton move;
	JButton help;
	JButton [] button =new JButton[n];
	MatchesBoard(){
		
		frame = new JFrame("Спички Ску.Ю.В.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width*scale+10, hight*scale);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(this);
		
		this.setLayout(null);
		

		
		 move = new JButton("move");
		move.addActionListener((ActionListener) this);
		 help = new JButton("help");
		 help.addActionListener((ActionListener) this);
		JButton goBack = new JButton("move back");
		JTextField numberOfMatches = new JTextField();
		start = new JButton("Start/Restart");
		JButton youRFirst = new JButton("Комп ходит первым");


		for(int k=0;k<n;k++){
			 button [k] =new JButton(new ImageIcon("spichkz.jpg"));
			 this.add( button [k]);
			  
			 button [k].setBounds(1*scale+4*k*scale, 1*scale, 64, 212);
			 button [k].addActionListener((ActionListener) this); 
		}
		   

		this.add(start);
		this.add(move);
		this.add(help);
		this.add(goBack);
		this.add(start);
		this.add(numberOfMatches);
		this.add(youRFirst);

	 	    
	    move.setBounds(10*scale, 15*scale,17*scale,2*scale);
		numberOfMatches.setText("   Input number of matches");
		numberOfMatches.setBounds(58*scale, 12*scale,11*scale,2*scale);
		goBack.setBounds(58*scale, 5*scale,11*scale,2*scale);
		help.setBounds(58*scale, 1*scale,11*scale,2*scale);
		youRFirst.setBounds(58*scale, 15*scale,11*scale,2*scale);
		start.setBounds(58*scale, 9*scale,11*scale,2*scale);
	
		frame.setVisible(true);
	   
	   
	}

	public Color color(int red,int green,int black){
		return new Color(red,green,black);
	};
//    public void paint(Graphics g){
//		frame.setBackground(color(213,213,213));
//       	g.setColor(color(0,13,25));
//    	for(int k = 0; k < width*scale; k += scale){
//	        g.drawLine(k, 0, k, hight*scale);
// 	        }
//    	   for(int k = 0; k < width*scale; k += scale){
//         		g.drawLine(0, k, width*scale, k);
//     	   }	
//	        paintChildren(g);
//	};   
	  
	   
   
	int clickCounter = 0;
	public void actionPerformed(ActionEvent e){
       JButton clickedButton = (JButton) e.getSource();
       if(clickedButton == help){
    	   JFrame hf = new JFrame();
    	   hf.setLocationRelativeTo(null);
    	   hf.setVisible(true);
    	   hf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	   JTextArea tA=new JTextArea(10,30);
    	   JPanel helpP = new JPanel();
    	   hf.add(helpP);
    	  
    	   tA.setText("Правила игры просты. Ходят поочереди - вы - компьютер - вы - компьютер и т.д. Разрешается брать одну, две или     три  спички на ваш выбор.                                                           Тот кто забирает последнюю - проигравший.");
    	   tA.setLineWrap(true);
    	   helpP.add(tA);
    	   hf.pack();
    	   
       }
       if (clickedButton == move){
        	movePC();
        	clickCounter = 0;
        }else if(clickCounter<3) {
                clickedButton.setVisible(false);
                 clickCounter++;
                  n--;
       
        System.out.println("клик");
        System.out.println(n);
//        clickedButton.update(getGraphics());
//        clickedButton.repaint();
        };
        if(n==0){
           
        	final JFrame los = new JFrame("ТЫ - ЛУЗЕР,тут нельзя выиграть");
        	JPanel p = new JPanel();
        	
        	los.setLayout(null);
        	los.add(p);
        	
        	
        	
        	los.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	los.setSize(20*scale, 10*scale);

        	
        	JLabel tex = new JLabel("            Вы проиграли");
        	los.add(tex);
        	tex.setBounds(5*scale  , 1*scale, 11*scale, 3*scale);
        	
        	JButton again = new JButton("Хочу ещё раз");
        	los.add(again);
        	again.setBounds(5*scale, 4*scale, 10*scale, 3*scale);
        	los.setLocationRelativeTo(null);
        	class TestActionListener implements ActionListener {
        	     public void actionPerformed(ActionEvent e) {
        	          los.setVisible(false);
        	          los.dispose();
        	          MatchesBoard myGb = new MatchesBoard();
        	     }
        	}
        	ActionListener actionListener = new TestActionListener();
        	 again.addActionListener(actionListener);
    	      	
    		
//        	los.pack();
    		los.setResizable(false);
            los.setVisible(true);  
        }
       }

	
    
    
	    public void movePC(){
	    	System.out.println("ход компьютера"+n);
	    	
	    	int m = (n-1)%4;
	    	n =n-m; 
	    	int k = 0;
	    	System.out.println("надо убрать "+ m);
	    	for ( int n=0; k<m; n++){
	    	   			if(button[n].isVisible()){
	    				  button[n].setVisible(false);
	    				  k++;
	    				  
	    			}
    	}
    			
    }
	public static void main(String[] args) {
		MatchesBoard myGb = new MatchesBoard();


		
	}

}

