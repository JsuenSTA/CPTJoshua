import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class arraytest{
	public static void main(String[] args){
		Console con = new Console();
		String strQuiz[][];

	}
	public static int countQuestions(String strQuizfile){
		TextInputFile txtQuizfile = new TextInputFile(strQuizfile);
		int intLines = 0;
		String strData;
		while(txtQuizfile.eof() == false){
			strData = txtQuizfile.readLine();
			intLines++;
		}
		txtQuizfile.close();
		return intLines/4;
	}

}
