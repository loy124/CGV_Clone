package bit.com.a.service;

import bit.com.a.model.CGVMemberDto;

public interface CGVMemberService {
	public boolean registerMember(CGVMemberDto dto);
	public boolean getId(String id);
	public CGVMemberDto login(CGVMemberDto dto);
}
