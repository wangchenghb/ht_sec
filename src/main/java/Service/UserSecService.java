package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mapper.UserSecMapper;
import pojo.UserSec;

@Service
public class UserSecService implements UserDetailsService {
	@Autowired
	private UserSecMapper userSecMapper;

	// org.springframework.security.core.userdetails.cache.NullUserCache

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		UserSec user = userSecMapper.getByUsername(username);
		return user;
	}
}
