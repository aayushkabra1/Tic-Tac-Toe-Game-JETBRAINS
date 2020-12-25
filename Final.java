import java.util.Scanner;

public class Final {

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static int indexOfArrayFromCoordinates(int a, int b){
        if (a == 1 && b == 1) {
            return 0;
        } else if (a == 1 && b == 2) {
            return 1;
        } else if (a == 1 && b == 3) {
            return 2;
        } else if (a == 2 && b == 1) {
            return 3;
        } else if (a == 2 && b == 2) {
            return 4;
        } else if (a == 2 && b == 3) {
            return 5;
        } else if (a == 3 && b == 1) {
            return 6;
        } else if (a == 3 && b == 2) {
            return 7;
        } else {
            return 8;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean xTurn = true;
        
        System.out.println("---------");
        System.out.println("| " + "  " + "  " + "  |");
        System.out.println("| " + "  " + "  " + "  |");
        System.out.println("| " + "  " + "  " + "  |");
        System.out.println("---------");

        String gameString = "         ";
        String newString;
        boolean xWins;
        boolean oWins;
        boolean draw = false;
        int xCount;
        int oCount;

        do {
            String x;
            String y;
            boolean askForInput = true;

            do {

                System.out.print("Enter the coordinates: ");
                x = scanner.next();
                y = scanner.next();
    
                if ((!isNumeric(x) || !isNumeric(y))) {
                    System.out.println("You should enter numbers!");
                    continue;
                }

                boolean coordinatesAreInGrid = Integer.parseInt(x) < 4 && Integer.parseInt(y) < 4 && Integer.parseInt(x) > 0 && Integer.parseInt(y) > 0;
                boolean inputPlaceIsEmpty = Character.toString(gameString.charAt(indexOfArrayFromCoordinates(Integer.parseInt(x), Integer.parseInt(y)))).equals(" ");
                if (!inputPlaceIsEmpty) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else if (inputPlaceIsEmpty && (!isNumeric(x) || !isNumeric(y))){
                    System.out.println("You should enter numbers!");
                } else if (inputPlaceIsEmpty && !coordinatesAreInGrid) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (inputPlaceIsEmpty && coordinatesAreInGrid && isNumeric(x) && isNumeric(y)) {
                    askForInput = false;
                }
    
            } while (askForInput);

            char characterToAdd;
            if (xTurn) characterToAdd = 'X';
            else characterToAdd = 'O';

            newString = gameString.substring(0, indexOfArrayFromCoordinates(Integer.parseInt(x), Integer.parseInt(y))) + Character.toString(characterToAdd) + gameString.substring(indexOfArrayFromCoordinates(Integer.parseInt(x), Integer.parseInt(y)) + 1, 9);
            gameString = newString.substring(0);

            System.out.println("---------");
            System.out.println("| " + newString.charAt(0) + " " + newString.charAt(1) + " " + newString.charAt(2) + " |");
            System.out.println("| " + newString.charAt(3) + " " + newString.charAt(4) + " " + newString.charAt(5) + " |");
            System.out.println("| " + newString.charAt(6) + " " + newString.charAt(7) + " " + newString.charAt(8) + " |");
            System.out.println("---------");

            xCount = 0;
            oCount = 0;
            for (int i = 0; i < gameString.length(); i++) {
                if (gameString.charAt(i) == 'X') {
                    xCount++;
                }
                if (gameString.charAt(i) == 'O') {
                    oCount++;
                }
            }

            // boolean oneGreaterThanOther = Math.abs(xCount - oCount) > 1;

            boolean firstRowContainsX = (gameString.charAt(0) == 'X' && gameString.charAt(1) == 'X' && gameString.charAt(2) == 'X');
            boolean secondRowContainsX = (gameString.charAt(3) == 'X' && gameString.charAt(4) == 'X' && gameString.charAt(5) == 'X');
            boolean thirdRowContainsX = (gameString.charAt(7) == 'X' && gameString.charAt(6) == 'X' && gameString.charAt(8) == 'X');
            boolean diagonal1ContainsX = (gameString.charAt(0) == 'X' && gameString.charAt(4) == 'X' && gameString.charAt(8) == 'X');
            boolean diagonal2ContainsX = (gameString.charAt(2) == 'X' && gameString.charAt(4) == 'X' && gameString.charAt(6) == 'X');
            boolean firstColumnContainsX = (gameString.charAt(0) == 'X' && gameString.charAt(3) == 'X' && gameString.charAt(6) == 'X');
            boolean secondColumnContainsX = (gameString.charAt(1) == 'X' && gameString.charAt(4) == 'X' && gameString.charAt(7) == 'X');
            boolean thirdColumnContainsX = (gameString.charAt(2) == 'X' && gameString.charAt(5) == 'X' && gameString.charAt(8) == 'X');

            boolean firstRowContainsO = (gameString.charAt(0) == 'O' && gameString.charAt(1) == 'O' && gameString.charAt(2) == 'O');
            boolean secondRowContainsO = (gameString.charAt(3) == 'O' && gameString.charAt(4) == 'O' && gameString.charAt(5) == 'O');
            boolean thirdRowContainsO = (gameString.charAt(7) == 'O' && gameString.charAt(6) == 'O' && gameString.charAt(8) == 'O');
            boolean diagonal1ContainsO = (gameString.charAt(0) == 'O' && gameString.charAt(4) == 'O' && gameString.charAt(8) == 'O');
            boolean diagonal2ContainsO = (gameString.charAt(2) == 'O' && gameString.charAt(4) == 'O' && gameString.charAt(6) == 'O');
            boolean firstColumnContainsO = (gameString.charAt(0) == 'O' && gameString.charAt(3) == 'O' && gameString.charAt(6) == 'O');
            boolean secondColumnContainsO = (gameString.charAt(1) == 'O' && gameString.charAt(4) == 'O' && gameString.charAt(7) == 'O');
            boolean thirdColumnContainsO = (gameString.charAt(2) == 'O' && gameString.charAt(5) == 'O' && gameString.charAt(8) == 'O');

            xWins = firstRowContainsX || secondRowContainsX || thirdRowContainsX || firstColumnContainsX || secondColumnContainsX || thirdColumnContainsX ||diagonal1ContainsX || diagonal2ContainsX;
            oWins = firstRowContainsO || secondRowContainsO || thirdRowContainsO || firstColumnContainsO || secondColumnContainsO || thirdColumnContainsO ||diagonal1ContainsO || diagonal2ContainsO;

            if (Math.abs(xCount - oCount) == 1 && !gameString.contains(" ")) {
                draw = true;
            }

            xTurn = !xTurn;

            if (xWins || oWins || draw) break;


        } while (true); 

        scanner.close();

        if (xWins && !oWins){
            System.out.println("X wins");
        } else if (!xWins && oWins) {
            System.out.println("O wins");
        } else if (Math.abs(xCount - oCount) == 1 && !gameString.contains(" ")){
            System.out.println("Draw");
        }

    }
}