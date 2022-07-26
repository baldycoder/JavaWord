package com.example.javaword.util;

import cn.hutool.core.lang.Assert;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author ：a123145
 * @date ：Created in 2022/7/26 16:21
 * @description：word操作工具类
 * @modified By：`
 * @version: 1.0
 */

public class WordUtil {

    public static boolean addNameToTemplate(String templatePath, HashMap<String,String> map,String temDir,String fileName) throws Exception{
        Assert.notNull(templatePath, "模板路径不能为空");
        Assert.notNull(temDir, "临时文件路径不能为空");
        Assert.notNull(fileName, "导出文件名不能为空");
        Assert.isTrue(fileName.endsWith(".docx"), "word导出请使用docx格式");
        if (!temDir.endsWith("/")) {
            temDir = temDir + File.separator;
        }
        File dir = new File(temDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }


        XWPFDocument doc = new XWPFDocument(OPCPackage.open(templatePath));
        for (XWPFParagraph p : doc.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null) {
                        for(String key : map.keySet()){
                            if( text.contains(key)){
                                text = text.replace(key, map.get(key));
                                r.setText(text, 0);
                            }
                        }
                    }
                }
            }
        }
//        for (XWPFTable tbl : doc.getTables()) {
//            for (XWPFTableRow row : tbl.getRows()) {
//                for (XWPFTableCell cell : row.getTableCells()) {
//                    for (XWPFParagraph p : cell.getParagraphs()) {
//                        for (XWPFRun r : p.getRuns()) {
//                            String text = r.getText(0);
//                            if (text != null && text.contains("needle")) {
//                                text = text.replace("needle", "haystack");
//                                r.setText(text,0);
//                            }
//                        }
//                    }
//                }
//            }
//        }
        doc.write(new FileOutputStream(temDir+fileName));
        doc.close();

        return true;
    }
}
