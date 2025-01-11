# Cheatsheet

## String Methods

### 1. Creation & Initialization
```java
String str = "Hello";
String str2 = new String("World");
```


2. Basic Operations

| Method                      | Description                                      | Example                        |
|-----------------------------|--------------------------------------------------|--------------------------------|
| `str.length()`              | Returns the length of the string.                | `"abc".length() -> 3`          |
| `str.charAt(index)`         | Returns the character at the specified index.    | `"abc".charAt(1) -> 'b'`       |
| `str.equals(otherString)`   | Compares two strings for equality.               | `"abc".equals("ABC") -> false` |
| `str.equalsIgnoreCase(otherString)` | Compares two strings ignoring case differences. | `"abc".equalsIgnoreCase("ABC") -> true` |
| `str.isEmpty()`             | Checks if the string is empty.                   | `"".isEmpty() -> true`         |
| `str.toLowerCase()`         | Converts all characters to lowercase.            | `"HeLLo".toLowerCase() -> "hello"` |
| `str.toUpperCase()`         | Converts all characters to uppercase.            | `"HeLLo".toUpperCase() -> "HELLO"` |
| `str.trim()`                | Removes leading and trailing whitespaces.        | `"  abc  ".trim() -> "abc"`    |




3. Substring Operations

| Method                    | Description                          | Example                        |
|---------------------------|--------------------------------------|--------------------------------|
| `str.substring(start)`    | Returns substring from start to end. | `"abcdef".substring(2) -> "cdef"` |
| `str.substring(start, end)` | Returns substring from start to end-1. | `"abcdef".substring(2, 4) -> "cd"` |

4. Searching in Strings


Method                      | Description                                      | Example                        |
|-----------------------------|--------------------------------------------------|--------------------------------|
| `str.indexOf(char)`         | Returns the index of the first occurrence of the char. | `"hello".indexOf('l') -> 2`    |
| `str.indexOf(char, fromIndex)` | Searches from fromIndex.                        | `"hello".indexOf('l', 3) -> 3` |
| `str.lastIndexOf(char)`     | Returns the index of the last occurrence of the char. | `"hello".lastIndexOf('l') -> 3` |
| `str.contains(sequence)`    | Checks if the string contains the specified sequence. | `"hello".contains("ell") -> true` |
| `str.startsWith(prefix)`    | Checks if the string starts with the given prefix. | `"hello".startsWith("he") -> true` |
| `str.endsWith(suffix)`      | Checks if the string ends with the given suffix. | `"hello".e

5. Replace & Split

| Method                      | Description                                      | Example                        |
|-----------------------------|--------------------------------------------------|--------------------------------|
| `str.replace(oldChar, newChar)` | Replaces all occurrences of oldChar with newChar. | `"abab".replace('a', 'z') -> "zbzb"` |
| `str.replaceAll(regex, replacement)` | Replaces all matches of regex with replacement. | `"abc123".replaceAll("\\d", "*") -> "abc***"` |
| `str.split(regex)`          | Splits the string around matches of the regex.   | `"a,b,c".split(",") -> ["a", "b", "c"]` |
6. Comparison

| Method                          | Description                                | Example                          |
|---------------------------------|--------------------------------------------|----------------------------------|
| `str.compareTo(otherString)`    | Compares strings lexicographically.        | `"abc".compareTo("abd") -> -1`   |
| `str.compareToIgnoreCase(otherString)` | Same as compareTo but ignores case. | `"abc".compareToIgnoreCase("ABC") -> 0` |

StringBuilder Methods

1. Basic Operations

Method	Description	Example
sb.length()	Returns the length of the string.	"abc".length() -> 3
sb.charAt(index)	Returns the character at the specified index.	sb.charAt(1) -> 'b'


2. Modifying Strings

| Method                  | Description                                      | Example                        |
|-------------------------|--------------------------------------------------|--------------------------------|
| `sb.append(str)`        | Appends the string to the builder.               | `sb.append("def") -> "abcdef"` |
| `sb.insert(offset, str)`| Inserts the string at the specified offset.      | `sb.insert(2, "xyz") -> "abxyzc"` |
| `sb.replace(start, end, str)` | Replaces characters from start to end-1 with str. | `sb.replace(1, 3, "xy") -> "axy"` |
| `sb.delete(start, end)` | Deletes characters from start to end-1.          | `sb.delete(1, 3) -> "ac"`      |
| `sb.reverse()`          | Reverses the characters in the builder.          | `sb.reverse() -> "cba"`        |



3. Searching

| Method            | Description                                      | Example                        |
|-------------------|--------------------------------------------------|--------------------------------|
| `sb.indexOf(str)` | Returns the index of the first occurrence of the string. | `sb.indexOf("bc") -> 1`        |
| `sb.lastIndexOf(str)` | Returns the index of the last occurrence of the string. | `sb.lastIndexOf("b") -> 1`     |

4. Conversion

 | Method                | Description                                | Example                |
|-----------------------|--------------------------------------------|------------------------|
| `sb.toString()`       | Converts the StringBuilder to a String.    | `sb.toString() -> "abc"` |
| `sb.substring(start, end)` | Extracts a substring (similar to String). | `sb.substring(1, 3) -> "bc"` |