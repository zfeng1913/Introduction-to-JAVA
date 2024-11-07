import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Battleship {
  public static class res {
    public static int player1 = 0;
    public static int player2 = 0;
    public static char [][] player1_board = {
    { '-', '-', '-', '-', '-'},
    { '-', '-', '-', '-', '-'},
    { '-', '-', '-', '-', '-'},
    { '-', '-', '-', '-', '-'},
    { '-', '-', '-', '-', '-'}};
    public static char [][] player2_board = {
    { '-', '-', '-', '-', '-'},
    { '-', '-', '-', '-', '-'},
    { '-', '-', '-', '-', '-'},
    { '-', '-', '-', '-', '-'},
    { '-', '-', '-', '-', '-'}};
}

    // Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}
  public static char[][] getplayer_position(String player, char[][] player_ship, Scanner input) {
    System.out.println(player + ", ENTER YOUR SHIPS’ COORDINATES.");


    for (int i = 0; i < 5; i++){
      System.out.println("Enter ship " + (i+1) + " location:");
      int a = input.nextInt();
      int b = input.nextInt();

      while ((a<0) || (b<0) || (a>4) ||(b>4)){
        System.out.println("Invalid coordinates. Choose different coordinates.");
        System.out.println("Enter ship " + (i+1) + " location:");
        a = input.nextInt();
        b = input.nextInt();
      }
      while (player_ship[a][b] == '@'){
        System.out.println("You already have a ship there. Choose different coordinates.");
        a = input.nextInt();
        b = input.nextInt();
        while ((a<0) || (b<0) || (a>4) ||(b>4)){
          System.out.println("Invalid coordinates. Choose different coordinates.");
          System.out.println("Enter ship " + (i+1) + " location:");
          a = input.nextInt();
          b = input.nextInt();
        }
      }
      player_ship[a][b] = '@';
    }
    printBattleShip(player_ship);
    return player_ship;
  }

  public static char[][] hit(String player, String oppo, char[][] opp_ship, char[][] player_board, Scanner input) {
    System.out.println(player + ", enter hit row/column:");
    int a = input.nextInt();
    int b = input.nextInt();
    while ((a<0) || (b<0) || (a>4) ||(b>4)){
      System.out.println("Invalid coordinates. Choose different coordinates.");
      System.out.println(player + ", enter hit row/column:");
      a = input.nextInt();
      b = input.nextInt();
    }
    while (player_board[a][b] != '-'){
      System.out.println("You already fired on this spot. Choose different coordinates.");
      a = input.nextInt();
      b = input.nextInt();
      while ((a<0) || (b<0) || (a>4) ||(b>4)){
        System.out.println("Invalid coordinates. Choose different coordinates.");
        System.out.println(player + ", enter hit row/column:");
        a = input.nextInt();
        b = input.nextInt();
      }
    }

    if (opp_ship[a][b] == '@'){
      System.out.println(player + " HIT " + oppo+ "’s SHIP!");
      player_board[a][b] = 'X';
      if (player.equals("PLAYER 1")){
        player1_win ++;
        res.player2_board[a][b] = 'X';
      } else{
        player2_win ++;
        res.player1_board[a][b] = 'X';
      }

    } else {
      System.out.println(player + " MISSED!");
      player_board[a][b] = 'O';
      if (player.equals("PLAYER 1")){

        res.player2_board[a][b] = 'O';
      } else{

        res.player1_board[a][b] = 'O';
      }
    }
    printBattleShip(player_board);
    return player_board, res;
  }


  public static void main(String[] args) {
     //read keyboard input
    Scanner input = new Scanner(System.in); //read keyboard input
    System.out.println("Welcome to Battleship!");
    System.out.println("");
    res.player1_board = getplayer_position("PLAYER 1", res.player1_board, input);

    int count = 0;
    do {
        System.out.println("");
        count++;
    } while (count < 100);
    res.player2_board = getplayer_position("PLAYER 2", res.player2_board, input);
    System.out.println("");


    char[][] player1_shoot = {
      { '-', '-', '-', '-', '-'},
      { '-', '-', '-', '-', '-'},
      { '-', '-', '-', '-', '-'},
      { '-', '-', '-', '-', '-'},
      { '-', '-', '-', '-', '-'}};

    char[][] player2_shoot = {
      { '-', '-', '-', '-', '-'},
      { '-', '-', '-', '-', '-'},
      { '-', '-', '-', '-', '-'},
      { '-', '-', '-', '-', '-'},
      { '-', '-', '-', '-', '-'}};


    while (res.player1 < 5 && res.player2 < 5){
      player1_shoot = hit("PLAYER 1", "PlAYER 2", res.player2_board, player1_shoot, input);
      if (res.player1 == 5){
        System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
        break;
      }
      System.out.println(" ");
      player2_shoot = hit("PLAYER 2", "PlAYER 1", res.player1_board, player2_shoot, input);
    }
    if (res.player2 == 5){
      System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
    }
    System.out.println(" ");
    System.out.println("Final boards");
    printBattleShip(res.player1_board);
    System.out.println(" ");
    printBattleShip(res.player2_board);

  }
}
