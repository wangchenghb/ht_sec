package mapper;

import java.util.List;

import pojo.Module;
import pojo.UserSec;


public interface UserSecMapper {
	/*
	 * 根据用户名获取SysAuthorities这里是权限集合
	 */
	List<Module> getModuleByUsername(String username);
	
	/*
	 * 根据用户名查询用户
	 */
	UserSec getByUsername(String username);
}
