package com.m3.Classes.LibraryUI;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private UserIO userIO;

    public View(UserIO userIO) {
        this.userIO = userIO;
    }

    public int menu() {
        userIO.print("Menu:");
        userIO.print("  0. Exit");
        userIO.print("  1. Add a DVD");
        userIO.print("  2. Remove a DVD");
        userIO.print("  3. Edit the information of a DVD");
        userIO.print("  4. List all DVDs");
        userIO.print("  5. Search a DVD");
        userIO.print("  6. Load the DVD library from a file");
        userIO.print("  7. Save the DVD Library to a file");

        return userIO.readInt("  Select the operation you wish to perform:", 0, 7);
    }

    public String operation1() {
        userIO.print("Operation - Add a DVD:");
        String title = userIO.readString("  Enter the title:");
        int year = userIO.readInt("  Enter the year of release:", 1997, 2050);
        int month = userIO.readInt("  Enter the month of release:", 1, 12);
        int day = userIO.readInt("  Enter the day of release:", 1, 31);
        LocalDate date;
        try {
            date = LocalDate.of(year, month, day);
        } catch (Exception DateTimeException) {
            userIO.print("Invalid date. Navigate back to the main menu.");
            return null;
        }
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String releaseDate = date.format(dateFormat);
        String directorName = userIO.readString("  Enter the name of the director:");
        String mpaaRating = userIO.readString("  Enter the MPAA rating:");
        String studio = userIO.readString("  Enter the name of the studio:");
        String note = userIO.readStringOptional("  (Optional) Enter user rating/note:");

        return (title + "::" + releaseDate + "::" + directorName + "::" + mpaaRating + "::" +
                studio + "::" + note);
    }

    public String operation2() {
        userIO.print("Operation - Remove a DVD:");
        return userIO.readString("  Enter the title:");
    }

    public int operation3() {
        userIO.print("Operation - Edit a DVD:");
        userIO.print("  1. Title");
        userIO.print("  2. Release date");
        userIO.print("  3. Director's name");
        userIO.print("  4. MPAA Rating:");
        userIO.print("  5. Studio");
        userIO.print("  6. User rating/note");

        return userIO.readInt("  Select the property you want to edit:", 1, 6);
    }

    public String operation3_1() {
        String oldTitle = userIO.readString("  Enter the old title:");
        String newTitle = userIO.readString("  Enter the new title");

        return (oldTitle + "::" + newTitle);
    }

    public String operation3_2() {
        String title = userIO.readString("  Enter the title:");
        int year = userIO.readInt("  Enter the year of release:", 1997, 2050);
        int month = userIO.readInt("  Enter the month of release:", 1, 12);
        int day = userIO.readInt("  Enter the day of release:", 1, 31);
        LocalDate date;
        try {
            date = LocalDate.of(year, month, day);
        } catch (Exception DateTimeException) {
            userIO.print("Invalid date. Navigate back to the main menu.");
            return null;
        }
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String releaseDate = date.format(dateFormat);

        return (title + "::" + releaseDate);
    }

    public String operation3_3() {
        String title = userIO.readString("  Enter the title:");
        String directorName = userIO.readString("  Enter the name of the director:");

        return (title + "::" + directorName);
    }

    public String operation3_4() {
        String title = userIO.readString("  Enter the title:");
        String rating = userIO.readString("  Enter the MPAA rating:");

        return (title + "::" + rating);
    }

    public String operation3_5() {
        String title = userIO.readString("  Enter the title:");
        String studio = userIO.readString("  Enter the name of the studio:");

        return (title + "::" + studio);
    }

    public String operation3_6() {
        String title = userIO.readString("  Enter the title:");
        String note = userIO.readString("  Enter user rating/note:");

        return (title + "::" + note);
    }

    public void operation4() {
        userIO.print("Operation - List all DVDs:");
    }

    public String operation5() {
        userIO.print("Operation - Search a DVD:");
        return userIO.readString("  Enter the title:");
    }

    public String operation6() {
        userIO.print("Operation - Load from a file:");
        return userIO.readString("  Enter the file name:");
    }

    public List<String> operation6(String fileName) {
        Scanner scanner;
        String currentLine;
        List<String> dvdList = new ArrayList<String>();

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        } catch (FileNotFoundException error) {
            userIO.print("File not found. Navigate back to the main menu.");
            return null;
        }

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            dvdList.add(currentLine);
        }

        return dvdList;
    }

    public String operation7() {
        userIO.print("Operation - Save to a file:");
        return userIO.readString("  Enter the file name:");
    }

    public void operation7(String fileName, List<String> dvdList) throws Exception {
        PrintWriter printer = new PrintWriter(new FileWriter(fileName));
        for (String dvdInfo : dvdList) {
            printer.println(dvdInfo);
        }
        printer.flush();
        printer.close();
    }
}
