package Task5;

public class MainTask5 {
    //Task2
    public static void printThreeWords(){
        System.out.println("Orange\nBanana\nApple");
    }
    //Task3
    public static void checkSumSign(){
        int a= -5;
        int b = 5;
        System.out.println(((a+b)>=0)? "Сумма позитивна" : "Сумма негативна");

    }
    //Task4
    public static void printColor(){
        int value = -10;
        System.out.println((value <= 0) ? "Червоний" : (value <= 100) ? "Жовтий" : "Зелений");

    }
    //Task5
    public static void compareNumbers(){
        int a = 10;
        int b = 10;
        System.out.println((a>=b)? "a>=b" : "a<b");
    }
    //Task6
    public static boolean compareInt(int a, int b){
        int sum = a+b;
        return sum >= 10 && sum <= 20;
    }
    //Task7
    public static void compareInt(int a){
        System.out.println((a>=0)?"Додатне":"Відємне");
    }
    //Task8
    public static boolean NegPosBool(int a){
        return a<0;
    }
    //Task9
    public static void PrintString(String a, int kol){
        System.out.println((a+"\n").repeat(kol));
    }
    //Task10
    public static boolean LeapYear(int year){
        return year % 4 == 0 && !(year%100==0) || year%400 ==0;
    }

    public static void main(String[] args) {
        MainTask5.printThreeWords();
        MainTask5.checkSumSign();
        MainTask5.printColor();
        MainTask5.compareNumbers();
        System.out.println(MainTask5.compareInt(5,4));
        MainTask5.compareInt(-3);
        System.out.println(MainTask5.NegPosBool(-2));
        MainTask5.PrintString("Vasya",10);
        System.out.println(MainTask5.LeapYear(800));


    }

}
