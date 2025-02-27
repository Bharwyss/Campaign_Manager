package campaignGUI.tools;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

// Class that contain the main menu of the application
public class MenuTool
{

     public static MenuBar createMenuBar()
     {
            MenuBar mainMenu = new MenuBar();

         // Files menu
         Menu filesMenu = new Menu("Files");
         MenuItem newFiles = new MenuItem("New");
         MenuItem openFiles = new MenuItem("Open");
         MenuItem recentFiles = new MenuItem("Recent");
         MenuItem saveFiles = new MenuItem("Save");
         MenuItem saveAsFiles = new MenuItem("Save as");
         MenuItem exitFiles = new MenuItem("Exit");
         filesMenu.getItems().addAll(newFiles, openFiles, recentFiles, saveFiles, saveAsFiles, exitFiles);

         // Edit menu
         Menu editMenu = new Menu("Edit");
         MenuItem undoEdit = new MenuItem("Undo");
         MenuItem redoEdit = new MenuItem("Redo");
         MenuItem cutEdit = new MenuItem("Cut");
         MenuItem copyEdit = new MenuItem("Copy");
         MenuItem pasteEdit = new MenuItem("Paste");
         editMenu.getItems().addAll(undoEdit, redoEdit, cutEdit, copyEdit, pasteEdit);

         // Help menu
         Menu helpMenu = new Menu("Help");

         // Add menus to the menu bar
         mainMenu.getMenus().addAll(filesMenu, editMenu, helpMenu);

         return mainMenu;
     }
}



