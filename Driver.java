
import java.io.File;
import java.io.IOException;

public class Driver {
	public static final int ITEM_TOTAL = 1682; 
	public static final int USER_TOTAL = 943;
	
	public static void main(String[] args) throws IOException {
		int[][] user_rate_matrix;
		File input = new File("train_all_txt.txt");
		// File user_rate_matrix_txt = new File("user_rate_matrix.txt");
		// File similarityMatrix_txt = new File("similarityMatrix.txt");
		// File predict_user_rate_matrix_txt = new File("predict_user_rate_matrix.txt");
		File output = new File("output.txt");
		
		
		BuildUserRateMatrix buildUserRateMatrix = new BuildUserRateMatrix(ITEM_TOTAL, USER_TOTAL, input);
		user_rate_matrix = buildUserRateMatrix.build();
		
		double[][] similarityMatrix = BuildSimilarityMatrix.build(user_rate_matrix);
		// PrintMatrix.print(similarityMatrix, similarityMatrix_txt);
		// PrintMatrix.print(user_rate_matrix, user_rate_matrix_txt);
		
		RecommenderResult recommenderResult = new RecommenderResult();
		recommenderResult.fillEmpty(user_rate_matrix, similarityMatrix);
		
		// PrintMatrix.print(user_rate_matrix, predict_user_rate_matrix_txt);
		PrintMatrix.adjustFormat2User_item_rate(user_rate_matrix, output);
		
	}

}
