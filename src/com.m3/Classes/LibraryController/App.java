package com.m3.Classes.LibraryController;

import com.m3.Classes.LibraryDAO.DVDLibraryImplementation;
import com.m3.Classes.LibraryDAO.DVDLibraryInterface;
import com.m3.Classes.LibraryUI.UserIO;
import com.m3.Classes.LibraryUI.UserIOImplementation;
import com.m3.Classes.LibraryUI.View;

public class App {
    public static void main(String[] args) throws Exception {
        UserIO io = new UserIOImplementation();
        View view = new View(io);
        DVDLibraryInterface dao = new DVDLibraryImplementation();
        Controller controller = new Controller(view, dao);
        controller.run();
    }
}
