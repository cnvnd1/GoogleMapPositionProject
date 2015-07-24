package com.logic;




import com.test.dao.dto.BeaconWithUserIdDTO;
import com.test.entity.use.BeaconUserInfoDTO;
import com.test.entity.use.DTO;
import com.test.entity.use.TimePerLocationDTO;
import com.test.entity.use.TimePerUserIdDTO;

public class DTOFactoryImp implements DTOFactory{

	@Override
	public DTO makeDTO(String type,BeaconWithUserIdDTO dto) throws InvalidDTOType {
		switch(type){
		case  "userId" :
			return new TimePerLocationDTO(dto.getLat(),dto.getLng(),dto.getmTime());
		case  "beaconId" :
			return new TimePerUserIdDTO(dto.getmTime(),dto.getUserId());	
		case "mTime" : 
			return new BeaconUserInfoDTO(dto.getUserId(),dto.getLat(),dto.getLng());
		default :
			throw new InvalidDTOType("wrong");
		}
	}
	
}
