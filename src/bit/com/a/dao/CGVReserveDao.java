package bit.com.a.dao;

import java.util.List;

import bit.com.a.model.CGVReserveDto;

public interface CGVReserveDao {
	
	public boolean CGVReserve(CGVReserveDto dto);
	public List<CGVReserveDto> getCGVReserveList(CGVReserveDto dto);
	
	public List<CGVReserveDto> getPayJoinTable(CGVReserveDto dto);
}
