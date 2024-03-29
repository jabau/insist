# insist

[![LICENSE](https://img.shields.io/github/license/jabau/insist)](https://opensource.org/licenses/MIT)
[![semver](https://img.shields.io/badge/semver-2.0.0-blue)](https://semver.org/)
[![Build Status](https://travis-ci.org/jabau/insist.svg?branch=master)](https://travis-ci.org/jabau/insist)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.jabau/insist.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.jabau%22%20AND%20a:%22insist%22)

Insist is a framework for enforcing value invariants using a [fluent](https://en.wikipedia.org/wiki/Fluent_interface) API and [hamcrest](http://hamcrest.org/JavaHamcrest/index) matchers.

```java
import static io.github.jabau.insist.Insistence.insist;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

class Example {
    final String name;

    Example(String name) {
        this.name = insist("name", name)
                        .is(notNullValue())
                        .value();
    }

    Integer squareIfInteger(Object x) {
        insist(x).is(notNullValue()).is(instanceOf(Integer.class));
        final Integer i = (Integer) x;
        return i*i;
    }
}
```

## Requirements

For building the library you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Building and installing the library locally

```shell
mvn install
```

## Changelog

See the [CHANGELOG](https://github.com/jabau/insist/blob/master/CHANGELOG.md) file.

## Copyright

Released under the MIT License. See the [LICENSE](https://github.com/jabau/insist/blob/master/LICENSE) file.
