
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;	
import javax.swing.JFrame;



public class GMIBMI  extends JFrame   {

	String name;
	int age;
	double weight;
	double height;
	public static void main(String[] args){
		GMIBMI test= new GMIBMI();
		test.setSize(400,300);
		test.setTitle("GUI_BMI");
		test.setLocationRelativeTo(null);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.getContentPane().setLayout(new GridBagLayout());
	
		test.setVisible(true);
	}
	
	public GMIBMI(){
		
		JLabel l1 = new JLabel("Name:");
		GridBagConstraints g1 = new GridBagConstraints();
		g1.gridx = 0;
		g1.gridy = 0;
		g1.gridwidth = 1;
		g1.gridheight = 1;
		g1.fill = GridBagConstraints.NONE;
		g1.anchor = GridBagConstraints.WEST;
		this.getContentPane().add(l1,g1);
		
		
		JLabel l2 = new JLabel("age:");
		GridBagConstraints g2 = new GridBagConstraints();
		g2.gridx = 0;
		g2.gridy = 1;
		g2.gridwidth = 1;
		g2.gridheight = 1;
		g2.fill = GridBagConstraints.NONE;
		g2.anchor = GridBagConstraints.WEST;
		this.getContentPane().add(l2,g2);
		
		
		JLabel l3 = new JLabel("weight(in kg):");
		GridBagConstraints g3 = new GridBagConstraints();
		g3.gridx = 0;
		g3.gridy = 2;
		g3.gridwidth = 1;
		g3.gridheight = 1;
		g3.fill = GridBagConstraints.NONE;
		g3.anchor = GridBagConstraints.WEST;
		this.getContentPane().add(l3,g3);
		
		
		JLabel l4 = new JLabel("height(in meter):");
		GridBagConstraints g4 = new GridBagConstraints();
		g4.gridx = 0;
		g4.gridy = 3;
		g4.gridwidth = 1;
		g4.gridheight = 1;
		g4.fill = GridBagConstraints.NONE;
		g4.anchor = GridBagConstraints.WEST;
		this.getContentPane().add(l4,g4);
		
		
		JTextField jt1 = new JTextField();
		GridBagConstraints g5 = new GridBagConstraints();
		g5.gridx = 2;
		g5.gridy = 0;
		g5.gridwidth = 8;
		g5.gridheight = 1;
		g5.fill = GridBagConstraints.BOTH;
		g5.anchor = GridBagConstraints.WEST;
		String name = jt1.getText();
		this.add(jt1,g5);
		
		JTextField jt2 = new JTextField();
		GridBagConstraints g6 = new GridBagConstraints();
		g6.gridx = 2;
		g6.gridy = 1;
		g6.gridwidth = 8;
		g6.gridheight = 1;
		g6.fill = GridBagConstraints.BOTH;
		g6.anchor = GridBagConstraints.WEST;
		String ageTemp = jt2.getText();
		int age = Integer.parseInt(ageTemp);
		this.add(jt2,g6);
		
		JTextField jt3 = new JTextField();
		GridBagConstraints g7 = new GridBagConstraints();
		g7.gridx = 2;
		g7.gridy = 2;
		g7.gridwidth = 8;
		g7.gridheight = 1;
		g7.fill = GridBagConstraints.BOTH;
		g7.anchor = GridBagConstraints.WEST;
		String weightTemp = jt3.getText();
		double weight = Double.parseDouble(weightTemp);
		this.add(jt3,g7);
		
		JTextField jt4 = new JTextField();
		GridBagConstraints g8 = new GridBagConstraints();
		g8.gridx = 2;
		g8.gridy = 3;
		g8.gridwidth = 8;
		g8.gridheight = 1;
		g8.fill = GridBagConstraints.BOTH;
		g8.anchor = GridBagConstraints.WEST;
		String heightTemp = jt4.getText();
		double height = Double.parseDouble(heightTemp);
		this.add(jt4,g8);
		
		JButton jb1 = new JButton("start");
		GridBagConstraints g9 = new GridBagConstraints();
		g9.gridx = 6;
		g9.gridy = 5;
		g9.gridwidth = 2;
		g9.gridheight = 1;
		g9.fill = GridBagConstraints.BOTH;
		g9.anchor = GridBagConstraints.EAST;
		this.add(jb1,g9);
		jb1.addActionListener( new ButtonListener () );
		
		
	}
		
		
		class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
			BMI bmi = new BMI(name,age,weight,height);
			JLabel jb5 = new JLabel("Your BMI is" + bmi.getBMI() + ".");
			GridBagConstraints g10 = new GridBagConstraints();
			g10.gridx = 0;
			g10.gridy = 7;
			g10.gridwidth = 1;
			g10.gridheight = 1;
			
			
			JLabel jb6 = new JLabel();
			JLabel g11 = new JLabel("Your status:" + bmi.getStatus());
			
			}
		}


		

	
}

class BMI {
  private String name;
  private int age;
  private double weight; // in pounds
  private double height; // in inches
  public static final double KILOGRAMS_PER_POUND = 0.45359237; 
  public static final double METERS_PER_INCH = 0.0254;  
  
  public BMI(String name, int age, double weight, double height) {
    this.name = name;
    this.age = age;
    this.weight = weight;
    this.height = height;
  }
  
  public BMI(String name, double weight, double height) {
    this(name, 20, weight, height);
  }
  
  public double getBMI() {
    double bmi = weight * KILOGRAMS_PER_POUND / 
      ((height * METERS_PER_INCH) * (height * METERS_PER_INCH));
    return Math.round(bmi * 100) / 100.0;
  }
  
  public String getStatus() {
    double bmi = getBMI();
    if (bmi < 18.5)
      return "Underweight";
    else if (bmi < 25)
      return "Normal";
    else if (bmi < 30)
      return "Overweight";
    else
      return "Obese";
  }
  
  public String getName() {
    return name;
  }
  
  public int getAge() {
    return age;
  }
  
  public double getWeight() {
    return weight;
  }
  
  public double getHeight() {
    return height;
  }






  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
