package com.test.entity.result;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.test.entity.use.DTO;

public class ResultDATA {
	
	//현재 이용객 
	Set<String> todayUser;
	//어제 이용객
	Set<String> yestdayUser;
	
	//사용자별 입력 데이터 
	HashMap<String, ResultDTO > userResultData;  
	//비콘별 입력 데이터 
	HashMap<String, ResultDTO > beaconResultData ;  
	//날짜별 입력 데이터 
	HashMap<String, ResultDTO > mTimeResultData ;  
	
	public ResultDATA() {
		super();
		this.todayUser = new HashSet<String>();
		this.yestdayUser = new HashSet<String>();
		this.userResultData = new HashMap<String, ResultDTO>();
		this.beaconResultData = new HashMap<String, ResultDTO>();
		this.mTimeResultData = new HashMap<String, ResultDTO>();
	}
	
	public void AddTodayUser(String userID){
		todayUser.add(userID);
	}
	public void AddYesterdayUser(String userID){
		yestdayUser.add(userID);
	}
	public Integer getTodayUser(){
		return todayUser.size();
	}
	public Integer getYestdayUser(){
		return yestdayUser.size();
	}
	//입력값이 없는 경우 
	public void  existSetUserIdPerBeaconInfo(String userId,DTO dto){
		ResultDTO info = new UserIdPerBeaconInfo(userId);
		info.addList(dto);
	}
	//입력값이 없는 경우 
	public void existSetBeaconIdPerUserInfo(String beaconId,DTO dto){
		ResultDTO info = new BeaconIdPerUserInfo(beaconId);
		info.addList(dto);
	}
	//입력값이 없는 경우 
	public void existSetMtimePerBeaconUserInfo(String mTime,DTO dto){
			ResultDTO info = new MTimePerBeaconUserInfo(mTime);
			info.addList(dto);
	}
	//입력값이 있는경우 
	public void firstSetUserResultData(String userId, DTO dto){
		userResultData.get(userId).addList(dto);
	}
	//입력값이 있는경우 
	public void fistSetBeaconResultData(String beaconId, DTO dto){
		beaconResultData.get(beaconId).addList(dto);
	}
	//입력값이 있는경우 
	public void fistSetMtimeResultData(String mTime, DTO dto){
		mTimeResultData.get(mTime).addList(dto);
	}
	public HashMap<String, ResultDTO> getUserResultData() {
		return userResultData;
	}	
	public HashMap<String, ResultDTO> getBeaconResultData() {
		return beaconResultData;
	}

	public HashMap<String, ResultDTO> getmTimeResultData() {
		return mTimeResultData;
	}
	
	
}
