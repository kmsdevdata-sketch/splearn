package spring.splearn.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberTest {

    @Test
    void 멤버를_생성한다() {
        var member = new Member(
                "kms.dev.data@gmail.com",
                "Minseo",
                "secret");

        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }
    
    @Test
    void 생성자_널체크() {

        assertThatThrownBy(() -> new Member(
                null,
                "Minseo",
                "secret"))
                .isInstanceOf(NullPointerException.class);

    }

    @Test
    void activate() {
        var member = new Member(
                "kms.dev.data@gmail.com",
                "Minseo",
                "secret");

        member.activate();

        assertThat(member.getStatus()).isEqualTo(MemberStatus.ACTIVE);
    }

    @Test
    void activate_실패() {

        var member = new Member(
                "kms.dev.data@gmail.com",
                "Minseo",
                "secret");

        member.activate();

        assertThatThrownBy(() -> {
            member.activate();
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 탈퇴() {

        var member = new Member(
                "kms.dev.data@gmail.com",
                "Minseo",
                "secret");
        member.activate();

        member.deactivate();

        assertThat(member.getStatus()).isEqualTo(MemberStatus.DEACTIVATED);
    }

    @Test
    void deactivate_실패() {

        var member = new Member(
                "kms.dev.data@gmail.com",
                "Minseo",
                "secret");


        assertThatThrownBy(member::deactivate).isInstanceOf(IllegalStateException.class);

        member.activate();
        member.deactivate();

        assertThatThrownBy(member::deactivate).isInstanceOf(IllegalStateException.class);

    }
}