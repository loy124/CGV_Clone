package bit.com.a.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.CGVReserveDao;
import bit.com.a.model.CGVReserveDto;

import bit.com.a.service.CGVReserveService;

@Service
public class CGVReserveServiceImpl implements CGVReserveService {

	@Autowired
	CGVReserveDao cgvReserveDao;
	
	@Override
	public boolean CGVReserve(CGVReserveDto dto) {
		
		return cgvReserveDao.CGVReserve(dto);
	}

	@Override
	public List<CGVReserveDto> getCGVReserve(CGVReserveDto dto) {
		System.out.println("ㅋㅋㅋ");
		List<CGVReserveDto> list = new ArrayList<CGVReserveDto>();
		list = cgvReserveDao.getCGVReserveList(dto);
	
		return list;
	}

	@Override
	public List<CGVReserveDto> getPayJoinTable(CGVReserveDto dto) {
		
		return cgvReserveDao.getPayJoinTable(dto);
	}
}
