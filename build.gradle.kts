//Ссылки на зависимости, которые используются во всем проекте. Обязательно синхронизировать сборку и настройки грэдл файла
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}