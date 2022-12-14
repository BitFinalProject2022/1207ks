package com.showmual.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.showmual.model.ManStyleVo;
import com.showmual.model.WomanStyleVo;
import com.showmual.service.StyleService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/closet")
public class StyleController {
    
    @Autowired
    StyleService styleService;
    
    @Autowired
    ManStyleVo manStyleVo;
    
    @Autowired
    WomanStyleVo womanStyleVo;
    
    List<ManStyleVo> manCoordiList = new ArrayList<ManStyleVo>();
    
    List<WomanStyleVo> womanStyleList = new ArrayList<WomanStyleVo>();
    
    
    // 코디 페이지
//    @RequestMapping(value = "/coordinate", method = RequestMethod.GET)
//    public String coordinatePage(Model model) {
//
//        return "coordinate";
//    }
    
    
    
    // 남자스타일 페이지
    @RequestMapping(value = "/manCoordi", method = RequestMethod.GET)
    public String manCoordi(Model model) {
    
        return "manCoordi";
    }
    
    
    // 코디 검색 하기
    @RequestMapping(value="/searchCoordi", method=RequestMethod.POST)
    @ResponseBody
    public List<ManStyleVo> selectImagePath(
            @RequestParam(value = "temperature", required = false) String temperature,
            @RequestParam(value = "color", required = false) String colorCode,
            @RequestParam(value = "style", required = false) String styleCode,
            @RequestParam(value = "hashtag", required = false) String hashtagCode) {
        
        System.out.println(temperature);
        System.out.println(colorCode);
        System.out.println(styleCode);
        System.out.println(hashtagCode);
        
        manCoordiList = styleService.listManStyles(temperature, colorCode, styleCode, hashtagCode);
        
        System.out.println("서비스 잘지났으면 이 글이 보여야함");
        
        return manCoordiList;
    }
    
    
    // 여자스타일 페이지
    @RequestMapping(value = "/womanCoordi", method = RequestMethod.GET)
    public String getWomanStyleList(Model model) {
        
        return "womanCoordi";
    }
    
}
