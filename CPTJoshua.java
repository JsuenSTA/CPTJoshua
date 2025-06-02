import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTJoshua{
	public static void main(String[] args){
		Console con = new Console("Mathing training game", 1280,720);
		//Varaibles
		String strname;
		//Set backgroundcolor
		
		
		//Menu
		while(true){
			con.drawString("Play (P)",500, 250);
			con.drawString("LeaderBoard (L)" ,500,300);
			con.drawString("Add quiz (A)" ,500,350);
			con.drawString("Quit (Q)" ,500,400);
			con.fillRect(0,0,1200,720);
			char chrInput = con.getChar();
			if(chrInput == 'P' || chrInput == 'p'){
				con.setDrawColor(Color.BLACK);
				con.fillRect(0,0,1200,720);
			}
		}
	}
}
