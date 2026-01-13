# Sliding Window – Code Cheatsheet (Java)

This README contains **ready-to-use templates** for all common sliding window patterns. Copy-paste friendly. Minimal thinking required.

---

## 1. Fixed Size Sliding Window

### Use when

* Subarray / substring size = `k`
* Sum / average / max / min over size `k`

### Template

```java
int left = 0;
int windowSum = 0;
int ans = Integer.MIN_VALUE;

// build first k-1 window
for (int i = 0; i < k - 1; i++) {
    windowSum += arr[i];
}

for (int right = k - 1; right < arr.length; right++) {
    windowSum += arr[right];        // expand
    ans = Math.max(ans, windowSum); // compute
    windowSum -= arr[left];         // shrink
    left++;
}
```

---

## 2. Variable Size Sliding Window (Validity Based)

### Use when

* Longest / shortest subarray or substring
* Constraint depends on window content

### Universal Template

```java
int left = 0;

for (int right = 0; right < n; right++) {
    // add arr[right] to window

    while (window is invalid) {
        // remove arr[left] from window
        left++;
    }

    // update answer using (right - left + 1)
}
```

---

## 3. Sliding Window with Frequency Array (Characters)

### ASCII Characters (most problems)

```java
int[] freq = new int[128];
```

### Uppercase letters only ('A'–'Z')

```java
int[] freq = new int[26];
int index = ch - 'A';
```

### Lowercase letters only ('a'–'z')

```java
int[] freq = new int[26];
int index = ch - 'a';
```

---

## 4. Longest Substring Without Repeating Characters

### Condition

* Window invalid if `freq[ch] > 1`

### Code

```java
int left = 0, maxLen = 0;
int[] freq = new int[128];

for (int right = 0; right < s.length(); right++) {
    char ch = s.charAt(right);
    freq[ch]++;

    while (freq[ch] > 1) {
        freq[s.charAt(left)]--;
        left++;
    }

    maxLen = Math.max(maxLen, right - left + 1);
}
```

---

## 5. Longest Repeating Character Replacement

### Key Formula

```
replacementsNeeded = windowSize - maxFrequency
```

### Rule

* Shrink when `replacementsNeeded > k`
* **Do NOT decrease maxFrequency when shrinking**

### Code

```java
int left = 0, maxLen = 0, maxFreq = 0;
int[] freq = new int[26];

for (int right = 0; right < s.length(); right++) {
    int idx = s.charAt(right) - 'A';
    freq[idx]++;
    maxFreq = Math.max(maxFreq, freq[idx]);

    while ((right - left + 1) - maxFreq > k) {
        freq[s.charAt(left) - 'A']--;
        left++;
    }

    maxLen = Math.max(maxLen, right - left + 1);
}
```

---

## 6. Why Sliding Window is O(n)

* `right` moves forward once
* `left` moves forward once
* No pointer moves backward

Total operations ≤ `2n`

---

## 7. When NOT to Use Sliding Window

❌ Subsequences (not contiguous)
❌ Permutations / combinations
❌ Non-monotonic constraints
❌ Backtracking-style problems

---

## 8. One-Line Mental Rule

> Expand with `right`, shrink with `left`, validity decides everything.

---

Use this README as a **pattern reference**, not something to memorize.
