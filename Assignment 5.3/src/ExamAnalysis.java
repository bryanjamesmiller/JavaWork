//ExamAnalysis.java

/** 
 *  This program takes user input for the correct answers
 *  to exam questions and the actual student responses
 *  contained in a data file.  It then echos the data file to 
 *  the computer screen.  It also outputs a list of the students' 
 *  scores in the form of number of correct answers, incorrect 
 *  answers, and blank answers given by student number.  Finally,
 *  it lists how the group as a whole answered each question
 *  on the exam.
 *  
 *  
 * @author    Bryan Miller
 * @version   Last modified on 3/14/2014
 **/
import java.io.*;
import java.util.*;
public class ExamAnalysis {

	public static void main(String [] args){
		Scanner userInput = new Scanner(System.in);
		String answerKey=getAnswerKey(userInput);
		File studentData=getStudentsAnswersFile(userInput);

		ArrayList<String> myArrayListOfAllStudentAnswers = new ArrayList<String>();
		int numStudents=getStudentsResults(answerKey, studentData, myArrayListOfAllStudentAnswers);

		System.out.println("\n\nQUESTION ANALYSIS    (* marks the correct response)");
		System.out.println("~~~~~~~~~~~~~~~~~\n");
		printAnswersPercentages(numStudents, answerKey, myArrayListOfAllStudentAnswers);
	}

	/** 
	 *  This method obtains an answer key input from the user through
	 *  they keyboard.
	 *
	 * @param	userInput	The Scanner object is passed to read in the answer key
	 * 			from the user's input.
	 * 	
	 * @return	The String value containing the answer key in all capital
	 * 			letters.	
	 **/
	public static String getAnswerKey(Scanner userInput){
		System.out.println("I hope you are ready to begin ...\n");
		System.out.println("Please type the correct answers to the exam questions,");
		System.out.print(" one right after the other:   ");

		String answerKey = userInput.next();
		return answerKey.toUpperCase();
	}

	/** 
	 *  This method obtains the file containing each students answers
	 *  from user input and prints out each student's answers.
	 *
	 * @param	userInput	The Scanner object is passed to read in the name
	 * 			of the file where the students' answers are located.
	 * 
	 * @return	The File object is returned to main so the 
	 * 			studentData can be used.
	 **/
	public static File getStudentsAnswersFile(Scanner userInput){
		System.out.println("What is the name of the file containing each student's");
		System.out.print(" responses to the 10 questions?  ");
		String studentAnswersFile=userInput.next();
		System.out.println();
		File studentData=new File(studentAnswersFile);
		int numStudents=0;
		try{
			Scanner fileReader=new Scanner(studentData);
			while(fileReader.hasNext()){
				String aStudentsAnswers=fileReader.nextLine();
				System.out.println(aStudentsAnswers);
				numStudents++;
			}
			System.out.println("We have reached \"end of file!\"\n");
			System.out.println("Thank you for the data on " + numStudents + 
					" students.  Here's the analysis:\n\n");
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.  Try again!");
		}
		return studentData;
	}

	/**
	 *  This method compares the students answers to the answer key and
	 *  prints out an analysis for each student number, listing each 
	 *  student's correct, incorrect, and blank answers. 
	 * 	
	 * @param	answerKey	This is a String of the answer key
	 * @param	studentData	This is the File containing the data
	 * 						for each student's test answers
	 * @param	myArrayListOfAllStudentAnswers	This is an ArrayList
	 * 						where all of the students' answers will 
	 * 						be stored for analysis.
	 * @return	numStudents	The number of students who took the 
	 * 						test.
	 **/
	public static int getStudentsResults(String answerKey, File studentData, ArrayList<String> myArrayListOfAllStudentAnswers){
		System.out.println("Student #\t Correct \t Incorrect \t Blank");
		System.out.println("~~~~~~~~~\t ~~~~~~~ \t ~~~~~~~~~ \t ~~~~~");
		int correctStudentAnswers=0;
		int incorrectStudentAnswers=0;
		int blankStudentAnswers=0;
		int numStudents=0;	
		
		try{
			Scanner fileReaderTwo=new Scanner(studentData);
			while(fileReaderTwo.hasNext()){
				String aStudentsAnswers=fileReaderTwo.nextLine().toUpperCase();
				myArrayListOfAllStudentAnswers.add(aStudentsAnswers);
				for(int i=0; i<answerKey.length(); i++){
					if(answerKey.charAt(i)==aStudentsAnswers.charAt(i))
						correctStudentAnswers++;
					else if(aStudentsAnswers.charAt(i)==' ')
						blankStudentAnswers++;
					else
						incorrectStudentAnswers++;
					
				}
				numStudents++;
				System.out.printf("%4d\t\t %4d\t\t %4d\t\t %4d\n", numStudents, 
						correctStudentAnswers, incorrectStudentAnswers, blankStudentAnswers);
				correctStudentAnswers=0;
				incorrectStudentAnswers=0;
				blankStudentAnswers=0;
			}
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.  Try again!");
		}
		return numStudents;
	}

