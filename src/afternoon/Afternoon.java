/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afternoon;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import javafx.scene.layout.GridPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
/**
 *
 * @author Salim
 */
public class Afternoon extends Application {
    Stage window;
    Scene Home,Cabin,Priority,Activity, Camper;
    static XSSFRow row;
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        
        //creating all of the buttons
        Button CamperSelect = new Button();
        Button ActivitySelect = new Button();
        Button PrioritySelect = new Button();
        Button GenerateChoices = new Button();
        Button ReturnHome = new Button();
        
        CamperSelect.setText("Pick Camper Activity");
        ActivitySelect.setText("Set the Activities");
        PrioritySelect.setText("Set the Priority");
        GenerateChoices.setText("Get the Results");
        ReturnHome.setText("Go Back");
        CamperSelect.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event){

                System.out.println("Hello World!");
                
            }
        });
        
        //creating all of the Layouts
        GridPane HomeLayout = new GridPane();
        HomeLayout.addRow(0,CamperSelect,ActivitySelect);
        HomeLayout.addRow(1, PrioritySelect,GenerateChoices);
        
        
        
        Home = new Scene(HomeLayout, 500, 500);
       // Home = new Scene(HomeLayout, 500, 500);
       // Home = new Scene(HomeLayout, 500, 500);
       // Home = new Scene(HomeLayout, 500, 500);
        
        window.setTitle("AfternoonProgram");
        window.setScene(Home);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int CabinNumber = 0;
        String CamperName = "";
        Cabin[] CabinList = new Cabin[20];
        File campers = new File("BONDINATOR9000.xlsx");
        FileInputStream fip = new FileInputStream(campers);
        XSSFWorkbook workbook = new XSSFWorkbook(fip);
        
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        Iterator < Row >  rowIterator = spreadsheet.iterator();
        while (rowIterator.hasNext()) {
         row = (XSSFRow) rowIterator.next();
         Iterator < Cell >  cellIterator = row.cellIterator();
         
         while ( cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            
            switch (cell.getCellType()) {
               case NUMERIC:
                  CabinNumber = (int)cell.getNumericCellValue();
                  if(CabinList[CabinNumber] == null){
                    CabinList[CabinNumber] = new Cabin(CabinNumber);
                  }
                  break;
               
               case STRING:
                  CamperName = CamperName + " " + cell.getStringCellValue();
                  break;
            }
         }
         Camper c = new Camper(CamperName, CabinNumber);
         CabinList[CabinNumber].AddCamper(c);
         CamperName = "";
         System.out.println(CabinList[CabinNumber].GetCabinNumber() + "\t\t" + c.GetName());
        }
        fip.close();
         
        //Create a blank sheet
           
        launch(args);
    }
    
}
