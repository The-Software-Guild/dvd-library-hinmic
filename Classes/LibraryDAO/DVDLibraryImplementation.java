package com.m3.Classes.LibraryDAO;

import com.m3.Classes.LibraryDTO.DVD;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DVDLibraryImplementation implements DVDLibraryInterface {

    private Map<String, DVD> library = new HashMap<>();

    private boolean notNull(DVD dvd) {
        if (dvd == null) {
            System.out.println("It does not exist in the library.");
            return false;
        }

        return true;
    }

    public void addDVD(DVD dvd) {
        library.put(dvd.getTitle(), dvd);
    }

    public void removeDVD(String title) {
        DVD dvd = library.remove(title);
        System.out.println("[" + dvd.getTitle() + "] is removed from the library.");
    }

    public void displayDVD(String title) {
        DVD dvd = library.get(title);
        if (notNull(dvd)) {
            System.out.println("Title:           " + dvd.getTitle());
            System.out.println("Release Date:    " + dvd.getReleaseDate());
            System.out.println("Director's Name: " + dvd.getDirectorName());
            System.out.println("MPAA Rating:     " + dvd.getMpaaRating());
            System.out.println("Studio:          " + dvd.getStudio());
            System.out.println("User Note:       " + dvd.getUserNote());
        }
    }

    public void editDVDTitle(String oldTitle, String newTitle) {
        DVD dvd = library.get(oldTitle);
        if (notNull(dvd)) {
            dvd.setTitle(newTitle);
            library.put(newTitle, dvd);
            library.remove(oldTitle);
            displayDVD(newTitle);
        }
    }

    public void editDVDReleaseDate(String title, String releaseDate) {
        DVD dvd = library.get(title);
        if (notNull(dvd)) {
            dvd.setReleaseDate(releaseDate);
            library.put(title, dvd);
            displayDVD(title);
        }
    }

    public void editDVDDirectorName(String title, String directorName) {
        DVD dvd = library.get(title);
        if (notNull(dvd)) {
            dvd.setDirectorName(directorName);
            library.put(title, dvd);
            displayDVD(title);
        }
    }

    public void editDVDMpaaRating(String title, String rating) {
        DVD dvd = library.get(title);
        if (notNull(dvd)) {
            dvd.setMpaaRating(rating);
            library.put(title, dvd);
            displayDVD(title);
        }
    }

    public void editDVDStudio(String title, String studio) {
        DVD dvd = library.get(title);
        if (notNull(dvd)) {
            dvd.setStudio(studio);
            library.put(title, dvd);
            displayDVD(title);
        }
    }

    public void editDVDUserNote(String title, String note) {
        DVD dvd = library.get(title);
        if (notNull(dvd)) {
            dvd.setUserNote(note);
            library.put(title, dvd);
            displayDVD(title);
        }
    }

    public void listDVDs() {
        Set<String> keys = library.keySet();
        for (String title : keys) {
            System.out.println(title);
        }
    }

    public Set<String> getKeys() {
        return library.keySet();
    }

    public DVD searchDVD(String title) {
        return library.get(title);
    }
}
