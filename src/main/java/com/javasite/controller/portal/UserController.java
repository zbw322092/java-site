package com.javasite.controller.portal;

import com.javasite.common.Const;
import com.javasite.common.ServerResponse;
import com.javasite.pojo.User;
import com.javasite.service.IUserService;
import net.sf.jsqlparser.schema.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * User Login
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do", method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session) {

        ServerResponse<User> response = iUserService.login(username, password);

        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }


    /**
     * User Logout
     * @param session
     * @return
     */
    @RequestMapping(value = "logout.do", method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }


    /**
     * User Register
     * @param user
     * @return
     */
    @RequestMapping(value = "register.do", method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> register(User user) {
        return iUserService.register(user);
    }

    /**
     * User Check Valid
     * @param str
     * @param type
     * @return
     */
    @RequestMapping(value = "check_valid.do", method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> checkValid(String str, String type) {
        return iUserService.checkValid(str, type);
    }


    /**
     * Get User Info
     * @param session
     * @return
     */
    @RequestMapping(value = "get_user_info.do", method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }

        return ServerResponse.createByErrorMessage("用户未登录，无法获取用户的信息");
    }

    /**
     * Get Forget Password Question
     * @param username
     * @return
     */
    @RequestMapping(value = "forget_get_question.do", method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(String username) {
        return iUserService.selectQuestion(username);
    }

//    public ServerResponse<String> forgetCheckAnswer(String username, String question, String answer) {
//
//    }
}
