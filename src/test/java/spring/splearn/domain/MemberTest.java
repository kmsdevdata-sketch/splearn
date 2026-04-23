package spring.splearn.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void 멤버를_생성한다() {
        var member = new Member(
                "kms.dev.data@gmail.com",
                "Minseo",
                "secret");

        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }
}