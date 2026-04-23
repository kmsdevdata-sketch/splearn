package spring.splearn.domain;


import org.springframework.util.Assert;

import java.util.Objects;

import static org.springframework.util.Assert.*;

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

        state(status == MemberStatus.PENDING,"PENDING 상태가 아닙니다.");

        this.status = MemberStatus.ACTIVE;
    }

    public void deactivate() {

        state(status == MemberStatus.ACTIVE,"ACTIVE 상태가 아닙니다.");

        this.status = MemberStatus.DEACTIVATED;
    }
}
