package com.dessert.ringring.util;

import com.dessert.ringring.domain.DTOGoods;
import com.dessert.ringring.mapper.GoodsMapper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class FileUtils {
//    //오늘 날짜
//    private final String today= LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
//
//    //업로드 경로
//    private final String uploadPath = Paths.get("C:","ringring","upload", today).toString();
//
//    //파일명을 랜덤문자열로 반환
//    private final String getRandomString(){
//        return UUID.randomUUID().toString().replaceAll("-","");
//    }
//
//    public List<DTOGoods> uploadFiles(MultipartFile[] files, Long boardIdx){
//        //파일이 비어있으면 비어있는 리스트 반환
//        if(files[0].getSize()<1){
//            return Collections.emptyList();
//        }
//
//        //업로드 파일 정보를 담을 비어있는 리스트
//        List<DTOGoods> dtoGoods = new ArrayList<>();
//
//        //업로드경로에 해당하는 디렉터리가 존재하지 않으면 디렉토리 생성함
//        File dir=new File(uploadPath);
//        if(dir.exists()==false){
//            dir.mkdirs();
//        }
//        //파일 갯수만큼 forEach 실행
//        for(MultipartFile file : files){
//            try{
//                //파일 확장자
//                final String extension = FilenameUtils.getExtension(file.getOriginalFilename());
//                //서버에 저장할 파일명(랜덤 문자열  +확장자)
//                final String saveName = getRandomString() + "."+extension;
//                //업로드 경로에 saveName과 동일한 이름가진 파일 생성
//                File target=new File(uploadPath, saveName);
//                file.transferTo(target);
//                //파일 정보 저장
//                String img=uploadPath+saveName;
//                DTOGoods goods = new DTOGoods();
//                goods.setImg(img);
//                dtoGoods.add(goods);
//            }catch (IOException e){
//                throw new AttachFileException("["+file.getOriginalFiLename()+"] failed to save file...");
//            }catch (Exception e){
//                throw new AttachFileException("["+file.getOriginalFilename()+"] failed to save file...");
//            }
//        } //for문 끝
//        return dtoGoods;
//    }

}
