
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrintMatrix {
	
	static public void print(int[][] matrix, File file) throws IOException {
		FileWriter fw = new FileWriter(file);
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				fw.write(matrix[i][j] + " ");
				System.out.println(i);
			}
			fw.write("\n");
		}
		fw.close();
	}
	
	static public void print(double[][] matrix, File file) throws IOException {
		FileWriter fw = new FileWriter(file);
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				fw.write(matrix[i][j] + " ");
			}
			fw.write("\n");
		}
		fw.close();
	}
	
	static public void adjustFormat2User_item_rate(int[][] matrix, File file) throws IOException {
		FileWriter fw = new FileWriter(file);
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				fw.write(i + " " + j + " " + matrix[i][j] + "\n");
				System.out.println("Printing the rates of user " + i);
			}
		}
		System.out.println("All the output information has been printed in output.txt");
		fw.close();
	}
}
