plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.custom_selection"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.custom_selection"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.cronet.embedded)
    testImplementation(libs.junit)
    implementation(libs.circleimageview)
    implementation(libs.dialogplus)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}