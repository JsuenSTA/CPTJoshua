import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class arraytest{
	public static void main(String[] args){
		Console con = new Console();
		String strQuiz[][];
		int intCount = countQuestions("algebra.txt");
		strQuiz = loadQuiz("algebra.txt",intCount);
	}
	public static String[][] loadQuiz(String strQuizfile, int intCount){
		String strQuiz[][];
		strQuiz = new String[intCount][4];
		TextInputFile txtQuizfile = new TextInputFile(strQuizfile);
		int intRow;
		for(intRow = 0; intRow < intCount; intRow++){
			strQuiz[intRow][0] = txtQuizfile.readLine();
			strQuiz[intRow][1] = txtQuizfile.readLine();
			strQuiz[intRow][2] = txtQuizfile.readLine();
			strQuiz[intRow][3] = txtQuizfile.readLine();
		}
		txtQuizfile.close();
		return strQuiz;
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
