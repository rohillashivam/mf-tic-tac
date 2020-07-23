package com.mfl.tictac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mfl.tictac.exception.UnavailableBoxException;
import com.mfl.tictac.game.initializer.GameInitializer;
import com.mfl.tictac.game.orchestrator.GameOrchestrator;
import com.mfl.tictac.player.Player;

public class TicTacToe {

	private static final String ENTRY_STR = "Enter any number from 1-9 to indicate your move : ";
	private static final String Player_STR = "Player - ";

	public static void main(String[] args) {
		GameInitializer initializer = new GameInitializer();
		GameOrchestrator orchestrator = initializer.initilize();
		boolean playerXTurn = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int retryCount = 0;
		boolean failureCase = false;
		while (!orchestrator.isGameOver()) {
			try {
				if (playerXTurn) {
					System.out.println(Player_STR + "X" + ENTRY_STR);
				} else {
					System.out.println(Player_STR + "O" + ENTRY_STR);
				}
				String moveNum = br.readLine();
				int num = Integer.parseInt(moveNum);
				try {
					orchestrator.orchestrate(num, playerXTurn ? 'X' : 'O');
				} catch(UnavailableBoxException e) {
					System.out.println("wrong box chosen");
					retryCount++;
					if(retryCount == 3) {
						System.out.println("Exiting game");
						failureCase = true;
						break;
					}
					continue;
					
				}
				playerXTurn = !playerXTurn;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(failureCase)
			return;
		if(orchestrator.isGameDrawn())
			System.out.println("GAME DRAWN");
		else {
			Player player = orchestrator.getWinner();
			System.out.println("Player - "+player.getPlayerChar()+" won ");
		}
	}
}
