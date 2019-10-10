## O Notation
**Different steps get added**  
Runtime O(a + b)
```
func(a, b){   
    for(elem : a){
        print elem // O(a) 
    }
    
    for(elem : b){
        print elem // O(b)
    }
}
```
**Drop constants: Loop same array: O(n + n), O(2n)**  
Runtime O(n)
```
func(a){
    for(elem : a){
        print elem // O(a)
    }
    for(elem : a){
        print elem // O(a)
    }
}
```
**Different inputs, different variables**  
Runtime: O(a*b)
```
func(a, b){
    for(elA : a){
        for(elB : b){
            print(elA, elB)
        }
    }
}
``` 
**Drop non-dominate terms**
O(a2) <= O(a + a2) <= O(a2 + a2)  
Runtime O(a2)
```
func(a){
    for(elem : a){
        print elem // O(a)
    }
    for(elemA : a){
        for(elemB : a){
             print (elemA, elemB) // O(a2)
        }
    }
}
```

