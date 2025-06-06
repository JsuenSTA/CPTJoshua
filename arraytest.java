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
		strQuiz = new String[intCount][5];
		TextInputFile txtQuizfile = new TextInputFile(strQuizfile);
		int intRow;
		int intRand;
		for(intRow = 0; intRow < intCount; intRow++){
			strQuiz[intRow][0] = txtQuizfile.readLine();
			strQuiz[intRow][1] = txtQuizfile.readLine();
			strQuiz[intRow][2] = txtQuizfile.readLine();
			strQuiz[intRow][3] = txtQuizfile.readLine();
			intRand = (int)(Math.random()*100+1);
			strQuiz[intRow][4] = intRand + "";
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
	public static String[][] sortingquiz(String strQuiz[][], int intCount){
		String strquestionTemp;
		String stranswertemp1;
		String stranswertemp2;
		String stranswertemp3;
		int intCount2;
		int intRow;
		intRow = intCount;
		for(intCount2 = 0; intCount2 < 5-1; intCount2++){
			for(intCount = 0; intCount < 5-1; intCount++){
				// Convert the people's score to integer and compare
				if(Integer.parseInt(strQuiz[intCount][2]) > Integer.parseInt(strQuiz[intCount+1][2])){
					// Swap here
					// swap questions
					strquestionTemp = strQuiz[intCount][0];
					strQuiz[intRow][0] = strQuiz[intRow+1][0];
					strQuiz[intRow+1][0] = strquestionTemp;
					
					// swap answer 1
					strquestionTemp = strQuiz[intCount][1];
					strQuiz[intRow][1] = strQuiz[intRow+1][1];
					strQuiz[intRow+1][1] = strquestionTemp;
					// swap answer 2
					strquestionTemp = strQuiz[intCount][2];
					strQuiz[intRow][2] = strQuiz[intRow+1][2];
					strQuiz[intRow+1][2] = strquestionTemp;
					// swap answer 2
					strquestionTemp = strQuiz[intCount][3];
					strQuiz[intRow][3] = strQuiz[intRow+1][3];
					strQuiz[intRow+1][3] = strquestionTemp;

				}
				
			}
		}
		return strQuiz;
	}
	public static void printQuestions(String strQuiz[][], int intCount, Console con){
		int intRow;
		for(intRow = 0; intRow < intCount; intRow++){
			con.println(strQuiz[intRow][0]);
			con.println(strQuiz[intRow][1]);
			con.println(strQuiz[intRow][2]);
			con.println(strQuiz[intRow][3]);
		}
	}
}

