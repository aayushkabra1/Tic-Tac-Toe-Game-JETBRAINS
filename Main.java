import java.util.Scanner;

public class Main {

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

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Cells: ");
        String inputString = scanner.next();

        System.out.println("---------");
        System.out.println("| " + inputString.charAt(0) + " " + inputString.charAt(1) + " " + inputString.charAt(2) + " |");
        System.out.println("| " + inputString.charAt(3) + " " + inputString.charAt(4) + " " + inputString.charAt(5) + " |");
        System.out.println("| " + inputString.charAt(6) + " " + inputString.charAt(7) + " " + inputString.charAt(8) + " |");
        System.out.println("---------");

        System.out.println("Enter the coordinates: ");
        
        String x;
        String y;
        boolean askForInput = true;
        do {
            x = scanner.next();
            y = scanner.next();

            boolean coordinatesAreInGrid = Integer.parseInt(x) < 4 && Integer.parseInt(y) < 4 && Integer.parseInt(x) > 0 && Integer.parseInt(y) > 0;
            boolean inputPlaceIsEmpty = Character.toString(inputString.charAt(indexOfArrayFromCoordinates(Integer.parseInt(x), Integer.parseInt(y)))).equals("_");
            if (!inputPlaceIsEmpty) {
                System.out.println("This cell is occupied! Choose another one!");
            } else if (inputPlaceIsEmpty && (!isNumeric(x) || !isNumeric(y))){
                System.out.println("You should enter numbers!");
            } else if (inputPlaceIsEmpty && !coordinatesAreInGrid) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (inputPlaceIsEmpty && coordinatesAreInGrid && isNumeric(x) && isNumeric(y)) {
                askForInput = false;
            }

        } while (askForInput == true);

        String newString = inputString.substring(0, indexOfArrayFromCoordinates(Integer.parseInt(x), Integer.parseInt(y))) + Character.toString('X') + inputString.substring(indexOfArrayFromCoordinates(Integer.parseInt(x), Integer.parseInt(y)) + 1, 9);
        System.out.println("---------");
        System.out.println("| " + newString.charAt(0) + " " + newString.charAt(1) + " " + newString.charAt(2) + " |");
        System.out.println("| " + newString.charAt(3) + " " + newString.charAt(4) + " " + newString.charAt(5) + " |");
        System.out.println("| " + newString.charAt(6) + " " + newString.charAt(7) + " " + newString.charAt(8) + " |");
        System.out.println("---------");

        scanner.close();
    }
}
