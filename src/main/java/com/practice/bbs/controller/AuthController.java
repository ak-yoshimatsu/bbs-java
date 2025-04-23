package com.practice.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 認証関連（ログイン／ログアウト）画面の表示を担当するコントローラクラス
 */
@Controller
public class AuthController {

    /**
     * ログイン画面を表示する
     * 
     * @return login.html
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    /**
     * ログアウト画面を表示する
     * 
     * @return logout.html
     */
    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }
}
