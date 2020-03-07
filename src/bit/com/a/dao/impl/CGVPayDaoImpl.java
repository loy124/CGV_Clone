package bit.com.a.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.CGVPayDao;
import bit.com.a.model.CGVPayDto;

@Repository
public class CGVPayDaoImpl implements CGVPayDao{

	@Autowired
	SqlSession session;
	
	@Override
	public boolean payTicket(CGVPayDto dto) {
		int count = session.insert("CGVPay", dto);
		
		return count > 0 ? true : false;
	}
	
}
