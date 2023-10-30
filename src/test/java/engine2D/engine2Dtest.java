package engine2D;
import java.awt.Graphics;

public class engine2Dtest{
    
    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(7,2);
        Line linea = new Line(p1,p2);
        System.out.println(linea.getYfromX(1.5));
        
    }
    
}
