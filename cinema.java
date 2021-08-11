import java.util.Scanner;

public class Cinema {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int r = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int s = scanner.nextInt();
        int allSeats = r * s;
        int totalIncome;
        if (allSeats <= 60) {
            totalIncome = allSeats * 10;
        } else if (r % 2 != 0) {
            totalIncome = (r / 2) * s * 10 + ((r / 2) + 1) * s * 8; 
        } else {
            totalIncome = (r / 2) * s * 10 + (r / 2) * s * 8;
        }
        int currInc = 0;
        int ticket = 0;
        char[][] arr = new char[r][s];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = 'S';
            }
        }
        outer:
        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            
            int action = scanner.nextInt();
            
            switch (action) {
                case 0:
                    break outer;
                case 1:
                    showSeats(arr);
                    break;
                case 2:
                    buyTicket(arr, currInc, ticket);
                    break;
                case 3:
                    showStatistics(arr, ticket, currInc, totalIncome);
                    break;
                default:
                    System.out.println("Wrong input!");
                    
            }
        }
    }
    public static void showSeats(char[][] arr) {
        System.out.println("Cinema:");
        for (int i = 1; i <= arr[0].length; i++) {
            if (i == 1) {
                System.out.print("  ");
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (j == 0) {
                    System.out.print(i + 1 + " ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void buyTicket(char[][] arr, int inc, int ticket) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter a row number:");
            int rn = scanner.nextInt();
            System.out.println("Enter a seat number in that row: ");
            int sn = scanner.nextInt();
            if (rn > arr.length || sn > arr[0].length) {
                System.out.println("Wrong input!");
                continue;
            } else if (arr[rn - 1][sn - 1] == 'B') {
                System.out.println("That ticket has already been purchased!");
                continue;
            } else {
                arr[rn - 1][sn - 1] = 'B';
                if (arr.length * arr[0].length > 60) {
                    if (rn > arr.length / 2) {
                        System.out.println("Ticket price: $8");
                        inc += 8;
                    } else {
                        System.out.println("Ticket price: $10");
                        inc += 10;
                    } 
                } else {
                    System.out.println("Ticket price: $10");
                    inc += 10;
                }
                ticket += 1;
                System.out.println(ticket + "XXXXXXXXXXXXXXXXXXXXX");
                break;
            }
        }
    }
    public static void showStatistics(char[][] arr, int ticket, int inc, int totInc) {
        System.out.println("Number of purchased tickets: " + ticket);
        int s = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 'S') {
                    s++;
                } else {
                    b++;
                }
            }
        }
        double percentage = b * 100 / s;
        System.out.println("Percentage: " + String.format("%.2f%%", percentage));
        System.out.println("Current income: $" + inc);
        System.out.println("Total income: $" + totInc);
        
    }
   
    
}
