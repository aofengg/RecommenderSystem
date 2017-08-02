
public class BuildSimilarityMatrix {

	//Build the similarity matrix about every two users.
	static public double[][] build(int[][] user_rate_matrix) {
		System.out.println("Building user-user similarity matrix...");
		double[][] similarityMatrix = new double[user_rate_matrix.length][user_rate_matrix.length];
		for (int i = 1; i < user_rate_matrix.length; i++) {
			similarityMatrix[i][i] = 1;
			for (int j = 1; j < i; j++) {
				similarityMatrix[i][j] = similarity(user_rate_matrix[i], user_rate_matrix[j]);
				similarityMatrix[j][i] = similarityMatrix[i][j];
			}
		}
		return similarityMatrix;
	}


	//Calculate the similarity between two users
	private static double similarity(int[] array1, int[] array2) {
		double result = 0;
		int sum_array1 = 0;
		int sum_array2 = 0;
		int sum_product = 0;
		int sum_square1 = 0;
		int sum_square2 = 0;
		int n = array1.length;
		
		for (int i = 1; i < array1.length; i++) {
			sum_array1 += array1[i];
			sum_array2 += array2[i];
			sum_square1 += Math.pow(array1[i], 2);
			sum_square2 += Math.pow(array2[i], 2);
			sum_product += array1[i] * array2[i];
		}
		double numerator = n * sum_product - sum_array1 * sum_array2;
		double denominator = Math.sqrt((n * sum_square1 - Math.pow(sum_array1, 2)) * (n * sum_square2 - Math.pow(sum_array2, 2)));
		if (denominator == 0) {
			result = 0;
		} else {
			result = numerator / denominator; 
		}
		return result;
	}
}
