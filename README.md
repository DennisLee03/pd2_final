# pd2_final
```
pd2_final
├─ .gitignore
├─ .gitattributes
├─ .mvn
│  └─ wrapper
│     └─ maven-wrapper.properties
├─ mvnw
├─ mvnw.cmd
├─ pom.xml
├─ other
│  └─ meals.csv
└─ src
   ├─ main
   │  ├─ java
   │  │  └─ com
   │  │     └─ kfccoupon
   │  │        └─ pd2
   │  │           ├─ controller
   │  │           │  ├─ HomeController.java
   │  │           │  └─ HomeController.java
   │  │           ├─ dao
   │  │           │  ├─ CouponDao.java
   │  │           │  └─ MongoDeleteCollection.java
   │  │           ├─ dto
   │  │           │  └─ CouponMealDto.java
   │  │           ├─ model
   │  │           │  └─ CouponMeal.java
   │  │           ├─ service
   │  │           │  ├─ CouponService.java
   │  │           │  └─ Crawler.java
   │  │           └─ Pd2Application.java
   │  └─ resources
   │     ├─ application.properties
   │     ├─ static
   │     │  ├─ script.js
   │     │  └─ styles.css
   │     └─ templates
   │        └─ home.html
   └─ test
      └─ java
         └─ com
            └─ kfccoupon
               └─ pd2
                  └─ Pd2ApplicationTests.java
```
```mermaid
classDiagram
    class HomeController {
        +String home()
    }
    class MainController {
        +ResponseEntity~String~ scrapeData()
        +ResponseEntity~List~CouponMealDto~~ getData()
        +ResponseEntity~String~ deleteCollection()
        +ResponseEntity~List~CouponMealDto~~ getUpSortedData()
        +ResponseEntity~List~CouponMealDto~~ getDownSortedData()
        +ResponseEntity~List~CouponMealDto~~ getNuggetData()
        +ResponseEntity~List~CouponMealDto~~ getTartData()
        +ResponseEntity~List~CouponMealDto~~ getQQData()
        +ResponseEntity~List~CouponMealDto~~ getChickenData()
        +ResponseEntity~List~CouponMealDto~~ getDaifukuData()
    }
    class CouponService {
        +void scrapeAndSaveData()
        +List~CouponMealDto~ getData()
        +List~CouponMealDto~ sortByPrice(boolean ascending)
        +List~CouponMealDto~ filterNuggets()
        +List~CouponMealDto~ filterTart()
        +List~CouponMealDto~ filterQQ()
        +List~CouponMealDto~ filterChiken()
        +List~CouponMealDto~ filterDaifuku()
    }
    class MongoDeleteCollection {
        +void dropCollection(String collectionName)
        -MongoTemplate mongoTemplate
    }
    class CouponMealDto {
        -String code
        -Integer price
        -String imgUrl
        -String content
        +String getCode()
        +void setCode(String code)
        +Integer getPrice()
        +void setPrice(Integer price)
        +String getImgUrl()
        +void setImgUrl(String imgUrl)
        +String getContent()
        +void setContent(String content, boolean mode)
    }
    class CouponMeal {
        -String code
        -Integer price
        -String imgUrl
        -String content
        +String getCode()
        +void setCode(String code)
        +Integer getPrice()
        +void setPrice(Integer price)
        +String getImgUrl()
        +void setImgUrl(String imgUrl)
        +String getContent()
        +void setContent(String content)
    }
    class Id {
    }
    class Document {
    }
    class Data {
    }
    class SpringApplication {
        +void run(Class applicationClass, String[] args)
    }
    class SpringBootApplication {
    }

    SpringApplication --> SpringBootApplication
    SpringApplication --> Controller
    SpringApplication --> RestController
    SpringApplication --> CouponDao
    SpringApplication --> CouponMeal
    SpringApplication --> MongoDeleteCollection

    CouponService --> List
    MongoDeleteCollection --> MongoTemplate
    MainController --> CouponMealDto

    CouponMeal --> Id
    CouponMeal --> Document
    CouponMeal --> Data

    CouponMealDto --> NotEmpty
    CouponMealDto --> NotNull
    CouponMealDto --> StringBuilder
```
