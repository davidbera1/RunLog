plugins {
    alias(libs.plugins.runlog.android.library)
}

android {
    namespace = "com.db.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)

    implementation(projects.core.domain)
}