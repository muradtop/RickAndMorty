// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id 'com.android.application' version '7.1.2' apply false
    id 'com.android.library' version '7.1.2' apply false
    id 'org.jetbrains.kotlin.android' version '1.5.30' apply false
    id "com.google.dagger.hilt.android" version "2.41" apply false
    id 'androidx.navigation.safeargs.kotlin' version '2.5.0-alpha01' apply false
}

task clean(type: Delete) {
    delete rootProject.buildDir
}