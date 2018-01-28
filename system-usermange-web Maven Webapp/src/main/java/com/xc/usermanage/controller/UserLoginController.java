package com.xc.usermanage.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xc.basic.util.Captcha;
import com.xc.houserental.controller.CommonCotroller;
import com.xc.houserental.web.ProjectSessionContext;
import com.xc.system_usermanage_core.model.UserInofAndAccountQm;
import com.xc.system_usermanage_core.service.UserService;

/**
 * <p>Title:用户登录，退出登录的的controller </p>
 * <p>Description: 提供用户给用户登录注册的controller </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月28日
 */
@Controller
public class UserLoginController extends CommonCotroller {
	private static Logger logger = Logger.getLogger(UserLoginController.class);
	@Autowired
	private UserService userService ;
	/**
	 * <p>Description:用户登录<p>
	 * @param userAccount 用户账号
	 * @param passWord 用户密码
	 * @param model 传递参数的实体类类
	 * @param session session
	 * @author wanglei 2018年1月28日
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String userAccount,String passWord,Model model,HttpSession session){
		UserInofAndAccountQm loginUser =null;
		try {
			loginUser = userService.getLogin(userAccount, passWord);
		} catch (Exception e) {
			logger.error("-----------------------------用户登录失败："+e.getMessage()+"-----------");
		}
		session.setAttribute("loginUser", loginUser);
		logger.info("---------------------用户["+loginUser.getUserAcc().getUaserAccountNum()+"]登录成功！"+"-----------");
		ProjectSessionContext.addSessoin(session);
		return "redirect:jsp/admin/index";
	}
	/**
	 * <p>Description:验证码校验<p>
	 * @param checkcode 验证码
	 * @param session
	 * @return
	 * @author wanglei 2018年1月28日
	 */
	@RequestMapping(value="/validateCheckcode",method=RequestMethod.POST)
	@ResponseBody
	public String valiteCheckcode(String checkcode,HttpSession session){
		Map<String,String> map= new HashMap<>();
		String cc = (String)session.getAttribute("cc");
		if(checkcode.equals(cc)) {
			map.put("istrue", "true");
		}else{
			map.put("istrue", "false");
		}
		return JSONObject.toJSONString(map);
	}
	/**
	 * <p>Description:获取验证码的方法<p>
	 * @param resp
	 * @param session
	 * @throws IOException
	 * @author wanglei 2018年1月28日
	 */
	@RequestMapping("/drawCheckCode")
	public void drawCheckCode(HttpServletResponse resp,HttpSession session) throws IOException {
		resp.setContentType("image/jpg");
		int width = 110; 
		int height = 45;
		Captcha c = Captcha.getInstance();
		c.set(width, height);
		String checkcode = c.generateCheckcode();
		session.setAttribute("cc", checkcode);
		OutputStream os = resp.getOutputStream();
		ImageIO.write(c.generateCheckImg(checkcode), "jpg", os);
		os.close();
		os.flush();
	}
}
