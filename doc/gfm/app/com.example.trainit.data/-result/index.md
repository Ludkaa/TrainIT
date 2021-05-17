//[app](../../../index.md)/[com.example.trainit.data](../index.md)/[Result](index.md)



# Result  
 [androidJvm] sealed class [Result](index.md)<out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>

Trieda ktora drzi data o uspesnosti

   


## Parameters  
  
androidJvm  
  
| | |
|---|---|
| <a name="com.example.trainit.data/Result///PointingToDeclaration/"></a>T| <a name="com.example.trainit.data/Result///PointingToDeclaration/"></a>|
  


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.example.trainit.data/Result.Error///PointingToDeclaration/"></a>[Error](-error/index.md)| <a name="com.example.trainit.data/Result.Error///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [Error](-error/index.md)(**exception**: [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)) : [Result](index.md)<[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)>   <br>More info  <br>Error  <br><br><br>|
| <a name="com.example.trainit.data/Result.Success///PointingToDeclaration/"></a>[Success](-success/index.md)| <a name="com.example.trainit.data/Result.Success///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [Success](-success/index.md)<out [T](-success/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**data**: [T](-success/index.md)) : [Result](index.md)<[T](-success/index.md)>   <br>More info  <br>Success  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.example.trainit.data/Result/toString/#/PointingToDeclaration/"></a>[toString](to-string.md)| <a name="com.example.trainit.data/Result/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.example.trainit.data/Result.Success///PointingToDeclaration/"></a>[Result](-success/index.md)|
| <a name="com.example.trainit.data/Result.Error///PointingToDeclaration/"></a>[Result](-error/index.md)|

