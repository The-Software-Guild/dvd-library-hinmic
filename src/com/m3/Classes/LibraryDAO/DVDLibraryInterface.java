package com.m3.Classes.LibraryDAO;

import com.m3.Classes.LibraryDTO.DVD;

import java.util.Set;

public interface DVDLibraryInterface {

    void addDVD(DVD dvd);

    void removeDVD(String title);

    void displayDVD(String title);

    void editDVDTitle(String oldTitle, String newTitle);

    void editDVDReleaseDate(String title, String releaseDate);

    void editDVDDirectorName(String title, String directorName);

    void editDVDMpaaRating(String title, String rating);

    void editDVDStudio(String title, String studio);

    void editDVDUserNote(String title, String note);

    void listDVDs();

    Set<String> getKeys();

    DVD searchDVD(String title);
}
