
import java.util.Scanner;

public class WhoWins {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.next();

        boolean firstRowContainsX = (inputString.charAt(0) == 'X' && inputString.charAt(1) == 'X' && inputString.charAt(2) == 'X');
        boolean secondRowContainsX = (inputString.charAt(3) == 'X' && inputString.charAt(4) == 'X' && inputString.charAt(5) == 'X');
        boolean thirdRowContainsX = (inputString.charAt(7) == 'X' && inputString.charAt(6) == 'X' && inputString.charAt(8) == 'X');
        boolean diagonal1ContainsX = (inputString.charAt(0) == 'X' && inputString.charAt(4) == 'X' && inputString.charAt(8) == 'X');
        boolean diagonal2ContainsX = (inputString.charAt(2) == 'X' && inputString.charAt(4) == 'X' && inputString.charAt(6) == 'X');
        boolean firstColumnContainsX = (inputString.charAt(0) == 'X' && inputString.charAt(3) == 'X' && inputString.charAt(6) == 'X');
        boolean secondColumnContainsX = (inputString.charAt(1) == 'X' && inputString.charAt(4) == 'X' && inputString.charAt(7) == 'X');
        boolean thirdColumnContainsX = (inputString.charAt(2) == 'X' && inputString.charAt(5) == 'X' && inputString.charAt(8) == 'X');

        boolean firstRowContainsO = (inputString.charAt(0) == 'O' && inputString.charAt(1) == 'O' && inputString.charAt(2) == 'O');
        boolean secondRowContainsO = (inputString.charAt(3) == 'O' && inputString.charAt(4) == 'O' && inputString.charAt(5) == 'O');
        boolean thirdRowContainsO = (inputString.charAt(7) == 'O' && inputString.charAt(6) == 'O' && inputString.charAt(8) == 'O');
        boolean diagonal1ContainsO = (inputString.charAt(0) == 'O' && inputString.charAt(4) == 'O' && inputString.charAt(8) == 'O');
        boolean diagonal2ContainsO = (inputString.charAt(2) == 'O' && inputString.charAt(4) == 'O' && inputString.charAt(6) == 'O');
        boolean firstColumnContainsO = (inputString.charAt(0) == 'O' && inputString.charAt(3) == 'O' && inputString.charAt(6) == 'O');
        boolean secondColumnContainsO = (inputString.charAt(1) == 'O' && inputString.charAt(4) == 'O' && inputString.charAt(7) == 'O');
        boolean thirdColumnContainsO = (inputString.charAt(2) == 'O' && inputString.charAt(5) == 'O' && inputString.charAt(8) == 'O');

        boolean xWins = firstRowContainsX || secondRowContainsX || thirdRowContainsX || firstColumnContainsX || secondColumnContainsX || thirdColumnContainsX ||diagonal1ContainsX || diagonal2ContainsX;
        boolean oWins = firstRowContainsO || secondRowContainsO || thirdRowContainsO || firstColumnContainsO || secondColumnContainsO || thirdColumnContainsO ||diagonal1ContainsO || diagonal2ContainsO;

        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == 'X') {
                xCount++;
            }
            if (inputString.charAt(i) == 'O') {
                oCount++;
            }
        }

        System.out.println("---------");
        System.out.println("| " + inputString.charAt(0) + " " + inputString.charAt(1) + " " + inputString.charAt(2) + " |");
        System.out.println("| " + inputString.charAt(3) + " " + inputString.charAt(4) + " " + inputString.charAt(5) + " |");
        System.out.println("| " + inputString.charAt(6) + " " + inputString.charAt(7) + " " + inputString.charAt(8) + " |");
        System.out.println("---------");

        boolean oneGreaterThanOther = Math.abs(xCount - oCount) > 1;

        if ((xWins && oWins) || oneGreaterThanOther) {
            System.out.println("Impossible");
        } if (xWins && !oWins) {
            System.out.println("X wins");
        } else if (oWins && !xWins) {
            System.out.println("O wins");
        } else if (oneGreaterThanOther && !inputString.contains("_")) {
            System.out.println("Impossible");
        } else if (Math.abs(xCount - oCount) == 1 && !inputString.contains("_")) {
            System.out.println("Draw");
        } else if (!xWins && !oneGreaterThanOther) {
            System.out.println("Game not finished");
        }
    }
}