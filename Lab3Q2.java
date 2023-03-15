
import java.lang.Math;


  class Vector2D 
{

    private double  x;
    private double y;

    Vector2D()
    {
        x=0;
        y=0;

    }

     Vector2D(double x, double y)
     {
            this.x=x;
            this.y=y;

     }

    public double getX() {
           return x;
    }

     public double getY() {
            return y;
     }

     void SetX (double x)
     {
        this.x=x;
       
     }

     void SetY (double y)
     {
        this.y=y;

     }

     double Magnitude ()
     {
        return Math.pow((Math.pow(x, 2)+Math.pow(y, 2)),0.5) ;
     }

     double angle ()
     {
         return Math.atan2(y, x);
     }

     void print ()
     {
        System.out.printf("%2.2fi + %.2fj%n",x,y);
        System.out.printf("%2.2f [ %2.2f ]%n",this.Magnitude(),angle());
     }

     static Vector2D   add ( Vector2D v1 , Vector2D v2)
    {
        
        return new Vector2D (v1.getX()+v2.getX(),v1.getY()+v2.getY());

    }

    static Vector2D sub ( Vector2D v1 , Vector2D v2)
    {
        
        return new Vector2D (v1.getX()-v2.getX(),v1.getY()-v2.getY());

    }

    public void  read( double x , double y)
    {
        this.x= x;
        this.y=y;

    }



}


class Point2D
{
    private double x ;
    private double y ;

    Point2D()
    {
        x=0;
        y=0;

    }

   public Point2D ( double x , double y)
    {
        this.x=x ;
        this.y=y;

    }

    public void SetX ( double x)
    {
        this.x =x;
    }

    public  void SetY (double y)
    {
        this.y =y;
        
    }

    public  double getX ()
    {
        return x;
    }
    public double getY ()
    {
        return y;
    }

}



class Line2D
{
    
private Point2D p;                        
private Vector2D v;    /////////////////////////////////////////////////// Ask the instructor

public Line2D (double x, double y, double x_comp, double y_comp)
{
    this.p = new Point2D(x,y);
    this.v = new Vector2D(x_comp, y_comp);
}


public Line2D(Point2D p, Vector2D v)
{
    this(p.getX(), p.getY(), v.getX(), v.getY());
}


public void print()
{
    System.out.printf(" The position is {%.1f , %.1f} %n" , this.p.getX(), this.p.getY());
    System.out.printf(" The direction is  %.2f %n" , this.v.angle()*180/3.14 );


    



    
}




}








public class Main {
   
   
   
    
    public static void main(String[] args) throws Exception {
        Vector2D V1 = new Vector2D(3,4);
        Point2D P1 = new Point2D(1,2);

        Line2D L1 = new Line2D(P1, V1);
        System.out.println("This line is contructed using the first constructor \n");
        L1.print();


        Line2D L2 = new Line2D(1,2,7,8);
        System.out.println("This line is contructed using the Second constructor \n");
        L2.print();
        






    }
}
