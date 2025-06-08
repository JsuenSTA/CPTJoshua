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
	for(int pass = 0; pass < intCount - 1; pass++){
		for(int row = 0; row < intCount - 1 - pass; row++){
			// Compare the 5th column (index 4) as integer
			if(Integer.parseInt(strQuiz[row][4]) > Integer.parseInt(strQuiz[row+1][4])){
				// Swap the entire row
				for(int col = 0; col < 5; col++){
					strTemp = strQuiz[row][col];
					strQuiz[row][col] = strQuiz[row+1][col];
					strQuiz[row+1][col] = strTemp;
				}
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

