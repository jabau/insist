package io.github.jabau.insist;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Class used to enforce value invariants by chaining insistence checks together using a fluent API
 * @param <T> type accepted by matchers
 */
public final class Insistence<T> {
    /**
     * Creates Insistence object
     * @param actual value being checked
     * @param <T> type of value
     * @return Insistence object
     */
    public static <T> Insistence<T> insist(T actual) {
        return insist("", actual);
    }

    /**
     * Creates Insistence object
     * @param name additional name information about the value
     * @param actual value being checked
     * @param <T> type of value
     * @return Insistence object
     */
    public static <T> Insistence<T> insist(String name, T actual) {
        return new Insistence<>(name, actual);
    }

    private final String name;
    private final T actual;

    private Insistence(String name, T actual) {
        this.name = name;
        this.actual = actual;
    }

    /**
     * Insists that actual is equal to value, if not, an AssertionError is thrown
     * @param value expected value
     * @return Insistence chain reference
     */
    public Insistence<T> is(T value) {
        assertThat(name, actual, (org.hamcrest.core.Is.is(value)));
        return this;
    }

    /**
     * Insists that actual satisfies the condition specified by matcher,
     * if not, an AssertionError is thrown
     * @param matcher an expression, built of hamcrest matchers, specifying allowed values
     * @return Insistence chain reference
     */
    public Insistence<T> is(org.hamcrest.Matcher<? super T> matcher) {
        assertThat(name, actual, org.hamcrest.core.Is.is(matcher));
        return this;
    }

    /**
     * @return actual value
     */
    public T value() {
        return actual;
    }
}
