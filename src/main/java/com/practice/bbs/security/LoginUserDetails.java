package com.practice.bbs.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.practice.bbs.entity.User;

/**
 * Spring Security が使用するユーザー情報の詳細を表すクラスです。
 * <p>
 * アプリケーション独自の {@link User} エンティティを基に、Spring Security の {@link UserDetails}
 * インターフェースを実装しています。
 * </p>
 */
public class LoginUserDetails implements UserDetails {

    private final User user;

    /**
     * 指定されたユーザー情報でインスタンスを初期化します。
     *
     * @param user ユーザー情報
     */
    public LoginUserDetails(User user) {
        this.user = user;
    }

    /**
     * ユーザーの ID を取得します。
     *
     * @return ユーザーの ID
     */
    public Integer getId() {
        return user.getId();
    }

    /**
     * ユーザーの名前を取得します。
     *
     * @return ユーザーの名前
     */
    public String getName() {
        return user.getName();
    }

    /**
     * ユーザーの権限情報を返します。
     * <p>
     * ユーザーのロールに "ROLE_" を付与して {@link GrantedAuthority} に変換します。
     * </p>
     *
     * @return 権限のコレクション
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
    }

    /**
     * ユーザーのパスワードを返します。
     *
     * @return パスワードのハッシュ値
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * ユーザー名（ログイン時に使用する識別子）を返します。
     * <p>
     * 通常はメールアドレスやユーザー名を返しますが、ここでは {@code name} を使用しています。
     * </p>
     *
     * @return ユーザー名
     */
    @Override
    public String getUsername() {
        return user.getName();
    }

    /**
     * アカウントの有効期限が切れていないかどうかを返します。
     *
     * @return {@code true}（常に有効）
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * アカウントがロックされていないかどうかを返します。
     *
     * @return {@code true}（常にロックされていない）
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 資格情報（パスワードなど）が有効期限切れでないかを返します。
     *
     * @return {@code true}（常に有効）
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * ユーザーが有効かどうかを返します。
     *
     * @return {@code true}（常に有効）
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}
