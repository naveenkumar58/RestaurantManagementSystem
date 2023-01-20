import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Filing {

	// HashMap<Integer, String> userDetails = new HashMap<>();// columnMap
	Filing() {
		// userDetails.put(0, "fName");
		// userDetails.put(1, "lName");
		// userDetails.put(2, "gender");
		// userDetails.put(3, "date");
		// userDetails.put(4, "email");
		// userDetails.put(5, "password");
	}

	public void writeData(String data, String fileName) {
		try {
			FileWriter fileWriter = new FileWriter(fileName, true);
			fileWriter.write(data + "\n");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> readData(String fileName) {
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(fileName));
			String line;
			try {
				line = reader.readLine();
				while (line != null) {
					// System.out.println(line);
					// read next line
					arrayList.add(line);
					line = reader.readLine();
					// for(int i=0;i<((CharSequence) arrayList).length();i++) {
					// String lineInfo = arrayList.get(i);
					// String[] columns=lineInfo.split(",") ;
					// columns[4]==email;
					// }
				}
				reader.close();
				// return arrayList;
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return arrayList;
	}
}
