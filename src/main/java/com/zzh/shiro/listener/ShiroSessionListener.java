package com.zzh.shiro.listener;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.subject.support.DelegatingSubject;
import org.apache.shiro.web.subject.support.WebDelegatingSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * shiro 会话监听
 */
public class ShiroSessionListener extends SessionListenerAdapter {
	Logger logger=LoggerFactory.getLogger(ShiroSessionListener.class);
	@Override
	public void onStart(Session session) {//会话创建时触发
		logger.debug("会话创建：" + session.getId());

	}
	@Override
	public void onExpiration(Session session) {//会话过期时触发
		logger.debug("会话过期：" + session.getId());

	}
	@Override
	public void onStop(Session session) {//退出时触发
		logger.info("会话停止：" + session.getId());
	}
}
