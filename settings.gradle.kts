pluginManagement {
    repositories {
        maven {
            url = uri("https://maven.aliyun.com/repository/google")
            name = "AliyunGoogle"
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/central")
            name = "AliyunCentral"
        }
        maven {
            url = uri("https://repo.huaweicloud.com/repository/maven/")
            name = "HuaweiCloud"
        }
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = uri("https://maven.aliyun.com/repository/google")
            name = "AliyunGoogle"
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/central")
            name = "AliyunCentral"
        }
        maven {
            url = uri("https://repo.huaweicloud.com/repository/maven/")
            name = "HuaweiCloud"
        }
        google()
        mavenCentral()
    }
}

rootProject.name = "Basics Codelab"
include(":app")
 