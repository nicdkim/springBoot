package com.ohgiraffers.chap04exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {

    @GetMapping("/controller-null")
    public String nullPointExceptionTest() {
        String str = null;
        System.out.println(str.charAt(0));
        return "main";
    }

    // Exception 처리의 우선권을 가진다
    @ExceptionHandler(NullPointerException.class)
    public String nullPointExceptionHandler(NullPointerException e) {
        System.out.println("controller 레벨의 exception 처리");
        return "error/nullPointer";
    }

    @GetMapping("controller-user")
    public String userException() throws MemberRegistException {
        boolean check = true;
        if (check) {
            throw new MemberRegistException("입사가 불가능 합니다.");
        }
        return "/";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandelr(Model model, MemberRegistException e) {
        System.out.println("controller 레벨의 exception 처리");
        model.addAttribute("exception", e);
        return "error/memberRegist";
    }


}
