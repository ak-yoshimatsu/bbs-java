package com.practice.bbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security のセキュリティ設定を行うクラスです。
 * <p>
 * アプリケーションの認証・認可、ログイン/ログアウト、セッション管理などの セキュリティポリシーを定義します。
 * </p>
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * パスワードのハッシュ化に使用する {@link PasswordEncoder} を提供します。
     *
     * @return {@link BCryptPasswordEncoder} のインスタンス
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * HTTP セキュリティに関する設定を行い、セキュリティフィルタチェーンを構成します。
     * <p>
     * ログインページの許可、ログイン成功時の遷移先、ログアウト設定、セッション管理などを定義しています。
     * </p>
     *
     * @param http {@link HttpSecurity} オブジェクト
     * @return 構成された {@link SecurityFilterChain}
     * @throws Exception 設定処理中に発生する可能性のある例外
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/login").permitAll() // 全ユーザーアクセス可能
                .anyRequest().hasRole("USER")) // その他のリクエストは "USER" ロールが必要
                .formLogin(form -> form.loginPage("/login") // カスタムログインページの指定
                        .defaultSuccessUrl("/", true)) // ログイン成功時のリダイレクト先
                .logout(logout -> logout.logoutUrl("/logout") // ログアウトのURL
                        .logoutSuccessUrl("/login?logout"))// ログアウト成功後のリダイレクト先
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS) // セッション常時作成
                        .invalidSessionUrl("/login") // 無効なセッション時の遷移先
                        .maximumSessions(1) // 同時ログインは1ユーザーにつき1セッションまで
                        .maxSessionsPreventsLogin(true)); // 最大セッション数に達したらログイン不可

        return http.build();
    }
}
