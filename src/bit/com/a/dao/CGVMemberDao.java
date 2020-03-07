package bit.com.a.dao;

import bit.com.a.model.CGVMemberDto;

public interface CGVMemberDao {
	public boolean registerMember(CGVMemberDto dto);
	public String getId(String id);
	public CGVMemberDto login(CGVMemberDto dto);
}
