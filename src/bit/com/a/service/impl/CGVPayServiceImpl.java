package bit.com.a.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.CGVPayDao;
import bit.com.a.model.CGVPayDto;
import bit.com.a.model.CGVReserveDto;
import bit.com.a.service.CGVPayService;
import bit.com.a.service.CGVReserveService;

@Service
public class CGVPayServiceImpl implements CGVPayService {

	@Autowired
	CGVPayDao cgvPayDao;
	

	@Override
	public boolean payTicket(CGVPayDto dto) {
		// TODO Auto-generated method stub
		return cgvPayDao.payTicket(dto);
	}
	
	

}
