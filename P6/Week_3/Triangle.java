public class Triangle {

    public double base;
    public double height;
    public double area;

    public static void main(String args[]) {
        Triangle t = new Triangle();
        t.calculateArea();
    }

    public void calculateArea() {
        area = 0.5 * base * height;
        System.out.println("The area of a trinagle");
    }
}
