package com.lhr13.hpm.controller;

import com.lhr13.hpm.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("/export")
public class ExportController {
    @Autowired
    private ExportService exportService;

    @GetMapping("/person")
    public ResponseEntity<byte[]> export2Excel() {
        return exportService.export2Excel();
    }
}
