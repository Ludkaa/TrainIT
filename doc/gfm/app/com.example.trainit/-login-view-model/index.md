//[app](../../../index.md)/[com.example.trainit](../index.md)/[LoginViewModel](index.md)



# LoginViewModel  
 [androidJvm] class [LoginViewModel](index.md)(**loginRepository**: [LoginRepository](../../com.example.trainit.data/-login-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel pre login

   


## Constructors  
  
| | |
|---|---|
| <a name="com.example.trainit/LoginViewModel/LoginViewModel/#com.example.trainit.data.LoginRepository/PointingToDeclaration/"></a>[LoginViewModel](-login-view-model.md)| <a name="com.example.trainit/LoginViewModel/LoginViewModel/#com.example.trainit.data.LoginRepository/PointingToDeclaration/"></a> [androidJvm] fun [LoginViewModel](-login-view-model.md)(loginRepository: [LoginRepository](../../com.example.trainit.data/-login-repository/index.md))Create empty Login view model   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="androidx.lifecycle/ViewModel/clear/#/PointingToDeclaration/"></a>[clear](index.md#%5Bandroidx.lifecycle%2FViewModel%2Fclear%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F2033665239)| <a name="androidx.lifecycle/ViewModel/clear/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)()  <br>  <br>fun [clear](index.md#%5Bandroidx.lifecycle%2FViewModel%2Fclear%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F2033665239)()  <br><br><br>|
| <a name="androidx.lifecycle/ViewModel/getTag/#kotlin.String/PointingToDeclaration/"></a>[getTag](index.md#%5Bandroidx.lifecycle%2FViewModel%2FgetTag%2F%23kotlin.String%2FPointingToDeclaration%2F%5D%2FFunctions%2F2033665239)| <a name="androidx.lifecycle/ViewModel/getTag/#kotlin.String/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun <[T](index.md#%5Bandroidx.lifecycle%2FViewModel%2FgetTag%2F%23kotlin.String%2FPointingToDeclaration%2F%5D%2FFunctions%2F2033665239) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [getTag](index.md#%5Bandroidx.lifecycle%2FViewModel%2FgetTag%2F%23kotlin.String%2FPointingToDeclaration%2F%5D%2FFunctions%2F2033665239)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](index.md#%5Bandroidx.lifecycle%2FViewModel%2FgetTag%2F%23kotlin.String%2FPointingToDeclaration%2F%5D%2FFunctions%2F2033665239)  <br><br><br>|
| <a name="com.example.trainit/LoginViewModel/login/#kotlin.String#kotlin.String/PointingToDeclaration/"></a>[login](login.md)| <a name="com.example.trainit/LoginViewModel/login/#kotlin.String#kotlin.String/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [login](login.md)(username: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), password: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))  <br>More info  <br>Login  <br><br><br>|
| <a name="androidx.lifecycle/ViewModel/onCleared/#/PointingToDeclaration/"></a>[onCleared](index.md#%5Bandroidx.lifecycle%2FViewModel%2FonCleared%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F2033665239)| <a name="androidx.lifecycle/ViewModel/onCleared/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [onCleared](index.md#%5Bandroidx.lifecycle%2FViewModel%2FonCleared%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F2033665239)()  <br><br><br>|
| <a name="androidx.lifecycle/ViewModel/setTagIfAbsent/#kotlin.String#TypeParam(bounds=[kotlin.Any])/PointingToDeclaration/"></a>[setTagIfAbsent](index.md#%5Bandroidx.lifecycle%2FViewModel%2FsetTagIfAbsent%2F%23kotlin.String%23TypeParam%28bounds%3D%5Bkotlin.Any%5D%29%2FPointingToDeclaration%2F%5D%2FFunctions%2F2033665239)| <a name="androidx.lifecycle/ViewModel/setTagIfAbsent/#kotlin.String#TypeParam(bounds=[kotlin.Any])/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun <[T](index.md#%5Bandroidx.lifecycle%2FViewModel%2FsetTagIfAbsent%2F%23kotlin.String%23TypeParam%28bounds%3D%5Bkotlin.Any%5D%29%2FPointingToDeclaration%2F%5D%2FFunctions%2F2033665239) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [setTagIfAbsent](index.md#%5Bandroidx.lifecycle%2FViewModel%2FsetTagIfAbsent%2F%23kotlin.String%23TypeParam%28bounds%3D%5Bkotlin.Any%5D%29%2FPointingToDeclaration%2F%5D%2FFunctions%2F2033665239)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), p1: [T](index.md#%5Bandroidx.lifecycle%2FViewModel%2FsetTagIfAbsent%2F%23kotlin.String%23TypeParam%28bounds%3D%5Bkotlin.Any%5D%29%2FPointingToDeclaration%2F%5D%2FFunctions%2F2033665239)): [T](index.md#%5Bandroidx.lifecycle%2FViewModel%2FsetTagIfAbsent%2F%23kotlin.String%23TypeParam%28bounds%3D%5Bkotlin.Any%5D%29%2FPointingToDeclaration%2F%5D%2FFunctions%2F2033665239)  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.example.trainit/LoginViewModel/loginResult/#/PointingToDeclaration/"></a>[loginResult](login-result.md)| <a name="com.example.trainit/LoginViewModel/loginResult/#/PointingToDeclaration/"></a> [androidJvm] val [loginResult](login-result.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)<[LoginResult](../-login-result/index.md)>   <br>|

