
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BuildUserRateMatrix {
	private int ITEM_TOTAL = 0;
	private int USER_TOTAL = 0;
	private File file = null;

	public BuildUserRateMatrix(int itemIn, int userIn, File fileIn) throws IOException {
		ITEM_TOTAL = itemIn;
		USER_TOTAL = userIn;
		file = fileIn;
	}


	//According to the information in the file, build the user-item to rate matrix
	public int[][] build() throws IOException {
		System.out.println("Building the user-item matrix...");
		int[][] user_rate_matrix = new int[USER_TOTAL + 1][ITEM_TOTAL + 1];
		FileProcessor fp = new FileProcessor(file);
		String line = null;
		while ((line = fp.readOneLineAsString()) != null) {
			// adjust input format
			while (line.startsWith(" ")) {
				line = line.trim();
			}
			if (line.length() == 0) {
				continue;
			}
			
			String[] sp = line.split("\\s+");
			user_rate_matrix[Integer.parseInt(sp[0])][Integer.parseInt(sp[1])] = Integer.parseInt(sp[2]);
		}
		return user_rate_matrix;
	}
}
