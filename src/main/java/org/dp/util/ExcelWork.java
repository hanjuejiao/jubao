package org.dp.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.dp.cache.LocalCache;
import org.dp.entity.JbrReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/9.
 */
public class ExcelWork {
    //空文件持久化到磁盘
    public static void createExcel(String path){
        //生产内存中的workbook
        HSSFWorkbook wb = new HSSFWorkbook();
        //初始化
        initFile(path,wb);
        FileOutputStream fil = null;
        try{
            fil = new FileOutputStream(path);
            wb.write(fil);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fil.close();
                wb.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    //初始化文件
    public static void initFile(String path, HSSFWorkbook workbook){
        // 在Excel工作簿中建一工作表，其名为缺省值。
        // 也可以指定工作表的名字。
        HSSFSheet sheet = workbook.createSheet("sheet1");
        int rowNum = 0;// 行标
        int [] colNum = new int[19];// 列标

        // 建立表头信息
        HSSFRow row = sheet.createRow(rowNum);
        HSSFCell [] cell = new HSSFCell[19];

        //在rowNum行的colNum列上创建单元格
        for(int i=0; i<19; i++){
            colNum[i] = i;
            cell[i] = row.createCell(colNum[i]);
            cell[i].setCellType(HSSFCell.CELL_TYPE_STRING);
        }
        //为单元格赋值
        cell[0].setCellValue("id");
        cell[1].setCellValue("user_name");
        cell[2].setCellValue("user_idcard");
        cell[3].setCellValue("user_phone");
        cell[4].setCellValue("user_zz");
        cell[5].setCellValue("user_dizhi");
        cell[6].setCellValue("user_jb");
        cell[7].setCellValue("report_name");
        cell[8].setCellValue("report_dw");
        cell[9].setCellValue("report_zw");
        cell[10].setCellValue("report_jb");
        cell[11].setCellValue("title");
        cell[12].setCellValue("question1");
        cell[13].setCellValue("question2");
        cell[14].setCellValue("files");
        cell[15].setCellValue("datetime");
        cell[16].setCellValue("status");
        cell[17].setCellValue("content");
        cell[18].setCellValue("filename");

//        FileOutputStream fos = null;
        // 工作薄建立完成，下面将工作薄存入文件
        // 新建一输出文件流
//        try {
//            fos = new FileOutputStream(path);
//            // 把相应的Excel 工作簿存盘
//            workbook.write(fos);
//
//            System.out.println("创建表头成功");
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            try {
//                fos.flush();
//                fos.close();
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
    }


    public static void main(String[] args){
    	JbrReport record = new JbrReport();
    	record.setContent("dawfs");
    	record.setId(5);
    	try {
			writeExcel(record, "D:/a/a/a/a/a");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static void writeExcel(JbrReport record, String parentpath) throws IOException {

        String path = parentpath + "/reportExcel.xls";
        File file = new File(path);
        if(!file.exists()){
            createExcel(path);
        }
        FileInputStream fIn = new FileInputStream(path);
        POIFSFileSystem ps=new POIFSFileSystem(fIn);//使用POI提供的方法得到excel的信息
        HSSFWorkbook workbook = new HSSFWorkbook(ps);
        HSSFSheet sheet=workbook.getSheetAt(0);
        //System.out.println(sheet.getSheetName());
        int lastRowNum = sheet.getLastRowNum();
        HSSFRow row=sheet.createRow((short)(sheet.getLastRowNum()+1));
        int [] colNum = new int[19];
        HSSFCell [] cell = new HSSFCell[19];
        for(int i=0; i<19; i++){
            colNum[i] = i;
            cell[i] = row.createCell(colNum[i]);
            cell[i].setCellType(HSSFCell.CELL_TYPE_STRING);
        }
        cell[0].setCellValue(LocalCache.getJubaoId());
        cell[1].setCellValue(record.getUser_name());
        cell[2].setCellValue(record.getUser_idcard());
        cell[3].setCellValue(record.getUser_phone());
        cell[4].setCellValue(record.getUser_zz());
        cell[5].setCellValue(record.getUser_dizhi());
        cell[6].setCellValue(record.getUser_jb());
        cell[7].setCellValue(record.getReport_name());
        cell[8].setCellValue(record.getReport_dw());
        cell[9].setCellValue(record.getReport_zw());
        cell[10].setCellValue(record.getReport_jb());
        cell[11].setCellValue(record.getTitle());
        cell[12].setCellValue(record.getQuestion1());
        cell[13].setCellValue(record.getQuestion2());
        cell[14].setCellValue(record.getFiles());
        cell[15].setCellValue(record.getDatetime());
        cell[16].setCellValue(record.getStatus());
        cell[17].setCellValue(record.getContent());
        cell[18].setCellValue(record.getFilename());
        
        FileOutputStream out=new FileOutputStream(path);
        workbook.write(out);
        out.flush();
        out.close();
        workbook.close();
        
    }
}
