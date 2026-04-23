package spring.splearn.domain;


import java.util.Objects;

public class Member {

    private String email;

    private String nickname;

    private String passwordHash;


    private MemberStatus status;

    public Member(String email, String nickname, String passwordHash) {
        this.email = Objects.requireNonNull(email);
        this.nickname = Objects.requireNonNull(nickname);
        this.passwordHash = Objects.requireNonNull(passwordHash);

        this.status = MemberStatus.PENDING;
    }


    public MemberStatus getStatus() {
        return status;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public void activate() {
        this.status = MemberStatus.ACTIVE;
    }
}
