# GetReceipt
Simple Android library based on [Spoonacular API](https://spoonacular.com/food-api) that were implemented to practice with Android libraries
implementation and publishing it with [Jitpack.io](https://jitpack.io). Library provides access to some very basic API functions. 
## How to import
To import the library you need to add Jitpack.io repository to your project. If you are using Gradle 7 or above, go to `settings.gradle` and add a repository there.
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://www.jitpack.io' }
    }
}
```
If you are using an older version of Gradle, go to your project level `build.gradle` and add the repository:
```
allprojects {
	repositories {
		...
		maven { url 'https://www.jitpack.io' }
	}
}
```
And then add the dependency to your module level `build.gradle`:
```
dependencies {
    ...
    implementation 'com.github.Sanusy.GetReceipt:final:publish'
}
```
## How to use
First of all you need to initialize library by calling `GetReceipt.init(apikey: String)`. You can get your API Key [here](https://spoonacular.com/food-api).
###### Services
Interaction with API provided by services. You can get services that provide receipts and ingredients.
```
val receiptService = GetReceipt.getReceiptService() //Providing service to get receipts.
val ingerdientService = GetReceipt.getIngredientService() //Providing service to get ingredients.
```
###### Receipts
With `ReceiptService` you can get the list of receipts and certain receipts:
```
val receiptList: ReceiptListDto = receiptService.getReceiptList(query?)
val receipt: ReceiptDto = receiptService.getReceipt(receiptId)
```
###### Ingredients
With ÌngredientService` you can get an ingredient list and details on certain ingredients:
```
val ingredientList: IngredientListDto = ringredientService.getReceiptList(query) //you should specify querry. For example "vegetables"
val ingredient: IngredientDto = ingredientService.getReceipt(ingredientId)
```
