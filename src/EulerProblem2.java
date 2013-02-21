import java.util.*; 

public class EulerProblem2 {
    public static void main(String[] args){
        ArrayList<Integer> AllItems = FibonacciList();
        System.out.println("All even fibonacci items below 4,000,000 are: " + AllItems );
        System.out.println("The Sum is: " + sumDigits(AllItems) );
    }

    public static ArrayList<Integer> FibonacciList(){
        int firstNumber  = 0;
        int secondNumber = 1;
        int sum = 0;
        ArrayList<Integer> fcItems = new ArrayList<Integer>();

        while ( secondNumber < 4000000 ){
            int newNumber = ( firstNumber + secondNumber );
            firstNumber = secondNumber;
            secondNumber = newNumber;
            if ( ( secondNumber % 2 ) == 0 ){
                sum = sum + secondNumber;
                fcItems.add(newNumber);
            }
        }

        System.out.println("The Sum is: " + sum );
        return fcItems;
    }

    public static Integer sumDigits (ArrayList<Integer> array){
        int sum = 0;
        for (int index = (array.size() -1 ); index >= 0 ; index-- ){
            sum = sum + array.get(index);
        }
        return sum;
    }


}
