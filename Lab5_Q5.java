//Test code:
package Q5; 
import Q2.Shape; 
import Q4.*; 
import java.util.Arrays; 
import javafx.geometry.Point2D; 
public class TestQ5 { 
public static void main(String[] args) throws Exception { 
// Create array of Moveables
Movable[] arr = new Movable[3]; 
// Create Diamond objects
arr[0] = new Diamond(new Point2D(3, 4), 6, 2); 
arr[1] = new Diamond(new Point2D(1, 2), 12, 3); 
arr[2] = new Diamond(new Point2D(3, 2), 1, 5); 
// Move each Diamond
for (Movable mv : arr) { 
mv.move(1, 1); 
} 
// Draw all diamonds
for (Movable mv : arr) { 
// Typecast to Shape
((Shape) mv).draw(); 
System.out.println("___________________"); 
} 
// Depends on the implementation of CompareTo.
System.out.println("______Sorting______"); 
Arrays.sort(arr); 
// Draw all diamonds
for (Movable mv : arr) { 
// Typecast to Shape
((Shape) mv).draw(); 
System.out.println("___________________"); 
} 
} 
}