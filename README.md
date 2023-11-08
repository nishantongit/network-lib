# network-lib

Add it in your root build.gradle at the end of repositories:

dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}

 Add the dependency

 dependencies {
	        implementation 'com.github.nishantongit:network-lib:1.0.2'
	}
