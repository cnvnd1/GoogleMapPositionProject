package com.test.dao;

import java.util.List;

import com.test.dao.dto.BeaconWithUserIdDTO;
import com.test.entity.use.IndividualLocationDTO;

public interface DAO {

	public abstract List<IndividualLocationDTO> getposition(String userId, String mdate, String mHour);
	public abstract List<BeaconWithUserIdDTO> getTotalPosition(String mdate, String mHour);
	public abstract List<BeaconWithUserIdDTO> getLocationAtHour(String mHour);
	public abstract int getCount(String lat, String lng, String mHour, String inputDate);
	public abstract List<IndividualLocationDTO> getIndividualPath(String userId, String mDate, String mHour);
}