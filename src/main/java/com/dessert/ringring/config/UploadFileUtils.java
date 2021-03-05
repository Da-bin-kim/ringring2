package com.dessert.ringring.config;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

public class UploadFileUtils {
    static final int THUMB_WIDTH=300;
    static final int THUMB_HEIGH=300;

    public static String fileUpload(String uploadPath, String fileName,byte[] fileData, String ymdPath) throws IOException {
        System.out.println("업로드 경로 : "+uploadPath);
        System.out.println("파일이름"+fileName);
        System.out.println("파일 크기"+fileData);
        System.out.println("ymd경로"+ymdPath);
        UUID uid = UUID.randomUUID();

        //랜덤문자열+오리지널파일이름
        String newFileName=uid+"_"+fileName;
        //구분하기 쉽게+중복방지위해 년월일폴더경로지정
        String imgPath=uploadPath+ymdPath;

        //썸네일용 이미지 생성성
        File target=new File(imgPath,newFileName);
        FileCopyUtils.copy(fileData, target);
        FileCopyUtils.copy(fileData,target);

        String thumbFileName="s_"+newFileName;
        File image=new File(imgPath+File.separator+newFileName);
        File thumbnail=new File(imgPath+File.separator+"s"+File.separator+thumbFileName);
        if(image.exists()){
            thumbnail.getParentFile().mkdirs();
            Thumbnails.of(image).size(THUMB_WIDTH,THUMB_HEIGH).toFile(thumbnail);
        }

        return newFileName;
    }
    //폴더이름, 폴더 생성하기(ymd)

    public static String calcPath(String uploadPath){
        Calendar cal=Calendar.getInstance();
        String yearPath=File.separator+cal.get(Calendar.YEAR);
        String monthPath=yearPath+File.separator+new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
        String datePath=monthPath+File.separator+new DecimalFormat("00").format(cal.get(Calendar.DATE));

        makeDir(uploadPath,yearPath,monthPath,datePath);
        makeDir(uploadPath,yearPath,monthPath,datePath+"\\s");

        return datePath;
    }
    //폴더생성
    private static void makeDir(String uploadPath,String... paths){
        if(new File(paths[paths.length-1]).exists()){
            return;
        }
        for(String path : paths){
            File dirPath = new File(uploadPath+path);
            if(!dirPath.exists()){
                dirPath.mkdir();
            }
        }

    }

}
