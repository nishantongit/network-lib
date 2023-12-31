# network-lib

# A light weight network library

## Add it in your root build.gradle at the end of repositories:

```
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```

if using kts then it to settings.gradle.kts

```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl( "https://jitpack.io") }
    }
}
```


## Add the dependency

 ```
  dependencies {
implementation 'com.github.nishantongit:network-lib:1.0.1'
}
```


 ## initialize your service

```
class ApiClient {
 companion object {
 fun getService(): EmployeeService {
 val logging = HttpLoggingInterceptor()
 logging.level = HttpLoggingInterceptor.Level.BODY
 val httpClientBuilder = OkHttpClient.Builder()
 httpClientBuilder.addInterceptor(logging)
 return Retrofit.Builder()
  .baseUrl("https://dummy.restapiexample.com/")
   .addConverterFactory(MoshiConverterFactory.create(
      Moshi.Builder()
     .addLast(KotlinJsonAdapterFactory())
    .build())
                )
                .addCallAdapterFactory(NetworkResultCallAdapterFactory.create())
                .client(httpClientBuilder.build()).build()
                .create(EmployeeService::class.java)
        }
    }
}
```

## define service like this

```

interface EmployeeService {
    @GET("/api/v1/employees")
    suspend fun getItems(): NetworkResult<EmployeeListResponse>
}
```

## Upcoming features
-> Service builder with default interceptor, convertorfactory and networkresult call adapter factory

