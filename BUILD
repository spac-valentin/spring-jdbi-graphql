# Setup Immutables.org annotation processor.
java_plugin(
    name = "immutables_plugin",
    generates_api = 1,
    processor_class = "org.immutables.processor.ProxyProcessor",
    deps = ["@maven//:org_immutables_value"],
)

java_library(
    name = "immutables",
    exported_plugins = [":immutables_plugin"],
    visibility = ["//visibility:public"],
    exports = ["//:immutables_plugin"],
)

java_plugin(
    name = "lombok_plugin",
    generates_api = 1,
    deps = ["@maven//:org_projectlombok_lombok"],
    processor_class = "lombok.launch.AnnotationProcessorHider$AnnotationProcessor",
    visibility = ["//visibility:public"],
)

# Setup lombok annotation processor.
java_library(
    name = "lombok",
    exported_plugins = [":lombok_plugin"],
    visibility = ["//visibility:public"]
)

# Setup mapstruct annotation processor.
java_plugin(
    name = "mapstruct_plugin",
    generates_api = 1,
    processor_class = "org.mapstruct.ap.MappingProcessor",
    deps = ["@maven//:org_mapstruct_mapstruct_processor"],
)

java_library(
    name = "mapstruct",
    exported_plugins = [":mapstruct_plugin"],
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:org_mapstruct_mapstruct",
        "@maven//:org_mapstruct_mapstruct_processor",
    ],
    runtime_deps = [
        # add to runtime, as we need
        "@maven//:org_mapstruct_mapstruct",
    ],
)

java_library(
    name = "everything",
    srcs = glob(["src/main/java/**/*.java"]),
    resources = glob(["src/main/resources/**"]),
    deps = [
        "//:immutables",
        "//:lombok",
        "//:mapstruct",
        "@maven//:com_graphql_java_kickstart_graphql_spring_boot_starter",
        "@maven//:com_graphql_java_kickstart_graphql_java_tools",
        "@maven//:com_graphql_java_graphql_java",
        "@maven//:com_google_code_findbugs_jsr305",
        "@maven//:org_hibernate_validator_hibernate_validator",
        "@maven//:javax_validation_validation_api",
        "@maven//:org_jdbi_jdbi3_spring4",
        "@maven//:org_jdbi_jdbi3_core",
        "@maven//:org_jdbi_jdbi3_sqlobject",
        "@maven//:org_projectlombok_lombok",
        "@maven//:org_immutables_value",
        "@maven//:org_springframework_boot_spring_boot_autoconfigure",
        "@maven//:org_springframework_boot_spring_boot",
        "@maven//:org_springframework_spring_beans",
        "@maven//:org_springframework_spring_web",
        "@maven//:org_springframework_spring_jdbc",
        "@maven//:org_springframework_spring_tx",
        "@maven//:org_springframework_spring_context",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:org_slf4j_slf4j_api",
        "@maven//:org_checkerframework_checker_qual",
    ]
)

java_binary(
    name = "spring-jdbi-graphql",
    srcs = glob(["src/main/java/**/*.java"]),
    main_class = "dev.vspac.SpringBootJdbiApplication",
    deps = [
        "//:immutables",
        "//:lombok",
        "//:mapstruct",
        "@maven//:com_graphql_java_kickstart_graphql_spring_boot_starter",
        "@maven//:com_graphql_java_kickstart_graphql_java_tools",
        "@maven//:com_graphql_java_graphql_java",
        "@maven//:com_google_code_findbugs_jsr305",
        "@maven//:org_hibernate_validator_hibernate_validator",
        "@maven//:javax_validation_validation_api",
        "@maven//:org_jdbi_jdbi3_spring4",
        "@maven//:org_jdbi_jdbi3_core",
        "@maven//:org_jdbi_jdbi3_sqlobject",
        "@maven//:org_projectlombok_lombok",
        "@maven//:org_immutables_value",
        "@maven//:org_springframework_boot_spring_boot_autoconfigure",
        "@maven//:org_springframework_boot_spring_boot",
        "@maven//:org_springframework_spring_beans",
        "@maven//:org_springframework_spring_web",
        "@maven//:org_springframework_spring_jdbc",
        "@maven//:org_springframework_spring_tx",
        "@maven//:org_springframework_spring_context",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:org_slf4j_slf4j_api",
        "@maven//:com_h2database_h2",
    ],
    resources = glob(["src/main/resources/**/*"]),
)