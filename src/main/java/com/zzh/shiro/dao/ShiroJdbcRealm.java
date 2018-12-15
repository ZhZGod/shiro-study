/**
 * 
 */
package com.zzh.shiro.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import com.zzh.shiro.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义shiro jdbc realm，实现shiro缓存控制
 * @desc ShiroJdbcRealm
 * @author chench9@lenovo.com
 * @date 2017年12月13日
 */
public class ShiroJdbcRealm extends JdbcRealm {
	@Autowired
	private UsersDAO usersDAO;
	private static final Logger logger = LoggerFactory.getLogger(ShiroJdbcRealm.class);
	
	/**
	 * 角色缓存
	 */
	private static final Set<String> CACHE_ROLES = new HashSet<String>();
	
	/**
	 * 权限缓存
	 */
	private static final Set<String> CACHE_PERMISSIONS = new HashSet<String>();

	/**
	 * 获取用户角色 根据用户名
	 * @param conn
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	@Override
	protected Set<String> getRoleNamesForUser(Connection conn, String username) throws SQLException {
		logger.info("roles cache size: {}, refresh: {}, zk connected: {}", new Object[] {CACHE_ROLES.size(), Constants.isRefresh(), Constants.isConnected()});
		
		if(CACHE_ROLES.isEmpty() || !Constants.isConnected() || Constants.isRefresh()) {
			logger.info("refresh role names cache");
			CACHE_ROLES.clear();
			/**
			 * 这里使用的默认的更具用户名查找 角色的名称
			 * select role_name from user_roles where username = ?
			 * 如果自己有
			 */
			Set<String> roleNames =	super.getRoleNamesForUser(conn, username);
			CACHE_ROLES.addAll(roleNames);
			return CACHE_ROLES;
		}
		
		return CACHE_ROLES;
	}

	/**
	 * 获取用户权限根据用户 用户的角色名
	 * @param conn
	 * @param username
	 * @param roleNames
	 * @return
	 * @throws SQLException
	 */
	@Override
	protected Set<String> getPermissions(Connection conn, String username, Collection<String> roleNames)
			throws SQLException {
		logger.info("permissions cache size: {}, refresh: {}, zk connected: {}", new Object[] {CACHE_PERMISSIONS.size(), Constants.isRefresh(), Constants.isConnected()});
		
		if(CACHE_PERMISSIONS.isEmpty() || !Constants.isConnected() || Constants.isRefresh()) {
			logger.info("refresh permissions cache");
			CACHE_PERMISSIONS.clear();
			Set<String> permissions = super.getPermissions(conn, username, roleNames);
			CACHE_PERMISSIONS.addAll(permissions);
			/**
			 * 这里是我自定义的  查找用户其他权限的地方
			 */
			for (String roleName : roleNames) {
				List<String> permission2 = usersDAO.getPermission2(roleName);
				CACHE_PERMISSIONS.addAll(permission2);
			}
			Constants.setRefresh(false);
		}
		
		return CACHE_PERMISSIONS;
	}

}
