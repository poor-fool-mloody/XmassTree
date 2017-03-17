package com.bucbuc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static int levels;
	static String sign, direction;

	public static void main(String[] args) {
		getData();
		drawTree(levels, sign, direction);
	}

	private static void drawTree(int lvls, String s, String dir) {

		switch (dir) {
		case "up":
			for (int i = 0; i < lvls; i++) {
				drawBranch(lvls - i - 1, " ");
				drawBranch(2 * i + 1, s);

				System.out.println();
			}
			break;

		case "down":
			for (int i = lvls; i > 0; i--) {
				drawBranch(lvls - i, " ");
				drawBranch(2 * i - 1, s);

				System.out.println();
			}
			break;

		case "left":
			for (int i = 0; i < 2 * lvls; i++) {
				if (i < lvls) {
					drawBranch(lvls - i - 1, " ");
					drawBranch(i + 1, s);
					System.out.println();
				} else if (i > lvls) {
					drawBranch(i - lvls, " ");
					drawBranch(i - 2 * (i - lvls), s);
					System.out.println();
				}

			}
			break;

		case "right":
			for (int i = 0; i < 2 * lvls; i++) {
				if (i < lvls) {
					drawBranch(i + 1, s);
					System.out.println();
				} else if (i > lvls) {
					drawBranch(i - 2 * (i - lvls), s);
					System.out.println();
				}
			}
			break;
		}
	}

	private static void drawBranch(int count, String s) {
		for (int i = count; i > 0; i--)
			System.out.print(s);
	}

	private static void getData() {
		levels = getLevels();
		sign = getSign();
		direction = getDirection();
	}

	private static String getDirection() {
		String dir;

		do {
			Scanner in = new Scanner(System.in);

			System.out.println("Direction:");
			dir = in.next();
		} while (dir.isEmpty() || (!(dir.equalsIgnoreCase("up") || dir.equalsIgnoreCase("down")
				|| dir.equalsIgnoreCase("left") || dir.equalsIgnoreCase("right"))));
		return dir;
	}

	private static String getSign() {
		String s = null;

		do {
			Scanner in = new Scanner(System.in);

			System.out.println("Sign:");
			s = in.next();
		} while (s.isEmpty() || s.length() != 1);
		return s;
	}

	private static int getLevels() {
		int lvls = 0; 

		while (lvls <= 0) {
			try {
				Scanner in = new Scanner(System.in);

				System.out.println("Levels:");
				lvls = in.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Not int");
			}
		}

		return lvls;
	}
}
