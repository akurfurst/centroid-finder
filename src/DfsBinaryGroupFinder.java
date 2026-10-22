import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DfsBinaryGroupFinder implements BinaryGroupFinder {
   /**
    * Finds connected pixel groups of 1s in an integer array representing a binary image.
    * 
    * The input is a non-empty rectangular 2D array containing only 1s and 0s.
    * If the array or any of its subarrays are null, a NullPointerException
    * is thrown. If the array is otherwise invalid, an IllegalArgumentException
    * is thrown.
    *
    * Pixels are considered connected vertically and horizontally, NOT diagonally.
    * The top-left cell of the array (row:0, column:0) is considered to be coordinate
    * (x:0, y:0). Y increases downward and X increases to the right. For example,
    * (row:4, column:7) corresponds to (x:7, y:4).
    *
    * The method returns a list of sorted groups. The group's size is the number 
    * of pixels in the group. The centroid of the group
    * is computed as the average of each of the pixel locations across each dimension.
    * For example, the x coordinate of the centroid is the sum of all the x
    * coordinates of the pixels in the group divided by the number of pixels in that group.
    * Similarly, the y coordinate of the centroid is the sum of all the y
    * coordinates of the pixels in the group divided by the number of pixels in that group.
    * The division should be done as INTEGER DIVISION.
    *
    * The groups are sorted in DESCENDING order according to Group's compareTo method.
    * 
    * @param image a rectangular 2D array containing only 1s and 0s
    * @return the found groups of connected pixels in descending order
    */
    @Override
    public List<Group> findConnectedGroups(int[][] image) {
        List<Group> clusters = new ArrayList<>();
        Set<Coordinate> visited = new HashSet<>();
        for(int r = 0; r < image.length; r++){
            for(int c = 0; c < image[r].length; c++){
                Coordinate current = new Coordinate(c, r);
                if(!visited.contains(current) && image[current.y()][current.x()] == 1){
                    clusters.add(dfs(image, current, visited));
                }
            }
        }

        clusters.sort((a,b) -> {
            return -(a.compareTo(b));
        });
        return clusters;
    }

    //dfs search. In here we will need to find the size of the cluster, and calculate the center of the cluster. Return the size and 
    //center as a group. 
    private Group dfs(int[][] image, Coordinate current, Set<Coordinate> visited){
        return null;
    }
    
}
