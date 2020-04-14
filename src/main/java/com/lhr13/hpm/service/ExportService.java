package com.lhr13.hpm.service;

import com.lhr13.hpm.POJO.Person;
import com.lhr13.hpm.dao.PersonDAO;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ExportService {

    @Autowired
    PersonDAO personDAO;

    public ResponseEntity<byte[]> export2Excel() {
        List<Person> person = personDAO.findAll();
        return exportPer2Exc(person);
    }

    private static ResponseEntity<byte[]> exportPer2Exc(List<Person> people) {
        HttpHeaders headers = new HttpHeaders();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HSSFWorkbook workbook = new HSSFWorkbook();

        try {
            //创建文档
            //创建文档摘要
            workbook.createInformationProperties();
            //获取文档信息并配置
            DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();
            //文档类别
            dsi.setCategory("员工信息");
            dsi.setManager("admin");
            dsi.setCompany("xxx hospital");


            SummaryInformation si = workbook.getSummaryInformation();
            si.setSubject("员工信息表");
            si.setTitle("员工信息");
            si.setAuthor("admin");

            HSSFSheet sheet = workbook.createSheet("hpm人员信息表");

            HSSFCellStyle dateStyle = workbook.createCellStyle();
            dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("yy/m/d"));

            HSSFCellStyle headStyle = workbook.createCellStyle();
            headStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
            headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            for (int i = 0; i < 16; i++) {
                sheet.setColumnWidth(i, 20 * 256);
            }


            HSSFRow headerRow = sheet.createRow(0);
            HSSFCell cell0 = getCell(headerRow,"编号", headStyle, 0);
            HSSFCell cell1 = getCell(headerRow,"姓名", headStyle, 1);
            HSSFCell cell2 = getCell(headerRow,"性别", headStyle, 2);
            HSSFCell cell3 = getCell(headerRow,"部门", headStyle, 3);
            HSSFCell cell4 = getCell(headerRow,"籍贯", headStyle, 4);
            HSSFCell cell5 = getCell(headerRow,"政治面貌", headStyle, 5);
            HSSFCell cell6 = getCell(headerRow,"参加工作时间", headStyle, 6);
            HSSFCell cell7 = getCell(headerRow,"是否为执业医师", headStyle, 7);
            HSSFCell cell8 = getCell(headerRow,"执业医师证书日期", headStyle, 8);
            HSSFCell cell9 = getCell(headerRow,"是否为助理医师", headStyle, 9);
            HSSFCell cell10 = getCell(headerRow,"助理医师证书日期", headStyle, 10);
            HSSFCell cell11 = getCell(headerRow,"资格证书编号", headStyle, 11);
            HSSFCell cell12 = getCell(headerRow,"执业范围", headStyle, 12);
            HSSFCell cell13 = getCell(headerRow,"身份证号码", headStyle, 13);
            HSSFCell cell14 = getCell(headerRow,"电话", headStyle, 14);
            HSSFCell cell15 = getCell(headerRow,"邮箱", headStyle, 15);


            for (int i = 0; i < people.size(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                Person person = people.get(i);
                row.createCell(0).setCellValue(person.getId());
                row.createCell(1).setCellValue(person.getName());
                row.createCell(2).setCellValue(person.getSex());
                row.createCell(3).setCellValue(person.getDep());
                row.createCell(4).setCellValue(person.getRoot());
                row.createCell(5).setCellValue(person.getPolitical());
                HSSFCell dateCell = row.createCell(6);
                        Date date = person.getJobdate();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        dateCell.setCellValue(sdf.format(date));
                row.createCell(7).setCellValue(person.getIsProDoc() == 0 ? "否" : "是");
                HSSFCell dateCell1 = row.createCell(8);
                        Date date1 = person.getPDdate();
                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                        dateCell1.setCellValue(sdf1.format(date1));
                row.createCell(9).setCellValue(person.getIsmediastinus() == 0 ? "否" : "是");
                HSSFCell dateCell2 = row.createCell(10);
                        Date date2 = person.getMDSdate();
                        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                        dateCell2.setCellValue(sdf2.format(date2));
                row.createCell(11).setCellValue(person.getCtfID());
                row.createCell(12).setCellValue(person.getReference());
                row.createCell(13).setCellValue(person.getIDNum());
                row.createCell(14).setCellValue(person.getPhone());
                row.createCell(15).setCellValue(person.getMail());
            }

            headers.setContentDispositionFormData("attachment",
                    new String("员工表.xls".getBytes("UTF-8"), "iso-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<byte[]>(baos.toByteArray(), headers,
        HttpStatus.CREATED);
    }

    private static HSSFCell getCell(HSSFRow headerRow, String name, HSSFCellStyle headStyle, int column) {
        HSSFCell cell = headerRow.createCell(column);
        cell.setCellValue(name);
        cell.setCellStyle(headStyle);
        return cell;
    }
}
