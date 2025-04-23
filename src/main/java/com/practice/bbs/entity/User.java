package com.practice.bbs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * アプリケーション内のユーザー情報を表すエンティティクラスです。
 * <p>
 * このクラスはデータベースの「users」テーブルとマッピングされており、 認証やユーザー管理に必要な情報を保持します。
 * </p>
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * ユーザーの一意な識別子。 自動採番されます。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * ユーザーの名前。
     */
    private String name;

    /**
     * ユーザーのメールアドレス（ログインに使用）。
     */
    private String email;

    /**
     * ハッシュ化されたパスワード。
     */
    private String password;

    /**
     * ユーザーの権限・役割（例: "USER", "ADMIN"）。
     */
    private String role;

    /**
     * ユーザーIDを取得します。
     *
     * @return ユーザーID
     */
    public Integer getId() {
        return id;
    }

    /**
     * ユーザー名を取得します。
     *
     * @return ユーザー名
     */
    public String getName() {
        return name;
    }

    /**
     * ユーザー名を設定します。
     *
     * @param name ユーザー名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ユーザーのメールアドレスを取得します。
     *
     * @return メールアドレス
     */
    public String getEmail() {
        return email;
    }

    /**
     * ユーザーのメールアドレスを設定します。
     *
     * @param email メールアドレス
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * ユーザーのパスワードを取得します。
     *
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * ユーザーのパスワードを設定します。
     *
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ユーザーのロール（権限）を取得します。
     *
     * @return ユーザーロール
     */
    public String getRole() {
        return role;
    }

    /**
     * ユーザーのロール（権限）を設定します。
     *
     * @param role ユーザーロール
     */
    public void setRole(String role) {
        this.role = role;
    }
}
