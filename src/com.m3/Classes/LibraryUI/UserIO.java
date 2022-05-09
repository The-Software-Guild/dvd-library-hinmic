package com.m3.Classes.LibraryUI;

public interface UserIO {

    void print(String message);

    String readString(String prompt);

    String readStringOptional(String prompt);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);
}
