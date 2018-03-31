package java.analyzer;

import java.fillers.Fillers;
import java.fillers.Generic;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.sorters.Sort;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IOException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Get Set with Classes extends Sort
        Set<Class<? extends Sort>> sorters = Analyze.getAllClasses();
        // Get Set with Methods annotated @Fillers
        Set<Method> fillers = Analyze.getAllMethods(Fillers.class);
        HSSFWorkbook book = new HSSFWorkbook();
        //System.out.println("Create book");

        for (Method filler : fillers) {
            //Create sheet and title
            System.out.println(filler.getName());
            HSSFSheet sheet = book.createSheet(filler.getName());
            HSSFRow rowTitle = sheet.createRow(0);
            rowTitle.createCell(0).setCellValue("Nothing");
            for(int i=1, length = 16; length < 10000; i++, length*=2) {
                rowTitle.createCell(i).setCellValue(Integer.toString(length));
            }
            int numberRow = 1;
            for(Class sorter: sorters){
                // Excel
                System.out.println(sorter.getName());
                System.out.println("Keep calm");
                HSSFRow row = sheet.createRow(numberRow);
                row.createCell(0).setCellValue(sorter.getName());
                numberRow++;
                // Get method sort from sorter(Class extends Sort)
                ArrayList<Integer> a = new ArrayList<>();
                Class[] paramTypes = new Class[]{a.getClass()};
                Method sort = sorter.getMethod("sort", paramTypes);
                //System.out.println("Dangerous Loop");
                for (int length = 16, numberCell = 1; length <10011; length*=2, numberCell++){
                    long startTime = System.currentTimeMillis();
                    for (int i = 0; i<1000; i++){
                        // Generating new array with length and sorting it
                        ArrayList<Integer> array =(ArrayList<Integer>) filler.invoke(new Generic() , new Object[]{new Integer(length)});
                        //Sorting an array
                        sort.invoke(sorter.newInstance(), array);
                    }

                    long timeSpent = System.currentTimeMillis() - startTime;
                    System.out.println("You did it for " + timeSpent);
                    row.createCell(numberCell).setCellValue(Long.toString(timeSpent));
                }
            }
        }
        System.out.println("End");

        FileOutputStream outFile = new FileOutputStream("src/java.excel/analysis.xls");
        book.write(outFile);
        book.close();
        outFile.close();
        System.out.println("Happy End");
    }

}
