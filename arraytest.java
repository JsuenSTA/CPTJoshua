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
			//Random number for sorting
			intRand = (int)(Math.random()*100+1);
			strQuiz[intRow][4] = intRand + "";
			System.out.println(intRand);
		}
		txtQuizfile.close();
		return strQuiz;
	}

	public static int countQuestions(String strQuiz){
		TextInputFile txtQuizfile = new TextInputFile(strQuiz);
		int intLines = 0;
		String strData;
		while(txtQuizfile.eof() == false){
			strData = txtQuizfile.readLine();
			intLines++;
		}
		txtQuizfile.close();
		return (intLines/4) ;
	}
	public static String[][] sortingquiz(String strQuiz[][], int intCount){
		String strTemp;
		for(int intpass = 0; intpass < intCount - 1; intpass++){
			for(int introw = 0; introw < intCount - 1 - intpass; introw++){
				// Compare the 5th column (index 4) as integer
				if(Integer.parseInt(strQuiz[introw][4]) > Integer.parseInt(strQuiz[introw+1][4])){
					// Swap the entire row
					for(int intcol = 0; intcol < 5; intcol++){
						strTemp = strQuiz[introw][intcol];
						strQuiz[introw][intcol] = strQuiz[introw+1][intcol];
						strQuiz[introw+1][intcol] = strTemp;
					}
				}
			}
		}
		return strQuiz;
	}

 
}

