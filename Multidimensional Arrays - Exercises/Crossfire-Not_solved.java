import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Crossfire {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] rowColumn = console.nextLine().split("\\s+");
        int rowMatrix = Integer.parseInt(rowColumn[0]);
        int colMatrix = Integer.parseInt(rowColumn[1]);
        int[][] matrix = new int[rowMatrix][colMatrix];
        for (int i=0; i<rowMatrix; i++){
            for (int j=0; j<colMatrix; j++){
                matrix[i][j]= i*colMatrix+1+j;
            }
        }
        List<int[]> matrixToList = Arrays.asList(matrix);

        String command;
        while (!"Nuke it from orbit".equals(command = console.nextLine())) {
            String[] attribute = command.split("\\s+");
            int row = Integer.parseInt(attribute[0]);
            int col = Integer.parseInt(attribute[1]);
            int radius = Integer.parseInt(attribute[2]);
            int topRadius = Math.max(0, row-radius);
            int bottomRadius = Math.min(rowMatrix-1, row+radius);
            int leftRadius = Math.max(0, col-radius);
            int rightRadius = Math.min(colMatrix-1, col+radius);
            for (int i=topRadius; i<=bottomRadius; i++){
                if(i!=row) {
                    int finalI = i;
                    matrixToList.set(i, IntStream.range(0, matrixToList.get(i).length).filter(j -> j != col).map(j -> matrixToList.get(finalI)[j]).toArray());
                }
                else {
                    int finalI1 = i;
                    matrixToList.set(i, IntStream.range(0, matrixToList.get(i).length).filter(j -> j < leftRadius || j> rightRadius).map(j -> matrixToList.get(finalI1)[j]).toArray());
                }
            }
        }
        matrixToList.forEach(s -> {
            if(s.length>0) System.out.println(Arrays.toString(s).replaceAll("[\\[\\],]", ""));
        });
    }
}
