https://docs.microsoft.com/en-us/dotnet/standard/generics/covariance-and-contravariance
https://kotlinlang.org/docs/reference/generics.html
https://kotlinlang.org/docs/tutorials/kotlin-for-py/generics.html

--- Covariance ---
- Generic<Subtype> can be assigned to Generic<Supertype>
- keyword: out
- example: List<String> can be assigned to List<Object> (needs List define T as covariant)
- example Java:
List<String> sValues = null;
List<? extends Object> oValues = sValues;

--- Contravariance ---
- Generic<Supertype> can be assigned to Generic<Subtype>
- keyword: in
- example: Comparator<Object> can be assigned to Comparator<String> (needs Comparator define T as contravariant)
- example Java:
Comparator<Object> cObj = null;
Comparator<? super String> cStr = cObj;

-- Declarative Variance --
When using on class there are some restrictions:
-- Covariance --
- keyword: out
- when type is used on public methods, it can only be on out position (return)
-- Contravariance --
- keyword: in
- when type is used on public methods, it can only be on in position (parameters)
