
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class RecommenderResult {
	//According to similarity matrix, fill all the empty part of user-item matrix
	public void fillEmpty(int[][] user_rate_matrix, double[][] similarityMatrix) {
		ArrayList<Integer> neighbors = new ArrayList<Integer>();
		for (int i = 1; i < user_rate_matrix.length; i++) {
			for (int j = 1; j < user_rate_matrix[i].length; j++) {
				if (user_rate_matrix[i][j] == 0) {
					double neighbor_similarity_sum = 0;
					double neighbor_rateXsimilarity_sum = 0;
					int rate = 0;
					System.out.println("Predicting the rate of user: " + i + "  for item: " + j);
					neighbors = getNeighbors(user_rate_matrix, i, j, similarityMatrix);
					for (int k = 0; k < neighbors.size(); k++) {
						neighbor_rateXsimilarity_sum += similarityMatrix[i][neighbors.get(k)]
								* user_rate_matrix[neighbors.get(k)][j];
						neighbor_similarity_sum += similarityMatrix[i][neighbors.get(k)];
					}
					if (neighbor_similarity_sum == 0) {
						rate = 0;
					} else {
						DecimalFormat df = new DecimalFormat("######0");
						rate = Integer.parseInt(df.format(neighbor_rateXsimilarity_sum / neighbor_similarity_sum));
					}
					user_rate_matrix[i][j] = rate;
				}
			}
		}
	}

	private ArrayList<Integer> getNeighbors(int[][] user_rate_matrix, int user, int item, double[][] similarityMatrix) {
		// TODO Auto-generated method stub
		final int range = 10;
		ArrayList<Integer> neighbors = new ArrayList<Integer>();
		double[] similarity_list = new double[similarityMatrix.length];
		for (int i = 0; i < similarityMatrix.length; i++) {
			if (user_rate_matrix[i][item] != 0) {
				similarity_list[i] = similarityMatrix[user][i];
			}
		}

		double[] sortSimilarity = new double[similarity_list.length];
		for (int i = 0; i < sortSimilarity.length; i++) {
			sortSimilarity[i] = similarity_list[i];
		}
		Arrays.sort(sortSimilarity);

		for (int i = 0; i < similarity_list.length; i++) {
			if (similarity_list[i] > sortSimilarity[sortSimilarity.length-1-range] && similarity_list[i] > 0) {
				neighbors.add(i);
			}
		}

		return neighbors;
	}
}
