import java.util.Scanner;

// Scrivere un programma che stampi i primi 100 elementi della successione di Fibonacci.

public class numeriDiFibonacci {

	public static void main(String[] args) {
	
        Scanner scan = new Scanner(System.in);
        System.out.println("quanti numeri di Fibonacci vuoi?");
        int ripetizioni = scan.nextInt();
        int[] numeri = {0,1,0};
        int z = 0;
        System.out.println(numeri[0]);
        System.out.println(numeri[1]);
        for(int i = 0; i <= ripetizioni-3; i++ ){
        
            numeri[2] = numeri[0] + numeri[1];
          
            for(int x = 1; x<numeri.length;x++){
                numeri[z]= numeri[x];
                z++;
            }
           System.out.println(numeri[2]);
            z = 0;
           




        }
        scan.close();
	}

}