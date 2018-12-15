/**
 *
 */
package com.zzh.shiro.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.zzh.shiro.dao.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chench9@lenovo.com
 * @desc UsersService
 * @date 2017年3月16日
 */
@Service
public class UsersService {
	@Autowired
	private UsersDAO usersDAO;
//	@Autowired
//	private MemoryConstrainedCacheManager shiroCacheManager;

	/**
	 * 获取用户权限
	 *
	 * @param username
	 * @return
	 */
	public List<String> getUserPermissions(String username) {
		return usersDAO.getUserPermissions(username);
	}

	public Set<String> getUserPermissionSet(String username) {
		List<String> permissionList = usersDAO.getUserPermissions(username);
		Set<String> permissionSet = new HashSet<String>();
		permissionSet.addAll(permissionList);
		return permissionSet;
	}

	public Integer addRole(String userName, String roleName) {
		return usersDAO.addRole(userName, roleName);
	}

	public Integer delRole(String userName, String roleName) {
		return usersDAO.delRole(userName, roleName);
	}


//	public void clearShiroCatch() {
		//获取权限看一下
//		Cache<Object, Object> cache = shiroCacheManager.getCache("org.apache.shiro.realm.jdbc.JdbcRealm.authorizationCache");
//        shiroCacheManager.destroy();//清除全部缓存
//        LifecycleUtils.destroy(cache);//清除某个缓存
//		Subject subject = SecurityUtils.getSubject();
//		Session session = subject.getSession();
//		System.out.println("session time out"+session.getTimeout());
//		System.out.println(subject.getPrincipal());
//		System.out.println(subject.getPrincipals());
		/*subject.getPrincipal()------>登录名
        String realmName = subject.getPrincipals().getRealmNames().iterator().next();
        //第一个参数为用户名,想要操作权限的用户，第二个参数为realmName,
        SimplePrincipalCollection principals = new SimplePrincipalCollection(subject.getPrincipal(),realmName);
        */
//		RealmSecurityManager securityManager =
//				(RealmSecurityManager) SecurityUtils.getSecurityManager();
//		JdbcRealm jdbcRealm = (JdbcRealm) securityManager.getRealms().iterator().next();
//		//删除登陆人
//		jdbcRealm.getAuthorizationCache().remove(subject.getPrincipal());
//		//删除登陆人对应的缓存
//		jdbcRealm.getAuthorizationCache().remove(subject.getPrincipals());
//		//重新加载subject
//		subject.releaseRunAs();
//	}

}
