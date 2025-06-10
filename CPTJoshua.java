import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTJoshua{
	public static void main(String[] args){
		Console con = new Console("Mathing training game", 1280,720);
		//con.setDrawFont(new Font("Times New Roman", Font.BOLD,30));
		//Varaibles
		String strname;
		String strquiz;
		String strselect;
		//Normal leaderboard
		String strquestion[][];
		//Sorted question
		String strquestionr[][];
		//Normal leaderboard
		String strleaderboard[][];
		String strquestioncount;
		String stranswered;
		String stravg;
		String stranswer;
		String strcontiune;
		strquiz = "";
		int intcount;
		int intleaderboardcount;
		int intanswered;
		int intavg;
		intavg = 0;
		intanswered = 0;
		char chrhelpexit;
		char chrInput;
		chrInput = ' ';
		chrhelpexit = 'a';
		boolean blnplay;
		boolean blngame;
		boolean blnhelp;
		boolean blnmoreans;
		boolean blnfilecheck;
		blnfilecheck = false;
		blnmoreans = true;
		blngame = false;
		blnplay = true;
		blnhelp = true;
		while(true){
			//Menu
			con.clear();
			con.setDrawColor(Color.BLACK);
			con.fillRect(0,0,1279,720);
			con.setDrawColor(Color.WHITE);
			con.drawString("Play (P)",500, 250);
			con.drawString("LeaderBoard (L)" ,500,300);
			con.drawString("Add quiz (A)" ,500,350);
			con.drawString("Help(h)",500, 400);
			con.drawString("Quit (Q)" ,500,450);
			con.repaint();
			chrInput = con.getChar();
			System.out.println(chrInput);
			if(chrInput == 'p' ){
				//Username input
				con.clear();
				con.repaint();
				con.setDrawColor(Color.BLACK);
				con.fillRect(0,0,1279,720);
				con.setDrawColor(Color.WHITE);
				con.println("Username: ");
				strname = con.readLine();
				con.clear();
				con.println("Welcome" + strname);
				con.println("Select quiz(Type the name correctly)\n");
				TextInputFile master = new TextInputFile("master.txt");
				while(master.eof() == false){
					strselect = master.readLine();
					con.println(strselect);
				}
				master.close();
				strquiz= con.readLine();
				//Loading in the quiz
				intcount = arraytest.countQuestions(strquiz);
				System.out.println(intcount);
				strquestion = arraytest.loadQuiz(strquiz,intcount);
				System.out.println("sorted quiz");
				strquestionr = arraytest.sortingquiz(strquestion, intcount);
				con.clear();
				con.println("Loading");
				con.sleep(1000);
				con.clear();
				blngame = true;
				intanswered = 0;
				intavg = 0;
				for (intcount = 0; intcount < strquestionr.length; intcount++) {
					con.setDrawColor(Color.BLACK);
					con.fillRect(0,0,1279,720);
					con.clear();
					con.setDrawColor(Color.WHITE);
					// Display quiz name and username
					con.drawString(strquiz, 550, 0);
					con.drawString(strname, 0, 0);
					// Display score and accuracy
					strquestioncount = (intcount) + "";
					stranswered = intanswered + "";
					intavg = (int) ((intanswered * 100.0) / intcount);
					stravg = intavg + "";
					con.drawString(stranswered, 1100, 0);
					con.drawString("/", 1125, 0);
					con.drawString(strquestioncount, 1150, 0);
					con.drawString(stravg, 1200, 0);
					con.drawString("%", 1250, 0);
					// Ask question
					con.println("\n\n");
					con.println(strquestionr[intcount][0]);
					stranswer = con.readLine();
					// Check answer
					if(stranswer.equalsIgnoreCase(strquestionr[intcount][1]) ||stranswer.equalsIgnoreCase(strquestionr[intcount][2]) ||stranswer.equalsIgnoreCase(strquestionr[intcount][3])){
						intanswered++;
						con.setDrawColor(Color.GREEN);
						con.drawString("Correct!", 600, 300);
					}else{
						con.setDrawColor(Color.RED);
						con.drawString("Incorrect!", 600, 300);
						}
					con.repaint();
					// small pause before next question
					//con.sleep(500); 
				}
				// Final score
				TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt", true);
				con.setDrawColor(Color.BLACK);
				con.fillRect(0,0,1279,720);
				con.clear();
				con.setDrawColor(Color.WHITE);
				intavg = (int) ((intanswered * 100.0) / intcount);
				con.clear();
				leaderboard.println(strname);
				leaderboard.println(strquiz);
				leaderboard.println(intavg);
				leaderboard.close();
				con.drawString("Final Score for " + strname + ":", 500, 300);
				con.drawString(intanswered + "/" + intcount + " - " + intavg + "%", 500, 400);
				con.println("Press any key to return to main menu.");
				con.getChar();
			}else if(chrInput == 'l'){
				con.clear();
				con.setDrawColor(Color.BLACK);
				con.fillRect(0,0,1279,720);
				con.setDrawColor(Color.WHITE);
				TextInputFile leaderboard = new TextInputFile("leaderboard.txt");
				intleaderboardcount = arraytest.countleaderboard();
				strleaderboard = arraytest.loadleaderboard(intleaderboardcount);
				for (intcount = 0; intcount < strleaderboard.length; intcount++) {
					con.println(strleaderboard[intcount][0]);
					con.println(strleaderboard[intcount][1]);
					con.println(strleaderboard[intcount][2]);
				}
				con.println("Press any key to leave");
				con.getChar();
			}else if(chrInput == 'h'){
				//Help screen
				con.clear();
				con.setDrawColor(Color.BLACK);
				con.fillRect(0,0,1279,720);
				con.setDrawColor(Color.WHITE);
				con.println("This is a math quiz");
				con.println("There are 3 deafult answer and you have to type it out");
				con.println("The game with calculate the average with the accuracy");
				con.println("Your goal is to get 100% with the questions");
				con.println("Press any key to return to main menu.");
				con.getChar();
			}else if(chrInput =='a'){
				//add quiz
				con.clear();
				con.setDrawColor(Color.BLACK);
				con.fillRect(0,0,1279,720);
				con.setDrawColor(Color.WHITE);
				//Setting up file name
				con.println("Create your quiz");
				con.println("Follow the txt format");
				con.println("Ex: adding.txt");
				strquiz = con.readLine();
				TextOutputFile newquiz = new TextOutputFile(strquiz, true);
				con.println("Let's start creating your "+strquiz);
				con.sleep(1000);
				con.clear();
				//The process of adding qustion
				while(blnmoreans == true){
					con.println("Question one");
					String strQuestion = con.readLine();
					newquiz.println(strQuestion);
					con.println("Answer 1");
					String strAnswerone = con.readLine();
					newquiz.println(strAnswerone);
					con.println("Answer 2");
					String strAnswertwo = con.readLine();
					newquiz.println(strAnswertwo);
					con.println("Answer 3");
					String strAnswerthree = con.readLine();
					newquiz.println(strAnswerthree);
					con.println("Do you wanna contiune adding question");
					con.println("If you want to contiune, press y");
					con.println("If you want to leave, press any letter key");
					strcontiune = con.readLine();
					if(!strcontiune.equalsIgnoreCase("y")){
						blnmoreans = false;
					}else{
						con.clear();	
					}
			}		
			}else if(chrInput == 'q'){
				con.closeWindow();
			}
		}
	}
}
