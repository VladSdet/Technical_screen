package qaTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class MirrorWords {
	static final String inputFile = "./in_file.txt";
	static final String outputFile = "./out_file.txt";

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> outFile = new ArrayList<String>();
		HashSet<String> wordSet = new MirrorWords().readFileToSet();
		for (Iterator<String> iterator = wordSet.iterator(); iterator.hasNext();) {
			String wordElement = iterator.next();
			String reversWordElement = new StringBuilder(wordElement.toString()).reverse().toString();
			if (reversWordElement.equals(wordElement))
				iterator.remove();
			if (wordSet.contains(reversWordElement)) {
				outFile.add(wordElement + "/" + reversWordElement + "\n");
				iterator.remove();
				String result = outFile.toString().replaceAll(",\\s", "").replaceAll("^.", "").replace("]", "");
				File file = new File(outputFile);
				FileOutputStream fos = new FileOutputStream(file);
				PrintStream ps = new PrintStream(fos);
				System.setOut(ps);
				System.out.println(result);
			}
		}
	}

	public HashSet<String> readFileToSet() {
		HashSet<String> wordSet = new HashSet<String>();
		try {
			File file = new File(inputFile);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				wordSet.add(line);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return wordSet;
	}
}
