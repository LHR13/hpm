package com.lhr13.hpm.service;

import com.lhr13.hpm.POJO.Person;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class exportPer2Exc {

    public ResponseEntity<byte[]> exportPer2Exc(List<Person> people) {
        HttpHeaders headers = null;
        ByteArrayOutputStream baos = null;
        try {
            //创建文档
            HSSFWorkbook workbook = new HSSFWorkbook();
            //创建文档摘要
            workbook.createInformationProperties();
            //获取文档信息并配置
            DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();
            //文档类别
            dsi.setCategory("员工信息");
            dsi.setManager("admin");

            SummaryInformation si = workbook.getSummaryInformation();
            si.setSubject("员工信息表");
            si.setTitle("员工信息");
            si.setAuthor("admin");

            HSSFSheet sheet = workbook.createSheet("hpm人员信息表");

            HSSFCellStyle dateStyle = workbook.createCellStyle();
            dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("y/m/d"));

            HSSFCellStyle headStyle = workbook.createCellStyle();
            headStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
            headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            sheet.setColumnWidth(0, 5 * 256);

        }
    }

}
