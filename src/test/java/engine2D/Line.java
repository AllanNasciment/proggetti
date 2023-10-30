package engine2D;

public class Line {
    private Point point1;
    private Point point2;
    
    public Line(Point point1 , Point point2){
        this.point1 = point1;
        this.point2 = point2;
    }
    
    public double getYfromX(double x){
        double minX = Double.min(point1.xValue(), point2.xValue());
        double maxX = Double.max(point1.xValue(), point2.xValue());
        double risult = Double.NaN;
        if(x >= minX && x <= maxX){
            double p1x = point1.xValue();
            double p1y = point1.yValue();
            double p2x = point2.xValue();
            double p2y = point2.yValue();
            if(x==p1x && minX == p1x){
                risult = p1y;
            }else if(x==p2x && minX == p2x){
                risult = p2y;
            }else{
                double coef = (p1y-p2y)/(p1x-p2x);
                double q = p1y-(coef*p1x);
                risult = coef*x+q;
            }
        }
        return risult;
    }
}
