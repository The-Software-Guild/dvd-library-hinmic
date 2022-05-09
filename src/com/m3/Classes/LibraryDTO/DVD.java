package com.m3.Classes.LibraryDTO;

import java.time.LocalDate;

public class DVD {
    enum MPAA {
        G,
        PG,
        PG13,
        R,
        NC17
    }

    private String title;
    private String releaseDate;
    private String directorName;
    private MPAA mpaaRating;
    private String studio;
    private String userNote;

    public DVD(String title, String releaseDate, String directorName,
               String rating, String studio, String note) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.directorName = directorName;
        this.studio = studio;
        this.userNote = note;

        switch (rating) {
            case "G":
                this.mpaaRating = MPAA.G;
                break;
            case "PG":
                this.mpaaRating = MPAA.PG;
                break;
            case "PG13":
                this.mpaaRating = MPAA.PG13;
                break;
            case "R":
                this.mpaaRating = MPAA.R;
                break;
            default:
                this.mpaaRating = MPAA.NC17;
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setDirectorName(String name) {
        this.directorName = name;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setMpaaRating(String rating) {
        switch (rating) {
            case "G":
                this.mpaaRating = MPAA.G;
                break;
            case "PG":
                this.mpaaRating = MPAA.PG;
                break;
            case "PG13":
                this.mpaaRating = MPAA.PG13;
                break;
            case "R":
                this.mpaaRating = MPAA.R;
                break;
            default:
                this.mpaaRating = MPAA.NC17;
        }
    }

    public MPAA getMpaaRating() {
        return mpaaRating;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getStudio() {
        return studio;
    }

    public void setUserNote(String note) {
        this.userNote = note;
    }

    public String getUserNote() {
        return userNote;
    }
}
