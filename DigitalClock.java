import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DigitalClock extends JPanel implements ActionListener {
	JFrame jf;
	Timer t;
	Calendar c;
	String month, day, clock = "", date = "";
	int y,m,d,h,min,s, dm;
	boolean sec = true;
	public DigitalClock() {
		jf = new JFrame("Clock");
		jf.add(this);
		t = new Timer(1000,this);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(500, 500);
		jf.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 250, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 250);
		jf.setResizable(false);
		jf.setVisible(true);
		t.start();
	}
	
	public static void main(String args[]) {
		new DigitalClock();
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, jf.getWidth(), jf.getHeight());
		g.setColor(Color.green.brighter());
		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.drawString(clock, 160, 300);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.drawString(date, 100, 150);
		g.drawString("" + y, 200, 200);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		sec = !sec;
		c = Calendar.getInstance();
		y = c.get(Calendar.YEAR);
		m = c.get(Calendar.MONTH) + 1;
		d = c.get(Calendar.DAY_OF_WEEK);
		h = c.get(Calendar.HOUR_OF_DAY);
		min = c.get(Calendar.MINUTE);
		s = c.get(Calendar.SECOND);
		dm = c.get(Calendar.DAY_OF_MONTH);
		mToString();
		dToString();
		
		if(sec)
			clock = String.format("%02d:%02d:%02d", h,min,s);
		else
			clock = String.format("%02d %02d %02d", h, min, s);
		date = String.format("%s, %d of %s", day, dm, month);
		
		repaint();
	}
	public void mToString(){
		switch(m){
		case 1:
			month = "January";
			break;
		case 2:
			month = "February";
			break;
		case 3:
			month = "March";
			break;
		case 4:
			month = "April";
			break;
		case 5:
			month = "May";
			break;
		case 6:
			month = "June";
			break;
		case 7:	
			month = "July";
			break;
		case 8:
			month = "August";
			break;
		case 9:
			month = "September";
			break;
		case 10:
			month = "October";
			break;
		case 11:
			month = "November";
			break;
		case 12:
			month = "December";
			break;
		default:	
			month = "";
		}
	}
	public void dToString(){
		switch(d){
		case 1:
			day = "Sunday";
			break;
		case 2:	
			day = "Monday";
			break;
		case 3:
			day = "Tuesday";
			break;
		case 4:
			day = "Wensday";
			break;
		case 5:
			day = "Thursday";
			break;
		case 6:
			day = "Friday";
			break;
		case 7:
			day = "Saturday";
			break;
		default:
			day = "";
		}
	}
}