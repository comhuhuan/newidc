package com.act.web.interceptor;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.act.alone.model.TabSysUser;
import com.act.idc.model.TabSysOperateLog;
import com.act.util.json.JacksonUtil;
import com.act.util.operatelog.OperateLog;
import com.act.web.constant.CommonContant;

@Component
@Aspect
public class OperateLogInterceptor {
	
	/**
	 * 定义织入切面的范围，目前只会织入controller的请求部分
	 */
	@Pointcut("execution(* com.act.web.module.*.controller.*.*(..)) && @annotation(com.act.util.operatelog.OperateLog)")
	private void controllerAspect() {}// 定义一个切入点
	
	/**
	 * 在请求完毕后，保存日志表
	 * @param pjd
	 * @throws Throwable
	 */
	@After("controllerAspect()")
	public void doAroundMethod(JoinPoint pjd) throws Throwable {
		/*HttpServletRequest request = getHttpServletRequest();
		TabSysUser user = (TabSysUser) request.getSession().getAttribute(
				CommonContant.SESSION_USERINFO);
		String ip = request.getRemoteAddr();
		Boolean opResult = true; // 操作结果
		Object[] params = pjd.getArgs();// 获取请求参数
		String json=JacksonUtil.beanToJson(params);
		TabSysOperateLog operateLogEntity = new TabSysOperateLog();
		operateLogEntity.setOpDesc(getOpDesc(pjd));
		operateLogEntity.setOpObject(getOpObject(pjd));
		operateLogEntity.setOperater(user.getUserName());
		operateLogEntity.setOpIp(ip);
		operateLogEntity.setOpResult(opResult);
		operateLogEntity.setOpTime(new Date());
		operateLogEntity.setOpType("01"); //默认写的值，对于操作类型，打算废除
//		operateLogEntity.setOpParams(json);
		operateLogEntity.save();*/
	}

	/**
	 * @Description: 获取request
	 * @return
	 */
	public HttpServletRequest getHttpServletRequest() {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		return request;
	}

	/**
	 * 获取操作对象
	 * @param joinPoint
	 * @return
	 * @throws Exception
	 */
	private String getOpObject(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String opObject = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					opObject = method.getAnnotation(OperateLog.class)
							.opObject();
					break;
				}
			}
		}
		return opObject;
	}

	/**
	 * 获取操作描述
	 * @param joinPoint
	 * @return
	 * @throws Exception
	 */
	private String getOpDesc(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String opDesc = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					opDesc = method.getAnnotation(OperateLog.class)
							.opDesc();
					break;
				}
			}
		}
		return opDesc;
	}

	/**
	 * 获取操作参数，并拼装json
	 * @param joinPoint
	 * @return
	 * @throws Exception
	 */
	private String getServiceMthodParams(JoinPoint joinPoint) throws Exception {
		Object[] arguments = joinPoint.getArgs();
		String params = JacksonUtil.beanToJson(arguments);
		return params;
	}
}
