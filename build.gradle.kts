plugins {
    application
    kotlin("jvm") version "1.3.61"
    kotlin("kapt") version "1.3.61"
}

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

dependencies {
    compile(kotlin("stdlib"))

    compile("io.micronaut:micronaut-runtime:1.2.7")
    compile("io.micronaut:micronaut-http-server-netty:1.2.7")
    compile("io.micronaut:micronaut-views:1.2.0")
    compile("ch.qos.logback:logback-classic:1.2.3")

    runtime("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7")
    runtime("org.thymeleaf:thymeleaf:3.0.11.RELEASE")

    kapt("io.micronaut:micronaut-inject-java:1.2.7")
    kapt("io.micronaut:micronaut-graal:1.2.7")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.compileKotlin {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        javaParameters = true
    }
}

application {
    mainClassName = "hello.WebAppKt"
}

tasks.create("stage") {
    dependsOn("shadowJar")
}
