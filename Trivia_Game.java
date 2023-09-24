import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Trivia_Game implements ActionListener {
	JFrame frame;
	JRadioButton response1, response2, response3, response4;
	JButton submit;
	JLabel question, score;
	ButtonGroup button;
	boolean answers4 = false, nextRound = false;
	int round = 0, points = 0;
	
	String ques[] = {"Fossil fuels, like the gas we put in our cars, comes from:", "Which of the following is a greenhouse gas?",
    "What is the greenhouse effect?", "Which of the following are consequences associated with climate change?", 
    "Trees can help remove carbon dioxide (a greenhouse gas) from the atmosphere by:", 
    "What was agreed to in the Paris Agreement(held in Paris in 2015)?", 
    "Which of the following countries have the most carbon dioxide emission rate?", 
    "What percentage does transportation take up in global GHG emissions?", 
    "What can you do to help fight climate change?", "Which of the following economic sectors emits the largest percentage of GHG?",
    "Which has been the hottest year on record?"};
	
	String op1[] = { "Natural history museums", "CO2", "When houses become green", "Ice sheets declining", "Cellular respiraton"
	, "Protect biodiversity, end deforestation in rainforests", "China", "1%", "Divest from fossil fuel companies",
	"Transportation", "2016"};
	String op2[] = { "The internet", "CH4", "Glass building that protects plants from cold",
			"Polar bears declining", "Advocating for Earth day", "Maintain steady global temperature, limit global warming"
	, "USA", "33%", "Engage yourself in the science behind climate change", "Buildings", "2020"};
	String op3[] = { "Cavemen dinner leftovers", "Water Vapor", "When GHGs trap the sun's heat in Earth", 
			"More invasive and disease-ridden insects", "Photosynthesis", "To limit sea level rise to 3 feet above current levels"
	, "Russia", "69%", "Vote for those who will focus fixing the climate", "Industry", "2018"};
	String op4[] = { "Organisms that died millions of years ago", "All of the above", "None of the above", "All of the above", "Playing classical music", 
			"To pursue a goal of 100% clean, renewable energy", 
			"India", "14%", "All of the above", "Electricity and heat production", "All of the above"};
	
	String ans[] = { "Organisms that died millions of years ago", "All of the above", "When GHGs trap the sun's heat in Earth",
			"All of the above", "Photosynthesis", "Maintain steady global temperature, limit global warming", 
			"China", "14%", "All of the above", "Electricity and heat production", "All of the above"};

	Trivia_Game() {
		
		// make and set details for game window
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(850, 500);
		Container c = frame.getContentPane();
		c.setBackground(Color.cyan);
		
		// assume 2 answers only
		answers4 = false; 
		
		// prints question
		question = new JLabel(ques[round]);
		question.setBounds(50, 50, 1000, 40);
		frame.add(question);
		question.setFont(new Font("arial", Font.BOLD, 20));
		
		//Score
		score = new JLabel("Score: " + String.valueOf(points));
		score.setBounds(50, 80, 1000, 40);
		frame.add(score);
		score.setFont(new Font("arial", Font.BOLD, 20));
		
		// responses are retrieved
		response1 = new JRadioButton(op1[round]);
		response1.setBounds(50, 170, 350, 60);
		frame.add(response1);
		
		response2 = new JRadioButton(op2[round]);
		response2.setBounds(450, 170, 350, 60);
		frame.add(response2);
		
		button = new ButtonGroup();
		button.add(response1);
		button.add(response2);
		response3 = new JRadioButton(op3[round]);
		response3.setBounds(50, 250, 350, 60);
		frame.add(response3);
		response4 = new JRadioButton(op4[round]);
		response4.setBounds(450, 250, 350, 60);
		frame.add(response4);
		answers4 = true;
		
		response1.addActionListener(this);
		response2.addActionListener(this);
		
		if(answers4) {
			button.add(response3);
			button.add(response4);
			response3.addActionListener(this);
			response4.addActionListener(this);
		}
		
		// submit and next buttons
		submit = new JButton("Submit");
		submit.setBounds(370, 400, 100, 30);
		frame.add(submit);
		submit.addActionListener(this);
		frame.setVisible(true);
	}

	// driver code
	public static void main(String s[]) {
		new Trivia_Game();
	}

	// button is clicked
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			String en = "";
			if (response1.isSelected())
				en = response1.getText();
			if (response2.isSelected())
				en = response2.getText();
			if(answers4) {
				if (response3.isSelected())
					en = response3.getText();
				if (response4.isSelected())
					en = response4.getText();
			}
			if (en.equals(ans[round])) {
				JOptionPane.showMessageDialog(null, "CORRECT!");
				points++;
				frame.remove(score);
				score = new JLabel("Score: " + String.valueOf(points));
				score.setBounds(50, 80, 1000, 40);
				frame.add(score);
				score.setFont(new Font("arial", Font.BOLD, 20));
				nextRound = true;
			} else {
				JOptionPane.showMessageDialog(null, "Ah! So close!");
				nextRound = true;
			}
		}
		if (nextRound) {
			round++;
			
			// game ends
			if(round == 11) {
				JOptionPane.showMessageDialog(null, "Score: " + String.valueOf(points) + " | Hope you enjoyed! :)");
				System.exit(0);
			}
			
			// new question is assigned
			question.setText(ques[round]);
			response1.setText(op1[round]);
			response2.setText(op2[round]);
			
			if(answers4) {
				response3.setText(op3[round]);
				response4.setText(op4[round]);
			}
			nextRound = false;
			
			// clear button
			button.clearSelection();
		}
	}
	
}