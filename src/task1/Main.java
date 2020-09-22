package task1;

import java.util.Locale;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x ");
        double x = scanner.nextDouble();
        System.out.print("Enter y ");
        double y = scanner.nextDouble();
        Area a = foundArea(x,y);
        System.out.println(a);
    }
    enum Area
    {
        Blue, Green, White, Grey, Orange, Yellow
    }

    public static Area foundArea(double x, double y){
        if (InsideCircle(x,y) && BelowParabola2(x,y) && InsideRectangle(x,y))
            return Area.White;
        if (AboveParabola1(x,y) && InsideRectangle(x,y) && !(AboveLine(x,y)))
            return Area.Orange;
        if (InsideCircle(x,y))
            return Area.Blue;
        if (BelowParabola2(x,y))
            return Area.Yellow;
        if (InsideRectangle(x,y) && !(AboveParabola1(x,y)))
            return Area.Green;
        if (AboveLine(x,y) && (InsideRectangle(x,y) || !(AboveParabola1(x,y))))
            return Area.Blue;
        if (AboveParabola1(x,y) && AboveLine(x,y))
            return Area.Green;
        if (AboveParabola1(x,y))
            return Area.Blue;
        return Area.Grey;
    }
    public static boolean InsideRectangle(double x, double y)
    {
        return x >= -2 && x <= 2 && y >=- 2 && y <=8 ;
    }

    public static boolean AboveParabola1(double x, double y)
    {
        return y >= x*x/8-0.5*x+2.5;
    }

    public static boolean BelowParabola2(double x, double y)
    {
        return y <= -x*x-4*x-3;
    }

    public static boolean InsideCircle(double x, double y)
    {
        return (x+4)*(x+4)+(y+1)*(y+1) <= 16;
    }

    public static boolean AboveLine(double x, double y)
    {
        return y>=-2*(x-2);
    }
}
