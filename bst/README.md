# 📌 **Binary Search Tree (BST) — Complete Notes**

## ⭐ 1. What is a BST?

A Binary Tree where every node obeys this rule:

```
left subtree values  < node.val < right subtree values
```

This rule must hold **for every node**, not just children.

### Why it matters?

It lets you search in **O(log n)** (if tree is balanced).
Worst case becomes **O(n)** when the tree becomes a sad linked list.

---

## ⭐ 2. Basic BST Operations

### **Search**

* If target < root → go left
* If target > root → go right
* Else return root

### **Insert**

Same logic as search, but create a new node when you reach null.

### **Min & Max**

* **Min** → go extreme left
* **Max** → go extreme right

---

## ⭐ 3. BST Traversals

### **Inorder Traversal = Sorted Order**

This is the single most important fact in all BST problems.

```
Left → Root → Right
```

### Preorder / Postorder

Same definitions as normal trees.

---

## ⭐ 4. BST Validity Check (isValidBST)

Use **ranges**:

```
root ∈ (min, max)
left subtree ∈ (min, root.val)
right subtree ∈ (root.val, max)
```

This avoids stupid errors that simple child-comparison falls for.

---

## ⭐ 5. Floor & Ceil in BST

### **Floor (≤ target and closest)**

* If root.val == val → root
* If root.val > val → go left
* If root.val < val → store root, go right

### **Ceil (≥ target and closest)**

* If root.val == val → root
* If root.val < val → go right
* If root.val > val → store root, go left

---

## ⭐ 6. Delete Node in BST

3 cases:

### **Case 1: Leaf**

Return null.

### **Case 2: One child**

Return child.

### **Case 3: Two children**

Replace node with **inorder successor**, then delete successor.

Successor = leftmost in right subtree.

---

## ⭐ 7. Lowest Common Ancestor in BST (LCA)

Beautifully simple because of the BST property:

```
if p.val < root.val && q.val < root.val → go left
if p.val > root.val && q.val > root.val → go right
else root is the answer
```

---

## ⭐ 8. k-th Smallest & k-th Largest

### **k-th Smallest**

Inorder traversal → pick k-th.

### **Optimal**

Use iterative inorder to avoid building array.

---

## ⭐ 9. Successor & Predecessor (General BST)

### **Successor**

Next greater value.

Case 1: Node has right subtree
→ successor = leftmost of right subtree

Case 2: No right subtree
→ successor = lowest ancestor where you took a left turn

### **Predecessor**

Same logic reversed.

---

## ⭐ 10. Build Balanced BST

### From **sorted array**

Pick mid → recursive left/right builds.

### From **sorted list**

Use slow-fast to find mid and divide list with boundaries.

---

## ⭐ 11. Convert BST to Sorted List

Inorder traversal is enough.

---

## ⭐ 12. Morris Inorder Traversal (O(1) space)

Idea:

* Create temporary right links to revisit nodes.
* Move without stack or recursion.
* Break temporary links after use.

Good to know, rarely used in interviews unless they want to flex.

---

## ⭐ 13. BST Patterns You Must Recognize

### 🟦 **Pattern 1: “Find next/previous value”**

Use successor/predecessor logic.

### 🟦 Pattern 2: “Sorted output from BST”

→ Inorder

### 🟦 Pattern 3: “Find something using the BST property”

→ Move left/right based on comparison

### 🟦 Pattern 4: “Need balanced BST”

→ Mid-based divide and conquer

### 🟦 Pattern 5: “k-th something”

→ Inorder + counter

### 🟦 Pattern 6: “Check validity”

→ Min/max range propagation

---

## ⭐ 14. When to Use BST in Problems?

When problem involves:

* **“find next greater/smaller”**
* **“rank” or k-th smallest/largest**
* **“keys in range [a, b]”**
* **“dynamic sorted data”**
  (insert/search/delete repeatedly)
* **“design data structure with fast search”**

---

## ⭐ 15. Key Time Complexities

| Operation                     | Average         | Worst           |
| ----------------------------- | --------------- | --------------- |
| Search                        | O(log n)        | O(n)            |
| Insert                        | O(log n)        | O(n)            |
| Delete                        | O(log n)        | O(n)            |
| Balanced Tree (AVL/Red-Black) | Always O(log n) | Always O(log n) |




```
Common Interview Mistakes:
1) Only comparing parent-child instead of using ranges → wrong.
2) Forgetting successor/predecessor logic.
3) Two-child deletion confusion.
4) Forgetting inorder = sorted.
5) Not using BST property during LCA.
```

