package bit.com.a.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.CGVReserveDao;
import bit.com.a.model.CGVReserveDto;

@Repository
public class CGVReserveDaoImpl implements CGVReserveDao {

	@Autowired
	SqlSession session;

	@Override
	public boolean CGVReserve(CGVReserveDto dto) {
		int count = session.insert("CGVReserve", dto);

		return count > 0 ? true : false;
	}

	@Override
	public List<CGVReserveDto> getCGVReserveList(CGVReserveDto dto) {
		// TODO Auto-generated method stub
		List<CGVReserveDto> list = new ArrayList<CGVReserveDto>();
		list = session.selectList("getCGVReserveList", dto);
		return list;
	}

	@Override
	public List<CGVReserveDto> getPayJoinTable(CGVReserveDto dto) {
		List<CGVReserveDto> list = new ArrayList<CGVReserveDto>();
		list = session.selectList("selectMapping", dto);
		return list;
	}
	
	

}
