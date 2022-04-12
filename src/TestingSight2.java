//Julian Matthews Final ICS project. Find which sorting method is faster under certain circumstances 12/16/2021
import java.util.Scanner;
public class TestingSight2 {
        public static void main(String[] args) {
            CalcUp Cal = new CalcUp();
            Scanner input = new Scanner(System.in);
            System.out.println("""
                I will sort random integer arrays using a mergesort function and a insertion sort function.
                Then I will compare which function sorted the arrays faster.\s
                Before I do that, you can determine some factors.""");
            System.out.println("How many indexes do you want your array to have?");
            int x = input.nextInt();
            if (x > 100000) {System.out.println("Too big, relax."); return;}

            System.out.println("How many tests do you want to be ran");
            double y = input.nextInt();
            if (y > 100000) {System.out.println("Too big, relax."); return;}

            Cal.calculator(x,y);

        }
}

