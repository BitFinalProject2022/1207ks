package com.showmual.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.showmual.dao.StyleDao;
import com.showmual.model.ManStyleVo;
import com.showmual.model.WomanStyleVo;

@Service("styleService")
@Transactional
public class StyleService {
    
    @Autowired
    StyleDao styleDao;
    
    public List<ManStyleVo> listManStyles(
            String temperature, String colorCode,
            String styleCode, String hashtagCode) {
        
        String[] temperatureList = null;
        String[] colorCodeList = null;
        String[] styleCodeList = null;
        String[] hashtagCodeList = null;
        
        // 배열로 바꾸기
        if(temperature != null) {
            temperatureList = temperature.split(",");
        }
        if(colorCode != null) {
            colorCodeList = colorCode.split(",");
        }
        if(styleCode != null) {
            styleCodeList = styleCode.split(",");
        }
        if(hashtagCode != null) {
            hashtagCodeList = hashtagCode.split(",");
        }
        
        System.out.println(Arrays.toString(temperatureList));
        System.out.println(Arrays.toString(colorCodeList));
        System.out.println(Arrays.toString(styleCodeList));
        System.out.println(Arrays.toString(hashtagCodeList));
        
        List<ManStyleVo> manStyleList = 
                styleDao.selectManCoordinate(temperatureList, colorCodeList, styleCodeList, hashtagCodeList);
        
        return manStyleList;
    }
    
    public List<WomanStyleVo> listWomanStyles() {
        List<WomanStyleVo> womanStyleList = styleDao.selectWomenCoordinate();
        return womanStyleList;
    }
    
}
