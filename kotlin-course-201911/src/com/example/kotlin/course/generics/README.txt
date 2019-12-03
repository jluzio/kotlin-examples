https://kotlinlang.org/docs/tutorials/kotlin-for-py/generics.html

--- Covariance ---
- "T and supertypes"
- Generic<Subtype> treated as Generic<Supertype>
- "move up of type tree"
- keyword: out

--- Contravariance ---
- "T and subtypes"
- Generic<Supertype> treated as Generic<Subtype>
- "move down of type tree"
- keyword: in

--- Declaration ---
- class declaration
-- out T --
- is Covariance
- in (public) function methods only when in result (no input param)

-- in T --
- is Contravariance
- used in context of parameters only (no returns)
- widen to subtypes of T, as some kind of generic library

--- Site ---
- only in functions
- type projections
- project parameter using out or in
- in translates to List<? extends Car>
- out translates to List<? supper Car>
