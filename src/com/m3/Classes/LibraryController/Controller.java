package com.m3.Classes.LibraryController;

import com.m3.Classes.LibraryDAO.DVDLibraryImplementation;
import com.m3.Classes.LibraryDAO.DVDLibraryInterface;
import com.m3.Classes.LibraryDTO.DVD;
import com.m3.Classes.LibraryUI.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Controller {
    private View session;
    private DVDLibraryInterface dvdLibrary;

    public Controller(View session, DVDLibraryInterface libraryDao) {
        this.session = session;
        this.dvdLibrary = libraryDao;
    }

    public void run() throws Exception {
        DVD dvd;
        int input;

        do {
            input = session.menu();
            String dvdTitle, fileName;
            switch (input) {
                case 1:
                    String dvdInfo = session.operation1();
                    String[] infoList = dvdInfo.split("::");
                    dvd = new DVD(infoList[0], infoList[1], infoList[2], infoList[3], infoList[4], infoList[5]);
                    dvdLibrary.addDVD(dvd);
                    break;
                case 2:
                    dvdTitle = session.operation2();
                    dvdLibrary.removeDVD(dvdTitle);
                    break;
                case 3:
                    int select = session.operation3();
                    String editInfo;
                    String[] propList;
                    switch (select) {
                        case 1:
                            editInfo = session.operation3_1();
                            propList = editInfo.split("::");
                            dvdLibrary.editDVDTitle(propList[0], propList[1]);
                            break;
                        case 2:
                            editInfo = session.operation3_2();
                            propList = editInfo.split("::");
                            dvdLibrary.editDVDReleaseDate(propList[0], propList[1]);
                            break;
                        case 3:
                            editInfo = session.operation3_3();
                            propList = editInfo.split("::");
                            dvdLibrary.editDVDDirectorName(propList[0], propList[1]);
                            break;
                        case 4:
                            editInfo = session.operation3_4();
                            propList = editInfo.split("::");
                            dvdLibrary.editDVDMpaaRating(propList[0], propList[1]);
                            break;
                        case 5:
                            editInfo = session.operation3_5();
                            propList = editInfo.split("::");
                            dvdLibrary.editDVDStudio(propList[0], propList[1]);
                            break;
                        case 6:
                            editInfo = session.operation3_6();
                            propList = editInfo.split("::");
                            dvdLibrary.editDVDUserNote(propList[0], propList[1]);
                            break;
                    }
                    break;
                case 4:
                    session.operation4();
                    dvdLibrary.listDVDs();
                    break;
                case 5:
                    dvdTitle = session.operation5();
                    dvdLibrary.displayDVD(dvdTitle);
                    break;
                case 6:
                    fileName = session.operation6();
                    List<String> dvdList = session.operation6(fileName);
                    for (String str : dvdList) {
                        propList = str.split("::");
                        dvd = new DVD(propList[0], propList[1], propList[2], propList[3],
                                propList[4], propList[5]);
                        dvdLibrary.addDVD(dvd);
                    }
                    break;
                default:
                    fileName = session.operation7();
                    String saveInfo;
                    List<String> saveList = new ArrayList<String>();
                    Set<String> keys = dvdLibrary.getKeys();
                    for (String key : keys) {
                        dvd = dvdLibrary.searchDVD(key);
                        saveInfo = dvd.getTitle() + "::" + dvd.getReleaseDate() + "::" +
                                dvd.getDirectorName() + "::" + dvd.getMpaaRating() + "::" +
                                dvd.getStudio() + "::" + dvd.getUserNote();
                        saveList.add(saveInfo);
                    }
                    session.operation7(fileName, saveList);
                    System.out.println("Session ends.");
            }
        } while (input > 0 && input < 7);
    }
}
