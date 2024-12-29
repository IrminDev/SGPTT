package com.sgpttt.UtilsService.util;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


public class MultipartFileConverter {
    public static MultipartFile convert(byte[] bytes, String fileName){
        return new MockMultipartFile(fileName, bytes);
    }
}
