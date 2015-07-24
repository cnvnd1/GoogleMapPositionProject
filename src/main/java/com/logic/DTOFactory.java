package com.logic;


import com.test.dao.dto.BeaconWithUserIdDTO;
import com.test.entity.use.DTO;

public interface DTOFactory {
	public DTO makeDTO(String type,BeaconWithUserIdDTO dto) throws InvalidDTOType;
}
