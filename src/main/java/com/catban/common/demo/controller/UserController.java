package com.catban.common.demo.controller;

import com.catban.common.constant.RegexpConstant;
import com.catban.common.demo.form.UserForm;
import com.catban.common.demo.model.User;
import org.apache.commons.lang.BooleanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.regex.Pattern;

/**
 * Created by meitu on 17/1/12.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "add")
    public String add(Model model){

        return "user/add";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public String save(User user ,@Valid UserForm userForm, BindingResult result){

        if (result.hasErrors()){
            return BooleanUtils.toStringTrueFalse(Boolean.FALSE);
        }

        return BooleanUtils.toStringTrueFalse(Boolean.TRUE);
    }

    /**
     * @param userPass
     * @return
     */
    @RequestMapping(value = "/checkPwdStrength")
    public boolean checkPwdStrength(@RequestParam("userPass") String userPass) {
        if (!userPass.matches("^.{8,}$")) {
            return false;
        }
        return true;
    }
}
