DROP DATABASE zwei_channel;

CREATE DATABASE IF NOT EXISTS zwei_channel;

USE zwei_channel;

CREATE TABLE IF NOT EXISTS users(

    user_uid VARCHAR(36) NOT NULL PRIMARY KEY,

    username VARCHAR(50) NOT NULL,
    /* ユーザーネーム。重複可 */

    mail_address VARCHAR(64) NOT NULL,
    /* メールアドレス。学校ドメインのみ。重複不可 */

    password VARCHAR(64) NOT NULL,
    /* パスワード */

    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    /* DB登録日時 */

    update_date TIMESTAMP
    /* レコード変更日時 */
);

CREATE TABLE IF NOT EXISTS user_details(
    user_uid VARCHAR(36) NOT NULL PRIMARY KEY,
    /* ユーザーに与えられる一意のID。usersテーブルのuser_uidと外部キー制約 */

    permission ENUM('ADMIN', 'OPERATOR', 'MODERATOR', 'USER') NOT NULL DEFAULT 'USER',
    /* ユーザーの権限レベル。デフォルト権限はUSER
    ADMIN    : すべての管理を行える初回登録ユーザーに付与される。すべてのスレッドを操作・閲覧可能。
    OPERATOR : ADMINと同一権限。ADMINユーザーから付与される。
    MODERATOR: ユーザーの監視が可能。処罰や問い合わせスレッドを閲覧可能。
    USER     : 一般ユーザー。
    */

    user_status ENUM('UNAUTHORIZED', 'GENERAL', 'LIMITATION', 'BAN') NOT NULL DEFAULT 'UNAUTHORIZED',
    /* ユーザーの状態。
    UNAUTHORIZED: メールアドレス認証がされていない状態。仮登録状態。
    GENERAL     : 一般状態。許可された操作がすべて可能。
    LIMITATION  : 制限状態。制限レベルによってできる行動が制限される。
    BAN         : 利用禁止状態。ログインすら不可能となる。
    */

    limitation_level ENUM('LIMITLESS', 'BROWSE_ONLY', 'UNAVAILABLE_PUBLIC_CHANNEL'),
    /* 制限レベル
       LIMITLESS                  : 無制限状態。
       BROWSE_ONLY                : スレッド閲覧のみ可能。
       UNAVAILABLE_PUBLIC_CHANNEL : 公開チャンネルの閲覧・書き込みが不可となる。
    */

    limitation_end_date TIMESTAMP,
    /* 制限終了日付 */

    ban_end_date TIMESTAMP,
    /* BAN終了日付 */

    disposal_count INT NOT NULL DEFAULT 0,
    /* 処分回数 */

    username_change_count INT NOT NULL DEFAULT 0,
    /* ユーザーネーム変更回数 */

    password_change_count INT NOT NULL DEFAULT 0,
    /* パスワード変更回数 */

    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    /*  */

    update_date TIMESTAMP,
    FOREIGN KEY (user_uid) REFERENCES users(user_uid)
    );

CREATE TABLE IF NOT EXISTS user_activities(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    target_uid VARCHAR(36) NOT NULL,
    executor_uid VARCHAR(36),
    activity_type ENUM('RESISTER', 'AUTHORIZE', 'LOGIN', 'LOGOUT', 'STATUS_GRANT', 'PERMISSION_GRANT'),
    status_modified ENUM('UNAUTHORIZED', 'GENERAL', 'LIMITATION', 'BAN'),
    permission_modified ENUM('ADMIN', 'OPERATOR', 'MODERATOR', 'USER'),
    activity_cause VARCHAR(255),
    activity_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (executor_uid) REFERENCES users(user_uid),
    FOREIGN KEY (target_uid) REFERENCES users(user_uid)
);

CREATE TABLE IF NOT EXISTS user_authenticate_activities(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    user_uid VARCHAR(36) NOT NULL,
    authorize_token VARCHAR(6) NOT NULL,
    token_term TIMESTAMP,
    token_status ENUM('UNUSED', 'USED', 'INVALID') NOT NULL DEFAULT 'UNUSED',
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS threads(
    thread_uid VARCHAR(36) NOT NULL PRIMARY KEY,
    thread_title VARCHAR(255) NOT NULL DEFAULT 'untitled',
    thread_category VARCHAR(36) NOT NULL,
    thread_owner VARCHAR(36) NOT NULL,
    thread_members TEXT,
    impression_count INT NOT NULL DEFAULT 0,
    like_count INT NOT NULL DEFAULT 0,
    thread_status ENUM('PUBLIC', 'PRIVATE', 'ARCHIVED') NOT NULL,
    thread_type ENUM('GENERAL', 'TEAM', 'PERSONAL', 'CONTACT') NOT NULL,
    create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP,
    FOREIGN KEY (thread_owner) REFERENCES users(user_uid)
    );

CREATE TABLE IF NOT EXISTS thread_activities(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    thread_uid VARCHAR(36) NOT NULL,
    executor_uid VARCHAR(36) NOT NULL,
    activity_type ENUM('ACCESS', 'CREATE', 'DELETE', 'LIKE', 'SHARE') NOT NULL,
    activity_cause VARCHAR(255),
    activity_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (thread_uid) REFERENCES threads(thread_uid),
    FOREIGN KEY (executor_uid) REFERENCES users(user_uid)
    );

CREATE TABLE IF NOT EXISTS posts(
    post_uid VARCHAR(36) NOT NULL PRIMARY KEY,
    thread_uid VARCHAR(36) NOT NULL,
    user_uid VARCHAR(36) NOT NULL,
    content TEXT NOT NULL,
    like_count INT NOT NULL DEFAULT 0,
    FOREIGN KEY (user_uid) REFERENCES users(user_uid),
    FOREIGN KEY (thread_uid) REFERENCES threads(thread_uid)
    );

CREATE TABLE IF NOT EXISTS post_activities(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    post_uid VARCHAR(36) NOT NULL,
    executor_uid VARCHAR(36) NOT NULL,
    activity_type ENUM('POST', 'DELETE', 'REPLY', 'LIKE', 'SHARE') NOT NULL,
    activity_cause VARCHAR(255),
    activity_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_uid) REFERENCES posts(post_uid),
    FOREIGN KEY (executor_uid) REFERENCES users(user_uid)
);