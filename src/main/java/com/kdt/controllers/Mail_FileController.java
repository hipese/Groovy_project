package com.kdt.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.Mail_FileDTO;
import com.kdt.services.Mail_FileService;

@RestController
@RequestMapping("/api/mailFile")
public class Mail_FileController {
    @Autowired
    Mail_FileService fservice;

    @GetMapping("/{seq}")
    public ResponseEntity<List<Mail_FileDTO>> selectBySeq(@PathVariable Integer seq) {
        List<Mail_FileDTO> files = fservice.selectBySeq(seq);
        return ResponseEntity.ok(files);
    }

    @GetMapping("/download/{sys_name}")
    public ResponseEntity<Resource> download(@PathVariable String sys_name) {
        // 파일 경로를 설정합니다. 이 경로는 서버에서 파일을 찾을 경로여야 합니다.
    	System.out.println(sys_name);
        String filePath = "/home/ubuntu/uploads" + sys_name;

        // 파일을 읽어와서 바이트 배열로 변환합니다.
        byte[] fileContent;
        try (InputStream inputStream = new FileInputStream(new File(filePath))) {
            fileContent = inputStream.readAllBytes();
        } catch (IOException e) {
            // 파일을 찾을 수 없거나 읽을 수 없는 경우 에러 처리를 수행해야 합니다.
            return ResponseEntity.notFound().build();
        }

        ByteArrayResource resource = new ByteArrayResource(fileContent);

        return ResponseEntity.ok()
                .contentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(fileContent.length)
                .body(resource);
            
    }
}
