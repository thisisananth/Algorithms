package chapter1;

import java.util.*;


public class AustralianVoting {
	
	//numCases cases
	//numCandidates candidates per case
	//numBallots ballots per candidate of numCandidates choices 
	public static void main(String[] args) {
		// Your program here
				long startTime = System.nanoTime();
				Scanner scanner = new Scanner(System.in);
				/*Scanner scanner=null;
				try {
					scanner = new Scanner(new FileInputStream("input.txt"));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				try {
					List<TestCase> testCases = new ArrayList<TestCase>();
					List<String> candidates = null;
					List<LinkedList<Integer>> ballots = null;
					if (scanner.hasNext()) {

						int numCases = scanner.nextInt();

						if (numCases != 0) {

							for (int i = 1; i <= numCases; i++) {
								TestCase testCase = new TestCase();
								testCase.setCaseId(i);
								int numCandidates = scanner.nextInt();
								scanner.nextLine();// go to next line
								candidates = new ArrayList<String>();
								ballots = new ArrayList<LinkedList<Integer>>();
								for (int j = 0; j < numCandidates; j++) {
									candidates.add(scanner.nextLine());
								}

								String nextLine = scanner.nextLine();

								while (nextLine != null && !nextLine.isEmpty()) {
									ballots.add(buildLinkedList(nextLine.split(" ")));
									try{
										
										nextLine = scanner.nextLine();
									} catch(NoSuchElementException e) {
										nextLine = null;
									}

								}

								testCase.setCandidates(candidates);
								testCase.setBallots(ballots);
								testCases.add(testCase);
							}

							for (int i = 0; i < testCases.size(); i++) {
								TestCase testCase = testCases.get(i);
								// System.out.println(testCase.toString());

								System.out.println(findWinner(testCase));
								if (i < testCases.size() - 1) {
									System.out.println();
								}

							}
							long endTime = System.nanoTime();
							System.out.println("Took "+(endTime - startTime) + " ns"); 
							return;

						} else {
							return;
						}

					}
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}


	}

	private static LinkedList<Integer> buildLinkedList(String[] input) {
		LinkedList<Integer> output = new LinkedList<Integer>();

		for (int i = 0; i < input.length; i++) {
			output.add(Integer.parseInt(input[i]));
		}

		return output;
	}

	private static String findWinner(TestCase testCase) {

		String winner = null;
		HashMap<Integer, Integer> rankings = new HashMap<Integer, Integer>();
		int candidateSize = testCase.getCandidates().size();
		for (int i = 1; i <= candidateSize; i++) {
			rankings.put(i, 0);
		}
		int ballotSize = testCase.getBallots().size();
		int fiftyPercentOrmore = (int) Math.floor((double) ballotSize / 2) + 1;
		updateRankings(testCase, rankings);

		while (winner == null) {

			Integer minBallot = null;
			List<Integer> leastPreffedCandidates = new ArrayList<Integer>();
			for (Map.Entry<Integer, Integer> entry : rankings.entrySet()) {
				if (entry.getValue() >= fiftyPercentOrmore) {
					winner = testCase.getCandidates().get(entry.getKey() - 1);
				} else {
					if (minBallot == null) {
						minBallot = entry.getValue();
						leastPreffedCandidates.add(entry.getKey());
					} else {
						if (entry.getValue() < minBallot) {
							minBallot = entry.getValue();
							leastPreffedCandidates = new ArrayList<Integer>();
							leastPreffedCandidates.add(entry.getKey());
						} else if (entry.getValue() == minBallot) {
							leastPreffedCandidates.add(entry.getKey());
						}
					}
				}
			}
			if (winner == null) {
				if (leastPreffedCandidates.size() != rankings.keySet().size()) {

					for (Integer candKey : leastPreffedCandidates) {
						rankings.remove(candKey);
					}

					for (LinkedList<Integer> ballot : testCase.getBallots()) {

						if (!rankings.keySet().contains(ballot.peek())) {
							while (!rankings.keySet().contains(ballot.peek())) {
								ballot.pop();

							}
							if (!ballot.isEmpty()) {
								rankings.put(ballot.peek(),
										rankings.get(ballot.peek()) + 1);
							}
						}

					}

				} else {
					// candidates are tied
					winner = "";
					int index = 1;
					for (Integer candKey : leastPreffedCandidates) {

						winner += testCase.getCandidates().get(candKey - 1);
						if (index != leastPreffedCandidates.size()) {
							winner += "\n";
						}
						index++;
					}
				}
			}

		}

		return winner;
	}

	private static void updateRankings(TestCase testCase,
			HashMap<Integer, Integer> rankings) {
		for (LinkedList<Integer> ballot : testCase.getBallots()) {
			if (ballot.size() > 0) {
				rankings.put(ballot.peek(), rankings.get(ballot.peek()) + 1);
			}
		}

	}

	// You can insert more classes here if you want.

	
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

	private int caseId;
	private List<String> candidates;
	private List<LinkedList<Integer>> ballots;

	public List<LinkedList<Integer>> getBallots() {
		return ballots;
	}

	public void setBallots(List<LinkedList<Integer>> ballots) {
		this.ballots = ballots;
	}

	@Override
	public String toString() {
		String str = "TestCase [caseId=" + caseId + ", candidates="
				+ candidates + "]";

		for (LinkedList<Integer> i : ballots) {
			str += ("[");
			for (int j : i) {
				str += (j);
			}
			str += ("],");
		}
		return str;
	}

}