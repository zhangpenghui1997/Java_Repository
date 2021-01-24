public class testStatic {
    private static int a;
    static {
        a=1;
    }
    public static void printA(){
        System.out.println(a);
    }
}
