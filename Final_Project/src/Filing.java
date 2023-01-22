import java.io.BufferedReader;
import java.io.File;
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

	// Product Start
	public Boolean isExists(String name, String fileName) {
		Boolean exists = false;
		ArrayList<String> arrlist = new ArrayList<String>();
		arrlist = this.readData(fileName);
		for (String p : arrlist) {
			if (p.startsWith(name)) {
				exists = true;
			}
		}
		return exists;
	}

	public void addProducts(String data, String fileName) {
		try {

			FileWriter fileWriter = new FileWriter(fileName, true);
			fileWriter.write(data + "\n");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteProductFile(String fileName) {
		try {
			File fl = new File(fileName);
			fl.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean deletProductByName(String productName, String fileName) {
		Boolean success = false;
		ArrayList<String> arrlist = new ArrayList<String>();
		arrlist = this.readData(fileName);
		this.deleteProductFile(fileName);
		for (String p : arrlist) {
			if (!(p.startsWith(productName))) {
				this.addProducts(p, fileName);
			} else {
				success = true;
			}
		}
		return success;
	}

	public void updateProduct(String productName, String product, String fileName) {

		// Boolean success = false;
		ArrayList<String> arrlist = new ArrayList<String>();
		arrlist = this.readData(fileName);
		this.deleteProductFile(fileName);
		for (String p : arrlist) {
			if (p.startsWith(productName)) {
				this.addProducts(product, fileName);
			} else {
				this.addProducts(p, fileName);
				// success = true;
			}
		}
		// return success;
	}

	// Product End

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
