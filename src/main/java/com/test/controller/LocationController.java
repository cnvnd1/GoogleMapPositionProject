package com.test.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.logic.MainLogic;
import com.test.dao.dto.BeaconWithUserIdDTO;
import com.test.entity.result.ResultDATA;
import com.test.entity.use.IndividualLocationDTO;
import com.test.entity.user.UserDTO;
import com.test.service.Service;

@Controller
public class LocationController {
	
	Service service;

	public void setService(Service service) {
		
		this.service = service;
		
	}
	public ModelAndView makeResultData(ModelAndView mav){
		
		//MainLogic mainLogic= new 
		//ResultDATA resultData = 
		
		return mav;
	
	}
	@RequestMapping("login")
	public ModelAndView login(UserDTO dto,ModelAndView mav){
		String checkId= "cnvnd@naver.com";
		String checkPasswd ="1234";
		System.out.println("login 실행");
		System.out.println(dto.getUserId()+"\t"+dto.getPasswd());
		if(checkId.equals(dto.getUserId()) && checkPasswd.equals(dto.getPasswd())){
			mav.setViewName("index");
			mav.addObject("user", dto);
			System.out.println("go index");
			return mav;
		}
		System.out.println("redirect 실행");
		mav.setViewName("redirect:loginForm");
		return mav;
	}
	@RequestMapping("/GoogleMap")
	public String GoogleMapOpen(){
		return "GoogleMap";
	}
	
	@RequestMapping("/admingooglemap")
	public String AdminGoogleMapOpen(){
		return "AdminUseGoogleMap";
	}
	
	
	@RequestMapping("/location")
	public @ResponseBody List<IndividualLocationDTO> getLocation(String userId, String mdate, String mHour){
		System.out.println("getLocation() 실행...");
		List<IndividualLocationDTO> list = service.getposition(userId, mdate, mHour);
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("/totallocation")
	public @ResponseBody List<BeaconWithUserIdDTO> getTotalLocation(String mdate, String mHour){
		System.out.println("getTotalLocation() 실행...");
		
		List<BeaconWithUserIdDTO> list = service.getTotalPosition(mdate, mHour);
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("/getcount")
	public @ResponseBody int getCount(String lat, String lng, String mHour, String inputDate){
		System.out.println("getCount() 실행...");
		int n = service.getCount(lat, lng, mHour, inputDate);
		return n;
	}
	
	@RequestMapping("/individualPath")
	public @ResponseBody List<IndividualLocationDTO> getIndividualPath(String userId, String mDate, String mHour){
		List<IndividualLocationDTO> list = service.getIndividualPath(userId, mDate, mHour);
		return list;
	}
	
	
	
}
