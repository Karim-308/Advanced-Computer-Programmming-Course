
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
    System.out.print("The position is = "+ this.p.getX()+" "+this.p.getY() + " The line is "+ v.getX() +" || "+v.getY() );

    
}




}








public class Lab3Q1 {
   
   
   
    
    public static void main(String[] args) throws Exception {
        Vector2D H1 = new Vector2D(3,4);
        Vector2D H2 = new Vector2D (6,7);
        H1.print();
        H2.print();

        System.out.println("Using Static add Method to add the first and Second");
        Vector2D.add(H1, H2).print();


        System.out.println( "seting x of first to 5 :"+"seting y of first to 6 :" );

      H1.read(5, 6);
        System.out.println("Perview of first");
         H1.print();




    }
}
