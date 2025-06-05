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
		int intcount;
		char chrhelpexit;
		char chrInput;
		chrInput = ' ';
		chrhelpexit = 'a';
		boolean blnplay;
		boolean blnhelp;
		blnplay = true;
		blnhelp = true;
		TextInputFile master = new TextInputFile("master.txt");
		//Set backgroundcolor
		//Menu
		while(true){
			while(chrInput != 'p'||chrInput != 'l' || chrInput !='a'|| chrInput != 'h'){
				con.clear();
				con.drawString("Play (P)",500, 250);
				con.drawString("LeaderBoard (L)" ,500,300);
				con.drawString("Add quiz (A)" ,500,350);
				con.drawString("Help(h)",500, 400);
				con.drawString("Quit (Q)" ,500,450);
				chrInput = con.getChar();
				System.out.println(chrInput);
				if(chrInput == 'p' ){
					//Username input
					con.clear();
					con.setDrawColor(Color.BLACK);
					con.fillRect(0,0,1279,720);
					con.setDrawColor(Color.WHITE);
					con.println("Username: ");
					strname = con.readLine();
					con.clear();
					//Selecting quiz
					con.println("Welcome" + strname);
					con.println("Select quiz(Type the name correctly)\n");
					while(master.eof() == false){
						strselect = master.readLine();
						con.println(strselect);
					}
					master.close();
					strquiz= con.readLine();
					//Loading in the quiz
					intcount = arraytest.countQuestions(strquiz);
					System.out.println(intcount);
				}
				if(chrInput == 'h'){
					con.clear();
					con.setDrawColor(Color.BLACK);
					con.fillRect(0,0,1279,720);
					con.setDrawColor(Color.WHITE);
					con.println("This is a math quiz");
					con.println("There are 3 deafult answer and you have to type it out");
					con.println("The game with calculate the average with the accuracy");
					con.println("Your goal is to get 100% with the questions");
					con.println("Press l to leave the help menu");
					System.out.println("it contiuned");
					blnhelp = false;
				}
				if(chrInput == 'q'){
					con.closeWindow();
				}
			}
		}
	}
}
