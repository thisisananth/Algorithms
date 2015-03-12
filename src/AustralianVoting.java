import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class AustralianVoting {
	
	//numCases cases
	//numCandidates candidates per case
	//numBallots ballots per candidate of numCandidates choices 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			List<TestCase> testCases = new ArrayList<TestCase>();
			List<String> candidates = null;
			List<int[]>  ballots = null;
			while (scanner.hasNext()) {
				
				
				int numCases = scanner.nextInt(); 
				
			
				
				if(numCases!=0){
					
					
					for(int i=0;i<numCases;i++){
						TestCase testCase = new TestCase();
						testCase.setCaseId(i);
						int numCandidates = scanner.nextInt();
						scanner.nextLine();//go to next line
						candidates = new ArrayList<String>();
						ballots = new ArrayList<int[]>();
						for(int j=0;j<numCandidates;j++){
							candidates.add(scanner.nextLine());
						}
						
						String nextLine = scanner.nextLine();
						
						while(nextLine!=null && !nextLine.isEmpty()){
							ballots.add(buildIntArray(nextLine.split(" ")));
							nextLine = scanner.nextLine();
						}
						
						testCase.setCandidates(candidates);
						testCase.setBallots(ballots);
						testCases.add(testCase);
					}
					
					
					for(TestCase testCase:testCases){
						System.out.println(testCase.toString());
					}
			
					return;
				
				}else{
					return;
				}
				
				

			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}

	}

	
	private static int[] buildIntArray(String[] input){
		int[] output = new int[input.length];
		
		for(int i=0;i<input.length;i++){
			output[i]=Integer.parseInt(input[i]);
		}
		
		return output;
	}
	
	
	

}
class TestCase {
	
	public int getCaseId() {
		return caseId;
	}
	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}
	public List<String> getCandidates() {
		return candidates;
	}
	public void setCandidates(List<String> candidates) {
		this.candidates = candidates;
	}
	public List<int[]> getBallots() {
		return ballots;
	}
	public void setBallots(List<int[]> ballots) {
		this.ballots = ballots;
	}
	private int caseId;
	private List<String> candidates;
	private List<int[]> ballots;
	
	@Override
	public String toString() {
		String str = "TestCase [caseId=" + caseId + ", candidates=" + candidates +
			"]";
		
		for(int[] i:ballots){
			str+=("[");
			for(int j:i){
				str+=(j);
			}
			str+=("],");
		}
		return str;
	}
	
	
}