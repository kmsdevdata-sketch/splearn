package spring.splearn.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void equality() {
        Email email1 = new Email("kms.dev.data@gmail.com");
        Email email2 = new Email("kms.dev.data@gmail.com");

        assertThat(email1).isEqualTo(email2);
    } 
}