package com.m3.Classes.LibraryUI;

import java.util.Scanner;

public class UserIOImplementation implements UserIO {
    Scanner inputReader = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        String input = "";
        do {
            print(prompt + ' ');
            input = inputReader.nextLine();
        } while (input.isEmpty());

        return input;
    }

    public String readStringOptional(String prompt) {
        String input;
        print(prompt + ' ');
        input = inputReader.nextLine();
        if (input.isEmpty()) {
            return null;
        } else {
            return input;
        }
    }

    @Override
    public int readInt(String prompt) {
        print(prompt + ' ');
        return Integer.parseInt(inputReader.nextLine());
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int input;
        do {
            print(prompt + ' ');
            try {
                input = Integer.parseInt(inputReader.nextLine());
            } catch (NumberFormatException error) {
                print("Not an integer!");
                input = 0;
            }
        } while (input <= min && input >= max);

        return input;
    }
}