	/**
	 *  This method prints out the question analysis report.  It calls
	 *  on a helper method printOutQuestionAnalysisHeader that prints 
	 *  out the header, and then it prints out the percentage of
	 *  students who answered with each different letter or blank.
	 * 
	 * @param	numStudents	The number of students who took the 
	 * 						test.	
	 * @param	answerKey	This is a String of the answer key
	 * @param	myArrayListOfAllStudentAnswers	This is an ArrayList
	 * 						where all of the students' answers will 
	 * 						be stored for analysis.
	 **/
	public static void printAnswersPercentages(int numStudents, String answerKey, ArrayList<String> myArrayListOfAllStudentAnswers){
		String currentString;
		double counterForAnswerEqualsA=0;
		double counterForAnswerEqualsB=0;
		double counterForAnswerEqualsC=0;
		double counterForAnswerEqualsD=0;
		double counterForAnswerEqualsE=0;
		double counterForAnswerEqualsBlank=0;

		for(int j=0; j<answerKey.length(); j++){
			for(int i=0; i<myArrayListOfAllStudentAnswers.size(); i++){
				currentString=myArrayListOfAllStudentAnswers.get(i);
				if(currentString.charAt(j)=='A')
					counterForAnswerEqualsA++;
				else if(currentString.charAt(j)=='B')
					counterForAnswerEqualsB++;
				else if(currentString.charAt(j)=='C')
					counterForAnswerEqualsC++;
				else if(currentString.charAt(j)=='D')
					counterForAnswerEqualsD++;
				else if(currentString.charAt(j)=='E')
					counterForAnswerEqualsE++;
				else
					counterForAnswerEqualsBlank++;
			}
			int questionNumber=j+1;
			printOutQuestionAnalysisHeader(questionNumber, answerKey.charAt(j));
			System.out.printf("%4d  %5d  %5d  %5d  %5d  %5d\n\n", 
					(int)counterForAnswerEqualsA, (int)counterForAnswerEqualsB, 
					(int)counterForAnswerEqualsC, (int)counterForAnswerEqualsD, 
					(int)counterForAnswerEqualsE, (int)counterForAnswerEqualsBlank);
			System.out.printf("%5.1f%% %5.1f%% %5.1f%% %5.1f%% %5.1f%%  %4.1f%%\n\n\n", 
					counterForAnswerEqualsA*100/numStudents, counterForAnswerEqualsB*100/numStudents, 
					counterForAnswerEqualsC*100/numStudents, counterForAnswerEqualsD*100/numStudents, 
					counterForAnswerEqualsE*100/numStudents, counterForAnswerEqualsBlank*100/numStudents);
			counterForAnswerEqualsA=0;
			counterForAnswerEqualsB=0;
			counterForAnswerEqualsC=0;
			counterForAnswerEqualsD=0;
			counterForAnswerEqualsE=0;
			counterForAnswerEqualsBlank=0;
		}
	}

	/**
	 *  This method prints out the header for the question analysis results
	 *  including the question number, the correct answer with an asterisk next
	 *  to it, and the other potential answers on the exam including if the
	 *  student left the answer blank. 
	 * 	
	 * @param	questionNumber	This int is the specific question number
	 * 							currently being printed out.
	 * @param	correctAnswerForAQuestion	This char is the correct
	 * 							answer for the current question.
	 **/
	public static void printOutQuestionAnalysisHeader(int questionNumber, char correctAnswerForAQuestion){
		String [] correctAnswerStarred = new String[5];
		correctAnswerStarred[0]="   A*     B      C      D      E     Blank\n";
		correctAnswerStarred[1]="   A      B*     C      D      E     Blank\n";
		correctAnswerStarred[2]="   A      B      C*     D      E     Blank\n";
		correctAnswerStarred[3]="   A      B      C      D*     E     Blank\n";
		correctAnswerStarred[4]="   A      B      C      D      E*    Blank\n";

		System.out.println("Question #" + questionNumber + ":\n");
		if(correctAnswerForAQuestion=='A')
			System.out.println(correctAnswerStarred[0]);
		else if(correctAnswerForAQuestion=='B')
			System.out.println(correctAnswerStarred[1]);
		else if(correctAnswerForAQuestion=='C')
			System.out.println(correctAnswerStarred[2]);
		else if(correctAnswerForAQuestion=='D')
			System.out.println(correctAnswerStarred[3]);
		else
			System.out.println(correctAnswerStarred[4]);		
	}
}



