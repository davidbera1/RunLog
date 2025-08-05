plugins {
    alias(libs.plugins.runlog.jvm.library)
}

dependencies {
    implementation(projects.core.domain)
}