package com.practice.bbs.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.bbs.entity.User;
import com.practice.bbs.repository.UserRepository;

/**
 * Spring Security におけるユーザー認証処理を提供するサービスクラスです。
 * <p>
 * {@link UserDetailsService} を実装し、指定されたメールアドレスに基づいて ユーザー情報を取得・検証し、Spring
 * Security が使用する {@link UserDetails} の実装である {@link LoginUserDetails} を返します。
 * </p>
 */
@Service
public class LoginDetailService implements UserDetailsService {

    private UserRepository repository;

    /**
     * ユーザーデータベース操作を行うリポジトリを注入します。
     *
     * @param repository {@link UserRepository} のインスタンス
     */
    public LoginDetailService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * 指定されたメールアドレスをもとにユーザー情報を検索し、 認証に使用する {@link UserDetails} を返します。
     *
     * @param email ログインフォームで入力されたメールアドレス
     * @return {@link LoginUserDetails} インスタンス
     * @throws UsernameNotFoundException メールアドレスに一致するユーザーが存在しない場合にスローされます
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return new LoginUserDetails(user);
    }
}
