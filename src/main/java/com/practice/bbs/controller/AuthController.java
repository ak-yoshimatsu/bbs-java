package com.practice.bbs.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 認証に関連する画面表示を担当するコントローラークラスです。
 * <p>
 * 主にログインおよびログアウト画面の表示処理を扱います。 Spring Security による認証情報を元にリダイレクト処理を行う場合もあります。
 * </p>
 */
@Controller
public class AuthController {

    /**
     * ログイン画面を表示します。
     * <p>
     * すでに認証されているユーザーがログイン画面にアクセスした場合は、 ホーム画面（"/"）へリダイレクトします。 未認証状態であれば login.html
     * テンプレートを返します。
     * </p>
     *
     * @param authentication 現在の認証情報（Spring Security により注入される）
     * @return 認証済みの場合はトップページへのリダイレクト、未認証の場合はログイン画面（login.html）の論理名
     */
    @GetMapping("/login")
    public String login(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }

    /**
     * ログアウト画面を表示します。
     * <p>
     * logout.html テンプレートを返します。 ログアウト完了後の確認画面などに使用される想定です。
     * </p>
     *
     * @return ログアウト画面（logout.html）の論理名
     */
    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }
}
