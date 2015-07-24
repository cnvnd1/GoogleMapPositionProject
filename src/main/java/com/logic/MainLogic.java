package com.logic;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.test.dao.dto.BeaconWithUserIdDTO;
import com.test.entity.result.ResultDATA;


public class MainLogic {
	
	private static final String USERID_DATATYPE = "userId";
	private static final String MTIME_DATATYPE = "mTime";
	private static final String BEACONID_DATATYPE = "beaconId";
	
	//DB에서 읽어 온 값들 저장 
	List<BeaconWithUserIdDTO> inputList;
	//반활할 결과 DTO
	ResultDATA resultDATA;
	//타입별 DTO을 만들어 주는 클래스 
	DTOFactoryImp dtoFactory;
	
	
	public List<BeaconWithUserIdDTO> getInputList() {
		return inputList;
	}
	
	public void setInputList(List<BeaconWithUserIdDTO> inputList) {
		this.inputList = inputList;
	}
	
	public ResultDATA makeResultDTO() throws InvalidDTOType{	
		for (BeaconWithUserIdDTO dto : inputList) {
			//해당 아이디의 사용자의 hashmap이 있는 경우 
			//이경우 해당사용자의 리스트에 addlist(dto)를 해준다 
			if(resultDATA.getUserResultData().containsKey(dto.getUserId())){
				resultDATA.existSetUserIdPerBeaconInfo(dto.getUserId(), dtoFactory.makeDTO(USERID_DATATYPE, dto));
			}else{ //없는 경우 
				resultDATA.firstSetUserResultData(dto.getUserId(), dtoFactory.makeDTO(USERID_DATATYPE, dto));
			}
			
			//해당 비콘의 hashmap이 있는경우 
			//이경우 해당 비콘의 리스트에 addlist(dto)를 해준다.
			if(resultDATA.getBeaconResultData().containsKey(dto.getBeaconId())){
				resultDATA.existSetBeaconIdPerUserInfo(dto.getBeaconId(), dtoFactory.makeDTO(BEACONID_DATATYPE, dto));		
			}else{ //없는 경우 
				resultDATA.fistSetBeaconResultData(dto.getBeaconId(), dtoFactory.makeDTO(BEACONID_DATATYPE, dto));
			}
			
			//해당 비콘의 hashmap이 있는경우 
			//이경우 해당 비콘의 리스트에 addlist(dto)를 해준다.
			if(resultDATA.getmTimeResultData().containsKey(dto.getmTime())){
				resultDATA.existSetMtimePerBeaconUserInfo(dto.getmTime(), dtoFactory.makeDTO(MTIME_DATATYPE, dto));		
			}else{ //없는 경우 
				resultDATA.fistSetMtimeResultData(dto.getmTime(), dtoFactory.makeDTO(MTIME_DATATYPE, dto));
			}
			
			//날짜별 사용자의 아이디를 set에 저장 
			Date date = Calendar.getInstance().getTime();
			String check = new SimpleDateFormat("yyyymmdd",Locale.KOREA).format(date);
			
			if(check.equals(dto.getmTime().substring(0,7))){
				resultDATA.AddTodayUser(dto.getUserId());
			}else{
				resultDATA.AddYesterdayUser(dto.getUserId());
			}	
		}
		
		return resultDATA;
	}
	public void onlyAdminMakeResult(){
			
	}
	
	public void memberMakeResult(){
		
	}
	
	public void userMakeResult(){
		
	}	
	
		
		
	

	
}
