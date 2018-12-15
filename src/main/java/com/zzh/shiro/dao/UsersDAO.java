/**
 * 
 */
package com.zzh.shiro.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @desc UsersDAO
 * @author chench9@lenovo.com
 * @date 2017年3月16日
 */
@Repository
public interface UsersDAO {
	
	public final String TABLE_ROLE_PERMISSIONS = "roles_permissions as rp "; // 角色权限表
	public final String TABLE_PERMISSIONS = "permissions as p "; // 权限表
	public final String TABLE_USER_ROLES = "user_roles "; // 用户角色表

	/**
	 * 查找用户对应角色拥有的权限
	 * @param username
	 * @return
	 */
	@Select("SELECT b.permission from user_roles a INNER JOIN roles_permissions b on a.role_name = b.role_name " +
			"where a.username = #{username}")
	public List<String> getUserPermissions(String username);

	@Select("select permission from role_permission2 where user_name = #{userName}")
	public List<String> getPermission2(String userName);

	/**
	 * 获取用于所有角色
	 */

	@Select("select role_name from user_roles where username =  #{userName}")
	public List<String> getRoles(String userName);
	/**
	 * 获取用于所有角色
	 */

	@Select("select password from users where username =  #{userName}")
	public String getPassword(String userName);
	/**
	 * 添加用户角色
	 * @param userName
	 * @param roleName
	 * @return
	 */
	@Insert("insert into " + TABLE_USER_ROLES + "(username,role_name,create_time,update_time) values(#{userName},#{roleName},now(),now())")
	public Integer addRole(@Param("userName") String userName, @Param("roleName") String roleName);
	
	@Delete("delete from " + TABLE_USER_ROLES + " where username=#{userName} and role_name=#{roleName}")
	public Integer delRole(@Param("userName") String userName, @Param("roleName") String roleName);

}
