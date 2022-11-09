

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Geektrust {

	public static void main(String[] args) throws Exception {
		//List<String> trainA = new ArrayList<>(Arrays.asList("ENGINE", "NDL", "NDL" , "KRN", "GHY", "SLM", "NJP", "NGP", "BLR"));
		//List<String> trainB = new ArrayList<>(Arrays.asList("ENGINE", "NJP" ,"GHY" ,"AGA", "PNE" ,"MAO", "BPL", "PTA"));
		//List<String> trainA = new ArrayList<>(Arrays.asList("ENGINE", "SLM", "BLR" , "KRN", "HYB", "SLM", "NGP", "ITJ"));
		//List<String> trainB = new ArrayList<>(Arrays.asList("ENGINE", "SRR" ,"MAO" ,"NJP", "PNE" ,"PTA"));
		//use above lines for manual input
		File file = new File(
	            "C:\\Users\\HP\\eclipse-workspace\\TrainProblem\\src\\train2.txt");
	        BufferedReader br
	            = new BufferedReader(new FileReader(file));
	        String st;
	        int lineNumber = 1;
	        String trainAString = br.readLine();
	        List<String> trainA = new ArrayList<String>(Arrays.asList(trainAString.split(" ")));
	        String trainBString = br.readLine();
	        List<String> trainB = new ArrayList<String>(Arrays.asList(trainBString.split(" ")));
	    trainAOrder(trainA);
	    trainBOrder(trainB);
	    System.out.println(trainABOrder(trainA,trainB));
	}

	private static String trainABOrder(List<String> trainA, List<String> trainB) {
		trainA.removeAll(new ArrayList<>(Arrays.asList("HYB"))); //Since trainA and trainB already contains all boggies removed except HYB
		trainB.removeAll(new ArrayList<>(Arrays.asList("HYB")));
		List<String> trainAB = new ArrayList<>();
		Map<String,Integer> priorityMap = new HashMap<>();
		priorityMap.put("ENGINE", 9);
		priorityMap.put("GHY", 8);
		priorityMap.put("NJP", 7);
		priorityMap.put("PTA", 6);
		priorityMap.put("NDL", 5);
		priorityMap.put("AGA", 4);
		priorityMap.put("BPL", 3);
		priorityMap.put("ITJ", 2);
		priorityMap.put("NGP", 1);
		if(trainA.size() == 1 && trainB.size() == 1)
		{
			return "JOURNEY_ENDED";
		} 
		trainA.addAll(trainB);
		int sizeA = trainA.size();// now trainA contains all the boggies of trainB also
		trainAB.add("ENGINE"); 
		trainAB.add("ENGINE");
		for(int i=0; i<sizeA-2;i++) {
			if(trainA.contains("GHY")) {
				trainAB.add("GHY");
				trainA.remove("GHY");
			} else if(trainA.contains("NJP")) {
				trainAB.add("NJP");
				trainA.remove("NJP");
			} else if(trainA.contains("PTA")) {
				trainAB.add("PTA");
				trainA.remove("PTA");
			} else if(trainA.contains("NDL")) {
				trainAB.add("NDL");
				trainA.remove("NDL");
			} else if(trainA.contains("AGA")) {
				trainAB.add("AGA");
				trainA.remove("AGA");
			} else if(trainA.contains("BPL")) {
				trainAB.add("BPL");
				trainA.remove("BPL");
			} else if(trainA.contains("ITJ")) {
				trainAB.add("ITJ");
				trainA.remove("ITJ");
			} else if(trainA.contains("NGP")) {
				trainAB.add("NGP");
				trainA.remove("NGP");
			}
		}
		
		return "DEPARTURE TRAIN_AB " + trainAB.stream().collect(Collectors.joining(" "));
		
		
	}


	private static void trainBOrder(List<String> trainB) {
		List<String> boggiesToRemove = new ArrayList<>();
		for (String boggie : trainB) {
			if (boggie.equals("TVC") || boggie.equals("SRR") || boggie.equals("MAQ") || boggie.equals("MAO")
					|| boggie.equals("PNE")) {
				boggiesToRemove.add(boggie);
			}
		}
		trainB.removeAll(boggiesToRemove);
		System.out.println("ARRIVAL "+ trainB.stream().collect(Collectors.joining(" ")));
		
	}

	private static void trainAOrder(List<String> trainA) {
		List<String> boggiesToRemove = new ArrayList<>();
		for(String boggie : trainA) {
			if(boggie.equals("CHN") || boggie.equals("SLM") || boggie.equals("BLR") || boggie.equals("KRN")) {
				boggiesToRemove.add(boggie);
			}
		}
		trainA.removeAll(boggiesToRemove);
		System.out.println("ARRIVAL "+ trainA.stream().collect(Collectors.joining(" ")));
		
	}
}
