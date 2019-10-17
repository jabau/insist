package io.github.jabau.insist;

import org.junit.jupiter.api.Test;

import static io.github.jabau.insist.Insistence.insist;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InsistenceTest {
    @Test
    void is_matcherDecorating() {
        insist("str").is(not(nullValue()));
    }

    @Test
    void is_chaining() {
        insist("value", "str").is(notNullValue()).is("str");
    }

    @Test
    void is_failure() {
        assertThrows(AssertionError.class, () -> insist("str").is(nullValue()));
    }

    @Test
    void value() {
        assertThat(insist("str").is("str").value(), is("str"));
    }
}