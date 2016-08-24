package sec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

//import com.yindejin.vo.Resource;
//import com.yindejin.vo.Role;
//import com.yindejin.vo.User;

import Service.UserSecService;
import pojo.UserSec;

//1 加载资源与权限的对应关系
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	
	private UserSecService systemService;

	//由spring调用
	public MySecurityMetadataSource(UserSecService systemService) {
		this.systemService = systemService;
		
	}

	public UserSecService getSystemService() {
		return systemService;
	}

	public void setSystemService(UserSecService systemService) {
		this.systemService = systemService;
	}

	private static LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> resourceMap = null;
	


	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}
//	//加载所有资源与权限的关系
//	private Map<String, String> getResource() {
//		Map<String, String> resourceMap = new HashMap<String, String>();
//		List<UserSec> users = systemService.getAllUser();
//		for(UserSec user:users){	
//			for(Role role : user.getUserRoles()) {
//				Set<Resource> resources = role.getRoleResources();
//				for(Resource resource : resources) {
//						String url = resource.getValue();
//						if(!resourceMap.containsKey(url)) {
//							resourceMap.put(url, role.getName());
//						}else{
//							String roleName = resourceMap.get(url);
//							resourceMap.put(url, roleName+","+role.getName());
//						}
//				}
//			}
//		}
//		return resourceMap;
//	}
//	
//	private void loadResourceDefine(){
//		resourceMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
//		Map<String, String> resource = getResource();
//		for(Map.Entry<String, String> entry:resource.entrySet()){
//			Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
//			configAttributes.add(new SecurityConfig(entry.getValue()));
//			resourceMap.put(new AntPathRequestMatcher(entry.getKey()), configAttributes);
//		}
//	}
//	
//	
	//返回所请求资源所需要的权限
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		
		HttpServletRequest request = ((FilterInvocation) object).getRequest();
		if(null==resourceMap){
			System.out.println("请求地址 " + ((FilterInvocation) object).getRequestUrl());
//			loadResourceDefine();
			System.out.println("我需要的认证："+resourceMap.toString());
		}
		for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : resourceMap.entrySet()) {
            if (entry.getKey().matches(request)) {
                return entry.getValue();
            }
        }
		return null;
	}
}