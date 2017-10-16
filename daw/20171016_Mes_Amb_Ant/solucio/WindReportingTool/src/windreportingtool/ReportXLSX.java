package windreportingtool;

import java.io.FileOutputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import windreportingtool.WindReportingTool.InfoWind;

/**
 *
 * @author BERNAT
 */
public class ReportXLSX {

    public static void writeReport(ArrayList<InfoWind> infos, String filename) throws Exception {
                       
        Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        String safeName = WorkbookUtil.createSafeSheetName("Wind's");
        Sheet sheet = wb.createSheet(safeName);        

        
        CellStyle cellStyle = wb.createCellStyle();

        Font font = wb.createFont();
        font.setFontHeightInPoints((short)14);
        font.setFontName("Arial");
        font.setBold(true);

        cellStyle.setFont(font);                        
        
        Row row = sheet.createRow(0);
        Cell cela0 = row.createCell(0);
        Cell cela1 = row.createCell(1);
        cela0.setCellStyle(cellStyle);
        cela1.setCellStyle(cellStyle);
        cela0.setCellValue(createHelper.createRichTextString("BEACH"));
        cela1.setCellValue(createHelper.createRichTextString("KM/H"));
        int r=1;
        for(InfoWind inf:infos) {
            row = sheet.createRow((short)r);            
            row.createCell(0).setCellValue(
                 createHelper.createRichTextString(inf.getNom()));
            row.createCell(1).setCellValue(inf.getVelocity());
            r++;
        }
        FileOutputStream fileOut = new FileOutputStream("output/"+filename+".xlsx");
        wb.write(fileOut);
        fileOut.close();
        System.out.println("Arxiu"+filename+".xlsx generat correctament.");
    }
}
