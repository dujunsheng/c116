package com.school.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.school.po.Student;


public class ExcelUtil {
	/** 
     * 读取报表 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
     */  
    public <T> List<T> readReport(InputStream inp,  Class<T> clazz, Map<Integer,String> map) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException  {  
  
        List<T> list = new ArrayList<T>();  
  
        try {  
  
            Workbook wb = WorkbookFactory.create(inp);  
  
            Sheet sheet = wb.getSheetAt(0);// 取得第一个sheets  
            
            Field field = null ;
            
            //从第一行开始读取数据  
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {  
  
                Row row = sheet.getRow(i); // 获取行(row)对象  
                T t = clazz.newInstance() ;
                T t1 = clazz.newInstance() ;
                
                if (row == null) {  
                    // row为空的话,不处理  
                    continue;  
                }  

                for (int j = 0; j < row.getLastCellNum(); j++) {  
                	field = clazz.getDeclaredField(map.get(j+1)) ;
                	field.setAccessible(true);
                	// 获得单元格(cell)对象 
                    Cell cell = row.getCell(j);  
                    // 将单元格的数据添加至一个对象对应的属性中
                    t = addingT(field, t1, cell);  
                }  
                // 将添加数据后的对象填充至list中  
                list.add(t);  
            }  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
         finally {  
            if (inp != null) {  
                try {  
                    inp.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            } 
        }  
        return list;  
  
    }   
    
    private <T> T addingT(Field field, T t, Cell cell) throws IllegalArgumentException, IllegalAccessException {  
    	
        switch (cell.getCellType()) {  
        
        case Cell.CELL_TYPE_STRING:  
            // 读取String  
        	field.set(t, cell.getStringCellValue());  
            break;  
        
            
        case Cell.CELL_TYPE_BOOLEAN:  
            // 得到Boolean对象的方法  
            field.set(t, cell.getBooleanCellValue());
            break;  
  
        case Cell.CELL_TYPE_NUMERIC:  
  
            // 先看是否是日期格式  
            if (DateUtil.isCellDateFormatted(cell)) {  
                // 读取日期格式  
            	
            	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        		
            	field.set(t, df.format(cell.getDateCellValue()));  
  
            } else {    
                // 读取数字  
            	
                Integer longVal = (int) Math.round(cell.getNumericCellValue()); 
                double doubleVal = Math.round(cell.getNumericCellValue()); 
                
				if(Double.parseDouble(longVal + ".0") == doubleVal){  
                	String type = field.getType().toString() ;
                	if (type.equals("class java.lang.String")){
                		field.set(t, longVal+"") ;
                	}else
                		field.set(t, longVal) ;  }
                else  
                	field.set(t, doubleVal);            	
            }  
            break;  
  
        case Cell.CELL_TYPE_FORMULA:  
            // 读取公式  
        	field.set(t,cell.getCellFormula());  
            break;  
        
		case HSSFCell.CELL_TYPE_BLANK: // 空值
			break;
			
		case HSSFCell.CELL_TYPE_ERROR: // 故障
			break;  
        }
        
        return t;  
    }
}
