package com.emfldlem.Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class commonUtil {

    public static int readFileId(File file) {

        StringBuilder strText = new StringBuilder();
        int nBuffer;
        try {
            BufferedReader buffRead = new BufferedReader(new FileReader(file));
            while ((nBuffer = buffRead.read()) != -1) {
                strText.append((char) nBuffer);
            }
            buffRead.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("====================" + strText);
        return Integer.parseInt(strText.toString());
    }
}
