//-----------------------------------------------------------------
//Author: Joshua
//Program Name: CPTJoshua
//Creation Date: May 25,2025
//Version Number:  v1.0
//-----------------------------------------------------------------

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
		String strfile;
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
		BufferedImage imglogo = con.loadImage("logo.png");
		con.clear();
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1279,720);
		con.setDrawColor(Color.WHITE);
		con.drawString("Welcome to Math Quiz",480,260);
		con.drawImage(imglogo,480,300);
		con.repaint();
		con.sleep(2000);
		while(true){
			//Menu
			con.clear();
			con.setDrawColor(Color.BLACK);
			con.fillRect(0,0,1279,720);
			con.setDrawColor(Color.WHITE);
			con.drawString("Menu",500,200);
			con.drawString("Play (P)",500, 250);
			con.drawString("Leaderboard (L)" ,500,300);
			con.drawString("Add quiz (A)" ,500,350);
			con.drawString("Help (H)",500, 400);
			con.drawString("Quit (Q)" ,500,450);
			con.repaint();
			chrInput = con.getChar();
			if(chrInput == 'p' || chrInput == 'P'){
				//Username input
				con.clear();
				con.repaint();
				con.setDrawColor(Color.BLACK);
				con.fillRect(0,0,1279,720);
				con.setDrawColor(Color.WHITE);
				con.println("Username: ");
				strname = con.readLine();
				con.clear();
				con.println("Welcome " + strname);
				con.println("Select quiz\n");
				while(blnfilecheck == false){
					TextInputFile masterlist= new TextInputFile("master.txt");
					while(masterlist.eof() == false){
						strselect = masterlist.readLine();
						con.println(strselect);
					}
					masterlist.close();
					con.print("\n");
					strquiz = con.readLine();
					TextInputFile mastercheck= new TextInputFile("master.txt");
					while(mastercheck.eof() == false){
						strfile = mastercheck.readLine();
						if(strfile.equals(strquiz)){
							blnfilecheck = true;
						}
					}
					mastercheck.close();
					//If user enter an invald option
					if(blnfilecheck == false){
						con.clear();
						con.println("Invalid choice...");
						con.println("Please retype your option");
						con.sleep(2000);
						con.clear();
					} 
				}
				strquiz =strquiz+".txt";
				//Loading in the quiz
				intcount = arraytest.countQuestions(strquiz);
				System.out.println("Before sorted");
				strquestion = arraytest.loadQuiz(strquiz,intcount);
				for (intcount = 0; intcount < strquestion.length; intcount++){
					System.out.println(strquestion[intcount][4]);
				}
				strquestionr = arraytest.sortingquiz(strquestion, intcount);
				System.out.println("After sorted");
				for (intcount = 0; intcount < strquestionr.length; intcount++) {
					System.out.println(strquestionr[intcount][4]);
				}
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
					con.sleep(500); 
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
			}else if(chrInput == 'l' || chrInput == 'L'){
				//Leaderboard
				con.clear();
				con.setDrawColor(Color.BLACK);
				con.fillRect(0,0,1279,720);
				con.setDrawColor(Color.WHITE);
				//Reading leaderboard.txt
				TextInputFile leaderboard = new TextInputFile("leaderboard.txt");
				intleaderboardcount = arraytest.countleaderboard();
				strleaderboard = arraytest.loadleaderboard(intleaderboardcount);
				for (intcount = 0; intcount < strleaderboard.length; intcount++) {
					con.drawString("Name",350,70);
					con.drawString("Quiz",500,70);
					con.drawString("Score",850,70);
					con.drawString(strleaderboard[intcount][0],350,(120+intcount*50));
					con.drawString(strleaderboard[intcount][1],500,(120+intcount*50));
					con.drawString(strleaderboard[intcount][2],850,(120+intcount*50));
				}
				con.println("Press any key to leave");
				con.getChar();
			}else if(chrInput == 's' || chrInput == 'S'){
				//Secret Menu
				con.setDrawColor(Color.BLACK);
				con.fillRect(0,0,1279,720);
				con.clear();
				con.setDrawColor(Color.WHITE);
				con.println("Congrats you found the secret menu\n\n");
				con.println("What did the shark say when he ate the clownfish?");
				con.println("This tastes a little funny.");
				con.println("\nPress any key to go back");
				con.getChar();
			}else if(chrInput == 'h' || chrInput == 'H'){
				//Help screen
				con.clear();
				con.setDrawColor(Color.BLACK);
				con.fillRect(0,0,1279,720);
				con.setDrawColor(Color.WHITE);
				con.println("This is a math quiz\n");
				con.println("There are 3 deafult answer and you have to type it out");
				con.println("The game with calculate the average with your accuracy");
				con.println("Your goal is to get 100% with the questions\n");
				con.println("Press any key to return to main menu.");
				con.getChar();
			}else if(chrInput =='a' || chrInput == 'A'){
				//add quiz
				con.clear();
				con.setDrawColor(Color.BLACK);
				con.fillRect(0,0,1279,720);
				con.setDrawColor(Color.WHITE);
				//Setting up file name
				con.println("Create your quiz");
				con.println("What's the name of the quiz");
				con.println("Ex: adding, subtracting");
				strquiz = con.readLine();
				TextOutputFile master = new TextOutputFile("master.txt", true);
				master.println(strquiz);
				master.close();
				TextOutputFile newquiz = new TextOutputFile(strquiz+".txt", true);
				con.println("Let's start creating your "+strquiz);
				con.sleep(1000);
				con.clear();
				//The process of adding qustion
				while(blnmoreans == true){
					con.println("Question: ");
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
					chrInput = con.getChar();
					if(chrInput =='y'){
						con.clear();
					}else{
						newquiz.close();
						blnmoreans = false;
					}
			}		
			}else if(chrInput == 'q' || chrInput == 'Q'){
				//Quit 
				con.closeWindow();
			}
		}
	}
}
