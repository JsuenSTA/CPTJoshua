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
		//Set backgroundcolor
		//Menu
		while(true){
			con.drawString("Play (P)",500, 250);
			con.drawString("LeaderBoard (L)" ,500,300);
			con.drawString("Add quiz (A)" ,500,350);
			con.drawString("Help(h)",500, 400);
			con.drawString("Quit (Q)" ,500,450);
			char chrInput = con.getChar();
			System.out.println(chrInput);
			while(chrInput != 'p'||chrInput != 'l' || chrInput !='a'|| chrInput != 'h'){
				if(chrInput == 'p'){
					con.clear();
					con.setDrawColor(Color.BLACK);
					con.fillRect(0,0,1279,720);
					System.out.println("work");
					con.setDrawColor(Color.WHITE);
					con.drawString("Username: ", 500, 250);
					strname = con.readLine();
					//con.setDrawColor(Color.BLACK);
					//con.fillRect(0,0,1279,720);
					con.setDrawColor(Color.WHITE);
					con.clear();
					con.drawString("Welcome" + strname, 500,250);
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
					while(chrInput != 'l'){
						con.sleep(10000);
						chrInput = con.getChar();
					}
					break;
				}
				if(chrInput == 'q'){
					con.closeWindow();
				}
			}
		}
	}
}
