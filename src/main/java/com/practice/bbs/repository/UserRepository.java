package com.practice.bbs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.bbs.entity.User;

/**
 * ユーザー情報をデータベースから取得・操作するためのリポジトリインターフェースです。
 * <p>
 * Spring Data JPA の {@link JpaRepository} を継承しており、標準的な CRUD 操作が利用できます。
 * </p>
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * メールアドレスをキーにユーザー情報を取得します。
     *
     * @param email 検索対象のメールアドレス
     * @return 指定したメールアドレスに対応する {@link User} エンティティを {@link Optional}
     *         でラップして返します。該当するユーザーが存在しない場合は空の {@code Optional}。
     */
    Optional<User> findByEmail(String email);
}
