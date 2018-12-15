/**
 * 
 */
package com.zzh.shiro.controller;


import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import com.zzh.shiro.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理
 * RequiresAuthentication  表示当前subject 必须时经过shiro认证的
 * RequiresGuest 表示可以不用通过shiro认证
 */
@RestController
@RequestMapping("/user")
//@RequiresAuthentication
public class UserController {
	@Autowired
	private UsersService usersService;
	/**
	 * 必须同时拥有abcd 和123权限
	 * @return
	 */
	@GetMapping("/test")
	@RequiresPermissions({"abcd","123"})
	public String test(){
		return "123";
	}

	/**
	 * 拥有 abcd  或者123权限
	 * @return
	 */
	@GetMapping("/test2")
	@RequiresPermissions(value = {"abcd","123"},logical = Logical.OR)
	public String test2(){
		return "123";
	}

	/**
	 * 拥有admin角色就可以访问
	 * @return
	 */
	@GetMapping("/roleTest")
	@RequiresRoles(value = {"admin"})
	public String test3(){
		return "roleTest123";
	}
	/**
	 * 拥有admin角色获取user校色就可以访问
	 * @return
	 */
	@GetMapping("/roleTest2")
	@RequiresRoles(value = {"admin","user"}, logical = Logical.OR)
	public String test4(){
		return "roleTest123";
	}

	@GetMapping("/123")
	public String test1(){
//		usersService.clearShiroCatch();
		return "123";
	}
}
