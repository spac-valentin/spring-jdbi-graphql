load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "2.8"
RULES_JVM_EXTERNAL_SHA = "79c9850690d7614ecdb72d68394f994fef7534b292c4867ce5e7dec0aa7bdfad"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "org.springframework.boot:spring-boot-dependencies:2.3.8.RELEASE",
        "org.springframework.boot:spring-boot-starter-web:2.3.8.RELEASE",
        "org.springframework.boot:spring-boot-starter-data-jpa:2.3.8.RELEASE",
        "org.springframework.boot:spring-boot-configuration-processor:2.3.8.RELEASE",
        "org.hibernate.validator:hibernate-validator:6.0.18.Final",
        "com.graphql-java-kickstart:graphql-spring-boot-starter:7.1.0",
        "org.jdbi:jdbi3-spring4:3.18.0",
        "org.jdbi:jdbi3-sqlobject:3.18.0",
        "org.jdbi:jdbi3-sqlobject:3.18.0",
        "org.immutables:value:2.8.8",
        "org.projectlombok:lombok:1.18.18",
        "org.mapstruct:mapstruct:1.4.2.Final",
        "org.mapstruct:mapstruct-processor:1.4.2.Final",
        "com.google.code.findbugs:jsr305:1.3.9",
        "com.fasterxml.jackson.core:jackson-annotations:2.11.4",
        "com.h2database:h2:1.4.200",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)
